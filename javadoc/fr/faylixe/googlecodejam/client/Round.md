#Round

Package [fr.faylixe.googlecodejam.client](README.md)<br>
> [Object](../../../java/lang/Object.md) > [NamedObject](/common/NamedObject.md) > [Round](Round.md)

<p>POJO class that represents a Google Jam {@link Round}.
 A {@link Round} is defined by a name, and a dashboard
 URL.</p>

##Summary


| Type | Method |
| --- | --- | --- |
| **boolean** | equals |
| [List](../../../java/util/List.md) | get |
| [String](../../../java/lang/String.md) | getContestName |
| [String](../../../java/lang/String.md) | getURL |
| **int** | hashCode |

##Fields


| Type | Field | Description |
| --- | --- | --- |
|  | DESCRIPTION_CLASS_NAME |

##Methods

###equals


{@inheritDoc}
#####Returns



--
###get


<p>Static factory methods that retrieves a list of round
 from the given JSoup <tt>contest</tt> node.</p>
#####Parameters


> contest Root element of the contest in the contest index page.
> parent Parent contest name.

#####Returns



--
###getContestName


<p>Getter for the parent contest name.</p>
#####Returns



--
###getURL


<p>Getter for round dashboard URL.</p>
#####Returns



--
###hashCode


{@inheritDoc}
#####Returns



--
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)