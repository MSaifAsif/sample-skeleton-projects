Sample Skeleton Projects
========================
[![Build Status](https://travis-ci.org/MSaifAsif/sample-skeleton-projects.svg?branch=master)](https://travis-ci.org/MSaifAsif/sample-skeleton-projects)

These projects are basic and easy to execute implementations of some of the popularly used frameworks and libraries out in the market and can be used to jump start your coding time by simply forking these projects or using them as reference and then building your application on top of them. The implementations range from advanced MVC frameworks such as Struts to small testing libraries like JUnit or pyUnit. 



## <a name="list-index">List of implementation</a>
* [struts2 skeleton](#struts2skeleton)
* [Jacoco Code coverage](#jacococoverage)
* [JBOSS RESTEasy service](#jboss-rest-service)
* [pyUnit](#py-unit)
* [How to contribute](#how-to-contrib)

## <a name="struts2skeleton">Struts2</a> [&#8593;](#list-index)
**Language:** Java

**Description:** A blank runnable web project based on the struts2 MVC architecture. The project comprises of a sample action class that will return success and display the resulting view (jsp file). The project can be run on any application server. Basic configurations including struts and log4j are also added for reference

**How to run:** Import the project as a maven project, build the war file using maven and place the war in the tomcat webapps folder. Once deployment is complete by tomcat, the sample MVC can be viewed at the URL `http://yourhost:port/Struts2HelloWorld/sample/GreetAction`

## <a name="jacococoverage">JaCoco code coverage</a> [&#8593;](#list-index)
**Language:** Java

**Description:** A beginner level application implementing the jacoco maven plugin to cover code coverage of the JUNIT test cases within the application

**How to run:** Import the project as a maven project, run `mvn clean test` and jacoco will create a site project inside `{proj.dir}/target/site` with multiple files. Open the index.html in any browser and you can view and browse to the various classes and test cases and get a visual representation of the code coverage of the test cases written

## <a name="jboss-rest-service">JBOSS RESTEasy</a> [&#8593;](#list-index)
**Language:** Java

**Description:** An entry level application implementing the RESTEasy service of JBOSS. 

**How to run:** Import the project as a maven project, build the war file using maven and deploy this war in tomcat or Jboss application server. Once deployement is successful, you can view the service by opening any browser and navigate to the url `http://localhost:8080/RestEasyService/rest/greet/hello/Tenka`

## <a name="py-unit">pyUnit</a> [&#8593;](#list-index)
**Language:** Python

**Description:** Basic implementation of how to create unit tests for python2.7 using the built-in unit test library for the python language. 

**How to run:** Checkout the project to any directory and on the command prompt type `python cal_test.py` and it will execute the test cases and the result status of all the test cases will be displayed on the terminal

## <a name="how-to-contrib">How to contribute</a> [&#8593;](#list-index)

The project is open for contributions from everyone. If you want to contribute to the project, the best way is to 
* Check the issues page to see if any pending issue is left and fixable
* Fork the repo
* Add documented and tested code
* Open a pull request to the master branch
* Once reviewed, the pull request will be merged
* README.md will contain information of runnable projects ONLY. All other projects are either in dev or testing phase

Its always best to open a issue and discuss its possibility before 
