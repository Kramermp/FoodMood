/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.controller;

import userprofile.view.LoginUI;
import userprofile.model.UserList;
import userprofile.view.UserProfileUI;

/**
 *
 * @author Michael Kramer
 */
public class LoginCntl {
    private UserList theUserList = new UserList();
    private LoginUI childUI;
    private UserCntl userCntl;
    
    /**
     * Creates a LoginController
     */
    public LoginCntl() {
        this.theUserList = new UserList();
        this.childUI = new LoginUI(this);
        this.childUI.setVisible(true);
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
            login();
        } else {
            loginInvalid();
        }
    }
    
    public void login(){
        foodmood.controller.NavigationCntl theNavigationCntl = new foodmood.controller.NavigationCntl();
        
    }
    
    public void loginInvalid() {
        System.out.println("Error Loging in with those credentials.");
    }
    
    public void signup() {
        userCntl = new UserCntl(theUserList);
        userCntl.registerNewUser();
    }
    
    /**
     * This method exits the program
     */
    public void exit() {
        System.exit(0);
    }
}
