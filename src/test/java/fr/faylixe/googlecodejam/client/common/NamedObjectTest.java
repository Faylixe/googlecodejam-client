package fr.faylixe.googlecodejam.client.common;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.google.gson.Gson;

import fr.faylixe.googlecodejam.client.common.NamedObject;
import fr.faylixe.googlecodejam.client.common.Resources;

/**
 * Test case for {@link NamedObject} class.
 *
 * @author fv
 */
public final class NamedObjectTest {

	/** Target name of our mock instance. **/
	private static final String NAME = "bob";

	/** Path of the target json named object file relative to this bundle. **/
	private static final String PATH = "named.object.json";

	/**
	 * Test named object behavior from default instantiation.
	 */
	@Test
	public void testDefault() {
		final NamedObject object = new NamedObject(NAME);
		assertEquals(NAME, object.getName());
	}

	/**
	 * Test named object behavior through JSON built object.
	 */
	@Test
	public void testSerialized() {
		final Gson parser = new Gson();
		final String json = Resources.getResource(PATH);
		final NamedObject object = parser.fromJson(json, NamedObject.class);
		assertEquals(NAME, object.getName());
	}

}
