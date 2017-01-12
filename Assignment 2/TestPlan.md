# Test-Project

## Important Note:
The Inline-pictures in this document may partly not get displayed correctly in the peer-review-system.
So please visit the GitHub-Repo for all Test-Cases, References or Code.

GitHub: https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/TestPlan.md

## Table of Contents
### 1. [Introduction]
[Introduction]:https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/TestPlan.md#1-introduction-1
### 2. [Requirements for Test]
[Requirements for Test]:https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/TestPlan.md#2-requirements-for-test-1
### 3. [Test-strategy]
[Test-strategy]:https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/TestPlan.md#3-test-strategy-1
### 4. [Resources]
[Resources]:https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/TestPlan.md#4-resources-1
### 5. [Project Milestones]
[Project Milestones]:https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/TestPlan.md#5-project-milestones-1
### 6. [Deliverables]
[Deliverables]:https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/TestPlan.md#6-deliverables-1
### 7. [Test Plan]
[Test Plan]:https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/TestPlan.md#7-test-plan-1
### 8. [Test Design]
[Test Design]:https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/TestPlan.md#8-test-design-test-cases
### 9. [Test Report]
[Test Report]:https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/TestPlan.md#9-test-report-1
### 10. [Test Evaluation]
[Test Evaluation]:https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/TestPlan.md#10-test-evaluation-1



## 1. Introduction
### 1.1 Purpose
The purpose of this test plan document is to support the followings objectives:
- Evaluate the current state and find possible risks in the given open source project
- Illustrates the recommended requirements for test
- Explain and recommend the testing strategies
- Classify the appropriate resources and bring an evaluation of the test achievements
- List the result of test project  

### 1.2 Background
My Web Server is an open source software. The Software Development Company (SDC) plans to use this server on large-scale of Internet of Things (IOT) in order to display the information from sensors. SDC wants to evaluate whether this server fulfills all of their security, functional and performance needs.  

### 1.4 Goals
- SDC
 - the project is easy to deploy
 - the project has a wide range, so it is deployable on many devices
- Developer
 - the project is setup with minimal configuration
 - the project is easy to integrate e.g. through an unambiguous API and Documentation
- Customer
 - the access to the web-server is easy and convenient
 - the project brings absolute security

### 1.3 Scope
This test plan applies to Data and Database Integrity Testing, Unit Testing, Function Testing, Business Cycle Testing, User Interface Testing, Performance Testing, Load Testing, Stress Testing, Security & Access Testing, API Testing, Configuration Testing and Installation Testing. All these tests will be conducted in this iteration. Information regarding the aim of these tests can be find in Section 2 (Requirements for Test).

### 1.5 References
All references are in the subfolder "References".

1. [WebServer_Requirements_v1.0][1]
2. [Scenario_paper_v1.0][2]

[1]: https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/References/WebServer_Requirements_v1.0.pdf
[2]: https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/References/Scenario_paper_v1.0.pdf

## 2. Requirements for Test
The listing below (uses cases, functional-requirements and non-functional-requirements) identifies all items that have been identified as targets for testing. It represents what will be tested.

### 2.1 Data Integrity Testing
- 2.1.1 Requirements Document, Use Case 3: "System delivers the shared resource to the browser[[1]]"
- 2.1.2 Verify correct retrieval of data from the shared resource folder
- 2.1.3 Verify simultaneous record read accesses.

### 2.2  Unit Testing
- 2.2.1 Confirm proper functioning of Unit-Tests from existing JUnit-Testsuit.
- 2.2.2 Verify statement- and branch-coverage of units by existing unit-tests.

### 2.3 Function Testing
- 2.3.1 Requirements Document, Supplementary Specification Req 3.: "The web server must work on Linux, Mac, Windows(XP, Vista, 7,8,10,Server 2008)[[1]]"
- 2.3.2 Requirements Document, Supplementary Specification Req 2.: "The web server must follow minimum requirements for HTTP 1.1[[1]]"
- 2.3.3 Requirements Document, Supplementary Specification Req 5.: "Req 5. The access log should be viewable from a text editor.[[1]]"
- 2.3.4 Requirements Document, Use Case 1: Verify correct start of the web-server.[[1]]
- 2.3.5 Requirements Document, Use Case 2: Verify normal termination of web-server.[[2]]
- 2.3.6 Verify correctness of existing automated integration-, response- and log- tests.
- 2.3.7 Verify correct working of the web-server in a local-network.

### 2.4 Business Cycle Testing
- 2.4.1 Requirements Document, Supplementary Specification Req 4.: "The source code should be released under GPL-2.0.[[1]]"

