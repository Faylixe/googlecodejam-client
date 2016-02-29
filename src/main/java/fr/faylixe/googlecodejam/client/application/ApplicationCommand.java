package fr.faylixe.googlecodejam.client.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static java.lang.System.out;
import static java.lang.System.err;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.lang3.SerializationUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import fr.faylixe.googlecodejam.client.CodeJamSession;
import fr.faylixe.googlecodejam.client.Contest;
import fr.faylixe.googlecodejam.client.Round;
import fr.faylixe.googlecodejam.client.common.NamedObject;
import fr.faylixe.googlecodejam.client.executor.HttpRequestExecutor;
import fr.faylixe.googlecodejam.client.executor.Request;
import fr.faylixe.googlecodejam.client.executor.SeleniumCookieSupplier;
import fr.faylixe.googlecodejam.client.webservice.Problem;
import fr.faylixe.googlecodejam.client.webservice.ProblemInput;
import fr.faylixe.googlecodejam.client.webservice.SubmitResponse;
import static fr.faylixe.googlecodejam.client.application.ApplicationConstant.*;

/**
 * <p>This class contains static method that are
 * executed from parsed command line argument in
 * {@link Application}.</p>
 * 
 * @author fv
 */
public final class ApplicationCommand {

	/** Path of the serialized round file to use. **/
	private static final String ROUND_PATH = ".cjs-round";

	/** Path of the serialized cookie file to use. **/
	private static final String COOKIE_PATH = ".cjs-cookie";

	/**
	 * Prompts users for selecting a valid {@link Round}
	 * instance that will be used as a contextual round.
	 * 
	 * @throws IOException If any error occurs while downloading contest page.
	 * @throws GeneralSecurityException If any error occurs while creating HTTP client.
	 */
	private static Optional<Round> selectRound() throws IOException, GeneralSecurityException {
		final HttpRequestExecutor executor = HttpRequestExecutor.create(Request.DEFAULT_HOSTNAME);
		final List<Contest> contests = Contest.get(executor);
		final Scanner reader = new Scanner(System.in);
		final Optional<Contest> selectedContest = select(contests, reader);
		if (selectedContest.isPresent()) {
			return select(selectedContest.get().getRounds(), reader);
		}
		return Optional.empty();
	}

	/**
	 * Selects a named object from the given list using the
	 * given {@link Scanner} for reading user input.
	 * 
	 * @param objects {@link NamedObject} list that user should choose in.
	 * @return Optional selected {@link NamedObject} instance.
	 */
	private static <T extends NamedObject> Optional<T> select(final List<T> objects, final Scanner reader) {
		out.println("Please select a contest :");
		for (int i = 0; i < objects.size(); i++) {
			final StringBuilder builder = new StringBuilder('\t');
			builder.append(i + 1);
			builder.append(" - ");
			builder.append(objects.get(i).getName());
			out.println(builder.toString());
		}
		out.print("> ");
		final String input = reader.next();
		try {
			final int selected = Integer.valueOf(input);
			if (selected > 0 && selected <= objects.size()) {
				return Optional.of(objects.get(selected - 1));
			}
		}
		catch (final NumberFormatException e) {
			err.println("Number expected, abort");
		}
		return Optional.empty();
	}

	/**
	 * Methods that is bound to the INIT command. Starts
	 * firefox through selenium to retrieve cookie instance
	 * and prompts user for the contextual round to use.
	 * 
	 * @return <tt>true</tt> if the init command was correctly executed, <tt>false</tt> otherwise.
	 */
	public static boolean init() {
		out.println("Firefox browser will open, please authenticate to your Google account with it.");
		final SeleniumCookieSupplier supplier = new SeleniumCookieSupplier(Request.DEFAULT_HOSTNAME + "/codejam", FirefoxDriver::new);
		try {
			final String cookie = supplier.get();
			if (cookie == null) {
				err.println("Retrieved cookie instance is null, abort.");
			}
			else {
				out.println("Cookie retrieved, extracting contest list.");
				final Optional<Round> round = selectRound();
				if (round.isPresent()) {
					out.println("Writing " + COOKIE_PATH);
					SerializationUtils.serialize(cookie, new FileOutputStream(COOKIE_PATH));
					out.println("Writing " + ROUND_PATH);
					SerializationUtils.serialize(round.get(), new FileOutputStream(ROUND_PATH));
					out.println("Initialization done, you can now download and submit in this directory.");
				}
				else {
					err.println("No round selected, abort.");
				}
			}
		}
		catch (final IOException | UnreachableBrowserException | GeneralSecurityException e) {
			err.println("An error occurs while creating CodeJamSession : " + e.getMessage());
		}
		return true;
	}

