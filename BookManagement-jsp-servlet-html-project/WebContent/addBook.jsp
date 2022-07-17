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
<form action="AddBookServlet" method="post">
     <table>
 		<tr> 
 			<td>Book Code:</td>
 			<td><input type="text" name="code" value="${bean.code}"></td>
 		</tr>
 		<tr> 
 			<td>Book Title:</td>
 			<td><input type="text" name="title" value="${bean.title}"></td>
 		</tr>
 		<tr> 
 			<td>Book Author:</td>
 			<td><input type="text" name="author" value="${bean.author}"></td>
 		</tr>
 		<tr> 
 			<td>Book Prize:</td>
 			<td><input type="text" name="prize" value="${bean.prize}"></td>
 		</tr>
 		<tr> 
 			<td></td>
 			<td><input type="submit" value="Add"></td>
 		</tr>
     </table>
</form>
</body>
</html>