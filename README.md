# automation_test
Basic shopping cart automation test

Selenium + Cucumber-JVM automation testing framework
=============

Introduction
-----------

Selenium + Cucumber-JVM framework aims for web automation testing. In this framework the acceptance criteria written in plain English are translated into the Java code by Cucumber. Selenium is used to drive the browser. Test parameters like URL, test data and message etc are managed by Yaml or properties files. Finally cucumber html report is generated to display test result.

Prerequisites
-------------
* Install and config Maven (http://maven.apache.org/download.cgi, download apache-maven-3.3.3-bin.tar.gz or above)
* Install Java 1.8
* Install Chrome driver

* Optional -- Install cucumber execution terminal with color (https://github.com/adoxa/ansicon/downloads, download ansi160.zip  --follow its read me)
* Optional -- Install eclipse cucumber feature file editor which can highlight Gherkin key word
 
Setup
-----
Import the source code as Maven project, run "mvn clean install" to install maven dependency.
Git repository:  https://github.com/sandesh-patil/automation_test


Framework structure
------------------

* Feature files:  feature files are written using Gherkin language based on the behavior-driven development (BDD) style of Given, When, Then. Cucumber-JVM consumes feature files to generate test code.

* Step definitions: implement feature files in java code

* Page objects: page objects are used to abstract the interactions between a user and a web page. Selenium is used to drive the browser.

* Yaml and config properties files: yaml OR config.properties files are used to manage test parameters, you can define the test environment URL, test data and message etc.


Execute test scenarios
----------------------
To execute tests locally, execute the following commands: 

	mvn clean test
	
To execute tests with Junit test runner in IDE:
* 	Configure the RunCukesTest runner if not already configured from Edit configuration
*   Select add JUnit , enter test runner name as `RunCukesTest`
*   Select class path as `com.myStore.testrunners.RunCukesTest`
*   
	

Options:  
* [DEnv]test, integration, staging, blue and production. Using Configs.ENV by default.  
    	  Attention! 'blue' is a virtual environment. If blue provided, execute staging tests against production environment.  
* [DBrowser]chrome, firefox, ie. Using Configs.browser by default.  
* [Dcucumber.options]Overwrite tags in RunCukesTest.java if provided.  
* [DProxy]run bamboo CI plan should with proxy setting "on", if run locally, set to "off" or without proxy option

Alternative clean and execute all Tests
------------------------------------
To execute tests locally, and clean and install, run the below command

	mvn clean install -U -Dcucumber.options="--tags @mystore"

Cucumber Tags Description
------------------------
* Env: @test, @staging, @production, @envall
	Each test scenario should have one or more environment tags. A scenario with @envall tag will be executed under all environments.
	
* Priority: @myStore
	This tag is used to run only specific scenario that is intended to be executed
	


Cucumber html report
----------------------
After executing tests, navigate to below folder to check cucumber html reports: 

/target/cucumber-reports/advanced-reports/cucumber-html-reports/overview-features.html


Important Information
---------------------
* add your feature files under src/test/resources/features/
* add your step definition under src/test/java/stepdefinitions/
* add your page object under src/test/java/com/amazon/pages/XXX( XXX stands for items on mega menu)  
* put common function under src/test/java/com/amazon/common/
* git commands:
	
	git clone https://github.com/sandesh-patil/web_automation_test/tree/feature/automation_wip (clone the repository)  
	git status (check git status, like which branch you are working now)  
	git checkout -b <branch-name>  (create a new branch)  

	git status (before check in code, check code status, like which files are changed, which files are added, etc)  
	git add <files need to check in> (check in some files)  
	git add --all (check in all changed files)  
	git commit -am "comments for code check in"  
	git push origin <branch-name>  


* Before merge branch back to master, do rebase first, then merge.
* Follow the below steps before merging your changes from feature branch to Master  

	git checkout master  
	git pull origin master (this is to get the latest version from master)  
	git checkout <branch-name>  
	git push or pull to make sure you have the latest version in your branch as well.  
	git rebase master (resolve any conflicts)  
	git push origin <branch-name> (use -f for the force push if there has been changes made to commit comments or you have squashed commits)  


Notes
-----
1. Make sure once the repo is cloned to local folder, the Java JDK set up is all done
   * Goto File / Project Structure / and in Project Settings / Project , make sure `1.8 (java version"1.8.0_202")` is selected from drop-down for Project JDK
   * Select Project Language level as `8 - Lambdas, type annotations etc.`
   * Select Project compiler output : `/Users/XXXXXX/web_automation_test/classes` (XXXXXX is the default Username of the machine)
2. If any further questions or thoughts, please feel free to reach alfredsandesh@gmail.com 



