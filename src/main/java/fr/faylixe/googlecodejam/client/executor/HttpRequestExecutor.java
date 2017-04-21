package fr.faylixe.googlecodejam.client.executor;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.*;
import com.google.api.client.http.MultipartContent.Part;
import org.apache.tika.Tika;

import java.io.File;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.security.GeneralSecurityException;

/**
 * <p>A {@link HttpRequestExecutor} is an abstraction
 * on top of {@link HttpRequestFactory} that handles
 * GET and POST request.</p>
 * 
 * @author fv
 */
public final class HttpRequestExecutor implements Serializable {

	/** Serialization index. **/
	private static final long serialVersionUID = 1L;

	/** Target hostname to which HTTP request are made. **/
	private final String hostname;

	/** Factory used for building HTTP request. **/
	private final transient HttpRequestFactory requestFactory;

	/** SACSID cookie token to used by the internal {@link #requestFactory}. **/
	private final String cookieValue;

	/**
	 * Default constructor. Initializes hostname value.
	 * 
	 * @param hostname Hostname used by this executor.
	 * @param requestFactory Factory used for building HTTP request.
	 * @param cookieValue SACSID cookie token to used by the given <tt>requestFactory</tt>.
	 */
	private HttpRequestExecutor(final String hostname, final HttpRequestFactory requestFactory, final String cookieValue) {
		this.hostname = hostname;
		this.requestFactory = requestFactory;
		this.cookieValue = cookieValue;
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
		//Files.probeContentType(file.toPath()) always returns null due to unfixed jdk bug
		//using Tika to fetch file mime type instead
		final String type = new Tika().detect(file);
		final FileContent content = new FileContent(type, file);
		final Part part = new Part(content);
		final HttpHeaders headers = new HttpHeaders();
		final String disposition = String.format(Request.FILE_CONTENT_DISPOSITION, name, file.getName());
		headers.set(Request.CONTENT_DISPOSITION, disposition);
		part.setHeaders(headers);
		return part;
	}
	
	/**
	 * Custom deserialization processing method that
	 * create a new valid {@link HttpRequestExecutor}
	 * instance from the internally stored cookie value.
	 * 
	 * @return Valid {@link HttpRequestExecutor} instance.
	 * @throws ObjectStreamException If any error occurs during deserialization process.
	 */
	private Object readResolve() throws ObjectStreamException {
		try {
			return create(hostname, cookieValue);
		}
		catch (final IOException | GeneralSecurityException e) {
			throw new ObjectStreamException(e.getMessage()) {

				/** Serialization index. **/
				private static final long serialVersionUID = 1L;

			};
		}
	}

	/**
	 * Static factory method that creates a {@link HttpRequestExecutor} instance
	 * which is set using the given <tt>cookie</tt> for building authenticated
	 * HTTP request.
	 * 
	 * @param hostname Hostname to use for the created executor.
	 * @param cookieValue Value of the SACSID cookie to use.
	 * @return Created instance.
	 * @throws IOException If any error occurs while creating http client.
	 * @throws GeneralSecurityException If any error occurs while creating http client.
	 */
	public static HttpRequestExecutor create(final String hostname, final String cookieValue) throws GeneralSecurityException, IOException {
		final String cookie = new StringBuilder()
			.append(Request.COOKIE_NAME)
			.append('=')
			.append(cookieValue)
			.toString();
		final HttpTransport transport = GoogleNetHttpTransport.newTrustedTransport();
		final HttpRequestFactory requestFactory = transport.createRequestFactory(request -> {
			final HttpHeaders headers = request.getHeaders();
			headers.setCookie(cookie);
		});
		return new HttpRequestExecutor(hostname, requestFactory, cookieValue);
	}
	
	/**
	 * Static factory method that creates a non logged
	 * {@link HttpRequestExecutor} instance.
	 * 
	 * @param hostname Hostname to use for the created executor.
	 * @return Created instance.
	 * @throws IOException If any error occurs while creating http client.
	 * @throws GeneralSecurityException If any error occurs while creating http client.
	 * @see #create(String, String)
	 */
	public static HttpRequestExecutor create(final String hostname) throws GeneralSecurityException, IOException {
		return create(hostname, "");
	}

}
