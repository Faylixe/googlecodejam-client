package fr.faylixe.googlecodejam.client.executor;

/**
 * <p>Simple class that exposes string constant
 * relative to HTTP API for interacting with
 * Code Jam webservice.</p>
 * 
 * @author fv
 */
public final class Request {

	/** API Request for retrieving contest info. **/
	public static final String CONTEST_INFO = "/ContestInfo";

	/** API Request for command based action. **/
	public static final String DO = "/do";

	/** The <tt>command</tt> parameter name. **/
	public static final String COMMAND_PARAMETER_NAME = "cmd";

	/** The <tt>command</tt> parameter. **/
	public static final String COMMAND_PARAMETER = "?" + COMMAND_PARAMETER_NAME +"=";

	/** Command used for retrieving contest initial values. **/
	public static final String INITIAL_VALUES_COMMAND = "GetInitialValues";
	
	/** Command used for retrieving contest analysis. **/
	public static final String ANALYSIS_COMMAND = "GetContestAnalysis";

	/** Command used for downloading input file. **/
	public static final String DOWNLOAD_COMMAND = "GetInputFile";

	/** Command user for submitting solution. **/
	public static final String SUBMIT_COMMAND = "SubmitAnswer";

	/** The <tt>agent</tt> parameter name. **/
	public static final String AGENT_PARAMETER_NAME = "agent";

	/** The <tt>agent</tt> parameter. **/
	public static final String AGENT_PARAMETER = "&" + AGENT_PARAMETER_NAME + "=";

	/** Default agent value to use. **/
	public static final String DEFAULT_AGENT = "googlecodejam-client-java";

	/** The <tt>csrfmiddlewaretoken</tt> parameter. **/
	public static final String CSRF_PARAMETER_NAME = "csrfmiddlewaretoken";
	
	/** The <tt>csrfmiddlewaretoken</tt> parameter name. **/
	public static final String CSRF_PARAMETER = "&" + CSRF_PARAMETER_NAME + "=";

	/** The <tt>problem</tt> parameter name. **/
	public static final String PROBLEM_PARAMETER_NAME = "problem";

	/** The <tt>problem</tt> parameter. **/
	public static final String PROBLEM_PARAMETER = "&" + PROBLEM_PARAMETER_NAME + "=";

	/** The time parameter. **/
	public static final String TIME_PARAMETER = "&zx=";

	/** The <tt>filename</tt> parameter. **/
	public static final String FILENAME_PARAMETER = "&filename=";

	/** The input identifier parameter name. **/
	public static final String INPUT_ID_PARAMETER_NAME = "input_id";

	/** The input identifier parameter. **/
	public static final String INPUT_ID_PARAMETER = "&" + INPUT_ID_PARAMETER_NAME + "=";

	/** The <tt>undefined</tt> parameter value. **/
	public static final String UNDEFINED = "undefined";

	/** The <tt>content disposition</tt> header name. **/
	public static final String CONTENT_DISPOSITION = "Content-Disposition";

	/** The <tt>content disposition</tt> format for a data part. **/
	public static final String FILE_CONTENT_DISPOSITION = "form-data; name=\"%s\"; filename=\"%s\"";

	/** The <tt>content disposition</tt> format for a file part. **/
	public static final String DATA_CONTENT_DISPOSITION = "form-data; name=\"%s\"";

	/** Media type used for POST submission request. **/
	public static final String MEDIA_TYPE = "multipart/form-data";

	/** The <tt>answer</tt> parameter. **/
	public static final String ANSWER_PARAMETER = "answer";

	/** The <tt>source file</tt> parameter. **/
	public static final String SOURCE_FILE_PARAMETER = "source-file0";

	/** The <tt>source file name</tt> parameter. **/
	public static final String SOURCE_FILE_NAME_PARAMETER = "source-file-name0";

	/** The <tt>number of source files</tt> parameter.  **/
	public static final String NUM_SOURCE_FILE_PARAMETER = "num_source_files";

	/** Default value used for the number of source files. **/
	public static final String DEFAULT_NUM_SOURCE_FILE = "1";

	/** Name of the identification cookie.  **/
	public static final String COOKIE_NAME = "SACSID";

	/** The <tt>boundary</tt> parameter for multipart POST request. **/
	public static final String BOUNDARY = "boundary";

	/** The prefix used for creating dynamic boundary. **/
	private static final String BOUNDARY_PREFIX = "----gcjMultipartBoundary";

	/** System property key for hostname. **/
	private static final String HOSTNAME_PROPERTY = "googlecodejam.hostname";

	/** Default hostname used by this client. **/
	private static final String DEFAULT_HOSTNAME = "https://code.google.com";

	/**
	 * Creates and returns a boundary for multipart request.
	 * 
	 * @return Created boundary.
	 */
	public static final String createBoundary() {
		final StringBuilder builder = new StringBuilder(BOUNDARY_PREFIX);
		builder.append((int) System.currentTimeMillis());
		return builder.toString();
	}

	/**
	 * Private constructor for avoiding instantiation.
	 */
	private Request() {
		// Do nothing.
	}
	
	/**
	 * Hostname getter, if user has defined a specific hostname through
	 * java system properties then it will be used. Otherwise the default
	 * hostname (https://code.google.com) will be returned.
	 * 
	 * @return Hostname to use for performing request.
	 */
	public static String getHostname() {
		final String hostname = System.getProperty(HOSTNAME_PROPERTY);
		// TODO : Ensure hostname format is valid.
		return (hostname == null ? DEFAULT_HOSTNAME : hostname);
	}

}
