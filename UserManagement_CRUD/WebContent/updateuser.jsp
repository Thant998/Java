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
<form action="UpdateUserServlet" method="post">
	<table>
		<tr>
			<td>ID:</td>
			<td><input type="text" name="id" value="${res.userId}"></td>
		</tr>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" value="${res.userName}" ></td>
		</tr>	
		<tr>
			<td>Email:</td>
			<td><input type="email" name="email" value="${res.userEmail}"></td>
		</tr>
		<tr>
			<td>Country:</td>
			<td><input type="text" name="country" value="${res.userCountry}"></td>
		</tr>
		<tr> 
 			<td></td>
 			<td><input type="submit" value="Update"></td>
 		</tr>	
	</table>
</form>
</body>
</html>