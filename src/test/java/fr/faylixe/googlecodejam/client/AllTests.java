package fr.faylixe.googlecodejam.client;

import fr.faylixe.googlecodejam.client.common.NamedObjectTest;
import fr.faylixe.googlecodejam.client.webservice.ContestInfoTest;
import fr.faylixe.googlecodejam.client.webservice.InitialValuesTest;
import fr.faylixe.googlecodejam.client.webservice.ProblemInputTest;
import fr.faylixe.googlecodejam.client.webservice.ProblemTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	// Commons tests.
	NamedObjectTest.class,
	// Basic model scrapping tests.
	ContestTest.class,
	RoundTest.class,
	// ContestInfo REST Call tests.
	ContestInfoTest.class,
	ProblemTest.class,
	ProblemInputTest.class,
	InitialValuesTest.class,
	// Session test
	CodeJamSessionTest.class,
})
public final class AllTests {

}
