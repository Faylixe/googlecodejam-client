package fr.faylixe.googlecodejam.client;

import fr.faylixe.googlecodejam.client.common.NamedObject;
import fr.faylixe.googlecodejam.client.executor.HttpRequestExecutor;
import fr.faylixe.googlecodejam.client.executor.Request;
import fr.faylixe.googlecodejam.client.webservice.InitialValues;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * <p>POJO class that represents a Google Jam {@link Round}.
 * A {@link Round} is defined by a name, and a dashboard
 * URL.</p>
 * 
 * @author fv
 */
public final class Round extends NamedObject {

	/** <p>Serialization index.</p> **/
	private static final long serialVersionUID = 1L;

	/** URL path of a contest. **/
	protected static final String CODEJAM_PATH = "/codejam/contest/";

	/** Prefix for built round URL. **/
	protected static final String ROUND_PREFIX = "/dashboard";

	/** Label used for parent contest when parent could not be retrieved. **/
	private static final String UNKNOWN_PARENT = "unkwown-contest";

	/** <p>Class name of the HTML description node.</p> **/
	public static final String DESCRIPTION_CLASS_NAME = "desc";

	/** <p>Name of the parent contest.</p> **/
	private final String parent;

	/** <p>URL of this round dashboard.</p> **/
	private final String url;

	/**
	 * <p>Default constructor.</p>
	 * 
	 * @param parent Name of the parent contest of this round.
	 * @param name Name of this round.
	 * @param url URL of this round dashboard.
	 */
	protected Round(final String parent, final String name, final String url) {
		super(name);
		this.parent = parent;
		this.url = url;
	}

	/**
	 * <p>Getter for the parent contest name.</p>
	 * 
	 * @return Name of the parent contest.
	 */
	public String getContestName() {
		return parent;
	}

	/**
	 * <p>Getter for round dashboard URL.</p>
	 * 
	 * @return URL of this round dashboard.
	 */
	public String getURL() {
		return url;
	}
	
	/** {@inheritDoc} **/
	@Override
	public int hashCode() {
		return url.hashCode();
	}
	
	/** {@inheritDoc} **/
	@Override
	public boolean equals(final Object object) {
		if (object == this) {
			return true;
		}
		if (object == null || object.getClass() != getClass()) {
			return false;
		}
		final Round other = (Round) object;
		return url.equals(other.getURL());
	}

	/**
	 * <p>Static factory method that creates a round from the
	 * given <tt>identifier</tt>.</p>
	 * 
	 * @param identifier Round id to use.
	 * @param cookie Cookie value to use for retrieving contest.
	 * @return Created round.
	 * @throws IOException If any error occurs while retrieving round information.
	 * @throws GeneralSecurityException If any error occurs while creating {@link HttpRequestExecutor} instance.
	 */
	public static Round fromIdentifier(final String identifier, final String cookie) throws GeneralSecurityException, IOException {
		final StringBuilder builder = new StringBuilder();
		builder
			.append(CODEJAM_PATH)
			.append(identifier)
			.append(ROUND_PREFIX);
		return fromURL(builder.toString(), cookie);
	}

	/**
	 * <p>Static factory method that creates a round from the
	 * given <tt>url</tt>.</p>
	 * 
	 * @param url Round url.
	 * @param cookie Cookie value to use for retrieving contest.
	 * @return Created round.
	 * @throws IOException If any error occurs while retrieving round information.
	 * @throws GeneralSecurityException If any error occurs while creating {@link HttpRequestExecutor} instance.
	 */
	public static Round fromURL(final String url, final String cookie) throws GeneralSecurityException, IOException {
		final HttpRequestExecutor executor = HttpRequestExecutor.create(Request.getHostname(), cookie);
		final InitialValues values = InitialValues.get(executor, new Round("", "", url));
		return new Round(UNKNOWN_PARENT, values.getName(), url);
	}

}
