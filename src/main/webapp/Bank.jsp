<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="styles.css">
<style>
body {
	background-image: url('log3.avif');
	background-size: cover;
	background-repeat: no-repeat;
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	background-color: #f4f4f4;
	padding: 50px;
	border-radius: 10px;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
	width: 400px;
	text-align: center;
}

header {
	text-align: center;
	background-color: #4CAF50;
	color: #fff;
	border-radius: 15px;
	padding: 0.5px;
}

form {
	max-width: 300px;
	margin: 0 auto;
	margin-top: 20px;
}

label {
	display: block;
	text-align: left;
	margin-bottom: 5px;
	font-weight: bold;
}

input[type="text"] {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

select {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

button {
	background-color: #007BFF;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	display: block;
	margin: 0 auto;
}

footer {
	margin-top: 10px;
}

.next:hover{
 background-color: chocolate;
  color: black;
}
</style>
<title>Bank Registration</title>
</head>
<body>
	<div class="container">
		<header>
			<h1>Bank Registration</h1>
		</header>
		<main>
		<%
		session.setAttribute("check", "bank");
		%>
			<form action="<%=request.getContextPath()%>/Address.jsp" method="POST">
				<label for="bank_name">Bank name:</label> <input type="text"
					id="bank_name" name="bank_name" required> <label
					for="ifsc_code">IFSC code:</label> <input type="text"
					id="ifsc_code" name="ifsc_code" required> <label for="bank_bal">Bank balance:</label> <input
					type="text" id="bank_bal" name="bank_bal" required> 
				 <button type="submit" class="next">Next</button> 
			</form>
		</main>
	</div>
</body>
</html>