<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="CSS/deposit.css">
<body>
<header>
<h1>Deposit money</h1>
<br>
<form action="<%=request.getContextPath()%>/logout" method="get" align="right">
<input type="hidden" name="action" value="destroy">
<input type="submit" value="logout" class="logout" >
</form>
</header>
<hr>
<br>
<main>
<br>
<form action="<%=request.getContextPath()%>/deposit" method="post">
<div>
<table>
<tr>
<th>
Enter the amount to deposit:
</th>
<td><input type="number" name="amount" class="amount">
<i><font color="red">${balance}</font></i>
</td>
</tr>
<tr>
<th>
Enter your PIN:
</th>
<td><input type="password" name="pin" maxLength="4">
<i><font color="red">${wrongPin}</font></i>
</td>
<tr>
<tr><td colspan="2" align="center">
<input type="submit" value="Submit" class="submit">
</td></tr>
</table>
</div>
<br>
</form>
<br>

${balancePostdeposit}
</main>
 <footer>
        <p>Banking app.</p>
    </footer>
</body>
</html>