#Class NamedObject
Package [fr.faylixe.googlecodejam.client.common](README.md)<br>

> *java.lang.Object* > [NamedObject](NamedObject.md)

All implemented interfaces :
> *java.io.Serializable*

Class that represents a object which
 could be identified by a name.


##Summary
####Constructors
| Visibility | Signature |
| --- | --- |
| **protected** | [NamedObject](#namedobject)() |
| **protected** | [NamedObject](#namedobjectstring)(*java.lang.String* name) |

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public final** *java.lang.String* | [getName](#getname)() |

---


##Constructors
####NamedObject()
> Default constructor.


---

####NamedObject(String)
> Constructor with name parameter
 that should be used when such object
 are created without using JSON serialization.

> **Parameters**
* name : Name of this object.


---


##Methods
####getName()
> Getter for the name of this object.

> **Returns**
* Name of this object.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)