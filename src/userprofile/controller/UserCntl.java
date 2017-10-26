/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import userprofile.model.User;
import userprofile.model.UserList;
import userprofile.view.UserProfileUI;

/**
 *
 * @author Michael Kramer
 */
public class UserCntl {
	private UserList theUserList;
	private UserProfileUI userProfileUI;
        
        Connection theConnection = null;
        Statement theStatement = null;
	
	public UserCntl (UserList theUserList) {
            this.theUserList = theUserList;
            System.out.println("Created a UserController.");
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
                        addUserToDB(userProfileUI.getUsername(), userProfileUI.getPassword());
                        
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
        
        public void registerNewUser() {
            userProfileUI = new UserProfileUI(this);
            userProfileUI.setVisible(true);
            userProfileUI.pack();
            
        }
        
        public void addUserToDB(String username, char[] password){
            createUserTable();
            System.out.println("adding user to db");
            try{
                Class.forName("org.sqlite.JDBC");
                theConnection = DriverManager.getConnection("jdbc:sqlite:foodmood.db");
                theStatement = theConnection.createStatement();
                System.out.println("successfully opened db");
                
                String passwordString = "";
                for (int i = 0; i < password.length; i++) {
                    passwordString += password[i];
                }

                String insert = "INSERT INTO login VALUES ('"+username+"', '"+passwordString+"');";
                theStatement.executeUpdate(insert);
                
                theStatement.close();
                theConnection.close(); 
                System.out.println("User added to db");

            }catch(Exception e){
                e.printStackTrace();
                System.exit(0);
            }
    }
        
        public void updateUser(String oldUsername, User newUser){
        System.out.println("updating user to db");
        try{
            Class.forName("org.sqlite.JDBC");
            theConnection = DriverManager.getConnection("jdbc:sqlite:foodmood.db");
            theStatement = theConnection.createStatement();
            System.out.println("successfully opened db");

            String newPasswordString = "";
            for (int i = 0; i < newUser.getPassword().length; i++) {
                newPasswordString += newUser.getPassword()[i];
            }

            String update = "UPDATE login SET username = '"+newUser.getUsername()+"', password = '"+newPasswordString+"' WHERE username = '"+oldUsername+"';";
            theStatement.executeUpdate(update);

            theStatement.close();
            theConnection.close(); 
            System.out.println("User added to db");

        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }

            public void createUserTable(){
        System.out.println("creating user table \n");
        try{
            Class.forName("org.sqlite.JDBC");
            theConnection = DriverManager.getConnection("jdbc:sqlite:foodmood.db");
            theStatement = theConnection.createStatement();
            
            String create = "CREATE TABLE IF NOT EXISTS login (username varchar, password varchar);";
            theStatement.executeUpdate(create);
            
            String insert = "INSERT INTO login VALUES ('user1', 'passworD');";
                theStatement.executeUpdate(insert);
            
            theStatement.close();
            theConnection.close(); 
        } catch(Exception e){
                e.printStackTrace();
                System.exit(0);
        }
    }
        
}
