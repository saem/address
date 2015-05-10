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
We started work on a persister monad to chain operations. We are trying to use the same persister for all operations, but realised
that - the way we have our code structured right now - when the persister orders the transactions it might screw up order of operations
for inserts and updates on the same entities.
1) Create a persister applicative(?).
2) Provide phones, emails, addresses API
3) Write address book command processor.

# research
1) how to hypermedia JSON?
