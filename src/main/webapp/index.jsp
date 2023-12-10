<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Banking Application</title>
<style>
body {
	font-family: 'Arial', sans-serif;
	margin: 0;
	padding: 0;
	background: url('templates/abs-img.jpg') no-repeat center center fixed;
	background-size: cover;
	color: #fff;
	text-align: center;
}

header {
	background-color: rgba(0, 64, 128, 0.8);
	padding: 1em;
}

h1 {
	margin: 0;
	font-size: 2.5em;
}

main {
	padding: 2em;
}

.btn-container {
	display: flex;
	justify-content: space-around;
	margin-top: 2em;
}

.banking-btn {
	padding: 1.5em 3em;
	font-size: 1.2em;
	cursor: pointer;
	background-color: #009688;
	color: #fff;
	border: none;
	border-radius: 5px;
	transition: background-color 0.3s;
	box-shadow: 5px 5px 40px powderblue;
}

.banking-btn:hover {
	background-color: #00796b;
}

footer {
	background-color: rgba(0, 64, 128, 0.8);
	padding: 1em;
	position: fixed;
	bottom: 0;
	width: 100%;
	color: #fff;
}
</style>
</head>
<body>
	<header>
		<h1>Welcome to Our Banking Application</h1>
	</header>
	<main>
		<div class="btn-container">
			<button class="banking-btn"
				onclick="location.href='<%=request.getContextPath()%>/adminLogin.jsp'">Corporate
				Banking</button>
			<button class="banking-btn"
				onclick="location.href='<%=request.getContextPath()%>/PersonalLogin.jsp'">Personal
				Banking</button>
		</div>
	</main>
	<footer>
		<p>Banking App.</p>
	</footer>
</body>
</html>