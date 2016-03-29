#Class ContestInfo
Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>

> *java.lang.Object* > [ContestInfo](ContestInfo.md)

All implemented interfaces :
> *java.io.Serializable*, *java.io.ObjectInputValidation*

POJO that aims to be bind to the <tt>/ContestInfo</tt>
 request, using Gson API.


##Summary
####Constructors
| Visibility | Signature |
| --- | --- |
| **public** | [ContestInfo](#contestinfo)() |

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** [ContestInfo](ContestInfo.md) | [get](#gethttprequestexecutor-round)([HttpRequestExecutor](../executor/HttpRequestExecutor.md) executor, [Round](../Round.md) round) |
| **public** [Problem](Problem.md) | [getProblem](#getproblemint)(**int** index) |
| **public** *java.util.List*<[Problem](Problem.md)> | [getProblems](#getproblems)() |
| **public** **int** | [getVersion](#getversion)() |
| **public** **boolean** | [hasAnalysis](#hasanalysis)() |
| **public** **void** | [validateObject](#validateobject)() |

---


##Constructors
####ContestInfo()
> 


---


##Methods
####get(HttpRequestExecutor, Round)
> Static factory method that builds a [ContestInfo](ContestInfo.md) instance
 from the given <tt>round</tt> using a <tt>/ContestInfo</tt>
 request from the round dashboard.

> **Parameters**
* executor : Executor instance used to perform the request.
* round : Round to retrieve [ContestInfo](ContestInfo.md) from.

> **Returns**
* Built [ContestInfo](ContestInfo.md) instance.

> **Throws**
* *java.io.IOException* IF any error occurs while executing request.


---

####getProblem(int)
> Shortcut method for reducing law of Demeters issues.

> **Parameters**
* index : Index of the problem to retrieve.

> **Returns**
* Problem instance required.

> **Throws**
* *java.lang.ArrayIndexOutOfBoundsException* If the given index is not valid.


---

####getProblems()
> Returns [Problem](Problem.md) instance associated
 to this contest.

> **Returns**
* List of problem this contest exposes.


---

####getVersion()
> Getter for the problems version.

> **Returns**
* Integer that defines the problems version.


---

####hasAnalysis()
> Indicates if this contests already have
 analysis committed or not.

> **Returns**
* <tt>true</tt> if contest analysis is available, <tt>false</tt> otherwise.


---

####validateObject()
> 


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)