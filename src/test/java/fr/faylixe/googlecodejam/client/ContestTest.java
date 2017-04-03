package fr.faylixe.googlecodejam.client;

import fr.faylixe.googlecodejam.client.Contest;
import fr.faylixe.googlecodejam.client.Round;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Test case for {@link Contest} class.
 * 
 * @author fv
 */
public final class ContestTest {

	/** Expected name of the retrieved contest. **/
	protected static final String NAME = "Code Jam to I/O 2015 for Women";

	/** Expected number of round for the retrieved contest. **/
	private static final int ROUND = 1;

	/** **/
	private static Contest testInstance;

	/**
	 * Retrieves the contest instance that will
	 * be used for testing. Such contest will be
	 * the last, assuming the the last contest
	 * will never change.
	 * 
	 * @return Contest instance for testing.
	 */
	public static Contest getTestContests() {
		if (testInstance == null) {
			try {
				final List<Contest> contests = Contest.get(HttpRequestExecutorMock.getTestExecutor());
				testInstance = contests.get(contests.size() - 1);
			}
			catch (final IOException | GeneralSecurityException e) {
				fail("Error occurs whiel retrieving contest : " + e.getMessage());
			}
		}
		return testInstance;
	}

	/**
	 * Ensures retrieved contests are consistent.
	 * In order to do so, it consider that the last extracted
	 * contest should never change (the older always stays the older).
	 */
	@Test
	public void testContestConsistency() {	
		final Contest contest = getTestContests();
		assertEquals(NAME, contest.getName());
		final List<Round> rounds = contest.getRounds();
		assertEquals(ROUND, rounds.size());
	}

}
