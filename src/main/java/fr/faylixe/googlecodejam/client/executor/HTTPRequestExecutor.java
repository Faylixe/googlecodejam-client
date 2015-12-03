package fr.faylixe.googlecodejam.client.executor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.UrlEncodedContent;

/**
 * <p>A {@link HTTPRequestExecutor} is an abstraction
 * on top of {@link HttpRequestFactory} that handles
 * GET and POST request.</p>
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
	 * Builds and returns a {@link GenericUrl} instance
	 * using the given <tt>path</tt> relative to the
	 * internal hostname.
	 * 
	 * @param path Path of the request to build.
	 * @return Hostname relative URL built.
	 */
	private GenericUrl getURL(final String path) {
		final StringBuilder builder = new StringBuilder(getHostname());
		builder.append(path);
		return new GenericUrl(builder.toString());
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
		final GenericUrl url = getURL(path);
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
	 * @see #getRequest(String)
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
	 * @param parameters POST parameters that will be URL encoded and sent.
	 * @return Response content of the performed request.
	 * @throws IOException If any error occurs while performing request.
	 */
	public InputStream post(final String path, final Map<String, String> parameters) throws IOException {
		final GenericUrl url = getURL(path);
		final HttpContent content = new UrlEncodedContent(parameters);
		final HttpRequest request = requestFactory.buildPostRequest(url, content);
		final HttpResponse response = request.execute();
		return response.getContent();
	}

}
