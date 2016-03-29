#CodeJamSession
Package <a href="README.md"> fr.faylixe.googlecodejam.client</a><br>

> *java.lang.Object* > <a href="common/NamedObject.md"> NamedObject</a> > <a href="CodeJamSession.md"> CodeJamSession</a>

<a href="CodeJamSession.md"> CodeJamSession</a> is the main API entry point, which consists
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
| **public** *java.lang.String* | <a href="#buildfilenameprobleminput"> buildFilename</a>(<a href="webservice/ProblemInput.md"> ProblemInput</a> input) |
| **public static** <a href="CodeJamSession.md"> CodeJamSession</a> | <a href="#createsessionhttprequestexecutor-round"> createSession</a>(<a href="executor/HttpRequestExecutor.md"> HttpRequestExecutor</a> executor, <a href="Round.md"> Round</a> round) |
| **public** *java.io.InputStream* | <a href="#downloadprobleminput"> download</a>(<a href="webservice/ProblemInput.md"> ProblemInput</a> input) |
| **public** *java.lang.String* | <a href="#getcontestanalysisproblem"> getContestAnalysis</a>(<a href="webservice/Problem.md"> Problem</a> problem) |
| **public** <a href="webservice/ContestInfo.md"> ContestInfo</a> | <a href="#getcontestinfo"> getContestInfo</a>() |
| **public** <a href="webservice/Problem.md"> Problem</a> | <a href="#getproblemstring"> getProblem</a>(*java.lang.String* letter) |
| **public** **boolean** | <a href="#isactive"> isActive</a>() |
| **public** **boolean** | <a href="#islogged"> isLogged</a>() |
| **public** **boolean** | <a href="#isqualified"> isQualified</a>() |
| **public** <a href="CodeJamSession.md"> CodeJamSession</a> | <a href="#refresh"> refresh</a>() |
| **public** <a href="webservice/SubmitResponse.md"> SubmitResponse</a> | <a href="#submitprobleminput-file-file"> submit</a>(<a href="webservice/ProblemInput.md"> ProblemInput</a> input, *java.io.File* output, *java.io.File* source) |

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
* executor : <a href="executor/HttpRequestExecutor.md"> HttpRequestExecutor</a> instance to use.
* round : Contextual <a href="Round.md"> Round</a> instance this session is bound to.

> **Returns**
* Created session.

> **Throws**
* *java.io.IOException* If any error occurs while retrieving contest info or initial values.


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
* *java.io.IOException* If any error occurs while downloading the file.


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
* Request response as a <a href="webservice/ContestInfo.md"> ContestInfo</a> POJO.


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
* *java.io.IOException* If any error occurs while reloading a new session.


---

####submit(ProblemInput, File, File)
> <p>Submits the given <tt>output</tt> file and the
 given <tt>source</tt> file for the given problem
 <tt>input</tt>. This method should be call only
 after a successful call to the <a href="CodeJamSession.md"> CodeJamSession</a>
 method on the same <tt>input</tt>, as the evaluation
 system will judge the last downloaded dataset
 based on the internal token / session.</p>

> **Parameters**
* input : Input file to submit solution for.
* output : Output file produced by the algorithm.
* source : Source code file of the algorithm to submit.

> **Returns**
* Request response, as a <a href="webservice/SubmitResponse.md"> SubmitResponse</a> instance.

> **Throws**
* *java.io.IOException* If any error occurs while uploading data, or performing the request.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)