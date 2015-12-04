package fr.faylixe.googlecodejam.client.executor;

import java.util.function.Supplier;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * TODO Javadoc
 * TODO Cookie expiration parsing
 * TODO Login url as parameter ? Function instead of supplier ?.
 * 
 * ISSUE : https://github.com/Faylixe/googlecodejam-client/issues/5
 * @author fv
 */
public final class SeleniumCookieSupplier implements Supplier<String> {

	/** Name of the target cookie to retrieve. **/
	private static final String COOKIE_NAME = "SACSID";

	/** **/
	private static final String LOGIN_URL = "https://www.google.com/accounts/ServiceLogin?service=ah&passive=true&continue=https://appengine.google.com/_ah/conflogin%3Fcontinue%3Dhttps://code.google.com/codejam&ltmpl=";

	/** Default waiting time between cookie check. **/
	private static final long WAITING_TIME = 2000;

	/** Target URL user should be redirected to. **/
	private final String target;

	/** Supplier that will create our driver instance to use. **/
	private final Supplier<WebDriver> driverSupplier;

	/** Lock object for notification exchange. **/
	private final Object lock;

	/** **/
	private volatile boolean running;

	/** **/
	private Cookie result;

	/**
	 * Default constructor.
	 * 
	 * @param target Target URL user should be redirected to.
	 * @param driverSupplier Supplier that will create our driver instance to use.
	 */
	public SeleniumCookieSupplier(final String target, final Supplier<WebDriver> driverSupplier) {
		this.lock = new Object();
		this.target = target;
		this.driverSupplier = driverSupplier;
	}

	/** {@inheritDoc} **/
	@Override
	public String get() {
		final WebDriver driver = new FirefoxDriver();
		driver.navigate().to(LOGIN_URL);
		running = true;
		return waitForCookie(driver);
	}
	
	/**
	 * 
	 * @return <tt>true</tt> if the selenium instance is still running, <tt>false</tt> otherwise.
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * 
	 * @return
	 */
	private String waitForCookie(final WebDriver driver) {
		while (isRunning()) {
			synchronized (lock) {
				try {
					lock.wait(WAITING_TIME);
					checkCurrentState(driver);
				}
				catch (final InterruptedException e) {
					// TODO : Log error.
					e.printStackTrace();
				}
			}
		}
		driver.quit();
		return result.getValue();
	}
	
	/**
	 * Checks the state of the given <tt>driver</tt>,
	 * ensuring if the required cookie has been settled or not.
	 * 
	 * @param driver Driver to check state from.
	 */
	public void checkCurrentState(final WebDriver driver) {
		final String url = driver.getCurrentUrl();
		if (target.equals(url)) {
			result = driver.manage().getCookieNamed(COOKIE_NAME);
			running = false;
		}
	}

}
