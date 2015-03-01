# address
Glorified address book

# notes
## connecting to local postgres instance
```
psql -a -f bin/initial.sql
java -jar target/address-0.1.jar db migrate --dry-run dev.yml
psql address -h 127.0.0.1 -d address
mvn -Djdbc.url="jdbc:postgresql://localpg/address" jooq-codegen:generate -f pom.xml
mvn clean && mvn package && java -jar target/address-0.1.jar server dev.yml
```

# todos
1) Rework code to deal with single value tables.
2) Write address book command processor.


1) Separate deletes into DeletedEntityFacts Table, extrinsic entities share a single delete table. Traits/intrinsic entities(ie: User) each have their own delete table.
| is_deleted(type=boolean,default=false) | is_disabled(type=boolean, default=false) | sequence | entity_id | encrypted(type=bytea,default="") |