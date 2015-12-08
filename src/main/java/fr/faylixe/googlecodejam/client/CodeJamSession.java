package fr.faylixe.googlecodejam.client;

import static fr.faylixe.googlecodejam.client.executor.Request.*;
import fr.faylixe.googlecodejam.client.executor.HttpRequestExecutor;
import fr.faylixe.googlecodejam.client.webservice.ContestInfo;
import fr.faylixe.googlecodejam.client.webservice.InitialValues;
import fr.faylixe.googlecodejam.client.webservice.Problem;
import fr.faylixe.googlecodejam.client.webservice.ProblemInput;
import fr.faylixe.googlecodejam.client.webservice.SubmitResponse;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.MultipartContent;
import com.google.gson.Gson;

/**
 * <p>{@link CodeJamSession} is the main API entry point, which consists
 * in logging to a code jam platform <tt>hostname</tt> and then providing
 * facilities such as :</p>
 * <br>
 * <ul>
 * 	<li>Retrieves contest, round</li>
 * 	<li>Interacts with platform API from a given round</li>
 * 	<li>Downloads input</li>
 * 	<li>Submits solutions</li>
 * </ul>
 * 
 * @author fv
 */
public final class CodeJamSession implements Serializable {

	/** Serialization index. **/
	private static final long serialVersionUID = 1L;

	/** Downloaded input file extension used for filename generation. **/
	private static final String INPUT_EXTENSION = ".in";

	/** Practice file type for unactive contest. **/
	private static final String PRACTICE = "practice";

	/** Character used for file name generation. **/
	private static final char FILENAME_SEPARATOR = '-';

	/** Logged HTTP executor for executing queries. **/
	private final transient HttpRequestExecutor executor; // ISSUE : https://github.com/Faylixe/googlecodejam-client/issues/1

	/** Current selected round this session is working on. **/
	private final Round round;

	/** Current contest info this session is working on. **/
	private final ContestInfo info;

	/** Initial values this session is working on. **/
	private final InitialValues values;

	/**
	 * Default constructor.
	 * 
	 * @param executor Logged HTTP executor for executing queries.
	 * @param round Current selected round this session is working on.
	 * @param info Current contest info this session is working on.
	 * @param values Initial values this session is working on.
	 */
	private CodeJamSession(final HttpRequestExecutor executor, final Round round, final ContestInfo info, final InitialValues values) {
		this.executor = executor;
		this.round = round;
		this.info = info;
		this.values = values;
	}

	/**
	 * Reloads session components in order to prevent from any change.
	 * Based on the version number of {@link InitialValues}.
	 * 
	 * @return This session if no change has been found, a newly created session updated otherwise.
	 * @throws IOException If any error occurs while retrieving new values.
	 */
	public CodeJamSession refresh() throws IOException {
		// ISSUE : https://github.com/Faylixe/googlecodejam-client/issues/4
		final InitialValues refreshedValues = InitialValues.get(executor, round);
		if (refreshedValues.getVersion() > values.getVersion()) {
			return createSession(executor, round);
		}
		return this;
	}

	/**
	 * Performs and returns a <tt>GET /</tt> request
	 * in order to get all <tt>round</tt> detail.
	 * 
	 * @return Request response as a {@link ContestInfo} POJO.
	 */
	public ContestInfo getContestInfo() {
		return info;
	}

	/**
	 * Indicates if the currently logged user is qualified
	 * for the next round or not.
	 * 
	 * @return <tt>true</tt> if user is qualified, <tt>false</tt> otherwise.
	 */
	public boolean isQualified() {
		return values.isQualified();
	}
	
	/**
	 * Indicates if the current session is logged in or not.
	 * 
	 * @return <tt>true</tt> if user is logged, <tt>false</tt> otherwise.
	 */
	public boolean isLogged() {
		return values.isLogged();
	}

