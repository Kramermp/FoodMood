/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmood.analytic;

import chart.controller.ChartCntl;
import chart.view.ChartUI;
import userprofile.User;
import userprofile.UserCntl;
import userprofile.LoginCntl;
import userprofile.view.*;

/**
 *
 * @author HannahGarthwaite
 */
public class NavigationCntl {
    
    
    public static enum ScreenOption {HOME, CHART, CORRELATION, HISTORY,
        USERPROFILE, EMPTY}
    private User activeUser;
    private HomeUI theHomeUI;
    private ChartUI theChartUI;
    private HistoryUI theHistoryUI;
    private CorrelationUI theCorrelationUI;
    private LoginCntl loginCntl;
    private UserInterface userInterface;
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
            case CHART:
                goChartScreen();
                break;
            case CORRELATION:
                goCorrelationScreen();
                break;
            case HISTORY:
                goHistoryScreen();
                break;
            case USERPROFILE:
                goUserProfileScreen();
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
        
    
    /**
     * Loads the Login Screen
     */
    public void logout() {
        System.out.println("Logging Out");
        loginCntl.logout();
    }
    
    private void goChartScreen(){
        System.out.println("Going to ChartScreen");
        ChartCntl chartCntl = new ChartCntl(this);
        userInterface.add(new ChartUI(chartCntl));
    }
    
    private void goCorrelationScreen(){
        System.out.println("Going to Correlation Screen");
        theCorrelationUI = new CorrelationUI(this);
        userInterface.add(theCorrelationUI);
        currentScreen = ScreenOption.CORRELATION;
        
    }
    
    private void goHistoryScreen(){
        System.out.println("Going to History Screen");
        theHistoryUI = new HistoryUI(this);
        userInterface.add(theHistoryUI);
        currentScreen = ScreenOption.HISTORY;
        
    }

    private void goUserProfileScreen() {
        System.out.println("Going to User Profile Screen.");
        UserCntl userCntl = new UserCntl(this);
        ViewUserProfileUI userUI = new ViewUserProfileUI(userCntl);
        userInterface.add(userUI);
    }
    
    
    public UserInterface getUserInterface() {
        return this.userInterface;
    }
    
    public User getActiveUser(){
        return activeUser;
    }
    
}
