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
     * @return the boolean if it is authenticated
     */
    public boolean authenticateUserCredentials(String username, char[] password) {
        boolean authenticated = false;
        for (int i = 0; i < theListOfUsers.size(); i++) {
            if(theListOfUsers.get(i).getUsername().equals(username)){
                if(java.util.Arrays.equals(password, theListOfUsers.get(i).getPassword())){
                    authenticated = true;
                    break;
                }
            }
        }
        return authenticated;
    }
    
    /**
     * Adds a User to the UserList with the provided UserName and Password
     * @param username Username of the new User
     * @param password Password of the new User
     */
    public void addUser(String username, char[] password) {
        User newUser = new User(username, password);
        theListOfUsers.add(newUser);
    }
    
    /**
     * Removes a User from the UserList
     * @param username The Username of the User to remove
     * @param password The Password of the User to remove 
     */
    public void deleteUser(String username, char[] password) {
        for (int i = 0; i < theListOfUsers.size(); i++) {
            if(theListOfUsers.get(i).getUsername().equals(username)){
                if(java.util.Arrays.equals(password, theListOfUsers.get(i).getPassword())){
                    theListOfUsers.remove(i);
                }
            }
        }
        
    }
    
    /**
     * Returns if a User is found with the provided Username
     * @param username The Username to check for
     * @return the boolean of if it has user
     */
    public boolean hasUser(String username) {
        boolean found = false;
        for (int i = 0; i < theListOfUsers.size(); i++) {
            if(theListOfUsers.get(i).getUsername().equals(username)){
                found = true;
                break;
            }
        }
        return found;
    }  
    
    /**
     * Gets the User with Username from the UserList
     * @param username The Username of the User to get
     * @return the User
     */
    public User getUser(String username) {
        for (int i = 0; i < theListOfUsers.size(); i++) {
            if(theListOfUsers.get(i).getUsername().equals(username)){
                return theListOfUsers.get(i);
            }
        }
        return null;
    }
    
    /**
     * Returns the number of Users in the UserList
     * @return the Count of Users
     */
    public int getUserCount() {
        return theListOfUsers.size();
    }
}
