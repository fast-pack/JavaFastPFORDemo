## JavaFastPFOR demo

This small Maven project shows how to use JavaFastPFOR (from the fast-pack/JavaFastPFOR repository) to compress and uncompress an int[] using `FastPFOR128`.

## Prerequisites

- JDK 21 installed and available on your PATH
- Maven 3.6+ (tested with Maven 3.9)

Verify with:

```bash
mvn -v
java -version
```

## Maven demo

We added the JitPack repository to our `pom.xml` and use the exact coordinates published for this project. The project exposes the artifact as `JavaFastPFOR` with a tag-style version. For example:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.fast-pack</groupId>
    <artifactId>JavaFastPFOR</artifactId>
    <version>JavaFastPFOR-0.3.1</version>
</dependency>
```

Note: coordinates are case-sensitive. Using `JavaFastPFor` (different case) or a short `0.3.1` version may fail if that exact artifact/version was not published.

### Build

Download dependencies and compile:

```bash
mvn package
```

### Run the demo

Run the `Main` class included in this project:

```bash
mvn exec:java -Dexec.mainClass=org.example.Main
```

The demo compresses an array of length 9984, then uncompresses it and prints a small verification summary. Example output:

```
N=9984 compressedSizeWords=XXX mismatches=0
first 20 original: [0, 0, 0, ...]
first 20 recovered: [0, 0, 0, ...]
```


## Gradle

This project also includes a Gradle build. 

```

repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.fast-pack:JavaFastPFOR:JavaFastPFOR-0.3.1'
}
```


It uses the JitPack repository and the same dependency coordinates.

Build with Gradle:

```bash
./gradlew clean build
```

Run the demo with Gradle:

```bash
./gradlew run
```

If you don't have the wrapper, you can use a local Gradle installation:

```bash
gradle clean build
gradle run
```
