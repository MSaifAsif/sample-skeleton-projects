<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- The following are custom tags/tld --%>
<%@ taglib prefix="mt" uri="WEB-INF/greet.tld"%>
<%@ taglib prefix="dt" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Servlet3.0</title>
</head>
<body>
    <div>
        This is my first JSP - called at
        <dt:date />
    </div>
    <div>
        <mt:greet-msg username="Chris">
        Greetings
    </mt:greet-msg>
    </div>
    <div>
        <c:import url="/fragments/one.jsp" />
    </div>
    <div align="right">
        <span> A few context parameters are : </span>
        <c:import url="/fragments/footer.jsp" />
    </div>
</body>
</html>