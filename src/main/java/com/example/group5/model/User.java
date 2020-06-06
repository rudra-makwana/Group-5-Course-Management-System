package com.example.group5.model;

/**
 * This is class for storing user details at the time of registration
 * @author Japnoor Kaur
 *
 */
public class User {
	private String bannerID;
	private String firstName;
	private String lastName;
	private String emailID;
	private String password;

	public User() {

	}

	/**
	 * This is a method for storing user details using getter and setters
	 *
	 * @param bannerID  This is a string
	 * @param firstName This is a string
	 * @param lastName  This is a string
	 * @param emailID   This is a string
	 * @param password  This is a string
	 * @author Japnoor Kaur
	 */
	public User(String bannerID, String firstName, String lastName, String emailID, String password) {
		super();
		this.bannerID = bannerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
		this.password = password;
	}

	public String getBannerID() {
		return bannerID;
	}

	public void setBannerID(String bannerID) {
		this.bannerID = bannerID;
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