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

##Methods

####get


Static factory method that use the <tt>GetInitialValues</tt> command
 for the given <tt>round</tt> to retrieve a valud {@link InitialValues} instance.
#####Parameter(s)


* executor
* round

#####Return


#####Throws


####getAdmin



#####Return


#####Throws


####getCS



#####Return


#####Throws


####getEmail


Getter for the user email.
#####Return


#####Throws


####getInput



#####Return


#####Throws


####getLeft


Getter for the time left.
#####Return


#####Throws


####getLoginHTML


Getter for the login HTML.
#####Return


#####Throws


####getLogoutHTML


Getter for the logout HTML.
#####Return


#####Throws


####getName


Getter for the contest name.
#####Return


#####Throws


####getSeen



#####Return


#####Throws


####getSnippet



#####Return


#####Throws


####getStart


Getter for the start date.
#####Return


#####Throws


####getToken



#####Return


#####Throws


####getURLEncodedToken


Returns an URL encoded form of the middle ware token.
#####Return


#####Throws


####getUntilStart


Getter for the time left.
#####Return


#####Throws


####getVersion


Getter for the contest version.
#####Return


#####Throws


####isLogged


Indicates if user is currently logged in.
#####Return


#####Throws


####isQualified


Indicates if the currently logged user
 is qualified for the next round.
#####Return


#####Throws


---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)