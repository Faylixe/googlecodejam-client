package io.faylixe.googlecodejam.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import io.faylixe.googlecodejam.client.common.Resources;
import io.faylixe.googlecodejam.client.executor.HTTPRequestExecutorTest;
import io.faylixe.googlecodejam.client.webservice.ContestInfo;
import io.faylixe.googlecodejam.client.webservice.ContestInfoTest;
import io.faylixe.googlecodejam.client.webservice.Problem;
import io.faylixe.googlecodejam.client.webservice.ProblemInput;
import io.faylixe.googlecodejam.client.webservice.ProblemTest;

/**
 * Test case for {@link CodeJamSession} class.
 * 
 * @author fv
 */
public final class CodeJamSessionTest {

	/** Path of the file that contains expected analysis content for the test problem. **/
	private static final String ANALYSIS_PATH = "analysis.txt";

	/** **/
	private static final String TYPE = "practice";

	/** Expected size of the downloaded input, in number of line. **/
	private static final int INPUT_SIZE = 1001; // TODO : Fetch the good one :).

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
			session = CodeJamSession.createSession(HTTPRequestExecutorTest.getTestExecutor(), round);
		}
		catch (final IOException e) {
			fail("Error occurs while retrieving session : " + e.getMessage());
		}
		return session;
	}

	/**
	 * Ensures that the internal contest
	 * info instance used is the one
	 * expected.
	 */
	@Test
	public void testContestInfo() {
		final CodeJamSession session = getTestSession();
		final ContestInfo info = session.getContestInfo();
		// TODO : Test equality instead ?
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
		try {
			final String analysis = session.getContestAnalysis(problem);
			final String expected = Resources.getResource(ANALYSIS_PATH);
			assertEquals(expected, analysis);
		}
		catch (final IOException e) {
			fail("An error occurs while retrieving contest analysis : " + e.getMessage());
		}
	}

	/**
	 * Ensures that the given problem input file
	 * as list of read <tt>lines</tt> is a valid
	 * input file regarding to the problem input
	 * specification.
	 * 
	 * @param lines Lines of the files to ensure consistency from.
	 */
	private void ensureInputConsistency(final List<String> lines) {
		final int n = Integer.valueOf(lines.remove(0));
		for (int i = 0; i < n; i++) {
			// TODO : Read lines.
		}
		assertTrue(lines.isEmpty());
	}

	/**
	 * Test for the {@link CodeJamSession#download(ProblemInput)}
	 * method, using the test {@link Problem} as a reference.
	 */
	@Test
	public void testDownload() {
		final CodeJamSession session = getTestSession();
		final ContestInfo info = session.getContestInfo();
		final Problem problem = info.getProblem(0);
		final ProblemInput input = problem.getProblemInput(0);
		try {
			final InputStream stream = session.download(input, TYPE);
			final InputStreamReader reader = new InputStreamReader(stream);
			final BufferedReader bufferedReader = new BufferedReader(reader);
			final List<String> lines = bufferedReader.lines().collect(Collectors.toList());
			assertEquals(INPUT_SIZE, lines.size());
			System.out.println(lines);
			ensureInputConsistency(lines);
		}
		catch (final IOException e) {
			fail("An error occurs while downloading test input : " + e.getMessage());
		}
	}

}
