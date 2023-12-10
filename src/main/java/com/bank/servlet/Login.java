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

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String username;

	public Login() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;

		Connection conn = null;
		PreparedStatement preset = null;
		ResultSet rs = null;
		int pos = 0;
		int result = 0;
		String name = "";
		String sql = "select customer.first_name from login,customer where login.userName=? and password=? and login.customerId=customer.id;";
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(sql, preset.RETURN_GENERATED_KEYS);
			preset.setString(++pos, username);
			preset.setString(++pos, password);
			rs = preset.executeQuery();
			if (rs.next()) {
				result = 1;
				name = rs.getString(1);
			}
			if (result > 0) {
				request.getRequestDispatcher("Balance.java");
				session.setAttribute("name", name);
				session.setAttribute("username", username);

				response.sendRedirect("PersonalHome.jsp");
				dispatcher = request.getRequestDispatcher("PersonalHome.jsp");

			} else {
				response.sendRedirect("PersonalLogin.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
