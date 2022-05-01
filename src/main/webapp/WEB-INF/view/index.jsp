<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome braaaaa</title>
	</head>
	<body>
		<h2><spring:message code="msg.index" /></h2>
		<ul>
			<li><a href="list"><spring:message code="book.header.list" /></a></li>
			<li><a href="edit"><spring:message code="book.header" /></a></li>
		</ul>
	</body>
</html>
