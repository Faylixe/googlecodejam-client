# Google Code Jam - Client API

[![Build Status](https://travis-ci.org/Faylixe/googlecodejam-client.svg)](https://travis-ci.org/Faylixe/googlecodejam-client) [![Coverage Status](https://coveralls.io/repos/Faylixe/googlecodejam-client/badge.svg?branch=master&service=github)](https://coveralls.io/github/Faylixe/googlecodejam-client?branch=master) [![Codacy Badge](https://api.codacy.com/project/badge/grade/a69abad9e6d14c81b62b9deeb99b8e7d)](https://www.codacy.com/app/Faylixe/googlecodejam-client) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/fr.faylixe/googlecodejam-client/badge.svg)](https://maven-badges.herokuapp.com/maven-central/fr.faylixe/googlecodejam-client) [![Join the chat at https://gitter.im/Faylixe/googlecodejam-client](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/Faylixe/googlecodejam-client?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Java client API for Google Code Jam contest. This API is implemented with, and for JDK8 and newer ([changelog](https://github.com/Faylixe/googlecodejam-client/blob/master/CHANGELOG.md)).

Please check the [command line application](https://github.com/Faylixe/googlecodejam-cli) for an exemple of application.

## Disclaimer

Please note that this client is not provided by Google. Any responsability is declined if a bug occurs when you are using it in a real contest condition.

## Maven dependency

Following dependency could be added to your *POM.xml* if you want to use the client API into your project.

```xml
<dependency>
    <groupId>fr.faylixe</groupId>
    <artifactId>googlecodejam-client</artifactId>
    <version>1.4.11</version>
</dependency>
```
The API entry point is the [CodeJamSession](https://github.com/Faylixe/googlecodejam-client/tree/master/javadoc/fr/faylixe/googlecodejam/client/CodeJamSession.md) class, which could be instantiated as following :

```java
// Initializes required HTTPRequestExecutor.
final HttpRequestExecutor executor = HttpRequestExecutor.create(CODEJAM_HOSTNAME, SACSID_COOKIE_VALUE);
// Retrieves Round.
final Round round = ...;
// Creates session.
final CodeJamSession session = CodeJamSession.createSession(executor, round);
```

The session could be then used to retrieve contest information, problem description and analysis, download input file
as submit solution as well. You can check the [javadoc](https://github.com/Faylixe/googlecodejam-client/tree/master/javadoc/fr/faylixe/googlecodejam/client) to get more informations.

## Contributors

Contribution are welcome, don't hesitate to submit a pull request to improve this tools, here is the list of people who contributed :

- [a-layouni](https://github.com/a-layouni)