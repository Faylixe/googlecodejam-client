#Class SubmitResponse
Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>

> *java.lang.Object* > [SubmitResponse](SubmitResponse.md)



POJO that aims to be bind to the <tt>SubmitAnswer</tt>
 command request, using Gson API. Contains detail about
 the performed submission.


##Summary
####Constructors
| Visibility | Signature |
| --- | --- |
| **public** | [SubmitResponse](#submitresponse)() |

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public** **int** | [getInputId](#getinputid)() |
| **public** *java.lang.String* | [getMessage](#getmessage)() |
| **public** **int** | [getProblemId](#getproblemid)() |
| **public** **boolean** | [isSuccess](#issuccess)() |

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