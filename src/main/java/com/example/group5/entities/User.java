package com.example.group5.entities;

/**
 * This is class for storing user details at the time of registration
 * @author Japnoor Kaur
 *
 */
public class User {
	private String bannerId;
	private String firstName;
	private String lastName;
	private String emailID;
	private String password;

	public User() {
		
	}
	/**
	 * This is a method for storing user details using getter and setters
	 * @param bannerId This is a string 
	 * @param firstName This is a string
	 * @param lastName This is a string
	 * @param emailID This is a string
	 * @param password This is a string
	 * @author Japnoor Kaur 
	 *
	 */
	public User(String bannerId, String firstName, String lastName, String emailID, String password) {
		super();
		this.bannerId = bannerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.password = password;
	}
	
	public String getBannerId() {
		return bannerId;
	}
	public void setBannerId(String bannerId) {
		this.bannerId = bannerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
