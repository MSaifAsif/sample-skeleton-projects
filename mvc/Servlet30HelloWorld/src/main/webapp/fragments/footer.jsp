<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<% out.println(application.getAttribute("sessionID")); %>
<% out.println(application.getAttribute("applicationName")); %>
<% out.println(application.getAttribute("applicationVersion")); %>