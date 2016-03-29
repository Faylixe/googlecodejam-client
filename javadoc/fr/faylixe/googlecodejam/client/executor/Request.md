#Request
Package <a href="README.md"> fr.faylixe.googlecodejam.client.executor</a><br>

> *java.lang.Object* > <a href="Request.md"> Request</a>

<p>Simple class that exposes string constant
 relative to HTTP API for interacting with
 Code Jam webservice.</p>

##Summary
####Fields
| Type and modifiers | Field name |
| --- | --- |
| **public static final** | <a href="#agent_parameter"> AGENT_PARAMETER</a> |
| **public static final** | <a href="#agent_parameter_name"> AGENT_PARAMETER_NAME</a> |
| **public static final** | <a href="#analysis_command"> ANALYSIS_COMMAND</a> |
| **public static final** | <a href="#answer_parameter"> ANSWER_PARAMETER</a> |
| **public static final** | <a href="#boundary"> BOUNDARY</a> |
| **public static final** | <a href="#command_parameter"> COMMAND_PARAMETER</a> |
| **public static final** | <a href="#command_parameter_name"> COMMAND_PARAMETER_NAME</a> |
| **public static final** | <a href="#content_disposition"> CONTENT_DISPOSITION</a> |
| **public static final** | <a href="#contest_info"> CONTEST_INFO</a> |
| **public static final** | <a href="#cookie_name"> COOKIE_NAME</a> |
| **public static final** | <a href="#csrf_parameter"> CSRF_PARAMETER</a> |
| **public static final** | <a href="#csrf_parameter_name"> CSRF_PARAMETER_NAME</a> |
| **public static final** | <a href="#data_content_disposition"> DATA_CONTENT_DISPOSITION</a> |
| **public static final** | <a href="#default_agent"> DEFAULT_AGENT</a> |
| **public static final** | <a href="#default_hostname"> DEFAULT_HOSTNAME</a> |
| **public static final** | <a href="#default_num_source_file"> DEFAULT_NUM_SOURCE_FILE</a> |
| **public static final** | <a href="#do"> DO</a> |
| **public static final** | <a href="#download_command"> DOWNLOAD_COMMAND</a> |
| **public static final** | <a href="#filename_parameter"> FILENAME_PARAMETER</a> |
| **public static final** | <a href="#file_content_disposition"> FILE_CONTENT_DISPOSITION</a> |
| **public static final** | <a href="#initial_values_command"> INITIAL_VALUES_COMMAND</a> |
| **public static final** | <a href="#input_id_parameter"> INPUT_ID_PARAMETER</a> |
| **public static final** | <a href="#input_id_parameter_name"> INPUT_ID_PARAMETER_NAME</a> |
| **public static final** | <a href="#media_type"> MEDIA_TYPE</a> |
| **public static final** | <a href="#num_source_file_parameter"> NUM_SOURCE_FILE_PARAMETER</a> |
| **public static final** | <a href="#problem_parameter"> PROBLEM_PARAMETER</a> |
| **public static final** | <a href="#problem_parameter_name"> PROBLEM_PARAMETER_NAME</a> |
| **public static final** | <a href="#source_file_parameter"> SOURCE_FILE_PARAMETER</a> |
| **public static final** | <a href="#submit_command"> SUBMIT_COMMAND</a> |
| **public static final** | <a href="#time_parameter"> TIME_PARAMETER</a> |
| **public static final** | <a href="#undefined"> UNDEFINED</a> |

####Methods
| Type and modifiers | Method signature |
| --- | --- |
| **public static final** *java.lang.String* | <a href="#createboundary"> createBoundary</a>() |

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