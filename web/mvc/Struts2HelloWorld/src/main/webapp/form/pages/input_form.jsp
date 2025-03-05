<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Hello World</title>
</head>
<body>
<s:form action="ProcessFormAction">
    <s:textfield label="First Name" name="firstName" id="firstName"
                 placeholder="Enter name here ... "/>
    <s:select name="gender" label="Gender"
              list="#{ 'Male':'m', 'Female':'f' }" headerKey="-1"
              headerValue="Choose" value="Male"/>
    <s:textfield label="Age" name="age" id="age"
                 placeholder="Enter age here ... "/>
    <s:submit label="Submit"/>
</s:form>
</body>
</html>