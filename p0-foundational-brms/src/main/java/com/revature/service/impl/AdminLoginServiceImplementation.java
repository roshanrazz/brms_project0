package com.revature.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.constant.Constant;
import com.revature.dao.impl.UserDaoImplementation;
import com.revature.menu.Menu;
import com.revature.model.User;
import com.revature.service.AdminLoginService;

public class AdminLoginServiceImplementation implements AdminLoginService{

	static Logger logger = Logger.getLogger(Menu.class.getName());
	Scanner scanner = new Scanner(System.in);
	@Override
	public boolean authenticateAdmin() throws SQLException {
		
		logger.info(Constant.WELCOME_MSG);
		logger.info(Constant.ADMIN_LOGIN);
		logger.info(Constant.ENTER_USERNAME);
		String username = scanner.nextLine();
		logger.info(Constant.ENTER_PASSWORD);
		String password = scanner.nextLine();
		
		String firstName;
		UserDaoImplementation userDaoImplementation = new UserDaoImplementation();
		List<User> list = userDaoImplementation.getUsers();
		for (User allUser : list) {
			if (username.equalsIgnoreCase(allUser.getLoginId()) && password.equals(allUser.getPassword())
					&& allUser.getRole().equalsIgnoreCase("admin")) {
				logger.info(Constant.SUCCESSFUL_LOGIN);
				firstName = allUser.getFirstname();
				logger.info(Constant.WELCOME + firstName + Constant.WELCOME_LAST_MSG);
				return true;
			}
		}
		logger.info(Constant.INVALID_USERNAME_PASSWORD);

		return false;
	}

}
