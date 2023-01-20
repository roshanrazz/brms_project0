package com.revature.app;

import java.sql.SQLException;
import com.revature.menu.Menu;
import com.revature.service.impl.AdminLoginServiceImplementation;

public class App {
	
	public static void main(String[] args) throws SQLException {
		AdminLoginServiceImplementation adminLogin = new AdminLoginServiceImplementation();
		boolean loggedInSuccessful = adminLogin.authenticateAdmin();
		if (loggedInSuccessful) {
		new Menu().mainMenu();
		}
	}
}