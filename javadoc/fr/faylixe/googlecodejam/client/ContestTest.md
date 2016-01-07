#ContestTest

Package [fr.faylixe.googlecodejam.client](README.md)<br>
> [Object](../../../ava/lang/Object.md) > [ContestTest](ContestTest.md)

Test case for {@link Contest} class.

##Summary

####Constructors

* **public** ContestTest()

Type | Method
 --- | --- 
[Contest](Contest.md) | getTestContests
**void** | testContestConsistency


##Constructors

###ContestTest()



---

##Methods

###getTestContests()


Retrieves the contest instance that will
 be used for testing. Such contest will be
 the last, assuming the the last contest
 will never change.
#####Returns


* Contest instance for testing.

---
###testContestConsistency()


Ensures retrieved contests are consistent.
 In order to do so, it consider that the last extracted
 contest should never change (the older always stays the older).
---
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)