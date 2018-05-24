<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of all contacts</title>
</head>
<body>

<h1>List of all contacts</h1>

<table border="1">
	<tr>
		<th>Name</th>
		<th>Email</th>
		<th>Phone</th>
		<th>Address</th>
	</tr>
	<c:forEach items="${requestScope.contacts}" var="c">
	<tr>
		<td>${c.firstname} ${c.lastname}</td>
		<td>${c.email}</td>
		<td>${c.phone}</td>
		<td>${c.address}</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>