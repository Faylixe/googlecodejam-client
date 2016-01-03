#ProblemInput

Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>
[Object](../../../../java/langObject.md) > [NamedObject](commonNamedObject.md) > [ProblemInput](ProblemInput.md)

<p>POJO that aims to be bind to the <tt>/ContestInfo</tt>
 request, using Gson API. {@link ProblemInput} instance belong
 to a {@link Problem} object, and describes input submission
 available for a given {@link Problem}.</p>

###Summary


| Type | Method |
| --- | --- | --- |
| **boolean** | equals |
| **int** | getDifficulty |
| **int** | getNumber |
| **int** | getPoints |
| [Problem](Problem.md) | getProblem |
| [String](../../../../java/langString.md) | getSuffix |
| **int** | hashCode |

###Fields


| Type | Field | Description |
| --- | --- | --- |
|  | LARGE |
|  | SMALL |

###Methods

####equals

{@inheritDoc}
####getDifficulty

Getter for the problem input difficulty.
####getNumber

Getter for the problem input number.
####getPoints

Getter for the input number of point.
####getProblem

Getter for the parent problem of this input.
####getSuffix

Getter for the input suffix.
####hashCode

{@inheritDoc}
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)