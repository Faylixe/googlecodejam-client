#InitialValues
Package <a href="README.md"> fr.faylixe.googlecodejam.client.webservice</a><br>

> *java.lang.Object* > <a href="InitialValues.md"> InitialValues</a>

<p>POJO that aims to be bind to the <tt>GetInitialValues</tt>
 command request, using Gson API.</p>
 
 TODO Ensures seen is not boolean.

##Summary
####Constructors
* **public** <a href="#initialvalues"> InitialValues</a>()

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static** <a href="InitialValues.md"> InitialValues</a> | <a href="#gethttprequestexecutor-round"> get</a>(<a href="../executor/HttpRequestExecutor.md"> HttpRequestExecutor</a> executor, <a href="../Round.md"> Round</a> round) |
| **public** *java.lang.String* | <a href="#getadmin"> getAdmin</a>() |
| **public** **int** | <a href="#getcs"> getCS</a>() |
| **public** *java.lang.String* | <a href="#getemail"> getEmail</a>() |
| **public** *java.lang.String* | <a href="#getinput"> getInput</a>() |
| **public** **long** | <a href="#getleft"> getLeft</a>() |
| **public** *java.lang.String* | <a href="#getloginhtml"> getLoginHTML</a>() |
| **public** *java.lang.String* | <a href="#getlogouthtml"> getLogoutHTML</a>() |
| **public** *java.lang.String* | <a href="#getname"> getName</a>() |
| **public** **int** | <a href="#getseen"> getSeen</a>() |
| **public** *java.lang.String* | <a href="#getsnippet"> getSnippet</a>() |
| **public** **long** | <a href="#getstart"> getStart</a>() |
| **public** *java.lang.String* | <a href="#gettoken"> getToken</a>() |
| **public** *java.lang.String* | <a href="#geturlencodedtoken"> getURLEncodedToken</a>() |
| **public** **long** | <a href="#getuntilstart"> getUntilStart</a>() |
| **public** **int** | <a href="#getversion"> getVersion</a>() |
| **public** **boolean** | <a href="#islogged"> isLogged</a>() |
| **public** **boolean** | <a href="#isqualified"> isQualified</a>() |

---


##Constructors
####InitialValues()
> 


---


##Methods
####get(HttpRequestExecutor, Round)
> Static factory method that use the <tt>GetInitialValues</tt> command
 for the given <tt>round</tt> to retrieve a valud <a href="InitialValues.md"> InitialValues</a> instance.

> **Parameters**
* executor : Executor instance to use for performing the associated request.
* round : Round to extract initial values from.

> **Returns**
* Created instance from request.

> **Throws**
* *java.io.IOException* If any error occurs during the associated HTTP request.


---

####getAdmin()
> 

> **Returns**
* To document


---

####getCS()
> 

> **Returns**
* To document


---

####getEmail()
> Getter for the user email.

> **Returns**
* Email of this logged user.


---

####getInput()
> 

> **Returns**
* To document


---

####getLeft()
> Getter for the time left.

> **Returns**
* Time left before contest finish (in second).


---

####getLoginHTML()
> Getter for the login HTML.

> **Returns**
* HTML that contains the link of the login page.


---

####getLogoutHTML()
> Getter for the logout HTML.

> **Returns**
* HTML that contains the link of the logout page.


---

####getName()
> Getter for the contest name.

> **Returns**
* Current contest name.


---

####getSeen()
> 

> **Returns**
* To document


---

####getSnippet()
> 

> **Returns**
* To document


---

####getStart()
> Getter for the start date.

> **Returns**
* Date of the contest start.


---

####getToken()
> 

> **Returns**
* Middleware token that is created when first call <tt>GetInitialValues</tt> command.


---

####getURLEncodedToken()
> Returns an URL encoded form of the middle ware token.

> **Returns**
* Middleware token in an URL encoded form.

> **Throws**
* *java.io.UnsupportedEncodingException* If target encoding is not supported.


---

####getUntilStart()
> Getter for the time left.

> **Returns**
* Amout of time until this contest start.


---

####getVersion()
> Getter for the contest version.

> **Returns**
* Contest version.


---

####isLogged()
> Indicates if user is currently logged in.

> **Returns**
* <tt>true</tt> if user is logged in, <tt>false</tt> otherwise.


---

####isQualified()
> Indicates if the currently logged user
 is qualified for the next round.

> **Returns**
* <tt>true</tt> if the currently logged user is qualified for the next round, <tt>false</tt> otherwise.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)