### 2.5 User Interface Testing
- 2.5.1 Verify easy access for customer. ([Scenario paper][2])

### 2.6 Performance Testing
- 2.6.1 Verify start of web-server in a reasonable time.
- 2.6.2 Performance Profiling of responses from web-server.
- 2.6.3 Verify web-server response when accessing it from various IoT-Devices in a LAN.

### 2.7 Load Testing
-  2.7.1 Requirements Document, Supplementary Specification Req 1.: "The web server should be responsive under high load.[[1]]"

### 2.8 Stress Testing
- None

### 2.9 Security & Access Testing
- 2.9.1 The web-server should provide absolute security.([Scenario paper][2])

### 2.10 Recovery Testing
- None

### 2.11 API Testing
- 2.11.1 Scenario paper: "easy integration and adaptation of the web-server[[2]]"

### 2.12 Configuration Testing
- 2.12.1 The web-server should need minimal configuration.([Scenario paper][2])

### 2.13 Installation Testing
- 2.13.1 The web-server should be easy to deploy.

### 2.14 Acceptance Testing
- None

## 3. Test Strategy
The Test Strategy presents a recommended approach of testing the identified testing-targets. The previous section described *what* are the testing-targets.
This section will describe *how* it will be tested.The main considerations for the test strategy are the techniques to be used and the criterion for knowing when the testing is completed.

### 3.1 Testing-types

#### 3.1.1 Data Integrity Testing
The data access and process should be tested within the running system. The retrieval of data can be tested in an automated suite, while the integrity and correctness must be tested manually.

![Data_Integrity_Testing][TestImage]

[TestImage]: https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test_Strategies_Tables/DataIntegrityTesting.png

#### 3.1.2 Unit Testing
![Unit_Testing](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test_Strategies_Tables/UnitTesting.png "Inline style")

#### 3.1.3 Function Testing
The testing of the application should focus on any target requirements that can be traced directly from the use-cases or the Scenario-goals. This type of testing is based up on black-box-testing, while testing the completeness of the existing tests is done with code-coverage and white-box testing.

![Function_Testing](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test_Strategies_Tables/FunctionTesting.png "Inline style")

#### 3.1.4 Business Cycle Testing
This section needs to be tested in cooperation with the legal-department.
Test-strategy needs to be determined.

#### 3.1.5 User Interface Testing
![User_Interface_Testing](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test_Strategies_Tables/UserInterfaceTesting.png "Inline style")

#### 3.1.6 Performance Testing
![Performance_Testing](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test_Strategies_Tables/PerformanceTesting.png "Inline style")

#### 3.1.7 Load Testing
![Load_Testing](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test_Strategies_Tables/LoadTesting.png "Inline style")

#### 3.1.8 Stress Testing
None

#### 3.1.9 Security & Access Testing
The testing will depend on an external tool which should be up-to-date with the current standards and verifies a proper level of security for known vulnerabilities.

![Security_Testing](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test_Strategies_Tables/SecurityTesting.png "Inline style")

#### 3.1.10 Recovery Testing
None

#### 3.1.11 API Testing
This section is not applicable to test because no API is provided.

#### 3.1.12 Configuration Testing
![Configuration_Testing](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test_Strategies_Tables/ConfigurationTesting.png "Inline style")

#### 3.1.13 Installation Testing
![Installation_Testing](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test_Strategies_Tables/InstallationTesting.png "Inline style")

#### 3.1.14 Acceptance Testing
None

### 3.2 Tools
The following tools will be employed for testing:
![Tools_Table](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test_Strategies_Tables/ToolsTable.png "Inline style")

## 4. Resources
The resources for the MyWebServer test effort are the SDC-employees of the testing-team.

### 4.1 Workers
![Resources_Workers_Table](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/ResourcesWorkersTable.png "Inline style")


### 4.2 System
The server module will mainly run on the defined PC's as localhost. For some function tests it will be emulated on VM's. The access tests will be done from various client systems to ensure compatibility and meet the requirements. Whole test-suits will just run on the listed PC-OS's.

![Resources_System_Table](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/SystemResourcesTable.png "Inline style")

The server test stations must have the following software installed and properly configured:

- JAVA 8 JDK

The server needs to be setup locally or remotely to run each test suit.
The default configuration used:
- port: 1091
- shared resource folder: /MyWebServer/tests/se/lnu/http/resources/inner

## 5. Project Milestones
The dates are just estimates and may vary since iteration-efforts may depend on each other. So planning and working will be done in an agile-way as defined in the test-plan.

