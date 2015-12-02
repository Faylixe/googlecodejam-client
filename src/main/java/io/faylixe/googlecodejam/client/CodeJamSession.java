package io.faylixe.googlecodejam.client;

import static io.faylixe.googlecodejam.client.webservice.Request.*;
import io.faylixe.googlecodejam.client.executor.HTTPRequestExecutor;
import io.faylixe.googlecodejam.client.webservice.ContestInfo;
import io.faylixe.googlecodejam.client.webservice.InitialValues;
import io.faylixe.googlecodejam.client.webservice.Problem;
import io.faylixe.googlecodejam.client.webservice.ProblemInput;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

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

	/** Logged HTTP executor for executing queries. **/
	private final transient HTTPRequestExecutor executor; // TODO : Consider using custom serialization / deserialization for build.

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
	private CodeJamSession(final HTTPRequestExecutor executor, final Round round, final ContestInfo info, final InitialValues values) {
		this.executor = executor;
		this.round = round;
		this.info = info;
		this.values = values;
	}

	/**
	 * Reloads session components in order to prevent from any change.
	 * 
	 * @return This session if no change has been found, a newly created session updated otherwise.
	 */
	public CodeJamSession refresh() {
		// TODO : Check for initial values. and reload if required.
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
			.append(COMMAND)
			.append(ANALYSIS_COMMAND)
			.append(PROBLEM_PARAMETER)
			.append(problem.getId())
			.append(CSRF_PARAMETER)
			.append(values.getToken());
		return executor.get(urlBuilder.toString());
	}

	/**
	 * Builds and returns a valid file name
	 * for the given problem <tt>input</tt>.
	 * 
	 * @param input Input to retrieve file name from.
	 * @return Built file name.
	 */
	private String buildFilename(final ProblemInput input) {
		final StringBuilder builder = new StringBuilder();
		final Problem problem = input.getProblem();
		final ContestInfo info = problem.getParent();
		final int index = info.getProblems().indexOf(problem);
		final char letter = (char) ((int) 'A' + index);
		builder.append(letter)
			.append('-')
			.append(input.getName())
			.append('-')
			.append(input.getSuffix());
		// TODO : Check if practice or suffix.
		return builder.toString();
	}

	/**
	 * Downloads and returns the stream of the
	 * input file associated to the given problem
	 * <tt>input</tt>.
	 * 
	 * @param input Input to download file from.
	 * @throws IOException If any error occurs while downloading the file.
	 */
	public InputStream download(final ProblemInput input) throws IOException {
		final String filename = buildFilename(input);
		final StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(round.getURL())
			.append(COMMAND)
			.append(DOWNLOAD_COMMAND)
			.append(PROBLEM_PARAMETER)
			.append(input.getProblem().getId())
			.append(FILENAME_PARAMETER)
			.append(filename)
			.append(INPUT_ID_PARAMETER)
			.append(input.getNumber())
			.append(CSRF_PARAMETER)
			.append(values.getToken());
		return executor.getStream(urlBuilder.toString());
	}
	
	/**
	 * TODO Implements submission.
	 * @return <tt>true</tt> if the submission has been considered has valid, <tt>false</tt> otherwise.
	 */
	public boolean submit() {
		return false;
	}

	/**
	 * Static factory method that should be used for creating a session.
	 * Loads associated contest info and initial values from the given
	 * <tt>round</tt>, using the given <tt>executor</tt>.
	 * 
	 * @return Created session.
	 * @throws IOException If any error occurs while retrieving contest info or initial values.
	 */
	public static CodeJamSession createSession(final HTTPRequestExecutor executor, final Round round) throws IOException {
		final ContestInfo info = ContestInfo.get(executor, round);
		final InitialValues values = InitialValues.get(executor, round);
		return new CodeJamSession(executor, round, info, values);
	}

}
