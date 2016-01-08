#SubmitResponse
Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>

> [SubmitResponse](SubmitResponse.md)*SubmitResponse* > [SubmitResponse](SubmitResponse.md)*SubmitResponse*
<p>POJO that aims to be bind to the <tt>SubmitAnswer</tt>
 command request, using Gson API. Contains detail about
 the performed submission.</p>
##Summary####Constructors
* **public** [SubmitResponse](#submitresponse)
####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public** **boolean** | [equals](#equalsobject) || **public** **int** | [getInputId](#getinputid) || **public** *String* | [getMessage](#getmessage) || **public** **int** | [getProblemId](#getproblemid) || **public** **int** | [hashCode](#hashcode) || **public** **boolean** | [isSuccess](#issuccess) |

##Constructors####SubmitResponse()


---


##Methods####equals(Object)
{@inheritDoc}

---

####getInputId()
Getter for the submission identifier.

#####Returns
* Target input identifier of this submission.

---

####getMessage()
Getter for the information message.

#####Returns
* Information message about submission.

---

####getProblemId()
Getter for the problem identifier.

#####Returns
* Target problem identifier of this submission.

---

####hashCode()
{@inheritDoc}

---

####isSuccess()
Indicates if the submission was successful or not.

#####Returns
* <tt>true</tt> if this submission was a success, <tt>false</tt> otherwise.

---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)