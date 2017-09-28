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
        notificationList = new ArrayList();
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
        if(notificationList == null){
            notificationList = new ArrayList();
        }
        notificationList.add(toAdd);
    }
    
    /**
     * Updates a notification in the list, using the ID to find it
     * @param toUpdate the notification to update
     */
    public void updateNotification(Notification toUpdate){
        for (int i = 0; i < notificationList.size(); i++) {
            if (notificationList.get(i).getId() == toUpdate.getId()) {
                notificationList.set(i, toUpdate);
                break;
            }
        }
    }
    
    /**
     * Marks a notification as read
     * @param notificationID the notification Id to mark as read
     */
    public void markNotificationAsRead(int notificationID){
        for (int i = 0; i < notificationList.size(); i++) {
            if (notificationList.get(i).getId() == notificationID) {
                notificationList.get(i).setRead(true);
            }
        }
    }
    
    /**
     * Deletes a notification
     * @param notificationID the ID of the notification to mark as read
     */
    public void deleteNotification(int notificationID){
        for (int i = 0; i < notificationList.size(); i++) {
            if (notificationList.get(i).getId() == notificationID) {
                notificationList.remove(i);
                break;
            }
        }
    }
    
    /**
     * Retrieves a notification given the index
     * @param index the index of the notification to get
     * @return notification
     */
    public Notification getNotification(int index){
        return notificationList.get(index);
    }
    
    public Notification getNotificationByID(int id){
        for (int i = 0; i < notificationList.size(); i++) {
            if (notificationList.get(i).getId() == id) {
                return notificationList.get(i);
            }
        }
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
