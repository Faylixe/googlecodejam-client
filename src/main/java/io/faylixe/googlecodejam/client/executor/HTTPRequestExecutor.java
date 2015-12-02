package io.faylixe.googlecodejam.client.executor;

import java.io.IOException;
import java.util.Map;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;

/**
 * <p>Abstract implementation for {@link IHTTPRequestExecutor}
 * interface that handles hostname.</p>
 * 
 * @author fv
 */
public final class HTTPRequestExecutor {

	/** Target hostname to which HTTP request are made. **/
	private final String hostname;

	/** Factory used for building HTTP request. **/
	private final HttpRequestFactory requestFactory;

	/**
	 * Default constructor. Initializes hostname value.
	 * 
	 * @param hostname Hostname used by this executor.
	 * @param requestFactory Factory used for building HTTP request.
	 */
	public HTTPRequestExecutor(final String hostname, final HttpRequestFactory requestFactory) {
		this.hostname = hostname;
		this.requestFactory = requestFactory;
	}

	/**
	 * Getter for the target hostname.
	 * 
	 * @return Target hostname this executor is performing request to.
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * Creates and returns a GET {@link HttpRequest} instance
	 * for the given <tt>path</tt> over the internal hostname.
	 * 
	 * @param path Path of the request to build.
	 * @return Built GET request.
	 * @throws IOException If any error occurs while creating the GET request.
	 */
	public HttpRequest getRequest(final String path) throws IOException {
		final StringBuilder builder = new StringBuilder(getHostname());
		builder.append(path);
		final GenericUrl url = new GenericUrl(builder.toString());
		return requestFactory.buildGetRequest(url);
	}
	
	/**
	 * Performs a HTTP GET request to the given <tt>path</tt>
	 * relative to the internal target hostname. The response
	 * is returned as a {@link String}.
	 * 
	 * @param path Relative server path to perform request to.
	 * @return Response content of the performed request.
	 * @throws IOException If any error occurs while performing request.
	 * @see {@link #getStream(String)}
	 */
	public String get(final String path) throws IOException {
		final HttpRequest request = getRequest(path);
		final HttpResponse response = request.execute();
		return response.parseAsString();
	}

	/**
	 * Performs a HTTP POST request to the given <tt>path</tt>
	 * relative to the internal target hostname.
	 * 
	 * @param path Relative server path to perform request to.
	 * @return Response content of the performed request.
	 */
	public String post(final String path, final Map<String, String> parameters) {
		return null;
	}

}
