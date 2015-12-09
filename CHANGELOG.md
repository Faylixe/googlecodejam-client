**v1.2.0** *(09/12/2015)*

Minor API update. Now ``CodeJamSession`` is fully serializable, and ``HttpRequestExecutor``
use a custom deserialization process by storing internally it authentification cookie.

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
