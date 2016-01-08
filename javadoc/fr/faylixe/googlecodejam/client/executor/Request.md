#Request
Package [fr.faylixe.googlecodejam.client.executor](README.md)<br>

> *Object* > [Request](Request.md)*Request*

<p>Simple class that exposes string constant
 relative to HTTP API for interacting with
 Code Jam webservice.</p>

##Summary
####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static final** *String* | [createBoundary](#createboundary) |
####Fields

##Fields####AGENT_PARAMETER
The <tt>agent</tt> parameter.
> **public static final** *String*

####AGENT_PARAMETER_NAME
The <tt>agent</tt> parameter name.
> **public static final** *String*

####ANALYSIS_COMMAND
Command used for retrieving contest analysis.
> **public static final** *String*

####ANSWER_PARAMETER
The <tt>answer</tt> parameter.
> **public static final** *String*

####BOUNDARY
The <tt>boundary</tt> parameter for multipart POST request.
> **public static final** *String*

####COMMAND_PARAMETER
The <tt>command</tt> parameter.
> **public static final** *String*

####COMMAND_PARAMETER_NAME
The <tt>command</tt> parameter name.
> **public static final** *String*

####CONTENT_DISPOSITION
The <tt>content disposition</tt> header name.
> **public static final** *String*

####CONTEST_INFO
API Request for retrieving contest info.
> **public static final** *String*

####COOKIE_NAME
Name of the identification cookie.
> **public static final** *String*

####CSRF_PARAMETER
The <tt>csrfmiddlewaretoken</tt> parameter name.
> **public static final** *String*

####CSRF_PARAMETER_NAME
The <tt>csrfmiddlewaretoken</tt> parameter.
> **public static final** *String*

####DATA_CONTENT_DISPOSITION
The <tt>content disposition</tt> format for a file part.
> **public static final** *String*

####DEFAULT_AGENT
Default agent value to use.
> **public static final** *String*

####DEFAULT_HOSTNAME
Default hostname used by this client.
> **public static final** *String*

####DEFAULT_NUM_SOURCE_FILE
Default value used for the number of source files.
> **public static final** *String*

####DO
API Request for command based action.
> **public static final** *String*

####DOWNLOAD_COMMAND
Command used for downloading input file.
> **public static final** *String*

####FILENAME_PARAMETER
The <tt>filename</tt> parameter.
> **public static final** *String*

####FILE_CONTENT_DISPOSITION
The <tt>content disposition</tt> format for a data part.
> **public static final** *String*

####INITIAL_VALUES_COMMAND
Command used for retrieving contest initial values.
> **public static final** *String*

####INPUT_ID_PARAMETER
The input identifier parameter.
> **public static final** *String*

####INPUT_ID_PARAMETER_NAME
The input identifier parameter name.
> **public static final** *String*

####MEDIA_TYPE
Media type used for POST submission request.
> **public static final** *String*

####NUM_SOURCE_FILE_PARAMETER
The <tt>number of source files</tt> parameter.
> **public static final** *String*

####PROBLEM_PARAMETER
The <tt>problem</tt> parameter.
> **public static final** *String*

####PROBLEM_PARAMETER_NAME
The <tt>problem</tt> parameter name.
> **public static final** *String*

####SOURCE_FILE_PARAMETER
The <tt>source file</tt> parameter.
> **public static final** *String*

####SUBMIT_COMMAND
Command user for submitting solution.
> **public static final** *String*

####TIME_PARAMETER
The time parameter.
> **public static final** *String*

####UNDEFINED
The <tt>undefined</tt> parameter value.
> **public static final** *String*


##Methods####createBoundary()
Creates and returns a boundary for multipart request.

#####Returns
* Created boundary.

---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)