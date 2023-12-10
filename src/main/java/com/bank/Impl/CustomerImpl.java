package com.bank.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.bank.Connection.JDBCConnection;
import com.bank.dao.CustomerInterface;
import com.bank.pojo.Customer;

public class CustomerImpl implements CustomerInterface {

	public static final String getCustomerList = "Select * from customer";
	public static final String saveCustomer = "insert into customer(first_name,last_name,account_number,current_balance,mobile_number,bank_id,addr_id,is_enable,pin,created_date) values(?,?,?,?,?,?,?,?,?,now())";
	public static final String updateCustomer = "Update customer set last_name=? where id=?";
	public static final String deleteCustomer = "delete from customer where id=?";
	public static final String disableCustomer = "update customer set is_enable=? where id=?";
	public static final String getCustomerCurrentBalance = "select current_balance from customer where account_number=?";
	public static final String withdrawAmount = "update customer set current_balance=current_balance-? where id=?";

	@Override
	public List<Customer> getcustomerList() {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection conn = null;
		// String sql = "select * from customer";
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = JDBCConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(getCustomerList);
			Customer customer = null;
			while (rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt("id"));
				customer.setCustomerFirstName(rs.getString("first_name"));
				customer.setCustomerLastName(rs.getString("last_name"));
				customer.setAccountNumber(rs.getInt("account_number"));
				customer.setCustomerCurrentBal(rs.getInt("current_balance"));
				customer.setMobileNumber(rs.getLong("mobile_number"));
				customer.setBankId(rs.getInt("bank_id"));
				customer.setAddrId(rs.getInt("addr_id"));
				customerList.add(customer);
			}
			/*
			 * for (Customer cs : customerList) { System.out.println(cs); }
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
		return customerList;
	}

	@Override
	public int saveCustomer(Customer customer,String bank) {
		Connection conn = null;
		ResultSet rs=null;
		PreparedStatement preSts = null;
		int result = 0;
		int pos = 0;
		int bankId=0;
		int nomineeId=0;
		int customerId=0;
		int addressId=0;
		try {
			conn = JDBCConnection.getConnection();
			conn.setAutoCommit(false);
			preSts = conn.prepareStatement(saveCustomer, preSts.RETURN_GENERATED_KEYS);
			preSts.setString(++pos, customer.getCustomerFirstName());
			preSts.setString(++pos, customer.getCustomerLastName());
			preSts.setInt(++pos, customer.getAccountNumber());
			preSts.setDouble(++pos, customer.getCustomerCurrentBal());
			preSts.setLong(++pos, customer.getMobileNumber());

			BankImpl bankImpl = new BankImpl();
			bankId = bankImpl.getBankId(bank);
			preSts.setInt(++pos, bankId);

			AddressImpl impl = new AddressImpl();
			addressId = impl.saveAddress(customer.getAddress());
			preSts.setInt(++pos, addressId);
			preSts.setInt(++pos, customer.getIsEnable());
			preSts.setInt(++pos, customer.getPin());
			preSts.executeUpdate();
			rs = preSts.getGeneratedKeys();

			if (rs.next()) {
				conn.commit();
				customerId = rs.getInt(1);
				System.out.println("Customer added");
				//System.out.println(address.getCity() + " inserted into DB with " + addressId);
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
		return customerId;
	}

	@Override
	public List<Customer> saveCustomerList(List<Customer> customerList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCustomerExists(Customer customer) {
		boolean result = false;
		List<Customer> customerList = null;
		Customer existingCustomer = null;
		try {
			customerList = getcustomerList();
			Iterator itr = customerList.iterator();
			while (itr.hasNext()) {
				existingCustomer = (Customer) itr.next();
				if ((existingCustomer.getCustomerId() == customer.getCustomerId()) && (existingCustomer
						.getCustomerFirstName().equalsIgnoreCase(customer.getCustomerFirstName()))) {
					result = true;
					System.out.println("Customer already exists");

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Customer updateCustomer(Customer customer, int id) {
		Connection conn = null;
		PreparedStatement preset = null;
		
		int result = 0;
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(updateCustomer, preset.RETURN_GENERATED_KEYS);
			preset.setString(1, customer.getCustomerLastName());
			preset.setInt(2, id);
			result = preset.executeUpdate();
			if (result > 0)
				System.out.println("Customer updated successfully........");
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
	public void deletecustomer(int id) {
		Connection conn = null;
		PreparedStatement preset = null;
		// String sql = "delete from customer where id=?";
		int result = 0;
		int pos = 0;
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(deleteCustomer, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, id);
			result = preset.executeUpdate();
			if (result > 0)
				System.out.println("Customer deleted....");
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
	public boolean disableCustomer(int disable, int id) {
		Connection conn = null;
		PreparedStatement preset = null;
		// String sql = "update customer set isEnable=? where id=?";
		int result = 0;
		int pos = 0;
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(disableCustomer, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, disable);
			preset.setInt(++pos, id);
			result = preset.executeUpdate();
			if (result > 0)
				System.out.println("Customer disabled.....");
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
	public double getCustomerCurrentBalance(int accountNumber) {
		double balance = 0.0;
		Connection conn = null;
		PreparedStatement preset = null;
		int pos = 0;
		ResultSet rs = null;
		
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(getCustomerCurrentBalance, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, accountNumber);
			rs = preset.executeQuery();
			while (rs.next()) {
				balance = rs.getDouble(1);
				System.out.println(balance);
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
			if (preset != null) {
				try {
					preset.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return balance;
	}

	@Override
	public void depositAmount(int id, double amount) {
		Connection conn = null;
		PreparedStatement preset = null;
		int pos = 0;
		int result = 0;
		String sql = "update customer set current_balance=current_balance+? where id=?";
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(sql, preset.RETURN_GENERATED_KEYS);
			preset.setDouble(++pos, amount);
			preset.setInt(++pos, id);
			result = preset.executeUpdate();
			if (result > 0) {
				System.out.println("Amount deposited successfully...");
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
	public void withdrawAmount(int id, double amount) {
		Connection conn = null;
		PreparedStatement preset = null;
		int pos = 0;
		int result = 0;
		ResultSet rs = null;
		double balance = 0.0;
		String ch = "select current_balance from customer where id=?";
		
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(ch, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, id);
			rs = preset.executeQuery();
			while (rs.next()) {
				balance = rs.getDouble(1);
			}
			if (balance > amount) {
				pos = 0;
				preset = conn.prepareStatement(withdrawAmount, preset.RETURN_GENERATED_KEYS);
				preset.setDouble(++pos, amount);
				preset.setInt(++pos, id);
				result = preset.executeUpdate();
				if (result > 0) {
					System.out.println("Amount withdraw successfully...");
				}
			} else {
				System.out.println("Insufficient amount");
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
	public void transferAmount(int debterID, int crediterId, double amount) {
		Connection conn = null;
		PreparedStatement preset = null;
		int pos = 0;
		int result = 0;
		ResultSet rs = null;
		double balance = 0.0;
		String check = "select current_balance from customer where id=?";
		String withdraw = "update customer set current_balance=current_balance-? where id=?";
		String deposit = "update customer set current_balance=current_balance+? where id=?";
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(check, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, debterID);
			rs = preset.executeQuery();
			while (rs.next()) {
				balance = rs.getDouble(1);
			}
			if (balance > amount) {
				pos = 0;
				preset = conn.prepareStatement(withdraw, preset.RETURN_GENERATED_KEYS);
				preset.setDouble(++pos, amount);
				preset.setInt(++pos, debterID);
				result = preset.executeUpdate();
				if (result > 0) {
					System.out.println("Amount transferred successfully...");
				}
			} else {
				System.out.println("Insufficient amount to transfer");
			}

			pos = 0;
			preset = conn.prepareStatement(deposit, preset.RETURN_GENERATED_KEYS);
			preset.setDouble(++pos, amount);
			preset.setInt(++pos, crediterId);
			result = preset.executeUpdate();
			if (result > 0) {
				System.out.println("Amount received.....");
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
			if (preset != null) {
				try {
					preset.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
} 