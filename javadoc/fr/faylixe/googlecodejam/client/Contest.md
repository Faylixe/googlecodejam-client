#Contest

Package [fr.faylixe.googlecodejam.client](README.md)<br>
> [Object](../../../java/lang/Object.md) > [NamedObject](/common/NamedObject.md) > [Contest](Contest.md)

<p>POJO class that represents a Google Jam {@link Contest}.
 A {@link Contest} is represented by a name and a
 collection of {@link Round}.</p>

##Summary


| Type | Method |
| --- | --- | --- |
| **boolean** | equals |
| [List](../../../java/util/List.md) | get |
| [List](../../../java/util/List.md) | getRounds |
| **int** | hashCode |

##Fields


| Type | Field | Description |
| --- | --- | --- |
|  | CONTEST_CLASS_NAME |
|  | CONTEST_INDEX |

##Methods

###equals


{@inheritDoc}
#####Parameter(s)


* object

#####Return



--
###get


<p>Retrieves and returns a list of available
 contest for the given <tt>hostname</tt>.</p>
#####Parameter(s)


* executor

#####Return


#####Throws

* [IOException](../../../java/io/IOException.md) If any error occurs during contest extraction process.

--
###getRounds


<p>Getter that returns a immutable view
 of the {@link Round} list.</p>
#####Return



--
###hashCode


{@inheritDoc}
#####Return



--
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)