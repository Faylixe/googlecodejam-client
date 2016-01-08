#ContestInfo

Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>
> *Object* > [ContestInfo](ContestInfo.md)

<p>POJO that aims to be bind to the <tt>/ContestInfo</tt>
 request, using Gson API.</p>

##Summary

####Constructors

* **public** [ContestInfo](#contestinfo)

####Methods

Type and modifiers | Method signature
 --- | --- 
**public static** [ContestInfo](ContestInfo.md) | [get](#gethttprequestexecutor-round)
**public** [Problem](Problem.md) | [getProblem](#getproblemint)
**public** *List* | [getProblems](#getproblems)
**public** **int** | [getVersion](#getversion)
**public** **boolean** | [hasAnalysis](#hasanalysis)
**public** **void** | [validateObject](#validateobject)


##Constructors

###ContestInfo()



---

##Methods

###get(HttpRequestExecutor, Round)


Static factory method that builds a {@link ContestInfo} instance
 from the given <tt>round</tt> using a <tt>/ContestInfo</tt>
 request from the round dashboard.
#####Parameters


* executor Executor instance used to perform the request.
* round Round to retrieve {@link ContestInfo} from.

#####Returns


* Built {@link ContestInfo} instance.

#####Throws

* *IOException* IF any error occurs while executing request.

---
###getProblem(int)


Shortcut method for reducing law of Demeters issues.
#####Parameters


* index Index of the problem to retrieve.

#####Returns


* Problem instance required.

#####Throws

* *ArrayIndexOutOfBoundsException* If the given index is not valid.

---
###getProblems()


Returns {@link Problem} instance associated
 to this contest.
#####Returns


* List of problem this contest exposes.

---
###getVersion()


Getter for the problems version.
#####Returns


* Integer that defines the problems version.

---
###hasAnalysis()


Indicates if this contests already have
 analysis committed or not.
#####Returns


* <tt>true</tt> if contest analysis is available, <tt>false</tt> otherwise.

---
###validateObject()


{@inheritDoc}
---
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)