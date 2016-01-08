#Round

Package [fr.faylixe.googlecodejam.client](README.md)<br>
> *Object* > [NamedObject](common/NamedObject.md) > [Round](Round.md)

<p>POJO class that represents a Google Jam {@link Round}.
 A {@link Round} is defined by a name, and a dashboard
 URL.</p>

##Summary

####Methods

Type and modifiers | Method signature
 --- | --- 
**public** **boolean** | [equals](#equalsobject)
**public static** *List* | [get](#getelement-string)
**public** *String* | [getContestName](#getcontestname)
**public** *String* | [getURL](#geturl)
**public** **int** | [hashCode](#hashcode)

####Fields



##Fields

####DESCRIPTION_CLASS_NAME


<p>Class name of the HTML description node.</p>
> **public static final** *String*

##Methods

####equals(Object)


{@inheritDoc}
---
####get(Element, String)


<p>Static factory methods that retrieves a list of round
 from the given JSoup <tt>contest</tt> node.</p>
#####Parameters


* contest Root element of the contest in the contest index page.
* parent Parent contest name.

#####Returns


* List of retrieved round.

---
####getContestName()


<p>Getter for the parent contest name.</p>
#####Returns


* Name of the parent contest.

---
####getURL()


<p>Getter for round dashboard URL.</p>
#####Returns


* URL of this round dashboard.

---
####hashCode()


{@inheritDoc}
---
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)