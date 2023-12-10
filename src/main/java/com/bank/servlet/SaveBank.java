package com.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.bank.Impl.BankImpl;
import com.bank.pojo.Address;
import com.bank.pojo.Bank;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/BankServlet")
public class SaveBank extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveBank() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String bankName = (String) session.getAttribute("bank_name");
		String ifsc = (String) session.getAttribute("ifsc_code");
		int totalCustomer = 0;
		String bankbalance = (String) session.getAttribute("bank_bal");
		int bankBalance = Integer.parseInt(bankbalance);
		
		
		String landmark = request.getParameter("landmark");
		int flatNumber = Integer.parseInt(request.getParameter("flatNumber"));
		String city = request.getParameter("city");
		String district = request.getParameter("district");
		String state = request.getParameter("state");
		String country=request.getParameter("country");
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		int isEnable=Integer.parseInt(request.getParameter("isEnable"));
		
		Address address = null;
		Bank bank = null;
		try {
			address=new Address();
			address.setFlatNumber(flatNumber);
			address.setLandmark(landmark);
			address.setCity(city);
			address.setDistrict(district);
			address.setState(state);
			address.setPinNumber(pincode);
			address.setCountry(country);
			address.setIsEnable(isEnable);
			
			bank = new Bank();
			bank.setBankName(bankName);
			bank.setIfscNumber(ifsc);
			bank.setTotalNumberofCustomer(totalCustomer);
			bank.setBankBalance(bankBalance);
			bank.setAddress(address);
			BankImpl impl = new BankImpl();
			int result=impl.saveBank(bank);
			if(result>0) {
			response.sendRedirect("success.jsp");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
