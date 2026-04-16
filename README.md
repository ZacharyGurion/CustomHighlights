# Custom Highlights

An IntelliJ plugin that lets you assign distinct colors to three keyword categories - **control flow**, **type/declaration**, and **access/visibility** - across a wide range of languages.

## Features

Color each keyword category independently via **Settings > Editor > Color Scheme > Custom Highlights**:

| Category | Examples |
|---|---|
| Control Flow | `if`, `else`, `for`, `while`, `return`, `throw`, `try`, `catch`, … |
| Type / Declaration | `void`, `int`, `var`, `class`, `def`, `fun`, … |
| Access / Visibility | `public`, `private`, `protected`, `internal`, … |

### Supported languages

Java, Kotlin, Python, JavaScript, TypeScript, Go, Rust, C, C++, C#, Groovy, Scala, PHP, Dart, SQL

Language support is opt-in at runtime - annotators for languages whose plugins are not installed are silently skipped.

## Configuration

1. Open **Settings > Editor > Color Scheme > Custom Highlights**
2. Select a keyword category
3. Set your desired foreground color and font style
4. Click **OK** - highlighting applies immediately across all open files

## Building from source

```
./gradlew buildPlugin
```

The plugin ZIP will be written to `build/distributions/`. Install it via **Settings > Plugins > Install Plugin from Disk**.

To run a sandboxed IDE instance with the plugin loaded:

```
./gradlew runIde
```

## Requirements

- IntelliJ IDEA 2025.3 or later (build 253+)
