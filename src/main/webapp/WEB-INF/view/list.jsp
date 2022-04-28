<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>List</title>
	</head>
	<body>
		<h2><spring:message code="book.header.list" /></h2>
		
		<c:if test="${not empty books}">
			<table border="1">
				<thead>
					<tr>
						<td><spring:message code="book.name" /></td>
						<td><spring:message code="book.author" /></td>
						<td><spring:message code="book.pages" /></td>
						<td>&nbsp;</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="book" items="${books}">
						<tr>
							<td>${book.name}</td>
							<td>${book.author}</td>
							<td>${book.pages}</td>
							<td><a href="delete/${book.id}"><spring:message code="book.delete" /></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<br/>
		<spring:url value="/" var="indexUrl" />
		<a href="${indexUrl}"><spring:message code="msg.index" /></a>
	</body>
</html>