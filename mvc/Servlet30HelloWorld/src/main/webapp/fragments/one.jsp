<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:forEach step="1" items="${numberList}" var="element"
    varStatus="loopStatus">
    <div>
        <c:set var="numberValue" value="${element}" />
        <c:out value="${loopStatus.index} : " />
        <c:out value="${fn:substring(numberValue, 0, 10)}" />
        <% out.print("."); %>
    </div>
</c:forEach>