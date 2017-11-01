/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.controller;

import foodmood.ExternalDataCntl;
import foodmood.controller.NavigationCntl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import userprofile.model.User;
import userprofile.model.UserList;
import userprofile.view.ViewUserUI;
import userprofile.view.NewUserUI;

/**
 *
 * @author Michael Kramer
 */
public class UserCntl {
    private UserList theUserList;
    private ViewUserUI userProfileUI;
    private NavigationCntl navigationCntl;
    private ExternalDataCntl externalDataCntl;
    private LoginCntl loginCntl;
    private User user;
    
    private NewUserUI newUserUi;
    
    public UserCntl (UserList theUserList, NavigationCntl navigationCntl) {
        this.externalDataCntl = new ExternalDataCntl();
        this.theUserList = theUserList;
        this.navigationCntl = navigationCntl;
        this.user = navigationCntl.getActiveUser();
    }
    
    public UserCntl (UserList theUserList, LoginCntl loginCntl) {
        this.theUserList = theUserList;
        this.loginCntl = loginCntl;
        this.externalDataCntl = new ExternalDataCntl();
    }
    
    public void setNewUserUi(NewUserUI newUserUi) {
        this.newUserUi = newUserUi;
    }
    
    public void submitNewUserCredentials(String username, char[] password) {
        boolean[] testResults = validateNewUserInput(username, password);
        boolean failedATest = false;
        for(int i = 0; i < testResults.length; i++) {
            if(!testResults[i]) 
                failedATest = true;
            switch (i) {
                case 0: 
                    newUserUi.usernameIsAvailable(testResults[i]);
                    break;
                case 1:
                    newUserUi.passwordIsStrongEnough(testResults[i]);
                    break;
                default:
                    // Just here to include the default it should not happen
                    // unless you expand the number of test results when submitting
                    // user credentials without expanding this switch.
                    System.err.println("Switch Case Should Not Enter Default");
                    break;   
            }
        }
        
        if(!failedATest) {
            addUser(username, password);
            newUserUi.closeWindow();
        }
        
    }
    
    /**
     * This method goes to the ViewUserUI and validates User input.
     * 
     * @return returns a boolean[] of test results
     */
    public boolean[] validateNewUserInput(String username, char[] password) {
        //This method fetches the differe
        System.out.println("validateNewUserInput()");
        boolean[] testResults = new boolean[2];
        
        System.out.println("Checking Username");
        /*
            Checking username is simply verifying that there is not a user, in
            theUserList, with that username already.
        */
        
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
        
        //if it is valid password it passes
        if(User.isValidPassword(password)) {
            System.out.println("The password entered is a valid password.");
            testResults[1] = true;
        } else {
            System.out.println("The password entered is not a valid password.");
            testResults[1] = false;
        }
        
        return testResults;
    }
    
    public void deleteUser(String username, char[] password) {
        theUserList.deleteUser(username, password);
        externalDataCntl.deleteUser(username);
    }

    private void addUser(String username, char[] password){
        theUserList.addUser(username, password);
        externalDataCntl.addUser(username, password);
    } 

    public void updateUser(String oldUsername, User newUser){
        for (int i = 0; i < theUserList.size(); i++) {
            if(theUserList.get(i).getUsername().equals(oldUsername)){
                theUserList.set(i, newUser);
            }
        }
        externalDataCntl.updateUser(oldUsername, newUser);
    }
    
}
