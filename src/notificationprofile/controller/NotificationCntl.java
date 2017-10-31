/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificationprofile.controller;

import userprofile.model.*;
import notificationprofile.model.*;
import notificationprofile.view.*;
import foodmood.controller.NavigationCntl;
/**
 *
 * @author HannahGarthwaite
 */
public class NotificationCntl {
    
    User theUser;
    NotificationList theNotificationList;
    NavigationCntl navigationCntl;
    
    /**
     * Default constructor, needs user to get and assign notifications
     * @param user currentUser
     * @param navigationCntl 
     */
    public NotificationCntl(User user, NavigationCntl navigationCntl){
        theUser = user;
        theNotificationList = user.getNotificationList();
        this.navigationCntl = navigationCntl;
        viewNotificationList();
    }
    
    /**
     * Deletes notification
     * @param id 
     */
    public void deleteNotification(int id){
        theNotificationList.deleteNotification(id);
    }
    /**
     * Opens NotificationListUI
     */
    public void viewNotificationList(){
        NotificationListUI theNotificationListUI = new NotificationListUI(this, theNotificationList);
        theNotificationListUI.setVisible(true);
    }
    
    /**
     * Opens NotificationUI for notification
     * @param id id of the notification to view
     */
    public void viewNotification(int id){
        Notification theNotificationToView = null;
        for (int i = 0; i < theNotificationList.getNotificationList().size(); i++) {
            if(theNotificationList.getNotification(i).getId() == id){
                theNotificationToView = theNotificationList.getNotification(i);
                break;
            }
        }
        NotificationUI theNotificationUI = new NotificationUI(this, theNotificationToView);
        theNotificationUI.setVisible(true);
        theNotificationList.markNotificationAsRead(theNotificationToView.getId());
    }
    
    /**
     * sets a notification to read
     * @param id id of the notification
     * @return 
     */
    public boolean notificationIsRead(int id){
        return theNotificationList.getNotificationByID(id).isRead();
    }
    
    /**
     * Calls navigationCntl to go home
     */
    public void goHome(){
        navigationCntl.goHomeScreen();
    }
    
    /**
     * Scrolls forward through notificationList
     * @param id 
     */
    public void next(int id){
        Notification theNotificationToView = theNotificationList.next(id);
        NotificationUI theNotificationUI = new NotificationUI(this, theNotificationToView);
        theNotificationUI.setVisible(true);
        theNotificationList.markNotificationAsRead(theNotificationToView.getId());
    }
    
    /**
     * Scrolls backwards through notificationList
     * @param id 
     */
    public void previous(int id){
        Notification theNotificationToView = theNotificationList.previous(id);
        NotificationUI theNotificationUI = new NotificationUI(this, theNotificationToView);
        theNotificationUI.setVisible(true);
        theNotificationList.markNotificationAsRead(theNotificationToView.getId());
    }
    
    
}
