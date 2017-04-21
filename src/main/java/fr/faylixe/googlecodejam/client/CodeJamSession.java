package fr.faylixe.googlecodejam.client;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.MultipartContent;
import com.google.gson.Gson;

import fr.faylixe.googlecodejam.client.common.NamedObject;
import fr.faylixe.googlecodejam.client.common.Resources;
import fr.faylixe.googlecodejam.client.executor.HttpRequestExecutor;
import fr.faylixe.googlecodejam.client.webservice.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static fr.faylixe.googlecodejam.client.executor.Request.*;

/**
 * {@link CodeJamSession} is the main API entry point, which consists
 * in logging to a code jam platform ``hostname`` and then providing
 * facilities such as :
 * <br>
 * * Retrieves contest, round
 * * Interacts with platform API from a given round
 * * Downloads input
 * * Submits solutions
 * 
 * @author fv
 */
public final class CodeJamSession extends NamedObject implements Serializable {

	/** <p>Serialization index.</p> **/
	private static final long serialVersionUID = 1L;

	/** Path prefix for the fake path sended when submitting source. **/
	private static final String PATH_PREFIX = "/home/foo/";

	/** <p>Downloaded input file extension used for filename generation.</p> **/
	private static final String INPUT_EXTENSION = ".in";

	/** <p>Practice file type for unactive contest.</p> **/
	private static final String PRACTICE = "practice";

	/** <p>Error message set when analysis retrieval failed.</p> **/
	private static final String ANALYSIS_ERROR = "An error occurs while retrieving analysis : %s";

	/** <p>Character used for file name generation.</p> **/
	private static final char FILENAME_SEPARATOR = '-';

	/** <p>Logged HTTP executor for executing queries.</p> **/
	private final HttpRequestExecutor executor;

	/** <p>Current selected round this session is working on.</p> **/
	private final Round round;

	/** <p>Current contest info this session is working on.</p> **/
	private final ContestInfo info;

	/** <p>Initial values this session is working on.</p> **/
	private final InitialValues values;

	/** <p>Map of already loaded contest analysis.</p> **/
	private final Map<Problem, String> analysis;

	/**
	 * <p>Static factory that builds the name of this session
	 * regarding of the given <tt>round</tt>.</p>
	 * 
	 * @param round Round to build name from.
	 * @return Name built.
	 */
	private static String buildContestName(final Round round) {
		final String contestName = Resources.normalize(round.getContestName());
		final String roundName = Resources.normalize(round.getName());
		return new StringBuilder(contestName.toLowerCase())
			.append('-')
			.append(roundName.toLowerCase())
			.toString();
	}

	/**
	 * <p>Default constructor.</p>
	 * 
	 * @param executor Logged HTTP executor for executing queries.
	 * @param round Current selected round this session is working on.
	 * @param info Current contest info this session is working on.
	 * @param values Initial values this session is working on.
	 */
	private CodeJamSession(
			final HttpRequestExecutor executor,
			final Round round,
			final ContestInfo info,
			final InitialValues values) {
		super(buildContestName(round));
		this.executor = executor;
		this.round = round;
		this.info = info;
		this.values = values;
		this.analysis = new HashMap<>();
	}

	/**
	 * <p>Reloads session components in order to prevent from any change.</p>
	 * 
	 * @return A newly created session updated otherwise.
	 * @throws IOException If any error occurs while reloading a new session.
	 */
	public CodeJamSession refresh() throws IOException {
		return createSession(executor, round);
	}
	
	/**
	 * <p>Performs and returns a <tt>GET /</tt> request
	 * in order to get all <tt>round</tt> detail.</p>
	 * 
	 * @return Request response as a {@link ContestInfo} POJO.
	 */
	public ContestInfo getContestInfo() {
		return info;
	}

	/**
	 * <p>Indicates if the currently logged user is qualified
	 * for the next round or not.</p>
	 * 
	 * @return <tt>true</tt> if user is qualified, <tt>false</tt> otherwise.
	 */
	public boolean isQualified() {
		return values.isQualified();
	}
	
	/**
	 * <p>Indicates if the current session is logged in or not.</p>
	 * 
	 * @return <tt>true</tt> if user is logged, <tt>false</tt> otherwise.
	 */
	public boolean isLogged() {
		return values.isLogged();
	}

