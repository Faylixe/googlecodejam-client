#SubmitResponse

Package [fr.faylixe.googlecodejam.client.webservice](README.md)<br>
> [Object](../../../../java/lang/Object.md) > [SubmitResponse](SubmitResponse.md)

<p>POJO that aims to be bind to the <tt>SubmitAnswer</tt>
 command request, using Gson API. Contains detail about
 the performed submission.</p>

##Summary

| Constructor |
|  ---  |

Type | Method
 --- | --- 
**int** | getInputId
[String](../../../../java/lang/String.md) | getMessage
**int** | getProblemId
**boolean** | isSuccess


##Constructors

###()



---

##Methods

###equals(Object)


{@inheritDoc}
---
###getInputId()


Getter for the submission identifier.
#####Returns


* Target input identifier of this submission.

---
###getMessage()


Getter for the information message.
#####Returns


* Information message about submission.

---
###getProblemId()


Getter for the problem identifier.
#####Returns


* Target problem identifier of this submission.

---
###hashCode()


{@inheritDoc}
---
###isSuccess()


Indicates if the submission was successful or not.
#####Returns


* <tt>true</tt> if this submission was a success, <tt>false</tt> otherwise.

---
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)