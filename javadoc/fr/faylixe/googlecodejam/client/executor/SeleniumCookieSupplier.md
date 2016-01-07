#SeleniumCookieSupplier

Package [fr.faylixe.googlecodejam.client.executor](README.md)<br>
> [Object](../../../../java/lang/Object.md) > [SeleniumCookieSupplier](SeleniumCookieSupplier.md)

TODO Javadoc
 TODO Cookie expiration parsing
 TODO Login url as parameter ? Function instead of supplier ?.
 
 ISSUE : https://github.com/Faylixe/googlecodejam-client/issues/5

##Summary

| Constructor |
|  ---  |
SeleniumCookieSupplier | (String, Supplier)

Type | Method
 --- | --- 
**void** | cancel
**void** | checkCurrentState
[String](../../../../java/lang/String.md) | get
**boolean** | isRunning


##Constructors

###SeleniumCookieSupplier(String, Supplier)


Default constructor.
#####Parameters


* target Target URL user should be redirected to.
* driverSupplier Supplier that will create our driver instance to use.

---

##Methods

###cancel()


Cancel the current operation.
---
###checkCurrentState(WebDriver)


Checks the state of the given <tt>driver</tt>,
 ensuring if the required cookie has been settled or not.
#####Parameters


* driver Driver to check state from.

---
###get()


{@inheritDoc}
---
###isRunning()


Indicates if the login process is still running.
#####Returns


* <tt>true</tt> if the selenium instance is still running, <tt>false</tt> otherwise.

---
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)