<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.container {
	margin: auto;
	background-color: lightblue;;
	padding: 50px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
	width: 400px;
	text-align: center;
}
th,td{
padding:10px;
}
</style>
</head>
<body>
<header>
<h3 align="center">Register as a new customer.</h3><br>
</header>
<hr>
<div class="container">
<form method="post" action="<%= request.getContextPath()%>/register">
<table>
<tr>
<td>Username:</td>
<td><input type="text" name="username"/></td>
</tr>
<tr>
<td>Password:</td>

<td><input type="password" name="password"/></td>
</tr>
<tr>
<td>Retype password:</td>
<td><input type="password" name="password1"/></td>
</tr> 
</table>
<hr>
<input type="submit" value="submit">
</form>
</div>
</body>
</html>