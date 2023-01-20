package com.revature.brms.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import com.revature.dao.TripDao;
import com.revature.dao.impl.TripDaoImplementation;
import com.revature.model.Trip;

public class TripDaoTest {

	@Test
	public void testAddTrip() throws SQLException {
		
		Trip trip = new Trip();
		trip.setBusRegistrationNumber("SC-99");
		trip.setBoardingTime("3:00");
		trip.setArrivalTime("10:50");
		trip.setTicketCharge(450);
		
		TripDao tripDao = new TripDaoImplementation();
		tripDao.addTrip(trip);	
		assertEquals(tripDao.getTrip("SC-99").getBusRegistrationNumber(), "SC-99");		
		
	  }
	
	@Test
	public void testGetTrip() throws SQLException {
		TripDao tripDao = new TripDaoImplementation();
		String busRid = tripDao.getTrip("DC-99").getBusRegistrationNumber();	
		assertEquals(busRid, "DC-99");
	}
	
}