![Project_Milestones_Table](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/ProjectMilestonesTable.png "Inline style")

## 6. Deliverables

### 6.1 Test Plan
The Test Plan will define *who* does *what* in which iteration. It divides the test-effort into manageable iterations and sets time-limitations.

### 6.2 Test Model
The Test Model will define all the test cases and will reference the test procedures, tools and test-scripts which are associated with each test-case.

### 6.3 Test Results
For each test executed a test-result form will be created. This should include the name or ID of the test-case or specification it relates to, the execution-date, name of the tester and the result of the test.

### 6.4 Test Report
A final evaluation of the test-activities and their results will be presented.

## 7. Test-Plan

### Full Test-Project

The fulfillment of  the test-strategy will be distributed in three iterations. To complete means all test-cases for each listed requirement is designed, executed and evaluated. The Test-Project Goal is to meet all completion-criteria from the test-strategy.

| Iteration       | Goals/Milestones  | Requirement-Number | Start-Date | End-Date |
| ------------- | -------- | -------- |  :--------: |  :--------: |
| Iteration #1  | **Unit-Testing**  </br> Confirm JUnit-Testsuit </br>  Verify unit-coverage  </br> </br> **Function-Testing** </br> Webserver works on OS's  </br> HTTP 1.1 Standard </br> Access log viewable  </br>UC1: Start of webserver  </br> UC2: Termination of webserver  </br> Verify Integration-Tests  </br> </br> **Performance Testing**  </br> Performance Profiling |  </br> Req. 2.2.1 </br> Req. 2.2.2   </br>  </br> </br> Req. 2.3.1  </br> Req. 2.3.2  </br> Req. 2.3.3  </br> Req. 2.3.4  </br> Req. 2.3.5  </br> Req. 2.3.6  </br> </br></br> Req. 2.6.2 | 14/12/2016 | 18/12/2016 |
| Iteration #2  | **Data Integrity Testing**  </br> UC3: System delivers to browser  </br> Verify correct retrieval </br> Verify simultaneous access </br> </br>**Function-Testing**  </br> Verify behavior in LAN  </br> </br> **Performance Testing**  </br> Start in reasonable time </br> Access-Time in LAN  </br>  </br> **Load Testing**  </br> Responsive under high load |  </br> Req. 2.1.1  </br> Req. 2.1.2  </br> Req. 2.1.3  </br> </br> </br> Req. 2.3.7 </br></br></br> Req. 2.6.1  </br> Req. 2.6.3  </br>  </br>  </br> Req. 2.7.1  | 18/12/2016 | 21/12/2016 |
| Iteration #3  | **UI Testing** </br> Verify easy access </br></br>  **Security and Access Testing** </br> Webserver security report </br> </br>  **Configuration Testing** </br> Minimal Configuration </br></br>  **Installation Testing** </br>  Easy deployment of server </br> </br>  **API Testing** </br> Easy integration and adaptation </br> </br> **Business Cycle Testing** </br>  GPL-2 License published |  </br>  Req. 2.5.1 </br> </br> </br> Req. 2.9.1 </br></br> </br> Req. 2.12.1  </br></br> </br> Req. 2.13.1 </br> </br> </br> Req. 2.11.1  </br> </br> </br>  Req. 2.4.1 | 21/12/2016 | 23/12/2016 |

### Iteration \#1
The first iteration is set from the 14/12/2016 until the 18/12/2016. Until then all the milestones should be covered. This means the tests are designed, executed, results documented and evaluated. If something is not finished it will be taken into the next iteration. If more then one tester are involved in a milestone the tester in bold is marked as the responsible person that the test is complete and documented.

| Goals/Milestones  | Requirement-Number |   Responsible Tester | Estimated Time | Work Time | Start-Date | End-Date |
| -------- | -------- |  -------- |  -------- | -------- | :--------: |  :--------: |
| **Unit-Testing**  |||||||
| Confirm JUnit-Testsuit |  Req. 2.2.1 | Tester1 | 5h | 5h | 18/12/2016 | 18/12/2016 |
| Verify unit-coverage   |  Req. 2.2.2 | Tester1 | 2h | 3h | 18/12/2016 | 18/12/2016|
| **Function-Testing**  |||||||
| Webserver works on OS's | Req 2.3.1  | **Tester2**, Tester3, Tester1 | 2h | 2h | 18/12/2016 | 18/12/2016 |
| HTTP 1.1 Standard | Req. 2.3.2 | Tester3 | 2h | 2h | 18/12/2016 | 18/12/2016 |
| Access log viewable | Req. 2.3.3 | Tester3 | 1h | 40min | 18/12/2016 | 18/12/2016 |
| UC1: Start of webserver | Req. 2.3.4 | Tester2 | 5h | 5h | 14/12/2106 | 17/12/2106 |
| UC2: Termination of webserver | Req. 2.3.5 | Tester2 | 2h | 1h | 16/12/2106 | 16/12/2106 |
| Verify Integration-Tests | Req. 2.3.6 | Tester1 | 5h | 2h | 18/12/2016 | 18/12/2016 |
| **Performance Testing** |||||||
| Performance Profiling | Req. 2.6.2 | Tester3 | 5h | 1h | 15/12/2016 | 15/12/2016 |
| **Total** | | | ~25h | | 14/12/2016 | 18/12/2016 |

