#Round
Package <a href="README.md"> fr.faylixe.googlecodejam.client</a><br>

> *java.lang.Object* > <a href="common/NamedObject.md"> NamedObject</a> > <a href="Round.md"> Round</a>

<p>POJO class that represents a Google Jam <a href="Round.md"> Round</a>.
 A <a href="Round.md"> Round</a> is defined by a name, and a dashboard
 URL.</p>

##Summary
####Fields
| Type and modifiers | Field name |
| --- | --- |
| **public static final** | <a href="#description_class_name"> DESCRIPTION_CLASS_NAME</a> |

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** *java.util.List*<<a href="Round.md"> Round</a>> | <a href="#getelement-string"> get</a>(*org.jsoup.nodes.Element* contest, *java.lang.String* parent) |
| **public** *java.lang.String* | <a href="#getcontestname"> getContestName</a>() |
| **public** *java.lang.String* | <a href="#geturl"> getURL</a>() |

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