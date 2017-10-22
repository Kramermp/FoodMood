/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.controller;

import java.util.Arrays;
import userprofile.model.User;
import userprofile.model.UserList;
import userprofile.view.UserProfileUI;

/**
 *
 * @author Michael Kramer
 */
public class UserCntl {
	private UserList theUserList = new UserList();
	private UserProfileUI userProfileUI = new UserProfileUI(this);
	
	public UserCntl () {
		System.err.println("This is a stub.");
		userProfileUI.setVisible(true);
		userProfileUI.pack();
		//TODO: Implement UserCntl
	}
	
	public void submitUser() {
		System.out.println("UserCntl.submitUser()");
		boolean[] testResults = validateNewUserInput();
		boolean failedATest = false;
		for(int i = 0; i < testResults.length; i++) {
			//If it has not already failed a test and did not pass the test
			if(!failedATest && !testResults[i]) {
				failedATest = true;
			}
			switch (i) {
				case 0: // The Username is already Taken
					userProfileUI.displayUsernameTakenError(testResults[0]);
					break;
				case 1: //The Password does not meet the requirements
					userProfileUI. displayPasswordRequirementsError(testResults[1]);
					break;
				case 2: //The entered Passwords do not match
					userProfileUI.displayPasswordMatchError(testResults[2]);
					break;					
				default: 
					/*
						Some error was detected
						this shouldn't happen unless the number of test is
						expaned without expanding this switch
					*/
					break;
			}
						
		}
		userProfileUI.pack();
		//If it passed all the tests
		if(!failedATest) {
			theUserList.addUser(userProfileUI.getUsername(), 
					userProfileUI.getPassword());
			System.out.println("The user was added to the userlist.");
		} else {
			System.out.println("There were errors with the information entered"
				+	" the user was not added to the userList.");
		}
	}
	
	/**
	 * This method goes to the UserProfileUI and validates User input.
	 * 
	 * @return returns a boolean[] of test results
	 */
	public boolean[] validateNewUserInput() {
		//This method fetches the differe
		System.out.println("validateNewUserInput()");
		boolean[] testResults = new boolean[3];
		
		System.out.println("Checking Username");
		/*
			Checking username is simply verifying that there is not a user, in
			theUserList, with that username already.
		*/
		
		String username = userProfileUI.getUsername();
		System.out.println("Detected Username as: " + username);
		//If it does not have user name it passes
		testResults[0] = !theUserList.hasUser(username);
		if(theUserList.hasUser(username)) {
			System.out.println("There is already a user with that username.");
		} else {
			System.out.println("That username is free.");
		}
		
		System.out.println("Checking Password");
		/*
			Checking the passwor is a two parter, first checking that the two
			passwords that are entered match, and then validating that the
			entered password meet the password requirements.
		*/
		char[] password = this.userProfileUI.getPassword();
		char[] confirmPassword = this.userProfileUI.getConfirmPassword();
		
		//if it is valid password it passes
		if(User.isValidPassword(password)) {
			System.out.println("The password entered is a valid password.");
			testResults[1] = true;
		} else {
			System.out.println("The password entered is not a valid password.");
			testResults[1] = false;
		}
		
		//if the password match it passes
		if(Arrays.equals(password, confirmPassword)) {
			System.out.println("The two entered passwords match");
			testResults[2] = true;
		} else {
			System.out.println("The two entered passwords do not match");
			testResults[2] = false;
		}
		
		
		
		return testResults;
	}
	
	public void updateUser() {
		System.err.println("This is a stub.");
		//TODO: Implement updateUser
	}
	
	public void deleteUser() {
		System.err.println("This is a stub.");
		//TODO: Implement deleteUser
	}
}
