#Class Contest
Package [fr.faylixe.googlecodejam.client](README.md)<br>

> *java.lang.Object* > [NamedObject](common/NamedObject.md) > [Contest](Contest.md)

All implemented interfaces :
> *java.io.Serializable*

POJO class that represents a Google Jam [Contest](Contest.md).
 A [Contest](Contest.md) is represented by a name and a
 collection of [Round](Round.md).


##Summary
####Fields
| Type and modifiers | Field name |
| --- | --- |
| **public static final** | [CONTEST_CLASS_NAME](#contest_class_name) |
| **public static final** | [CONTEST_INDEX](#contest_index) |

####Constructors
| Visibility | Signature |
| --- | --- |
| **protected** | [Contest](#conteststring-list)(*java.lang.String* name, *java.util.List*<[Round](Round.md)> rounds) |

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** *java.util.List*<[Contest](Contest.md)> | [get](#gethttprequestexecutor)([HttpRequestExecutor](executor/HttpRequestExecutor.md) executor) |
| **public** *java.util.List*<[Round](Round.md)> | [getRounds](#getrounds)() |

---


##Constructors
####Contest(String, List<Round>)
> Default constructor.

> **Parameters**
* name : Name of this contest.
* rounds : [Round](Round.md) that belongs to this contest.


---


##Fields
####CONTEST_CLASS_NAME
> **public static final** *java.lang.String*

> Class name of the element that contains contest data.

---

####CONTEST_INDEX
> **public static final** *java.lang.String*

> URL of the contest index page.

---


##Methods
####get(HttpRequestExecutor)
> Retrieves and returns a list of available
 contest for the given <tt>hostname</tt>.

> **Parameters**
* executor : [HttpRequestExecutor](executor/HttpRequestExecutor.md) instance to use to retrieve contest index.

> **Returns**
* List of contest extracted.

> **Throws**
* *java.io.IOException* If any error occurs during contest extraction process.


---

####getRounds()
> Getter that returns a immutable view
 of the [Round](Round.md) list.

> **Returns**
* List of the round of this contest.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)