package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.config.DatabaseConnection;
import com.revature.constant.Constant;
import com.revature.dao.UserDao;
import com.revature.model.User;

public class UserDaoImplementation implements UserDao{
	
	static Connection con = DatabaseConnection.getConnection();

	@Override
	public int addUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		String query = Constant.USER_INSERT;
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, user.getLoginId());
		ps.setString(2, user.getFirstname());
		ps.setString(3, user.getLastName());
		ps.setString(4, user.getEmailId());
		ps.setString(5, user.getPhoneNumber());
		ps.setString(6, user.getPassword());
		ps.setString(7, user.getIdentityProof());
		ps.setString(8, user.getPhysicalDisability());
		ps.setString(9, user.getAddress());
		ps.setString(10, user.getDateOfBirth());
		ps.setString(11, "User");
		int n = ps.executeUpdate();
		return n;
//		return 0;
	}

	@Override
	public void deleteUser(String loginId) throws SQLException {
		// TODO Auto-generated method stub
		String query = Constant.USER_DELETE;
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, loginId);
		ps.executeUpdate();
		
	}

	@Override
	public User getUser(String loginId) throws SQLException {
		// TODO Auto-generated method stub
		String query = Constant.USER_GET_ONE_USER;
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, loginId);
		ps.execute();
		
		User user = new User();
		ResultSet rs = ps.executeQuery();
        boolean check = false;
        
        while (rs.next()) {
            check = true;
            user.setLoginId(rs.getString(1));
            user.setFirstname(rs.getString(2));
            user.setLastName(rs.getString(3));
            user.setEmailId(rs.getString(4));
            user.setPhoneNumber(rs.getString(5));
            user.setPassword(rs.getString(6));
            user.setIdentityProof(rs.getString(7));
            user.setPhysicalDisability(rs.getString(8));
            user.setAddress(rs.getString(9));
            user.setDateOfBirth(rs.getString(10));
            user.setRole(rs.getString(11));
            
        
        }
  
        if (check == true) {
            return user;
        }
        else
            return null;
	}

	@Override
	public List<User> getUsers() throws SQLException {
		// TODO Auto-generated method stub
		String query = Constant.USER_GET_ALL_USERS;
		PreparedStatement ps = con.prepareStatement(query);
		ps.execute();
		
		ResultSet rs = ps.executeQuery();
		List<User> list = new ArrayList<>();
		
        while (rs.next()) {
        	User user = new User();
        	user.setLoginId(rs.getString(1));
            user.setFirstname(rs.getString(2));
            user.setLastName(rs.getString(3));
            user.setEmailId(rs.getString(4));
            user.setPhoneNumber(rs.getString(5));
            user.setPassword(rs.getString(6));
            user.setIdentityProof(rs.getString(7));
            user.setPhysicalDisability(rs.getString(8));
            user.setAddress(rs.getString(9));
            user.setDateOfBirth(rs.getString(10));
            user.setRole(rs.getString(11));
            list.add(user);
        }
		return list;
	}

	@Override
	public void updateUser(User user, String loginId) throws SQLException {
		// TODO Auto-generated method stub
		
		String query = Constant.USER_UPDATE;
		PreparedStatement ps  = con.prepareStatement(query);
		ps.setString(1, user.getLoginId());
		ps.setString(2, user.getFirstname());
		ps.setString(3, user.getLastName());
		ps.setString(4, user.getEmailId());
		ps.setString(5, user.getPhoneNumber());
		ps.setString(6, user.getPassword());
		ps.setString(7, user.getIdentityProof());
		ps.setString(8, user.getPhysicalDisability());
		ps.setString(9, user.getAddress());
		ps.setString(10, user.getDateOfBirth());
		ps.setString(11, user.getRole());
		ps.setString(12, loginId);
		ps.executeUpdate();
		
	}

}
