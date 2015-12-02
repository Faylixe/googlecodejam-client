package io.faylixe.googlecodejam.client.webservice;

import static org.junit.Assert.assertEquals;
import io.faylixe.googlecodejam.client.common.Resources;
import io.faylixe.googlecodejam.client.webservice.ContestInfo;
import io.faylixe.googlecodejam.client.webservice.Problem;
import io.faylixe.googlecodejam.client.webservice.ProblemInput;

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
	private static final String NAME = "Old Magician";

	/** Expected id for the test problem. **/
	private static final String ID = "24454";

	/** Expected type for the test problem. **/
	private static final String TYPE = "default";

	/** Expected key for the test problem. **/
	private static final String KEY = "agpzfmdjai1wcm9kchALEghwcm9ibGVtcxiGvwEM";

	/** Expected normalized name for the test problem. **/
	private static final String NORMALIZED_NAME = "OldMagician";

	/** Expected number of child input for the test problem. **/
	private static final int INPUT = 2;

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
