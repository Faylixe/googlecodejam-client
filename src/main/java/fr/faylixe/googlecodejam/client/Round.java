package fr.faylixe.googlecodejam.client;

import fr.faylixe.googlecodejam.client.common.HTMLConstant;
import fr.faylixe.googlecodejam.client.common.NamedObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
	private Round(final String parent, final String name, final String url) {
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
	 * <p>Static factory method that builds a {@link Round} instance
	 * from the given HTML element.</p>
	 * 
	 * @param element Element that contains our round description.
	 * @return Built {@link Round} instance.
	 */
	private static Optional<Round> buildRound(final Element element, final String parent) {
		final Elements links = element.getElementsByTag(HTMLConstant.ANCHOR);
		Round round = null;
		if (!links.isEmpty()) {
			final Element link = links.first();
			final String name = link.text();
			final String url = link.attr(HTMLConstant.HREF);
			round = new Round(parent, name, url);
		}
		return Optional.ofNullable(round);
	}

	/**
	 * <p>Static factory methods that retrieves a list of round
	 * from the given JSoup <tt>contest</tt> node.</p>
	 * 
	 * @param contest Root element of the contest in the contest index page.
	 * @param parent Parent contest name.
	 * @return List of retrieved round.
	 */
	public static List<Round> get(final Element contest, final String parent) {
		final Elements rows = contest.getElementsByTag(HTMLConstant.TR);
		final List<Round> rounds = new ArrayList<Round>(rows.size());
		for (final Element row : rows) {
			final Elements cells = row.getElementsByClass(DESCRIPTION_CLASS_NAME);
			if (!cells.isEmpty()) {
				final Element cell = cells.first();
				buildRound(cell, parent).ifPresent(rounds::add);
			}
		}
		return rounds;
	}

}
