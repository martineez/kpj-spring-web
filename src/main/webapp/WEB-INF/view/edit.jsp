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

		<form:form method="POST" action="/springweb/edit" modelAttribute="book">
            <form:label path="name"><spring:message code="book.name" /></form:label>
            <form:input path="name" />

            <form:label path="author"><spring:message code="book.author" /></form:label>
            <form:input path="author" />

            <form:label path="pages"><spring:message code="book.pages" /></form:label>
            <form:input path="pages" />

            <input type="submit" value="Submit" />
        </form:form>

        <c:if test="${not empty infomsg}">
            <h3>${infomsg}</h3>
        </c:if>
		<c:if test="${not empty errormsg}">
            <h3>${errormsg}</h3>
        </c:if>

		<br/>
		<spring:url value="/" var="indexUrl" />
		<a href="${indexUrl}"><spring:message code="msg.index" /></a>
	</body>
</html>