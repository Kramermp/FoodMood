/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import userprofile.controller.LoginCntl;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Michael Kramer
 */
public class LoginUI extends JFrame {
    private LoginCntl parentController;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton exitButton;
    private JButton signupButton;
    
    /**
     * Creates a LoginView with a reference to the parent LoginCntl
     * @param parentController the parentController
     */
    public LoginUI(LoginCntl parentController) {
        this.parentController = parentController;
        buildWindow();
        initializeComponents();
        addComponents();
        pack();
    }
    
    /**
     * Optionally implemented if user saves credentials on the device
     * (Here for initial testing purposes)
     */
    public void enterCredentialsFromSavedValues(String username, char[] password){
        usernameTextField.setText(username);
        passwordField.setText(new String(password));
    }
    
    /**
     * Configures the window of the LoginUI
     */
    private void buildWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
    }
    
    /**
     * Initializes components of the view
     */
    private void initializeComponents(){
        usernameTextField = new JTextField();
        passwordField = new JPasswordField();
        
        loginButton = new JButton("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Login Button click event registered");
                submitUserCredentials();
            }   
        });
        
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Exit Button click event registered");
                exit();
            }   
        });
        
        signupButton = new JButton("Sign Up");
        signupButton.addActionListener((ActionEvent ae) -> { 
            System.out.println("Signup Button click event registered");
            parentController.signup();
        });
    }
    
    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        add(usernameTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        add(passwordField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        add(exitButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        add(loginButton, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        add(signupButton, gbc);
        
    }
    
    private void exit() {
        //Go back to parent controller before doing system.exit because there
        //maybe be special things that we want to do every exit
        parentController.exit();
    }
    
    private void submitUserCredentials() {
        parentController.submitUserCredentials(usernameTextField.getText(), passwordField.getPassword());
    }
}
