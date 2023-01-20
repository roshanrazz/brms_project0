package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.config.DatabaseConnection;
import com.revature.constant.Constant;
import com.revature.dao.RouteDao;
import com.revature.model.Route;

public class RouteDaoImplementation implements RouteDao {
	
	static Connection con = DatabaseConnection.getConnection();

	@Override
	public int addRoute(Route route) throws SQLException {
		
		// TODO Auto-generated method stub
		
		String query = Constant.ROUTE_INSERT;
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, route.getRouteId());
		ps.setString(2, route.getBusRegistrationNumber());
		ps.setString(3, route.getSource());
		ps.setString(4, route.getDestination());
		int n = ps.executeUpdate();
		return n;
	}

	@Override
	public void deleteRoute(String rid) throws SQLException {
		// TODO Auto-generated method stub
		String query = Constant.ROUTE_DELETE;
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, rid);
		ps.executeUpdate();
		
	}

	@Override
	public Route getRoute(String rid) throws SQLException {
		// TODO Auto-generated method stub
		String query = Constant.ROUTE_GET_ONE_ROUTE;
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, rid);
		ps.execute();
		
		Route route = new Route();
		ResultSet rs = ps.executeQuery();
        boolean check = false;
        
        while (rs.next()) {
            check = true;
            route.setRouteId(rs.getString("Route_Id"));
            route.setBusRegistrationNumber(rs.getString("Bus_Registration_Number"));
            route.setSource(rs.getString("Source"));
            route.setDestination(rs.getString("Destination"));
        
        }
  
        if (check == true) {
            return route;
        }
        else
            return null;
	}

	@Override
	public List<Route> getRoutes() throws SQLException {
		// TODO Auto-generated method stub
		String query = Constant.ROUTE_GET_ALL_ROUTE;
		PreparedStatement ps = con.prepareStatement(query);
		ps.execute();
		
		ResultSet rs = ps.executeQuery();
		List<Route> ls = new ArrayList<>();
		
        while (rs.next()) {
        	Route route = new Route();
        	route.setRouteId(rs.getString("Route_Id"));
            route.setBusRegistrationNumber(rs.getString("Bus_Registration_Number"));
            route.setSource(rs.getString("Source"));
            route.setDestination(rs.getString("Destination"));
            ls.add(route);
        }
		return ls;
	}

	@Override
	public void updateRoute(Route route,String rid) throws SQLException {
		 
		
		String query = Constant.ROUTE_UPDATE_ROUTE;
		PreparedStatement ps  = con.prepareStatement(query);
		ps.setString(1, route.getRouteId());
		ps.setString(2, route.getBusRegistrationNumber());
		ps.setString(3, route.getSource());
		ps.setString(4, route.getDestination());
		ps.setString(5, rid);
		ps.executeUpdate();
		
	}
	
	

}
