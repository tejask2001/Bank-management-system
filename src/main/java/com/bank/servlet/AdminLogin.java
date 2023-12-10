package com.bank.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.Connection.JDBCConnection;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		Connection conn = null;
		PreparedStatement preset = null;
		ResultSet rs = null;
		int pos = 0;
		int result = 0;
		String sql="select id from admin where username=? and password=?";
		
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(sql, preset.RETURN_GENERATED_KEYS);
			preset.setString(++pos, username);
			preset.setString(++pos, password);
			rs = preset.executeQuery();
			if (rs.next()) {
				result = 1;
			}
			if(result>0) {
				response.sendRedirect("CorporateHome.jsp");
			}
			else {
				response.sendRedirect("adminLogin.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();		}
	}

}
