package com.revature.model;

public class User {
	
	String loginId;
	String firstname;
	String lastName;
	String emailId;
	String phoneNumber;
	String password;
	String identityProof;
	String physicalDisability;
	String address;
	String dateOfBirth;
	String role;
	
	
	
	public User() {
	}



	public User(String loginId, String firstname, String lastName, String emailId, String phoneNumber, String password,
			String identityProof, String physicalDisability, String address, String dateOfBirth, String role) {
		super();
		this.loginId = loginId;
		this.firstname = firstname;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.identityProof = identityProof;
		this.physicalDisability = physicalDisability;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.role = role;
	}



	public String getLoginId() {
		return loginId;
	}



	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getIdentityProof() {
		return identityProof;
	}



	public void setIdentityProof(String identityProof) {
		this.identityProof = identityProof;
	}



	public String getPhysicalDisability() {
		return physicalDisability;
	}



	public void setPhysicalDisability(String physicalDisability) {
		this.physicalDisability = physicalDisability;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "User [loginId=" + loginId + ", firstname=" + firstname + ", lastName=" + lastName + ", emailId="
				+ emailId + ", phoneNumber=" + phoneNumber + ", password=" + password + ", identityProof="
				+ identityProof + ", physicalDisability=" + physicalDisability + ", address=" + address
				+ ", dateOfBirth=" + dateOfBirth + ", role=" + role + "]";
	}
	
	
}
