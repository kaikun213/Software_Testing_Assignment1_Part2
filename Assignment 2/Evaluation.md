## 10. Test Evaluation

works:
Data integrity
- data integrity and retrieval of shared folder
Unit tets:
- Existing Tests do cover the code. With the written additional tests we reach over 90% branch and line-coverage which fulfills an automated test suit for regression testing.
Function Tests:
- server starts and stops correctly as stated in the scenarios. (Just no log entry)
- The server starts and runs correctly in all declared environments e.g. Mac OS, Linux, Windows 10,8,7 and XP as well as Windows 2008 Server. We ensured this by either testing it on local machines or emulated virtual ones.
- Integration tests run properly and cover the code. Only the GetOnlineServer is failing since we host a local machine and tests for the writing to the log file are missing. (need to be implemented) => otherwise log error would be detected much faster
- The server can be accesses in a LAN Network an behaves normally.
- The project has a good performance for single and multiple users as our load and performance tests has shown. However of course it will depend on the actual hardware-server it is deployed on as well as other factors such as broadband, firewalls or the running operating system.


error:
- no new logs are written but access log is viewable in a text editor
- 403 forbidden -> security exception will be thrown if area outside shared folder is accessed. Use case scenario is not correct to produce the error. -> hacker techniques to produce.
- simultaneous access to server -> error rate 18% should be much lower. => But not deployed local machine has limited resources. Project showed good performance
- No proper error message when server encounters an internal problem


Last iteration:
Business cycle testing : Look up the licensing of the source code with the legal department.
UI Testing : no need since user has just access to resources -> no navigation or similar. Matter of content. => probably added later with sample project.
Security Testing: We run a quick standard SUT of security tests and it showed that the server has nearly no standard protection enabled. E.g. in the HTTP protocol headers. or CGI. However the real tests need to be done in an actual server environment when the project is deployed because there will be much different security vulnerabilities then on a local machine.
API Testing: We could not do API-testing because the project does not have an API or anyway of other presentable documentation. This is one of the biggest downsides and should be added to enable developers easy integration and adaption to their projects as well as better maintenance.
Installation and Configuration testing: The Server is very easy to deploy and configure.

Conclusion:

The Test-Project shows that the current project is stable, fulfills all functional requirements and gives good performance. The data-access and integrity tests verified that all data in the shared folder can be retrieved correctly and without manipulation of it. The functional tests verify that the server starts and terminates properly, this is verified in all required operating systems. (Linux, Mac OS, Windows 10, 8, 7 , XP and Windows Server 2008)  The existing integration and response tests passed and verify that the project works properly and are a proficient start for regression tests. The test which failed was due to the deployment on a local-machine since it tested if the server is online. For the SUT some additional log-tests are needed which verify the writing to the log file.The server can be accesses in a LAN Network an behaves normally and the project has a good performance for single and multiple users as our load and performance tests have shown. However of course it will depend on the actual hardware-server it is deployed on as well as other factors such as broadband, firewalls or the running operating system. The identified errors from our tests listed:

- No new logs are written but access log is viewable in a text editor
- "403 forbidden"-message could not get reproduces. However by inspecting the code we know a security exception will be thrown if someone tries to access a file which is outside the shared folder. With various hacking-techniques this could be produced.
- When accessing the server simultaneously the error rate is about 18%. This rate is to high but should be tested on a a real server-environment since the local machine had very limited resources.
- No proper error message is shown when server encounters an internal problem

In the third Iteration no tests got designed and executed due to resource limitations and unreachable test-areas (e.g. no API). However the results can be summarized as the following:
- Business cycle testing: The licensing of the source code must be investigated together with the legal department. Current licensing is MIT on GitHub.
- Security Testing: A run of a standard SUT of security tests (Tool: Nikto) showed that no standard security is enabled such as HTTP headers, CGI etc. There is also no authentication features of similar implemented. Only security given is that no resources outside the shared folder can be accessed. It is recommended to test the security more in detail under the deployment conditions, since the security vulnerabilities of a server machine are much different to a local one and can not be easily mocked.
- API Testing: The project does not have an actual API or any other kind of presentable documentation. It is one of the greatest needs to improve to make the project easy to integrate and adopt for developers.
- Installation and Configuration testing: The server is very easy to deploy and configure as shown in various other tests. (E.g. Deployment and running on different OS)

Summarized we can recommend to use this project as a start for an IoT-Server. However proper security and documentation such as the log file needs to be added and a test on simultaneous access must be redone in another environment.


## Missing:

- Test case 4.3, Browser must show 404 bad request error -> yes it does , do use an valid address e.g. localhost:1091/secret.png

- Test case 4.4, Browser encounters an internal problem => should be server which encounters an internal problem!! Easy simulated by throwing an IOException somewhere in the code
Result => Does not show a proper error message

- Test case Data integrity 405 Error is missing? Postman => POST instead of get request will produce it

- Test results for HTTP 1.1 standard are missing ?? Is it following the standard??
