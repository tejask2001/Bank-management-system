package com.bank.main;

import java.util.ArrayList;
import java.util.List;

import com.bank.Impl.*;
import com.bank.pojo.*;

public class BankMain {
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.setBankName("Dena Bank");
		bank.setIfscNumber("XXXDe");
		bank.setTotalNumberofCustomer(8888);
		bank.setBankBalance(6000);
		//bank.setAddId(6);

		Address address = new Address();
		address.setFlatNumber(555);
		address.setLandmark("Gandhi ward");
		address.setCity("Nagpur");
		address.setDistrict("Nagpur");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPinNumber(441101);
		address.setIsEnable(1);

		Customer customer = new Customer();
		customer.setCustomerFirstName("Pratik");
		customer.setCustomerLastName("Patil");
		customer.setAccountNumber(303030);
		customer.setCustomerCurrentBal(8888);
		customer.setMobileNumber(96969696);
		// customer.setBankId(4);
		customer.setIsEnable(1);
		customer.setPin(1112);
		
		ArrayList<Integer> list=new ArrayList<>();
		list.add(445544);
		list.add(754854);
		list.add(432101);
		customer.setNomineeAccount(list);
		customer.setAddress(address);

		
		
		/*NomineeImpl ni=new NomineeImpl();
		
		System.out.println("My nominees are :");
		ni.getMyNominees(1);
		System.out.println(" ");
		System.out.println("I'm nominee of :");
		ni.getNominee(1);*/
		
		AddressImpl impl=new AddressImpl();
		impl.getaddressList();
	
	}
}