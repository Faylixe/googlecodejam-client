# Google Code Jam - Client API

[![Build Status](https://travis-ci.org/Faylixe/googlecodejam-client.svg)](https://travis-ci.org/Faylixe/googlecodejam-client) [![Coverage Status](https://coveralls.io/repos/Faylixe/googlecodejam-client/badge.svg?branch=master&service=github)](https://coveralls.io/github/Faylixe/googlecodejam-client?branch=master) [![Codacy Badge](https://api.codacy.com/project/badge/grade/a69abad9e6d14c81b62b9deeb99b8e7d)](https://www.codacy.com/app/Faylixe/googlecodejam-client) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/fr.faylixe/googlecodejam-client/badge.svg)](https://maven-badges.herokuapp.com/maven-central/fr.faylixe/googlecodejam-client) [![Join the chat at https://gitter.im/Faylixe/googlecodejam-client](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/Faylixe/googlecodejam-client?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)


Java client API for Google Code Jam contest. This API is implemented with, and for JDK8 and prior ([changelog](https://github.com/Faylixe/googlecodejam-client/blob/master/CHANGELOG.md)).

[OSGi packaged version](https://github.com/Faylixe/googlecodejam-client-osgi) is also available.

* [Disclaimer](#disclaimer)
* [Maven dependency](#maven-dependency)
* [Command line application](#command-line-application)
  - [Installation](#installation)
  - [Initialization action](#initialization-action)
  - [Download action](#download-action)
  - [Submit action](#submit-action)
* [Jammy](#jammy)


## Disclaimer

Please note that this client is not provided by Google. Any responsability is declined if a bug occurs when you are using it in a real contest condition. This API is fully working in a practice context, but has never been tested in a real contest.

## Maven dependency

Following dependency could be added to your *POM.xml* if you want to use the client API into your project.

```xml
<dependency>
    <groupId>fr.faylixe</groupId>
    <artifactId>googlecodejam-client</artifactId>
    <version>1.2.7</version>
</dependency>
```
The API entry point is the [CodeJamSession](http://faylixe.fr/googlecodejam-client/apidocs/fr/faylixe/googlecodejam/client/CodeJamSession.html) class, which could be instantiated as following :

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

## Command line application

A command line application which consists in the client JAR and a running script is also available. Here is the usage description :

```bash
codejam action parameter
```

Where action belongs to the following option list :

* *--init*
* *--download*
* *--submit*

Please note that Firefox web browser is also required.

### Installation

You can install script and packaged version of client by running the following command :

```bash
wget -O - https://raw.githubusercontent.com/Faylixe/googlecodejam-client/master/scripts/install | bash
```

Once script has been executed, you can run the **codejam** command. Please note that installation script should be ran under root permission.

### Initialization action

This action does not take any parameters, and will open up a Firefox instance
in order to authenticate to Google services. Once Firefox is opened and the login page loaded,
please proceed to the authentication process, and when you will be logged and redirected
to the code jam home page, Firefox will be closed automatically.

```bash
codejam --init
```

Once logged you will be prompted to choose a contest and a round. Those will become contextual round and session
for the current directory you are running the script in, meaning that if you run another time the script with another
action, it will use the created contextual logged session and round.

### Download action

As it name suggests, the *download* action allows logged user to download an input file for a given problem.
If the contest is active, then it will trigger the submission timer depending of the input difficulty you have
choosen (usually 4 minutes for a *small* input, 8 for a *large* one).

The following exemple will download the *small* input file for the first problem.

```bash
codejam --download --problem A --inputtype small
```

If the download is successful, the name of the downloaded file will be printed, so it could be chained in a command workflow, for example :

```bash
cat < `codejam --download --problem A --inputtype small` | python A.py
```
### Submit action

Once input file is downloaded, and algorithm solved all test cases, *submit* action could be used in order
to send either the output file as the source file of your algorithm as well.

```bash
codejam --submit --problem A --inputtype small --output path/to/output --sourcefile path/to/sourcefile
```

## Jammy

Want more than a command line application ? Take a look at the [Jammy](http://faylixe.fr/jammy) project, which provides a dedicated development perspective
in Eclipse IDE.
