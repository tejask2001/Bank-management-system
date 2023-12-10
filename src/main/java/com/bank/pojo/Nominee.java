package com.bank.pojo;

public class Nominee {
	private int cust_id;
	private int nomi_id;
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public int getNomi_id() {
		return nomi_id;
	}
	public void setNomi_id(int nomi_id) {
		this.nomi_id = nomi_id;
	}
	@Override
	public String toString() {
		return "Nominee [cust_id=" + cust_id + ", nomi_id=" + nomi_id + "]";
	}
}