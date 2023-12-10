<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modern Banking Page</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: powderblue;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        header {
            background-color: #2c3e50;
            color: #ecf0f1;
            text-align: center;
            padding: 20px;
        }
        main {
            text-align: center;
            padding: 50px;
        }
        footer {
            background-color: #34495e;
            color: #bdc3c7;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
        #logout{
	position: relative;
	left: 45%;
	border-radius: px;
	min-height: 10px;
	min-width: 60px;
	box-shadow: 0px 0px 6px 2px darkolivegreen;
}
.logout:hover{
	background-color: darkgoldenrod;
}
    </style>
</head>
<body>
    <header>
        <h1>Balance</h1>
        <form action="<%=request.getContextPath()%>/logout" method=get>
			<input type="hidden" name="action" value="destroy"> <input
				type="submit" value="logout" class="logout" id="logout">
		</form>
    </header>
    <main>
    
       <h3><b>${msg}</b></h3>
    </main>
    <footer>
        <p>Banking app.</p>
    </footer>
</body>
</html>
	