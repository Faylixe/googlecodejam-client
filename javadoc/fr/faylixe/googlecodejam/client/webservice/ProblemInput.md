#ProblemInput
Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>

> *Object* > [NamedObject](ommon/NamedObject.md) > [ProblemInput](ProblemInput.md)

<p>POJO that aims to be bind to the <tt>/ContestInfo</tt>
 request, using Gson API. {@link ProblemInput} instance belong
 to a {@link Problem} object, and describes input submission
 available for a given {@link Problem}.</p>

##Summary
####Constructors
* **public** [ProblemInput](#probleminput)
####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public** **boolean** | [equals](#equalsobject) || **public** **int** | [getDifficulty](#getdifficulty) || **public** **int** | [getNumber](#getnumber) || **public** **int** | [getPoints](#getpoints) || **public** [Problem](Problem.md) | [getProblem](#getproblem) || **public** *String* | [getSuffix](#getsuffix) || **public** **int** | [hashCode](#hashcode) |
####Fields

##Constructors####ProblemInput()
> 

---


##Fields
####LARGE
> **public static final** *String*
Constant used for large input.

####SMALL
> **public static final** *String*
Constant used for small input.


##Methods
####equals(Object)
> {@inheritDoc}

---

####getDifficulty()
> Getter for the problem input difficulty.

**Returns**
* Difficulty rank of this problem input.

---

####getNumber()
> Getter for the problem input number.

**Returns**
* TODO : Figure out what number is for.

---

####getPoints()
> Getter for the input number of point.

**Returns**
* Number of points this problem input deliver.

---

####getProblem()
> Getter for the parent problem of this input.

**Returns**
* Parent problem instance of this input.

---

####getSuffix()
> Getter for the input suffix.

**Returns**
* Suffix used for this problem input.

---

####hashCode()
> {@inheritDoc}

---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)