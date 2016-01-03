#ContestInfo

Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>
> [Object](../../../../java/lang/Object.md) > [ContestInfo](ContestInfo.md)

<p>POJO that aims to be bind to the <tt>/ContestInfo</tt>
 request, using Gson API.</p>

##Summary


| Type | Method |
| --- | --- | --- |
| [ContestInfo](ContestInfo.md) | get |
| [Problem](Problem.md) | getProblem |
| [List](../../../../java/util/List.md) | getProblems |
| **int** | getVersion |
| **boolean** | hasAnalysis |
| **void** | validateObject |

##Methods

###get


Static factory method that builds a {@link ContestInfo} instance
 from the given <tt>round</tt> using a <tt>/ContestInfo</tt>
 request from the round dashboard.
#####Parameter(s)


* executor
* round

#####Return


#####Throws

* [IOException](../../../../java/io/IOException.md) IF any error occurs while executing request.

###getProblem


Shortcut method for reducing law of Demeters issues.
#####Parameter(s)


* index

#####Return


#####Throws

* [ArrayIndexOutOfBoundsException](../../../../java/lang/ArrayIndexOutOfBoundsException.md) If the given index is not valid.

###getProblems


Returns {@link Problem} instance associated
 to this contest.
#####Return



###getVersion


Getter for the problems version.
#####Return



###hasAnalysis


Indicates if this contests already have
 analysis committed or not.
#####Return



###validateObject


{@inheritDoc}
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)