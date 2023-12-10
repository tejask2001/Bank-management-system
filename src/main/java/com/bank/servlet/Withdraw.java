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

@WebServlet("/withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Withdraw() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cash=request.getParameter("amount");
		String pin=request.getParameter("pin");
		int amount=Integer.parseInt(cash);
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		PrintWriter out=response.getWriter();
		RequestDispatcher dispatcher=null;
		
		Connection conn=null;
		PreparedStatement preset=null;
		ResultSet rs=null;
		int result=0;
		int pos=0;
		int balance=0;
		int balancePostWithdraw=0;
		String pinDB=null;
		String pinCheck="select c.pin from customer c,login l where l.customerId=c.id and l.userName=?";
		String checkBal="select c.current_balance  from customer c,login l where c.id=l.customerId and l.userName=?";
		String withdraw="update customer c,login l set c.current_balance =c.current_balance -? where l.customerId=c.id and l.userName=?";
		
		try {
			conn=JDBCConnection.getConnection();
			preset=conn.prepareStatement(pinCheck,preset.RETURN_GENERATED_KEYS);
			preset.setString(++pos, username);
			rs=preset.executeQuery();
			if(rs.next()) {
				pinDB=rs.getString(1);
			}
			if(pinDB.equals(pin)) {
				preset=null;
				rs=null;
				pos=0;
				preset=conn.prepareStatement(checkBal,preset.RETURN_GENERATED_KEYS);
				preset.setString(++pos, username);
				rs=preset.executeQuery();
				if(rs.next()) {
					balance=rs.getInt(1);
				}
				if(balance>amount) {
					preset=null;
					rs=null;
					pos=0;
					preset=conn.prepareStatement(withdraw,preset.RETURN_GENERATED_KEYS);
					preset.setInt(++pos, amount);
					preset.setString(++pos, username);
					result=preset.executeUpdate();
					if(result>0) {
						balancePostWithdraw=balance-amount;
						session.setAttribute("balancePostWithdraw", "Amount withdraw successfully, your updated balance is "+balancePostWithdraw);
						session.setAttribute("balance", "");
						session.setAttribute("wrongPin", "");
						response.sendRedirect("withdraw.jsp");
					}
				}else {
					session.setAttribute("balance", "Insufficient Balance");
					response.sendRedirect("withdraw.jsp");
					dispatcher=request.getRequestDispatcher("balance.jsp");
				}
			}else {
				session.setAttribute("wrongPin", "Incorrect pin");
				response.sendRedirect("withdraw.jsp");
				dispatcher=request.getRequestDispatcher("withdraw.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
