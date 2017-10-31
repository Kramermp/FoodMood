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
import userprofile.view.LoginUI;
import userprofile.model.UserList;
import userprofile.model.User;
import userprofile.view.UserProfileUI;

/**
 *
 * @author Michael Kramer
 */
public class LoginCntl {
    private UserList theUserList;
    private LoginUI childUI;
    private UserCntl userCntl;
    private User user;
    private ExternalDataCntl externalDataCntl;
    /**
     * Creates a LoginController
     */
    public LoginCntl() {
        externalDataCntl = new ExternalDataCntl();
        theUserList = externalDataCntl.readLogins();
        this.childUI = new LoginUI(this);
        this.childUI.setVisible(true);
        this.childUI.requestFocus();
        
    }
    
    /**
     * Compares the provided Username and Password to UserList to authenticate
     * the provided User credentials.
     * @param username the Username
     * @param password the Password
     */
    public boolean authenticateUserCredentials(String username, char[] password) {
        return theUserList.authenticateUserCredentials(username, password);
    }
    
    public void submitUserCredentials(String username, char[] password) {
        if(authenticateUserCredentials(username, password)) {
            user = theUserList.getUser(username);
            login(user);
            childUI.setVisible(false);
        } else {
            loginInvalid();
        }
    }
    
    public void login(User user){
        foodmood.controller.NavigationCntl theNavigationCntl = new foodmood.controller.NavigationCntl(this, user);
        
    }
    
    public void loginInvalid() {
        System.out.println("Error Loging in with those credentials.");
        childUI.displayLoginFailure();
    }
    
    public void signup() {
        userCntl = new UserCntl(theUserList, new NavigationCntl(this));
        userCntl.registerNewUser();
    }
    
    /**
     * This method exits the program
     */
    public void exit() {
        System.exit(0);
    }
    
    
}
