#ContestInfo
Package <a href="README.md"> fr.faylixe.googlecodejam.client.webservice</a><br>

> *java.lang.Object* > <a href="ContestInfo.md"> ContestInfo</a>

<p>POJO that aims to be bind to the <tt>/ContestInfo</tt>
 request, using Gson API.</p>

##Summary
####Constructors
* **public** <a href="#contestinfo"> ContestInfo</a>()

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** <a href="ContestInfo.md"> ContestInfo</a> | <a href="#gethttprequestexecutor-round"> get</a>(<a href="../executor/HttpRequestExecutor.md"> HttpRequestExecutor</a> executor, <a href="../Round.md"> Round</a> round) |
| **public** <a href="Problem.md"> Problem</a> | <a href="#getproblemint"> getProblem</a>(**int** index) |
| **public** *java.util.List*<<a href="Problem.md"> Problem</a>> | <a href="#getproblems"> getProblems</a>() |
| **public** **int** | <a href="#getversion"> getVersion</a>() |
| **public** **boolean** | <a href="#hasanalysis"> hasAnalysis</a>() |

---


##Constructors
####ContestInfo()
> 


---


##Methods
####get(HttpRequestExecutor, Round)
> Static factory method that builds a <a href="ContestInfo.md"> ContestInfo</a> instance
 from the given <tt>round</tt> using a <tt>/ContestInfo</tt>
 request from the round dashboard.

> **Parameters**
* executor : Executor instance used to perform the request.
* round : Round to retrieve <a href="ContestInfo.md"> ContestInfo</a> from.

> **Returns**
* Built <a href="ContestInfo.md"> ContestInfo</a> instance.

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
> Returns <a href="Problem.md"> Problem</a> instance associated
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

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)