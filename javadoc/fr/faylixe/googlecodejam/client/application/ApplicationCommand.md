#ApplicationCommand

Package [fr.faylixe.googlecodejam.client.application](README.md)<br>
> [Object](../../../../java/lang/Object.md) > [ApplicationCommand](ApplicationCommand.md)

<p>This class contains static method that are
 executed from parsed command line argument in
 {@link Application}.</p>

##Summary

| Constructor |
|  ---  |
Type | Method
 --- | --- 
**boolean** | download
**boolean** | init
**boolean** | submit

##Constructors

###()



---

##Methods

###download(CommandLine)


Downloads an input file, from the given user <tt>command</tt>.
 Retrieves the contextual session if exist, and if so, then
 the download method is used on the loaded session. If the
 file already exist, it will be removed first before downloading.
#####Parameters


* command User command line.

#####Returns


* <tt>true</tt> if the command was executed successfully, <tt>false</tt> otherwise.

---
###init()


Methods that is bound to the INIT command. Starts
 firefox through selenium to retrieve cookie instance
 and prompts user for the contextual round to use.
#####Returns


* <tt>true</tt> if the init command was correctly executed, <tt>false</tt> otherwise.

---
###submit(CommandLine)


Performs an output file submission using the <tt>SubmitAnswer</tt>
 command. Retrieves the contextual session if exist, and if so, then
 the submit method is used on the loaded session.
#####Parameters


* command User command line.

#####Returns


* <tt>true</tt> if the command was executed successfully, <tt>false</tt> otherwise.

---
---
[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)