package fr.faylixe.googlecodejam.client.application;

import java.io.IOException;

import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import fr.faylixe.googlecodejam.client.executor.HTTPRequestExecutor;
import fr.faylixe.googlecodejam.client.executor.SeleniumCookieSupplier;

/**
 * <p>Main application that allows to
 * interact with this API through a
 * command line based client.</p>
 * 
 * @author fv
 */
public final class CommandLineApplication {

	/** Default hostname used by this client. **/
	private static final String DEFAULT_HOSTNAME = "https://code.google.com";

	/** Cookies header name. **/
	private static final String COOKIE_HEADER = "SACSID=";

	/**
	 * Application entry point. Creates {@link IHTTPRequestExecutor}
	 * and starts client.
	 * 
	 * @param args Command line parameters provided.
	 */
	public static void main(final String [] args) {
		// Print header.
		System.out.println("####################################");
		System.out.println("Google Code Jam command line client");
		System.out.println("####################################\n");
		System.out.println("Firefox browser will open, please authenticate to your Google account with it");
		final SeleniumCookieSupplier supplier = new SeleniumCookieSupplier(DEFAULT_HOSTNAME + "/codejam", FirefoxDriver::new);
		final String cookie = COOKIE_HEADER + supplier.get();
		final HttpTransport transport = new NetHttpTransport();
		final HttpRequestFactory requestFactory =  transport.createRequestFactory(request -> {
			final HttpHeaders headers = request.getHeaders();
			headers.setCookie(cookie);
		});
		final HTTPRequestExecutor executor = new HTTPRequestExecutor(DEFAULT_HOSTNAME, requestFactory);
		final CodeJamClient client = new CodeJamClient(executor);
		try {
			client.selectRound();
		}
		catch (final IOException e) {
			System.err.println("An error occurs while selecing active round : " + e.getMessage());
			e.printStackTrace();
			System.exit(-1);
		}
		
		client.run();
	}

}
