/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificationprofile.model;

import java.util.ArrayList;

/**
 *
 * @author HannahGarthwaite
 */
public class NotificationList {
    private ArrayList<Notification> notificationList;
    
    /**
     * Default constructor for NotificationList
     */
    public NotificationList(){
        
    }

    /**
     * Gets the list of notifications
     * @return the notificationList
     */
    public ArrayList<Notification> getNotificationList() {
        return notificationList;
    }

    /**
     * Sets the list of notifications
     * @param notificationList the notificationList to set
     */
    public void setNotificationList(ArrayList<Notification> notificationList) {
        this.notificationList = notificationList;
    }
    
    /**
     * Adds a notification to the list
     * @param toAdd the notification to add to the list
     */
    public void addNotification(Notification toAdd){
        
    }
    
    /**
     * Updates a notification in the list, using the ID to find it
     * @param toUpdate the notification to update
     */
    public void updateNotification(Notification toUpdate){
        
    }
    
    /**
     * Marks a notification as read
     * @param notificationID the notification Id to mark as read
     */
    public void markNotificationAsRead(int notificationID){
        
    }
    
    /**
     * Deletes a notification
     * @param notificationID the ID of the notification to mark as read
     */
    public void deleteNotification(int notificationID){
        
    }
    
    /**
     * Retrieves a notification given the index
     * @param index the index of the notification to get
     * @return notification
     */
    public Notification getNotification(int index){
        return null;
    }
    
    /**
     * Sorts notifications by time in descending order
     */
    public void sortByTime(){
        
    }
    
    /**
     * Sorts notifications with those that have not been read at the beginning
     */
    public void sortByRead(){
        
    }
    
    
}
