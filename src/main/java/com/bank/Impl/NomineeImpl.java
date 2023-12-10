package com.bank.Impl;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bank.Connection.JDBCConnection;

public class NomineeImpl {
	
	public void getMyNominees(int id) {
		Connection conn=null;
		PreparedStatement preset=null;
		ResultSet rs=null;
		int pos=0;
		String sql="select n.firstName from customer c,nominee n,customer_nominee cs where cs.cust_id=c.id and cs.nomi_id=n.id and cs.cust_id=? and cs.nomi_id=n.id";
		
		try {
			conn=JDBCConnection.getConnection();
			preset=conn.prepareStatement(sql,preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, id);
			rs=preset.executeQuery();
			int i=0;
			while(rs.next()) {
				i=1;
				System.out.println(rs.getString(i));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getNominee(int id) {
		Connection conn=null;
		PreparedStatement preset=null;
		ResultSet rs=null;
		int pos=0;
		String sql="select c.firstName,c.lastName from customer c,nominee n,customer_nominee cs where cs.cust_id=c.id and cs.nomi_id=n.id and cs.nomi_id=? and cs.cust_id=c.id;";
		try {
			conn=JDBCConnection.getConnection();
			preset=conn.prepareStatement(sql,preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, id);
			rs=preset.executeQuery();
			int i=0;
			while(rs.next()) {
				i=1;
				System.out.println(rs.getString(i));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
