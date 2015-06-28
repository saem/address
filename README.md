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
    a) Make sure the OperationAlgebra still makes sense
    b) Sketch some JSON of what the operations will look like
2) Provide phones, emails, addresses API
3) Write address book command processor

# research
1) how to hypermedia JSON?
