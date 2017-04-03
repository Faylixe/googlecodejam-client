package fr.faylixe.googlecodejam.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import fr.faylixe.googlecodejam.client.CodeJamSession;
import fr.faylixe.googlecodejam.client.Round;
import fr.faylixe.googlecodejam.client.common.Resources;
import fr.faylixe.googlecodejam.client.webservice.ContestInfo;
import fr.faylixe.googlecodejam.client.webservice.ContestInfoTest;
import fr.faylixe.googlecodejam.client.webservice.Problem;
import fr.faylixe.googlecodejam.client.webservice.ProblemInput;
import fr.faylixe.googlecodejam.client.webservice.ProblemTest;
import fr.faylixe.googlecodejam.client.webservice.SubmitResponse;

/**
 * Test case for {@link CodeJamSession} class.
 * 
 * @author fv
 */
public final class CodeJamSessionTest {

	/** Path of the file that contains expected analysis content for the test problem. **/
	private static final String ANALYSIS_PATH = "analysis.txt";

	/** Expected size of the downloaded input, in number of line. **/
	private static final int INPUT_SIZE = 201;

	/** Expected submission message. **/
	private static final String MESSAGE = "Good Job!";

	/**
	 * Retrieves a valid {@link CodeJamSession}
	 * that should be used for testing.
	 * Such session is not connected.
	 * 
	 * @return Session instance that should be used for testing.
	 */
	public static CodeJamSession getTestSession() {
		final Round round = RoundTest.getTestRound();
		CodeJamSession session = null;
		try {
			session = CodeJamSession.createSession(HttpRequestExecutorMock.getTestExecutor(), round);
		}
		catch (final IOException | GeneralSecurityException e) {
			fail("Error occurs while retrieving session : " + e.getMessage());
		}
		return session;
	}
	
	/**
	 * Ensures that the internal contest info instance used
	 * is the one expected. Also test session related properties,
	 * like if user is qualified or is the contest is active.
	 */
	@Test
	public void testSessionConsistency() {
		final CodeJamSession session = getTestSession();
		assertFalse(session.isActive());
		assertFalse(session.isLogged());
		assertFalse(session.isQualified());
		final ContestInfo info = session.getContestInfo();
		ContestInfoTest.testContestInfoConsistency(info);
	}

	/**
	 * Test for the {@link CodeJamSession#getContestAnalysis(Problem)}
	 * method, using the test {@link Problem} as a reference.
	 */
	@Test
	public void testContestAnalysis() {
		final CodeJamSession session = getTestSession();
		final Problem problem = ProblemTest.getTestProblem();
		final String analysis = session.getContestAnalysis(problem);
		final String expected = Resources.getResource(ANALYSIS_PATH);
		assertEquals(expected
				.replaceAll(" ", "")
				.replaceAll("\n", ""), 
				analysis
					.replaceAll(" ", "")
					.replaceAll("\r\n", ""));
	}

	/**
	 * Retrieves the problem input instance to use for
	 * download and submission test case.
	 * 
	 * @param session Session to retrieve problem input from.
	 * @return Problem input test instance.
	 */
	private ProblemInput getTestInput(final CodeJamSession session) {
		final ContestInfo info = session.getContestInfo();
		final Problem problem = info.getProblem(0);
		final ProblemInput input = problem.getProblemInput(0);
		return input;
	}

	/**
	 * Performs the download request for the target
	 * test input using the given <tt>session</tt>
	 * 
	 * @param session Session to download problem input file from.
	 * @return Input file content.
	 */
	private List<String> getTestInputContent(final CodeJamSession session) {
		final ProblemInput input = getTestInput(session);
		try {
			final InputStream stream = session.download(input);
			final InputStreamReader reader = new InputStreamReader(stream);
			final BufferedReader bufferedReader = new BufferedReader(reader);
			return bufferedReader.lines().collect(Collectors.toList());
		}
		catch (final IOException e) {
			fail("An error occurs while downloading test input : " + e.getMessage());
		}
		return Collections.emptyList();
	}

	/**
	 * Test for the {@link CodeJamSession#download(ProblemInput)}
	 * method, using the test {@link Problem} as a reference.
	 */
	@Test
	public void testDownload() {
		final CodeJamSession session = getTestSession();
		final List<String> lines = getTestInputContent(session);
		assertEquals(INPUT_SIZE, lines.size());
		final int n = Integer.valueOf(lines.remove(0));
		for (int i = 0; i < n * 2; i++) {
			lines.remove(0);
		}
		assertTrue(lines.isEmpty());
	}

	/**
	 * Test for the {@link CodeJamSession#submit(ProblemInput, File, File)}
	 * method, using the test {@link Problem} as a reference.
	 */
	@Test
	public void testSubmission() {
		final CodeJamSession session = getTestSession();
		final List<String> lines = getTestInputContent(session);
		final int n = Integer.valueOf(lines.remove(0));
		try {
			final File output = Files.createTempFile(null, null).toFile();
			final File source = Files.createTempFile(null, null).toFile();
			source.createNewFile();
			final BufferedWriter writer = new BufferedWriter(new FileWriter(output));
			for (int i = 0; i < n; i++) {
				final int b = Integer.valueOf(lines.remove(0));
				final String s = lines.remove(0);
				final StringBuilder result = new StringBuilder();
				for (int j = 0; j < b; j++) {
					final String bytes = s
							.substring(j * 8, (j + 1) * 8)
							.replaceAll("O", "0")
							.replaceAll("I", "1");
					final int v = Integer.parseInt(bytes, 2);
					result.append((char) v);
				}
				writer.write("Case #" + (i + 1) + ": " + result.toString());
				writer.newLine();
			}
			writer.close();
			final ProblemInput input = getTestInput(session);
			final SubmitResponse response = session.submit(input, output, source);
			assertTrue(response.isSuccess());
			assertEquals(MESSAGE, response.getMessage());
		}
		catch (final IOException e) {
			fail("An error occurs during submission process : " + e.getMessage());
		}
	}

}
