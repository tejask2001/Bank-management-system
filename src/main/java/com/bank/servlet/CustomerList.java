package com.bank.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.Connection.JDBCConnection;
import com.bank.Impl.CustomerImpl;
import com.bank.pojo.Customer;

@WebServlet("/customerList")
public class CustomerList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerList() {
        super();
        
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			CustomerImpl impl=new CustomerImpl();
			
			request.setAttribute("list", impl.getcustomerList());
			RequestDispatcher rd=request.getRequestDispatcher("CustomerList.jsp");
			rd.forward(request, response);
}
}
