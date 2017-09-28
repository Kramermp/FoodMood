/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testharness;

import Login.LoginController;
import Login.LoginView;
import foodmood.controller.NavigationCntl;

/**
 *
 * @author HannahGarthwaite
 */
public class LoginTest {
    public LoginTest() {
        LoginController theLoginController = new LoginController();
        if(theLoginController != null) {
            System.out.println("The Login Controller was created.");
        }
        
        String username = "correct";
        char[] password = "password".toCharArray();
        char[] incorrectPassword = "incorrect".toCharArray();
        
                
        LoginView theLoginView = new LoginView(theLoginController);
        theLoginView.enterCredentialsFromSavedValues(username, incorrectPassword);
        System.out.println("Incorrect user credentials entered in LoginView");
        //theLoginView.submitUserCredentials();
        System.out.println("Incorrect user credentials sent for login");
        
        theLoginView.enterCredentialsFromSavedValues(username, incorrectPassword);
        System.out.println("Correct user credentials entered in LoginView");
       //theLoginView.submitUserCredentials();
        System.out.println("Correct user credentials sent for login");
        
        if(theLoginController.authenticateUserCredentials(username, password)){
            System.out.println("The Login Controller successfully authenticated user.");
        }else{
            System.out.println("The Login Controller failed to authenticate user.");
        }
        if(theLoginController.authenticateUserCredentials(username, incorrectPassword)){
            System.out.println("The Login Controller successfully denied access.");
        }else{
            System.out.println("The Login Controller incorrectly logged a user in.");
        }
        
        theLoginController.login();
        System.out.println("The Navigation Controller was created by Login Control.");
        
        NavigationTest theNavigationTest = new NavigationTest();
        
    }
}
