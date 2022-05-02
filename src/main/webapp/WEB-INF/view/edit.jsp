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

        <form:form action="/springweb/edit" commandName="book" method="post">
            <table>
	            <tr>
		            <td><label><strong><spring:message code="book.name" /></label></strong></td>
		            <td><form:input path="name"/></td>
		            <td align="left" style="color:red;"><form:errors path="name" cssClass="error"/></td>
	            </tr>
	            <tr>
		            <td><label><strong><spring:message code="book.author" /></label></strong></td>
		            <td><form:input path="author"/></td>
		            <td align="left" style="color:red;"><form:errors path="author" cssClass="error"/></td>
	            </tr>
	            <tr>
		            <td><label><strong><spring:message code="book.pages" /></label></strong></td>
		            <td><form:input path="pages"/></td>
		            <td align="left" style="color:red;"><form:errors path="pages" cssClass="error"/></td>
	            </tr>
            </table>

            <spring:message code="book.save" var="labelSubmit"/>
            <input type="submit" value="${labelSubmit}"/>

            <c:if test="${not empty info}">
                <b style="color:green;"><p>${info}</p></b>
            </c:if>

        </form:form>

		<br/>
		<spring:url value="/" var="indexUrl" />
		<a href="${indexUrl}"><spring:message code="msg.index" /></a>
	</body>
</html>