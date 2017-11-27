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
public final class NotificationCntl {
    
    private User activeUser;
    private Notification selectedNotification;
    private NotificationList theNotificationList;
    private NavigationCntl navigationCntl;
    
    /**
     * Default constructor, needs user to get and assign notifications
     * @param user currentUser
     * @param navigationCntl 
     * @param foodCntl 
     * @param moodCntl 
     * @param showView 
     */
    public NotificationCntl(NavigationCntl navigationCntl, 
            FoodCntl foodCntl, MoodCntl moodCntl, boolean showView){
        this.navigationCntl = navigationCntl;
        this.activeUser = navigationCntl.getActiveUser();
        this.theNotificationList = activeUser.getNotificationList();
        checkForNotifications(foodCntl, moodCntl);
    }
    
    /**
     * checks with FoodCntl and MoodCntl for last time information was entered
     * @param foodCntl
     * @param moodCntl
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
    
    public void deleteNotification() {
        theNotificationList.deleteNotification(selectedNotification);
        selectedNotification = null;
        navigationCntl.goToScreen(NavigationCntl.ScreenOption.NOTIFICATIONLIST);
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
        navigationCntl.goToScreen(NavigationCntl.ScreenOption.HOME);
    }
    
    /**
     * Scrolls forward through notificationList
     * @param id 
     */
    public void next(){
        selectedNotification = theNotificationList.next(selectedNotification);
        this.navigationCntl.goToScreen(NavigationCntl.ScreenOption.NOTIFICATION);
    }
    
    /**
     * Scrolls backwards through notificationList
     * @param id 
     */
    public void previous(){
        selectedNotification = theNotificationList.previous(selectedNotification);
        this.navigationCntl.goToScreen(NavigationCntl.ScreenOption.NOTIFICATION);
    }
    
    /**
     * Tests if all notifications have been read to display warning on home
     * @return if an unread notification exists
     */
    public boolean hasUnreadNotifications(){
        return theNotificationList.hasUnreadNotification();
    }
    
    public NotificationList getNotificationList() {
        return this.theNotificationList;
    }
    
    public void requestHomeView() {
        navigationCntl.goToScreen(NavigationCntl.ScreenOption.HOME);
    }
    
    public void requestExtendedNotificationView(Notification notification) {
        this.selectedNotification = notification;
        navigationCntl.goToScreen(NavigationCntl.ScreenOption.NOTIFICATION);
    }

    public Notification getSelectedNotification() {
       return this.selectedNotification;
    }

    public boolean hasNext() {
        return this.theNotificationList.hasNext(selectedNotification);
    }

    public boolean hasPrevious() {
        return this.theNotificationList.hasPrevious(selectedNotification);
    }
    
}
