package com.bank.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import com.bank.Connection.JDBCConnection;
import com.bank.dao.BankInterface;
import com.bank.pojo.Bank;
import com.bank.pojo.Customer;

public class BankImpl implements BankInterface {

	public static final String getBankList = "Select * from Bank";
	public static final String saveCustomer = "insert into bank(bank_name,ifsc_code,total_no_of_cust,bank_bal,add_id,created_date)values(?,?,?,?,?,now())";
	public static final String updateBank = "update bank set bank_name=? where id=? and bank_name=?";
	public static final String deleteBank = "delete from bank where id=?";
	public static final String disableBank = "update bank set isEnable=? where id=?";

	@Override
	public List<Bank> getbankList() {
		Connection conn = null;
		// String sql = "select * from Bank";
		Bank bank = null;
		Statement st = null;
		ResultSet rs = null;
		List<Bank> BankList = null;
		try {
			conn = JDBCConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(getBankList);
			BankList = new ArrayList<Bank>();
			while (rs.next()) {
				bank = new Bank();
				bank.setBankId(rs.getInt("id"));
				bank.setBankName(rs.getString("bank_name"));
				bank.setIfscNumber(rs.getString("ifsc_code"));
				bank.setTotalNumberofCustomer(rs.getInt("total_no_of_cust"));
				bank.setBankBalance(rs.getInt("bank_bal"));
				bank.setAddressId(rs.getInt("add_id"));
				BankList.add(bank);
			}
			/*
			 * for (Bank b : BankList) { System.out.println(b); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return BankList;
	}

	@Override
	public int saveBank(Bank bank) {
		Connection conn = null;
		PreparedStatement preSts = null;
		ResultSet rs=null;
		int result = 0;
		int pos = 0;
		int addressId=0;
		int bankId=0;
		boolean flag = isBankExists(bank);
		if (!flag) {
			// String sql = "insert into
			// bank(bank_name,ifsc_code,total_no_of_cust,bank_bal,add_id)values(?,?,?,?,?)";
			try {
				conn = JDBCConnection.getConnection();
				preSts = conn.prepareStatement(saveCustomer, preSts.RETURN_GENERATED_KEYS);
				// preSts.setInt(1, bank.getBankId());
				preSts.setString(++pos, bank.getBankName());
				preSts.setString(++pos, bank.getIfscNumber());
				preSts.setInt(++pos, bank.getTotalNumberofCustomer());
				preSts.setDouble(++pos, bank.getBankBalance());
				AddressImpl impl=new AddressImpl();
				addressId=impl.saveAddress(bank.getAddress());
				preSts.setInt(++pos, addressId);
				preSts.executeUpdate();
				rs = preSts.getGeneratedKeys();

				if (rs.next()) {
					bankId = rs.getInt(1);
				}
				
				if (result > 0) {
					System.out.println(bank.getBankName() + " inserted into DB with " + bank.getBankId());
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (preSts != null) {
					try {
						preSts.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			System.out.println("Bank already exists......");
		}
		return bankId;
	}

	@Override
	public List<Bank> saveBankList(List<Bank> bankList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBankExists(Bank newBank) {
		boolean result = false;
		Bank existingBank = null;
		List<Bank> bankList = null;

		try {
			bankList = getbankList();
			Iterator itr = bankList.iterator();
			while (itr.hasNext()) {
				existingBank = (Bank) itr.next();
				if ((existingBank.getIfscNumber().equalsIgnoreCase(newBank.getIfscNumber()))
						&& (existingBank.getBankName().equalsIgnoreCase(newBank.getBankName()))) {
					result = true;
					// System.out.println("Bank already exists.....");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Bank updateBank(Bank bank, int id, String bank_name) {
		Connection conn = null;
		PreparedStatement preset = null;
		// String sql = "update bank set bank_name=? where id=? and bank_name=?";
		int result = 0;
		int pos = 0;
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(updateBank, preset.RETURN_GENERATED_KEYS);
			preset.setString(++pos, bank.getBankName());
			preset.setInt(++pos, id);
			preset.setString(++pos, bank_name);
			result = preset.executeUpdate();
			if (result > 0)
				System.out.println("Bank updated successfully......");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preset != null) {
				try {
					preset.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public void deleteBank(int id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement preset = null;
		// String sql = "delete from bank where id=?";
		int result = 0;
		int pos = 0;
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(deleteBank, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, id);
			result = preset.executeUpdate();
			if (result > 0)
				System.out.println("Bank deleted.....");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preset != null) {
				try {
					preset.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public boolean disableBank(int disable, int id) {
		Connection conn = null;
		PreparedStatement preset = null;
		// String sql = "update bank set isEnable=? where id=?";
		int result = 0;
		int pos = 0;
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(disableBank, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, disable);
			preset.setInt(++pos, id);
			result = preset.executeUpdate();
			if (result > 0)
				System.out.println("Bank disabled......");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preset != null) {
				try {
					preset.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public int getBankId(String bank) {
		Connection conn = null;
		PreparedStatement preset = null;
		int pos = 0;
		int bankId = 0;
		ResultSet rs = null;
		String sql = "select id from bank where bank_name=?";
		int in = 0;
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(sql, preset.RETURN_GENERATED_KEYS);
			preset.setString(++pos, bank);
			rs = preset.executeQuery();
			while (rs.next()) {
				bankId = rs.getInt("id");
				// System.out.println(v);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bankId;
	}

}