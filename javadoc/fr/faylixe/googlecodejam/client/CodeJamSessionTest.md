#CodeJamSessionTest

Package [fr.faylixe.googlecodejam.client](README.md)<br>
> [Object](../../../java/lang/Object.md) > [CodeJamSessionTest](CodeJamSessionTest.md)

Test case for {@link CodeJamSession} class.

##Summary


| Type | Method |
| --- | --- | --- |
| [CodeJamSession](CodeJamSession.md) | getTestSession |
| **void** | testContestAnalysis |
| **void** | testDownload |
| **void** | testSessionConsistency |
| **void** | testSubmission |

##Methods

###getTestSession


Retrieves a valid {@link CodeJamSession}
 that should be used for testing.
 Such session is not connected.
#####Return


#####Throws


###testContestAnalysis


Test for the {@link CodeJamSession#getContestAnalysis(Problem)}
 method, using the test {@link Problem} as a reference.#####Throws


###testDownload


Test for the {@link CodeJamSession#download(ProblemInput)}
 method, using the test {@link Problem} as a reference.#####Throws


###testSessionConsistency


Ensures that the internal contest info instance used
 is the one expected. Also test session related properties,
 like if user is qualified or is the contest is active.#####Throws


###testSubmission


Test for the {@link CodeJamSession#submit(ProblemInput, File, File)}
 method, using the test {@link Problem} as a reference.#####Throws


---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)