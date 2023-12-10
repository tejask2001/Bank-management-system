package com.bank.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.Connection.JDBCConnection;
import com.bank.pojo.Bank;
import com.bank.pojo.Customer;

@WebServlet("/bankDetails")
public class BankDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		String bankName=request.getParameter("bankName");
		List<Bank> bankList = new ArrayList<Bank>();
		Connection conn=null;
		PreparedStatement preset=null;
		ResultSet rs=null;
		Statement st=null;
		String sql="select * from bank where bank_name='"+bankName+"'";
		
		try {
			conn=JDBCConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			Bank bank=null;
			while(rs.next()) {
				bank=new Bank();
				bank.setBankId(rs.getInt("id"));
				bank.setBankName(rs.getString("bank_name"));
				bank.setIfscNumber(rs.getString("ifsc_code"));
				bank.setTotalNumberofCustomer(rs.getInt("total_no_of_cust"));
				bank.setBankBalance(rs.getInt("bank_bal"));
				bank.setAddressId(rs.getInt("add_id"));
				bankList.add(bank);
				
				request.setAttribute("bankDetails", bankList);
				RequestDispatcher dispatcher=request.getRequestDispatcher("hhh.jsp");
				dispatcher.forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
