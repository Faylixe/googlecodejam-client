#Request
Package [fr.faylixe.googlecodejam.client.executor](README.md)<br>

> *Object* > [Request](Request.md)

<p>Simple class that exposes string constant
 relative to HTTP API for interacting with
 Code Jam webservice.</p>

##Summary
####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static final** *String* | [createBoundary](#createboundary) |
####Fields

##Fields
####AGENT_PARAMETER
> **public static final** *String*
The <tt>agent</tt> parameter.
---

####AGENT_PARAMETER_NAME
> **public static final** *String*
The <tt>agent</tt> parameter name.
---

####ANALYSIS_COMMAND
> **public static final** *String*
Command used for retrieving contest analysis.
---

####ANSWER_PARAMETER
> **public static final** *String*
The <tt>answer</tt> parameter.
---

####BOUNDARY
> **public static final** *String*
The <tt>boundary</tt> parameter for multipart POST request.
---

####COMMAND_PARAMETER
> **public static final** *String*
The <tt>command</tt> parameter.
---

####COMMAND_PARAMETER_NAME
> **public static final** *String*
The <tt>command</tt> parameter name.
---

####CONTENT_DISPOSITION
> **public static final** *String*
The <tt>content disposition</tt> header name.
---

####CONTEST_INFO
> **public static final** *String*
API Request for retrieving contest info.
---

####COOKIE_NAME
> **public static final** *String*
Name of the identification cookie.
---

####CSRF_PARAMETER
> **public static final** *String*
The <tt>csrfmiddlewaretoken</tt> parameter name.
---

####CSRF_PARAMETER_NAME
> **public static final** *String*
The <tt>csrfmiddlewaretoken</tt> parameter.
---

####DATA_CONTENT_DISPOSITION
> **public static final** *String*
The <tt>content disposition</tt> format for a file part.
---

####DEFAULT_AGENT
> **public static final** *String*
Default agent value to use.
---

####DEFAULT_HOSTNAME
> **public static final** *String*
Default hostname used by this client.
---

####DEFAULT_NUM_SOURCE_FILE
> **public static final** *String*
Default value used for the number of source files.
---

####DO
> **public static final** *String*
API Request for command based action.
---

####DOWNLOAD_COMMAND
> **public static final** *String*
Command used for downloading input file.
---

####FILENAME_PARAMETER
> **public static final** *String*
The <tt>filename</tt> parameter.
---

####FILE_CONTENT_DISPOSITION
> **public static final** *String*
The <tt>content disposition</tt> format for a data part.
---

####INITIAL_VALUES_COMMAND
> **public static final** *String*
Command used for retrieving contest initial values.
---

####INPUT_ID_PARAMETER
> **public static final** *String*
The input identifier parameter.
---

####INPUT_ID_PARAMETER_NAME
> **public static final** *String*
The input identifier parameter name.
---

####MEDIA_TYPE
> **public static final** *String*
Media type used for POST submission request.
---

####NUM_SOURCE_FILE_PARAMETER
> **public static final** *String*
The <tt>number of source files</tt> parameter.
---

####PROBLEM_PARAMETER
> **public static final** *String*
The <tt>problem</tt> parameter.
---

####PROBLEM_PARAMETER_NAME
> **public static final** *String*
The <tt>problem</tt> parameter name.
---

####SOURCE_FILE_PARAMETER
> **public static final** *String*
The <tt>source file</tt> parameter.
---

####SUBMIT_COMMAND
> **public static final** *String*
Command user for submitting solution.
---

####TIME_PARAMETER
> **public static final** *String*
The time parameter.
---

####UNDEFINED
> **public static final** *String*
The <tt>undefined</tt> parameter value.
---


##Methods
####createBoundary()
> Creates and returns a boundary for multipart request.
> **Returns**
* Created boundary.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)