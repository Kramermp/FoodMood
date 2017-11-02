/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.model;

import notificationprofile.model.Notification;
import foodprofile.model.FoodList;
import java.io.Serializable;
import java.util.Arrays;
import moodprofile.model.MoodList;
import notificationprofile.model.NotificationList;

/**
 *
 * @author Michael Kramer
 */
public class User implements Serializable {
    private String username;
    private char[] password;
    private FoodList usersFoodList = new FoodList();
    private MoodList usersMoodList = new MoodList();
    private NotificationList usersNotificationList = new NotificationList();

    /**
     * This constructor takes no arguments, and creates a User object with 
     * default values.
     */
    public User() {
        this.username = "No Username Provided";
    }

    /**
     * This constructor takes a String and Char[] to creates a User object
     * @param username The username of the User
     * @param password The password of the User
     */
    public User(String username, char[] password) {
        this.username = username;
        this.password = password;
        this.usersNotificationList = new NotificationList();
    }
    
    /**
     * Compares the provided username and password to the User's
     * @param username The Username to authenticate
     * @param password The Password to authenticate
     * @return The boolean result from authenticate, true is authenticated.
     */
    public boolean authenticate(String username, char[] password) {
        if(username.equalsIgnoreCase(this.username) && java.util.Arrays.equals(password, this.password)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Gets the Username of the User object
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the Username of the User object
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the Password of the User Object
     * @return the password
     */
    public char[] getPassword() {
        return password;
    }

    /**
     * Sets the Password of the User object
     * @param password the password to set
     */
    public void setPassword(char[] password) {
        this.password = password;
    }
    
    /**
    *Sets the notificationList for the User
    *@param notifications the list to set
    */
    public void setNotificationList(NotificationList notifications){
        this.usersNotificationList = notifications;
    }
    
    /**
    *Gets notificationList for the User
    *@return NotificationList 
    */
    public NotificationList getNotificationList(){
        return usersNotificationList;
    }
    
    /**
    *Adds a notification to the notificationList
    *@param notification the notification to add
    */
    public void addNotification(Notification notification){
	usersNotificationList.addNotification(notification);
    }
    
    /**
    *Deletes notification
    *@param notificationID the Id of notification to add
    */
    public void deleteNotificaiton(int notificationID){
	usersNotificationList.deleteNotification(notificationID);
    }
    
    /**
    *Marks notification as read
    *@param notificationID the ID of the notification to mark as read
    */
    public void markNotificationAsRead(int notificationID){
	usersNotificationList.markNotificationAsRead(notificationID);
    }
    
    public FoodList getFoodList() {
        return this.usersFoodList;
    }
    
    public MoodList getMoodList() {
        return this.usersMoodList;
    }
    
    public void setFoodList(FoodList foodList) {
        this.usersFoodList = foodList;
    }
    
    public void setMoodList(MoodList moodList) {
        this.usersMoodList = moodList;
    }
    
    @Override
    public boolean equals(Object objectToCompare) {
        User testUser = (User) objectToCompare;
        return testUser.getUsername().equals(this.username) 
                && Arrays.equals(this.password, testUser.getPassword());
    }
	
	/**
	 * Checks if a char[] meets the requirements to be a password.
	 * @return true if it is a valid password
	 */
	public static boolean isValidPassword(char[] passwordToCheck) {
		/*
			It is unclear what the requirements will be for passwords, so I will
			implement a very simple requirement that it must be more than 3
			characters long.
		*/
		
		return passwordToCheck.length > 3;
	}
}
