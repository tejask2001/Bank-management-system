package com.bank.pojo;

import java.sql.Date;

public class Address {
	private int addressId;
	private int flatNumber;
	private String landmark;
	private String city;
	private String district;
	private String state;
	private int pinNumber;
	private String country;
	private int isEnable;
	private Date createdDate;

	public void setIsEnable(int isEnable) {
		this.isEnable = isEnable;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int i) {
		this.pinNumber = i;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getIsEnable() {
		return isEnable;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", flatNumber=" + flatNumber + ", landmark=" + landmark + ", city="
				+ city + ", district=" + district + ", state=" + state + ", pinNumber=" + pinNumber + ", country="
				+ country + ", isEnable=" + isEnable + ", createdDate=" + createdDate + "]";
	}

	
}
