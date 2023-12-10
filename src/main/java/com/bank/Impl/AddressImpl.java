package com.bank.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.bank.Connection.JDBCConnection;
import com.bank.dao.AddressInterface;
import com.bank.pojo.Address;
import com.bank.pojo.Bank;

public class AddressImpl implements AddressInterface {

	public static final String getaddressList = "Select * from address";
	public static final String saveAddress = "insert into address(flat_number,landmark,city,district,state,country,pin_code,isEnable,created_date) values(?,?,?,?,?,?,?,?,now())";
	public static final String updateAddress = "update address set city=? where id=?";
	public static final String deleteAddress = "delete from address where id=?";
	public static final String disableAddress = "update address set isEnable=? where id=?";

	@Override
	public List<Address> getaddressList() {
		List<Address> addressList = new ArrayList<Address>();
		Connection conn = null;
		// String sql = "select * from address";
		// PreparedStatement pre = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(getaddressList);
			Address address = null;
			while (rs.next()) {
				address = new Address();
				address.setAddressId(rs.getInt("id"));
				address.setFlatNumber(rs.getInt("flat_number"));
				address.setLandmark(rs.getString("landmark"));
				address.setCity(rs.getString("city"));
				address.setDistrict(rs.getString("district"));
				address.setState(rs.getString("state"));
				address.setCountry(rs.getString("country"));
				address.setPinNumber(rs.getInt("pin_code"));
				addressList.add(address);
			}
			List<Address> list = new ArrayList<Address>();
			list=addressList.stream().filter(p->p.getAddressId()>7).collect(Collectors.toList());
			System.out.println(list);
			/*
			 * for (Address ad : addressList) { System.out.println(ad); }
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
		return addressList;
	}

	@Override
	public int saveAddress(Address address) {
		Connection conn = null;
		PreparedStatement preset = null;
		int result = 0;
		int pos = 0;
		int addressId = 0;
		ResultSet rs = null;
		boolean flag = isAddressExists(address);
		if (!flag) {

			try {
				conn = JDBCConnection.getConnection();
				conn.setAutoCommit(false);
				preset = conn.prepareStatement(saveAddress, preset.RETURN_GENERATED_KEYS);
				preset.setInt(++pos, address.getFlatNumber());
				preset.setString(++pos, address.getLandmark());
				preset.setString(++pos, address.getCity());
				preset.setString(++pos, address.getDistrict());
				preset.setNString(++pos, address.getState());
				preset.setString(++pos, address.getCountry());
				preset.setInt(++pos, address.getPinNumber());
				preset.setInt(++pos, address.getIsEnable());
				preset.executeUpdate();
				rs = preset.getGeneratedKeys();

				if (rs.next()) {
					conn.commit();
					addressId = rs.getInt(1);
					System.out.println(address.getCity() + " inserted into DB with " + addressId);
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
		return addressId;
	}

	@Override
	public List<Address> saveAddressList(List<Address> addressList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAddressExists(Address address) {
		boolean result = false;
		Address existingAddress = null;
		List<Address> addressList = null;

		try {
			addressList = getaddressList();
			Iterator itr = addressList.iterator();
			while (itr.hasNext()) {
				existingAddress = (Address) itr.next();
				if ((existingAddress.getLandmark().equalsIgnoreCase(address.getLandmark()))
						&& (existingAddress.getCity().equalsIgnoreCase(address.getCity()))) {
					result = true;
					// System.out.println("Address already exists");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public Address updateAddress(Address address, int id) {
		Connection conn = null;
		PreparedStatement preset = null;
		// String sql = "update address set city=? where id=?";
		int result = 0;
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(updateAddress, preset.RETURN_GENERATED_KEYS);
			preset.setString(1, address.getCity());
			preset.setInt(2, id);

			result = preset.executeUpdate();
			if (result > 0) {
				System.out.println("Address updated successfully......");
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
		return null;
	}

	@Override
	public void deleteAddress(int id) {
		Connection conn = null;
		PreparedStatement preset = null;
		// String sql = "delete from address where id=?";
		int result = 0;
		int pos = 0;
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(deleteAddress, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, id);
			result = preset.executeUpdate();
			if (result > 0)
				System.out.println("Address deleted....");
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
	public boolean disableAddress(int disable, int id) {
		Connection conn = null;
		PreparedStatement preset = null;
		// String sql = "update address set isEnable=? where id=?";
		int result = 0;
		int pos = 0;
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(disableAddress, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, disable);
			preset.setInt(++pos, id);
			result = preset.executeUpdate();
			if (result > 0)
				System.out.println("Address disabled.....");
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
	public boolean isAddressEnable(int id) {
		Connection conn = null;
		PreparedStatement preset = null;
		int pos = 0;
		ResultSet rs = null;
		String sql = "select isEnable from address where id=?";
		int in = 0;
		try {
			conn = JDBCConnection.getConnection();
			preset = conn.prepareStatement(sql, preset.RETURN_GENERATED_KEYS);
			preset.setInt(++pos, id);
			rs = preset.executeQuery();
			while (rs.next()) {
				int v = rs.getInt("isEnable");
				System.out.println(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