	/**
	 * If exists, deserializes the cookie and round file
	 * in order to create and returns a valid {@link CodeJamSession}.
	 * 
	 * @return Contextual session loaded if exist.
	 * @throws IOException If the session could not be loaded.
	 * @throws GeneralSecurityException 
	 */
	private static CodeJamSession getContextualSession() throws IOException, GeneralSecurityException {
		final String cookie = (String) SerializationUtils.deserialize(new FileInputStream(COOKIE_PATH));
		final HttpRequestExecutor executor = HttpRequestExecutor.create(Request.DEFAULT_HOSTNAME, cookie);
		final Round round = (Round) SerializationUtils.deserialize(new FileInputStream(ROUND_PATH));
		return CodeJamSession.createSession(executor, round);
	}

	/**
	 * Retrieves and returns the problem input from the given <tt>command</tt>
	 * using the given <tt>session</tt>.
	 * 
	 * @param command Command to retrieve input parameters from.
	 * @param session Session to retrieve input from.
	 * @return Retrieved {@link ProblemInput} instance if exists, <tt>null</tt> otherwise.
	 */
	private static ProblemInput getProblemInput(final CommandLine command, final CodeJamSession session) {
		if (!command.hasOption(PROBLEM) || !command.hasOption(INPUT_TYPE)) {
			err.println("Download command requires problem and input type parameters.");
			return null;
		}
		final String problemArgument = command.getOptionValue(PROBLEM);
		final String inputArgument = command.getOptionValue(INPUT_TYPE);
		final Problem problem = session.getProblem(problemArgument);
		if (problem == null) {
			err.println("Problem " + problemArgument + " not found.");
			return null;
		}
		final ProblemInput input = problem.getProblemInput(inputArgument);
		if (input == null) {
			err.println("Input " + inputArgument + "not found for problem " + problemArgument + ".");
			return null;
		}
		return input;
	}

	/**
	 * Downloads an input file, from the given user <tt>command</tt>.
	 * Retrieves the contextual session if exist, and if so, then
	 * the download method is used on the loaded session. If the
	 * file already exist, it will be removed first before downloading.
	 * 
	 * @param command User command line.
	 * @return <tt>true</tt> if the command was executed successfully, <tt>false</tt> otherwise.
	 */
	public static boolean download(final CommandLine command) {
		try {
			final CodeJamSession session = getContextualSession();
			final ProblemInput input = getProblemInput(command, session);
			final InputStream stream = session.download(input);
			final Path target = Paths.get(session.buildFilename(input));
			Files.deleteIfExists(target);
			Files.copy(stream, target);
			out.println(target.toString());
		}
		catch (final IOException | GeneralSecurityException e) {
			err.println("An error occurs while downloading input file : " + e.getMessage());
		}
		return true;
	}

	/**
	 * Performs an output file submission using the <tt>SubmitAnswer</tt>
	 * command. Retrieves the contextual session if exist, and if so, then
	 * the submit method is used on the loaded session.
	 * 
	 * @param command User command line.
	 * @return <tt>true</tt> if the command was executed successfully, <tt>false</tt> otherwise.
	 */
	public static boolean submit(final CommandLine command) {
		if (!command.hasOption(OUTPUT) || !command.hasOption(SOURCE)) {
			err.println("Submit command requires output and source file parameters.");
			return false;
		}
		final String output = command.getOptionValue(OUTPUT);
		final String source = command.getOptionValue(SOURCE);
		try {
			final CodeJamSession session = getContextualSession();
			final ProblemInput input = getProblemInput(command, session);
			final SubmitResponse response = session.submit(input, new File(output), new File(source));
			if (response.isSuccess()) {
				out.println("Submission correct !");				
			}
			else {
				out.println("Submission failed : " + response.getMessage());
			}
		}
		catch (final IOException | GeneralSecurityException e) {
			err.println("An error occurs while submitting output file : " + e.getMessage());
		}
		return true;
	}

}
