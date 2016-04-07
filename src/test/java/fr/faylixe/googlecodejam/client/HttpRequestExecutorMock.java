package fr.faylixe.googlecodejam.client;

import java.io.IOException;
import java.security.GeneralSecurityException;

import fr.faylixe.googlecodejam.client.executor.HttpRequestExecutor;
import fr.faylixe.googlecodejam.client.executor.Request;

/**
 * Test case for the {@link HttpRequestExecutor} class.
 * 
 * @author fv
 */
public final class HttpRequestExecutorMock {

	/**
	 * Creates and returns a valid {@link HttpRequestExecutor}
	 * instance that could be used for test. Such instance is not
	 * logged to any google services.
	 * 
	 * @return Created instance.
	 * @throws IOException If any error occurs while creating mock instance.
	 * @throws IOException If any error occurs while creating mock instance.
	 */
	public static HttpRequestExecutor getTestExecutor() throws GeneralSecurityException, IOException {
		return HttpRequestExecutor.create(Request.getHostname());
	}

}
