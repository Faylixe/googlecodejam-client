#Round
Package [fr.faylixe.googlecodejam.client](README.md)<br>

> *java.lang.Object* > [NamedObject](common/NamedObject.md) > [Round](Round.md)

[Round](Round.md)[Round](Round.md)

##Summary
####Fields
* **public static final** [DESCRIPTION_CLASS_NAME](#description_class_name)

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** *java.util.List*<[Round](Round.md)> | [get](#getelement-string)(*org.jsoup.nodes.Element* contest, *java.lang.String* parent) |
| **public** *java.lang.String* | [getContestName](#getcontestname)() |
| **public** *java.lang.String* | [getURL](#geturl)() |

---


##Fields
####DESCRIPTION_CLASS_NAME
> **public static final** *java.lang.String*

> 

---


##Methods
####get(Element, String)
> 

> **Parameters**
* contest : Root element of the contest in the contest index page.
* parent : Parent contest name.

> **Returns**
* List of retrieved round.


---

####getContestName()
> 

> **Returns**
* Name of the parent contest.


---

####getURL()
> 

> **Returns**
* URL of this round dashboard.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)