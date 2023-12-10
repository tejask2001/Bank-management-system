package com.bank.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.bank.Impl.UserImpl;
import com.bank.pojo.Address;
import com.bank.pojo.Customer;
import com.bank.pojo.User;

@WebServlet("/register")
public class RegisterCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterCustomer() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String password1=request.getParameter("password1");
		PrintWriter out=response.getWriter();
		User user=new User();
		user.setUserName(username);
		user.setPassword(password1);
		
	UserImpl impl=new UserImpl();
	int result=impl.saveUser(user);
		if(result>0) {
			out.println("user registered");
		}
		
		
		
		
		/*PrintWriter out=response.getWriter();
		out.println(username);
		out.println(password);
		out.println(password1);
		out.println(firstName);
		out.println(lastName);
		out.println(flatNumber);
		out.println(landmark);
		out.println(city);
		out.println(district);
		out.println(state);
		out.println(country);
		out.println(pincode);
		out.println(isAddressEnable);
		out.println(accountNumber);
		out.println(isAddressEnable);
		out.println(currentBalance);
		out.println(mobileNumber);
		out.println(bank_name);
		out.println(isEnable);
		out.println(pin);*/
		
	}
}
