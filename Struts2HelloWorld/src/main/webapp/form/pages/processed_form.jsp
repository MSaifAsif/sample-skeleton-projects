<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Hello World</title>
</head>
<body>
    <div>
        <span>You entered the following information :</span> <br>
        <s:property value="firstName" />
        ,
        <s:property value="age" />
        ,
        <s:property value="gender" />
    </div>
</body>
</html>