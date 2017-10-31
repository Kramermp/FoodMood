/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmood.controller;

import foodmood.view.*;
import foodprofile.controller.FoodCntl;
import foodprofile.view.*;
import moodprofile.controller.MoodController;
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
	/**
	 * Creates a default NavigationController Constructor
	 */
	public NavigationCntl (LoginCntl loginCntl, User user) {
            this.loginCntl = loginCntl;
            activeUser = user;
            goHomeScreen();
	}
	
        public NavigationCntl(LoginCntl loginCntl){
            this.loginCntl = loginCntl;
        }
        
	/**
	 * Loads the default Screen
	 */
	public void goHomeScreen() {
		theHomeUI = new HomeUI(this);
                theHomeUI.setVisible(true);
	}
	
	/**
	 * Loads the foodScreen
	 */
	public void goFoodScreen() {
		FoodCntl foodController = new FoodCntl(this, activeUser);
                FoodUI foodUI = new FoodUI(foodController);
	}
	
	/**
	 * Loads the Mood Screen
	 */
	public void goMoodScreen() {
		MoodController moodController = new MoodController(activeUser);
                MoodUI moodUI = new MoodUI(moodController);
	}
	
	/**
	 * Loads Food Mood Screen
	 */
	public void goFoodMoodScreen() {
		//I think this referes to the stats screen
		
	}
	
	/**
	 * Loads the Notification Screen
	 */
	public void goNotifcationScreen() {
		NotificationCntl notificationController = new NotificationCntl(activeUser, this);
	}
	
	/**
	 * Loads the Login Screen
	 */
	public void logout() {
		LoginCntl loginCntl = new LoginCntl();
	}

    public void goUserProfile() {
        UserCntl userCntl = new UserCntl(this);
        userCntl.goUserProfile();
    }
    
    public User getActiveUser(){
        return activeUser;
    }
}
