#Contest
Package [fr.faylixe.googlecodejam.client](README.md)<br>

> *Object* > [NamedObject](common/NamedObject.md) > [Contest](Contest.md)

<p>POJO class that represents a Google Jam {@link Contest}.
 A {@link Contest} is represented by a name and a
 collection of {@link Round}.</p>

##Summary
####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public** **boolean** | [equals](#equalsobject) || **public static** *List* | [get](#gethttprequestexecutor) || **public** *List* | [getRounds](#getrounds) || **public** **int** | [hashCode](#hashcode) |
####Fields

##Fields
####CONTEST_CLASS_NAME
> **public static final** *String*
<p>Class name of the element that contains contest data.</p>

####CONTEST_INDEX
> **public static final** *String*
<p>URL of the contest index page.</p>


##Methods
####equals(Object)
> {@inheritDoc}

---

####get(HttpRequestExecutor)
> <p>Retrieves and returns a list of available
 contest for the given <tt>hostname</tt>.</p>
**Parameters**
* executor {@link HttpRequestExecutor} instance to use to retrieve contest index.
**Returns**
* List of contest extracted.
**Throws**
* *IOException* If any error occurs during contest extraction process.

---

####getRounds()
> <p>Getter that returns a immutable view
 of the {@link Round} list.</p>
**Returns**
* List of the round of this contest.

---

####hashCode()
> {@inheritDoc}

---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)