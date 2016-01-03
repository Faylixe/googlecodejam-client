#Resources

Package [fr.faylixe.googlecodejam.client.common](README.md)<br>
> [Object](../../../../java/lang/Object.md) > [Resources](Resources.md)

<p>Static toolbox that exposes methods for internal resources managment.</p>

##Summary


| Type | Method |
| --- | --- | --- |
| [String](../../../../java/lang/String.md) | getHTMLTemplate |
| [String](../../../../java/lang/String.md) | getResource |
| [InputStream](../../../../java/io/InputStream.md) | getResourceStream |
| [String](../../../../java/lang/String.md) | normalize |

##Methods

###getHTMLTemplate


Getter for the HTML template content.
#####Return


#####Throws

* IOException : If any error occurs while reading template content.
###getResource


Reads and returns resources content denoted by the
 given <tt>path</tt>.
#####Parameter(s)


* path

#####Return



###getResourceStream


Reads and returns resources content denoted by the
 given <tt>path</tt>.
#####Parameter(s)


* path

#####Return



###normalize


Normalizes the given <tt>name</tt> by removing
 all non alphanumeric character.
#####Parameter(s)


* name

#####Return



---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)