#ProblemInput

Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>
> [Object](../../../../java/lang/Object.md) > [NamedObject](common/NamedObject.md) > [ProblemInput](ProblemInput.md)

<p>POJO that aims to be bind to the <tt>/ContestInfo</tt>
 request, using Gson API. {@link ProblemInput} instance belong
 to a {@link Problem} object, and describes input submission
 available for a given {@link Problem}.</p>

##Summary


| Type | Method |
| --- | --- | --- |
| **boolean** | equals |
| **int** | getDifficulty |
| **int** | getNumber |
| **int** | getPoints |
| [Problem](Problem.md) | getProblem |
| [String](../../../../java/lang/String.md) | getSuffix |
| **int** | hashCode |

##Fields


| Type | Field | Description |
| --- | --- | --- |
|  | LARGE |
|  | SMALL |

##Methods

###equals


{@inheritDoc}
#####Returns



--
###getDifficulty


Getter for the problem input difficulty.
#####Returns



--
###getNumber


Getter for the problem input number.
#####Returns



--
###getPoints


Getter for the input number of point.
#####Returns



--
###getProblem


Getter for the parent problem of this input.
#####Returns



--
###getSuffix


Getter for the input suffix.
#####Returns



--
###hashCode


{@inheritDoc}
#####Returns



--
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)