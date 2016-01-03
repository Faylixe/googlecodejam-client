#CodeJamSession

Package [fr.faylixe.googlecodejam.client](README.md)<br>
> [Object](../../../java/lang/Object.md) > [NamedObject](/common/NamedObject.md) > [CodeJamSession](CodeJamSession.md)

{@link CodeJamSession} is the main API entry point, which consists
 in logging to a code jam platform ``hostname`` and then providing
 facilities such as :
 <br>
 * Retrieves contest, round
 * Interacts with platform API from a given round
 * Downloads input
 * Submits solutions

##Summary


| Type | Method |
| --- | --- | --- |
| [String](../../../java/lang/String.md) | buildFilename |
| [CodeJamSession](CodeJamSession.md) | createSession |
| [InputStream](../../../java/io/InputStream.md) | download |
| [String](../../../java/lang/String.md) | getContestAnalysis |
| [ContestInfo](/webservice/ContestInfo.md) | getContestInfo |
| [Problem](/webservice/Problem.md) | getProblem |
| **boolean** | isActive |
| **boolean** | isLogged |
| **boolean** | isQualified |
| [CodeJamSession](CodeJamSession.md) | refresh |
| [SubmitResponse](/webservice/SubmitResponse.md) | submit |

##Methods

###buildFilename


<p>Builds and returns a valid file name
 for the given problem <tt>input</tt>.</p>
#####Parameters


> input Input to retrieve file name from.

#####Returns



--
###createSession


<p>Static factory method that should be used for creating a session.
 Loads associated contest info and initial values from the given
 <tt>round</tt>, using the given <tt>executor</tt>.</p>
#####Parameters


> executor {@link HttpRequestExecutor} instance to use.
> round Contextual {@link Round} instance this session is bound to.

#####Returns


#####Throws

* [IOException](../../../java/io/IOException.md) If any error occurs while retrieving contest info or initial values.

--
###download


<p>Downloads and returns the stream of the
 input file associated to the given problem
 <tt>input</tt>.</p>
#####Parameters


> input Input to download file from.

#####Returns


#####Throws

* [IOException](../../../java/io/IOException.md) If any error occurs while downloading the file.

--
###getContestAnalysis


<p>Returns the analysis for the given
 <tt>problem</tt> if any.</p>
#####Parameters


> problem Problem to retrieve analysis from.

#####Returns



--
###getContestInfo


<p>Performs and returns a <tt>GET /</tt> request
 in order to get all <tt>round</tt> detail.</p>
#####Returns



--
###getProblem


<p>Retrieves the problem associated
 to the given <tt>letter</tt>.</p>
#####Parameters


> letter Letter that identifies the problem.

#####Returns



--
###isActive


<p>Indiciates if the contest is currently active,
 namely if competition is occuring at the current
 time, or not.</p>
#####Returns



--
###isLogged


<p>Indicates if the current session is logged in or not.</p>
#####Returns



--
###isQualified


<p>Indicates if the currently logged user is qualified
 for the next round or not.</p>
#####Returns



--
###refresh


<p>Reloads session components in order to prevent from any change.</p>
#####Returns


#####Throws

* [IOException](../../../java/io/IOException.md) If any error occurs while reloading a new session.

--
###submit


<p>Submits the given <tt>output</tt> file and the
 given <tt>source</tt> file for the given problem
 <tt>input</tt>. This method should be call only
 after a successful call to the {@link #download(ProblemInput)}
 method on the same <tt>input</tt>, as the evaluation
 system will judge the last downloaded dataset
 based on the internal token / session.</p>
#####Parameters


> input Input file to submit solution for.
> output Output file produced by the algorithm.
> source Source code file of the algorithm to submit.

#####Returns


#####Throws

* [IOException](../../../java/io/IOException.md) If any error occurs while uploading data, or performing the request.

--
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)