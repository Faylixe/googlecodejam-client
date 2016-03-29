#Class ContestInfoTest
Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>

> *java.lang.Object* > [ContestInfoTest](ContestInfoTest.md)



Test case for [ContestInfo](ContestInfo.md) class.


##Summary
####Constructors
| Visibility | Signature |
| --- | --- |
| **public** | [ContestInfoTest](#contestinfotest)() |

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** [ContestInfo](ContestInfo.md) | [getTestContestInfo](#gettestcontestinfo)() |
| **public static** **void** | [testContestInfoConsistency](#testcontestinfoconsistencycontestinfo)([ContestInfo](ContestInfo.md) info) |
| **public** **void** | [testContestInfoConsistency](#testcontestinfoconsistency)() |

---


##Constructors
####ContestInfoTest()
> 


---


##Methods
####getTestContestInfo()
> Retrieves the [ContestInfo](ContestInfo.md) instance
 that will be used for testing. Using
 test [Round](../Round.md) as reference.

> **Returns**
* ContestInfo instance for testing.


---

####testContestInfoConsistency(ContestInfo)
> Ensures the given [ContestInfo](ContestInfo.md) is
 consistent.

> **Parameters**
* info : [ContestInfo](ContestInfo.md) instance to ensure consistency from.


---

####testContestInfoConsistency()
> Ensures retrieved [ContestInfo](ContestInfo.md) is
 consistent. Uses [ContestInfo](ContestInfo.md) from
 target test [Round](../Round.md) instance.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)