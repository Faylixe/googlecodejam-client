#ProblemInput

Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>
[Object](../../../../java/lang/Object.md) > [NamedObject](common/NamedObject.md) > [ProblemInput](ProblemInput.md)

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
#####Parameter(s)


* object

#####Return


#####Throws


###getDifficulty


Getter for the problem input difficulty.
#####Return


#####Throws


###getNumber


Getter for the problem input number.
#####Return


#####Throws


###getPoints


Getter for the input number of point.
#####Return


#####Throws


###getProblem


Getter for the parent problem of this input.
#####Return


#####Throws


###getSuffix


Getter for the input suffix.
#####Return


#####Throws


###hashCode


{@inheritDoc}
#####Return


#####Throws


---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)