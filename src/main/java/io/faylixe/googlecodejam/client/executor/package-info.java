/**
 * <p>In order to perform request to the Google Code Jam platform,
 * a logged session should be establish through available protocol.</p>
 * <br>
 * <p>In order to provide generic service to apply HTTP request without
 * having to care about session token or other form of logged session,
 * {@link io.faylixe.googlecodejam.client.executor.IHTTPRequestExecutor}
 * interface is used so as to offer an abstraction of the login phase.</p>
 * <br>
 * <p>Two implementations are also provided, namely :</p>
 * <ul>
 * 	<li>{@link io.faylixe.googlecodejam.client.executor.ClientLoginHTTPRequestExecutor} which handles the deprecated Client Login protocol</li>
 * 	<li>{@link io.faylixe.googlecodejam.client.executor.OAuthHTTPRequestExecutor} which handles the new OAuth identification process.</li>
 * </ul>
 * @author fv
 */
package io.faylixe.googlecodejam.client.executor;