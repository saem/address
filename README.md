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
0) Finish Persister, such that it can add various operations, and save things
1) Write to tables_affected column in the events table.
2) Rework the resource to post events instead of users.
3) Write address book command processor.
