#HttpRequestExecutor
Package [fr.faylixe.googlecodejam.client.executor](README.md)<br>

> *java.lang.Object* > [HttpRequestExecutor](HttpRequestExecutor.md)

[HttpRequestExecutor](HttpRequestExecutor.md)*com.google.api.client.http.HttpRequestFactory*

##Summary
####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** *com.google.api.client.http.MultipartContent.Part* | [buildDataPart](#builddatapartstring-string)(*java.lang.String* name, *java.lang.String* data) |
| **public static** *com.google.api.client.http.MultipartContent.Part* | [buildFilePart](#buildfilepartstring-file)(*java.lang.String* name, *java.io.File* file) |
| **public static** [HttpRequestExecutor](HttpRequestExecutor.md) | [create](#createstring-string)(*java.lang.String* hostname, *java.lang.String* cookieValue) |
| **public static** [HttpRequestExecutor](HttpRequestExecutor.md) | [create](#createstring)(*java.lang.String* hostname) |
| **public** *java.lang.String* | [get](#getstring)(*java.lang.String* path) |
| **public** *java.lang.String* | [getHostname](#gethostname)() |
| **public** *com.google.api.client.http.HttpRequest* | [getRequest](#getrequeststring)(*java.lang.String* path) |
| **public** *java.lang.String* | [post](#poststring-httpcontent)(*java.lang.String* path, *com.google.api.client.http.HttpContent* content) |

---


##Methods
####buildDataPart(String, String)
> *com.google.api.client.http.MultipartContent.Part*

> **Parameters**
* name : Name of the POST data to create part for.
* data : Value of the POST data to create part for.

> **Returns**
* Created data part.


---

####buildFilePart(String, File)
> *com.google.api.client.http.MultipartContent.Part*

> **Parameters**
* name : name Name of the POST file data to create part for.
* file : File of the POST data to create part for.

> **Returns**
* Created data part.

> **Throws**
* *java.io.IOException* If any any error occurs during file type detection.


---

####create(String, String)
> [HttpRequestExecutor](HttpRequestExecutor.md)

> **Parameters**
* hostname : Hostname to use for the created executor.
* cookieValue : Value of the SACSID cookie to use.

> **Returns**
* Created instance.

> **Throws**
* *java.io.IOException* If any error occurs while creating http client.
* *java.security.GeneralSecurityException* If any error occurs while creating http client.


---

####create(String)
> [HttpRequestExecutor](HttpRequestExecutor.md)

> **Parameters**
* hostname : Hostname to use for the created executor.

> **Returns**
* Created instance.

> **Throws**
* *java.io.IOException* If any error occurs while creating http client.
* *java.security.GeneralSecurityException* If any error occurs while creating http client.


---

####get(String)
> *java.lang.String*

> **Parameters**
* path : Relative server path to perform request to.

> **Returns**
* Response content of the performed request.

> **Throws**
* *java.io.IOException* If any error occurs while performing request.


---

####getHostname()
> 

> **Returns**
* Target hostname this executor is performing request to.


---

####getRequest(String)
> *com.google.api.client.http.HttpRequest*

> **Parameters**
* path : Path of the request to build.

> **Returns**
* Built GET request.

> **Throws**
* *java.io.IOException* If any error occurs while creating the GET request.


---

####post(String, HttpContent)
> 

> **Parameters**
* path : Relative server path to perform request to.
* content : POST content that will be sent.

> **Returns**
* Response content of the performed request.

> **Throws**
* *java.io.IOException* If any error occurs while performing request.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)