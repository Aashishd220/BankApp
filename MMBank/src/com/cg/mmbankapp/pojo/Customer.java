package com.cg.mmbankapp.pojo;

import java.time.LocalDate;

public class Customer {
	private final int customerId;
	private String customerName;
	private long contactNumber;
	private String emailId;
	private LocalDate dateOfBirth;
	private String Address;
	private String nationality;
	private String gender;
	private static int custId;

	static {
		custId = 200;
	}

	{
		this.customerId = ++custId;
	}
	public Customer(String customerName, String emailId, long contactNumber, LocalDate dateOfBirth,
			String permanentAddress, String gender) {
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.gender = gender;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getCustomerId() {
		return customerId;
	}
	
}
