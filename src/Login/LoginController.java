/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import userprofile.model.UserList;

/**
 *
 * @author Michael Kramer
 */
public class LoginController {
    private UserList theListOfUsers = new UserList();
    
    /**
     * Creates a LoginController
     */
    public LoginController() {
        System.err.println("This is a stub.");
        //TODO: Implment LoginController
    }
    
    /**
     * Compares the provided Username and Password to UserList to authenticate
     * the provided User credentials.
     * @param username
     * @param password 
     */
    public void authenticateUserCredentials(String username, char[] password) {
        System.err.println("This is a stub.");
        //TODO: Implment authenticateUserCredentials
    }
}
