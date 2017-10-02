# Java 9 Introduction

## Module
> A Module has a name, it groups related code and is self-contained

```java
// module-info.java
module java.sql {
    exports java.sql;
    exports javax.sql;
    exports javax.transaction.xa;
    
    requires java.logging;
    requires java.xml;
}
```

1. `java --list-modules` to list all jdk modules
2. `java --describe-module java.sql` to inspect module definition