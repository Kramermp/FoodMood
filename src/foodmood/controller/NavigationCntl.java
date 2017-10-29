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
import userprofile.model.User;
/**
 *
 * @author Michael Kramer
 */
public class NavigationCntl {
		private User activeUser;
        private HomeUI theHomeUI;
	/**
	 * Creates a default NavigationController Constructor
	 */
	public NavigationCntl () {
		//This needs to get the acutal User from login or get it
		activeUser = new User("TempUser", "pass".toCharArray());
		goHomeScreen();
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
		FoodCntl foodController = new FoodCntl(activeUser);
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
		NotificationCntl notificationController = new NotificationCntl(activeUser);
	}
	
	/**
	 * Loads the Login Screen
	 */
	public void logout() {
		theHomeUI.dispose();
	}

    public void goUserProfile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
