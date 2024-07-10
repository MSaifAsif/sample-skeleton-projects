# Log4j
Language: Java

## Description:
Basic implementation of how to create configure and use the logging capabilites provided by log4j.

## How to run:
Checkout the project to any directory and on the command prompt type `mvn clean test` and it will execute the 
test cases and a log will get printed on the console and the same log will be redirected to a log file namely 
`myApp.log` located at `${project_home}/logs`. The key point to understand is how to use the configuration file that 
is read by the log4j library. This file is located at `src/main/resources/log4j2.xml`
```shell
[~]$ mvn clean test
```
