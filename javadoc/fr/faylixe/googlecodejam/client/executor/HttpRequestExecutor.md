#HttpRequestExecutor
Package [fr.faylixe.googlecodejam.client.executor](README.md)<br>

> *Object* > [HttpRequestExecutor](HttpRequestExecutor.md)

<p>A {@link HttpRequestExecutor} is an abstraction
 on top of {@link HttpRequestFactory} that handles
 GET and POST request.</p>

##Summary
####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** *Part* | [buildDataPart](#builddatapartstring-string) |
| **public static** *Part* | [buildFilePart](#buildfilepartstring-file) |
| **public static** [HttpRequestExecutor](HttpRequestExecutor.md) | [create](#createstring-string) |
| **public static** [HttpRequestExecutor](HttpRequestExecutor.md) | [create](#createstring) |
| **public** *String* | [get](#getstring) |
| **public** *String* | [getHostname](#gethostname) |
| **public** *HttpRequest* | [getRequest](#getrequeststring) |
| **public** *String* | [post](#poststring-httpcontent) |


##Methods
####buildDataPart(String, String)
> Static factory method that creates a {@link Part} which contains
 simple form data.
> **Parameters**
* name Name of the POST data to create part for.
* data Value of the POST data to create part for.

> **Returns**
* Created data part.


---

####buildFilePart(String, File)
> Static factory method that creates a {@link Part} which contains
 file form data.
> **Parameters**
* name name Name of the POST file data to create part for.
* file File of the POST data to create part for.

> **Returns**
* Created data part.

> **Throws**
* *IOException* If any any error occurs during file type detection.


---

####create(String, String)
> Static factory method that creates a {@link HttpRequestExecutor} instance
 which is set using the given <tt>cookie</tt> for building authenticated
 HTTP request.
> **Parameters**
* hostname Hostname to use for the created executor.
* cookieValue Value of the SACSID cookie to use.

> **Returns**
* Created instance.


---

####create(String)
> Static factory method that creates a non logged
 {@link HttpRequestExecutor} instance.
> **Parameters**
* hostname Hostname to use for the created executor.

> **Returns**
* Created instance.


---

####get(String)
> Performs a HTTP GET request to the given <tt>path</tt>
 relative to the internal target hostname. The response
 is returned as a {@link String}.
> **Parameters**
* path Relative server path to perform request to.

> **Returns**
* Response content of the performed request.

> **Throws**
* *IOException* If any error occurs while performing request.


---

####getHostname()
> Getter for the target hostname.
> **Returns**
* Target hostname this executor is performing request to.


---

####getRequest(String)
> Creates and returns a GET {@link HttpRequest} instance
 for the given <tt>path</tt> over the internal hostname.
> **Parameters**
* path Path of the request to build.

> **Returns**
* Built GET request.

> **Throws**
* *IOException* If any error occurs while creating the GET request.


---

####post(String, HttpContent)
> Performs a HTTP POST request to the given <tt>path</tt>
 relative to the internal target hostname.
> **Parameters**
* path Relative server path to perform request to.
* content POST content that will be sent.

> **Returns**
* Response content of the performed request.

> **Throws**
* *IOException* If any error occurs while performing request.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)