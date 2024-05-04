jnfp
===

[![Maven Central](https://img.shields.io/maven-central/v/com.io7m.jnfp/com.io7m.jnfp.svg?style=flat-square)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.io7m.jnfp%22)
[![Maven Central (snapshot)](https://img.shields.io/nexus/s/com.io7m.jnfp/com.io7m.jnfp?server=https%3A%2F%2Fs01.oss.sonatype.org&style=flat-square)](https://s01.oss.sonatype.org/content/repositories/snapshots/com/io7m/jnfp/)
[![Codecov](https://img.shields.io/codecov/c/github/io7m-com/jnfp.svg?style=flat-square)](https://codecov.io/gh/io7m-com/jnfp)

![com.io7m.jnfp](./src/site/resources/jnfp.jpg?raw=true)

| JVM | Platform | Status |
|-----|----------|--------|
| OpenJDK (Temurin) Current | Linux | [![Build (OpenJDK (Temurin) Current, Linux)](https://img.shields.io/github/actions/workflow/status/io7m-com/jnfp/main.linux.temurin.current.yml)](https://www.github.com/io7m-com/jnfp/actions?query=workflow%3Amain.linux.temurin.current)|
| OpenJDK (Temurin) LTS | Linux | [![Build (OpenJDK (Temurin) LTS, Linux)](https://img.shields.io/github/actions/workflow/status/io7m-com/jnfp/main.linux.temurin.lts.yml)](https://www.github.com/io7m-com/jnfp/actions?query=workflow%3Amain.linux.temurin.lts)|
| OpenJDK (Temurin) Current | Windows | [![Build (OpenJDK (Temurin) Current, Windows)](https://img.shields.io/github/actions/workflow/status/io7m-com/jnfp/main.windows.temurin.current.yml)](https://www.github.com/io7m-com/jnfp/actions?query=workflow%3Amain.windows.temurin.current)|
| OpenJDK (Temurin) LTS | Windows | [![Build (OpenJDK (Temurin) LTS, Windows)](https://img.shields.io/github/actions/workflow/status/io7m-com/jnfp/main.windows.temurin.lts.yml)](https://www.github.com/io7m-com/jnfp/actions?query=workflow%3Amain.windows.temurin.lts)|

## jnfp

Java functions to convert between floating point and _normalized fixed point_
values.

## Features

* Conversion between unsigned normalized fixed-point numbers and floating point numbers.
* Conversion between signed normalized fixed-point numbers and floating point numbers.
* High coverage test suite.
* [OSGi-ready](https://www.osgi.org/)
* [JPMS-ready](https://en.wikipedia.org/wiki/Java_Platform_Module_System)
* ISC license.

## Usage

Convert a floating point value to its 32-bit unsigned normalized fixed point
representation:

```
var r = NFPUnsignedFloatLong.toUnsignedNormalized(0.25, 32);
```

Convert a 32-bit unsigned normalized fixed point value to its floating point
representation:

```
var s = NFPUnsignedFloatLong.fromUnsignedNormalized(r, 32);
```

Classes exist for signed, unsigned, `int`, `long`, `float`, and `double`
specializations.

