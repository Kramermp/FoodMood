/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import userprofile.view.LoginUI;
import userprofile.model.UserList;
import userprofile.model.User;
import userprofile.view.UserProfileUI;

/**
 *
 * @author Michael Kramer
 */
public class LoginCntl {
    private UserList theUserList = new UserList();
    private LoginUI childUI;
    private UserCntl userCntl;
    
    
    Connection theConnection = null;
    Statement theStatement = null;
    
    /**
     * Creates a LoginController
     */
    public LoginCntl() {
        createUserTable();
        readLogins();
        this.childUI = new LoginUI(this);
        this.childUI.setVisible(true);
        this.childUI.requestFocus();
    }
    
    /**
     * Compares the provided Username and Password to UserList to authenticate
     * the provided User credentials.
     * @param username the Username
     * @param password the Password
     */
    public boolean authenticateUserCredentials(String username, char[] password) {
        return theUserList.authenticateUserCredentials(username, password);
    }
    
    public void submitUserCredentials(String username, char[] password) {
        if(authenticateUserCredentials(username, password)) {
            login();
        } else {
            loginInvalid();
        }
    }
    
    public void login(){
        foodmood.controller.NavigationCntl theNavigationCntl = new foodmood.controller.NavigationCntl();
        
    }
    
    public void loginInvalid() {
        System.out.println("Error Loging in with those credentials.");
        childUI.displayLoginFailure();
    }
    
    public void signup() {
        userCntl = new UserCntl(theUserList);
        userCntl.registerNewUser();
    }
    
    /**
     * This method exits the program
     */
    public void exit() {
        System.exit(0);
    }
    
    public void createUserTable(){
        System.out.println("creating user table \n");
        try{
            Class.forName("org.sqlite.JDBC");
            theConnection = DriverManager.getConnection("jdbc:sqlite:foodmood.db");
            theStatement = theConnection.createStatement();
            
            String create = "CREATE TABLE IF NOT EXISTS login (username varchar, password varchar)";
            theStatement.executeUpdate(create);
            
            String delete = "DELETE FROM login WHERE username = 'User1';";
            theStatement.executeUpdate(delete);
            delete = "DELETE FROM login WHERE username = 'user1';";
            theStatement.executeUpdate(delete);
            
            String insert = "INSERT INTO login VALUES ('User1', 'password');";
            theStatement.executeUpdate(insert);
            
            theStatement.close();
            theConnection.close(); 
        } catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }
        
    public void readLogins(){
        System.out.println("Reading logins");
        try{
            Class.forName("org.sqlite.JDBC");
            theConnection = DriverManager.getConnection("jdbc:sqlite:foodmood.db");
            theStatement = theConnection.createStatement();
            
            ResultSet set = theStatement.executeQuery("SELECT * FROM login");
            ArrayList<User> users = new ArrayList();
            while(set.next()){
                String username = set.getString("username");
                char[] password = set.getString("password").toCharArray();
                System.out.println(username);
                for (int i = 0; i < password.length; i++) {
                    System.out.println(password[i]);
                }
                
                User user = new User(username, password);
                users.add(user);
            }
            theUserList = new UserList(users);
             
            theStatement.close();
            theConnection.close(); 
            
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        
        
    }
}
