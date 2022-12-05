<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file = "menu.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<form action="update" method="post">
		<pre>
			<input type = "hidden" name = "id" value = "${lead.id}"/>
			First Name <input type = "text" name = "firstName" value = "${lead.firstName}"/>
			Last Name <input type = "text" name = "lastName" value = "${lead.lastName}"/>
			Email <input type = "text" name = "email" value = "${lead.email}"/>
			Mobile <input type = "text" name = "mobile" value = "${lead.mobile}"/>
			<input type = "Submit" value = "Update"/>
		</pre>
	</form>
</body>
</html>
