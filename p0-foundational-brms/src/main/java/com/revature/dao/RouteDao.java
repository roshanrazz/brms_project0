package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Route;

public interface RouteDao {
	
	  public int addRoute(Route route) throws SQLException;
	  
	  public void deleteRoute(String rid) throws SQLException;
	  
	  public Route getRoute(String rid) throws SQLException;
	  
	  public List<Route> getRoutes() throws SQLException;
	  
	  public void updateRoute(Route route,String rid) throws SQLException;

}
