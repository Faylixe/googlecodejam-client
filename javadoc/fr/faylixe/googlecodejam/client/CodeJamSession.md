#CodeJamSession
Package [fr.faylixe.googlecodejam.client](README.md)<br>

> *Object* > [NamedObject](common/NamedObject.md) > [CodeJamSession](CodeJamSession.md)

{@link CodeJamSession} is the main API entry point, which consists
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
| **public** *String* | [buildFilename](#buildfilenameprobleminput)([ProblemInput](webservice/ProblemInput.md) input) |
| **public static** [CodeJamSession](CodeJamSession.md) | [createSession](#createsessionhttprequestexecutor-round)([HttpRequestExecutor](executor/HttpRequestExecutor.md) executor, [Round](Round.md) round) |
| **public** *InputStream* | [download](#downloadprobleminput)([ProblemInput](webservice/ProblemInput.md) input) |
| **public** *String* | [getContestAnalysis](#getcontestanalysisproblem)([Problem](webservice/Problem.md) problem) |
| **public** [ContestInfo](webservice/ContestInfo.md) | [getContestInfo](#getcontestinfo)() |
| **public** [Problem](webservice/Problem.md) | [getProblem](#getproblemstring)(*String* letter) |
| **public** **boolean** | [isActive](#isactive)() |
| **public** **boolean** | [isLogged](#islogged)() |
| **public** **boolean** | [isQualified](#isqualified)() |
| **public** [CodeJamSession](CodeJamSession.md) | [refresh](#refresh)() |
| **public** [SubmitResponse](webservice/SubmitResponse.md) | [submit](#submitprobleminput-file-file)([ProblemInput](webservice/ProblemInput.md) input, *File* output, *File* source) |

---


##Methods
####buildFilename(ProblemInput)
> <p>Builds and returns a valid file name
 for the given problem <tt>input</tt>.</p>

> **Parameters**
* input : Input to retrieve file name from.

> **Returns**
* Built file name.


---

####createSession(HttpRequestExecutor, Round)
> <p>Static factory method that should be used for creating a session.
 Loads associated contest info and initial values from the given
 <tt>round</tt>, using the given <tt>executor</tt>.</p>

> **Parameters**
* executor : {@link HttpRequestExecutor} instance to use.
* round : Contextual {@link Round} instance this session is bound to.

> **Returns**
* Created session.

> **Throws**
* *IOException* If any error occurs while retrieving contest info or initial values.


---

####download(ProblemInput)
> <p>Downloads and returns the stream of the
 input file associated to the given problem
 <tt>input</tt>.</p>

> **Parameters**
* input : Input to download file from.

> **Returns**
* Stream to read which contains our downloaded file data.

> **Throws**
* *IOException* If any error occurs while downloading the file.


---

####getContestAnalysis(Problem)
> <p>Returns the analysis for the given
 <tt>problem</tt> if any.</p>

> **Parameters**
* problem : Problem to retrieve analysis from.

> **Returns**
* Analysis if any.


---

####getContestInfo()
> <p>Performs and returns a <tt>GET /</tt> request
 in order to get all <tt>round</tt> detail.</p>

> **Returns**
* Request response as a {@link ContestInfo} POJO.


---

####getProblem(String)
> <p>Retrieves the problem associated
 to the given <tt>letter</tt>.</p>

> **Parameters**
* letter : Letter that identifies the problem.

> **Returns**
* Corresponding problem if exist, <tt>null</tt> otherwise.


---

####isActive()
> <p>Indiciates if the contest is currently active,
 namely if competition is occuring at the current
 time, or not.</p>

> **Returns**
* <tt>true</tt> if the contest is active, <tt>false</tt> otherwise.


---

####isLogged()
> <p>Indicates if the current session is logged in or not.</p>

> **Returns**
* <tt>true</tt> if user is logged, <tt>false</tt> otherwise.


---

####isQualified()
> <p>Indicates if the currently logged user is qualified
 for the next round or not.</p>

> **Returns**
* <tt>true</tt> if user is qualified, <tt>false</tt> otherwise.


---

####refresh()
> <p>Reloads session components in order to prevent from any change.</p>

> **Returns**
* A newly created session updated otherwise.

> **Throws**
* *IOException* If any error occurs while reloading a new session.


---

####submit(ProblemInput, File, File)
> <p>Submits the given <tt>output</tt> file and the
 given <tt>source</tt> file for the given problem
 <tt>input</tt>. This method should be call only
 after a successful call to the {@link #download(ProblemInput)}
 method on the same <tt>input</tt>, as the evaluation
 system will judge the last downloaded dataset
 based on the internal token / session.</p>

> **Parameters**
* input : Input file to submit solution for.
* output : Output file produced by the algorithm.
* source : Source code file of the algorithm to submit.

> **Returns**
* Request response, as a {@link SubmitResponse} instance.

> **Throws**
* *IOException* If any error occurs while uploading data, or performing the request.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)