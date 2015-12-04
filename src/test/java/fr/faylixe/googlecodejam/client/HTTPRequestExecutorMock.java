package fr.faylixe.googlecodejam.client;

import fr.faylixe.googlecodejam.client.executor.HTTPRequestExecutor;

import com.google.api.client.http.javanet.NetHttpTransport;

/**
 * Test case for the {@link HTTPRequestExecutor} class.
 * 
 * @author fv
 */
public final class HTTPRequestExecutorMock {

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

}