### Iteration \#2
The first iteration is set from the 18/12/2016 until the 21/12/2016.

| Goals/Milestones  | Requirement-Number |   Responsible Tester | Estimated Time | Work Time | Start-Date | End-Date |
| -------- | -------- |  -------- |  -------- | -------- | :--------: |  :--------: |
| **Data Integrity Testing**  |||||||
| UC3: System delivers to browser |  Req. 2.1.1 | Tester2 | 7h | 5h | 20/12/2016| 21/12/2016|
| Verify correct retrieval   |  Req. 2.1.2 | Tester2 | 2h | 1h | 22/12/2016| 22/12/2016|
| Verfiy simultaneous access | Req. 2.1.3 | Tester3 | 2h | 2h | 22/12/2016 | 22/12/2016 |
| **Function-Testing**  |||||||
| Verify behavior in LAN  | Req 2.3.7 | Tester1 | 2h | 2h | 22/12/2016 | 22/12/2016 |
| **Performance Testing** |||||||
| Start in reasonable time | Req. 2.6.1 | Tester2 | 2h | 1h | 22/12/2016| 22/12/2016|
| Access-Time in LAN | Req. 2.6.3 | Tester1 | 2h | 2h | 22/12/2016 | 22/12/2016 |
| **Load Testing** |||||||
| Responsive under high load | Req. 2.7.1 | Tester3 | 2h | 1.4h | 21/12/2016 | 21/12/2016 |
| **Total** | | | Sum of all (35-40?) | ~20h | 18/12/2016 | 21/12/2016 |


### Iteration \#3
The first iteration is set from the 21/12/2016 until the 23/12/2016.

| Goals/Milestones  | Requirement-Number |   Responsible Tester | Estimated Time | Work Time | Start-Date | End-Date |
| -------- | -------- |  -------- |  -------- | -------- | :--------: |  :--------: |
| **UI Testing**  |||||||
| Verify easy access |  Req. 2.5.1 | Tester2 | | | | |
| **Security and Access Testing**  |||||||
| Webserver security report | Req. 2.9.1 | Tester1 | | | | |
| **Configuration Testing**  |||||||
| Minimal Configuration  | Req 2.12.1 | Tester3 | | | | |
| **Installation Testing** |||||||
| Easy deployment of server  | Req. 2.13.1 | Tester3 | | | | | |
| **API Testing** |||||||
| Easy integration and adaptation | Req. 2.11.1 | Tester1 | | | | | |
| **Business Cycle Testing** |||||||
|  GPL-2 License published  | Req. 2.4.1 | Tester2 | | | | | |
| **Total** | | | Sum of all (35-40?) | | 21/12/2016 | 23/12/2016 |

## 8. Test Design (Test-cases)

### Function Testing (Req. 2.3.1, 2.3.4 & 2.3.5)

#### Test case 0.1, Webserver works on Windows, Linus and Mac OS

##### MacOS
![TestCase1.1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 0.1/TestCase0.1Expected.png "Inline style")
##### Linux
![TestCase0.2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%200.1/TestCase0.2.png "Inline style")
##### Windows 10
![TestCase0.3](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%200.1/TestCase0.3.PNG "Inline style")
##### Windows 8
![TestCase0.2a](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%200.1/Windows8.png)
##### Windows 7
![TestCase0.2b](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%200.1/Windows7.png)
##### Windows XP
![TestCase0.2c](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%200.1/WindowsXP.png)
##### Windows Server 2008
![TestCase2.9](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%200.1/Test%20Case%20Windows%202008%20Server/TestCaseWindowsServerOS.png)

***

#### Test case 1.1, Failed to start server without providing any port number and shared resource folder path

![TestCase1.1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.1/TestCase1.1Expected.png "Inline style")

