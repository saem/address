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
1) Make persisters self-burning, so you can't repeatedly persist the same operations over and over
2) Unify The UserEventWriteRepresentation and PersonEventWriteRepresentation as an EntityEventWriteRepresentation 
3) Provide phones, emails, addresses API
4) Write address book command processor

# research
1) how to hypermedia JSON?
