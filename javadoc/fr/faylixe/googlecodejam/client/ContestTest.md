#ContestTest
Package <a href="README.md"> fr.faylixe.googlecodejam.client</a><br>

> *java.lang.Object* > <a href="ContestTest.md"> ContestTest</a>

Test case for <a href="Contest.md"> Contest</a> class.

##Summary
####Constructors
* **public** <a href="#contesttest"> ContestTest</a>()

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** <a href="Contest.md"> Contest</a> | <a href="#gettestcontests"> getTestContests</a>() |
| **public** **void** | <a href="#testcontestconsistency"> testContestConsistency</a>() |

---


##Constructors
####ContestTest()
> 


---


##Methods
####getTestContests()
> Retrieves the contest instance that will
 be used for testing. Such contest will be
 the last, assuming the the last contest
 will never change.

> **Returns**
* Contest instance for testing.


---

####testContestConsistency()
> Ensures retrieved contests are consistent.
 In order to do so, it consider that the last extracted
 contest should never change (the older always stays the older).


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)