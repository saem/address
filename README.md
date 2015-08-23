# Address
Glorified address book

# Abandoned
This project has been abandoned. We're providing the source code for people such that they can learn from what we have
attempted. Initially, the idea was to have a schema that would be append only, such that all writes would be modelled as
inserts. This would allow users of this design to be able to easily support undo, downstream complex event processing, 
etc... It went through many iterations, and a number of lessons were learned along the way. We ultimately stopped 
pursuing this as we learned that managing constraints like uniqueness (only one user can hold a user name at a given 
point in time, etc...) were incredibly difficult to maintain without breaking the singular append only schema design.
This along with a number of other realizations led us to believe that we were building a distributed database, with the
need for distributed transactions and all sorts of other machinery that was vastly complicating what should have been, 
based on our initial expectations, a simple architecture and design.

## Lessons Learned

* Persister: this piece is particularly interesting as all database operations are expressed as abstract operations, and
  are interpreted by the persister which is the only thing that actually interacts with the underlying database. This 
  incredibly clean separation allowed us to do many interesting things, like batching, query re-ordering and all sorts 
  of optimizations. In the future we see applicability of a system such as this in order to reduce exposure of database
  physical schema, from the logical view we want presented elsewhere. Though, it was designed prior to learning about 
  Object Algebras[1], it might be considered within the family of that work.
* Append only schema design: There are a number of interesting lessons in the append only schema design:
  * Entity System: The entity system directly models the Entity concept from Domain Driven Design [2], which then further
    refines the concept. Over the course of development we realized that there are two types of Entities, intrinsic and 
    extrinsic. Extrinsic entities are those that exist in the real world and are simply being modelled/simulated within 
    the system for book keeping purposes -- that is to the say if the system was deleted whole-sale, the entities would
    still exist. Intrinsic, ones are like Users, they represent a facet of an extrinsic entity, but themselves, are 
    entirely a construct of the systems design. This is relevant when modelling deletes, deleting specific facets,
    intrinsic components is a perfectly natural thing to do, a person is no longer a user of the system. But deleting
    extrinsic entities is a rather unnatural operation, if one was to delete a person, it would be akin to denying the 
    existence of said person.
  * Self-describing System: The system is represented as a single row in a dedicated table, this table is unified under 
    the entity system, users and system are unified under the concept of actor (actors take actions), and wherever a 
    reference to an actor was required, actors were used. This meant, that the system taking an action upon itself is
    fully describable within the system. So, as a first event of the system creating an administrative user is cleanly
    modelled. This is illustrated most clearly in the events table, where we store a log of all events, by definition 
    each event must have an actor that did it, this creates a chicken and egg problem where no users currently exist,
    so how can an event to make a user exist take place. Also, seeding the users table with a user isn't possible as
    we have no event to refer to. Having the system be self-describing and also being an actor, allows it to take the
    action of creating the user. This also means there is no need to create nullable foreign keys, as is often the case.
    Furthermore, the system can be aware of the version of code that it is running, database migrations that it might
    have run, etc...
  * Column per Table: Though this might be considered the height of inefficiency, the single value per table has a number
    of advantages that are worth considering, the biggest ones we'll highlight here. Many consider database schema 
    migrations to be one of the most painful undertakings, especially when involving large tables. This pain point is
    entirely alleviated as you can simply add new columns, or create new versions of existing columns as an O(1)
    operation. Additionally, only values that change require updates, all other columns are left untouched. Lastly,
    knowing the nature of a change (without diffing) is immediately known from projecting only the changes.

[1]: Object Algebras: https://www.cs.utexas.edu/~wcook/Drafts/2012/ecoop2012.pdf
[2]: Domain Driven Design: https://en.wikipedia.org/wiki/Domain-driven_design

# Licensing

If you wish to use any of the code here, please create an issue in regards to licensing, otherwise treat it as GPL3.

# Notes
## Connecting to Local Postgres Instance
```
psql -a -f bin/initial.sql
java -jar target/address-0.1.jar db migrate --dry-run dev.yml
psql address -h 127.0.0.1 -d address
mvn -Djdbc.url="jdbc:postgresql://localpg/address" jooq-codegen:generate -f pom.xml
mvn clean && mvn package && java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5001 -jar target/address-0.1.jar server dev.yml 
```

# ToDos
## Java Code
* Fix BenDB jOOQ bundle to allow for multiple connections
* Setup multiple DBs for ViewDB and LogDB
* New architecture:
    * Resource -> Reader|Writer (ViewDB, Command log side-effect) -> Persister|Provider (LogDB, DataStore side-effect) -> Report -> Response
    * Resource translates from HTTP Request to Command
    * Reader/Writer accepts Command and turns it into a Report
    * Reader/Writer side-effect the Event into a read/write, respectively
        * Reader uses a provider (materialized view access) to read the necessary data
        * Writer uses a persister to write to the event log
    * Report is translated by the Resource to a Response
* Write address book command processor
* Write resource

### Write Handling
```
http<request>                   -> resource
validate (http)                 -> resource
request                         -> resource/commander
command                         -> commander
validate (command, uniqueness)  -> commander
event                           -> commander/writer
event_log_write                 -> persister
response                        -> writer
http<response>                  -> resource
```

## Research
1) how to hypermedia JSON?

# Relationship Notes
* Relationships are an entity-like-thing (relationship_id, entity_id_a_min, entity_id_b_max)
* Relationship specialization tables can add metadata to the relationship, such as directionality
* Relationship fact tables can also add metadata to relationships, varying over time
