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
.submit:hover{
 background-color: chocolate;
  color: black;
}
</style>

<title>Address Registration</title>
</head>
<body>
	<div class="container">
		<header>
			<h1>Address Registration</h1>
		</header>

		<main>
		
		<%
		String annotation=null;
		
		if(session.getAttribute("check").equals("bank")){
			annotation="BankServlet";
		}
		else{
			annotation="CustomerServlet";
		}
		
		
		String bank_name=request.getParameter("bank_name");
		String ifsc_code=request.getParameter("ifsc_code");
		String bank_bal=request.getParameter("bank_bal");
		
		session.setAttribute("bank_name", bank_name);
		session.setAttribute("ifsc_code", ifsc_code);
		session.setAttribute("bank_bal", bank_bal);
		%>
		
		<%
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String accountNumber=request.getParameter("accountNumber");
		String currentBalance=request.getParameter("currentBalance");
		String mobileNumber=request.getParameter("mobileNumber");
		String bankName=request.getParameter("bankName");
		String isEnable=request.getParameter("isEnable");
		
		session.setAttribute("firstName", firstName);
		session.setAttribute("lastName", lastName);
		session.setAttribute("accountNumber", accountNumber);
		session.setAttribute("currentBalance", currentBalance);
		session.setAttribute("mobileNumber", mobileNumber);
		session.setAttribute("bankName", bankName);
		session.setAttribute("isEnable", isEnable);
		%>

			<form action=<%=annotation%> method="POST">

				<label for="landmark">Landmark:</label> <input type="text"
					id="landmark" name="landmark" required> <label
					for="flatNumber">Flat Number:</label> <input type="text"
					id="flatNumber" name="flatNumber" required> <label
					for="city">City:</label> <input type="text" id="city" name="city"
					required> <label for="district">District:</label> <input
					type="text" id="district" name="district" required> <label
					for="state">State:</label> <input type="text" id="state"
					name="state" required> <label for="country">Country:</label>

				<input type="text" id="country" name="country" required> <label
					for="pincode">Pincode:</label> <input type="text" id="pincode"
					name="pincode" required> <label for="isEnable">Is

					Enable:</label> <select id="isEnable" name="isEnable">
					<option value="1">Yes</option>
					<option value="0">No</option>
				</select>
				<button type="submit" class="submit">Register</button>
			</form>
	</div>
</body>
</html>