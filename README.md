# Todos Automation

This document contains the instructions to run the automation script written using Selenium with Java to test the todos page (https://todomvc.com/examples/angular2/). It also includes a quick guide to run the script, an overview of the scenarios tested as well as how the reporting works. I've also briefly explained why I used this specific tool and what I would like to improve. 

# Table of contents
- [Todos Automation](#todos-automation)
- [Table of contents](#table-of-contents)
- [Installation](#installation)
- [Test Scenarios](#test-scenarios)
- [Workflow](#workflow)
- [Reporting](#reporting)
- [Conclusion](#conclusion)

# Installation
[(Back to top)](#table-of-contents)

Installation steps via any IDE: 

1. Please import the maven project. The dependencies for Selenium, TestNG and WebDriverManager have been mentioned in the pom.xml file. The input variables have been mentioned in the TestNG.xml and the xpaths have been listed in the config.properties file. 
2. Compile the project using mvn clean install.
3. Run testng.xml as a testng suite.

# Test Scenarios
[(Back to top)](#table-of-contents)

**Positive scenarios automated:**

| Test Case No | Scenario | Expected Result |
| :------------- |:-------------| :-----|
| TC1 | Create a task | A row should be added with the task name and "1 item left" should be displayed at the bottom. |
| TC2 | Edit a task | The task should be editable when double clicked and the new name should be saved. |
| TC3 | Uncheck a task  | "1 item left" should be displayed at the bottom and the task name should not be struck through or greyed out. The "Clear Completed" link should also not be displayed. |
| TC4 | Complete a task | The name of the task should be struckthrough and greyed out and the number of items displayed at the bottom should be reduced as 0. A "Clear Completed" link should be displayed. |
| TC5 | Clear a completed task | The row should be removed when the task is individually deleted by clicking the 'Clear Completed' link and only the "What needs to be done?" textbox should be displayed. |
| TC6 | Delete a single task | The row should be removed when the task is individually deleted by clicking the 'x' and only the "What needs to be done?" textbox should be displayed. |
| TC7 | Adding 'n' number of tasks | 'n' number of rows should be added with the task names and "'n' items left" should be displayed at the bottom. |
| TC8 | Delete multiple tasks | The previously created tasks should be deleted |

**Negative scenarios:** 
I have tested the following scenarios manually but it was all working properly. Without a requirements document, I am not able to formulate proper negative scenarios to automate and catch errors. 

Negative scenarios tested:
a) Entering more than 1000 words in a single todo task
b) Input validation including alphanumeric, symbols, foreign languages
c) Adding upto 65 todo tasks

# Workflow
[(Back to top)](#table-of-contents)

Following is the flow of the automation code. 

Input has been set in the Testng.xml to run all the tests in both Chrome and Firefox.

The methods setUp, loadProperties and openUrl have been assigned to "@BeforeTest" annotation in TestNG.

**TC1**

The createTask method is run and the number in the footer is checked to ensure that it has been added. 

**TC2**

The editTask method is then run to double click the task and edit the name. The modified name is then verified.
 
**TC3**
 
A method named clickTask was created to mark a task as complete.
For this test case, the uncheckTask method is used to verify if the task returns to its previous state once it has been unchecked. The footer text of "1 item left" is also checked to make sure that it reflects correctly.

**TC4 and TC5**
 A separate method called clearCompletedTask was created. In the checkTask method, the complete task functionality and the clear completed link are tested.

**TC6**
The removeTask method is used to delete the task by clicking the 'x' button in the task name.

**TC7**
To test creation of multiple tasks, the createMultipleTask method is used and the xpaths are checked to ensure it is successful. 

**TC8**
For the final test case, the deleteLastTask method is used to delete both the created tasks. 

# Reporting
[(Back to top)](#table-of-contents)

I have used TestNG in this project and the reporting is done from that. 

The report can be viewed from the following path using a browser.

```Path: jupiter\todo\test-output\index.html```

![image](https://user-images.githubusercontent.com/85895792/125159429-e6e35680-e194-11eb-854b-e22fcac2c9e6.png)

# Conclusion
[(Back to top)](#table-of-contents)

I have used previously used Cucumber BDD framework for automation but decided to use Selenium with Java this time. To further improve the code, I would like to expand the scenarios handled and make the code more dynamic. 
