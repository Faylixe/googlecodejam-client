#ProblemInput
Package <a href="README.md"> fr.faylixe.googlecodejam.client.webservice</a><br>

> *java.lang.Object* > <a href="../common/NamedObject.md"> NamedObject</a> > <a href="ProblemInput.md"> ProblemInput</a>

<p>POJO that aims to be bind to the <tt>/ContestInfo</tt>
 request, using Gson API. <a href="ProblemInput.md"> ProblemInput</a> instance belong
 to a <a href="Problem.md"> Problem</a> object, and describes input submission
 available for a given <a href="Problem.md"> Problem</a>.</p>

##Summary
####Fields
| Type and modifiers | Field name |
| --- | --- |
| **public static final** | <a href="#large"> LARGE</a> |
| **public static final** | <a href="#small"> SMALL</a> |

####Constructors
* **public** <a href="#probleminput"> ProblemInput</a>()

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public** **int** | <a href="#getdifficulty"> getDifficulty</a>() |
| **public** **int** | <a href="#getnumber"> getNumber</a>() |
| **public** **int** | <a href="#getpoints"> getPoints</a>() |
| **public** <a href="Problem.md"> Problem</a> | <a href="#getproblem"> getProblem</a>() |
| **public** *java.lang.String* | <a href="#getsuffix"> getSuffix</a>() |

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

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)