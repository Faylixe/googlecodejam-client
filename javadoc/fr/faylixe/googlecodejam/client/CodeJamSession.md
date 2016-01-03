#CodeJamSession

Package [fr.faylixe.googlecodejam.client](../)<br>
[Object](../../../java/langObject.md) > [NamedObject](/commonNamedObject.md) > [CodeJamSession](CodeJamSession.md)

{@link CodeJamSession} is the main API entry point, which consists
 in logging to a code jam platform ``hostname`` and then providing
 facilities such as :
 <br>
 * Retrieves contest, round
 * Interacts with platform API from a given round
 * Downloads input
 * Submits solutions

###Summary


| Type | Method |
| --- | --- |
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

###Fields


###Methods

####buildFilename


####createSession


####download


####getContestAnalysis


####getContestInfo


####getProblem


####isActive


####isLogged


####isQualified


####refresh


####submit


---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)