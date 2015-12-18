#CodeJamSession

Package [fr.faylixe.googlecodejam.client](https://github.com/Faylixe/googlecodejam-client/blob/master/fr/faylixe/googlecodejam/client)<br>
[Object]() > [NamedObject]() > [CodeJamSession]()

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
| **public static** [CodeJamSession]() createSession() |
| **public** [InputStream]() download() |
| **public** [String]() getContestAnalysis() |
| **public** [ContestInfo]() getContestInfo() |
| **public** [Problem]() getProblem() |
| **public** **boolean** isActive() |
| **public** **boolean** isLogged() |
| **public** **boolean** isQualified() |
| **public** [CodeJamSession]() refresh() |
| **public** [SubmitResponse]() submit() |

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


