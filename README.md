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

## Maven dependency (JitPack)

Add the JitPack repository to your `pom.xml` and use the exact coordinates published for this project. The project exposes the artifact as `JavaFastPFOR` with a tag-style version. For example:

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
    <version>JavaFastPFOR-0.3.0</version>
</dependency>
```

Note: coordinates are case-sensitive. Using `JavaFastPFor` (different case) or a short `0.3.0` version may fail if that exact artifact/version was not published.

## Build

Download dependencies and compile:

```bash
mvn -U package
```

If Maven cached a failed resolution you can clear the specific cached artifact and retry:

```bash
rm -rf ~/.m2/repository/com/github/fast-pack/JavaFastPFOR
mvn -U package
```

## Run the demo

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

## Troubleshooting

- "Could not find artifact ..." when building: check that the `artifactId` and `version` in your `pom.xml` exactly match what JitPack exposes (case-sensitive). Use the repository page `https://jitpack.io/#fast-pack/JavaFastPFOR` to inspect available versions/tags.
- If JitPack builds are failing for a tag, try using the exact commit hash or `master-SNAPSHOT` while debugging.
