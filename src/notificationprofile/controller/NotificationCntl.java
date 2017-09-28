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
    
    public NotificationCntl(User user){
        theUser = user;
        theNotificationList = user.getNotificationList();
    }
    
    public void viewNotificationList(){
        NotificationListUI theNotificationListUI = new NotificationListUI(this, theNotificationList);
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
        theNotificationList.markNotificationAsRead(theNotificationToView.getId());
    }
    
    public boolean notificationIsRead(int id){
        return theNotificationList.getNotificationByID(id).isRead();
    }
    
    public void goHome(){
        NavigationCntl theNavigationCntl = new NavigationCntl();
    }
}
