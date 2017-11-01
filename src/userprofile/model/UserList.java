/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.model;

import java.util.ArrayList;
import java.util.Arrays;

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
    
    public UserList(ArrayList<User> users){
        theListOfUsers = users;
    }
    
    public static UserList createTestUserList() {
        UserList testUserList = new UserList();
        testUserList.theListOfUsers = new ArrayList<User>();
        testUserList.theListOfUsers.add(new User("TestUser", "pass".toCharArray()));
        return testUserList;
    }
    
    public int size(){
        return theListOfUsers.size();
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
            if(theListOfUsers.get(i).getUsername().equalsIgnoreCase(username)){
                authenticated = theListOfUsers.get(i).authenticate(username, password);
                break;
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
        System.out.println("DeleteUser called");
        for (int i = 0; i < theListOfUsers.size(); i++) {
            if(theListOfUsers.get(i).getUsername().equalsIgnoreCase(username)){
                System.out.println("There is a user with that name");
                if(Arrays.equals(password, theListOfUsers.get(i).getPassword())){
                    System.out.println("Found a Matching User to Delete.");
                    theListOfUsers.remove(i);
                } else {
                    System.out.println("Found: " + String.valueOf(theListOfUsers.get(i).getPassword()));
                    System.out.println("Looking for: " + String.valueOf(password));
                }
            } else {
//                System.out.println("Found: " + theListOfUsers.get(i).getUsername());
//                System.out.println("Looking for: " + username);
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
            if(theListOfUsers.get(i).getUsername().equalsIgnoreCase(username)){
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
            if(theListOfUsers.get(i).getUsername().equalsIgnoreCase(username)){
                return theListOfUsers.get(i);
            }
        }
        return null;
    }
    
    public void set(int i, User newUser){
        theListOfUsers.set(i, newUser);
    }
    
    public User get(int i){
        return theListOfUsers.get(i);
    }
    
    /**
     * Returns the number of Users in the UserList
     * @return the Count of Users
     */
    public int getUserCount() {
        return theListOfUsers.size();
    }
}
