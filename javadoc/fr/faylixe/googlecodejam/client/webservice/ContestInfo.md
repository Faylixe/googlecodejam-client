#ContestInfo
Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>

> *java.lang.Object* > [ContestInfo](ContestInfo.md)



##Summary
####Constructors
* **public** [ContestInfo](#contestinfo)()

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** [ContestInfo](ContestInfo.md) | [get](#gethttprequestexecutor-round)([HttpRequestExecutor](../executor/HttpRequestExecutor.md) executor, [Round](../Round.md) round) |
| **public** [Problem](Problem.md) | [getProblem](#getproblemint)(**int** index) |
| **public** *java.util.List*<[Problem](Problem.md)> | [getProblems](#getproblems)() |
| **public** **int** | [getVersion](#getversion)() |
| **public** **boolean** | [hasAnalysis](#hasanalysis)() |

---


##Constructors
####ContestInfo()
> 


---


##Methods
####get(HttpRequestExecutor, Round)
> [ContestInfo](ContestInfo.md)

> **Parameters**
* executor : Executor instance used to perform the request.
* round : Round to retrieve {@link ContestInfo} from.

> **Returns**
* Built {@link ContestInfo} instance.

> **Throws**
* *java.io.IOException* IF any error occurs while executing request.


---

####getProblem(int)
> 

> **Parameters**
* index : Index of the problem to retrieve.

> **Returns**
* Problem instance required.

> **Throws**
* *java.lang.ArrayIndexOutOfBoundsException* If the given index is not valid.


---

####getProblems()
> [Problem](Problem.md)

> **Returns**
* List of problem this contest exposes.


---

####getVersion()
> 

> **Returns**
* Integer that defines the problems version.


---

####hasAnalysis()
> 

> **Returns**
* <tt>true</tt> if contest analysis is available, <tt>false</tt> otherwise.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)