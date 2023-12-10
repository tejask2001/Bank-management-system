<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bank.pojo.Bank"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bank Details</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

header {
	background-color: #333;
	color: #fff;
	padding: 10px;
	text-align: center;
}

main {
	padding: 20px;
}

footer {
	background-color: #333;
	color: #fff;
	padding: 10px;
	text-align: center;
	position: fixed;
	bottom: 0;
	width: 100%;
}

select {
	padding: 10px;
	font-size: 16px;
}
</style>
</head>
<body>

	<header>
		<h1>Bank Details</h1>
	</header>

	<main>
		<form method="post" action="<%=request.getContextPath()%>/bankDetails">
			<label for="bankSelect"><b>Select a Bank:</b></label> <select
				id="bankSelect" name="bankName">
				<option value="UCO">UCO Bank</option>
				<option value="BOB">Bank of Baroda</option>
				<option value="SBI">State Bank of India</option>
				<option value="BOM">Bank of Maharashtra</option>
				<option value="AXIS">AXIS Bank</option>
				<option value="HDFC">HDFC</option>
				<option value="BOI">Bank of India</option>
				<option value="CB">Canara Bank</option>
				<option value="ICICI">ICICI Bank</option>
				<option value="PNB">Punjab National Bank</option>
			</select> <br> <input type="submit" value="Submit">
		</form>

		
	</main>

	<footer> &copy; 2023 Bank Details Page </footer>

</body>
</html>
