#CodeJamSession
Package [fr.faylixe.googlecodejam.client](README.md)<br>

> *java.lang.Object* > [NamedObject](common/NamedObject.md) > [CodeJamSession](CodeJamSession.md)

[CodeJamSession](CodeJamSession.md)

##Summary
####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public** *java.lang.String* | [buildFilename](#buildfilenameprobleminput)([ProblemInput](webservice/ProblemInput.md) input) |
| **public static** [CodeJamSession](CodeJamSession.md) | [createSession](#createsessionhttprequestexecutor-round)([HttpRequestExecutor](executor/HttpRequestExecutor.md) executor, [Round](Round.md) round) |
| **public** *java.io.InputStream* | [download](#downloadprobleminput)([ProblemInput](webservice/ProblemInput.md) input) |
| **public** *java.lang.String* | [getContestAnalysis](#getcontestanalysisproblem)([Problem](webservice/Problem.md) problem) |
| **public** [ContestInfo](webservice/ContestInfo.md) | [getContestInfo](#getcontestinfo)() |
| **public** [Problem](webservice/Problem.md) | [getProblem](#getproblemstring)(*java.lang.String* letter) |
| **public** **boolean** | [isActive](#isactive)() |
| **public** **boolean** | [isLogged](#islogged)() |
| **public** **boolean** | [isQualified](#isqualified)() |
| **public** [CodeJamSession](CodeJamSession.md) | [refresh](#refresh)() |
| **public** [SubmitResponse](webservice/SubmitResponse.md) | [submit](#submitprobleminput-file-file)([ProblemInput](webservice/ProblemInput.md) input, *java.io.File* output, *java.io.File* source) |

---


##Methods
####buildFilename(ProblemInput)
> 

> **Parameters**
* input : Input to retrieve file name from.

> **Returns**
* Built file name.


---

####createSession(HttpRequestExecutor, Round)
> 

> **Parameters**
* executor : {@link HttpRequestExecutor} instance to use.
* round : Contextual {@link Round} instance this session is bound to.

> **Returns**
* Created session.

> **Throws**
* *java.io.IOException* If any error occurs while retrieving contest info or initial values.


---

####download(ProblemInput)
> 

> **Parameters**
* input : Input to download file from.

> **Returns**
* Stream to read which contains our downloaded file data.

> **Throws**
* *java.io.IOException* If any error occurs while downloading the file.


---

####getContestAnalysis(Problem)
> 

> **Parameters**
* problem : Problem to retrieve analysis from.

> **Returns**
* Analysis if any.


---

####getContestInfo()
> 

> **Returns**
* Request response as a {@link ContestInfo} POJO.


---

####getProblem(String)
> 

> **Parameters**
* letter : Letter that identifies the problem.

> **Returns**
* Corresponding problem if exist, <tt>null</tt> otherwise.


---

####isActive()
> 

> **Returns**
* <tt>true</tt> if the contest is active, <tt>false</tt> otherwise.


---

####isLogged()
> 

> **Returns**
* <tt>true</tt> if user is logged, <tt>false</tt> otherwise.


---

####isQualified()
> 

> **Returns**
* <tt>true</tt> if user is qualified, <tt>false</tt> otherwise.


---

####refresh()
> 

> **Returns**
* A newly created session updated otherwise.

> **Throws**
* *java.io.IOException* If any error occurs while reloading a new session.


---

####submit(ProblemInput, File, File)
> [CodeJamSession](CodeJamSession.md)

> **Parameters**
* input : Input file to submit solution for.
* output : Output file produced by the algorithm.
* source : Source code file of the algorithm to submit.

> **Returns**
* Request response, as a {@link SubmitResponse} instance.

> **Throws**
* *java.io.IOException* If any error occurs while uploading data, or performing the request.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)