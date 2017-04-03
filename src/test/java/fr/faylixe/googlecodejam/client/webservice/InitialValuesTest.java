package fr.faylixe.googlecodejam.client.webservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.junit.Test;

import fr.faylixe.googlecodejam.client.HttpRequestExecutorMock;
import fr.faylixe.googlecodejam.client.Round;
import fr.faylixe.googlecodejam.client.RoundTest;
import fr.faylixe.googlecodejam.client.webservice.InitialValues;

/**
 * Test case for {@link InitialValues} class.
 * 
 * @author fv
 */
public final class InitialValuesTest {

	/** Expected input panel content. **/
	private static final String INPUT = "<span>Contestants must sign in to download inputs and submit.</span>";

	/** Expected login HTML content. **/
	private static final String LOGIN = "<a href=\"https://www.google.com/accounts/ServiceLogin?service=ah&passive=true&continue=https://appengine.google.com/_ah/conflogin%3Fcontinue%3Dhttps://code.google.com/codejam/contest/dashboard%253Fc%253D9214486&ltmpl=\">Sign in</a>";

	/** Expected logout HTML content. **/
	private static final String LOGOUT = "<a href=\"https://code.google.com/_ah/logout?continue=https://www.google.com/accounts/Logout%3Fcontinue%3Dhttps://appengine.google.com/_ah/logout%253Fcontinue%253Dhttps://code.google.com/codejam/contest%26service%3Dah\">Sign out</a>";

	/** Expected contest name. **/
	private static final String NAME = "Code Jam to I/O 2015 for Women";

	/** Expected start date. **/
	private static final long START = 1429981200;

	/** Expected CS value. **/
	private static final int CS = 4;

	/** Expected seen values. **/
	private static final int SEEN = 0;

	/** Expected version of this contest. **/
	private static final int VERSION = 8;

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
			values = InitialValues.get(HttpRequestExecutorMock.getTestExecutor(), round);
		}
		catch (final IOException | GeneralSecurityException e) {
			fail("Error occurs while retrieving contest initial values : " + e.getMessage());
		}
		return values;
	}

	/**
	 * Ensures retrieved {@link InitialValues} are
	 * consistent. Using values from {@link Round}
	 * test instance.
	 */
	@Test
	public void testInitialValuesConsistency() {
		final InitialValues values = getTestInitialValues();
		assertTrue(values.getAdmin().isEmpty());
		assertEquals(CS, values.getCS());
		assertNull(values.getEmail());
		assertEquals(INPUT, values.getInput());
		assertTrue(values.getLeft() <= 0);
		assertEquals(LOGIN, values.getLoginHTML());
		assertEquals(LOGOUT, values.getLogoutHTML());
		assertEquals(NAME, values.getName());
		assertEquals(SEEN, values.getSeen());
		assertTrue(values.getSnippet().isEmpty());
		assertEquals(START, values.getStart());
		assertTrue(values.getUntilStart() <= 0);
		assertEquals(VERSION, values.getVersion());
		assertFalse(values.isLogged());
		assertFalse(values.isQualified());
	}

}