***

#### Test case 1.2, Failed to start server with only port number

![TestCase1.2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.2/TestCase1.2Expected.png "Inline style")

***

#### Test case 1.3, Failed to start server with only shared resource container

![TestCase1.3](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.3/TestCase1.3Expected.png "Inline style")
***

#### Test case 1.4, Failed to start server with only invalid port number

![TestCase1.4](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.4/TestCase1.4Expected.png "Inline style")

***

#### Test case 1.5, Failed to start server with only incorrect shared resource container

![TestCase1.5](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.5/TestCase1.5Expected.png "Inline style")

***

#### Test case 1.6, Failed to start server with incorrect order of port and shared resource container

![TestCase1.6](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.6/TestCase1.6Expected.png "Inline style")

***

#### Test case 1.7, Failed to start server with incorrect port number and correct shared resource container

![TestCase1.7](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.7/TestCase1.7Expected.png "Inline style")

***

#### Test case 1.8, Failed to start server with correct port number and empty shared resource container path

![TestCase1.8](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.8/TestCase1.8Expected.png "Inline style")

***

#### Test case 1.9, Server successfully startup with correct port number and correct shared resource container path

![TestCase1.9](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.9/TestCase1.9Expected.png "Inline style")

***

#### Test case 1.10, Server failed to start because given port is already taken

![TestCase1.10](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.10/TestCase1.10Expected.png "Inline style")

***

#### Test case 2.1, Failed to stop server with Uppercase stop command

![TestCase2.1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 2.1/TestCase2.1Expected.png "Inline style")

***

#### Test case 2.2, Failed to stop server with command’s first letter uppercase

![TestCase2.2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 2.2/TestCase2.2Expected.png "Inline style")

***

#### Test case 2.3, Server stops successfully with correct command

![TestCase2.3](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 2.3/TestCase2.3Expected.png "Inline style")

***

#### Test case 2.9, Run existing Integration-Tests

![TestCase2.9](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/IntegrationTests/Test Case 2.9/TestCase2.9.png "Inline style")

***

#### Test case 3.0, Acess log viewable (Req. 2.3.3)

![TestCase3.0](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%203.0/TestCase3.0design.PNG "TestCase 3.0")

***

#### Test case 3.1, HTTP 1.1 protocol (Req. 2.3.2)
##### 200
![TestCase3.1 200](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%203.1/TestCase3.1_200_design.PNG "TestCase 3.1 200")

##### 404
![TestCase3.1 404](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%203.1/TestCase3.1_404_design.PNG "TestCase 3.1 404")

##### 405
![TestCase3.1 405](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%203.1/TestCase3.1_405_design.PNG "TestCase 3.1 405")

***

#### Test case 3.3, verifying server behavior in a LAN
![TestCase3.3](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%203.3/TestCase3.3.png "Inline style")

### Unit Testing (Req. 2.2.1 & 2.2.2)

#### Test case 2.5, Existing Unit Tests run
![TestCase2.5](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/UnitTests/Test Case 2.5/TestCase2.5.png "Inline style")



***

#### Test case 2.6, Code Coverage Unit Tests

![TestCase2.6](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/UnitTests/Test Case 2.6/TestCase2.6.png "Inline style")

***

#### Test case 2.7, Existing and additional Unit Tests run

![TestCase2.7](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/UnitTests/Test Case 2.7/TestCase2.7.png "Inline style")

***

#### Test case 2.8, Code Coverage existing and additional Unit tests

![TestCase2.8](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/UnitTests/Test Case 2.8/TestCase2.8.png "Inline style")

***

### Performance Testing

#### Test case 2.4, Confirm the performance is stable

![TestCase2.4](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Test%20Case%202.4/TestCase2.4design.PNG "Test Case 2.4")

***

#### Test case 3.4, Access time in LAN
![TestResult3.4](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Performance%20Testing/Test%20Case%203.4/TestResult3.4.png)

***

#### Test Case 4.8 Verify loading of page in a reasonable time
![TestCase4.8](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Performance Testing/Test Case 4.8/TestCase4.8Expected.png "Inline style")

***


### Load Testing (Req: 2.7.1)
#### Test case 3.2
![TestCase3.2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Load%20Testing/Test%20Case%203.2/TestCase3.2design.PNG "TestCase 3.2 load test")

***


### Data and Integrity Testing (Req. 2.1.1, 2.1.2 & 2.1.3)
#### Test case 4.1, Browser must show 404 Not found error
![TestCase4.1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.1/TestCase4.1Expected.png "Inline style")

***

