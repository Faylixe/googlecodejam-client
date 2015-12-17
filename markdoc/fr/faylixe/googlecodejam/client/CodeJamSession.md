# CodeJamSession

[Object]() > [NamedObject](nullfr/faylixe/googlecodejam/client/common/NamedObject.md) > [CodeJamSession](nullfr/faylixe/googlecodejam/client/CodeJamSession.md)

{@link CodeJamSession} is the main API entry point, which consists
 in logging to a code jam platform ``hostname`` and then providing
 facilities such as :

 * Retrieves contest, round
 * Interacts with platform API from a given round
 * Downloads input
 * Submits solutions

test | est
--- | ---
blabla | bar

## Summary

Return type | Signature
----------- | ----------
[CodeJamSession](nullfr/faylixe/googlecodejam/client/CodeJamSession.md) | refresh


[ContestInfo](nullfr/faylixe/googlecodejam/client/webservice/ContestInfo.md) | getContestInfo
**boolean** | isQualified
**boolean** | isLogged
[Problem](nullfr/faylixe/googlecodejam/client/webservice/Problem.md) | getProblem
**boolean** | isActive
[String]() | getContestAnalysis
[String]() | buildFilename
[InputStream]() | download
[SubmitResponse](nullfr/faylixe/googlecodejam/client/webservice/SubmitResponse.md) | submit
[CodeJamSession](nullfr/faylixe/googlecodejam/client/CodeJamSession.md) | createSession
