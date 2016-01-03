#Problem

Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>
> [Object](../../../../java/lang/Object.md) > [NamedObject](common/NamedObject.md) > [Problem](Problem.md)

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
#####Returns



--
###getBody


Getter for the problem body description.
#####Returns



--
###getId


Getter for the problem id.
#####Returns



--
###getKey


Getter for the problem key.
#####Returns



--
###getNormalizedName


Getter for the problem normalized name.
#####Returns



--
###getParent


Getter for the parent contest of this problem.
#####Returns



--
###getProblemInput


Shortcut method for reducing law of Demeters issues.
#####Parameters


> index Index of the problem input to retrieve.

#####Returns


#####Throws

* [ArrayIndexOutOfBoundsException](../../../../java/lang/ArrayIndexOutOfBoundsException.md) If the given index is not valid.

--
###getProblemInput


Filters and returns first problem input which name
 match the given <tt>type</tt>
#####Parameters


> type Type of the input to retrieve (usually small or large).

#####Returns



--
###getProblemInputs


Getter for the problem inputs.
#####Returns



--
###getType


Getter for the problem type.
#####Returns



--
###hashCode


{@inheritDoc}
#####Returns



--
###validateObject


{@inheritDoc}
--
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)