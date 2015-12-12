package fr.faylixe.googlecodejam.client.webservice;

import static fr.faylixe.googlecodejam.client.executor.Request.COMMAND_PARAMETER;
import static fr.faylixe.googlecodejam.client.executor.Request.DO;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import fr.faylixe.googlecodejam.client.Round;
import fr.faylixe.googlecodejam.client.executor.HttpRequestExecutor;
import fr.faylixe.googlecodejam.client.executor.Request;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * <p>POJO that aims to be bind to the <tt>GetInitialValues</tt>
 * command request, using Gson API.</p>
 * 
 * TODO Ensures seen is not boolean.
 * 
 * @author fv
 */
public final class InitialValues implements Serializable {

	/** Serialization index. **/
	private static final long serialVersionUID = 1L;

	/** Encoding use for URL encoding. **/
	private static final String ENCODING = "UTF-8";

	/** **/
	@SerializedName("admin_html_snippet")
	private String admin;

	/** **/
	@SerializedName("clar_last_seen")
	private int seen;

	/** **/
	@SerializedName("cs")
	private int cs;

	/** Middleware token that is created when first call <tt>GetInitialValues</tt> command. **/
	@SerializedName("csrf_middleware_token")
	private String token;

	/** Email of this logged user. **/
	@SerializedName("email")
	private String email;

	/** **/
	@SerializedName("input_panel_html")
	private String input;

	/** **/
	@SerializedName("insight_html_snippet")
	private String snippet;

	/** Boolean flag that indicates if user is logged in or not. **/
	@SerializedName("logged_in")
	private boolean logged;

	/** HTML that contains the link of the login page. **/
	@SerializedName("login_html")
	private String loginHTML;

	/** HTML that contains the link of the logout page. **/
	@SerializedName("logout_html")
	private String logoutHTML;

	/** Current contest name. **/
	@SerializedName("name")
	private String name;

	/** Boolean flag that indicates if user is qualified for the next round or not. **/
	@SerializedName("qualified")
	private boolean qualified;

	/** Time left before contest finish (in second). **/
	@SerializedName("second_left")
	private long left;

	/** Amout of time until this contest start (in second). **/
	@SerializedName("second_until_start")
	private long untilStart;

	/** Date of the contest start. **/
	@SerializedName("start_int")
	private long start;

	/** Contest version. **/
	@SerializedName("version")
	private int version;

	/**
	 * 
	 * @return To document
	 */
	public String getAdmin() {
		return admin;
	}

	/**
	 * 
	 * @return To document
	 */
	public int getSeen() {
		return seen;
	}

	/**
	 * 
	 * @return To document
	 */
	public int getCS() {
		return cs;
	}

	/**
	 * 
	 * @return Middleware token that is created when first call <tt>GetInitialValues</tt> command. 
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * Returns an URL encoded form of the middle ware token.
	 * 
	 * @return Middleware token in an URL encoded form.
	 * @throws UnsupportedEncodingException If target encoding is not supported.
	 * @see #getToken()
	 */
	public String getURLEncodedToken() throws UnsupportedEncodingException {
		return URLEncoder.encode(token, ENCODING);
	}

	/**
	 * Getter for the user email.
	 * 
	 * @return Email of this logged user.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @return To document
	 */
	public String getInput() {
		return input;
	}

	/**
	 * 
	 * @return To document
	 */
	public String getSnippet() {
		return snippet;
	}

	/**
	 * Indicates if user is currently logged in.
	 * 
	 * @return <tt>true</tt> if user is logged in, <tt>false</tt> otherwise.
	 */
	public boolean isLogged() {
		return logged;
	}
	
	/**
	 * Getter for the login HTML.
	 * 
	 * @return HTML that contains the link of the login page.
	 */
	public String getLoginHTML() {
		return loginHTML;
	}

	/**
	 * Getter for the logout HTML.
	 * 
	 * @return HTML that contains the link of the logout page.
	 */
	public String getLogoutHTML() {
		return logoutHTML;
	}

	/**
	 * Getter for the contest name.
	 * 
	 * @return Current contest name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Indicates if the currently logged user
	 * is qualified for the next round.
	 * 
	 * @return <tt>true</tt> if the currently logged user is qualified for the next round, <tt>false</tt> otherwise.
	 */
	public boolean isQualified() {
		return qualified;
	}

	/**
	 * Getter for the time left.
	 * 
	 * @return Time left before contest finish (in second).
	 */
	public long getLeft() {
		return left;
	}

	/**
	 * Getter for the time left.
	 * 
	 * @return Amout of time until this contest start.
	 */
	public long getUntilStart() {
		return untilStart;
	}

	/**
	 * Getter for the start date.
	 * 
	 * @return Date of the contest start. 
	 */
	public long getStart() {
		return start;
	}

	/**
	 * Getter for the contest version.
	 * 
	 * @return Contest version.
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * Static factory method that use the <tt>GetInitialValues</tt> command
	 * for the given <tt>round</tt> to retrieve a valud {@link InitialValues} instance.
	 * 
	 * @param executor Executor instance to use for performing the associated request.
	 * @param round Round to extract initial values from.
	 * @return Created instance from request.
	 * @throws IOException If any error occurs during the associated HTTP request.
	 */
	public static InitialValues get(final HttpRequestExecutor executor, final Round round) throws IOException {
		final StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(round.getURL())
			.append(DO)
			.append(COMMAND_PARAMETER)
			.append(Request.INITIAL_VALUES_COMMAND)
			.append(Request.TIME_PARAMETER)
			.append(String.valueOf(System.currentTimeMillis() * 1000))
			.append(Request.CSRF_PARAMETER)
			.append(Request.UNDEFINED); 
		final String json = executor.get(urlBuilder.toString());
		final Gson parser = new Gson();
		return parser.fromJson(json, InitialValues.class);
	}

}
