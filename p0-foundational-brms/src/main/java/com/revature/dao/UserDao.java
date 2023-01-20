package com.revature.dao;

import java.sql.SQLException;
import java.util.List;
import com.revature.model.User;

public interface UserDao {
	
	public int addUser(User user) throws SQLException;
	  
	public void deleteUser(String loginId) throws SQLException;
	  
	public User getUser(String loginId) throws SQLException;
	  
	public List<User> getUsers() throws SQLException;
	  
	public void updateUser(User user,String loginId) throws SQLException;


}





