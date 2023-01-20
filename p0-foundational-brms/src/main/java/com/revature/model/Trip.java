package com.revature.model;

public class Trip {

	String busRegistrationNumber;
	String boardingTime;
	String arrivalTime;
	int ticketCharge;
		
	public Trip() {
	}

	public Trip(String busRegistrationNumber, String boardingTime, String arrivalTime, int ticketCharge) {
		this.busRegistrationNumber = busRegistrationNumber;
		this.boardingTime = boardingTime;
		this.arrivalTime = arrivalTime;
		this.ticketCharge = ticketCharge;
	}

	public String getBusRegistrationNumber() {
		return busRegistrationNumber;
	}

	public void setBusRegistrationNumber(String busRegistrationNumber) {
		this.busRegistrationNumber = busRegistrationNumber;
	}

	public String getBoardingTime() {
		return boardingTime;
	}

	public void setBoardingTime(String boardingTime) {
		this.boardingTime = boardingTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getTicketCharge() {
		return ticketCharge;
	}

	public void setTicketCharge(int ticketCharge) {
		this.ticketCharge = ticketCharge;
	}

	@Override
	public String toString() {
		return "Trip [busRegistrationNumber=" + busRegistrationNumber + ", boardingTime=" + boardingTime
				+ ", arrivalTime=" + arrivalTime + ", ticketCharge=" + ticketCharge + "]";
	}
	
	
}
