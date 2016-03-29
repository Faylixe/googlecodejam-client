#SubmitResponse
Package <a href="README.md"> fr.faylixe.googlecodejam.client.webservice</a><br>

> *java.lang.Object* > <a href="SubmitResponse.md"> SubmitResponse</a>

<p>POJO that aims to be bind to the <tt>SubmitAnswer</tt>
 command request, using Gson API. Contains detail about
 the performed submission.</p>

##Summary
####Constructors
* **public** <a href="#submitresponse"> SubmitResponse</a>()

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public** **int** | <a href="#getinputid"> getInputId</a>() |
| **public** *java.lang.String* | <a href="#getmessage"> getMessage</a>() |
| **public** **int** | <a href="#getproblemid"> getProblemId</a>() |
| **public** **boolean** | <a href="#issuccess"> isSuccess</a>() |

---


##Constructors
####SubmitResponse()
> 


---


##Methods
####getInputId()
> Getter for the submission identifier.

> **Returns**
* Target input identifier of this submission.


---

####getMessage()
> Getter for the information message.

> **Returns**
* Information message about submission.


---

####getProblemId()
> Getter for the problem identifier.

> **Returns**
* Target problem identifier of this submission.


---

####isSuccess()
> Indicates if the submission was successful or not.

> **Returns**
* <tt>true</tt> if this submission was a success, <tt>false</tt> otherwise.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)