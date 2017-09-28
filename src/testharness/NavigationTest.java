/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testharness;

import foodmood.controller.NavigationCntl;
/**
 *
 * @author HannahGarthwaite
 */
public class NavigationTest {
    
    NavigationCntl theNavigationCntl;
    
    public NavigationTest(){
        theNavigationCntl = new NavigationCntl();
        System.out.println("\nNavigation Controller instantiated by NavigationTest");
        
        theNavigationCntl.goHomeScreen();
        System.out.println("The Navigation Controller called goHome.");
        
        testFoodModule();
        
        testMoodModule();
        
        testFoodMoodModule();
        
        testNotificationModule();
        
        testLogout();
    }
    
    public void testFoodModule(){
        theNavigationCntl.goFoodScreen();
        System.out.println("\nThe Navigation Controller called goFoodScreen.");
        //foodprofile.controller.FoodController theFoodController = new foodprofile.controller.FoodController();
        //FoodTest theFoodTest = new FoodTest(theFoodController);
    }
    
    public void testMoodModule(){
        theNavigationCntl.goMoodScreen();
        System.out.println("\nThe Navigation Controller called goMoodScreen.");
    }
    
    public void testFoodMoodModule(){
        theNavigationCntl.goFoodMoodScreen();
        System.out.println("\nThe Navigation Controller called goFoodMoodScreen.");
    }
    
    public void testNotificationModule(){
        theNavigationCntl.goNotifcationScreen();
        System.out.println("\nThe Navigation Controller called goNotificationScreen.");
        NotificationTest theNotificationTest = new NotificationTest();
    }
    
    public void testLogout(){
        System.out.println("\nThe Navigation Controller called logout.");
        theNavigationCntl.logout();

    }
    
}
