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
    private JFrame userInterface;
    
    /**
     * Creates a default NavigationController Constructor
     */
    public NavigationCntl (LoginCntl loginCntl, User user) {
        this.loginCntl = loginCntl;
        this.activeUser = user;
        this.userInterface = new JFrame();
        configureUserInterface();
        goUserProfile();
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
        theHomeUI = new HomeUI(this);
        theHomeUI.setVisible(true);
    }
        
    //_______________Food Module___________________        
    /**
     * Loads the foodScreen
     */
    public void goFoodScreen() {
        FoodCntl foodController = new FoodCntl(this, activeUser);
        FoodUI foodUI = new FoodUI(foodController);
    }
        
    //_______________Mood Module___________________  
    /**
     * Loads the Mood Screen
     */
    public void goMoodScreen() {
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
        NotificationCntl notificationController = new NotificationCntl(activeUser, this);
    }
    
    //_______________User Module___________________  
    /**
     * Loads the Login Screen
     */
    public void logout() {
        if(theHomeUI != null)
            theHomeUI.dispose();
        if(this.userInterface != null)
            userInterface.dispose();
        loginCntl.logout();
    }

    public void goUserProfile() {
        
        UserCntl userCntl = new UserCntl(this);
    }
    
    public JFrame getUserInterface() {
        return this.userInterface;
    }
    
    public User getActiveUser(){
        return activeUser;
    }
}
