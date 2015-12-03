# Google Code Jam - Client API

[![Build Status](https://travis-ci.org/Faylixe/googlecodejam-client.svg)](https://travis-ci.org/Faylixe/googlecodejam-client) [![Coverage Status](https://coveralls.io/repos/Faylixe/googlecodejam-client/badge.svg?branch=master&service=github)](https://coveralls.io/github/Faylixe/googlecodejam-client?branch=master) [![Codacy Badge](https://api.codacy.com/project/badge/grade/a69abad9e6d14c81b62b9deeb99b8e7d)](https://www.codacy.com/app/Faylixe/googlecodejam-client) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/fr.faylixe/googlecodejam-client/badge.svg)](https://maven-badges.herokuapp.com/maven-central/fr.faylixe/googlecodejam-client)

Java client API for Google Code Jam contest.

## Maven dependencies

Following dependency could be added to your *POM.xml* if you want to use the client API into your project.

```xml
<dependency>
    <groupId>fr.faylixe</groupId>
    <artifactId>googlecodejam-client</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Command line application

A command line application which consists in the client JAR and a running script is also available. Here is the usage description :

```
usage: codejamclient.sh init|download|submit parameter
 -d,--download           Downloads an input file for a given problem and
                         target dataset.
 -f,--sourcefile <arg>   Source file to submit
 -i,--init               Initializes code jam context by logging user in,
                         and selects an active contest and round.
 -o,--output <arg>       Output file to submit
 -p,--problem <arg>      Target problem for downloading or submitting
 -s,--submit             Submits an output file as solution source as well
                         for a given problem and target dataset.
 -t,--inputtype <arg>    Input type (in general, small or large)
```
