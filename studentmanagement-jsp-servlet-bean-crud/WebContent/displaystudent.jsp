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
			<th>Student ID</th>
			<th>Name</th>
			<th>Date Of Birth</th>
			<th>Subject</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${applicationScope.list}" var="data">
			<tr>
				<td>${data.id}</td>
				<td>${data.name}</td>
				<td>${data.dob}</td>
				<td>${data.subjects}</td>
				<td>
					<a href="updateStudent.jsp?id=${data.id}&name=${data.name}&dob=${data.dob}&subjects=${data.subjects}">Update</a>|
					<a href="DeleteStudentServlet?id=${data.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>