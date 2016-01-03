#InitialValues

Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>
> [Object](../../../../java/lang/Object.md) > [InitialValues](InitialValues.md)

<p>POJO that aims to be bind to the <tt>GetInitialValues</tt>
 command request, using Gson API.</p>
 
 TODO Ensures seen is not boolean.

##Summary


| Type | Method |
| --- | --- | --- |
| [InitialValues](InitialValues.md) | get |
| [String](../../../../java/lang/String.md) | getAdmin |
| **int** | getCS |
| [String](../../../../java/lang/String.md) | getEmail |
| [String](../../../../java/lang/String.md) | getInput |
| **long** | getLeft |
| [String](../../../../java/lang/String.md) | getLoginHTML |
| [String](../../../../java/lang/String.md) | getLogoutHTML |
| [String](../../../../java/lang/String.md) | getName |
| **int** | getSeen |
| [String](../../../../java/lang/String.md) | getSnippet |
| **long** | getStart |
| [String](../../../../java/lang/String.md) | getToken |
| [String](../../../../java/lang/String.md) | getURLEncodedToken |
| **long** | getUntilStart |
| **int** | getVersion |
| **boolean** | isLogged |
| **boolean** | isQualified |

##Methods

###get


Static factory method that use the <tt>GetInitialValues</tt> command
 for the given <tt>round</tt> to retrieve a valud {@link InitialValues} instance.
#####Parameters


* executor Executor instance to use for performing the associated request.
* round Round to extract initial values from.

#####Returns


#####Throws

* [IOException](../../../../java/io/IOException.md) If any error occurs during the associated HTTP request.

--
###getAdmin



#####Returns



--
###getCS



#####Returns



--
###getEmail


Getter for the user email.
#####Returns



--
###getInput



#####Returns



--
###getLeft


Getter for the time left.
#####Returns



--
###getLoginHTML


Getter for the login HTML.
#####Returns



--
###getLogoutHTML


Getter for the logout HTML.
#####Returns



--
###getName


Getter for the contest name.
#####Returns



--
###getSeen



#####Returns



--
###getSnippet



#####Returns



--
###getStart


Getter for the start date.
#####Returns



--
###getToken



#####Returns



--
###getURLEncodedToken


Returns an URL encoded form of the middle ware token.
#####Returns


#####Throws

* [UnsupportedEncodingException](../../../../java/io/UnsupportedEncodingException.md) If target encoding is not supported.

--
###getUntilStart


Getter for the time left.
#####Returns



--
###getVersion


Getter for the contest version.
#####Returns



--
###isLogged


Indicates if user is currently logged in.
#####Returns



--
###isQualified


Indicates if the currently logged user
 is qualified for the next round.
#####Returns



--
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)