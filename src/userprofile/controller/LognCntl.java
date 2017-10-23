/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.controller;

import userprofile.view.LoginView;
import userprofile.model.UserList;

/**
 *
 * @author Michael Kramer
 */
public class LognCntl {
    private UserList theListOfUsers = new UserList();
    
    /**
     * Creates a LoginController
     */
    public LognCntl() {
        theListOfUsers = new UserList();
        new LoginView(this);
    }
    
    /**
     * Compares the provided Username and Password to UserList to authenticate
     * the provided User credentials.
     * @param username the Username
     * @param password the Password
     */
    public boolean authenticateUserCredentials(String username, char[] password) {
        return theListOfUsers.authenticateUserCredentials(username, password);
    }
    
    public void login(){
        foodmood.controller.NavigationCntl theNavigationCntl = new foodmood.controller.NavigationCntl();
    }
}
