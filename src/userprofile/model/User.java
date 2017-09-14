/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.model;

/**
 *
 * @author Michael Kramer
 */
public class User {
	private String username;
	private String password;
	
	/**
	 * This constructor takes no arguments, and creates a User object with 
	 * default values.
	 */
	public User() {
		this.username = "No Username Provided";
		this.password = "";
	}
	
	/**
	 * Compares the provided username and password to the User's
	 * <p>
	 * @param username The Username to authenticate
	 * @param password The Password to authenticate
	 * @return The boolean result from authenticate, true is authenticated.
	 */
	public boolean authenticate(String username, String password) {
		return true;
	}
}
