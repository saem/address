# Address
Glorified address book

# notes
## Connecting to Local Postgres Instance
```
psql -a -f bin/initial.sql
java -jar target/address-0.1.jar db migrate --dry-run dev.yml
psql address -h 127.0.0.1 -d address
mvn -Djdbc.url="jdbc:postgresql://localpg/address" jooq-codegen:generate -f pom.xml
mvn clean && mvn package && java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5001 -jar target/address-0.1.jar server dev.yml 
```

# ToDos
## Database
* Singularize tables (http://stackoverflow.com/a/5841297/68131)
* Fix phones, emails, and addresses, to deal with value types and only effect associations
* Relationships are an entity-like-thing (relationship_id, entity_id_a_min, entity_id_b_max)
* Relationship specialization tables can add metadata to the relationship, such as directionality
* Relationship fact tables can also add metadata to relationships, varying over time

## Java Code
* New architecture:
    * Resource -> Reader|Writer (Command log side-effect) -> Persister|Provider (DataStore side-effect) -> Report -> Response
    * Resource translates from HTTP Request to Command
    * Reader/Writer accepts Command and turns it into a Report
    * Reader/Writer side-effect the Event into a read/write, respectively
        * Reader uses a provider (materialized view access) to read the necessary data
        * Writer uses a persister to write to the event log
    * Report is translated by the Resource to a Response
* Write address book command processor
* Write resource

## Research
1) how to hypermedia JSON?
