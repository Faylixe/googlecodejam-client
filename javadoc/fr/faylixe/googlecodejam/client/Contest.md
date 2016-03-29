#Contest
Package [fr.faylixe.googlecodejam.client](README.md)<br>

> *java.lang.Object* > <a href="common/NamedObject.md">NamedObject</a> > <a href="Contest.md">Contest</a>

<p>POJO class that represents a Google Jam <a href="Contest.md">Contest</a>.
 A <a href="Contest.md">Contest</a> is represented by a name and a
 collection of <a href="Round.md">Round</a>.</p>

##Summary
####Fields
| Type and modifiers | Field name |
| --- | --- |
| **public static final** | [CONTEST_CLASS_NAME](#contest_class_name) |
| **public static final** | [CONTEST_INDEX](#contest_index) |

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** *java.util.List*<<a href="Contest.md">Contest</a>> | [get](#gethttprequestexecutor)(<a href="executor/HttpRequestExecutor.md">HttpRequestExecutor</a> executor) |
| **public** *java.util.List*<<a href="Round.md">Round</a>> | [getRounds](#getrounds)() |

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
* executor : <a href="executor/HttpRequestExecutor.md">HttpRequestExecutor</a> instance to use to retrieve contest index.

> **Returns**
* List of contest extracted.

> **Throws**
* *java.io.IOException* If any error occurs during contest extraction process.


---

####getRounds()
> <p>Getter that returns a immutable view
 of the <a href="Round.md">Round</a> list.</p>

> **Returns**
* List of the round of this contest.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)