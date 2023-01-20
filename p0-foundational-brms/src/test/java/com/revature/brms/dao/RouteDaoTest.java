package com.revature.brms.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;

import org.junit.Test;

import com.revature.dao.RouteDao;
import com.revature.dao.impl.RouteDaoImplementation;
import com.revature.model.Route;

public class RouteDaoTest {
	@Test
	public void testAddRoute() throws SQLException {
		
		Route route = new Route();
		
		route.setRouteId("R008");
		route.setBusRegistrationNumber("DC-99");
		route.setSource("Delhi");
		route.setDestination("Shridi");
		
		RouteDao routeDao = new RouteDaoImplementation();
		routeDao.addRoute(route);	
		assertEquals(routeDao.getRoute("R008").getBusRegistrationNumber(), "DC-99");		
		
	  }
	
	@Test
	public void testDeleteRoute() throws SQLException {
		RouteDao routeDao = new RouteDaoImplementation();
		assertNotNull(routeDao.getRoute("R008"));
		routeDao.deleteRoute("R008");
		assertNull(routeDao.getRoute("R008"));
	}
	
	@Test
	public void testGetRoute() throws SQLException {
		RouteDao routeDao = new RouteDaoImplementation();
		String busRid = routeDao.getRoute("R007").getBusRegistrationNumber();	
		assertEquals(busRid, "DC-99");
	}
	
	
	

}
