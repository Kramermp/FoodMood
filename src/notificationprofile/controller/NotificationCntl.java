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
    
    public NotificationCntl(User user, NavigationCntl navigationCntl){
        theUser = user;
        theNotificationList = user.getNotificationList();
        this.navigationCntl = navigationCntl;
        viewNotificationList();
    }
    
    public void viewNotificationList(){
        NotificationListUI theNotificationListUI = new NotificationListUI(this, theNotificationList);
        theNotificationListUI.setVisible(true);
    }
    
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
    
    public boolean notificationIsRead(int id){
        return theNotificationList.getNotificationByID(id).isRead();
    }
    
    public void goHome(){
        navigationCntl.goHomeScreen();
    }
    
    public void next(int id){
        Notification theNotificationToView = theNotificationList.next(id);
        NotificationUI theNotificationUI = new NotificationUI(this, theNotificationToView);
        theNotificationUI.setVisible(true);
        theNotificationList.markNotificationAsRead(theNotificationToView.getId());
    }
    
    public void previous(int id){
        Notification theNotificationToView = theNotificationList.previous(id);
        NotificationUI theNotificationUI = new NotificationUI(this, theNotificationToView);
        theNotificationUI.setVisible(true);
        theNotificationList.markNotificationAsRead(theNotificationToView.getId());
    }
    
    public void deleteNotification(int id){
        theNotificationList.deleteNotification(id);
    }
}
