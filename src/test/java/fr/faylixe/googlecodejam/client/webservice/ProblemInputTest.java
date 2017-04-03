package fr.faylixe.googlecodejam.client.webservice;

import static org.junit.Assert.assertEquals;
import fr.faylixe.googlecodejam.client.webservice.Problem;
import fr.faylixe.googlecodejam.client.webservice.ProblemInput;

import java.util.List;

import org.junit.Test;

/**
 * Test case for the {@link ProblemInput} class.
 * 
 * @author fv
 */
public final class ProblemInputTest {

	/** Expected name of the test problem input. **/
	private static final String NAME = "small";

	/** Expected suffix of the test problem input. **/
	private static final String SUFFIX = "";

	/** Expected difficulty of the test problem input. **/
	private static final int DIFFICULTY = 0;

	/** Expected point of the test problem input. **/
	private static final int POINTS = 7;

	/** Expected number of the test problem input. **/
	private static final int NUMBER = 0;

	/**
	 * Ensures retrieved {@link ProblemInput}
	 * is consistent. Using the first input from
	 * the test {@link Problem}.
	 */
	@Test
	public void testProblemInputConsistency() {
		final Problem problem = ProblemTest.getTestProblem();
		final List<ProblemInput> inputs = problem.getProblemInputs();
		final ProblemInput input = inputs.get(0);
		assertEquals(DIFFICULTY, input.getDifficulty());
		assertEquals(NAME, input.getName());
		assertEquals(NUMBER, input.getNumber());
		assertEquals(POINTS, input.getPoints());
		assertEquals(SUFFIX, input.getSuffix());
	}

}
