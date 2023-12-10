package com.bank.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.Connection.JDBCConnection;
import com.bank.pojo.Customer;
import com.bank.pojo.User;

public class UserImpl {

	public int saveUser(User user) {
		Connection conn = null;
		int rs = 0;
		PreparedStatement preset = null;
		int result = 0;
		int pos = 0;
		
		String sql = "insert into login(userName,password,customerId) values(?,?,?)";
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(sql, preset.RETURN_GENERATED_KEYS);
			preset.setString(++pos, user.getUserName());
			preset.setString(++pos, user.getPassword());
			preset.setInt(++pos, 6);
			rs = preset.executeUpdate();
			if (rs>0) {
				System.out.println("user registered");
				result=1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}