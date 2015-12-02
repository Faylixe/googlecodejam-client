package io.faylixe.googlecodejam.client;

import io.faylixe.googlecodejam.client.common.NamedObjectTest;
import io.faylixe.googlecodejam.client.executor.HTTPRequestExecutorTest;
import io.faylixe.googlecodejam.client.webservice.ContestInfoTest;
import io.faylixe.googlecodejam.client.webservice.InitialValuesTest;
import io.faylixe.googlecodejam.client.webservice.ProblemInputTest;
import io.faylixe.googlecodejam.client.webservice.ProblemTest;

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
	// Executor test.
	HTTPRequestExecutorTest.class
})
public final class AllTests {

}
