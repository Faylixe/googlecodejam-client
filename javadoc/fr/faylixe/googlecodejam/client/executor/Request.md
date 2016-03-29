#Class Request
Package [fr.faylixe.googlecodejam.client.executor](README.md)<br>

> *java.lang.Object* > [Request](Request.md)



Simple class that exposes string constant
 relative to HTTP API for interacting with
 Code Jam webservice.


##Summary
####Fields
| Type and modifiers | Field name |
| --- | --- |
| **public static final** | [AGENT_PARAMETER](#agent_parameter) |
| **public static final** | [AGENT_PARAMETER_NAME](#agent_parameter_name) |
| **public static final** | [ANALYSIS_COMMAND](#analysis_command) |
| **public static final** | [ANSWER_PARAMETER](#answer_parameter) |
| **public static final** | [BOUNDARY](#boundary) |
| **public static final** | [COMMAND_PARAMETER](#command_parameter) |
| **public static final** | [COMMAND_PARAMETER_NAME](#command_parameter_name) |
| **public static final** | [CONTENT_DISPOSITION](#content_disposition) |
| **public static final** | [CONTEST_INFO](#contest_info) |
| **public static final** | [COOKIE_NAME](#cookie_name) |
| **public static final** | [CSRF_PARAMETER](#csrf_parameter) |
| **public static final** | [CSRF_PARAMETER_NAME](#csrf_parameter_name) |
| **public static final** | [DATA_CONTENT_DISPOSITION](#data_content_disposition) |
| **public static final** | [DEFAULT_AGENT](#default_agent) |
| **public static final** | [DEFAULT_HOSTNAME](#default_hostname) |
| **public static final** | [DEFAULT_NUM_SOURCE_FILE](#default_num_source_file) |
| **public static final** | [DO](#do) |
| **public static final** | [DOWNLOAD_COMMAND](#download_command) |
| **public static final** | [FILENAME_PARAMETER](#filename_parameter) |
| **public static final** | [FILE_CONTENT_DISPOSITION](#file_content_disposition) |
| **public static final** | [INITIAL_VALUES_COMMAND](#initial_values_command) |
| **public static final** | [INPUT_ID_PARAMETER](#input_id_parameter) |
| **public static final** | [INPUT_ID_PARAMETER_NAME](#input_id_parameter_name) |
| **public static final** | [MEDIA_TYPE](#media_type) |
| **public static final** | [NUM_SOURCE_FILE_PARAMETER](#num_source_file_parameter) |
| **public static final** | [PROBLEM_PARAMETER](#problem_parameter) |
| **public static final** | [PROBLEM_PARAMETER_NAME](#problem_parameter_name) |
| **public static final** | [SOURCE_FILE_PARAMETER](#source_file_parameter) |
| **public static final** | [SUBMIT_COMMAND](#submit_command) |
| **public static final** | [TIME_PARAMETER](#time_parameter) |
| **public static final** | [UNDEFINED](#undefined) |

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static final** *java.lang.String* | [createBoundary](#createboundary)() |

---


##Fields
####AGENT_PARAMETER
> **public static final** *java.lang.String*

> The <tt>agent</tt> parameter.

---

####AGENT_PARAMETER_NAME
> **public static final** *java.lang.String*

> The <tt>agent</tt> parameter name.

---

####ANALYSIS_COMMAND
> **public static final** *java.lang.String*

> Command used for retrieving contest analysis.

---

####ANSWER_PARAMETER
> **public static final** *java.lang.String*

> The <tt>answer</tt> parameter.

---

####BOUNDARY
> **public static final** *java.lang.String*

> The <tt>boundary</tt> parameter for multipart POST request.

---

####COMMAND_PARAMETER
> **public static final** *java.lang.String*

> The <tt>command</tt> parameter.

---

####COMMAND_PARAMETER_NAME
> **public static final** *java.lang.String*

> The <tt>command</tt> parameter name.

---

####CONTENT_DISPOSITION
> **public static final** *java.lang.String*

> The <tt>content disposition</tt> header name.

---

####CONTEST_INFO
> **public static final** *java.lang.String*

> API Request for retrieving contest info.

---

####COOKIE_NAME
> **public static final** *java.lang.String*

> Name of the identification cookie.

---

####CSRF_PARAMETER
> **public static final** *java.lang.String*

> The <tt>csrfmiddlewaretoken</tt> parameter name.

---

####CSRF_PARAMETER_NAME
> **public static final** *java.lang.String*

> The <tt>csrfmiddlewaretoken</tt> parameter.

---

####DATA_CONTENT_DISPOSITION
> **public static final** *java.lang.String*

> The <tt>content disposition</tt> format for a file part.

---

####DEFAULT_AGENT
> **public static final** *java.lang.String*

> Default agent value to use.

---

####DEFAULT_HOSTNAME
> **public static final** *java.lang.String*

> Default hostname used by this client.

---

####DEFAULT_NUM_SOURCE_FILE
> **public static final** *java.lang.String*

> Default value used for the number of source files.

---

####DO
> **public static final** *java.lang.String*

> API Request for command based action.

---

####DOWNLOAD_COMMAND
> **public static final** *java.lang.String*

> Command used for downloading input file.

---

####FILENAME_PARAMETER
> **public static final** *java.lang.String*

> The <tt>filename</tt> parameter.

---

####FILE_CONTENT_DISPOSITION
> **public static final** *java.lang.String*

> The <tt>content disposition</tt> format for a data part.

---

####INITIAL_VALUES_COMMAND
> **public static final** *java.lang.String*

> Command used for retrieving contest initial values.

---

####INPUT_ID_PARAMETER
> **public static final** *java.lang.String*

> The input identifier parameter.

---

####INPUT_ID_PARAMETER_NAME
> **public static final** *java.lang.String*

> The input identifier parameter name.

---

####MEDIA_TYPE
> **public static final** *java.lang.String*

> Media type used for POST submission request.

---

####NUM_SOURCE_FILE_PARAMETER
> **public static final** *java.lang.String*

> The <tt>number of source files</tt> parameter.

---

####PROBLEM_PARAMETER
> **public static final** *java.lang.String*

> The <tt>problem</tt> parameter.

---

####PROBLEM_PARAMETER_NAME
> **public static final** *java.lang.String*

> The <tt>problem</tt> parameter name.

---

####SOURCE_FILE_PARAMETER
> **public static final** *java.lang.String*

> The <tt>source file</tt> parameter.

---

####SUBMIT_COMMAND
> **public static final** *java.lang.String*

> Command user for submitting solution.

---

####TIME_PARAMETER
> **public static final** *java.lang.String*

> The time parameter.

---

####UNDEFINED
> **public static final** *java.lang.String*

> The <tt>undefined</tt> parameter value.

---


##Methods
####createBoundary()
> Creates and returns a boundary for multipart request.

> **Returns**
* Created boundary.


---

---

[![Marklet](https://img.shields.io/badge/Generated%20by-Marklet-green.svg)](https://github.com/Faylixe/marklet)