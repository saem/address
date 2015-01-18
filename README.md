# address
Glorified address book

# notes
## connecting to local postgres instance
```
psql address -h 127.0.0.1 -d address
```

# todos
* [Create relationship tables between entities and emails/phones/address]()
** Do we deal with emails with emails
* Figure out the axes of various properties, actor/non-actor, fundamental entity type, intrinsic vs extrinsic
** Emails: We don't know who clicked on the unsubscribe link -> extrinsic or system, actor or non-actor??
* Actor: Entities, Email?
* Non-Actor: Person, Email?, Address, Phone Number