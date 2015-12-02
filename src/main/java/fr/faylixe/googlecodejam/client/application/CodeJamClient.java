package fr.faylixe.googlecodejam.client.application;

import fr.faylixe.googlecodejam.client.CodeJamSession;
import fr.faylixe.googlecodejam.client.Contest;
import fr.faylixe.googlecodejam.client.Round;
import fr.faylixe.googlecodejam.client.common.NamedObject;
import fr.faylixe.googlecodejam.client.executor.HTTPRequestExecutor;
import fr.faylixe.googlecodejam.client.webservice.ContestInfo;
import fr.faylixe.googlecodejam.client.webservice.Problem;
import fr.faylixe.googlecodejam.client.webservice.ProblemInput;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * 
 * @author fv
 */
public final class CodeJamClient implements Runnable {

	/** **/
	private final HTTPRequestExecutor executor;

	/** **/
	private final Scanner reader;

	/** **/
	private CodeJamSession session;

	/** **/
	private final Map<String, Consumer<List<String>>> commands;
	
	/**
	 * 
	 * @author fv
	 *
	 */
	private class DownloadCommand implements Consumer<List<String>> {

		/** {@inheritDoc} **/
		@Override
		public void accept(final List<String> parameters) {
			final ContestInfo info = session.getContestInfo();
			final int index = 0;
			final Problem problem = info.getProblem(index);
			final int inputIndex = 0;
			final ProblemInput input = problem.getProblemInput(inputIndex);
			try {
				session.download(input, "");
			}
			catch (final IOException e) {
				
			}
		}
		
	}
	
	/**
	 * 
	 * @param executor
	 */
	public CodeJamClient(final HTTPRequestExecutor executor) {
		this.reader = new Scanner(System.in);
		this.executor = executor;
		this.commands = new HashMap<>();
	}

	/**
	 * 
	 * @throws IOException 
	 */
	public void selectRound() throws IOException {
		final List<Contest> contests = Contest.get(executor);
		final Optional<Contest> selectedContest = select(contests);
		if (selectedContest.isPresent()) {
			final Optional<Round> selectedRound = select(selectedContest.get().getRounds());
			if (selectedRound.isPresent()) {
				this.session = CodeJamSession.createSession(executor, selectedRound.get());
			}
		}
	}

	/**
	 * Selects 
	 * 
	 * @param objects {@link NamedObject} list that user should choose in.
	 * @return Optional selected {@link NamedObject} instance.
	 */
	private <T extends NamedObject> Optional<T> select(final List<T> objects) {
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
	 * Evaluates the given input <tt>line</tt>. And indicates
	 * if should continue.
	 * 
	 * @param line User input line to evaluate.
	 * @return <tt>true</tt> if the program should continue to read, <tt>false</tt> otherwise.
	 */
	private boolean eval(final String line) {
		// TODO : Split input into token.
		final String name = ""; // TODO : Retrieves command name from token.
		final Consumer<List<String>> command = commands.get(name);
		if (command != null) {
			command.accept(null);
		}
		else {
			System.err.println("Unknown command '" + name + "'");
		}
		return true;
	}
	
	/** {@inheritDoc} **/
	@Override
	public void run() {
		if (session == null) {
			throw new IllegalStateException("");
		}
		final Scanner reader = new Scanner(System.in);
		boolean running = true;
		while (running) {
			System.out.print("> ");
			final String input = reader.nextLine();
			running = eval(input);
		}
		reader.close();
	}
	
}
