package com.bank.pojo;

import java.sql.Date;
import java.util.ArrayList;

public class Customer {
	private int customerId;
	private int bankId;
	private int addrId;
	private String customerFirstName;
	private String customerLastName;
	private int accountNumber;
	private double customerCurrentBal;
	private int isEnable;
	private long mobileNumber;
	private Address address;
	private int pin;
	private ArrayList<Integer> nomineeAccount;
	private Date createdDate;

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public int getAddrId() {
		return addrId;
	}

	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getCustomerCurrentBal() {
		return customerCurrentBal;
	}

	public void setCustomerCurrentBal(double customerCurrentBal) {
		this.customerCurrentBal = customerCurrentBal;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public ArrayList<Integer> getNomineeAccount() {
		return nomineeAccount;
	}

	public void setNomineeAccount(ArrayList<Integer> nomineeAccount) {
		this.nomineeAccount = nomineeAccount;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", bankId=" + bankId + ", addrId=" + addrId
				+ ", customerFirstName=" + customerFirstName + ", customerLastName=" + customerLastName
				+ ", accountNumber=" + accountNumber + ", customerCurrentBal=" + customerCurrentBal + ", isEnable="
				+ isEnable + ", mobileNumber=" + mobileNumber + ", address=" + address + ", pin=" + pin
				+ ", nomineeAccount=" + nomineeAccount + ", createdDate=" + createdDate + "]";
	}

	
}
