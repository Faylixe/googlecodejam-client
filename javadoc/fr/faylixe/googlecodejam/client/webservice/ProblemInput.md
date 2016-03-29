#Class ProblemInput
Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>

> *java.lang.Object* > [NamedObject](../common/NamedObject.md) > [ProblemInput](ProblemInput.md)

All implemented interfaces :
> *java.io.Serializable*

POJO that aims to be bind to the <tt>/ContestInfo</tt>
 request, using Gson API. [ProblemInput](ProblemInput.md) instance belong
 to a [Problem](Problem.md) object, and describes input submission
 available for a given [Problem](Problem.md).


##Summary
####Fields
| Type and modifiers | Field name |
| --- | --- |
| **public static final** | [LARGE](#large) |
| **public static final** | [SMALL](#small) |

####Constructors
| Visibility | Signature |
| --- | --- |
| **public** | [ProblemInput](#probleminput)() |

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public** **int** | [getDifficulty](#getdifficulty)() |
| **public** **int** | [getNumber](#getnumber)() |
| **public** **int** | [getPoints](#getpoints)() |
| **public** [Problem](Problem.md) | [getProblem](#getproblem)() |
| **public** *java.lang.String* | [getSuffix](#getsuffix)() |
| **protected** **void** | [setParent](#setparentproblem)([Problem](Problem.md) parent) |

---


##Constructors
####ProblemInput()
> 


---


##Fields
####LARGE
> **public static final** *java.lang.String*

> Constant used for large input.

---

####SMALL
> **public static final** *java.lang.String*

> Constant used for small input.

---


##Methods
####getDifficulty()
> Getter for the problem input difficulty.

> **Returns**
* Difficulty rank of this problem input.


---

####getNumber()
> Getter for the problem input number.

> **Returns**
* TODO : Figure out what number is for.


---

####getPoints()
> Getter for the input number of point.

> **Returns**
* Number of points this problem input deliver.


---

####getProblem()
> Getter for the parent problem of this input.

> **Returns**
* Parent problem instance of this input.


---

####getSuffix()
> Getter for the input suffix.

> **Returns**
* Suffix used for this problem input.


---

####setParent(Problem)
> Sets the parent problem of this input.

> **Parameters**
* parent : Parent problem to set.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)