package fr.faylixe.googlecodejam.client.application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.lang3.SerializationUtils;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import fr.faylixe.googlecodejam.client.CodeJamSession;
import fr.faylixe.googlecodejam.client.Contest;
import fr.faylixe.googlecodejam.client.Round;
import fr.faylixe.googlecodejam.client.common.NamedObject;
import fr.faylixe.googlecodejam.client.executor.HTTPRequestExecutor;
import fr.faylixe.googlecodejam.client.executor.SeleniumCookieSupplier;
import fr.faylixe.googlecodejam.client.webservice.ProblemInput;
import static fr.faylixe.googlecodejam.client.application.ApplicationConstant.*;

/**
 * 
 * @author fv
 */
public final class ApplicationCommand {

	/** **/
	private static final String ROUND_PATH = ".cjs-round";

	/** **/
	private static final String COOKIE_PATH = ".cjs-cookie";

	/** Default hostname used by this client. **/
	private static final String DEFAULT_HOSTNAME = "https://code.google.com";

	/** Cookies header name. **/
	private static final String COOKIE_HEADER = "SACSID=";

	/**
	 * 
	 * @throws IOException 
	 */
	private static Optional<Round> selectRound() throws IOException {
		final HttpTransport transport = new NetHttpTransport();
		final HTTPRequestExecutor executor = new HTTPRequestExecutor(DEFAULT_HOSTNAME, transport.createRequestFactory());
		final List<Contest> contests = Contest.get(executor);
		final Scanner reader = new Scanner(System.in);
		final Optional<Contest> selectedContest = select(contests, reader);
		if (selectedContest.isPresent()) {
			return select(selectedContest.get().getRounds(), reader);
		}
		return Optional.empty();
	}

	/**
	 * Selects 
	 * 
	 * @param objects {@link NamedObject} list that user should choose in.
	 * @return Optional selected {@link NamedObject} instance.
	 */
	private static <T extends NamedObject> Optional<T> select(final List<T> objects, final Scanner reader) {
		System.out.println("Please select a contest :");
		for (int i = 0; i < objects.size(); i++) {
			final StringBuilder builder = new StringBuilder('\t');
			builder.append(i + 1);
			builder.append(" - ");
			builder.append(objects.get(i).getName());
			System.out.println(builder.toString());
		}
		System.out.print("> ");
		final String input = reader.next();
		try {
			final int selected = Integer.valueOf(input);
			if (selected > 0 && selected <= objects.size()) {
				return Optional.of(objects.get(selected - 1));
			}
		}
		catch (final NumberFormatException e) {
			// TODO : Log error.
		}
		return Optional.empty();
	}

	/**
	 * 
	 * @param command
	 */
	public static boolean init(final CommandLine command) {
		System.out.println("####################################");
		System.out.println("Google Code Jam command line client");
		System.out.println("####################################\n");
		System.out.println("Firefox browser will open, please authenticate to your Google account with it");
		final SeleniumCookieSupplier supplier = new SeleniumCookieSupplier(DEFAULT_HOSTNAME + "/codejam", FirefoxDriver::new);
		final String cookie = supplier.get(); // TODO : Ensure that cookies instance is valid.
		try {
			final Optional<Round> round = selectRound();
			if (!round.isPresent()) {
				return false;
			}
			SerializationUtils.serialize(cookie, new FileOutputStream(COOKIE_PATH));
			SerializationUtils.serialize(round.get(), new FileOutputStream(ROUND_PATH));
		}
		catch (final IOException e) {
			System.err.println("An error occurs while creating CodeJamSession : " + e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @return
	 * @throws IOException 
	 */
	private static CodeJamSession getContextualSession() throws IOException {
		final String cookie = (String) SerializationUtils.deserialize(new FileInputStream(COOKIE_PATH));
		final Round round = (Round) SerializationUtils.deserialize(new FileInputStream(ROUND_PATH));
		final HttpTransport transport = new NetHttpTransport();
		final HttpRequestFactory requestFactory =  transport.createRequestFactory(request -> {
			final HttpHeaders headers = request.getHeaders();
			headers.setCookie(COOKIE_HEADER + cookie);
		});
		final HTTPRequestExecutor executor = new HTTPRequestExecutor(DEFAULT_HOSTNAME, requestFactory);
		return CodeJamSession.createSession(executor, round);
	}
	
	/**
	 * 
	 * @param problemArgument
	 * @param inputArgument
	 * @return
	 */
	private static ProblemInput getProblemInput(final String problemArgument, final String inputArgument) {
		return null;
	}

	/**
	 * Downloads an input file, from the given user <tt>command</tt>.
	 * Retrieves the contextual session if exist, and if so, then
	 * the download method is used on the loaded session.
	 * 
	 * @param command User command line.
	 * @return <tt>true</tt> if the command was executed successfully, <tt>false</tt> otherwise.
	 */
	public static boolean download(final CommandLine command) {
		if (!command.hasOption(PROBLEM) || !command.hasOption(INPUT_TYPE)) {
			System.err.println("Download command requires problem and input type parameters.");
			return false;
		}
		final String problemArgument = command.getOptionValue(PROBLEM);
		final String inputArgument = command.getOptionValue(INPUT_TYPE);
		try {
			final CodeJamSession session = getContextualSession();
			final ProblemInput input = getProblemInput(problemArgument, inputArgument);
			final InputStream stream = session.download(input);
			final Path target = Paths.get(session.buildFilename(input));
			Files.copy(stream, target);
		}
		catch (final IOException e) {
			System.err.println("An error occurs while downloading input file : " + e.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param command
	 * @return
	 */
	public static boolean submit(final CommandLine command) {
		return true;
	}

}
