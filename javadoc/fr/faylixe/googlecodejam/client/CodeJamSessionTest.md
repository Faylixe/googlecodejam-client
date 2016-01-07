#CodeJamSessionTest

Package [fr.faylixe.googlecodejam.client](README.md)<br>
> [Object](../../../java/lang/Object.md) > [CodeJamSessionTest](CodeJamSessionTest.md)

Test case for {@link CodeJamSession} class.

##Summary

Constructor
 --- 
Type | Method
 --- | --- 
[CodeJamSession](CodeJamSession.md) | getTestSession
**void** | testContestAnalysis
**void** | testDownload
**void** | testSessionConsistency
**void** | testSubmission

##Constructors

###()



---

##Methods

###()


Retrieves a valid {@link CodeJamSession}
 that should be used for testing.
 Such session is not connected.
#####Returns


* Session instance that should be used for testing.

---
###()


Test for the {@link CodeJamSession#getContestAnalysis(Problem)}
 method, using the test {@link Problem} as a reference.
---
###()


Test for the {@link CodeJamSession#download(ProblemInput)}
 method, using the test {@link Problem} as a reference.
---
###()


Ensures that the internal contest info instance used
 is the one expected. Also test session related properties,
 like if user is qualified or is the contest is active.
---
###()


Test for the {@link CodeJamSession#submit(ProblemInput, File, File)}
 method, using the test {@link Problem} as a reference.
---
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)