/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.view;

import ui.utils.JPasswordHint;
import ui.utils.JTextHint;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import userprofile.controller.UserCntl;
import userprofile.model.User;

/**
 *
 * @author Michael Kramer
 */
public class ViewUserProfileUI extends JPanel {
    private UserCntl parentCntl;
    private User sourceUser;


    private JPanel buttonPanel = new JPanel();
    private JPanel errorPanel;
    private JTextHint usernameFld;
    private JLabel usernameTakenErrLbl;
    private JPasswordHint passwordFld;
    private JLabel passwordRequirementsErrLbl;
    private JPasswordHint confirmPasswordFld;
    private JLabel passwordMatchErrLbl;
    private JProgressBar passwordStrength;
    
    private String currentUsername;
    private JPasswordHint currentPasswordFld;


    /**
     * Creates a UserProfile UI with the SourceUser
     * @param sourceUser the user to populate the the UI with
     * @param parentController the parentCntl
     */
    public ViewUserProfileUI(UserCntl parentCntl, User sourceUser) {
        this.parentCntl = parentCntl;
        this.sourceUser = sourceUser;
        addComponents();
    }

    /**
     * Creates a UserProfile UI without a sourceUser
     * @param parentController the parentCntl
     */
    public ViewUserProfileUI(UserCntl parentCntl) {
        this.parentCntl = parentCntl;
        this.sourceUser = parentCntl.getActiveUser();
        this.setLayout(new GridBagLayout());
        addComponents();
    }
    
    public void loadSourceUser() {
        //usernameFld.setValue(sourceUser.getUsername());
    }

    private void addComponents() {
        currentUsername = sourceUser.getUsername();
        GridBagConstraints gbc = new GridBagConstraints();
        
        JPanel leftMargin = new JPanel();
        //leftMargin.setBackground(Color.BLUE); // For Debugging Purposes
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = .5;
        this.add(leftMargin, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = 1;
        this.add(buildInputPanel(), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = .5;
        this.add(buildButtonPanel(), gbc);
        
        JPanel rightMargin = new JPanel();
        //rightMargin.setBackground(Color.MAGENTA); // For Debugging Purposes
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = .5;
        this.add(rightMargin, gbc);
    }

    private JPanel buildInputPanel() {
        JPanel inputPanel = new JPanel();
        //inputPanel.setBackground(Color.CYAN);
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JPanel topMargin = new JPanel();
        //topMargin.setBackground(Color.BLACK);
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        inputPanel.add(topMargin, gbc);
        
        JLabel usernameLbl = new JLabel("Username");
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = 0.25;
        inputPanel.add(usernameLbl, gbc);
        
        usernameFld = new JTextHint(sourceUser.getUsername(), 25);
        usernameFld.setHorizontalAlignment(JTextField.CENTER);
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 0;
        inputPanel.add(usernameFld, gbc);
       
        JLabel passwordLbl = new JLabel("New Password");
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = 0.25;
        inputPanel.add(passwordLbl, gbc);
        
        passwordFld = new JPasswordHint("New Password", 25);
        passwordFld.setHorizontalAlignment(JPasswordField.CENTER);
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 0;
        inputPanel.add(passwordFld, gbc);
        
        JProgressBar passwordStrengthBar = new JProgressBar(0, 16);
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = .25;
        new PasswordStrengthListener(passwordFld, passwordStrengthBar);
        inputPanel.add(passwordStrengthBar, gbc);
        
        
        JLabel confirmPasswordLbl = new JLabel("Confirm New Password");
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = .25;
        inputPanel.add(confirmPasswordLbl, gbc);
        
        confirmPasswordFld = new JPasswordHint("Confirm New Password", 25);
        confirmPasswordFld.setHorizontalAlignment(JPasswordField.CENTER);
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 0;
        inputPanel.add(confirmPasswordFld, gbc);
        
        JLabel currentPasswordLbl = new JLabel("Current Password");
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = .25;
        inputPanel.add(currentPasswordLbl, gbc);
        
        currentPasswordFld = new JPasswordHint("Current Password", 25);
        currentPasswordFld.setHorizontalAlignment(JPasswordField.CENTER);
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 0;
        inputPanel.add(currentPasswordFld, gbc);
        
        errorPanel = new JPanel();
        errorPanel.setLayout(new GridBagLayout());
        //bottomMargin.setBackground(Color.WHITE);
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        inputPanel.add(errorPanel, gbc);
        
        return inputPanel;
    }

    private JPanel buildButtonPanel() {
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JButton cancelBtn = new JButton("Discard Changes");
        cancelBtn.addActionListener((ActionEvent ae) -> { 
            System.out.println("cancelBtn click event registered.");
            parentCntl.goHomeScreen();
        });
        gbc.gridx = 0; 
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttonPanel.add(cancelBtn, gbc);
        
        JButton deleteBtn = new JButton("Delete Account");
        deleteBtn.addActionListener((ActionEvent ae) -> { 
            System.out.println("deleteBtn click event registered.");
            parentCntl.requestAccountDeletion(currentUsername, currentPasswordFld.getValue());
        });
        gbc.gridx = 0; 
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttonPanel.add(deleteBtn, gbc);
        
        JButton saveBtn = new JButton("Save Changes");
        saveBtn.addActionListener((ActionEvent ae) -> { 
            System.out.println("saveBtn click event registered.");
            String newUsername;
            char[] newPassword;
            if(usernameFld.getValue().isEmpty()) {
                System.out.println("using current username");
                newUsername = currentUsername;
            } else {
                newUsername = usernameFld.getValue();
            }
            if(!(passwordFld.getValue().length  > 0)) {
                System.out.println("using current password");
                newPassword = currentPasswordFld.getValue();
            } else {
                newPassword = passwordFld.getPassword();
            }
            parentCntl.requestAccountChanges(currentUsername, newUsername, currentPasswordFld.getValue(), newPassword);
            
        });
        gbc.gridx = 0; 
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        buttonPanel.add(saveBtn, gbc);
        
        return buttonPanel;
    }
    
    public void displayCurrentPasswordErr(boolean viewState) {
        errorPanel.removeAll();
        errorPanel.add(new JLabel("You must enter you current password to make" +
                " changes to yout account."));
        errorPanel.repaint();
        errorPanel.revalidate();
    }
    
    public void displayPasswordTooWeakErr(boolean viewState) {
        errorPanel.removeAll();
        errorPanel.add(new JLabel("Your new password is too weak."));
        errorPanel.repaint();
        errorPanel.revalidate();
    }
    
    public void displayUsernameTakenErr(boolean viewState) {
        errorPanel.removeAll();
        errorPanel.add(new JLabel("That username is already taken."));
        errorPanel.repaint();
        errorPanel.revalidate();
    }
	
}
