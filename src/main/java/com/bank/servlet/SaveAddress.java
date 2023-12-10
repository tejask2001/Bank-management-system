package com.bank.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.bank.Impl.AddressImpl;
import com.bank.pojo.Address;

@WebServlet("/AddressServlet")
public class SaveAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveAddress() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PrintWriter out = res.getWriter();
		String landmark = request.getParameter("landmark");
		int flatNumber = Integer.parseInt(request.getParameter("flatNumber"));
		String city = request.getParameter("city");
		String district = request.getParameter("district");
		String state = request.getParameter("state");
		String country=request.getParameter("country");
		int pincode = Integer.parseInt(request.getParameter("pincode"));
		Address address = null;
		AddressImpl impl=new AddressImpl();

		try {
			address=new Address();
			address.setAddressId(999);
			address.setFlatNumber(flatNumber);
			address.setLandmark(landmark);
			address.setCity(city);
			address.setDistrict(district);
			address.setState(state);
			address.setPinNumber(pincode);
			address.setCountry(country);
			impl.saveAddress(address);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
