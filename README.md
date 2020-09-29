[![Join the chat at https://gitter.im/MSaifAsif/sample-skeleton-projects](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/MSaifAsif/sample-skeleton-projects?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge) [![Score](https://www.code-inspector.com/project/13916/score/svg)](https://frontend.code-inspector.com/public/project/13916/sample-skeleton-projects/dashboard) [![status](https://www.code-inspector.com/project/13916/status/svg)](https://frontend.code-inspector.com/public/project/13916/sample-skeleton-projects/dashboard)





# Sample Skeleton Projects
A collection of small skeleton projects to help start development quickly.

## What is this ?
The projects are simply basic and easy to execute implementations of some of the popularly used frameworks and libraries out in the market.  Definition of small depends on LOC. The idea started as a private project but now is being put public for everyone to benefit.

## Wait, what's LOC
LOC, or simply Lines Of Code, is the approximate sum of the minimum lines of code and configurations that are absolutely essential to deploy the project

## Why do I need this ?
These can be used to jump start your coding time by simply forking these projects or using them as reference and then building your application on top of them. In theory you just need to do a few steps to have it up and running. The following is an example of how to run the `SpringBootHelloWorld` skeleton

```bash
$ cd web-api/SpringBootHelloWorld/
$ mvn spring-boot:run
....
RequestHandler]
2020-09-29 13:35:28.722  INFO 48888 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2020-09-29 13:35:28.784  INFO 48888 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-09-29 13:35:28.790  INFO 48888 --- [           main] com.sample.runners.StandAloneClient      : Started StandAloneClient in 2.763 seconds (JVM running for 8.289)
...
```

## What's included ?
The implementations range from MVC frameworks like Struts to small testing libraries like JUnit.

## I can't find the framework I am using 
Help us implement it. Open a [request](https://github.com/MSaifAsif/sample-skeleton-projects/issues) or send us a PR. More than happy to add more.

**Note:** Projects not listed in the index table below are either in development phase or in debug mode and are not be relied on yet.

```bash
.
├── benchmarking
│   └── JMH
├── big-data
│   └── MapReduceHelloWorld
├── crawlers
│   └── JsoupHelloWorld
├── datastore
│   ├── nosql
│   │   └── MongoDbHelloWorld
│   └── sql
│       ├── Ebean
│       └── JPA
├── logging
│   ├── Log4j
│   └── logback
├── mvc
│   ├── AppletHelloWorld
│   ├── JSFHelloWorld
│   ├── PlayHelloWorld
│   ├── Servlet30HelloWorld
│   ├── Struts2HelloWorld
│   ├── StrutsHelloWorld
│   ├── TapestryHelloWolrd
│   └── WicketHelloWorld
├── profiling
├── queuing
│   └── SpringBootRabbitMQ
├── testing
│   ├── mocking
│   │   └── mockito
│   ├── ui-testing
│   │   └── cypress_test_integration
│   └── unit-testing
│       ├── junit4
│       │   └── UnitTestsCodeCoverage
│       └── junit5
├── web-api
│   ├── AxisWebserviceHelloWorld
│   ├── DropwizardHelloWorld
│   ├── EJBHelloWorld
│   ├── Firefly
│   ├── JavaLiteHelloWorld
│   ├── Pippo
│   ├── PortletsHelloWorld
│   ├── RESTEasy
│   ├── SparkHelloWorld
└── └── SpringBootHelloWorld
```
