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
import foodprofile.controller.FoodCntl;
import java.util.Calendar;
import java.util.Date;
import moodprofile.controller.MoodCntl;
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
    public NotificationCntl(User user, NavigationCntl navigationCntl, FoodCntl foodCntl, MoodCntl moodCntl, boolean showView){
        theUser = user;
        theNotificationList = user.getNotificationList();
        this.navigationCntl = navigationCntl;
        checkForNotifications(foodCntl, moodCntl);
        if(showView){
            viewNotificationList();
        }
    }
    
    /**
     * checks with FoodCntl and MoodCntl for last time information was entered
     */
    public void checkForNotifications(FoodCntl foodCntl, MoodCntl moodCntl){
        
        //get the current time
        Date now = Calendar.getInstance().getTime();
        now.setYear(now.getYear()+1900);
        if(now.getMonth()<12){
            now.setMonth(now.getMonth()+1);
        }
        
        //get the times of last entry
        Date lastMood = moodCntl.getDateOfLastMood();
        Date lastFood = foodCntl.getDateOfLastFood();
        
        //in milliseconds
        long timeInMillisecondsMood = now.getTime() - lastMood.getTime();
        System.out.println("Last mood: " +timeInMillisecondsMood);
        //convert to hours
        long timeInHoursMood = timeInMillisecondsMood / (60 * 60 * 1000)%24;
        System.out.println("Time difference: "+timeInHoursMood);
        if(timeInHoursMood > 3){
            addMoodReminder(now);
        }
        
        //in milliseconds
        long timeInMillisecondsFood = now.getTime() - lastFood.getTime();
        System.out.println("Last food: " +timeInMillisecondsFood);
        //in hours
        long timeInHoursFood = timeInMillisecondsFood / (60 * 60 * 1000)%24;
        System.out.println("Time difference: "+timeInHoursFood);
        if(timeInHoursFood > 3){
            addFoodReminder(now);
        }
    }
    
    /**
     * Adds a reminder to the notification list to enter food
     * @param date time the reminder was made
     */
    public void addFoodReminder(Date date){
        Notification foodReminder = new Notification(1, "Have you eaten?", "It has been a while since you entered a food!", date, false);
        theNotificationList.addNotification(foodReminder);
    }
    
    /**
     * Adds a reminder to the notification list to enter mood
     * @param date time the reminder is made
     */
    public void addMoodReminder(Date date){
        Notification moodReminder = new Notification(1, "How are you?", "It has been a while since you entered a mood!", date, false);
        theNotificationList.addNotification(moodReminder);
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
    
    /**
     * Tests if all notifications have been read to display warning on home
     * @return if an unread notification exists
     */
    public boolean hasUnreadNotifications(){
        return theNotificationList.hasUnreadNotification();
    }
    
}
