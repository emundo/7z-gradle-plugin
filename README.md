# 7z Gradle Plugin

A Gradle Plugin providing a task to extract 7z archives.

## Getting Started

```groovy
buildscript {
    repositories {
        maven {
            url "https://plugins.gradle.org/m2/"
        }
    }
    dependencies {
        classpath "gradle.plugin.eu.emundo:7z-gradle-plugin:1.0.0"
    }
}

apply plugin: "eu.emundo.sevenz"

task extractArchive(type: UnSevenZ) {
    sourceFile = file("path/to/archive.7z")
    outputDir = file("path/to/folder")
}
```

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/emundo/7z-gradle-plugin/releases).

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