#### Test case 4.2, Browser must show 403 forbidden error
![TestCase4.2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.2/TestCase4.2Expected.png "Inline style")

***


#### Test case 4.3 Browser must show 400 bad request
![TestCase4.3](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.3/TestCase4.3Expected.png "Inline style")

***

#### Test case 4.4 Browser encounters an internal problem
![TestCase4.4](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.4/TestCase4.4Expected.png "Inline style")

***

#### Test case 4.5 Browser successfully access the resource folder
![TestCase4.5](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.5/TestCase4.5Expected.png "Inline style")

***

#### Test case 4.6, Verify correct retrieval of data from the shared resource folder
![TestCase4.6](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.6/TestCase4.6Expected.png "Inline style")


***

#### Test Case 4.7, Verify simultaneous connections on the server
![TestCase4.7](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Data%20and%20Integrity%20Testing/Test%20Case%204.7/TestCase4.7design.PNG "TestCase 4.7")

***

## 9. Test Report

### Function Testing (Req. 2.3.1, 2.3.4 & 2.3.5)

#### Test case 0.1, Webserver works on Windows, Linus and Mac OS

##### MacOS
![TestCase1.1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 0.1/TestCase0.1Actual.png "Inline style")

**Output 1**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 0.1/Result1.png "Inline style")
**Output 2**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 0.1/Result2.png "Inline style")

***

##### Linux

![TestCase0.2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%200.1/TestResult0.2.png "Inline style")

**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%200.1/TestCase0.2Additional.png "Inline style")

***
##### Windows 10

![TestCase0.3](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%200.1/TestResult0.3.PNG "Test Result 3")

**Output**
![Result_a](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%200.1/output0.3_1.PNG "output 1")
![Result_b](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%200.1/output0.3_2.PNG "output 2")

##### Windows 8
![TestResult0.2a](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%200.1/Windows8Result.png)
##### Windows 7
![TestResult0.2b](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%200.1/Windows7Result.png)
##### Windows XP
![TestResult0.2c](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%200.1/WindowsXPResult.png)

***
##### Windows 2008 Server
![TestCase2.9](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%200.1/Test%20Case%20Windows%202008%20Server/TestResultWindowsServerOS.png)

**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%200.1/Test%20Case%20Windows%202008%20Server/TestCaseWindowsServerOSAdditional.png)


#### Test case 1.1, Failed to start server without providing any port number and shared resource folder path

![TestCase1.1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.1/TestCase1.1Actual.png "Inline style")

**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.1/Result.png "Inline style")


***

#### Test case 1.2, Failed to start server with only port number

![TestCase1.2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.2/TestCase1.2Actual.png "Inline style")

**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.2/Result.png "Inline style")

***

#### Test case 1.3, Failed to start server with only shared resource container

![TestCase1.3](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.3/TestCase1.3Actual.png "Inline style")

**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.3/Result.png "Inline style")

***

#### Test case 1.4, Failed to start server with only invalid port number

![TestCase1.4](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.4/TestCase1.4Actual.png "Inline style")


**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.4/Result.png "Inline style")

***

#### Test case 1.5, Failed to start server with only incorrect shared resource container

![TestCase1.5](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.5/TestCase1.5Actual.png "Inline style")


**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.5/Result.png "Inline style")

***

#### Test case 1.6, Failed to start server with incorrect order of port and shared resource container

![TestCase1.6](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.6/TestCase1.6Actual.png "Inline style")

**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.6/Result.png "Inline style")

***

#### Test case 1.7, Failed to start server with incorrect port number and correct shared resource container

![TestCase1.7](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.7/TestCase1.7Actual.png "Inline style")

**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.7/Result.png "Inline style")

***

#### Test case 1.8, Failed to start server with correct port number and empty shared resource container path

![TestCase1.8](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.8/TestCase1.8Actual.png "Inline style")


**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.8/Result.png "Inline style")

***

#### Test case 1.9, Server successfully startup with correct port number and correct shared resource container path

![TestCase1.9](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.9/TestCase1.9Actual.png "Inline style")

**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.9/Result.png "Inline style")

***


#### Test case 1.10, Server failed to start because given port is already taken

![TestCase1.10](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.10/TestCase1.10Actual.png "Inline style")

**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 1.10/Result.png "Inline style")

***


#### Test case 2.1, Failed to stop server with Uppercase stop command

![TestCase2.1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 2.1/TestCase2.1Actual.png "Inline style")

**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 2.1/Result.png "Inline style")

***

#### Test case 2.2, Failed to stop server with command’s first letter uppercase

