#HttpRequestExecutor
Package <a href="README.md"> fr.faylixe.googlecodejam.client.executor</a><br>

> *java.lang.Object* > <a href="HttpRequestExecutor.md"> HttpRequestExecutor</a>

<p>A <a href="HttpRequestExecutor.md"> HttpRequestExecutor</a> is an abstraction
 on top of *com.google.api.client.http.HttpRequestFactory* that handles
 GET and POST request.</p>

##Summary
####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** *com.google.api.client.http.MultipartContent.Part* | <a href="#builddatapartstring-string"> buildDataPart</a>(*java.lang.String* name, *java.lang.String* data) |
| **public static** *com.google.api.client.http.MultipartContent.Part* | <a href="#buildfilepartstring-file"> buildFilePart</a>(*java.lang.String* name, *java.io.File* file) |
| **public static** <a href="HttpRequestExecutor.md"> HttpRequestExecutor</a> | <a href="#createstring-string"> create</a>(*java.lang.String* hostname, *java.lang.String* cookieValue) |
| **public static** <a href="HttpRequestExecutor.md"> HttpRequestExecutor</a> | <a href="#createstring"> create</a>(*java.lang.String* hostname) |
| **public** *java.lang.String* | <a href="#getstring"> get</a>(*java.lang.String* path) |
| **public** *java.lang.String* | <a href="#gethostname"> getHostname</a>() |
| **public** *com.google.api.client.http.HttpRequest* | <a href="#getrequeststring"> getRequest</a>(*java.lang.String* path) |
| **public** *java.lang.String* | <a href="#poststring-httpcontent"> post</a>(*java.lang.String* path, *com.google.api.client.http.HttpContent* content) |

---


##Methods
####buildDataPart(String, String)
> Static factory method that creates a *com.google.api.client.http.MultipartContent.Part* which contains
 simple form data.

> **Parameters**
* name : Name of the POST data to create part for.
* data : Value of the POST data to create part for.

> **Returns**
* Created data part.


---

####buildFilePart(String, File)
> Static factory method that creates a *com.google.api.client.http.MultipartContent.Part* which contains
 file form data.

> **Parameters**
* name : name Name of the POST file data to create part for.
* file : File of the POST data to create part for.

> **Returns**
* Created data part.

> **Throws**
* *java.io.IOException* If any any error occurs during file type detection.


---

####create(String, String)
> Static factory method that creates a <a href="HttpRequestExecutor.md"> HttpRequestExecutor</a> instance
 which is set using the given <tt>cookie</tt> for building authenticated
 HTTP request.

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
> Static factory method that creates a non logged
 <a href="HttpRequestExecutor.md"> HttpRequestExecutor</a> instance.

> **Parameters**
* hostname : Hostname to use for the created executor.

> **Returns**
* Created instance.

> **Throws**
* *java.io.IOException* If any error occurs while creating http client.
* *java.security.GeneralSecurityException* If any error occurs while creating http client.


---

####get(String)
> Performs a HTTP GET request to the given <tt>path</tt>
 relative to the internal target hostname. The response
 is returned as a *java.lang.String*.

> **Parameters**
* path : Relative server path to perform request to.

> **Returns**
* Response content of the performed request.

> **Throws**
* *java.io.IOException* If any error occurs while performing request.


---

####getHostname()
> Getter for the target hostname.

> **Returns**
* Target hostname this executor is performing request to.


---

####getRequest(String)
> Creates and returns a GET *com.google.api.client.http.HttpRequest* instance
 for the given <tt>path</tt> over the internal hostname.

> **Parameters**
* path : Path of the request to build.

> **Returns**
* Built GET request.

> **Throws**
* *java.io.IOException* If any error occurs while creating the GET request.


---

####post(String, HttpContent)
> Performs a HTTP POST request to the given <tt>path</tt>
 relative to the internal target hostname.

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