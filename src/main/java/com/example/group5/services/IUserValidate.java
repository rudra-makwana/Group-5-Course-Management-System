package com.example.group5.services;

/**
 * This is an interface for user input validation for registration
 * @author Japnoor Kaur
 *
 */
public interface IUserValidate {

	  public boolean validateEmail(String str);
	  public boolean validateBannerId(String str);
	  public boolean validateFirstName(String str);
	  public boolean validateLastName(String str);
	  public boolean validatePassword(String str);
	  
}
