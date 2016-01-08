#Contest
Package [fr.faylixe.googlecodejam.client](README.md)<br>

> *java.lang.Object* > [NamedObject](common/NamedObject.md) > [Contest](Contest.md)

<p>POJO class that represents a Google Jam {@link Contest}.
 A {@link Contest} is represented by a name and a
 collection of {@link Round}.</p>

##Summary
####Fields
* **public static final** [CONTEST_CLASS_NAME](#contest_class_name)
* **public static final** [CONTEST_INDEX](#contest_index)

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** *java.util.List* | [get](#gethttprequestexecutor)([HttpRequestExecutor](executor/HttpRequestExecutor.md) executor) |
| **public** *java.util.List* | [getRounds](#getrounds)() |

---


##Fields
####CONTEST_CLASS_NAME
> **public static final** *java.lang.String*

> <p>Class name of the element that contains contest data.</p>

---

####CONTEST_INDEX
> **public static final** *java.lang.String*

> <p>URL of the contest index page.</p>

---


##Methods
####get(HttpRequestExecutor)
> <p>Retrieves and returns a list of available
 contest for the given <tt>hostname</tt>.</p>

> **Parameters**
* executor : {@link HttpRequestExecutor} instance to use to retrieve contest index.

> **Returns**
* List of contest extracted.

> **Throws**
* *java.io.IOException* If any error occurs during contest extraction process.


---

####getRounds()
> <p>Getter that returns a immutable view
 of the {@link Round} list.</p>

> **Returns**
* List of the round of this contest.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)