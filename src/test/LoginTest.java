/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Login.LoginController;
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
        if(theLoginController.authenticateUserCredentials("correct", new char[5])){
            System.out.println("The Login Controller successfully authenticated user.");
        }else{
            System.out.println("The Login Controller failed to authenticate user.");
        }
        if(theLoginController.authenticateUserCredentials("incorrect", new char[5])){
            System.out.println("The Login Controller successfully denied access.");
        }else{
            System.out.println("The Login Controller incorrectly logged a user in.");
        }
        
        theLoginController.login();
        System.out.println("The Navigation Controller was created by Login Control.");
        
        NavigationTest theNavigationTest = new NavigationTest();
        
    }
}
