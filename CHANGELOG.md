**v1.2.7** *(29/02/2016)*

* Adding trusted HTTP transport to HTTPRequestExecutor.

**v1.2.6** *(16/12/2015)*

* Updates *refresh()* method, now returns always a reloaded session.
* Adds valid hash code computation and equality check to web service classes.
* Adds persistent contest analysis with lazy loading.

**v1.2.5** *(12/12/2015)*

Fix **CodeJamSession** serialization issues.

**v1.2.4** *(12/12/2015)*

Adding *cancel()* method to **SeleniumCookieSupplier**.

**v1.2.3** *(11/12/2015)*

Fix **HttpRequestExecutor** serialization issues.

**v1.2.2** *(10/12/2015)*

Replaces *selenium-java* artifact by *selenium-firefox-driver* in order to reduce
transitive dependencies.

**v1.2.1** *(10/12/2015)*

Removes OSGi specification through *maven-bundle-plugin*. If you want to use this
API in a OSGi context, switch to the dedicated artifact [fr.faylixe:googlecodejam-client-osgi](https://github.com/Faylixe/googlecodejam-client-osgi).

**v1.2.0** *(09/12/2015)*

Minor API update. Now ``CodeJamSession`` is fully serializable, and ``HttpRequestExecutor``
use a custom deserialization process by storing internally it authentification cookie. Also
updates project POM.xml with *maven-bundle-plugin* so as to make it OSGi compatible.

**v1.1.2** *(08/12/2015)*

Minor release that bring small updates to the internal API.
No associated packaged release will be uploaded.

**v1.1.1** *(05/12/2015)*

This release fixes following issues :

* Bug when downloading a file that already exist in the directory.
* Removes Selenium logging.
* Improves Selenium management, by handling non valid cookie, or premature browser shutdown.

**v1.1.0** *(04/12/2015)*


First release, delivering command line application with following features :

* Directory setup with contextual contest and session.
* Input downloading.
* Output submission with source.

**v1.0.0** *(03/12/2015)*

Pre release, for first stable version.
