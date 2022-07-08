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
<h1>Employee Login Form</h1>
<form action="LoginServlet" method="post">
<label for="name">UserName;</label>
<input type="text" id="name" name="name"><br><br>
<label for="pass">Password:</label>
<input type="password" id="pass" name="pass"><br><br>
<input type="submit" value="Submit">
</form>
</div>
</body>
</html>