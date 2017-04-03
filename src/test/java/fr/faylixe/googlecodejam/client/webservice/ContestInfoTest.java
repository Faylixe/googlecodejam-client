package fr.faylixe.googlecodejam.client.webservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import fr.faylixe.googlecodejam.client.HttpRequestExecutorMock;
import fr.faylixe.googlecodejam.client.Round;
import fr.faylixe.googlecodejam.client.RoundTest;
import fr.faylixe.googlecodejam.client.webservice.ContestInfo;
import fr.faylixe.googlecodejam.client.webservice.Problem;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import org.junit.Test;

/**
 * Test case for {@link ContestInfo} class.
 * 
 * @author fv
 */
public final class ContestInfoTest {

	/** Expected version of this contest. **/
	private static final int VERSION = 0;

	/** Expected number of problem instance. **/
	private static final int PROBLEM = 4;

	/**
	 * Retrieves the {@link ContestInfo} instance
	 * that will be used for testing. Using
	 * test {@link Round} as reference.
	 * 
	 * @return ContestInfo instance for testing.
	 */
	public static ContestInfo getTestContestInfo() {
		final Round round = RoundTest.getTestRound();
		ContestInfo info = null;
		try {
			info = ContestInfo.get(HttpRequestExecutorMock.getTestExecutor(), round);
		}
		catch (final IOException | GeneralSecurityException e) {
			fail("Error occurs while retrieving contest info : " + e.getMessage());
		}
		return info;
	}

	/**
	 * Ensures the given {@link ContestInfo} is
	 * consistent.
	 * 
	 * @param info {@link ContestInfo} instance to ensure consistency from.
	 */
	public static void testContestInfoConsistency(final ContestInfo info) {
		assertEquals(VERSION, info.getVersion());
		assertTrue(info.hasAnalysis());
		final List<Problem> problems = info.getProblems();
		assertEquals(PROBLEM, problems.size());
	}

	/**
	 * Ensures retrieved {@link ContestInfo} is
	 * consistent. Uses {@link ContestInfo} from
	 * target test {@link Round} instance.
	 */
	@Test
	public void testContestInfoConsistency() {
		final ContestInfo info = getTestContestInfo();
		testContestInfoConsistency(info);
	}

}
