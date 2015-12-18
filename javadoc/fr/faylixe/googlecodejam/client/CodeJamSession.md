#CodeJamSession

Package [fr.faylixe.googlecodejam.client](https://github.com/Faylixe/googlecodejam-client/blob/master/fr/faylixe/googlecodejam/client)<br>
[Object]() > [NamedObject](https://github.com/Faylixe/googlecodejam-client/blob/master/javadoc/fr/faylixe/googlecodejam/client/common/NamedObject.md) > [CodeJamSession](https://github.com/Faylixe/googlecodejam-client/blob/master/javadoc/fr/faylixe/googlecodejam/client/CodeJamSession.md)

{@link CodeJamSession} is the main API entry point, which consists
 in logging to a code jam platform ``hostname`` and then providing
 facilities such as :
 <br>
 * Retrieves contest, round
 * Interacts with platform API from a given round
 * Downloads input
 * Submits solutions

###Summary


| Method |
| --- |
| **public** [String]() buildFilename() |
| **public static** [CodeJamSession](https://github.com/Faylixe/googlecodejam-client/blob/master/javadoc/fr/faylixe/googlecodejam/client/CodeJamSession.md) createSession() |
| **public** [InputStream]() download() |
| **public** [String]() getContestAnalysis() |
| **public** [ContestInfo](https://github.com/Faylixe/googlecodejam-client/blob/master/javadoc/fr/faylixe/googlecodejam/client/webservice/ContestInfo.md) getContestInfo() |
| **public** [Problem](https://github.com/Faylixe/googlecodejam-client/blob/master/javadoc/fr/faylixe/googlecodejam/client/webservice/Problem.md) getProblem() |
| **public** **boolean** isActive() |
| **public** **boolean** isLogged() |
| **public** **boolean** isQualified() |
| **public** [CodeJamSession](https://github.com/Faylixe/googlecodejam-client/blob/master/javadoc/fr/faylixe/googlecodejam/client/CodeJamSession.md) refresh() |
| **public** [SubmitResponse](https://github.com/Faylixe/googlecodejam-client/blob/master/javadoc/fr/faylixe/googlecodejam/client/webservice/SubmitResponse.md) submit() |

###Fields


###Methods

####buildFilename


####createSession


####download


####getContestAnalysis


####getContestInfo


####getProblem


####isActive


####isLogged


####isQualified


####refresh


####submit


