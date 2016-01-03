#Problem

Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>
[Object](../../../../java/langObject.md) > [NamedObject](commonNamedObject.md) > [Problem](Problem.md)

<p>POJO that aims to be bind to the <tt>/ContestInfo</tt>
 request, using Gson API. {@link Problem} instance belong
 to a {@link ContestInfo} object, and consists in the problem
 metadata such a name, description, and IO details.</p>

###Summary


| Type | Method |
| --- | --- | --- |
| **boolean** | equals |
| [String](../../../../java/langString.md) | getBody |
| [String](../../../../java/langString.md) | getId |
| [String](../../../../java/langString.md) | getKey |
| [String](../../../../java/langString.md) | getNormalizedName |
| [ContestInfo](ContestInfo.md) | getParent |
| [ProblemInput](ProblemInput.md) | getProblemInput |
| [ProblemInput](ProblemInput.md) | getProblemInput |
| [List](../../../../java/utilList.md) | getProblemInputs |
| [String](../../../../java/langString.md) | getType |
| **int** | hashCode |
| **void** | validateObject |

###Methods

####equals

{@inheritDoc}
####getBody

Getter for the problem body description.
####getId

Getter for the problem id.
####getKey

Getter for the problem key.
####getNormalizedName

Getter for the problem normalized name.
####getParent

Getter for the parent contest of this problem.
####getProblemInput

Shortcut method for reducing law of Demeters issues.
####getProblemInput

Filters and returns first problem input which name
 match the given <tt>type</tt>
####getProblemInputs

Getter for the problem inputs.
####getType

Getter for the problem type.
####hashCode

{@inheritDoc}
####validateObject

{@inheritDoc}
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)