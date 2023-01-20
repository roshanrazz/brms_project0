package com.revature.model;




public class Route {
	
	String routeId;
	String busRegistrationNumber;
	String source;
	String destination;
	
	
	
	public Route() {
	}



	public Route(String routeId, String busRegistrationNumber, String source, String destination) {
		this.routeId = routeId;
		this.busRegistrationNumber = busRegistrationNumber;
		this.source = source;
		this.destination = destination;
	}



	public String getRouteId() {
		return routeId;
	}



	public void setRouteId(String routeId) {
		this.routeId = routeId;
	}



	public String getBusRegistrationNumber() {
		return busRegistrationNumber;
	}



	public void setBusRegistrationNumber(String busRegistrationNumber) {
		this.busRegistrationNumber = busRegistrationNumber;
	}



	public String getSource() {
		return source;
	}



	public void setSource(String source) {
		this.source = source;
	}



	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", busRegistrationNumber=" + busRegistrationNumber + ", source=" + source
				+ ", destination=" + destination + "]";
	}
	

}
