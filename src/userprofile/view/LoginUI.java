/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.view;

import userprofile.controller.LoginController;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Michael Kramer
 */
public class LoginUI {
    private LoginController parentController;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton exitButton;
    
    /**
     * Creates a LoginView with a reference to the parent LoginController
     * @param parentController the parentController
     */
    public LoginUI(LoginController parentController) {
        System.err.println("This is a stub.");
        //TODO: Implment LoginUI
    }
    
    private void exit() {
        System.err.println("This is a stub.");
        //TODO: Implment exit
    }
    
    private void submitUserCredentials() {
        System.err.println("This is a stub.");
        //TODO: Implment submitUserCredentials
    }
}
