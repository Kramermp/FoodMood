/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.GregorianCalendar;
import userprofile.model.*;
import notificationprofile.controller.*;
import notificationprofile.model.*;

/**
 *
 * @author HannahGarthwaite
 */
public class NotificationTest {
    
    public NotificationTest(){
        User user = new User("username", "password".toCharArray());
        System.out.println("Notification Test created User.");
        NotificationList theNotificationList = new NotificationList();
        System.out.println("Notification Test created NotificationList.");
        
        Notification theNotification = new Notification(0, "Test Notification", "This is a test.", new GregorianCalendar(), false);
        System.out.println("Notification Test created a test notification "+theNotification.getId());
        
        theNotificationList.addNotification(theNotification);
        System.out.println("Notification Test added Notification.");
        
        user.setNotificationList(theNotificationList);
        System.out.println("Notification Test set Notification List in User.");
                
        NotificationCntl theNotificationCntl = new NotificationCntl(user);
        System.out.println("NotificationCntl created.");
        
        if(theNotificationCntl.notificationIsRead(0)){
            System.out.println("The NotificaitonCntl incorrect marked the test notification as read.");
        }else{
            System.out.println("The NotificationCntl successfully marked the test notification as unread.");
        }
        
        theNotificationCntl.viewNotificationList();
        System.out.println("The NotificationCntl viewed NotificatinListUI");
        theNotificationCntl.viewNotification(0);
        System.out.println("The NotificationCntl viewed Notification 0");
        if(theNotificationCntl.notificationIsRead(0)){
            System.out.println("The NotificationCntl successfully marked the test notification as read.");
        }else{
            System.out.println("The NotificaitonCntl did not mark the test notification as read.");
        }
        
        theNotificationCntl.goHome();
        System.out.println("The NotificationCntl went home.\n");
        
    }
    
}
