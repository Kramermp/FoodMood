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
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Michael Kramer
 */
public class LoginUI extends JFrame {
    private LoginCntl parentController;
    private JTextHint usernameTxtFld;
    private JPasswordHint passwordFld;
    private JPanel errorMessage;
    private JLabel errorText;
    private JButton submitBtn;
    
    /**
     * Creates a LoginView with a reference to the parent LoginCntl
     * @param parentController the parentController
     */
    public LoginUI(LoginCntl parentController) {
        this.parentController = parentController;
        buildWindow();
        addComponents();
        //pack();
    }
    
    /**
     * Optionally implemented if user saves credentials on the device
     * (Here for initial testing purposes)
     */
    public void enterCredentialsFromSavedValues(String username, char[] password){
        usernameTxtFld.setText(username);
        passwordFld.setText(new String(password));
    }
    
    /**
     * Configures the window of the LoginUI
     */
    private void buildWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setSize(new Dimension( 500, 700));
    }
    
    private void addComponents() {
    setLayout(new GridBagLayout());
        // The labelInset will be the standard inset used by the label objects
        Insets labelInset = new Insets(15, 0, 0, 0);
        // The fieldInset will be the standard inset used by the field objects
        Insets fieldInset = new Insets(5, 0, 0, 0);
        
        JLabel usernameLbl = new JLabel("USERNAME");
        GridBagConstraints c = new GridBagConstraints();
        c.insets = labelInset;
        c.anchor = GridBagConstraints.SOUTH;
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = 0;
        c.weighty = .75;
        add(usernameLbl, c);
        
        usernameTxtFld = new JTextHint("Username", 25);
        usernameTxtFld.setHorizontalAlignment(JTextField.CENTER);
        usernameTxtFld.addActionListener((ActionEvent ae) -> { 
            System.out.println("An Action occured on Username Field.");
            passwordFld.requestFocus();
           
        });
        //Add ActionListener for username field
        c = new GridBagConstraints();
        c.insets = fieldInset;
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = 3;
        add(usernameTxtFld, c);
        
        JLabel passwordLbl = new JLabel("PASSWORD");
        c = new GridBagConstraints();
        c.insets = labelInset;
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = 4;
        add(passwordLbl, c);

        passwordFld = new JPasswordHint("Password", 25);
        passwordFld.setHorizontalAlignment(JPasswordField.CENTER);
        passwordFld.addActionListener((ActionEvent ae) -> { 
            System.out.println("An Action occured on Password Field.");
            submitBtn.requestFocus();
        });
        
        c = new GridBagConstraints();
        c.insets = fieldInset;
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = 5;
        add(passwordFld, c);
        
        errorMessage = new JPanel();
        errorText = new JLabel("The Username or Password was"
                + " incorrect.");
        errorText.setForeground(Color.RED);
        errorMessage.add(errorText);
        errorMessage.setEnabled(false);
        errorMessage.setVisible(false);
        
        c = new GridBagConstraints();
        c.insets = fieldInset;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridwidth = 2;
        c.gridy = 6;    
        add(errorMessage, c);   

        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener((ActionEvent) -> { 
            this.parentController.exit();
        });
        
        //cancelBtn.addActionListener(new CancelBtnListener());
        c = new GridBagConstraints();
        c.insets = new Insets(150, 10, 0, 5);
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridy = 6;
        add(cancelBtn, c);
        
        submitBtn = new JButton("Submit");
        submitBtn.addActionListener((ActionEvent -> { 
            submitUserCredentials();
        }));
        c = new GridBagConstraints();
        c.insets = new Insets(150, 5, 0, 10);
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridy = 6;
        add(submitBtn, c);
        
        JButton signupBtn = new JButton("Sign Up");
        signupBtn.addActionListener((ActionEvent) -> { 
            this.parentController.signup();
        });
        //registerBtn.addActionListener(new RegisterBtnListener());
        c = new GridBagConstraints();
        c.insets = new Insets(5, 10, 0, 10);
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridy = 7;
        c.weighty = .75;
        add(signupBtn, c);    
    }
    
    public void displayLoginFailure() {
        errorMessage.setEnabled(true);
        errorMessage.setVisible(true);
        errorText.setText("The Username or Password entered was incorrect.");
    }
    
    private void exit() {
        //Go back to parent controller before doing system.exit because there
        //maybe be special things that we want to do every exit
        parentController.exit();
    }
    
    private void submitUserCredentials() {
        errorMessage.setEnabled(false);
        errorMessage.setVisible(false);
        if(usernameTxtFld.getValue().isEmpty()) {
            //If the Username field is empty
            if(passwordFld.getValue().length > 0) {
                //But the Password field has a value
                errorMessage.setEnabled(true);
                errorMessage.setVisible(true);
                errorText.setText("Please Enter Your Username");
            } else {
                //If both Username and password are empty
                errorMessage.setEnabled(true);
                errorMessage.setVisible(true);
                errorText.setText("Please Enter Your Username and Password.");
            }
        } else if (passwordFld.getValue().length < 1) {
            //If Username field is not empty but the password field is empty
            errorMessage.setEnabled(true);
            errorMessage.setVisible(true);
            errorText.setText("Please Enter Your Password.");       
        } else {
            //If both username and Password fields have values entered into them
            parentController.submitUserCredentials(usernameTxtFld.getValue(),
            passwordFld.getValue());
        }  
    }


    
}
