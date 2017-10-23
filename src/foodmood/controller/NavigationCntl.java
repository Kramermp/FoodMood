/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmood.controller;

import foodmood.view.*;
import foodprofile.view.*;
/**
 *
 * @author Michael Kramer
 */
public class NavigationCntl {
	
        private HomeUI theHomeUI;
	/**
	 * Creates a default NavigationController Constructor
	 */
	public NavigationCntl () {
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
		
	}
	
	/**
	 * Loads the Mood Screen
	 */
	public void goMoodScreen() {
		
	}
	
	/**
	 * Loads Food Mood Screen
	 */
	public void goFoodMoodScreen() {
		
	}
	
	/**
	 * Loads the Notification Screen
	 */
	public void goNotifcationScreen() {
		
	}
	
	/**
	 * Loads the Login Screen
	 */
	public void logout() {
		
	}
}
