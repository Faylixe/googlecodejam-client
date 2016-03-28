#Resources
Package [fr.faylixe.googlecodejam.client.common](README.md)<br>

> *java.lang.Object* > [Resources](Resources.md)



##Summary
####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** *java.lang.String* | [getHTMLTemplate](#gethtmltemplate)() |
| **public static** *java.lang.String* | [getResource](#getresourcestring)(*java.lang.String* path) |
| **public static** *java.io.InputStream* | [getResourceStream](#getresourcestreamstring)(*java.lang.String* path) |
| **public static** *java.lang.String* | [normalize](#normalizestring)(*java.lang.String* name) |

---


##Methods
####getHTMLTemplate()
> 

> **Returns**
* HTML page template.

> **Throws**
* *java.io.IOException* If any error occurs while reading template content.


---

####getResource(String)
> 

> **Parameters**
* path : Paht of the resources to read.

> **Returns**
* Resource content as {@link String}.


---

####getResourceStream(String)
> 

> **Parameters**
* path : Path of the resources to read.

> **Returns**
* Resource content as {@link InputStream}.


---

####normalize(String)
> 

> **Parameters**
* name : Name to normalize.

> **Returns**
* Normalized name.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)