#Round
Package [fr.faylixe.googlecodejam.client](README.md)<br>

> *java.lang.Object* > [NamedObject](common/NamedObject.md) > [Round](Round.md)

<p>POJO class that represents a Google Jam {@link Round}.
 A {@link Round} is defined by a name, and a dashboard
 URL.</p>

##Summary
####Fields
* **public static final** [DESCRIPTION_CLASS_NAME](#description_class_name)

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** *java.util.List* | [get](#getelement-string)(*org.jsoup.nodes.Element* contest, *java.lang.String* parent) |
| **public** *java.lang.String* | [getContestName](#getcontestname)() |
| **public** *java.lang.String* | [getURL](#geturl)() |

---


##Fields
####DESCRIPTION_CLASS_NAME
> **public static final** *java.lang.String*

> <p>Class name of the HTML description node.</p>

---


##Methods
####get(Element, String)
> <p>Static factory methods that retrieves a list of round
 from the given JSoup <tt>contest</tt> node.</p>

> **Parameters**
* contest : Root element of the contest in the contest index page.
* parent : Parent contest name.

> **Returns**
* List of retrieved round.


---

####getContestName()
> <p>Getter for the parent contest name.</p>

> **Returns**
* Name of the parent contest.


---

####getURL()
> <p>Getter for round dashboard URL.</p>

> **Returns**
* URL of this round dashboard.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)