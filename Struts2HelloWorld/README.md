**What is Struts2**

Originally known as `WebWork 2`, the `Apache Struts 2` is an open-source web application framework for developing enterprise-ready Java EE based web applications. It uses and extends the Java Servlet API to encourage developers to adopt a model–view–controller (MVC) architecture.


**How it works**

The over-all design of the framework is more or less the same as any of the MVC frameworks out in the market. In a nutshell, the Model is usually a java bean or a java business object that contains the business logic of manipulating data that may be recieved from external sources say like e.g retrieved from a database or from some web service etc. The View is the representation of the data usually in the form of a JSP page or an HTML page. The Controller is the actual engine that contains mapping related to passing data between the JSP views and the business logic Models.

The figure below best explains the flow of how a request is generated, how it flows through the framework architecture and how a response is created at the end ()
![alt tag](http://www.javatpoint.com/images/st/struts2flow.jpg)

1. First and foremost, the user generates a request. This can anything from clicking a button on a website or uploading an image to the webpage etc
2. The Container maps the request in the web.xml file and gets the class name of controller. The container is where your application is deployed. This is an application server like Tomcat or JBoss etc.
3. Container invokes the controller (StrutsPrepareAndExecuteFilter for struts2.x onwards and FilterDispatcher before struts2.x). These two are the actual names of the struts2 controller files that are resposnible for understanding the request and forwarding it to the designated action classes.
3. Controller gets the information for the action from the ActionMapper.
5. Controller invokes the ActionProxy
6. ActionProxy gets the information of action and interceptor stack from the configuration manager which gets the information from the struts.xml file which contains mappings (in the form of xml) regarding which class is mapped to which URL. Something like how servlets are mapped with url-patterns in the web.xml
7. ActionProxy forwards the request to the ActionInvocation
8. ActionInvocation invokes each interceptors first and then the action class that is mapped with the request URL in the struts.xml file
9. A result is generated once the action class is executed succesfully.
10. The result is sent back to the ActionInvocation
11. A HttpServletResponse is generated.
12. Response is sent to the user

> sources & references: Javatpoint, Wikipedia
