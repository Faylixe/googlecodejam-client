#Resources
Package <a href="README.md"> fr.faylixe.googlecodejam.client.common</a><br>

> *java.lang.Object* > <a href="Resources.md"> Resources</a>

<p>Static toolbox that exposes methods for internal resources managment.</p>

##Summary
####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** *java.lang.String* | <a href="#gethtmltemplate"> getHTMLTemplate</a>() |
| **public static** *java.lang.String* | <a href="#getresourcestring"> getResource</a>(*java.lang.String* path) |
| **public static** *java.io.InputStream* | <a href="#getresourcestreamstring"> getResourceStream</a>(*java.lang.String* path) |
| **public static** *java.lang.String* | <a href="#normalizestring"> normalize</a>(*java.lang.String* name) |

---


##Methods
####getHTMLTemplate()
> Getter for the HTML template content.

> **Returns**
* HTML page template.

> **Throws**
* *java.io.IOException* If any error occurs while reading template content.


---

####getResource(String)
> Reads and returns resources content denoted by the
 given <tt>path</tt>.

> **Parameters**
* path : Paht of the resources to read.

> **Returns**
* Resource content as *java.lang.String*.


---

####getResourceStream(String)
> Reads and returns resources content denoted by the
 given <tt>path</tt>.

> **Parameters**
* path : Path of the resources to read.

> **Returns**
* Resource content as *java.io.InputStream*.


---

####normalize(String)
> Normalizes the given <tt>name</tt> by removing
 all non alphanumeric character.

> **Parameters**
* name : Name to normalize.

> **Returns**
* Normalized name.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)