![TestCase2.2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 2.2/TestCase2.2Actual.png "Inline style")

**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 2.2/Result.png "Inline style")

***

#### Test case 2.3, Server stops successfully with correct command

![TestCase2.3](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 2.3/TestCase2.3Actual.png "Inline style")

**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Function Testing/Test Case 2.3/Result.png "Inline style")

***

### Unit Testing (Req. 2.2.1 & 2.2.2)

#### Test case 2.5, Existing Unit Tests run

![TestCase2.5](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/UnitTests/Test Case 2.5/TestResult2.5.png "Inline style")

**Output**

![TestRuns](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/UnitTests/Test Case 2.5/TestCase2.5Additional.png "Inline style")

***

### Performance Profiling
#### Test case 2.4, Confirm the performance is stable

![TestCase2.4](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Test%20Case%202.4/TestCase2.4.PNG "Test Case 2.4")

***

#### Test case 2.6, Code Coverage Unit Tests

![TestCase2.6](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/UnitTests/Test Case 2.6/TestResult2.6.png "Inline style")

**Output**

![TestRuns](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/UnitTests/Test Case 2.6/TestCase2.6Additional.png "Inline style")

***

#### Test case 2.7, Existing and additional Unit Tests run

![TestCase2.7](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/UnitTests/Test Case 2.7/TestResult2.7.png "Inline style")

**Output**

![TestRuns](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/UnitTests/Test Case 2.7/TestCase2.7Additional.png "Inline style")

***

#### Test case 2.8, Code Coverage existing and additional Unit tests

![TestCase2.8](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/UnitTests/Test Case 2.8/TestResult2.8.png "Inline style")

**Output**
![TestRuns](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/UnitTests/Test Case 2.8/TestCase2.8Additional.png "Inline style")

***

#### Test case 2.9, Run existing Integration-Tests

![TestCase2.9](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/IntegrationTests/Test Case 2.9/TestResult2.9.png "Inline style")

**Output**

![TestRuns](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/IntegrationTests/Test Case 2.9/TestCase2.9Additional.png "Inline style")

***

#### Test case 3.0, Acess log viewable (Req. 2.3.3)

![TestCase3.0](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%203.0/TestCase3.0.PNG "TestCase 3.0")

***

#### Test case 3.1, HTTP 1.1 error messages (Req. 2.3.2)
**200**
![TestReport3.1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%203.1/TestReport3.1_200.PNG "TestReport 3.1")

**404**
![TestReport3.1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%203.1/TestReport3.1_404.PNG "TestReport 3.1")

**405**
![TestReport3.1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%203.1/TestReport3.1_405.PNG "TestReport 3.1")

***

#### Test case 3.3, verifying server behavior in a LAN
![TestCase3.3](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%203.3/TestResult3.3.png "Inline style")

**Output**

![TestResut](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Function%20Testing/Test%20Case%203.3/TestCase3.3Additional.png "Inline style")

***

### Load Testing (Req. 2.7.1)
#### Test case 3.2
![TestCase3.2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Load%20Testing/Test%20Case%203.2/TestCase3.2.PNG "TestCase 3.2 load test")

**Output**
![Graph Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Load%20Testing/Test%20Case%203.2/GraphResult.PNG "TestCase 3.2 result")

***

#### Test case 3.4, Access time in LAN

![TestResult3.4](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Performance%20Testing/Test%20Case%203.4/TestResult3.4.png)

**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Performance%20Testing/Test%20Case%203.4/TestCase3.4Additional.png)

***

### Data and Integrity Testing (Req. 2.1.1, 2.1.2 & 2.1.3)
### Test case 4.1, Browser must show 404 Not found error
![TestCase4.1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.1/TestCase4.1Actual.png "Inline style")


**Output 1**
![Result1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.1/Result1.png "Inline style")
**Output 2**
![Result2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.1/Result2.png "Inline style")
**Output 3**
![Result3](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.1/Result3.png "Inline style")

***

### Test case 4.2, Browser must show 403 forbidden error
![TestCase4.2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.2/TestCase4.2Actual.png "Inline style")


**Output 1**
![Result1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.2/Result1.png "Inline style")
**Output 2**
![Result2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.2/Result2.png "Inline style")

***

### Test case 4.3, Browser must show 404 bad request error
![TestCase4.3](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.3/TestCase4.3Actual.png "Inline style")


**Output 1**
![Result2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.3/Result2.png "Inline style")
**Output 2**
![Result1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.3/Result1.png "Inline style")

***

