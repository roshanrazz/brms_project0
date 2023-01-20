package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Trip;

public interface TripDao {
	
	public int addTrip(Trip trip) throws SQLException;
	  
	public void deleteTrip(String busRid) throws SQLException;
	  
	public Trip getTrip(String busRid) throws SQLException;
	  
	public List<Trip> getTrips() throws SQLException;
	  
	public void updateTrip(Trip trip,String busRid) throws SQLException;

}
