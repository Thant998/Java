<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.html"></jsp:include>
<div style=color:red;>${error}</div>
<form action="UpdateStudentServlet" method="post">
    <table>
			<tr>
				<td>Student ID:</td>
				<td><input type="text" name="id" value="${param.id}"></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="${param.name}"></td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td><input type="date" name="birthday" value="${param.dob}"></td>
			</tr>
			<tr>
				<td>Subjects:</td>
				<td><input type="text" name="course" value="${param.subjects}"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update"></td>
			<tr>
		</table>
 		
 	
</form>
</body>
</html>