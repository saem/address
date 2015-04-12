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
1) Figure out how to handle updates/deletes to non-existent entities (if ID doesn't exist return a 404, catch foreign key exception and convert to 404).
2) JSON-LD-ify the API (references: json-ld.org, www.w3.org/TR/json-ld/, and github.com/jsonld-java/jsonld-java)
3) Redo Relationship schema to be generic related facts, update phones, emails, and addresses.
4) Provide phones, emails, addresses API
4) Write address book command processor.
