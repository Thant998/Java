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
<br><br><br>
	<table>
		<tr>
			<th>Book Code</th>
			<th>Book Title</th>
			<th>Book Author</th>
			<th>Book Prize</th>
			<th>Action</th>
		</tr> 
		<c:forEach items="${applicationScope.list}" var="data">
			<tr>
				<td>${data.code}</td>
				<td>${data.title}</td>
				<td>${data.author}</td>
				<td>${data.prize}</td>
				<td>
					<a href="updateBook.jsp?code=${data.code}&title=${data.title}&author=${data.author}&prize=${data.prize}">Update</a>|
					<a href="DeleteServlet?code=${data.code}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>