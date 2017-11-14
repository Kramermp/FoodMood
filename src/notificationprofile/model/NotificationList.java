/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificationprofile.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author HannahGarthwaite
 */
public class NotificationList implements Serializable {
    private ArrayList<Notification> notificationList;
    
    /**
     * Default constructor for NotificationList
     */
    public NotificationList(){
        notificationList = new ArrayList();
    }
    
    /**
     * populates test data
     */
    public void populateTestData(){
        //public Notification(int id, String name, String description, GregorianCalendar timeIssued, boolean read){
        Notification notification1 = new Notification(1, "Have you eaten?", "It has been a while since you entered a food!", new java.util.Date(), false);
        Notification notification2 = new Notification(2, "Sociopath?", "It has been a while since you entered a mood!", new java.util.Date(), false);
        Notification notification3 = new Notification(3, "Where have you been?", "It has been a while since we saw you!", new java.util.Date(), false);
        notificationList.add(notification1);
        notificationList.add(notification2);
        notificationList.add(notification3);
    }

    /**
     * Gets the list of notifications
     * @return the notificationList
     */
    public ArrayList<Notification> getNotificationList() {
        return notificationList;
    }
    
    /**
     * @return size of notification list
     */
    public int size(){
        return notificationList.size();
    }
    
    /**
     * next notification in list
     * @param id id of current notification
     * @return next notification
     */
    public Notification next(int id){
        int index = 0;
        for (int i = 0; i < notificationList.size(); i++) {
            if(notificationList.get(i).getId() == id){
                index = i;
                break;
            }
        }
        index++;
        if(index >= notificationList.size()){
            index = 0;
        }
        return notificationList.get(index);
    }
    
    /**
     * previous notification
     * @param id id of current notification
     * @return previous notification
     */
    public Notification previous(int id){
        int index = 0;
        for (int i = 0; i < notificationList.size(); i++) {
            if(notificationList.get(i).getId() == id){
                index = i;
                break;
            }
        }
        index--;
        if(index < 0){
            index = notificationList.size()-1;
        }
        return notificationList.get(index);
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
    
    /**
     * Gets a notificaiton by the id
     * @param id id of the notification
     * @return the notification
     */
    public Notification getNotificationByID(int id){
        for (int i = 0; i < notificationList.size(); i++) {
            if (notificationList.get(i).getId() == id) {
                return notificationList.get(i);
            }
        }
        return null;
    }
    
    /**
     * Test if all notifications have been read, to display warning on home
     * @return boolean if there is an unread notification
     */
    public boolean hasUnreadNotification(){
        boolean read = false;
        for (int i = 0; i < notificationList.size(); i++) {
            if(!notificationList.get(i).isRead()){
                read = true; 
                break;
            }
        }
        return read;
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
