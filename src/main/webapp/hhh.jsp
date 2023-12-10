<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bank.pojo.Bank"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	background-color:powderblue;
	
}

table,th,td{
	border-collapse: collapse;
	padding: 4px;
}
th{
    background-color:teal;
    font-size: 18px;
    color: white;
    text-transform: uppercase;
  }
tr{
	border-bottom: 1px solid white;
}
td{
	background-color:lightsteelblue;
	text-align: center;
	
}
</style>
</head>
<body>
<header>
<h1 align="center">List of Customer</h1>
</header>
<div id="bankDetails">
			<%
ArrayList<Bank> list=(ArrayList<Bank>) request.getAttribute("bankDetails");
%>
			<table border="1" align="center">
				<tr>
					<th>Id</th>
					<th>Bank Name</th>
					<th>IFSC Code</th>
					<th>Total Customer</th>
					<th>Bank balance</th>
					<th>Address Id</th>
				</tr>
				<%for (Bank cs : list) {%>
				<tr>
					<td><%=cs.getBankId() %></td>
					<td><%=cs.getBankName() %></td>
					<td><%=cs.getIfscNumber() %></td>
					<td><%=cs.getTotalNumberofCustomer() %></td>
					<td><%=cs.getBankBalance() %></td>
					<td><%=cs.getAddressId() %></td>
				</tr>
				<%}%>
			</table>
		</div>
</body>
</html>