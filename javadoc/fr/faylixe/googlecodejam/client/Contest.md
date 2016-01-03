#Contest

Package [fr.faylixe.googlecodejam.client](README.md)<br>
[Object](../../../java/langObject.md) > [NamedObject](/commonNamedObject.md) > [Contest](Contest.md)

<p>POJO class that represents a Google Jam {@link Contest}.
 A {@link Contest} is represented by a name and a
 collection of {@link Round}.</p>

###Summary


| Type | Method |
| --- | --- | --- |
| **boolean** | equals |
| [List](../../../java/utilList.md) | get |
| [List](../../../java/utilList.md) | getRounds |
| **int** | hashCode |

##Fields


| Type | Field | Description |
| --- | --- | --- |
|  | CONTEST_CLASS_NAME |
|  | CONTEST_INDEX |

##Methods

####equals


{@inheritDoc}
#####Parameter(s)


* object

#####Return


#####Throws


####get


<p>Retrieves and returns a list of available
 contest for the given <tt>hostname</tt>.</p>
#####Parameter(s)


* executor

#####Return


#####Throws


####getRounds


<p>Getter that returns a immutable view
 of the {@link Round} list.</p>
#####Return


#####Throws


####hashCode


{@inheritDoc}
#####Return


#####Throws


---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)