package com.bank.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {

	static String driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/bank_db";
	static String username="_______";
	static String password="_________";
	
	
	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, username, password);
			//System.out.println("Connection done....");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		JDBCConnection c=new JDBCConnection();
		c.getConnection();
	}
}