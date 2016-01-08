#CodeJamSessionTest
Package [fr.faylixe.googlecodejam.client](README.md)<br>

> *Object* > [CodeJamSessionTest](CodeJamSessionTest.md)

Test case for {@link CodeJamSession} class.

##Summary
####Constructors
* **public** [CodeJamSessionTest](#codejamsessiontest)
####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** [CodeJamSession](CodeJamSession.md) | [getTestSession](#gettestsession) || **public** **void** | [testContestAnalysis](#testcontestanalysis) || **public** **void** | [testDownload](#testdownload) || **public** **void** | [testSessionConsistency](#testsessionconsistency) || **public** **void** | [testSubmission](#testsubmission) |

##Constructors####CodeJamSessionTest()
> 

---


##Methods
####getTestSession()
> Retrieves a valid {@link CodeJamSession}
 that should be used for testing.
 Such session is not connected.

**Returns**
* Session instance that should be used for testing.

---

####testContestAnalysis()
> Test for the {@link CodeJamSession#getContestAnalysis(Problem)}
 method, using the test {@link Problem} as a reference.

---

####testDownload()
> Test for the {@link CodeJamSession#download(ProblemInput)}
 method, using the test {@link Problem} as a reference.

---

####testSessionConsistency()
> Ensures that the internal contest info instance used
 is the one expected. Also test session related properties,
 like if user is qualified or is the contest is active.

---

####testSubmission()
> Test for the {@link CodeJamSession#submit(ProblemInput, File, File)}
 method, using the test {@link Problem} as a reference.

---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)