<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="CSS/homepage.css">
</head>
<body>
	<header>
		<h1 align="center">Bank Registration Page</h1>
		<br>
		<h2 align="right">
			<form action="<%=request.getContextPath()%>/logout" method=get>
				<input type="hidden" name="action" value="destroy"> <input
					type="submit" value="logout" class="logout" id="logout">
			</form>
		</h2>
	</header>
	<hr>
	<br>
	<div class="container">
		<button id="transfer" class="bank"
			onclick="location.href='<%=request.getContextPath()%>/Bank.jsp'">Save
			Bank</button>
		<br>
		<button id="transfer" class="customer"
			onclick="location.href='<%=request.getContextPath()%>/Customer.jsp'">Save
			Customer</button>
		<br>
		<button id="transfer" class="address"
			onclick="location.href='<%=request.getContextPath()%>/bankDetails.jsp'">Bank
			Details</button>
		<br>
		<form action="<%=request.getContextPath()%>/customerList" method=post>
			<input type="submit" value="Customer List" class="getList"
				id="getList">
		</form>
	</div>

</body>
</html>