### Test case 4.4, Browser encounters an internal problem
![TestCase4.4](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.4/TestCase4.4Actual.png "Inline style")

**Output 1**
![Result1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.4/Result1.png "Inline style")
**Output 2**
![Result2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.4/Result2.png "Inline style")

***

### Test case 4.5, Browser successfully acces the resource folder
![TestCase4.5](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.5/TestCase4.5Actual.png "Inline style")


**Output 1**
![Result1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.5/Result1.png "Inline style")
**Output 2**
![Result2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.5/Result2.png "Inline style")

***

### Test case 4.6, Verify correct retrieval of data from the shared resource folder
![TestCase4.6](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.6/TestCase4.6Actual.png "Inline style")


**Output 1**
![Result1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.6/Result1.png "Inline style")
**Output 2**
![Result2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Data and Integrity Testing/Test Case 4.6/Result2.png "Inline style")


***

#### Test Case 4.7, Verify simultaneous connections on the server
![TestCase4.7](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Data%20and%20Integrity%20Testing/Test%20Case%204.7/TestCase4.7actual.PNG "TestCase 4.7")

**Output**
![Result](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test%20Cases/Data%20and%20Integrity%20Testing/Test%20Case%204.7/output.PNG "TestCase 4.7")

***

#### Test Case 4.8 Verify loading of page in a reasonable time
![TestCase4.8](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Performance Testing/Test Case 4.8/TestCase4.8Actual.png "Inline style")

**Output 1**
![Result1](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Performance Testing/Test Case 4.8/Result1.png "Inline style")
**Output 2**
![Result2](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Performance Testing/Test Case 4.8/Result2.png "Inline style")
**Output 3**
![Result3](https://github.com/onkelhoy/Software-Testing/blob/master/Assignment%202/Resources/Test Cases/Performance Testing/Test Case 4.8/Result3.png "Inline style")

***

## 10. Test Evaluation
### Traceability Matrix
|Requirements Identifiers|Reqs Tested|Req 2.1.1|Req 2.1.2|Req 2.1.3|Req 2.2.1|Req 2.2.2|Req 2.3.1|Req 2.3.2|Req 2.3.3|Req 2.3.4|Req 2.3.5|Req 2.3.6|Req 2.3.7|Req 2.4.1|Req 2.5.1|Req 2.6.1|Req 2.6.2|Req 2.6.3|Req 2.7.1|Req 2.9.1|Req 2.11.1|Req 2.12.1|Req 2.13.1|
|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|----|
|Test Cases| 33 | 5 | 1 | 1 |  |  | 1 | 1 | 1 | 27 | 3 |  |  |  |  | 1 | 1 |  | 3 |  |  |  |  |
|Test Implicitly|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
|0.1| 2 |  |  |  |  |  | x |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|1.1| 1 |  |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|1.2| 1 |  |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|1.3| 1 |  |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|1.4| 1 |  |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|1.5| 1 |  |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|1.6| 1 |  |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|1.7| 1 |  |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|1.8| 1 |  |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|1.9| 1 |  |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|1.10| 1 |  |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|2.1| 2 |  |  |  |  |  |  |  |  | x | x |  |  |  |  |  |  |  |  |  |  |  |  |
|2.2| 2 |  |  |  |  |  |  |  |  | x | x |  |  |  |  |  |  |  |  |  |  |  |  |
|2.3| 2 |  |  |  |  |  |  |  |  | x | x |  |  |  |  |  |  |  |  |  |  |  |  |
|2.4| 2 |  |  |  |  |  |  |  |  | x |  |  |  |  |  |  | x |  |  |  |  |  |  |
|2.5|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
|2.6|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
|2.7|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
|2.8|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
|2.9|  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
|3.0| 2 |  |  |  |  |  |  |  | x | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|3.1| 2 |  |  |  |  |  |  | x |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|3.2| 2 |  |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  | x |  |  |  |  |
|3.3| 2 |  |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  | x |  |  |  |  |
|3.4| 2 |  |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  | x |  |  |  |  |
|4.1| 2 | x |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|4.2| 1 | x |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |
|4.3| 2 | x |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|4.4| 2 | x |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|4.5| 2 | x |  |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|4.6| 2 |  | x |  |  |  |  |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|4.7| 2 |  |  | x |  |  |  |  |  | x |  |  |  |  |  |  |  |  |  |  |  |  |  |
|4.8| 2 |  |  |  |  |  |  |  |  | x |  |  |  |  |  | x |  |  |  |  |  |  |  |
Test-Traceability-Matrix to overview Requirement-Coverage of our test-cases.


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
