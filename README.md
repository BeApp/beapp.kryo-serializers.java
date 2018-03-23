# Introduction

This library provides some extras serializers for [Kryo](https://github.com/EsotericSoftware/kryo) project, which is used by [SnappyDB](https://github.com/nhachicha/SnappyDB).

# Installation

Add Beapp's repository in your project's repositories list, then add the dependency.

```groovy
repositories {
    jcenter()
    // ...
    maven { url 'http://repository.beapp.fr/libs-release-local' }
}

dependencies {
    compile 'fr.beapp.kryo:kryo-serializers:<version>'
}
```