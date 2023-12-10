package com.bank.pojo;

import java.sql.Date;
import java.util.List;

public class Bank {
	private int bankId;
	private String bankName;
	private String ifscNumber;
	private int totalNumberofCustomer;
	private double bankBalance;
	private int addressId;
	private Address address;
	private Date createdDate;
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfscNumber() {
		return ifscNumber;
	}
	public void setIfscNumber(String ifscNumber) {
		this.ifscNumber = ifscNumber;
	}
	public int getTotalNumberofCustomer() {
		return totalNumberofCustomer;
	}
	public void setTotalNumberofCustomer(int totalNumberofCustomer) {
		this.totalNumberofCustomer = totalNumberofCustomer;
	}
	public double getBankBalance() {
		return bankBalance;
	}
	public void setBankBalance(double bankBalance) {
		this.bankBalance = bankBalance;
	}
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + ", ifscNumber=" + ifscNumber
				+ ", totalNumberofCustomer=" + totalNumberofCustomer + ", bankBalance=" + bankBalance + ", addressId="
				+ addressId + ", address=" + address + ", createdDate=" + createdDate + "]";
	}
	
	
	

	
}
