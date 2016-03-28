#Contest
Package [fr.faylixe.googlecodejam.client](README.md)<br>

> *java.lang.Object* > [NamedObject](common/NamedObject.md) > [Contest](Contest.md)

[Contest](Contest.md)[Contest](Contest.md)[Round](Round.md)

##Summary
####Fields
* **public static final** [CONTEST_CLASS_NAME](#contest_class_name)
* **public static final** [CONTEST_INDEX](#contest_index)

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** *java.util.List*<[Contest](Contest.md)> | [get](#gethttprequestexecutor)([HttpRequestExecutor](executor/HttpRequestExecutor.md) executor) |
| **public** *java.util.List*<[Round](Round.md)> | [getRounds](#getrounds)() |

---


##Fields
####CONTEST_CLASS_NAME
> **public static final** *java.lang.String*

> 

---

####CONTEST_INDEX
> **public static final** *java.lang.String*

> 

---


##Methods
####get(HttpRequestExecutor)
> 

> **Parameters**
* executor : {@link HttpRequestExecutor} instance to use to retrieve contest index.

> **Returns**
* List of contest extracted.

> **Throws**
* *java.io.IOException* If any error occurs during contest extraction process.


---

####getRounds()
> [Round](Round.md)

> **Returns**
* List of the round of this contest.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)