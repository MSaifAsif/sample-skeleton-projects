sample-skeleton-projects
========================

These projects are basic and easy to execute implementations of some of the popularly used frameworks out in the market and can be used to jump start your coding time by simply forking these projects or using them as reference and then building your application on top of them.

## <a name="list-index">List of implementation</a>
* [struts2 skeleton](#struts2skeleton)
* [Jacoco Code coverage](#jacococoverage)
* [JBOSS RESTEasy service](#jboss-rest-service)
* [How to contribute](#how-to-contrib)

## <a name="struts2skeleton">Struts2</a> [&#8593;](#list-index)
A blank runnable web project based on the struts2 MVC architecture. The project comprises of a sample action class that will return success and display the resulting view (jsp file). The project can be run on any application server. Basic configurations including struts and log4j are also added for reference

**How to run:** Import the project as a maven project, build the war file using maven and place the war in the tomcat webapps folder. Once deployment is complete by tomcat, the sample MVC can be viewed at the URL `http://yourhost:port/Struts2HelloWorld/sample/GreetAction`

## <a name="jacococoverage">Jacoco code coverage</a> [&#8593;](#list-index)
A beginner level application implementing the jacoco maven plugin to cover code coverage of the JUNIT test cases within the application

**How to run:** Import the project as a maven project, run `mvn clean test` and jacoco will create a site project inside `{proj.dir}/target/site` with multiple files. Open the index.html in any browser and you can view and browse to the various classes and test cases and get a visual representation of the code coverage of the test cases written

## <a name="jboss-rest-service">JBOSS REASTEasy</a> [&#8593;](#list-index)
An entry level application implementing the RESTEasy service of JBOSS. 

**How to run:** Import the project as a maven project, build the war file using maven and deploy this war in tomcat or Jboss application server. Once deployement is successful, you can view the service by opening any browser and navigate to the url `http://localhost:8080/RestEasyService/rest/greet/hello/Tenka`

## <a name="how-to-contrib">How to contribute</a> [&#8593;](#list-index)

The project is open for contributions from everyone. If you want to contribute to the project, the best way is to 
* Check the issues page to see if any pending issue is left and fixable
* Fork the repo
* Add documented and tested code
* Open a pull request to the master branch
* Once reviewed, the pull request will be merged
* README.md will contain information of runnable projects ONLY. All other projects are either in dev or testing phase

Its always best to open a issue and discuess its possibility before 
