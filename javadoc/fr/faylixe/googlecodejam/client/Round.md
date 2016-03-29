#Class Round
Package [fr.faylixe.googlecodejam.client](README.md)<br>

> *java.lang.Object* > [NamedObject](common/NamedObject.md) > [Round](Round.md)

All implemented interfaces :
> *java.io.Serializable*

POJO class that represents a Google Jam [Round](Round.md).
 A [Round](Round.md) is defined by a name, and a dashboard
 URL.


##Summary
####Fields
| Type and modifiers | Field name |
| --- | --- |
| **public static final** | [DESCRIPTION_CLASS_NAME](#description_class_name) |

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

> Class name of the HTML description node.

---


##Methods
####get(Element, String)
> Static factory methods that retrieves a list of round
 from the given JSoup <tt>contest</tt> node.

> **Parameters**
* contest : Root element of the contest in the contest index page.
* parent : Parent contest name.

> **Returns**
* List of retrieved round.


---

####getContestName()
> Getter for the parent contest name.

> **Returns**
* Name of the parent contest.


---

####getURL()
> Getter for round dashboard URL.

> **Returns**
* URL of this round dashboard.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)