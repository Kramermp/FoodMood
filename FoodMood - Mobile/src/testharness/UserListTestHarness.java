/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testharness;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import userprofile.model.User;
import userprofile.model.UserList;

/**
 *
 * @author Michael Kramer
 */
public class UserListTestHarness {
    private static int errorCount = 0;
    
    public static void run() {
        testConstructors();
        testAccessors();
        testMutators();
        testMethods();
        
        System.out.println("The UserListTestHarness completed with " + errorCount
            + " errors.");
    }
    
    private static void testConstructors() {
        System.out.println("Testing UserList Constructors");
        UserList testUserList = UserList.createTestUserList();
        if(testUserList != null) {
            System.out.println("The Default UserList Constructor successfully"
                + " created ther UserList object.");
        } else {
            System.err.println("The Default UserList Constructor failed to"
                + " create the UserList object.");
            errorCount++;
        }
    }
    
    private static void testAccessors() {
  
        UserList testUserList = UserList.createTestUserList();
        
        try {
            //Test getUserCount
            Class userListClass = testUserList.getClass();
            Field userListField = userListClass.getDeclaredField("theListOfUsers");
            userListField.setAccessible(true);
            ArrayList<User> detectedListOfUsers = (ArrayList<User>) userListField.get(testUserList);
            
            if(testUserList.getUserCount() == detectedListOfUsers.size()) {
                System.out.println("The method UserList.getUserCount()" 
                    + " successfully retrieved the user count.");
            } else {
                System.err.println("The method UserList.getUserCount() failed"
                    + "to retrieve the user count.");
                errorCount++;
            }
            
            //Test getUser
            User testUser = new User("Test User", "Password".toCharArray());
            detectedListOfUsers.add(testUser);
            //This should use == this is not a mistake
            if(testUserList.getUser("Test User") == testUser) {
                System.out.println("The method UserList.getUser(String)"
                    + " successfully retrieved the user.");
            } else {
                System.err.println("The method UserList.getUser(String) failed"
                    + " to retrieve the user.");
                errorCount++;
            }  
            
        } catch (NoSuchFieldException | SecurityException ex) {
            System.err.println("Error while testing UserList Accessors. \n"
                + ex.getMessage());
            errorCount++;
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            System.err.println("Error while testing UserList Accessors. \n"
                + ex.getMessage());
            errorCount++;
        }
    }
    
    private static void testMutators() {
        UserList testUserList = UserList.createTestUserList();
        
         try {
            Class userListClass = testUserList.getClass();
            Field userListField = userListClass.getDeclaredField("theListOfUsers");
            userListField.setAccessible(true);
            ArrayList<User> detectedListOfUsers = (ArrayList<User>) userListField.get(testUserList);
            
            //Test AddUser
            String testUsername = "Test User";
            char[] testPassword = "Password".toCharArray();
            testUserList.addUser(testUsername, testPassword);
            User expectedUser = new User (testUsername, testPassword);
            for(int i = 0; i < detectedListOfUsers.size(); i++) {
                if(detectedListOfUsers.get(i).equals(expectedUser)) {
                    System.out.println("The method UserList.addUser(String, char[])" 
                            + " successfully added the expectedUser.");
                    break;
                }
                //If it is at last element
                if(i == detectedListOfUsers.size() - 1) {
                    System.err.println("The method UserList.addUser(String, char[])"
                            + " failed to add the expectedUser.");
                    errorCount++;
                }
            }
            
            //Test deleteUser
            testUsername = "Other User";
            testPassword = "Password".toCharArray();
            detectedListOfUsers.add(new User(testUsername, testPassword));
            testUserList.deleteUser(testUsername, testPassword);
            for(int i = 0; i < detectedListOfUsers.size(); i++) {
                if(detectedListOfUsers.get(i).equals(expectedUser)) {
                    System.err.println("The method UserList.deleteUser(String, char[])" 
                            + " failed to remove the User.");
                    errorCount++;
                    break;
                }
                //If it is at last element
                if(i == detectedListOfUsers.size() - 1) {
                    System.out.println("The method UserList.deleteUser(String, char[])"
                            + " successfully removed the expectedUser.");
                }
            }     
            
        } catch (NoSuchFieldException | SecurityException ex) {
            System.err.println("Error while testing UserList mutators \n"
                + ex.getMessage());
            errorCount++;
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            System.err.println("Error while testing UserList mutators \n"
                + ex.getMessage());
            errorCount++;
        }
    }
    
    private static void testMethods() {
        UserList testUserList = UserList.createTestUserList();
        
        try {
            Class userListClass = testUserList.getClass();
            Field userListField = userListClass.getDeclaredField("theListOfUsers");
            userListField.setAccessible(true);
            ArrayList<User> detectedListOfUsers = (ArrayList<User>) userListField.get(testUserList);
            
            //Test hasUser
            String testUsername = "Test User";
            char[] testPassword = "Password".toCharArray();
            detectedListOfUsers.add(new User(testUsername, testPassword));
            if(testUserList.hasUser(testUsername)) {
                System.out.println("The method UserList.hasUser(String)"
                    + " successfully detected the user.");
            } else {
                System.err.println("The method UserList.hasUser(String)"
                    + " failed to detect the user.");
                errorCount++;
            }
            
            //Test authenticateUserCredentials(String, char[])
            testUsername = "Other Test User";
            testPassword = "Password".toCharArray();
            detectedListOfUsers.add(new User(testUsername, testPassword));
            if(testUserList.authenticateUserCredentials(testUsername, testPassword)) {
                System.out.println("The method UserList.authenticateUserCredentials(String, char[])"
                        + " successfully authenticated the user credentials.");
            } else {
                System.err.println("The method UserList.authenticateUserCredentials(Stringm char[])"
                        + " failed to authenticate the user credentials.");
                errorCount++;
            }
            
        } catch (NoSuchFieldException | SecurityException ex) {
            System.err.println("Error while testing UserList mutators \n"
                + ex.getMessage());
            errorCount++;
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            System.err.println("Error while testing UserList mutators \n"
                + ex.getMessage());
            errorCount++;
        }
    }
}
