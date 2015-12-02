package io.faylixe.googlecodejam.client;

import io.faylixe.googlecodejam.client.common.HTMLConstant;
import io.faylixe.googlecodejam.client.common.NamedObject;
import io.faylixe.googlecodejam.client.executor.HTTPRequestExecutor;

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

	/** Serialization index. **/
	private static final long serialVersionUID = 1L;

	/** URL of the contest index page. **/
	public static final String CONTEST_INDEX = "/codejam/contests.html";

	/** Class name of the element that contains contest data. **/
	public static final String CONTEST_CLASS_NAME = "year_row";

	/** {@link Round} that belongs to this contest. **/
	private final List<Round> rounds;

	/**
	 * Default constructor.
	 * 
	 * @param name Name of this contest.
	 * @param rounds {@link Round} that belongs to this contest.
	 */
	protected Contest(final String name, final List<Round> rounds) {
		super(name);
		this.rounds = rounds;
	}
	
	/**
	 * Getter that returns a immutable view
	 * of the {@link Round} list.
	 * 
	 * @return List of the round of this contest.
	 * @see Collections#unmodifiableList(List)
	 */
	public List<Round> getRounds() {
		return Collections.unmodifiableList(rounds);
	}


	/**
	 * Static factory method that retrieves contest name
	 * from a given HTML contest element.
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
	 * Creates and returns a contest instance from the given
	 * <tt>year</tt> HTML element.
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
	 * Retrieves and returns a list of available
	 * contest for the given <tt>hostname</tt>
	 * 
	 * @param executor {@link HTTPRequestExecutor} instance to use to retrieve contest index.
	 * @return List of contest extracted.
	 * @throws IOException If any error occurs during contest extraction process.
	 */
	public static List<Contest> get(final HTTPRequestExecutor executor) throws IOException {
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
