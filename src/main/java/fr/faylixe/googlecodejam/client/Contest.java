package fr.faylixe.googlecodejam.client;

import fr.faylixe.googlecodejam.client.common.NamedObject;
import fr.faylixe.googlecodejam.client.executor.HttpRequestExecutor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

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
	public static final String CONTEST_INDEX = "/codejam/past-contests?data=1";

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

	private static class JSONRound {
		private String name;
		private String id;
	}
	
	private static class JSONContest {
		@SerializedName("contests")
		private JSONRound[] rounds;
		private String name;
	}
	private static class JSONTab {
		@SerializedName("tournaments")
		private JSONContest[] contests;
	}
	private static class JSONData {
		private JSONTab[] tabs;
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
		final List<Contest> contests = new ArrayList<Contest>();
		final String content = executor.get(CONTEST_INDEX);
		final Gson gson = new Gson();
		final JSONData data = gson.fromJson(content, JSONData.class);
		for (final JSONTab tab : data.tabs) {
			for (final JSONContest contest : tab.contests) {
				final List<Round> rounds = new ArrayList<Round>(contest.rounds.length);
				for (final JSONRound round : contest.rounds) {
					final String url = new StringBuilder(Round.CODEJAM_PATH)
						.append(round.id)
						.append(Round.ROUND_PREFIX)
						.toString();
					rounds.add(new Round(contest.name, round.name, url));
				}
				contests.add(new Contest(contest.name, rounds));
			}
		}
		return contests;
	}

}
