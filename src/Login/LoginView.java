/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Michael Kramer
 */
public class LoginView{
    private LoginController parentController;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton exitButton;
    
    /**
     * Creates a LoginView with a reference to the parent LoginController
     * @param parentController the parentController
     */
    public LoginView(LoginController parentController) {
        this.parentController = parentController;
    }
    
    private void initializeComponents(){
        usernameTextField = new JTextField();
        passwordField = new JPasswordField();
        
        loginButton = new JButton("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitUserCredentials();
            }   
        });
        
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit();
            }   
        });
    }
    
    private void exit() {
        System.exit(0);
    }
    
    private void submitUserCredentials() {
        parentController.authenticateUserCredentials(usernameTextField.getText(), passwordField.getPassword());
    }
}
