You will need to provide us with a nicely defined ReadMe file, 
where you will explain how and what is being tested, 
which patterns are used and why, 
how the tests are organized, 
how the reporting works
and everything else you think it’s important for us to know.

What your application does,
Why you used the technologies you used,
Some of the challenges you faced and features you hope to implement in the future.
What was your motivation?
What problem does it solve?
What did you learn?
What makes your project stand out? If your project has a lot of features, consider adding a "Features" section and listing them here.


1. Table of Contents
2. How to install/use the project
3. Tests
4. Conclusion

# Table of contents
- [Table of contents](#table-of-contents)
- [Todos Automation](#todos-automation)
- [Installation](#installation)
- [Demo-Preview](#demo-preview)
- [Test Scenarios](#test-scenarios)
- [Development](#development)
- [Reporting](#reporting)
    - [Sponsor](#sponsor)
    - [Adding new features or fixing bugs](#adding-new-features-or-fixing-bugs)
- [License](#license)
- [Footer](#footer)

# Todos Automation

This document contains the instructions to run the automation script written using Selenium with Java to test the todos page (https://todomvc.com/examples/angular2/). It also includes a quick guide to run the script, an overview of the scenarios tested as well as how the reporting works. I've also briefly explained why I used this specific tool, the challenges I faced along with what I've learnt from this project and what I would like to improve. 

# Installation
[(Back to top)](#table-of-contents)

The following files are present:
todo.java
pom.xml
TestNG.xml

To use this project, first clone the repo on your device using the command below:

```git init```

```git clone https://github.com/navendu-pottekkat/nsfw-filter.git```

# Demo-Preview

Following is the flow of the automation code. 

Input has been set in the Testng.xml to run all the tests in both Chrome and Firefox.

The methods setUp, loadProperties and openUrl have been assigned to "@BeforeTest" annotation in TestNG.

**TC1**

The createTask method is run and the number in the footer is checked to ensure that it has been added. 

**TC2**

The editTask method is then run to double click the task and edit the name. The modified name is then verified.
 
**TC3**
 
A method named clickTask was created to mark a task as complete.
For the next test case, the 


# Test Scenarios
[(Back to top)](#table-of-contents)

**Positive scenarios automated:**

| Test Case No | Scenario | Expected Result |
| :------------- |:-------------| :-----|
| TC1 | Create a task | A row should be added with the task name and "1 item left" should be displayed at the bottom. |
| TC2 | Update a task | The task should be editable when double clicked and the new name should be saved. |
| TC3 | Complete a task | The name of the task should be struckthrough and greyed out and the number of items displayed at the bottom should be reduced as 0. A "Clear Completed" link should be displayed. |
| TC4 | Uncheck a task | "1 item left" should be displayed at the bottom and the task name should not be struck through or greyed out. The "Clear Completed" link should also not be displayed. |
| TC5 | Delete an single task | The row should be removed when the task is individually deleted by clicking the 'x' and only the "What needs to be done?" textbox should be displayed. |
| TC6 | Clear a completed task | The row should be removed when the task is individually deleted by clicking the 'Clear Completed' link and only the "What needs to be done?" textbox should be displayed. |
| TC7 | Adding 'n' number of tasks | 'n' number of rows should be added with the task names and "'n' items left" should be displayed at the bottom. |
| TC8 | Delete multiple tasks | The previously created tasks should be deleted |

**Negative scenarios:** 
I have tested the following scenarios manually but it was all working properly. Without a requirements document, I am not able to formulate proper negative scenarios to automate and catch errors. 

Negative scenarios tested:
a) Entering more than 1000 words in a single todo task
b) Input validation including alphanumeric, symbols, foreign languages
c) Adding upto 65 todo tasks

# Development
[(Back to top)](#table-of-contents)

<!-- This is the place where you give instructions to developers on how to modify the code.

You could give **instructions in depth** of **how the code works** and how everything is put together.

You could also give specific instructions to how they can setup their development environment.

Ideally, you should keep the README simple. If you need to add more complex explanations, use a wiki. Check out [this wiki](https://github.com/navendu-pottekkat/nsfw-filter/wiki) for inspiration. -->

# Reporting
[(Back to top)](#table-of-contents)

I have used TestNG in this project and the reporting is done from that. 

### Sponsor
[(Back to top)](#table-of-contents)

<!-- Your project is gaining traction and it is being used by thousands of people(***with this README there will be even more***). Now it would be a good time to look for people or organisations to sponsor your project. This could be because you are not generating any revenue from your project and you require money for keeping the project alive.

You could add how people can sponsor your project in this section. Add your patreon or GitHub sponsor link here for easy access.

A good idea is to also display the sponsors with their organisation logos or badges to show them your love!(*Someday I will get a sponsor and I can show my love*) -->

### Adding new features or fixing bugs
[(Back to top)](#table-of-contents)

<!-- This is to give people an idea how they can raise issues or feature requests in your projects. 

You could also give guidelines for submitting and issue or a pull request to your project.

Personally and by standard, you should use a [issue template](https://github.com/navendu-pottekkat/nsfw-filter/blob/master/ISSUE_TEMPLATE.md) and a [pull request template](https://github.com/navendu-pottekkat/nsfw-filter/blob/master/PULL_REQ_TEMPLATE.md)(click for examples) so that when a user opens a new issue they could easily format it as per your project guidelines.

You could also add contact details for people to get in touch with you regarding your project. -->

# License
[(Back to top)](#table-of-contents)

<!-- Adding the license to README is a good practice so that people can easily refer to it.

Make sure you have added a LICENSE file in your project folder. **Shortcut:** Click add new file in your root of your repo in GitHub > Set file name to LICENSE > GitHub shows LICENSE templates > Choose the one that best suits your project!

I personally add the name of the license and provide a link to it like below. -->

[GNU General Public License version 3](https://opensource.org/licenses/GPL-3.0)

# Footer
[(Back to top)](#table-of-contents)

<!-- Let's also add a footer because I love footers and also you **can** use this to convey important info.

Let's make it an image because by now you have realised that multimedia in images == cool(*please notice the subtle programming joke). -->

Leave a star in GitHub, give a clap in Medium and share this guide if you found this helpful.

<!-- Add the footer here -->

<!-- ![Footer](https://github.com/navendu-pottekkat/awesome-readme/blob/master/fooooooter.png) -->
