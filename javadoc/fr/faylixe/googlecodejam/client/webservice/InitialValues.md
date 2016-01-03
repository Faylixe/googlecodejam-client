#InitialValues

Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>
[Object](../../../../java/langObject.md) > [InitialValues](InitialValues.md)

<p>POJO that aims to be bind to the <tt>GetInitialValues</tt>
 command request, using Gson API.</p>
 
 TODO Ensures seen is not boolean.

###Summary


| Type | Method |
| --- | --- | --- |
| [InitialValues](InitialValues.md) | get |
| [String](../../../../java/langString.md) | getAdmin |
| **int** | getCS |
| [String](../../../../java/langString.md) | getEmail |
| [String](../../../../java/langString.md) | getInput |
| **long** | getLeft |
| [String](../../../../java/langString.md) | getLoginHTML |
| [String](../../../../java/langString.md) | getLogoutHTML |
| [String](../../../../java/langString.md) | getName |
| **int** | getSeen |
| [String](../../../../java/langString.md) | getSnippet |
| **long** | getStart |
| [String](../../../../java/langString.md) | getToken |
| [String](../../../../java/langString.md) | getURLEncodedToken |
| **long** | getUntilStart |
| **int** | getVersion |
| **boolean** | isLogged |
| **boolean** | isQualified |

###Methods

####get


Static factory method that use the <tt>GetInitialValues</tt> command
 for the given <tt>round</tt> to retrieve a valud {@link InitialValues} instance.
####getAdmin



####getCS



####getEmail


Getter for the user email.
####getInput



####getLeft


Getter for the time left.
####getLoginHTML


Getter for the login HTML.
####getLogoutHTML


Getter for the logout HTML.
####getName


Getter for the contest name.
####getSeen



####getSnippet



####getStart


Getter for the start date.
####getToken



####getURLEncodedToken


Returns an URL encoded form of the middle ware token.
####getUntilStart


Getter for the time left.
####getVersion


Getter for the contest version.
####isLogged


Indicates if user is currently logged in.
####isQualified


Indicates if the currently logged user
 is qualified for the next round.
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)