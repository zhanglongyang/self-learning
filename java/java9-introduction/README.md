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

### Migration will fail if
1. you use JDK types that have been encapsulated
    ```bash
    java --illegal-access=permit Main
    ```
    ```bash
    javac --add-exports java.base/sun.security.x509=ALL-UNAMED Main.java
    java --add-exports java.base/sun.security.x509=ALL-UNAMED Main
    ```
2. you use types from non-default Java modules
    ```
    javac --add-module javax.xml.bind Main.java
    java --add-module javax.xml.bind Main
    ```

### Using `Jdeps`
```bash
jdeps -jdkinternals Main.class
```