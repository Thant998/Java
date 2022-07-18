<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.html"></jsp:include><br><br>
<div style="color:red;">${error}</div>
	<form action="AddStudentServlet" method="post">
		<table>
			<tr>
				<td>Student ID:</td>
				<td><input type="text" name="id" value="${bean.id}"></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" value="${bean.name}"></td>
			</tr>
			<tr>
				<td>Date Of Birth:</td>
				<td><input type="date" name="birthday" value="${bean.dob}"></td>
			</tr>
			<tr>
				<td>Subjects;</td>
				<td><input type="text" name="course" value="${bean.subjects}"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="ADD"></td>
			<tr>
		</table>
	</form>
</body>
</html>