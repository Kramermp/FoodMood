/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.view;

import ui.utils.JTextHint;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import userprofile.UserCntl;
import userprofile.User;

/**
 *
 * @author Michael Kramer
 */
public class UserProfileUI extends JFrame {
    private UserCntl parentController;
    private User sourceUser;

    private JPanel inputPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JTextField usernameTxtFld;
    private JLabel usernameTakenErrLbl;
    private JPasswordField passwordTxtFld;
    private JLabel passwordRequirementsErrLbl;
    private JPasswordField confirmPasswordTxtFld;
    private JLabel passwordMatchErrLbl;
    private JProgressBar passwordStrength;

    /**
     * Creates a blank UserProfileUI
     */
    public UserProfileUI() {
        System.out.println("UserProfileUI()");
        addComponents();
        buildInputPanel();
        buildButtonPanel();

    }

    /**
     * Creates a UserProfile UI with the SourceUser
     * @param sourceUser the user to populate the the UI with
     * @param parentController the parentController
     */
    public UserProfileUI(UserCntl parentController, User sourceUser) {
        System.out.println("UserProfileUI(UserCntl, User);");
        this.parentController = parentController;
        this.sourceUser = sourceUser;
        addComponents();
        buildInputPanel();
        buildButtonPanel();
    }

            /**
     * Creates a UserProfile UI without a sourceUser
     * @param parentController the parentController
     */
    public UserProfileUI(UserCntl parentController) {
        System.out.println("UserProfileUI(UserCntl, User);");
        this.parentController = parentController;
        addComponents();
        buildInputPanel();
        buildButtonPanel();
    }

    private void addComponents() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        this.add(inputPanel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.SOUTH;
        this.add(buttonPanel, gbc);
    }

    private void buildInputPanel() {
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        if(sourceUser != null) {

            usernameTxtFld = new JTextHint("Username");
            

        } else {
            //If there is not a source user
            //This implies that this UI is fpr creating a new user
            usernameTxtFld = new JTextField("Username");
            gbc.gridx = 0;
            gbc.gridy = 0;
            inputPanel.add(usernameTxtFld, gbc);
            usernameTakenErrLbl = new JLabel("The entered username is already taken.");
            usernameTakenErrLbl.setForeground(Color.RED);
            usernameTakenErrLbl.setVisible(false);
            gbc.gridx = 1;
            gbc.gridy = 0;
            inputPanel.add(usernameTakenErrLbl, gbc);
            passwordStrength = new JProgressBar(0, 16);
            passwordTxtFld = new JPasswordField("Password");
            DocumentListener test = new PasswordStrengthListener(passwordTxtFld, passwordStrength);
            passwordTxtFld.getDocument().addDocumentListener(test);
            gbc.gridx = 0;
            gbc.gridy = 1;
            inputPanel.add(passwordTxtFld, gbc);
            gbc.gridx = 0;
            gbc.gridy = 3;
            inputPanel.add(passwordStrength, gbc);
            passwordRequirementsErrLbl = new JLabel("The password does not meet the password requirements.");
            passwordRequirementsErrLbl.setForeground(Color.red);
            passwordRequirementsErrLbl.setVisible(false);
            gbc.gridx = 1;
            gbc.gridy = 1;
            inputPanel.add(passwordRequirementsErrLbl, gbc);
            confirmPasswordTxtFld = new JPasswordField("Verify Password");
            gbc.gridx = 0;
            gbc.gridy = 2;
            inputPanel.add(confirmPasswordTxtFld, gbc);
            passwordMatchErrLbl = new JLabel("The entered passwords do not match.");
            passwordMatchErrLbl.setForeground(Color.RED);
            passwordMatchErrLbl.setVisible(false);
            gbc.gridx = 1;
            gbc.gridy = 2;
            inputPanel.add(passwordMatchErrLbl, gbc);
        }
    }

    private void buildButtonPanel() {
            buttonPanel.setBackground(Color.yellow);
            buttonPanel.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            if(sourceUser != null) {
                    //If there is a source User

            } else {
				//If there is not a source user
				//This implies that this UI is fpr creating a new user
				JButton cancelBtn = new JButton("Cancel");
				cancelBtn.addActionListener((ActionEvent ae) -> { 
//						System.out.println("cancelBtn click registered");
//						parentController.goHome();
				});
				gbc.gridx = 0;
				gbc.gridy = 0;
				buttonPanel.add(cancelBtn, gbc);
				JButton submitBtn = new JButton("Submit");
				submitBtn.addActionListener((ActionEvent ae) -> {
						System.out.println("submitBtn click registered");
//						if(this.parentController.submitUser()){
//							this.setVisible(false);
//						}
				});
				gbc.gridx = 1;
				gbc.gridy = 0;
				buttonPanel.add(submitBtn, gbc);	
            }

    }
            /**
             * Returns the String value of the Username JTextField
             * @return the Username
             */
            public String getUsername() {
                    return usernameTxtFld.getText();
            }

            public char[] getPassword() {
                    return passwordTxtFld.getPassword();
            }

            public char[]  getConfirmPassword() {
                    return confirmPasswordTxtFld.getPassword();
            }

    public void displayUsernameTakenError(boolean testResult) {
            System.out.println("Display Username Error:" + !testResult);
            usernameTakenErrLbl.setVisible(!testResult);
    }

    public void displayPasswordRequirementsError(boolean testResult) {
            System.out.println("Display Password Requirements Error:" + !testResult);
            passwordRequirementsErrLbl.setVisible(!testResult);
    }

    public void displayPasswordMatchError(boolean testResult) {
            System.out.println("Display Password Match Error:" + !testResult);
            passwordMatchErrLbl.setVisible(!testResult);
    }
	
}
