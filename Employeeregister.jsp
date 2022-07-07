<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Employee Register Form</h1>
<form action="EmployeeServlet" method="post">
<label for="firstName">First Name:</label>
<input type="text" id="firstName" name="firstName"><br><br>
<label for="lastName">Last Name:</label>
<input type="text" id="lastName" name="lastName"><br><br>
<label for="userName">UserName:</label>
<input type="text" id="userName" name="userName"><br><br>
<label for="pass">Password:</label>
<input type="password" id="pass" name="pass"><br><br>
<label for="add">Address:</label>
<input type="text" id="add" name="add"><br><br>
<label for="cont">Contact:</label>
<input type="text" id="cont" name="cont"><br><br>
<input type="submit" value="submit">
</form>
</div>

</body>
</html>