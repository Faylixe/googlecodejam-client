#ProblemTest

Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>
> [Object](../../../../ava/lang/Object.md) > [ProblemTest](ProblemTest.md)

Test case for the {@link Problem} class.

##Summary

| Constructor |
|  ---  |
| **public**ProblemTest() |

Type | Method
 --- | --- 
[Problem](Problem.md) | getTestProblem
**void** | testProblemConsistency


##Constructors

###ProblemTest()



---

##Methods

###getTestProblem()


Retrieves the {@link Problem} instance
 that will be used for testing. Using
 test {@link ContestInfo} as reference.
#####Returns


* Problem instance for testing.

---
###testProblemConsistency()


Ensures retrieved {@link Problem} is
 consistent. Uses the first {@link Problem}
 from {@link ContestInfo} test instance.
---
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)