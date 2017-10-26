/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import userprofile.controller.LoginCntl;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 *
 * @author Michael Kramer
 */
public class LoginUI extends JFrame {
    private LoginCntl parentController;
    private JTextHint usernameTextField;
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
		this.requestFocus();
        //pack();
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
		this.setSize(new Dimension( 500, 700));
    }
    
    /**
     * Initializes components of the view
     */
    private void initializeComponents(){
        usernameTextField = new JTextHint("Username");
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
		JPanel leftMargin = new JPanel();
		//leftMargin.setBackground(Color.RED);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 6;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(leftMargin, gbc);
		
		JPanel rightMargin = new JPanel();
		//rightMargin.setBackground(Color.RED);
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridheight = 6;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(rightMargin, gbc);
		
		JPanel topMargin = new JPanel();
		//topMargin.setBackground(Color.BLUE);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 2;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(topMargin, gbc);
		
		
		JPanel bottomMargin = new JPanel();
		//bottomMargin.setBackground(Color.CYAN);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridheight = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = 2;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(bottomMargin, gbc);
		
		//usernameTextField.setText("Username");
		usernameTextField.setToolTipText("Username");
		//usernameTextField.addFocusListener(new UserNameFieldListener());
		usernameTextField.setHorizontalAlignment(JTextField.CENTER);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		gbc.weighty = 1;
		add(usernameTextField, gbc);
		
		passwordField.setToolTipText("Password");
		passwordField.setHorizontalAlignment(JPasswordField.CENTER);
		passwordField.addFocusListener(new PasswordFieldListener());
		passwordField.setAlignmentX(JPasswordField.CENTER_ALIGNMENT);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        add(passwordField, gbc);
		
		exitButton.setPreferredSize(new Dimension (10, 15));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(0,0,0,10);
        gbc.weightx = 1;
		gbc.weighty = .1;
        gbc.anchor = GridBagConstraints.NORTH;
        add(exitButton, gbc);
		
		loginButton.setPreferredSize(new Dimension (10, 15));
		gbc.insets = new Insets(0, 10, 0, 0);
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
		gbc.weighty = .1;
        gbc.anchor = GridBagConstraints.NORTH;
        add(loginButton, gbc);
		
		signupButton.setPreferredSize(new Dimension(10, 15));
		gbc.insets = new Insets(10, 0, 0,0);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
		gbc.weighty = .1;
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

	private class PasswordFieldListener implements FocusListener {
		char[] value = new char[0];
		char[] hint = "Password".toCharArray();
		Color hintColor = Color.GRAY;
		Color textColor = Color.BLACK;
		
		private void setText(char text) {
			
		}
		public PasswordFieldListener() {
			passwordField.setText(hint);
			passwordField.setEchoChar((char) 0);
		}

		@Override
		public void focusGained(FocusEvent fe) {
			System.out.println("Focus was gained");
			if(passwordField.getPassword() == hint) {
				passwordField.setText("");
			}
			//passwordField.setText(hint);
			
		}

		@Override
		public void focusLost(FocusEvent fe) {
			System.out.println("Focus Lost");
			if(getText() == hint) {
				//Do Nothing
				System.out.println("The Value was not the hint");
			} else {
				if(getText().isEmpty()) {
					setText(hint);
					setForeground(hintColor);
					value = "";
				} else {
					value = getText();
				}
			}
		}
	}
}
