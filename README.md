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

# Usage

You just have to register the needed serializers in a `Kryo` instance like this :

```
kryo.register(Duration.class, new ThreeTenDurationSerializer());
```

You can register all serializers at once by using :

```
ThreeTenSerializers.registerAllSerializers(kryo);
```
