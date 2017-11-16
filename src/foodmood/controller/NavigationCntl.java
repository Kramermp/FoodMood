/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmood.controller;

import foodmood.view.*;
import foodprofile.controller.FoodCntl;
import foodprofile.view.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import moodprofile.controller.MoodCntl;
import moodprofile.view.MoodUI;
import notificationprofile.controller.NotificationCntl;
import userprofile.controller.LoginCntl;
import userprofile.controller.*;
import userprofile.model.User;
/**
 *
 * @author Michael Kramer
 */
public class NavigationCntl {
    private User activeUser;
    private HomeUI theHomeUI;
    private UserCntl userCntl;
    private LoginCntl loginCntl;
    private UserInterface userInterface;
    private NotificationCntl notificationCntl;
    
    /**
     * Creates a default NavigationController Constructor
     */
    public NavigationCntl (LoginCntl loginCntl, UserInterface userInterface, User user) {
		System.out.println("NavigationCntl created");
        this.loginCntl = loginCntl;
        this.activeUser = user;
        this.userInterface = userInterface;
        goHomeScreen();
    }
    
    private void configureUserInterface() {
        userInterface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userInterface.setSize(new Dimension(500, 700));
//        userInterface.setExtendedState(JFrame.MAXIMIZED_BOTH);
        userInterface.setVisible(true);
        userInterface.setLayout(new BorderLayout());
    }
        
    /**
     * Loads the default Screen
     */
    public void goHomeScreen() {
		userInterface.reset();
        theHomeUI = new HomeUI(this);
		userInterface.add(theHomeUI);
        //theHomeUI.setVisible(true);
    }
        
    //_______________Food Module___________________        
    /**
     * Loads the foodScreen
     */
    public void goFoodScreen() {
        FoodCntl foodController = new FoodCntl(this, activeUser);
        FoodUI foodUI = new FoodUI(foodController, userInterface);
    }
        
    //_______________Mood Module___________________  
    /**
     * Loads the Mood Screen
     */
    public void goMoodScreen() {
		System.out.println("Going to MoodUI");
        MoodCntl moodController = new MoodCntl(this, activeUser);
        MoodUI moodUI = new MoodUI(moodController);
    }
    
    /**
     * Loads Food Mood Screen
     */
    public void goFoodMoodScreen() {
        //I think this referes to the stats screen
        
    }

    //_______________Notification Module___________________   
    /**
     * Loads the Notification Screen
     */
    public void goNotifcationScreen() {
        NotificationCntl notificationController = new NotificationCntl(activeUser, this, new FoodCntl(this, activeUser), new MoodCntl(this,activeUser), true);
    }
    
    //_______________User Module___________________  
    /**
     * Loads the Login Screen
     */
    public void logout() {
        loginCntl.logout();
    }

    public void goUserProfile() {
        configureUserInterface();
        UserCntl userCntl = new UserCntl(this);
    }
    
    public UserInterface getUserInterface() {
        return this.userInterface;
    }
    
    public User getActiveUser(){
        return activeUser;
    }
    
    public boolean unreadNotificaiton(){
		//This right here is causing a bug where the UI is being turned into the
		//Incorrect UI
        //notificationCntl = new NotificationCntl(activeUser, this, new FoodCntl(this, activeUser), new MoodCntl(this,activeUser), false);
        return notificationCntl.hasUnreadNotifications();
    }
}