	/**
	 * <p>Retrieves the problem associated
	 * to the given <tt>letter</tt>.</p>
	 * 
	 * @param letter Letter that identifies the problem.
	 * @return Corresponding problem if exist, <tt>null</tt> otherwise.
	 */
	public Problem getProblem(final String letter) {
		if (letter.isEmpty() || letter.length() > 1) {
			return null;
		}
		final char identifier = letter.toUpperCase().charAt(0);
		final int index = (int) identifier - (int) 'A';
		final List<Problem> problems = info.getProblems();
		if (index < 0 || index >= problems.size()) {
			return null;
		}
		return problems.get(index);
	}

	/**
	 * <p>Indiciates if the contest is currently active,
	 * namely if competition is occuring at the current
	 * time, or not.</p>
	 * 
	 * @return <tt>true</tt> if the contest is active, <tt>false</tt> otherwise.
	 */
	public boolean isActive() {
		final long now = System.currentTimeMillis();
		final long start = values.getStart();
		final long end = start + values.getLeft();
		// TODO : Ensure predicate consistency.
		return now >= start && now <= end;
	}

	/**
	 * <p>Retrieves and returns the analysis
	 * for the given <tt>problem</tt>.</p>
	 * 
	 * @param problemId Problem to retrieve analysis from.
	 * @return Analysis if any.
	 * @throws IOException If any error occurs while retrieving analysis.
	 */
	private String getContestAnalysis(final String problemId) throws IOException {
		final StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(round.getURL())
			.append(DO)
			.append(COMMAND_PARAMETER)
			.append(ANALYSIS_COMMAND)
			.append(PROBLEM_PARAMETER)
			.append(problemId)
			.append(CSRF_PARAMETER)
			.append(values.getToken())
			.append(AGENT_PARAMETER)
			.append(DEFAULT_AGENT);
		return executor.get(urlBuilder.toString());
	}
	
	/**
	 * <p>Returns the analysis for the given
	 * <tt>problem</tt> if any.</p>
	 * 
	 * @param problem Problem to retrieve analysis from.
	 * @return Analysis if any.
	 */
	public String getContestAnalysis(final Problem problem) {
		if (!analysis.containsKey(problem)) {
			try {
				final String content = getContestAnalysis(problem.getId());
				analysis.put(problem, content);		
			}
			catch (final IOException e) {
				return String.format(ANALYSIS_ERROR, e.getMessage());
			}
		}
		return analysis.get(problem);
	}

	/**
	 * <p>Builds and returns a valid file name
	 * for the given problem <tt>input</tt>.</p>
	 * 
	 * @param input Input to retrieve file name from.
	 * @param attempt Attempt number.
	 * @return Built file name.
	 */
	public String buildFilename(final ProblemInput input, final int attempt) {
		final StringBuilder builder = new StringBuilder();
		final Problem problem = input.getProblem();
		final ContestInfo info = problem.getParent();
		final int index = info.getProblems().indexOf(problem);
		final char letter = (char) ((int) 'A' + index);
		builder.append(letter)
			.append(FILENAME_SEPARATOR)
			.append(input.getName())
			.append(FILENAME_SEPARATOR);
		if (attempt == -1) {
			builder.append(PRACTICE);
		}
		else {
			builder.append(attempt);
		}
		builder.append(INPUT_EXTENSION);
		return builder.toString();
	}

	/**
	 * <p>Downloads and returns the stream of the
	 * input file associated to the given problem
	 * <tt>input</tt> in a practice mode.</p>
	 * 
	 * @param input Input to download file from.
	 * @return Stream to read which contains our downloaded file data.
	 * @throws IOException If any error occurs while downloading the file.
	 */
	public InputStream download(final ProblemInput input) throws IOException {
		return download(input, -1);
	}

	/**
	 * <p>Downloads and returns the stream of the
	 * input file associated to the given problem
	 * <tt>input</tt>.</p>
	 * 
	 * @param input Input to download file from.
	 * @param attempt Attempt number.
	 * @return Stream to read which contains our downloaded file data.
	 * @throws IOException If any error occurs while downloading the file.
	 */
	public InputStream download(final ProblemInput input, final int attempt) throws IOException {
		final String filename = buildFilename(input, attempt);
		final StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(round.getURL())
			.append(DO)
			.append(COMMAND_PARAMETER)
			.append(DOWNLOAD_COMMAND)
			.append(PROBLEM_PARAMETER)
			.append(input.getProblem().getId())
			.append(FILENAME_PARAMETER)
			.append(filename)
			.append(INPUT_ID_PARAMETER)
			.append(input.getNumber())
			.append(CSRF_PARAMETER)
			.append(values.getURLEncodedToken())
			.append(AGENT_PARAMETER)
			.append(DEFAULT_AGENT);
		final HttpRequest request = executor.getRequest(urlBuilder.toString());
		final HttpResponse response = request.execute();
		return response.getContent();
	}

