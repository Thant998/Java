<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	table, th, td{
		border:1px solid blue;
		border-collapse:collapse;
	}

</style>
</head>
<body>
<jsp:include page="header.html"></jsp:include>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Country</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${requestScope.list}" var="data">
		<tr>
			<td>${data.userId}</td>
			<td>${data.userName}</td>
			<td>${data.userEmail}</td>
			<td>${data.userCountry}</td>
		</tr>
		<tr>
			<td>
				<a href="UpdateUserServlet?id=${data.userId}">Update</a>|
				<a href="DeleteUserServlet?id=${data.userId}">Delete</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>