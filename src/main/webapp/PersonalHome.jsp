<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/login.css">
</head>
<body>
	<%
	String username = null;
	if (request.getSession().getAttribute("username") == null) {
		response.sendRedirect("index.jsp");
	}
	%>
	<header>
		<div id="welcome">
			Welcome, <i>${name}</i>
		</div>
	</header>



	<div class="container">
		<form action="<%=request.getContextPath()%>/logout" method=get>
			<input type="hidden" name="action" value="destroy"> <input
				type="submit" value="logout" class="logout" id="logout">
		</form>
		<div class="col">
			<h2>
				<form action="<%=request.getContextPath()%>/balance" method=post>
					<input type="submit" value="Check Balance" class="balance"
						id="balance">
				</form>
			</h2>

		</div>
		<div class="col">
			<h2>
				<button id="withdraw" class="withdraw"
					onclick="location.href='<%=request.getContextPath()%>/withdraw.jsp'">Withdraw</button>
			</h2>
		</div>
		<div class="col">
			<h2>
				<button id="deposit" class="deposit"
					onclick="location.href='<%=request.getContextPath()%>/deposit.jsp'">Deposit</button>
			</h2>
		</div>
		<div class="col">
			<h2>
				<button id="transfer" class="transfer"
					onclick="location.href='<%=request.getContextPath()%>/transfer.jsp'">Transfer</button>
			</h2>
		</div>
	</div>


</body>
</html>