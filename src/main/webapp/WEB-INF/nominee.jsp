<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nominee</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/logout" method=get align="right">
		<input type="hidden" name="action" value="destroy"> <input
			type="submit" value="logout" class="logout" id="logout">
	</form>
	<hr>
	<form method="post" action="<%=request.getContextPath()%>/nominee">
		<input type="submit" value="submit" class="submit" />
		
		<hr>
		
		
</body>
</html>