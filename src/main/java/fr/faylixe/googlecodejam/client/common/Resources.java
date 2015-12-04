package fr.faylixe.googlecodejam.client.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>Static toolbox that exposes methods for internal resources managment.</p>
 *
 * @author fv
 */
public final class Resources {

	/** Normalization pattern used for creating project and file name. **/
	private static final String PATTERN = "[^A-Za-z0-9]";

	/** Bundle relative path of the HTML template file. **/
	private static final String HTML_TEMPLATE_PATH = "problem.template.html";

	/**
	 * Private constructor for avoiding instantiation.
	 */
	private Resources() {
		// Do nothing.
	}

	/**
	 * Normalizes the given <tt>name</tt> by removing
	 * all non alphanumeric character.
	 *
	 * @param name Name to normalize.
	 * @return Normalized name.
	 */
	public static String normalize(final String name) {
		return name.replaceAll(PATTERN, "");
	}

	/**
	 * Reads and returns resources content denoted by the
	 * given <tt>path</tt>.
	 * 
	 * @param path Paht of the resources to read.
	 * @return Resource content as {@link String}.
	 */
	public static String getResource(final String path) {
		final InputStream stream = getResourceStream(path);
		final BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		final Stream<String> lines = reader.lines();
		return lines.collect(Collectors.joining("\n"));
	}
	
	/**
	 * Reads and returns resources content denoted by the
	 * given <tt>path</tt>.
	 * 
	 * @param path Path of the resources to read.
	 * @return Resource content as {@link InputStream}.
	 */
	public static InputStream getResourceStream(final String path) {
		final ClassLoader loader = Resources.class.getClassLoader();
		return loader.getResourceAsStream(path);
	}

	/**
	 * Getter for the HTML template content.
	 *
	 * @return HTML page template.
	 * @throws IOException If any error occurs while reading template content.
	 */
	public static String getHTMLTemplate() throws IOException {
		return getResource(HTML_TEMPLATE_PATH);
	}

}
