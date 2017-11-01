/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.controller;

import externaldata.controller.ExternalDataCntl;
import foodmood.controller.NavigationCntl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import userprofile.view.LoginUI;
import userprofile.model.UserList;
import userprofile.model.User;
import userprofile.view.ViewUserProfileUI;
import userprofile.view.NewUserUI;

/**
 *
 * @author Michael Kramer
 */
public class LoginCntl {
    private UserList theUserList;
    private LoginUI loginUi;
    private UserCntl userCntl;
    private User user;
    private ExternalDataCntl externalDataCntl;
    private NavigationCntl theNavigationCntl;
    private NewUserUI newUserUi;
    
    /**
     * Creates a LoginController
     */
    public LoginCntl() {
        this.externalDataCntl = ExternalDataCntl.getExternalDataCntl();
        this.theUserList = externalDataCntl.getUserList();
        this.userCntl = new UserCntl(this);
        this.loginUi = new LoginUI(this);
        this.loginUi.setVisible(true);
        this.loginUi.requestFocus();
        
        //This should be removed at a later time
        //submitUserCredentials("mpk5206", "pass".toCharArray());
    }
    
    public final void submitUserCredentials(String username, char[] password) {
        if(theUserList.authenticateUserCredentials(username, password)) {
            login(username);
        } else {
            loginInvalid();
        }
    }
    
    public void logout() {
        theNavigationCntl = null;
        loginUi.setVisible(true);
    }
    
    public void login(String username){
        User selectedUser = theUserList.getUser(username);
        theNavigationCntl = new NavigationCntl(this, selectedUser);
        loginUi.setVisible(false);
    }
    
    public void loginInvalid() {
        System.out.println("Error Logging in with those credentials.");
        loginUi.displayLoginFailure();
    }
    
    /**
     * This method exits the program
     */
    public void exit() {
        System.exit(0);
    }
    
    public void signupBtnPressed() {
        newUserUi = new NewUserUI(this, userCntl);
        newUserUi.setSize(loginUi.getSize());
        newUserUi.setLocation(loginUi.getLocation());
        newUserUi.setVisible(true);
        newUserUi.requestFocus();
        userCntl.setNewUserUi(newUserUi);
        loginUi.setVisible(false);
    }
    
    public void closeNewUserUI() {
        if(newUserUi != null) {
            loginUi.setSize(newUserUi.getSize());
            loginUi.setLocation(newUserUi.getLocation());
            newUserUi.setVisible(false);
            newUserUi.dispose();
            newUserUi = null;
            loginUi.setVisible(true);
        } else {
            // Do Nothing
        }  
    }
    
    
}
