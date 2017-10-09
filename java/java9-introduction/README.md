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

## Language and Library improvements

1. Collection Factory methods
    ```
    List<Integer> ints = List.of(1, 2, 3)

    Set<String> abc = Set.of("a", "b", "c")

    Map<String, Integer> kvs = Map.of("k1", 1, "k2", 2)
    ```
2. Stream API
    - Added methods
    ```
    Stream<T> takeWhile(Predicate<? super T> predicate)

    Stream<T> dropWhile(Predicate<? super T> predicate)

    static Stream<T> ofNullable(T t)

    static Stream<T> iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)
    ```
3. Additions to Optional
    - added method
    ```
    void ifPresentOrElse(Consumer<T> action, Runnable emptyAction)

    Optinal<T> or(Supplier<Optional<T>> supplier)

    Stream<T> stream()
    ```
4. Try-with-resources
    ```
    try (FileInputStream fis = new FileInputStream("filder/file.name")) {
        fis.read();
    }
    ```