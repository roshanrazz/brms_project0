package com.revature.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.constant.Constant;
import com.revature.dao.impl.RouteDaoImplementation;
import com.revature.dao.impl.TripDaoImplementation;
import com.revature.model.Route;
import com.revature.model.Trip;

public class Menu {

	static Logger logger = Logger.getLogger(Menu.class.getName());
	Scanner scanner = new Scanner(System.in);

	public void mainMenu() throws SQLException {

		do {
			logger.info(Constant.ADMIN_PANEL_WELCOME_MSG);
			logger.info(Constant.CHOICE_ROUTE_TRIP);

			logger.info(Constant.ENTER_CHOICE);

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				routeManagement();
				logger.info(Constant.CONTINUE_MSG);
				break;
			case 2:
				tripManagement();
				logger.info(Constant.CONTINUE_MSG);
				break;
			case 3:
				logger.info(Constant.EXITING_MSG);
				System.exit(0);
				break;
			default:
				logger.info(Constant.INVALID_CHOICE_MSG);
				logger.info(Constant.CONTINUE_MSG);

			}
		} while ((scanner.nextLine()).equalsIgnoreCase("y"));

	}

	private void routeManagement() throws SQLException {
		logger.info(Constant.ROUTE_CHOICES);

		logger.info(Constant.ENTER_CHOICE);

		int choice = Integer.parseInt(scanner.nextLine());

		switch (choice) {
		case 1:
			addRouteToDatabase();
			break;
		case 2:
			deleteRouteFromDatabase();
			break;
		case 3:
			updateRouteToDatabase();
			break;
		case 4:
			getParticularRouteFromDatabase();
			break;
		case 5:
			getAllRoutesFromDatabase();
			break;
		case 6:
			logger.info(Constant.EXITING_MSG);
			System.exit(0);
			break;
		default:
			logger.info(Constant.INVALID_CHOICE_MSG);
			System.exit(0);
		}

	}

	private void getAllRoutesFromDatabase() throws SQLException {
		// TODO Auto-generated method stub
		RouteDaoImplementation routeDaoImplementation = new RouteDaoImplementation();
		List<Route> list = routeDaoImplementation.getRoutes();
		if (list.isEmpty()) {
			logger.info(Constant.NO_ROUTES_FOUND);
		}
		logger.info(Constant.ROUTE_TABLE);
		for (Route allRoutes : list) {
			logger.info(allRoutes.getRouteId() + "		" + allRoutes.getBusRegistrationNumber() + "		"
					+ allRoutes.getSource() + "		" + allRoutes.getDestination());
		}

	}

	private void getParticularRouteFromDatabase() throws SQLException {
		// TODO Auto-generated method stub
		RouteDaoImplementation routeDaoImplementation = new RouteDaoImplementation();
		List<Route> list = routeDaoImplementation.getRoutes();
		if (list.isEmpty()) {
			logger.info(Constant.NO_ROUTES_FOUND);
		} else {
			boolean flag = false;
			logger.info(Constant.ROUTE_ID);
			String routeId = scanner.nextLine();
			for (Route allRoutes : list) {
				if (allRoutes.getRouteId().equalsIgnoreCase(routeId)) {
					Route route2 = routeDaoImplementation.getRoute(routeId);
					logger.info(Constant.ROUTE_TABLE);
					logger.info(route2.getRouteId() + "		" + route2.getBusRegistrationNumber() + "		" + route2.getSource()
							+ "		" + route2.getDestination());
					flag = true;
				}
			}
			if (!flag) {
				logger.info(Constant.INVALID_ROUTE_ID);
			}
		}

	}

	private void updateRouteToDatabase() throws SQLException {
		// TODO Auto-generated method stub
		RouteDaoImplementation routeDaoImplementation = new RouteDaoImplementation();
		List<Route> list = routeDaoImplementation.getRoutes();
		if (list.isEmpty()) {
			logger.info(Constant.NO_ROUTES_FOUND);
		} else {
			boolean updated = false;
			logger.info(Constant.ENTER_ROUTE_ID_TO_UPDATE);
			String routeId = scanner.nextLine();
			for (Route allRoute : list) {
				if (allRoute.getRouteId().equalsIgnoreCase(routeId)) {
					Route tempRoute = routeDaoImplementation.getRoute(routeId);

					logger.info(Constant.ENTER_CHOICE);

					logger.info(Constant.UPDATE_ATTRIBUTES_ROUTE);
					int choice = Integer.parseInt(scanner.nextLine());
					switch (choice) {
					case 1:
						logger.info(Constant.ENETR_NEW_ROUTE_ID);
						String newRouteId = scanner.nextLine();
						tempRoute.setRouteId(newRouteId);
						routeDaoImplementation.updateRoute(tempRoute, routeId);
						logger.info(Constant.ONE_ROW_UPDATED);
						break;
					case 2:
						logger.info(Constant.NEW_BUS_RID);
						String newBusRid = scanner.nextLine();
						tempRoute.setBusRegistrationNumber(newBusRid);
						routeDaoImplementation.updateRoute(tempRoute, routeId);
						logger.info(Constant.ONE_ROW_UPDATED);
						break;
					case 3:
						logger.info(Constant.NEW_SOURCE);
						String newSource = scanner.nextLine();
						tempRoute.setSource(newSource);
						routeDaoImplementation.updateRoute(tempRoute, routeId);
						logger.info(Constant.ONE_ROW_UPDATED);
						break;
					case 4:
						logger.info(Constant.NEW_DESTINATION);
						String newDestination = scanner.nextLine();
						tempRoute.setDestination(newDestination);
						routeDaoImplementation.updateRoute(tempRoute, routeId);
						logger.info(Constant.ONE_ROW_UPDATED);
						break;
					default:
						logger.info(Constant.INVALID_CHOICE_MSG);
						break;
					}

					updated = true;
				}
			}
			if (!updated) {
				logger.info(Constant.INVALID_ROUTE_ID);
			}
		}

	}

	private void deleteRouteFromDatabase() throws SQLException {
		// TODO Auto-generated method stub
		RouteDaoImplementation routeDaoImplementation = new RouteDaoImplementation();
		List<Route> list = routeDaoImplementation.getRoutes();
		if (list.isEmpty()) {
			logger.info(Constant.NO_ROUTES_FOUND);
		} else {
			boolean deleted = false;
			logger.info(Constant.ENTER_ROUTE_ID);
			String routeId = scanner.nextLine();
			for (Route allRoute : list) {
				if (allRoute.getRouteId().equalsIgnoreCase(routeId)) {
					routeDaoImplementation.deleteRoute(routeId);
					logger.info(Constant.ONE_ROW_DELETED);
					deleted = true;
				}
			}
			if (!deleted) {
				logger.info(Constant.INVALID_ROUTE_ID);
			}

		}
	}

	private void addRouteToDatabase() throws SQLException {

		Route route = new Route();

		logger.info(Constant.ENTER_NEW_ROUTE);
		String routeId = scanner.nextLine();
		logger.info(Constant.ENTER_BUS_RID);
		String busRid = scanner.nextLine();
		logger.info(Constant.ENTER_SOURCE);
		String source = scanner.nextLine();
		logger.info(Constant.ENTER_DESTINATION);
		String destination = scanner.nextLine();

		route.setRouteId(routeId);
		route.setBusRegistrationNumber(busRid);
		route.setSource(source);
		route.setDestination(destination);

		RouteDaoImplementation routeDaoImplementation = new RouteDaoImplementation();
		routeDaoImplementation.addRoute(route);

		logger.info(Constant.ONE_ROW_INSERTED);

	}

	private void tripManagement() throws SQLException {

		logger.info(Constant.TRIP_CHOICES);

		logger.info(Constant.ENTER_CHOICE);

		int choice = Integer.parseInt(scanner.nextLine());

		switch (choice) {
		case 1:
			addTripToDatabase();
			break;
		case 2:
			deleteTripFromDatabase();
			break;
		case 3:
			updateTripToDatabase();
			break;
		case 4:
			getParticularTripFromDatabase();
			break;
		case 5:
			getAllTripsFromDatabase();
			break;
		case 6:
			logger.info(Constant.EXITING_MSG);
			System.exit(0);
			break;
		default:
			logger.info(Constant.INVALID_CHOICE_MSG);
			System.exit(0);
		}

	}

	private void getAllTripsFromDatabase() throws SQLException {
		// TODO Auto-generated method stub
		TripDaoImplementation tripDaoImplementation = new TripDaoImplementation();
		List<Trip> list = tripDaoImplementation.getTrips();
		if (list.isEmpty()) {
			logger.info(Constant.NO_TRIPS_FOUND);
		}
		logger.info(Constant.TRIP_TABLE);
		for (Trip allTrips : list) {
			logger.info(allTrips.getBusRegistrationNumber() + "	 " + allTrips.getBoardingTime() + "	"
					+ allTrips.getArrivalTime() + "	" + allTrips.getTicketCharge());
		}

	}

	private void getParticularTripFromDatabase() throws SQLException {
		// TODO Auto-generated method stub
		TripDaoImplementation tripDaoImplementation = new TripDaoImplementation();
		List<Trip> list = tripDaoImplementation.getTrips();
		if (list.isEmpty()) {
			logger.info(Constant.NO_TRIPS_FOUND);
		} else {
			boolean flag = false;
			logger.info(Constant.ENTER_BUS_RID);
			String busRid = scanner.nextLine();
			for (Trip allTrips : list) {
				if (allTrips.getBusRegistrationNumber().equalsIgnoreCase(busRid)) {
					Trip trip = tripDaoImplementation.getTrip(busRid);
					logger.info(Constant.TRIP_TABLE);
					logger.info(trip.getBusRegistrationNumber() + "	 " + trip.getBoardingTime() + "	"
							+ trip.getArrivalTime() + "	" + trip.getTicketCharge());

					flag = true;
				}
			}
			if (!flag) {
				logger.info(Constant.INVALID_BUS_RID);
			}
		}

	}

	private void updateTripToDatabase() throws SQLException {
		// TODO Auto-generated method stub
		TripDaoImplementation tripDaoImplementation = new TripDaoImplementation();
		List<Trip> list = tripDaoImplementation.getTrips();
		if (list.isEmpty()) {
			logger.info(Constant.NO_TRIPS_FOUND);
		} else {
			logger.info(Constant.BUS_RID_TO_BE_UPDATED);
			String busRid = scanner.nextLine();
			boolean updated = false;
			for (Trip allTrips : list) {
				if (allTrips.getBusRegistrationNumber().equalsIgnoreCase(busRid)) {
					Trip tempTrip = tripDaoImplementation.getTrip(busRid);

					logger.info(Constant.ENTER_CHOICE);

					logger.info(Constant.UPDATE_ATTRIBUTES_CHOICES);
					int choice = Integer.parseInt(scanner.nextLine());
					switch (choice) {
					case 1:
						logger.info(Constant.NEW_BUS_RID);
						String newBusRid = scanner.nextLine();
						tempTrip.setBusRegistrationNumber(newBusRid);
						tripDaoImplementation.updateTrip(tempTrip, busRid);
						logger.info(Constant.ONE_ROW_UPDATED);
						break;
					case 2:
						logger.info(Constant.NEW_BOARDING_TIME);
						String newBoardingTime = scanner.nextLine();
						tempTrip.setBoardingTime(newBoardingTime);
						tripDaoImplementation.updateTrip(tempTrip, busRid);
						logger.info(Constant.ONE_ROW_UPDATED);
						break;
					case 3:
						logger.info(Constant.NEW_ARRIVAL_TIME);
						String newArrivalTime = scanner.nextLine();
						tempTrip.setArrivalTime(newArrivalTime);
						tripDaoImplementation.updateTrip(tempTrip, busRid);
						logger.info(Constant.ONE_ROW_UPDATED);
						break;
					case 4:
						logger.info(Constant.NEW_TICKET_CHARGE);
						int newTicketCharge = Integer.parseInt(scanner.nextLine());
						tempTrip.setTicketCharge(newTicketCharge);
						tripDaoImplementation.updateTrip(tempTrip, busRid);
						logger.info(Constant.ONE_ROW_UPDATED);
						break;
					default:
						logger.info(Constant.INVALID_CHOICE_MSG);
						break;
					}

					updated = true;
				}
			}
			if (!updated) {
				logger.info(Constant.INVALID_BUS_RID);
			}

		}
	}

	private void deleteTripFromDatabase() throws SQLException {
		// TODO Auto-generated method stub
		TripDaoImplementation tripDaoImplementation = new TripDaoImplementation();
		List<Trip> list = tripDaoImplementation.getTrips();
		if (list.isEmpty()) {
			logger.info(Constant.NO_TRIPS_FOUND);
		} else {
			boolean deleted = false;
			logger.info(Constant.BUS_RID_TO_BE_DELETED);
			String busRid = scanner.nextLine();
			for (Trip allTrips : list) {
//          logger.info(allRoutes); // for all routes toString
				if (allTrips.getBusRegistrationNumber().equalsIgnoreCase(busRid)) {
					tripDaoImplementation.deleteTrip(busRid);
					logger.info(Constant.ONE_ROW_DELETED);
					deleted = true;
				}
			}
			if (!deleted) {
				logger.info(Constant.INVALID_BUS_RID);
			}
		}

	}

	private void addTripToDatabase() throws SQLException {
		// TODO Auto-generated method stub
		Trip trip = new Trip();

		logger.info(Constant.ENTER_BUS_RID);
		String busRid = scanner.nextLine();
		logger.info(Constant.BOARDING_TIME);
		String boardingTime = scanner.nextLine();
		logger.info(Constant.ARRIVAL_TIME);
		String arrivalTime = scanner.nextLine();
		logger.info(Constant.TICKET_CHARGE);
		int ticketCharge = Integer.parseInt(scanner.nextLine());

		trip.setBusRegistrationNumber(busRid);
		trip.setBoardingTime(boardingTime);
		trip.setArrivalTime(arrivalTime);
		trip.setTicketCharge(ticketCharge);

		TripDaoImplementation tripDaoImplementation = new TripDaoImplementation();
		tripDaoImplementation.addTrip(trip);

		logger.info(Constant.ONE_ROW_INSERTED);

	}

}
