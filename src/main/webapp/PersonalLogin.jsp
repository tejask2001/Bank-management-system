<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="CSS/index.css">
<body>
	<div class="container">
		<div class="wrapper">
			<div class="title">
				<span>Login</span>
			</div>
			<form method="post" action="<%= request.getContextPath()%>/login" >
				<div class="row">
					<i class="fas fa-user"></i> <input type="text"
						placeholder="Username" name="username" required>
				</div>
				<div class="row">
					<i class="fas fa-lock"></i> <input type="password"
						placeholder="Password" name="password" required>
				</div>
				<div class="row button">
					<input type="submit" value="Login"><br>
					
					Don't have account, <a href="register.jsp">Register here</a> 
				</div>
			</form>
		</div>
	</div>
</body>
</html>