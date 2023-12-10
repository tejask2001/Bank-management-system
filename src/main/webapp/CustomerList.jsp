<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="java.util.ArrayList" %>
   <%@page import="com.bank.pojo.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/customerList.css">
</head>
<body>
<header>
<h1 align="center">List of Customer</h1>
</header>
<%
ArrayList<Customer> list=(ArrayList<Customer>) request.getAttribute("list");
%>
<table border="1" align="center">
<tr>
<th>Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Account Number</th>
<th>Current Balance</th>
<th>Mobile Number</th>
</tr>
<%for (Customer cs : list) {%>
<tr>
<td>
<%=cs.getCustomerId() %>
</td>
<td>
<%=cs.getCustomerFirstName()%>
</td>
<td>
<%=cs.getCustomerLastName() %>
</td>
<td>
<%=cs.getAccountNumber() %>
</td>
<td>
<%=cs.getCustomerCurrentBal() %>
</td>
<td>
<%=cs.getMobileNumber() %>
</td>
</tr>
<%}%>
</table>
</body>
</html>