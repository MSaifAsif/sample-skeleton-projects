<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ tag import="java.text.DateFormat" import="java.util.Date" %>
<%
    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
    Date now = new Date(System.currentTimeMillis());
    out.println(dateFormat.format(now));
%>