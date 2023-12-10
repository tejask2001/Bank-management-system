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

import com.bank.Impl.NomineeImpl;

@WebServlet("/nominee")
public class Nomine extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Nomine() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		String sql="select c.currentBalance from customer c, login l where l.customerId=c.id and l.userName=?";
		
		Connection conn=null;
		PreparedStatement preset=null;
		ResultSet rs=null;
		int result=0;
		int pos=0;
		try {
			
		}catch(Exception e) {
			e.printStackTrace();		}
		
		NomineeImpl impl=new NomineeImpl();
		impl.getMyNominees(0);
		
		session.setAttribute("nominee", "");
		response.sendRedirect("nominee.jsp");
	}
}
