package io.faylixe.googlecodejam.client.executor;

import io.faylixe.googlecodejam.client.executor.HTTPRequestExecutor;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.junit.Test;

import com.google.api.client.http.javanet.NetHttpTransport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test case for the {@link HTTPRequestExecutor} class.
 * 
 * @author fv
 */
public final class HTTPRequestExecutorTest {

	/** Path of the test resources to reach using our test executor.**/
	private static final String PATH = "";

	/** Hostname used (Google Code Jam server). @**/
	public static final String HOSTNAME = "https://code.google.com";

	/**
	 * Creates and returns a valid {@link HTTPRequestExecutor}
	 * instance that could be used for test. Such instance is not
	 * logged to any google services.
	 * 
	 * @return Created instance.
	 */
	public static HTTPRequestExecutor getTestExecutor() {
		return new HTTPRequestExecutor(HOSTNAME, new NetHttpTransport().createRequestFactory());
	}

	/**
	 * Ensures hostname settled is valid.
	 */
	@Test
	public void testHostname() {
		final HTTPRequestExecutor executor = getTestExecutor();
		assertEquals(HOSTNAME, executor.getHostname());
	}

	/**
	 * Test for the {@link HTTPRequestExecutor#get(String)} method.
	 */
	@Test
	public void testGETRequest() {
		final HTTPRequestExecutor executor = getTestExecutor();
		try {
			final String content = executor.get(PATH);
			// TODO : Test content.
		}
		catch (final IOException e) {
			fail("An error occurs while retrieving content from " + PATH + " : " + e.getMessage());
		}
	}

}
