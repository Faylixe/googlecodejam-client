#HttpRequestExecutor

Package [fr.faylixe.googlecodejam.client.executor](README.md)<br>
[Object](../../../../java/langObject.md) > [HttpRequestExecutor](HttpRequestExecutor.md)

<p>A {@link HttpRequestExecutor} is an abstraction
 on top of {@link HttpRequestFactory} that handles
 GET and POST request.</p>

###Summary


| Type | Method |
| --- | --- | --- |
| [Part](../../../../com/google/api/client/httpPart.md) | buildDataPart |
| [Part](../../../../com/google/api/client/httpPart.md) | buildFilePart |
| [HttpRequestExecutor](HttpRequestExecutor.md) | create |
| [HttpRequestExecutor](HttpRequestExecutor.md) | create |
| [String](../../../../java/langString.md) | get |
| [String](../../../../java/langString.md) | getHostname |
| [HttpRequest](../../../../com/google/api/client/httpHttpRequest.md) | getRequest |
| [String](../../../../java/langString.md) | post |

###Methods

####buildDataPart


Static factory method that creates a {@link Part} which contains
 simple form data.
####buildFilePart


Static factory method that creates a {@link Part} which contains
 file form data.
####create


Static factory method that creates a {@link HttpRequestExecutor} instance
 which is set using the given <tt>cookie</tt> for building authenticated
 HTTP request.
####create


Static factory method that creates a non logged
 {@link HttpRequestExecutor} instance.
####get


Performs a HTTP GET request to the given <tt>path</tt>
 relative to the internal target hostname. The response
 is returned as a {@link String}.
####getHostname


Getter for the target hostname.
####getRequest


Creates and returns a GET {@link HttpRequest} instance
 for the given <tt>path</tt> over the internal hostname.
####post


Performs a HTTP POST request to the given <tt>path</tt>
 relative to the internal target hostname.
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)