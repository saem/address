# address
Glorified address book

# notes
## connecting to local postgres instance
```
psql -a -f bin/initial.sql
java -jar target/address-0.1.jar db migrate --dry-run dev.yml
psql address -h 127.0.0.1 -d address
mvn -Djdbc.url="jdbc:postgresql://localpg/address" jooq-codegen:generate -f pom.xml
mvn clean && mvn package && java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5001 -jar target/address-0.1.jar server dev.yml 
```

# todos
1) Migrate to an operations based API
2) Provide phones, emails, addresses API
3) Write address book command processor

# research
1) how to hypermedia JSON?

# Currently
/person/created
{ actorId, first, last, phones: [...] } -> db_operations* -> inserts*

# Possibility
/events
```json
{"event_operations": [
    {"@operation": "person_created", "@ref":"123" first, last},
    {"@operation": "phone_created", number, extension, "associated_to":"@ref(123)"}
]
} -> db_operations* -> inserts*
```