	/**
	 * <p>Submits the given <tt>output</tt> file and the
	 * given <tt>source</tt> file for the given problem
	 * <tt>input</tt>. This method should be call only
	 * after a successful call to the {@link #download(ProblemInput)}
	 * method on the same <tt>input</tt>, as the evaluation
	 * system will judge the last downloaded dataset
	 * based on the internal token / session.</p>
	 * 
	 * @param input Input file to submit solution for.
	 * @param output Output file produced by the algorithm.
	 * @param source Source code file of the algorithm to submit.
	 * @return Request response, as a {@link SubmitResponse} instance.
	 * @throws IOException If any error occurs while uploading data, or performing the request.
	 */
	public SubmitResponse submit(final ProblemInput input, final File output, final File source) throws IOException {
		final MultipartContent content = createContent(input, output, source);
		final StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(round.getURL());
		urlBuilder.append(DO);
		final String response = executor.post(urlBuilder.toString(), content);
		final Gson gson = new Gson();
		return gson.fromJson(response, SubmitResponse.class);
	}

	/**
	 * <p>Created and returns a valid {@link MultipartContent} instance
	 * that contains data required for submission.</p>
	 * 
	 * @param input Input file to submit solution for.
	 * @param output Output file produced by the algorithm.
	 * @param source Source code file of the algorithm to submit.
	 * @return Created multipart content.
	 */
	private MultipartContent createContent(final ProblemInput input, final File output, final File source) throws IOException {
		final HttpMediaType type = new HttpMediaType(MEDIA_TYPE);
		type.setParameter(BOUNDARY, createBoundary());
		// Submission from Chrome through contest website sends fake path for security,
		// which presumes the server only uses the last token to generate the downloadable
		// zip. It is possible to submit real path here (source.getAbsolutePath) but to
		// preserve user privacy a fake path will do source.getName() might be sufficient
		// as well but it's not tested using a fake path is the safest option since that's
		// what Chrome does.
		final String sourceFilePath = new StringBuilder(PATH_PREFIX)
			.append(source.getName())
			.toString();
		final MultipartContent content = new MultipartContent()
			.setMediaType(type)
			.addPart(HttpRequestExecutor.buildDataPart(CSRF_PARAMETER_NAME, values.getToken()))
			.addPart(HttpRequestExecutor.buildFilePart(ANSWER_PARAMETER, output))
			.addPart(HttpRequestExecutor.buildFilePart(SOURCE_FILE_PARAMETER, source))
			.addPart(HttpRequestExecutor.buildDataPart(SOURCE_FILE_NAME_PARAMETER, sourceFilePath))
			.addPart(HttpRequestExecutor.buildDataPart(COMMAND_PARAMETER_NAME, SUBMIT_COMMAND))
			.addPart(HttpRequestExecutor.buildDataPart(PROBLEM_PARAMETER_NAME, input.getProblem().getId()))
			.addPart(HttpRequestExecutor.buildDataPart(INPUT_ID_PARAMETER_NAME, String.valueOf(input.getNumber())))
			.addPart(HttpRequestExecutor.buildDataPart(NUM_SOURCE_FILE_PARAMETER, DEFAULT_NUM_SOURCE_FILE))
			.addPart(HttpRequestExecutor.buildDataPart(AGENT_PARAMETER_NAME, DEFAULT_AGENT));
		return content;
	}

	/**
	 * <p>Static factory method that should be used for creating a session.
	 * Loads associated contest info and initial values from the given
	 * <tt>round</tt>, using the given <tt>executor</tt>.</p>
	 * 
	 * @param executor {@link HttpRequestExecutor} instance to use.
	 * @param round Contextual {@link Round} instance this session is bound to.
	 * @return Created session.
	 * @throws IOException If any error occurs while retrieving contest info or initial values.
	 */
	public static CodeJamSession createSession(final HttpRequestExecutor executor, final Round round) throws IOException {
		final ContestInfo info = ContestInfo.get(executor, round);
		final InitialValues values = InitialValues.get(executor, round);
		return new CodeJamSession(executor, round, info, values);
	}

}
