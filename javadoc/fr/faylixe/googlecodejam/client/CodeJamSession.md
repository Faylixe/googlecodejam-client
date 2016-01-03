#CodeJamSession

Package [fr.faylixe.googlecodejam.client](README.md)<br>
[Object](../../../java/langObject.md) > [NamedObject](/commonNamedObject.md) > [CodeJamSession](CodeJamSession.md)

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
| [String](../../../java/langString.md) | buildFilename |
| [CodeJamSession](CodeJamSession.md) | createSession |
| [InputStream](../../../java/ioInputStream.md) | download |
| [String](../../../java/langString.md) | getContestAnalysis |
| [ContestInfo](/webserviceContestInfo.md) | getContestInfo |
| [Problem](/webserviceProblem.md) | getProblem |
| **boolean** | isActive |
| **boolean** | isLogged |
| **boolean** | isQualified |
| [CodeJamSession](CodeJamSession.md) | refresh |
| [SubmitResponse](/webserviceSubmitResponse.md) | submit |

##Methods

###buildFilename


<p>Builds and returns a valid file name
 for the given problem <tt>input</tt>.</p>
#####Parameter(s)


* input

#####Return


#####Throws


###createSession


<p>Static factory method that should be used for creating a session.
 Loads associated contest info and initial values from the given
 <tt>round</tt>, using the given <tt>executor</tt>.</p>
#####Parameter(s)


* executor
* round

#####Return


#####Throws


###download


<p>Downloads and returns the stream of the
 input file associated to the given problem
 <tt>input</tt>.</p>
#####Parameter(s)


* input

#####Return


#####Throws


###getContestAnalysis


<p>Returns the analysis for the given
 <tt>problem</tt> if any.</p>
#####Parameter(s)


* problem

#####Return


#####Throws


###getContestInfo


<p>Performs and returns a <tt>GET /</tt> request
 in order to get all <tt>round</tt> detail.</p>
#####Return


#####Throws


###getProblem


<p>Retrieves the problem associated
 to the given <tt>letter</tt>.</p>
#####Parameter(s)


* letter

#####Return


#####Throws


###isActive


<p>Indiciates if the contest is currently active,
 namely if competition is occuring at the current
 time, or not.</p>
#####Return


#####Throws


###isLogged


<p>Indicates if the current session is logged in or not.</p>
#####Return


#####Throws


###isQualified


<p>Indicates if the currently logged user is qualified
 for the next round or not.</p>
#####Return


#####Throws


###refresh


<p>Reloads session components in order to prevent from any change.</p>
#####Return


#####Throws


###submit


<p>Submits the given <tt>output</tt> file and the
 given <tt>source</tt> file for the given problem
 <tt>input</tt>. This method should be call only
 after a successful call to the {@link #download(ProblemInput)}
 method on the same <tt>input</tt>, as the evaluation
 system will judge the last downloaded dataset
 based on the internal token / session.</p>
#####Parameter(s)


* input
* output
* source

#####Return


#####Throws


---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)