package fr.faylixe.googlecodejam.client.webservice;

import static org.junit.Assert.assertEquals;
import fr.faylixe.googlecodejam.client.common.Resources;
import fr.faylixe.googlecodejam.client.webservice.ContestInfo;
import fr.faylixe.googlecodejam.client.webservice.Problem;
import fr.faylixe.googlecodejam.client.webservice.ProblemInput;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

/**
 * Test case for the {@link Problem} class.
 *
 * @author fv
 */
public final class ProblemTest {

	/** Path of the file that contains expected body content for the test problem. **/
	private static final String BODY_PATH = "body.txt";

	/** Expected name for the test problem. **/
	private static final String NAME = "I/O Error";

	/** Expected id for the test problem. **/
	private static final String ID = "5685983253102592";

	/** Expected type for the test problem. **/
	private static final String TYPE = "default";

	/** Expected key for the test problem. **/
	private static final String KEY = "agpzfmdjai1wcm9kchULEghwcm9ibGVtcxiAgICg8uuMCgw";

	/** Expected normalized name for the test problem. **/
	private static final String NORMALIZED_NAME = "IOError";

	/** Expected number of child input for the test problem. **/
	private static final int INPUT = 1;

	/**
	 * Retrieves the {@link Problem} instance
	 * that will be used for testing. Using
	 * test {@link ContestInfo} as reference.
	 *
	 * @return Problem instance for testing.
	 * @return
	 */
	public static Problem getTestProblem() {
		final ContestInfo info = ContestInfoTest.getTestContestInfo();
		final Problem problem = info.getProblem(0);
		return problem;
	}

	/**
	 * Ensures retrieved {@link Problem} is
	 * consistent. Uses the first {@link Problem}
	 * from {@link ContestInfo} test instance.
	 */
	@Test
	public void testProblemConsistency() {
		final Problem problem = getTestProblem();
		assertEquals(NAME, problem.getName());
		assertEquals(ID, problem.getId());
		assertEquals(TYPE, problem.getType());
		assertEquals(KEY, problem.getKey());
		assertEquals(NORMALIZED_NAME, problem.getNormalizedName());
		final String body = Resources.getResource(BODY_PATH);
		final Document document = Jsoup.parse(problem.getBody());
		assertEquals(body, document.text());
		final List<ProblemInput> inputs = problem.getProblemInputs();
		assertEquals(INPUT, inputs.size());
	}

}
