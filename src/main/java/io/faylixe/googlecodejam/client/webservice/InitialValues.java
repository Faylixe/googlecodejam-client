package io.faylixe.googlecodejam.client.webservice;

import java.io.IOException;

import io.faylixe.googlecodejam.client.Round;
import io.faylixe.googlecodejam.client.executor.HTTPRequestExecutor;

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
public final class InitialValues {

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

	/** Time left before contest finish. **/
	@SerializedName("second_left")
	private long left;

	/** Amout of time until this contest start. **/
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
	 * @return
	 */
	public String getAdmin() {
		return admin;
	}

	/**
	 * 
	 * @return
	 */
	public int getSeen() {
		return seen;
	}

	/**
	 * 
	 * @return
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
	 * Getter for the user email.
	 * 
	 * @return Email of this logged user.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @return
	 */
	public String getInput() {
		return input;
	}

	/**
	 * 
	 * @return
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
	 * @return Time left before contest finish.
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
	 * 
	 * @param round
	 * @param executor
	 * @return
	 * @throws IOException 
	 */
	public static InitialValues get(final HTTPRequestExecutor executor, final Round round) throws IOException {
		final StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(round.getURL())
			.append(Request.COMMAND)
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
