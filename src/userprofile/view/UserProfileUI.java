/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.view;

import javax.swing.JButton;
import userprofile.controller.UserCntl;
import userprofile.model.User;

/**
 *
 * @author Michael Kramer <mpk5206 @ psu.edu>
 */
public class UserProfileUI {
	private UserCntl parentController;
	private User sourceUser;
	private JButton submitButton;
	
	/**
	 * Creates a blank UserProfileUI
	 */
	public UserProfileUI() {
		System.err.println("This is a stub.");
		//TODO: Implement UserProfileUI
	}
	
	/**
	 * Creates a UserProfile UI with the SourceUser
	 * @param sourceUser 
	 */
	public UserProfileUI(UserCntl parentController, User sourceUser) {
		System.err.println("This is a stub.");
		//TODO: Implement UserProfileUI
	}
	
}
