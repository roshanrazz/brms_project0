package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.config.DatabaseConnection;
import com.revature.constant.Constant;
import com.revature.dao.TripDao;
import com.revature.model.Trip;

public class TripDaoImplementation implements TripDao{
	
	static Connection con = DatabaseConnection.getConnection();

	@Override
	public int addTrip(Trip trip) throws SQLException {
		// TODO Auto-generated method stub
		
		String query = Constant.TRIP_INSERT;
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, trip.getBusRegistrationNumber());
		ps.setString(2, trip.getBoardingTime());
		ps.setString(3, trip.getArrivalTime());
		ps.setInt(4, trip.getTicketCharge());
		int n = ps.executeUpdate();
		return n;
	}

	@Override
	public void deleteTrip(String busRid) throws SQLException {
		String query = Constant.TRIP_DELETE;
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, busRid);
		ps.executeUpdate();
		
	}

	@Override
	public Trip getTrip(String busRid) throws SQLException {
		String query = Constant.TRIP_GET_ONE_TRIP;
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1, busRid);
		ps.execute();
		
		Trip trip = new Trip();
		ResultSet rs = ps.executeQuery();
        boolean check = false;
        
        while (rs.next()) {
            check = true;
            trip.setBusRegistrationNumber(rs.getString(1));
            trip.setBoardingTime(rs.getString(2));
            trip.setArrivalTime(rs.getString(3));
            trip.setTicketCharge(rs.getInt(4));
        
        }
  
        if (check == true) {
            return trip;
        }
        else
            return null;
	}

	@Override
	public List<Trip> getTrips() throws SQLException {
		String query = Constant.TRIP_GET_ALL_TRIP;
		PreparedStatement ps = con.prepareStatement(query);
		ps.execute();
		
		ResultSet rs = ps.executeQuery();
		List<Trip> list = new ArrayList<>();
		
        while (rs.next()) {
        	Trip trip = new Trip();
        	trip.setBusRegistrationNumber(rs.getString(1));
        	trip.setBoardingTime(rs.getString(2));
        	trip.setArrivalTime(rs.getString(3));
        	trip.setTicketCharge(rs.getInt(4));
            list.add(trip);
        }
		return list;
	}

	@Override
	public void updateTrip(Trip trip, String busRid) throws SQLException {
		String query = Constant.TRIP_UPDATE;
		PreparedStatement ps  = con.prepareStatement(query);
		ps.setString(1, trip.getBusRegistrationNumber());
		ps.setString(2, trip.getBoardingTime());
		ps.setString(3, trip.getArrivalTime());
		ps.setInt(4, trip.getTicketCharge());
		ps.setString(5, busRid);
		ps.executeUpdate();
		
	}

}
