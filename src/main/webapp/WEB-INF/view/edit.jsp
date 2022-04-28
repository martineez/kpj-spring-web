<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Edit</title>
	</head>
	<body>
		<h2><spring:message code="book.header" /></h2>
		
		<!-- TODO: Use Spring JSTL for form (commandName, action, method)-->
		<!-- TODO: Test if exist info message and show it -->
		<!-- TODO: Create table which contains field name (from resource bundle), input field, error info -->
		<!-- TODO: Add submit button -->
		
		<br/>
		<spring:url value="/" var="indexUrl" />
		<a href="${indexUrl}"><spring:message code="msg.index" /></a>
	</body>
</html>