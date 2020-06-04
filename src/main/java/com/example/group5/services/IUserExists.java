package com.example.group5.services;

/**
 * This is an interface for checking whether user already exists in database
 * @author Japnoor Kaur
 *
 */
public interface IUserExists {
	  public boolean bannerIdExists(String str);
	  public boolean userExists(String str);
}
