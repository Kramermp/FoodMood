/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.view;

import ui.utils.JPasswordHint;
import ui.utils.JTextHint;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import userprofile.LoginCntl;
import userprofile.UserCntl;

/**
 * This class is the UI that is created when a User wishes to create a new account.
 * <p>
 * 
 * @author Michael Kramer
 */
public class NewUserUI extends JPanel {
    private LoginCntl parentCntl;
    private UserCntl theUserCntl;
    
    private JTextHint usernameFld; 
    private JPasswordHint passwordFld;
    private JPasswordHint confirmPasswordFld;
    private JPanel errorPanel;
            
    
    
    public NewUserUI(LoginCntl parentCntl, UserCntl theUserCntl) {
        this.parentCntl = parentCntl;
        this.theUserCntl = theUserCntl;
        this.setLayout(new GridBagLayout());
        addComponents();
    }
    
    /*
     * The components for this UI are grouped into two clumps. The first clump
     * is the inputPanel. The inputPanel contains the different fields that the
     * user will interact with to configure their new user profile. The second
     * clump is the buttonPanel. The buttonPanel contains the buttons that the
     * user will use to either save their input or to cancel their account 
     * creation.
     * 
     * The components are grouped in this manner to ensure that we can quickly 
     * lay this window out without having the buttons and fields interacting.
     */
    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        
        JPanel leftMargin = new JPanel();
        //leftMargin.setBackground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = .5;
        add(leftMargin, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = 1;
        add(buildInputPanel(), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = .5;
        add(buildButtonPanel(), gbc);
        
        JPanel rightMargin = new JPanel();
        //rightMargin.setBackground(Color.MAGENTA);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = .5;
        add(rightMargin, gbc);
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
        
        usernameFld = new JTextHint("Username", 25);
        usernameFld.setHorizontalAlignment(JTextField.CENTER);
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 0;
        inputPanel.add(usernameFld, gbc);
       
        JLabel passwordLbl = new JLabel("Password");
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = 0.25;
        inputPanel.add(passwordLbl, gbc);
        
        passwordFld = new JPasswordHint("Password", 25);
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
        
        
        JLabel confirmPasswordLbl = new JLabel("Confirm Password");
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = .25;
        inputPanel.add(confirmPasswordLbl, gbc);
        
        confirmPasswordFld = new JPasswordHint("Confirm Password", 25);
        confirmPasswordFld.setHorizontalAlignment(JPasswordField.CENTER);
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weighty = 0;
        inputPanel.add(confirmPasswordFld, gbc);
        
        errorPanel = new JPanel();
        errorPanel.setLayout(new GridBagLayout());
        //bottomMargin.setBackground(Color.WHITE);
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        inputPanel.add(errorPanel, gbc);
        
        return inputPanel;
    }
    
    private JPanel buildButtonPanel() {
        JPanel buttonPanel = new JPanel();
        //buttonPanel.setBackground(Color.RED);
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //JPanel leftMargin = new JPanel();
        //leftMargin.setBackground(Color.YELLOW);
        //gbc.gridx = 0;
        //gbc.gridy = 0;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.weightx = 1;
        //buttonPanel.add(leftMargin, gbc);
        
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setPreferredSize(new Dimension(50, 25)); // This ensures that cancel and submit recieve the same space
        cancelBtn.addActionListener((ActionEvent ae) -> { 
            System.out.println("cancelBtn click event registered");
            returnToLogin();
        });
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = .75;
        gbc.weighty = 1;
        buttonPanel.add(cancelBtn, gbc);
        
        JPanel middleMargin = new JPanel();
        //middleMargin.setBackground(Color.PINK);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = .5;
        gbc.weighty = 1;
        buttonPanel.add(middleMargin, gbc);
        
        JButton submitBtn = new JButton("Submit");
        submitBtn.setPreferredSize(new Dimension(50, 25)); // This ensures that cancel and submit recieve the same space
        submitBtn.addActionListener((ActionEvent ae) -> {
            System.out.println("submitBtn click event registered");
            if (verifyUserInput())
                theUserCntl.submitNewUserCredentials(this);
        });
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = .75;
        gbc.weighty = 1;
        buttonPanel.add(submitBtn, gbc);
        
        //JPanel rightMargin = new JPanel();
        //rightMargin.setBackground(Color.ORANGE);
        //gbc.gridx = 4;
        //gbc.gridy = 0;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.weightx = 1;
        //buttonPanel.add(rightMargin, gbc);

        return buttonPanel; 
    }
    
    /* 
     * This method does does some simple checks such as verifing that there
     * is input in each of the fields and ensures that the two password fields
     * match.
     */
    
    private boolean verifyUserInput() {
        int errorCount =0;
        //errorPanel.setBackground(Color.yellow);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        errorPanel.removeAll();
        
        if(!usernameFld.hasValue()) {
            errorCount++;
            gbc.gridy = errorCount;
            errorPanel.add(new JLabel("Please enter a Username."), gbc);
        }

        if(!passwordFld.hasValue()) {
            errorCount++;
            gbc.gridy = errorCount;
            errorPanel.add(new JLabel("Please enter a Password."), gbc);
        } else {
            if(!Arrays.equals(passwordFld.getValue(), confirmPasswordFld.getValue())) {
                errorCount++;
                gbc.gridy = errorCount;
                errorPanel.add(new JLabel("The Passwords you entered do not match."), gbc);
            }
        }
        errorPanel.repaint();
        errorPanel.revalidate();
        return errorCount == 0;
    }
    
    public void usernameIsAvailable(boolean usernameIsAvailable) {
        if(!usernameIsAvailable) {
            System.out.println("That Username is taken");
            errorPanel.add(new JLabel("That Username is already taken."));
        }
    }
    
    public void passwordIsStrongEnough(boolean passwordIsStrongEnough) {
        if(!passwordIsStrongEnough) {
            System.out.println("That Password is too weak.");
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridy = 1;
            errorPanel.add(new JLabel("The Password you entered is too weak."), gbc);
        }
    }
    
    public void returnToLogin() {
        parentCntl.displayLogin();
    }
    
    public String getUsername() {
        return this.usernameFld.getValue();
    } 
    
    public char[] getPassword() {
        return this.passwordFld.getValue();
    }
    
    private class NewUserUIWindowListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent we) {
            // Do Nothing
        }

        @Override
        public void windowClosing(WindowEvent we) {
            System.out.println("NewUserUI closing");
            returnToLogin();
        }

        @Override
        public void windowClosed(WindowEvent we) {
            // Do Nothing
        }

        @Override
        public void windowIconified(WindowEvent we) {
            // Do Nothing
        }

        @Override
        public void windowDeiconified(WindowEvent we) {
            // Do Nothing
        }

        @Override
        public void windowActivated(WindowEvent we) {
            // Do Nothing
        }

        @Override
        public void windowDeactivated(WindowEvent we) {
            // Do Nothing
        }
        
    }
}
