#ContestInfoTest

Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>
> *Object* > [ContestInfoTest](ContestInfoTest.md)

Test case for {@link ContestInfo} class.

##Summary

####Constructors

* **public** [ContestInfoTest](#contestinfotest)

####Methods

Type and modifiers | Method signature
 --- | --- 
**public static** [ContestInfo](ContestInfo.md) | [getTestContestInfo](#gettestcontestinfo)
**public static** **void** | [testContestInfoConsistency](#testcontestinfoconsistencycontestinfo)
**public** **void** | [testContestInfoConsistency](#testcontestinfoconsistency)


##Constructors

####ContestInfoTest()



---

##Methods

####getTestContestInfo()


Retrieves the {@link ContestInfo} instance
 that will be used for testing. Using
 test {@link Round} as reference.
#####Returns


* ContestInfo instance for testing.

---
####testContestInfoConsistency(ContestInfo)


Ensures the given {@link ContestInfo} is
 consistent.
#####Parameters


* info {@link ContestInfo} instance to ensure consistency from.

---
####testContestInfoConsistency()


Ensures retrieved {@link ContestInfo} is
 consistent. Uses {@link ContestInfo} from
 target test {@link Round} instance.
---
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)