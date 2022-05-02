<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html xmlns:th="http://www.thymeleaf.org">

<html>
	<head>
		<meta charset="utf-8">
		<title>Edit</title>
	</head>
	<body>
		<h2><spring:message code="book.header" /></h2>


		<form:form commandName="book" method="post" action="/springweb-1.0.0-SNAPSHOT/edit">
			<table>
				<tr>
					<td><form:label path="name">
						><spring:message code="book.name" />
					</form:label></td>
					<td><form:input path="name"/></td>
					<td>
						<form:errors path="name" cssClass="error" element="div" />
					</td>
				</tr>
				<tr>
					<td><form:label path="author">
						><spring:message code="book.author" />
					</form:label></td>
					<td><form:input path="author"/></td>
					<td>
						<form:errors path="author" cssClass="error" element="div" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="pages">
							><spring:message code="book.pages" />
						</form:label>
					</td>
					<td><form:input path="pages"/></td>
					<td>
						<form:errors path="pages" cssClass="error" element="div" />
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"/></td>
				</tr>
			</table>
		</form:form>

			<c:if test="${!empty bookAdded}">
				<c:out value="${bookAdded}" />
			</c:if>

		<!-- TODO: Use Spring JSTL for form (commandName, action, method)-->
		<!-- TODO: Test if exist info message and show it -->
		<!-- TODO: Create table which contains field name (from resource bundle), input field, error info -->
		<!-- TODO: Add submit button -->
		
		<br/>
		<spring:url value="/" var="indexUrl" />
		<a href="${indexUrl}"><spring:message code="msg.index" /></a>
	</body>
</html>