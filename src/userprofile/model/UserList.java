/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.model;

import java.util.ArrayList;

/**
 *
 * @author Michael Kramer
 */
public class UserList {
    private ArrayList<User> theListOfUsers = new ArrayList<User>();
    
    /**
     * Default Constructor of the UserList, creates an empty UserList
     */
    public UserList() {
        
    }
    
    /**
     * Goes through the UserList validates the provided credentials
     * @param username The Username to validate
     * @param password The Password to validate
     * @return 
     */
    public boolean authenticateUserCredentials(String username, char[] password) {
        System.err.println("This is a stub.");
        //TODO: Implment authenticateUserCredentials
        return true;
    }
    
    /**
     * Adds a User to the UserList with the provided UserName and Password
     * @param username Username of the new User
     * @param password Password of the new User
     */
    public void addUser(String username, char[] password) {
        System.err.println("This is a stub.");
        //TODO: Implement addUser
    }
    
    /**
     * Removes a User from the UserList
     * @param username The Username of the User to remove
     * @param password The Password of the User to remove 
     */
    public void deleteUser(String username, char[] password) {
        System.err.println("This is a stub.");
        //TODO: Implement deleteUser
    }
    
    /**
     * Returns if a User is found with the provided Username
     * @param username The Username to check for
     * @return 
     */
    public boolean hasUser(String username) {
        System.err.println("This is a stub.");
        //TODO: Implement hasUser
        return false;
    }  
    
    /**
     * Gets the User with Username from the UserList
     * @param username The Username of the User to get
     * @return 
     */
    public User getUser(String username) {
        System.err.println("This is a stub.");
        //TODO: Implement getUser
        return new User();
    }
    
    /**
     * Returns the number of Users in the UserList
     * @return 
     */
    public int getUserCount() {
        System.err.println("This is a stub.");
        //TODO: implement getUserCount
        return 0;
    }
}
