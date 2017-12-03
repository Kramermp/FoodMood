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
import moodprofile.view.MoodListUI;
import moodprofile.view.MoodUI;
import notificationprofile.controller.NotificationCntl;
import notificationprofile.view.NotificationListUI;
import notificationprofile.view.NotificationUI;
import userprofile.controller.LoginCntl;
import userprofile.controller.*;
import userprofile.model.User;
import userprofile.view.ViewUserProfileUI;
/**
 *
 * @author Michael Kramer
 */
public class NavigationCntl {

    
    public static enum ScreenOption {HOME, FOOD, FOODLIST, EXTENDEDFOOD, 
            MOOD, MOODLIST, EXTENDEDMOOD, USERPROFILE, NOTIFICATIONLIST,
            NOTIFICATION, RECOMMENDATION, EMPTY}
    private User activeUser;
    private HomeUI theHomeUI;
    private LoginCntl loginCntl;
    private UserInterface userInterface;
    private NotificationCntl notificationCntl;
    private FoodCntl foodCntl;
    private MoodCntl moodCntl;
    private ScreenOption currentScreen;
    
    /**
     * Creates a default NavigationController Constructor
     * @param loginCntl
     * @param userInterface
     * @param user
     */
    public NavigationCntl (LoginCntl loginCntl, UserInterface userInterface, User user) {
		System.out.println("NavigationCntl created");
        this.loginCntl = loginCntl;
        this.activeUser = user;
        this.userInterface = userInterface;
        goToScreen(ScreenOption.HOME);
    }
    
    public void goToScreen(ScreenOption screenToDisplay) {
        System.out.println("Navigating to New Screen: " + screenToDisplay);
        System.out.println("Screen is currently: " + currentScreen);
        resetUI();
        switch (screenToDisplay) {
            case HOME: 
                goHomeScreen();
                break;
            case FOOD:
                goFoodScreen();
                break;
            case FOODLIST:
                goFoodListScreen();
                break;
            case EXTENDEDFOOD:
                goExtendedFoodView();   
                break;
            case MOOD:
                goMoodScreen();
                break;
            case MOODLIST:
                goMoodListScreen();
                break;
            case EXTENDEDMOOD:
                goExtendedMoodScreen();
                break;
            case USERPROFILE:
                goUserProfileScreen();
                break;
            case NOTIFICATIONLIST:
                goNotifcationListScreen();
                break;
            case NOTIFICATION:
                goNotificationScreen();
                break;
            case RECOMMENDATION:
                goRecommendationScreen();
                break;
                
        }
        currentScreen = screenToDisplay;
        userInterface.requestFocus();
        System.out.println("Screen should now be: " + currentScreen);
    }
    
    /**
     * Loads the default navigation Screen
     */
    private void goHomeScreen() {
        System.out.println("Going to homeScreen.");
        theHomeUI = new HomeUI(this);
		userInterface.add(theHomeUI);
        currentScreen = ScreenOption.HOME;
    }
    
    private void resetUI() {
        userInterface.reset();
        currentScreen = ScreenOption.EMPTY;
    }
        
    //_______________Food Module___________________        
    /**
     * Loads the foodScreen
     */
    private void goFoodScreen() {
        System.out.println("Going to Food Screen");
        if(foodCntl == null) {
            // If there is not already a foodCntl loaded then we need to create
            // One
            foodCntl = new FoodCntl(this);
        }
        // After we have ensure that there is a FoodCntl
        FoodUI foodUi = new FoodUI(foodCntl);
        userInterface.add(foodUi);
    }
    
    private void goFoodListScreen() {
        System.out.println("Going to the FoodList Screen");
        if(foodCntl == null) {
            // If there is not already a foodCntl loaded then we need to create
            // One
            foodCntl = new FoodCntl(this);
        }
        FoodListUI foodListUi = new FoodListUI(foodCntl);
        userInterface.add(foodListUi);
    }
    
    private void goExtendedFoodView() {
        System.out.println("Going to the ExtendedFoodScreen Screen");
        if(foodCntl == null) {
            // If there is not already a foodCntl loaded then we need to create
            // One
            foodCntl = new FoodCntl(this);
        }
        FoodUI foodUi = new FoodUI(foodCntl, foodCntl.getSelectedFood());
        userInterface.add(foodUi);
    }
        
    //_______________Mood Module___________________  
    /**
     * Loads the Mood Screen
     */
    public void goMoodScreen() {
		System.out.println("Going to MoodUI");
        if(moodCntl == null) {
            moodCntl = new MoodCntl(this);
        }
        MoodUI moodUI = new MoodUI(moodCntl);
        userInterface.add(moodUI); 
    }
    
    public void goMoodListScreen() {
        System.out.println("Going to MoodListUI");
        if(moodCntl == null) {
            moodCntl = new MoodCntl(this);
        }
        MoodListUI moodListUI = new MoodListUI(moodCntl);
        userInterface.add(moodListUI);
    }
    
    private void goExtendedMoodScreen() {
        System.out.println("Going to ExtendedMoodUI");
        if(moodCntl == null) {
            moodCntl = new MoodCntl(this);
        }
        MoodUI moodUi = new MoodUI(moodCntl, moodCntl.getSelectedMood());
        userInterface.add(moodUi);
    }

    //_______________Notification Module___________________   
    /**
     * Loads the Notification Screen
     */
    private void goNotifcationListScreen() {
        System.out.println("Going to NotificationList Screen");
        if(notificationCntl == null) {
            notificationCntl = new NotificationCntl(this, new FoodCntl(this), new MoodCntl(this), true);
        }     
        NotificationListUI notificationListUI = new NotificationListUI(notificationCntl);
        userInterface.add(notificationListUI);
    }
    
    private void goNotificationScreen() {
        System.out.println("Going to NotificationScrenn");
        if(notificationCntl == null) {
            notificationCntl = new NotificationCntl(this, new FoodCntl(this), new MoodCntl(this), true);
        }
        NotificationUI notificationUi = new NotificationUI(notificationCntl);
        userInterface.add(notificationUi);
    }
    //_______________User Module___________________  
    /**
     * Loads the Login Screen
     */
    public void logout() {
        System.out.println("Logging Out");
        loginCntl.logout();
    }

    private void goUserProfileScreen() {
        System.out.println("Going to User Profile Screen.");
        UserCntl userCntl = new UserCntl(this);
        ViewUserProfileUI userUI = new ViewUserProfileUI(userCntl);
        userInterface.add(userUI);
    }
    
    private void goRecommendationScreen() {
        System.out.println("Going to Reccomendation Screen.");
        FoodRecommendationUI foodRecommendationUI = new FoodRecommendationUI(this);
        userInterface.add(foodRecommendationUI);
    }
    
    public UserInterface getUserInterface() {
        return this.userInterface;
    }
    
    public User getActiveUser(){
        return activeUser;
    }
    
    public boolean unreadNotification(){
        notificationCntl = new NotificationCntl(this, new FoodCntl(this), new MoodCntl(this), false);
        return notificationCntl.hasUnreadNotifications();
    }
    
    public FoodCntl getFoodCntl(){
        return new FoodCntl(this);
    }
    
    public MoodCntl getMoodCntl(){
        return new MoodCntl(this);
    }
}
