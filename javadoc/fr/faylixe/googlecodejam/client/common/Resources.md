#Resources
Package [fr.faylixe.googlecodejam.client.common](README.md)<br>

> *Object* > [Resources](Resources.md)*Resources*

<p>Static toolbox that exposes methods for internal resources managment.</p>

##Summary
####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** *String* | [getHTMLTemplate](#gethtmltemplate) || **public static** *String* | [getResource](#getresourcestring) || **public static** *InputStream* | [getResourceStream](#getresourcestreamstring) || **public static** *String* | [normalize](#normalizestring) |

##Methods####getHTMLTemplate()
Getter for the HTML template content.

#####Returns
* HTML page template.

#####Throws* *IOException* If any error occurs while reading template content.

---

####getResource(String)
Reads and returns resources content denoted by the
 given <tt>path</tt>.

#####Parameters
* path Paht of the resources to read.

#####Returns
* Resource content as {@link String}.

---

####getResourceStream(String)
Reads and returns resources content denoted by the
 given <tt>path</tt>.

#####Parameters
* path Path of the resources to read.

#####Returns
* Resource content as {@link InputStream}.

---

####normalize(String)
Normalizes the given <tt>name</tt> by removing
 all non alphanumeric character.

#####Parameters
* name Name to normalize.

#####Returns
* Normalized name.

---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)