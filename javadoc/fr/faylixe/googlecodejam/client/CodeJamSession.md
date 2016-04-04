#Class CodeJamSession
Package [fr.faylixe.googlecodejam.client](README.md)<br>

> *java.lang.Object* > [NamedObject](common/NamedObject.md) > [CodeJamSession](CodeJamSession.md)

All implemented interfaces :
> *java.io.Serializable*

[CodeJamSession](CodeJamSession.md) is the main API entry point, which consists
 in logging to a code jam platform ``hostname`` and then providing
 facilities such as :
 <br>
 * Retrieves contest, round
 * Interacts with platform API from a given round
 * Downloads input
 * Submits solutions


##Summary
####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public** *java.lang.String* | [buildFilename](#buildfilenameprobleminput-int)([ProblemInput](webservice/ProblemInput.md) input, **int** attempt) |
| **public static** [CodeJamSession](CodeJamSession.md) | [createSession](#createsessionhttprequestexecutor-round)([HttpRequestExecutor](executor/HttpRequestExecutor.md) executor, [Round](Round.md) round) |
| **public** *java.io.InputStream* | [download](#downloadprobleminput)([ProblemInput](webservice/ProblemInput.md) input) |
| **public** *java.io.InputStream* | [download](#downloadprobleminput-int)([ProblemInput](webservice/ProblemInput.md) input, **int** attempt) |
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
####buildFilename(ProblemInput, int)
> Builds and returns a valid file name
 for the given problem <tt>input</tt>.

> **Parameters**
* input : Input to retrieve file name from.
* attempt : Attempt number.

> **Returns**
* Built file name.


---

####createSession(HttpRequestExecutor, Round)
> Static factory method that should be used for creating a session.
 Loads associated contest info and initial values from the given
 <tt>round</tt>, using the given <tt>executor</tt>.

> **Parameters**
* executor : [HttpRequestExecutor](executor/HttpRequestExecutor.md) instance to use.
* round : Contextual [Round](Round.md) instance this session is bound to.

> **Returns**
* Created session.

> **Throws**
* *java.io.IOException* If any error occurs while retrieving contest info or initial values.


---

####download(ProblemInput)
> Downloads and returns the stream of the
 input file associated to the given problem
 <tt>input</tt> in a practice mode.

> **Parameters**
* input : Input to download file from.

> **Returns**
* Stream to read which contains our downloaded file data.

> **Throws**
* *java.io.IOException* If any error occurs while downloading the file.


---

####download(ProblemInput, int)
> Downloads and returns the stream of the
 input file associated to the given problem
 <tt>input</tt>.

> **Parameters**
* input : Input to download file from.
* attempt : Attempt number.

> **Returns**
* Stream to read which contains our downloaded file data.

> **Throws**
* *java.io.IOException* If any error occurs while downloading the file.


---

####getContestAnalysis(Problem)
> Returns the analysis for the given
 <tt>problem</tt> if any.

> **Parameters**
* problem : Problem to retrieve analysis from.

> **Returns**
* Analysis if any.


---

####getContestInfo()
> Performs and returns a <tt>GET /</tt> request
 in order to get all <tt>round</tt> detail.

> **Returns**
* Request response as a [ContestInfo](webservice/ContestInfo.md) POJO.


---

####getProblem(String)
> Retrieves the problem associated
 to the given <tt>letter</tt>.

> **Parameters**
* letter : Letter that identifies the problem.

> **Returns**
* Corresponding problem if exist, <tt>null</tt> otherwise.


---

####isActive()
> Indiciates if the contest is currently active,
 namely if competition is occuring at the current
 time, or not.

> **Returns**
* <tt>true</tt> if the contest is active, <tt>false</tt> otherwise.


---

####isLogged()
> Indicates if the current session is logged in or not.

> **Returns**
* <tt>true</tt> if user is logged, <tt>false</tt> otherwise.


---

####isQualified()
> Indicates if the currently logged user is qualified
 for the next round or not.

> **Returns**
* <tt>true</tt> if user is qualified, <tt>false</tt> otherwise.


---

####refresh()
> Reloads session components in order to prevent from any change.

> **Returns**
* A newly created session updated otherwise.

> **Throws**
* *java.io.IOException* If any error occurs while reloading a new session.


---

####submit(ProblemInput, File, File)
> Submits the given <tt>output</tt> file and the
 given <tt>source</tt> file for the given problem
 <tt>input</tt>. This method should be call only
 after a successful call to the [CodeJamSession](CodeJamSession.md)
 method on the same <tt>input</tt>, as the evaluation
 system will judge the last downloaded dataset
 based on the internal token / session.

> **Parameters**
* input : Input file to submit solution for.
* output : Output file produced by the algorithm.
* source : Source code file of the algorithm to submit.

> **Returns**
* Request response, as a [SubmitResponse](webservice/SubmitResponse.md) instance.

> **Throws**
* *java.io.IOException* If any error occurs while uploading data, or performing the request.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)