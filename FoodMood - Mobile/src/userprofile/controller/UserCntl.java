/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.controller;

import externaldata.controller.ExternalDataCntl;
import foodmood.controller.NavigationCntl;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import userprofile.model.User;
import userprofile.model.UserList;
import userprofile.view.ViewUserProfileUI;
import userprofile.view.NewUserUI;

/**
 *
 * @author Michael Kramer
 */
public class UserCntl {
    private UserList theUserList;
    private final ExternalDataCntl externalDataCntl = ExternalDataCntl.getExternalDataCntl();
    private JFrame userInterface;
    private ViewUserProfileUI userProfileUi;
    private NavigationCntl navigationCntl;
    private LoginCntl loginCntl;
    private User user;
    
    private NewUserUI newUserUi;

    
    public UserCntl(NavigationCntl navigationCntl) {
        //This is used for editing a user profile;
        this.navigationCntl = navigationCntl;
        this.userProfileUi = new ViewUserProfileUI(this);
        theUserList = externalDataCntl.getUserList();
        this.user = navigationCntl.getActiveUser();
        this.navigationCntl.getUserInterface().setContentPane(this.userProfileUi);
        
        this.navigationCntl.getUserInterface().revalidate();
        this.navigationCntl.getUserInterface().repaint();
        this.navigationCntl.getUserInterface().requestFocus();
       
    }
    
    public UserCntl (LoginCntl loginCntl) {
        theUserList = ExternalDataCntl.getExternalDataCntl().getUserList();
        this.loginCntl = loginCntl;
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
     * This method goes to the ViewUserProfileUI and validates User input.
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
    
    public void deleteUserProfile(String username, char[] password) {
        System.out.println("here");
        deleteUser(username, password);
        navigationCntl.logout();
    }
    
    public void deleteUser(String username, char[] password) {
        theUserList.deleteUser(username, password);
        externalDataCntl.deleteUser(username);
    }

    private void addUser(String username, char[] password){
        theUserList.addUser(username, password);
        externalDataCntl.addUser(username, password);
    } 

    public void updateUser(String oldUsername, String newUsername, 
            char[] newPassword){
        User userToUpdate = theUserList.getUser(oldUsername);
        userToUpdate.setUsername(newUsername);
        userToUpdate.setPassword(newPassword);
        externalDataCntl.updateUser(oldUsername, new User(newUsername, newPassword));
    }
    
    public User getActiveUser() {
        return this.navigationCntl.getActiveUser();
    }
    
    public void requestAccountDeletion(String username, char[] password) {
        if(theUserList.authenticateUserCredentials(username, password)) {
            deleteUserProfile(username, password);
        } else {
            this.userProfileUi.displayCurrentPasswordErr(true);
        }
    }
    
    public void requestAccountChanges(String oldUsername, String newUsername, 
            char[] currentPassword, char[] newPassword) {
        if(theUserList.authenticateUserCredentials(oldUsername, currentPassword)) {
            if(!theUserList.hasUser(newUsername) || oldUsername.equals(newUsername))
                if (User.isValidPassword(newPassword)) {
                    updateUser(oldUsername, newUsername, newPassword);
                    navigationCntl.goHomeScreen();
                } else {
                    System.out.println(String.valueOf(newPassword) + " detectedPass");
                    this.userProfileUi.displayPasswordTooWeakErr(true);
                }
                    
            else 
                this.userProfileUi.displayUsernameTakenErr(true);
        } else {
            this.userProfileUi.displayCurrentPasswordErr(true);
        }
    }
    
    public void goHomeScreen() {
        navigationCntl.goHomeScreen();
    }
    
}
