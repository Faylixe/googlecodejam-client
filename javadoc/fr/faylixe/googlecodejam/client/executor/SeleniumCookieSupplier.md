#SeleniumCookieSupplier

Package [fr.faylixe.googlecodejam.client.executor](README.md)<br>
>  > [SeleniumCookieSupplier](SeleniumCookieSupplier.md)

TODO Javadoc
 TODO Cookie expiration parsing
 TODO Login url as parameter ? Function instead of supplier ?.
 
 ISSUE : https://github.com/Faylixe/googlecodejam-client/issues/5

##Summary

####Constructors

* **public** [SeleniumCookieSupplier](#seleniumcookiesupplierstring-java.util.function.supplier)

####Methods

Type and modifiers | Method signature
 --- | --- 
**public** **void** | [cancel](#cancel)
**public** **void** | [checkCurrentState](#checkcurrentstatewebdriver)
**public**  | [get](#get)
**public** **boolean** | [isRunning](#isrunning)


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