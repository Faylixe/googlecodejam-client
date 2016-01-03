#Problem

Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>
[Object](../../../../java/lang/Object.md) > [NamedObject](common/NamedObject.md) > [Problem](Problem.md)

<p>POJO that aims to be bind to the <tt>/ContestInfo</tt>
 request, using Gson API. {@link Problem} instance belong
 to a {@link ContestInfo} object, and consists in the problem
 metadata such a name, description, and IO details.</p>

##Summary


| Type | Method |
| --- | --- | --- |
| **boolean** | equals |
| [String](../../../../java/lang/String.md) | getBody |
| [String](../../../../java/lang/String.md) | getId |
| [String](../../../../java/lang/String.md) | getKey |
| [String](../../../../java/lang/String.md) | getNormalizedName |
| [ContestInfo](ContestInfo.md) | getParent |
| [ProblemInput](ProblemInput.md) | getProblemInput |
| [ProblemInput](ProblemInput.md) | getProblemInput |
| [List](../../../../java/util/List.md) | getProblemInputs |
| [String](../../../../java/lang/String.md) | getType |
| **int** | hashCode |
| **void** | validateObject |

##Methods

###equals


{@inheritDoc}
#####Parameter(s)


* object

#####Return


#####Throws


###getBody


Getter for the problem body description.
#####Return


#####Throws


###getId


Getter for the problem id.
#####Return


#####Throws


###getKey


Getter for the problem key.
#####Return


#####Throws


###getNormalizedName


Getter for the problem normalized name.
#####Return


#####Throws


###getParent


Getter for the parent contest of this problem.
#####Return


#####Throws


###getProblemInput


Shortcut method for reducing law of Demeters issues.
#####Parameter(s)


* index

#####Return


#####Throws


###getProblemInput


Filters and returns first problem input which name
 match the given <tt>type</tt>
#####Parameter(s)


* type

#####Return


#####Throws


###getProblemInputs


Getter for the problem inputs.
#####Return


#####Throws


###getType


Getter for the problem type.
#####Return


#####Throws


###hashCode


{@inheritDoc}
#####Return


#####Throws


###validateObject


{@inheritDoc}#####Throws


---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)