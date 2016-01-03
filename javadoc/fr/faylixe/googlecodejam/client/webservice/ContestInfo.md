#ContestInfo

Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>
[Object](../../../../java/langObject.md) > [ContestInfo](ContestInfo.md)

<p>POJO that aims to be bind to the <tt>/ContestInfo</tt>
 request, using Gson API.</p>

###Summary


| Type | Method |
| --- | --- | --- |
| [ContestInfo](ContestInfo.md) | get |
| [Problem](Problem.md) | getProblem |
| [List](../../../../java/utilList.md) | getProblems |
| **int** | getVersion |
| **boolean** | hasAnalysis |
| **void** | validateObject |

###Methods

####get


Static factory method that builds a {@link ContestInfo} instance
 from the given <tt>round</tt> using a <tt>/ContestInfo</tt>
 request from the round dashboard.
####getProblem


Shortcut method for reducing law of Demeters issues.
####getProblems


Returns {@link Problem} instance associated
 to this contest.
####getVersion


Getter for the problems version.
####hasAnalysis


Indicates if this contests already have
 analysis committed or not.
####validateObject


{@inheritDoc}
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)