#CodeJamSessionTest
Package [fr.faylixe.googlecodejam.client](README.md)<br>

> *java.lang.Object* > <a href="CodeJamSessionTest.md">CodeJamSessionTest</a>

Test case for <a href="CodeJamSession.md">CodeJamSession</a> class.

##Summary
####Constructors
* **public** [CodeJamSessionTest](#codejamsessiontest)()

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** <a href="CodeJamSession.md">CodeJamSession</a> | [getTestSession](#gettestsession)() |
| **public** **void** | [testContestAnalysis](#testcontestanalysis)() |
| **public** **void** | [testDownload](#testdownload)() |
| **public** **void** | [testSessionConsistency](#testsessionconsistency)() |
| **public** **void** | [testSubmission](#testsubmission)() |

---


##Constructors
####CodeJamSessionTest()
> 


---


##Methods
####getTestSession()
> Retrieves a valid <a href="CodeJamSession.md">CodeJamSession</a>
 that should be used for testing.
 Such session is not connected.

> **Returns**
* Session instance that should be used for testing.


---

####testContestAnalysis()
> Test for the <a href="CodeJamSession.md">CodeJamSession</a>
 method, using the test <a href="webservice/Problem.md">Problem</a> as a reference.


---

####testDownload()
> Test for the <a href="CodeJamSession.md">CodeJamSession</a>
 method, using the test <a href="webservice/Problem.md">Problem</a> as a reference.


---

####testSessionConsistency()
> Ensures that the internal contest info instance used
 is the one expected. Also test session related properties,
 like if user is qualified or is the contest is active.


---

####testSubmission()
> Test for the <a href="CodeJamSession.md">CodeJamSession</a>
 method, using the test <a href="webservice/Problem.md">Problem</a> as a reference.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)