package fr.faylixe.googlecodejam.client.executor;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.MultipartContent.Part;

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
	 * @param content POST content that will be sent.
	 * @return Response content of the performed request.
	 * @throws IOException If any error occurs while performing request.
	 */
	public String post(final String path, final HttpContent content) throws IOException {
		final GenericUrl url = getURL(path);
		final HttpRequest request = requestFactory.buildPostRequest(url, content);
		final HttpResponse response = request.execute();
		return response.parseAsString();
	}

	/**
	 * Static factory method that creates a {@link Part} which contains
	 * simple form data.
	 * 
	 * @param name Name of the POST data to create part for.
	 * @param data Value of the POST data to create part for.
	 * @return Created data part.
	 */
	public static Part buildDataPart(final String name, final String data) {
		final ByteArrayContent content = new ByteArrayContent(null, data.getBytes());
		final Part part = new Part(content);
		final HttpHeaders headers = new HttpHeaders();
		final String disposition = String.format(Request.DATA_CONTENT_DISPOSITION, name);
		headers.set(Request.CONTENT_DISPOSITION, disposition);
		part.setHeaders(headers);
		return part;
	}

	/**
	 * Static factory method that creates a {@link Part} which contains
	 * file form data.
	 * 
	 * @param name name Name of the POST file data to create part for.
	 * @param file File of the POST data to create part for.
	 * @return Created data part.
	 * @throws IOException If any any error occurs during file type detection.
	 */
	public static Part buildFilePart(final String name, final File file) throws IOException {
		final String type = Files.probeContentType(file.toPath());
		final FileContent content = new FileContent(type, file);
		final Part part = new Part(content);
		final HttpHeaders headers = new HttpHeaders();
		final String disposition = String.format(Request.FILE_CONTENT_DISPOSITION, name, file.getName());
		headers.set(Request.CONTENT_DISPOSITION, disposition);
		part.setHeaders(headers);
		return part;
	}

}
