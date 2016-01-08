#InitialValues

Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>
>  > [InitialValues](InitialValues.md)

<p>POJO that aims to be bind to the <tt>GetInitialValues</tt>
 command request, using Gson API.</p>
 
 TODO Ensures seen is not boolean.

##Summary

####Constructors

* **public** [InitialValues](#initialvalues)

####Methods

Type and modifiers | Method signature
 --- | --- 
**public static** [InitialValues](InitialValues.md) | [get](#gethttprequestexecutor-round)
**public**  | [getAdmin](#getadmin)
**public** **int** | [getCS](#getcs)
**public**  | [getEmail](#getemail)
**public**  | [getInput](#getinput)
**public** **long** | [getLeft](#getleft)
**public**  | [getLoginHTML](#getloginhtml)
**public**  | [getLogoutHTML](#getlogouthtml)
**public**  | [getName](#getname)
**public** **int** | [getSeen](#getseen)
**public**  | [getSnippet](#getsnippet)
**public** **long** | [getStart](#getstart)
**public**  | [getToken](#gettoken)
**public**  | [getURLEncodedToken](#geturlencodedtoken)
**public** **long** | [getUntilStart](#getuntilstart)
**public** **int** | [getVersion](#getversion)
**public** **boolean** | [isLogged](#islogged)
**public** **boolean** | [isQualified](#isqualified)


##Constructors

###InitialValues()



---

##Methods

###get(HttpRequestExecutor, Round)


Static factory method that use the <tt>GetInitialValues</tt> command
 for the given <tt>round</tt> to retrieve a valud {@link InitialValues} instance.
#####Parameters


* executor Executor instance to use for performing the associated request.
* round Round to extract initial values from.

#####Returns


* Created instance from request.

#####Throws

*  If any error occurs during the associated HTTP request.

---
###getAdmin()



#####Returns


* To document

---
###getCS()



#####Returns


* To document

---
###getEmail()


Getter for the user email.
#####Returns


* Email of this logged user.

---
###getInput()



#####Returns


* To document

---
###getLeft()


Getter for the time left.
#####Returns


* Time left before contest finish (in second).

---
###getLoginHTML()


Getter for the login HTML.
#####Returns


* HTML that contains the link of the login page.

---
###getLogoutHTML()


Getter for the logout HTML.
#####Returns


* HTML that contains the link of the logout page.

---
###getName()


Getter for the contest name.
#####Returns


* Current contest name.

---
###getSeen()



#####Returns


* To document

---
###getSnippet()



#####Returns


* To document

---
###getStart()


Getter for the start date.
#####Returns


* Date of the contest start.

---
###getToken()



#####Returns


* Middleware token that is created when first call <tt>GetInitialValues</tt> command.

---
###getURLEncodedToken()


Returns an URL encoded form of the middle ware token.
#####Returns


* Middleware token in an URL encoded form.

#####Throws

*  If target encoding is not supported.

---
###getUntilStart()


Getter for the time left.
#####Returns


* Amout of time until this contest start.

---
###getVersion()


Getter for the contest version.
#####Returns


* Contest version.

---
###isLogged()


Indicates if user is currently logged in.
#####Returns


* <tt>true</tt> if user is logged in, <tt>false</tt> otherwise.

---
###isQualified()


Indicates if the currently logged user
 is qualified for the next round.
#####Returns


* <tt>true</tt> if the currently logged user is qualified for the next round, <tt>false</tt> otherwise.

---
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)