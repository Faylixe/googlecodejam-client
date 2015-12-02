package io.faylixe.googlecodejam.client.webservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Test;

import io.faylixe.googlecodejam.client.Round;
import io.faylixe.googlecodejam.client.RoundTest;
import io.faylixe.googlecodejam.client.executor.HTTPRequestExecutorTest;
import io.faylixe.googlecodejam.client.webservice.InitialValues;

/**
 * Test case for {@link InitialValues} class.
 * 
 * @author fv
 */
public final class InitialValuesTest {

	/** Expected contest name. **/
	private static final String NAME = "";

	/** Expected start date. **/
	private static final long START = 0;

	/** Expected time until start. **/
	private static final long UNTIL_START = 0;

	/** Expected left time. **/
	private static final long LEFT = 0;

	/** Expected seen values. **/
	private static final int SEEN = 0;

	/** Expected version of this contest. **/
	private static final int VERSION = 0;

	/**
	 * Retrieves the {@link InitialValues}
	 * instance that will be used for testing.
	 * Using the test {@link Round} as reference.
	 * 
	 * @return Instance to use for testing.
	 */
	public static InitialValues getTestInitialValues() {
		final Round round = RoundTest.getTestRound();
		InitialValues values = null;
		try {
			values = InitialValues.get(HTTPRequestExecutorTest.getTestExecutor(), round);
		}
		catch (final IOException e) {
			fail("Error occurs while retrieving contest initial values : " + e.getMessage());
		}
		return values;
	}

	/**
	 * Ensures retrieved {@link InitialValues} are
	 * consistent. Using values from {@link Round}
	 * test instance.
	 * 
	 * TODO Finalizes test (admin, cs, input, login / out HTML, snippet).
	 */
	@Test
	public void testInitialValuesConsistency() {
		final InitialValues values = getTestInitialValues();
		values.getAdmin();
		values.getCS();
		assertTrue(values.getEmail().isEmpty());
		values.getInput();
		assertEquals(LEFT, values.getLeft());
		values.getLoginHTML();
		values.getLogoutHTML();
		assertEquals(NAME, values.getName());
		assertEquals(SEEN, values.getSeen());
		values.getSnippet();
		assertEquals(START, values.getStart());
		assertEquals(UNTIL_START, values.getUntilStart());
		assertEquals(VERSION, values.getVersion());
		assertFalse(values.isLogged());
		assertFalse(values.isQualified());
	}

}
