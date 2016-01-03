#HttpRequestExecutor

Package [fr.faylixe.googlecodejam.client.executor](README.md)<br>
> [Object](../../../../java/lang/Object.md) > [HttpRequestExecutor](HttpRequestExecutor.md)

<p>A {@link HttpRequestExecutor} is an abstraction
 on top of {@link HttpRequestFactory} that handles
 GET and POST request.</p>

##Summary


| Type | Method |
| --- | --- | --- |
| [Part](../../../../com/google/api/client/http/Part.md) | buildDataPart |
| [Part](../../../../com/google/api/client/http/Part.md) | buildFilePart |
| [HttpRequestExecutor](HttpRequestExecutor.md) | create |
| [HttpRequestExecutor](HttpRequestExecutor.md) | create |
| [String](../../../../java/lang/String.md) | get |
| [String](../../../../java/lang/String.md) | getHostname |
| [HttpRequest](../../../../com/google/api/client/http/HttpRequest.md) | getRequest |
| [String](../../../../java/lang/String.md) | post |

##Methods

--###buildDataPart


Static factory method that creates a {@link Part} which contains
 simple form data.
#####Parameter(s)


* name
* data

#####Return



--###buildFilePart


Static factory method that creates a {@link Part} which contains
 file form data.
#####Parameter(s)


* name
* file

#####Return


#####Throws

* [IOException](../../../../java/io/IOException.md) If any any error occurs during file type detection.

--###create


Static factory method that creates a {@link HttpRequestExecutor} instance
 which is set using the given <tt>cookie</tt> for building authenticated
 HTTP request.
#####Parameter(s)


* hostname
* cookieValue

#####Return



--###create


Static factory method that creates a non logged
 {@link HttpRequestExecutor} instance.
#####Parameter(s)


* hostname

#####Return



--###get


Performs a HTTP GET request to the given <tt>path</tt>
 relative to the internal target hostname. The response
 is returned as a {@link String}.
#####Parameter(s)


* path

#####Return


#####Throws

* [IOException](../../../../java/io/IOException.md) If any error occurs while performing request.

--###getHostname


Getter for the target hostname.
#####Return



--###getRequest


Creates and returns a GET {@link HttpRequest} instance
 for the given <tt>path</tt> over the internal hostname.
#####Parameter(s)


* path

#####Return


#####Throws

* [IOException](../../../../java/io/IOException.md) If any error occurs while creating the GET request.

--###post


Performs a HTTP POST request to the given <tt>path</tt>
 relative to the internal target hostname.
#####Parameter(s)


* path
* content

#####Return


#####Throws

* [IOException](../../../../java/io/IOException.md) If any error occurs while performing request.

---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)