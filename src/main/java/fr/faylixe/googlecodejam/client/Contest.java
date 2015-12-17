package fr.faylixe.googlecodejam.client;

import fr.faylixe.googlecodejam.client.common.HTMLConstant;
import fr.faylixe.googlecodejam.client.common.NamedObject;
import fr.faylixe.googlecodejam.client.executor.HttpRequestExecutor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * <p>POJO class that represents a Google Jam {@link Contest}.
 * A {@link Contest} is represented by a name and a
 * collection of {@link Round}.</p>
 * 
 * @author fv
 */
public final class Contest extends NamedObject {

	/** <p>Serialization index.</p> **/
	private static final long serialVersionUID = 1L;

	/** <p>URL of the contest index page.</p> **/
	public static final String CONTEST_INDEX = "/codejam/contests.html";

	/** <p>Class name of the element that contains contest data.</p> **/
	public static final String CONTEST_CLASS_NAME = "year_row";

	/** <p>{@link Round} that belongs to this contest.</p> **/
	private final List<Round> rounds;

	/**
	 * <p>Default constructor.</p>
	 * 
	 * @param name Name of this contest.
	 * @param rounds {@link Round} that belongs to this contest.
	 */
	protected Contest(final String name, final List<Round> rounds) {
		super(name);
		this.rounds = rounds;
	}
	
	/**
	 * <p>Getter that returns a immutable view
	 * of the {@link Round} list.</p>
	 * 
	 * @return List of the round of this contest.
	 * @see Collections#unmodifiableList(List)
	 */
	public List<Round> getRounds() {
		return Collections.unmodifiableList(rounds);
	}

	/** {@inheritDoc} **/
	@Override
	public int hashCode() {
		return getName().hashCode();
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
		final Contest other = (Contest) object;
		return getName().equals(other.getName());
	}

	/**
	 * <p>Static factory method that retrieves contest name
	 * from a given HTML contest element.</p>
	 * 
	 * @param element JSoup element to retrieve title from.
	 * @return Optional reference of a contest title.
	 */
	private static Optional<String> getName(final Element element) {
		final Elements candidates = element.getElementsByTag(HTMLConstant.H3);
		if (!candidates.isEmpty()) {
			return Optional.of(candidates.first().text());
		}
		return Optional.empty();
	}

	/**
	 * <p>Creates and returns a contest instance from the given
	 * <tt>year</tt> HTML element.</p>
	 * 
	 * @param year HTML element to extract contest from.
	 * @return Created contest if any.
	 */
	private static Optional<Contest> buildContest(final Element year) {
		final Optional<String> name = getName(year);
		Contest contest = null;
		if (name.isPresent()) {
			final String contestName = name.get();
			final List<Round> rounds = Round.get(year, contestName);
			contest = new Contest(contestName, rounds);
		}
		return Optional.ofNullable(contest);
	}

	/**
	 * <p>Retrieves and returns a list of available
	 * contest for the given <tt>hostname</tt>.</p>
	 * 
	 * @param executor {@link HttpRequestExecutor} instance to use to retrieve contest index.
	 * @return List of contest extracted.
	 * @throws IOException If any error occurs during contest extraction process.
	 */
	public static List<Contest> get(final HttpRequestExecutor executor) throws IOException {
		final String content = executor.get(CONTEST_INDEX);
		final Document document = Jsoup.parse(content);
		final Elements years = document.getElementsByClass(CONTEST_CLASS_NAME);
		final List<Contest> contests = new ArrayList<Contest>(years.size());
		for (final Element year : years) {
			final Optional<Contest> contest = buildContest(year);
			if (contest.isPresent()) {
				contests.add(contest.get());
			}
		}
		return contests;
	}

}
