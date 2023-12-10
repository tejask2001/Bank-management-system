package com.bank.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.Connection.JDBCConnection;
import com.mysql.cj.protocol.Resultset;

@WebServlet("/balance")
public class Balance extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		RequestDispatcher dispatcher=null;
		String username=(String) session.getAttribute("username");
		
		Connection conn=null;
		PreparedStatement preset=null;
		ResultSet rs=null;
		int pos=0;
		int balance=0;
		
		String sql="select c.current_balance from customer c, login l where l.customerId=c.id and l.userName=?";
		
		try {
			conn=JDBCConnection.getConnection();
			preset=conn.prepareStatement(sql,preset.RETURN_GENERATED_KEYS);
			preset.setString(++pos, username);
			rs = preset.executeQuery();
			if(rs.next()) {
				balance=rs.getInt(1);
				session.setAttribute("msg", username+", your current balance is "+balance);
				response.sendRedirect("balance.jsp");
				dispatcher=request.getRequestDispatcher("balance.jsp");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}