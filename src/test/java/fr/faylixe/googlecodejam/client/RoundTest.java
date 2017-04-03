package fr.faylixe.googlecodejam.client;

import static org.junit.Assert.assertEquals;
import fr.faylixe.googlecodejam.client.Contest;
import fr.faylixe.googlecodejam.client.Round;

import java.util.List;

import org.junit.Test;

/**
 * Test case for the {@link Round} class.
 * 
 * @author fv
 */
public final class RoundTest {

	/** Expected URL of the round retrieved. **/
	private static final String URL = "/codejam/contest/9214486/dashboard";

	/** Expected name of the retrieved round. **/
	private static final String NAME = "Code Jam";

	/**
	 * Retrieves the round instance that will
	 * be used for testing. Such round will be the first
	 * of the target test contest.
	 * 
	 * @return Round instance for testing.
	 */
	public static Round getTestRound() {
		final Contest contest = ContestTest.getTestContests();
		final List<Round> rounds = contest.getRounds();
		final Round round = rounds.get(0);
		return round;
	}

	/**
	 * Ensures retrieved rounds are consistent.
	 * Uses the target contest test first round.
	 */
	@Test
	public void testRoundConsistency() {
		final Round round = getTestRound();
		assertEquals(URL, round.getURL());
		assertEquals(NAME, round.getName());
		assertEquals(ContestTest.NAME, round.getContestName());
	}

}
