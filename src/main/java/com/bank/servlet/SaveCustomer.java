package com.bank.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.bank.Impl.CustomerImpl;
import com.bank.pojo.Address;
import com.bank.pojo.Customer;

@WebServlet("/CustomerServlet")
public class SaveCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SaveCustomer() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session=request.getSession();
		
		String firstName=(String) session.getAttribute("firstName");
		String lastName=(String) session.getAttribute("lastName");
		String accountnumber=(String) session.getAttribute("accountNumber");
		String currentbalance=(String) session.getAttribute("currentBalance");		
		String mobilenumber=(String) session.getAttribute("mobileNumber");		
		String bank=(String) session.getAttribute("bankName");
		String isenable=(String) session.getAttribute("isEnable");
		int accountNumber=Integer.parseInt(accountnumber);
		int currentBalance=Integer.parseInt(currentbalance);		
		long mobileNumber=Long.parseLong(mobilenumber);		
		int isEnable=Integer.parseInt(isenable);
		
		String landmark = request.getParameter("landmark");
		int flatNumber = Integer.parseInt(request.getParameter("flatNumber"));
		String city = request.getParameter("city");
		String district = request.getParameter("district");
		String state = request.getParameter("state");
		String country=request.getParameter("country");
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		int isAddressEnable=Integer.parseInt(request.getParameter("isEnable"));
		
		Address address = null;
		int result=0;
		Customer customer=null;
		try {
			address=new Address();
			address.setFlatNumber(flatNumber);
			address.setLandmark(landmark);
			address.setCity(city);
			address.setDistrict(district);
			address.setState(state);
			address.setPinNumber(pincode);
			address.setCountry(country);
			address.setIsEnable(isAddressEnable);
			
			customer=new Customer();
			customer.setCustomerFirstName(firstName);
			customer.setCustomerLastName(lastName);
			customer.setAccountNumber(accountNumber);
			customer.setCustomerCurrentBal(currentBalance);
			customer.setMobileNumber(mobileNumber);
			
			customer.setAddress(address);
			customer.setIsEnable(isEnable);
			
			customer.setPin(7777);
			CustomerImpl impl=new CustomerImpl();
			result=impl.saveCustomer(customer, bank);
			System.out.println("Customer saved"); 
			if(result>0) {
				response.sendRedirect("success.jsp");
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
