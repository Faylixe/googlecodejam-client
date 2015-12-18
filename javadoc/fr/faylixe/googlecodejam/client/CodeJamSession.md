#CodeJamSession
Package [fr.faylixe.googlecodejam.client](nullfr/faylixe/googlecodejam/client)
[Object]() > [NamedObject]() > [CodeJamSession]()

{@link CodeJamSession} is the main API entry point, which consists
 in logging to a code jam platform ``hostname`` and then providing
 facilities such as :
 <br>
 * Retrieves contest, round
 * Interacts with platform API from a given round
 * Downloads input
 * Submits solutions

Return type | Signature
--- | ---:
[String]() | buildFilename
[CodeJamSession]() | createSession
[InputStream]() | download
[String]() | getContestAnalysis
[ContestInfo]() | getContestInfo
[Problem]() | getProblem
**boolean** | isActive
**boolean** | isLogged
**boolean** | isQualified
[CodeJamSession]() | refresh
[SubmitResponse]() | submit
