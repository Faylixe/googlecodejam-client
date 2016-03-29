#ContestInfoTest
Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>

> *java.lang.Object* > <a href="ContestInfoTest.md">ContestInfoTest</a>

Test case for <a href="ContestInfo.md">ContestInfo</a> class.

##Summary
####Constructors
* **public** [ContestInfoTest](#contestinfotest)()

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** <a href="ContestInfo.md">ContestInfo</a> | [getTestContestInfo](#gettestcontestinfo)() |
| **public static** **void** | [testContestInfoConsistency](#testcontestinfoconsistencycontestinfo)(<a href="ContestInfo.md">ContestInfo</a> info) |
| **public** **void** | [testContestInfoConsistency](#testcontestinfoconsistency)() |

---


##Constructors
####ContestInfoTest()
> 


---


##Methods
####getTestContestInfo()
> Retrieves the <a href="ContestInfo.md">ContestInfo</a> instance
 that will be used for testing. Using
 test <a href="../Round.md">Round</a> as reference.

> **Returns**
* ContestInfo instance for testing.


---

####testContestInfoConsistency(ContestInfo)
> Ensures the given <a href="ContestInfo.md">ContestInfo</a> is
 consistent.

> **Parameters**
* info : <a href="ContestInfo.md">ContestInfo</a> instance to ensure consistency from.


---

####testContestInfoConsistency()
> Ensures retrieved <a href="ContestInfo.md">ContestInfo</a> is
 consistent. Uses <a href="ContestInfo.md">ContestInfo</a> from
 target test <a href="../Round.md">Round</a> instance.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)