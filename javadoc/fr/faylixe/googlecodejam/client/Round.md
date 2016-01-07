#Round

Package [fr.faylixe.googlecodejam.client](README.md)<br>
> [Object](../../../ava/lang/Object.md) > [NamedObject](common/NamedObject.md) > [Round](Round.md)

<p>POJO class that represents a Google Jam {@link Round}.
 A {@link Round} is defined by a name, and a dashboard
 URL.</p>

##Summary

####Methods

Type | Method
 --- | --- 
**public****boolean** | equals
**public static**[List](../../../ava/util/List.md) | get
**public**[String](../../../ava/lang/String.md) | getContestName
**public**[String](../../../ava/lang/String.md) | getURL
**public****int** | hashCode

Type | Name | Description
 --- | --- | --- 


##Fields


##Methods

###equals(Object)


{@inheritDoc}
---
###get(Element, String)


<p>Static factory methods that retrieves a list of round
 from the given JSoup <tt>contest</tt> node.</p>
#####Parameters


* contest Root element of the contest in the contest index page.
* parent Parent contest name.

#####Returns


* List of retrieved round.

---
###getContestName()


<p>Getter for the parent contest name.</p>
#####Returns


* Name of the parent contest.

---
###getURL()


<p>Getter for round dashboard URL.</p>
#####Returns


* URL of this round dashboard.

---
###hashCode()


{@inheritDoc}
---
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)