	/**
	 * Retrieves the problem associated
	 * to the given <tt>letter</tt>.
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
	 * Indiciates if the contest is currently active,
	 * namely if competition is occuring at the current
	 * time, or not.
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
	 * Retrieves and returns the analysis
	 * for the given <tt>problem</tt>.
	 * 
	 * @param problem Problem to retrieve analysis from.
	 * @return Analysis if any.
	 * @throws IOException If any error occurs while retrieving analysis.
	 */
	public String getContestAnalysis(final Problem problem) throws IOException {
		final StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(round.getURL())
			.append(DO)
			.append(COMMAND_PARAMETER)
			.append(ANALYSIS_COMMAND)
			.append(PROBLEM_PARAMETER)
			.append(problem.getId())
			.append(CSRF_PARAMETER)
			.append(values.getToken())
			.append(AGENT_PARAMETER)
			.append(DEFAULT_AGENT);
		return executor.get(urlBuilder.toString());
	}
	
	/**
	 * Computes input file type suffix for the
	 * given <tt>input</tt>.
	 * 
	 * @param input Problem input to retrieve suffix from.
	 * @return "practice" if the contest if not active, computed suffix otherwise.
	 */
	private String getType(final ProblemInput input) {
		if (!isActive()) {
			return PRACTICE;
		}
		return input.getSuffix(); // TODO : Ensure suffix is valid in a real contest.
	}

	/**
	 * Builds and returns a valid file name
	 * for the given problem <tt>input</tt>.
	 * 
	 * @param input Input to retrieve file name from.
	 * @return Built file name.
	 */
	public String buildFilename(final ProblemInput input) {
		final StringBuilder builder = new StringBuilder();
		final Problem problem = input.getProblem();
		final ContestInfo info = problem.getParent();
		final int index = info.getProblems().indexOf(problem);
		final char letter = (char) ((int) 'A' + index);
		builder.append(letter)
			.append(FILENAME_SEPARATOR)
			.append(input.getName())
			.append(FILENAME_SEPARATOR)
			.append(getType(input))
			.append(INPUT_EXTENSION);
		return builder.toString();
	}

	/**
	 * Downloads and returns the stream of the
	 * input file associated to the given problem
	 * <tt>input</tt>.
	 * 
	 * @param input Input to download file from.
	 * @return Stream to read which contains our downloaded file data.
	 * @throws IOException If any error occurs while downloading the file.
	 */
	public InputStream download(final ProblemInput input) throws IOException {
		final String filename = buildFilename(input);
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
	 * Submits the given <tt>output</tt> file and the
	 * given <tt>source</tt> file for the given problem
	 * <tt>input</tt>. This method should be call only
	 * after a successful call to the {@link #download(ProblemInput)}
	 * method on the same <tt>input</tt>, as the evaluation
	 * system will judge the last downloaded dataset
	 * based on the internal token / session.
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
	 * Created and returns a valid {@link MultipartContent} instance
	 * that contains data required for submission.
	 * 
	 * @param input Input file to submit solution for.
	 * @param output Output file produced by the algorithm.
	 * @param source Source code file of the algorithm to submit.
	 * @return Created multipart content.
	 */
	private MultipartContent createContent(final ProblemInput input, final File output, final File source) throws IOException {
		final HttpMediaType type = new HttpMediaType(MEDIA_TYPE);
		type.setParameter(BOUNDARY, createBoundary());
		final MultipartContent content = new MultipartContent()
			.setMediaType(type)
			.addPart(HttpRequestExecutor.buildDataPart(CSRF_PARAMETER_NAME, values.getToken()))
			.addPart(HttpRequestExecutor.buildFilePart(ANSWER_PARAMETER, output))
			.addPart(HttpRequestExecutor.buildFilePart(SOURCE_FILE_PARAMETER, source))
			.addPart(HttpRequestExecutor.buildDataPart(COMMAND_PARAMETER_NAME, SUBMIT_COMMAND))
			.addPart(HttpRequestExecutor.buildDataPart(PROBLEM_PARAMETER_NAME, input.getProblem().getId()))
			.addPart(HttpRequestExecutor.buildDataPart(INPUT_ID_PARAMETER_NAME, String.valueOf(input.getNumber())))
			.addPart(HttpRequestExecutor.buildDataPart(NUM_SOURCE_FILE_PARAMETER, DEFAULT_NUM_SOURCE_FILE))
			.addPart(HttpRequestExecutor.buildDataPart(AGENT_PARAMETER_NAME, DEFAULT_AGENT));
		return content;
	}

	/**
	 * Static factory method that should be used for creating a session.
	 * Loads associated contest info and initial values from the given
	 * <tt>round</tt>, using the given <tt>executor</tt>.
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
