/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testharness;

import foodprofile.model.FoodList;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import moodprofile.model.MoodList;
import notificationprofile.model.NotificationList;
import userprofile.model.User;

/**
 * This class is the TestHarness for the just the User model class and can be
 * used to test all of the User Class's methods.
 * 
 * @author Michael Kramer
 * @version .1
 * @since.1
 */
public class UserTestHarness {
    private static int errorCount = 0;
    
    public static void run() {
        System.out.println("Running the User Test Harness.");
        testConstructors();
        testAccessors();
        testMutators();
        testMethods();
    }
    
    private static void testConstructors() {
        System.out.println("Testing the User Class's constructors.");
        User testUser = new User();
        if(testUser != null){
            System.out.println("The Default constructor successfully created"
                + " the User object.");
        } else {
            System.err.println("The default constructor failed to create the"
                + " the User object.");
            errorCount++;
        }
        
        String testUsername = "Test User";
        char[] testPassword = "Password".toCharArray();
        testUser = new User(testUsername, testPassword);
        if(testUser != null) {
            System.out.println("The User(String, char[]) constructor"
                    + " successfully created the User object.");
            try {
                Class userClass = testUser.getClass();
                Field usernameField = userClass.getDeclaredField("username");
                usernameField.setAccessible(true);
                Field passwordField = userClass.getDeclaredField("password");
                passwordField.setAccessible(true);
                String detectedUsername = (String) usernameField.get(testUser);
                char[] detectedPassword = (char[]) passwordField.get(testUser);
                //You actually want to compare using == because we are expecting
                //These to be the exact same object aka sharing the same memory
                //Address and not just equals
                if(testUsername == detectedUsername) {
                    System.out.println("The User(String, char[]) constructor"
                        + " successfully assigned the Username.");
                } else {
                    System.err.println("The User(String, char[]) constructor"
                        + " failed to properly assign the Username \n"
                        + " Expected:" + testUsername + "\n"
                        + " Found:" + detectedUsername);
                    errorCount++;
                }
                //You actually want to compare using == because we are expecting
                //These to be the exact same object aka sharing the same memory
                //Address and not just equals
                if(testPassword == detectedPassword) {
                    System.out.println("The User(String, char[]) constructor"
                        + " successfully assigned the password.");
                } else {
                    System.err.println("The User(String, char[]) constructor"
                        + " failed to properly assign the password \n"
                        + " Expected:" + testPassword.toString() + "\n"
                        + " Found:" + detectedPassword.toString());
                    errorCount++;
                }
            } catch (NoSuchFieldException e) {
                System.err.println("Error During User(String, char[])");
                System.err.println(e.getMessage());
                errorCount++;
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                System.err.println("Error During User(String, char[]) \n"
                    + ex.getMessage());
                errorCount++;
            }
        } else {
            System.out.println("The User(String, char[]) constructor"
                    + " failed to create the User object.");
        }
    }
    
    private static void testAccessors() {
        String testUsername = "Test User";
        char[] testPassword = "Password".toCharArray();
        User testUser = new User(testUsername, testPassword);
        try {
            //Test getUsername
            Class userClass = testUser.getClass();
            Field usernameField = userClass.getDeclaredField("username");
            usernameField.setAccessible(true);
            String detectedUsername = (String) usernameField.get(testUser);
            //You actually want to use == this is not a mistake
            if(testUser.getUsername() == detectedUsername) {
                System.out.println("The method User.getUsername() successfully"
                    + " retrieved the Username");
            } else {
                System.err.println("The method User.getUsername() failed to"
                    + " properly retrieve the Username \n"
                    + " Expected:" + testUsername + "\n"
                    + " Found:" + detectedUsername);
                errorCount++;
            }
            
            //Tests getPassword
            Field passwordField = userClass.getDeclaredField("password");
            passwordField.setAccessible(true);
            char[] detectedPassword = (char[]) passwordField.get(testUser);
            //You actually want to use == this is not a mistake
            if(testUser.getPassword() == detectedPassword) {
                System.out.println("The method User.getPassword() successfully"
                    + " retrieved the password.");
            } else {
                System.err.println("The method User.getPassword() failed to"
                    + " properly retrieve the password \n"
                    + " Expected:" + Arrays.toString(testPassword) + "\n"
                    + " Found:" + Arrays.toString(detectedPassword));
                errorCount++;
            }
            
            //Tests getFoodList()
            Field foodListField = userClass.getDeclaredField("usersFoodList");
            foodListField.setAccessible(true);
            FoodList detectedFoodList= (FoodList) foodListField.get(testUser);
            //You actually want to use == this is not a mistake
            if(testUser.getFoodList() == detectedFoodList) {
                System.out.println("The method User.getFoodList() successfully"
                    + " retrieved the usersFoodList.");
            } else {
                System.err.println("The method User.getFoodList() failed to"
                    + " properly retrieve the usersFoodList");
                errorCount++;
            }
            
            //Tests getMoodList()
            Field moodListField = userClass.getDeclaredField("usersMoodList");
            moodListField.setAccessible(true);
            MoodList detectedMoodList= (MoodList) moodListField.get(testUser);
            //You actually want to use == this is not a mistake
            if(testUser.getMoodList() == detectedMoodList) {
                System.out.println("The method User.getMoodList() successfully"
                    + " retrieved the usersFoodList.");
            } else {
                System.err.println("The method User.getMoodList() failed to"
                    + " properly retrieve the usersFoodList");
                errorCount++;
            }
            
            //Test getNotficationList()
            Field notificationListField = userClass.getDeclaredField("usersNotificationList");
            notificationListField.setAccessible(true);
            NotificationList detectedNotificationList = (NotificationList) notificationListField.get(testUser);
            //You actually want to use == this is not a mistake
            if(testUser.getNotificationList() == detectedNotificationList) {
                System.out.println("The method User.getNotificaitonList() successfully"
                    + " retrieved the usersFoodList.");
            } else {
                System.err.println("The method User.getNotificationList() failed to"
                    + " properly retrieve the usersFoodList");
                errorCount++;
            }
              
        } catch (NoSuchFieldException e) {
            System.err.println("Error while testing the User Accessors. \n"
                + e.getMessage());
            errorCount++;
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            System.err.println("Error whilte testing the User Accessors. \n"
                + ex.getMessage());
            errorCount++;
        }
        
    }
    
    private static void testMutators() {
        String testUsername = "Test User";
        char[] testPassword = "Password".toCharArray();
        User testUser = new User(testUsername, testPassword);
        try {
            //Test setUsername()    
            String newUsername = "New Username";
            testUser.setUsername(newUsername);
            Class userClass = testUser.getClass();
            Field usernameField = userClass.getDeclaredField("username");
            usernameField.setAccessible(true);
            String detectedUsername = (String) usernameField.get(testUser);
            //You actually want to use == this is not a mistake
            if(detectedUsername == newUsername) {
                System.out.println("The method User.setUsername() successfully"
                    + " modified the Username");
            } else {
                System.err.println("The method User.setUsername() failed to "
                    + " modify the Username \n"
                    + "Expected:" + newUsername + "\n"
                    + "Found: " + detectedUsername);
            }
            
            //Tests setPassword()
            char[] newPassword = "New Password".toCharArray();
            testUser.setPassword(newPassword);
            Field passwordField = userClass.getDeclaredField("password");
            passwordField.setAccessible(true); 
            char[] detectedPassword = (char[]) passwordField.get(testUser);
            //You actually want to use == this is not a mistake
            if(detectedPassword == newPassword) {
                System.out.println("The method User.setPassword() successfully"
                    + " modified the password.");
            } else {
                System.err.println("The method User.setPassword() failed to"
                    + " properly modify the password \n"
                    + "Expected:" + Arrays.toString(newPassword) + "\n"
                    + "Found:" + Arrays.toString(detectedPassword));
            }
            
            //Tests setFoodList()
            Field foodListField = userClass.getDeclaredField("usersFoodList");
            foodListField.setAccessible(true);
            FoodList newFoodList = new FoodList();
            testUser.setFoodList(newFoodList);
            FoodList detectedFoodList= (FoodList) foodListField.get(testUser);
            //You actually want to use == this is not a mistake
            if(detectedFoodList == newFoodList) {
                System.out.println("The method User.setFoodList() successfully"
                    + " modified the usersFoodList.");
            } else {
                System.err.println("The method User.setFoodList() failed to"
                    + " properly modify the usersFoodList");
            }
            
            //Tests setMoodList()
            Field moodListField = userClass.getDeclaredField("usersMoodList");
            moodListField.setAccessible(true);
            MoodList newMoodList = new MoodList();
            testUser.setMoodList(newMoodList);
            MoodList detectedMoodList= (MoodList) moodListField.get(testUser);
            //You actually want to use == this is not a mistake
            if(detectedMoodList == newMoodList) {
                System.out.println("The method User.getMoodList() successfully"
                    + " retrieved the usersMoodList.");
            } else {
                System.err.println("The method User.getMoodList() failed to"
                    + " properly retrieve the usersMoodList");
            }
            
            //Test setNotficationList()
            Field notificationListField = userClass.getDeclaredField("usersNotificationList");
            notificationListField.setAccessible(true);
            NotificationList newNotificationList = new NotificationList();
            testUser.setNotificationList(newNotificationList);
            NotificationList detectedNotificationList = (NotificationList) notificationListField.get(testUser);
            //You actually want to use == this is not a mistake
            if(detectedNotificationList == newNotificationList) {
                System.out.println("The method User.setNotificaitonList() successfully"
                    + " modified the usersNotificationList.");
            } else {
                System.err.println("The method User.setNotificationList() failed to"
                    + " properly modify the userNotificationList");
            }
              
        } catch (NoSuchFieldException e) {
            System.err.println("Error while testing User accessors. \n"
                + e.getMessage());
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            
        }
    }
    
    private static void testMethods() {
        //Test authenticate
        String testUsername = "Test User";
        char[] testPassword = "Password".toCharArray();
        User testUser = new User(testUsername, testPassword);
        if(testUser.authenticate(testUsername, testPassword)) {
            System.out.println("The method user.authenticate(String, char[])"
                + " successfully authenticated the user's credentials");
        } else {
            System.err.println("The method user.authenticate(String, char[])"
                + " failed to authenticate the user's credentials");
        }
        
        if(!testUser.authenticate("WrongName", testPassword)) {
            System.out.println("The method user.authenticate(String, char[])"
                + " successfully rejected the user credentials when the"
                + " username did not match but the password did");
        } else {
            System.err.println("The method user.authenticate(String, char[])"
                + " failed to reject the user credentials when the username did"
                + " not match, but the password did.");
        }
        
        if(!testUser.authenticate(testUsername, "WrongPass".toCharArray())) {
            System.out.println("The method user.authenticate(String, char[])"
                + " successfully reject the user credentials when the username"
                + " matched but the password did not match.");
        } else {
            System.out.println("The method user.authenticate(String, char[])"
                + " failed to reject the user credentials when the username"
                + " matched but the password did not match.");
        }
        
        if(!testUser.authenticate("WrongName", "WrongPass".toCharArray())){
            System.out.println("The method user.authenticate(String, char[])"
                + " successfully rejected the user credentials when neither"
                + " the username nor the password matched."); 
        } else {
            System.out.println("The method user.authenticate(String, char[])"
                + " failed to reject the user credentials when neither"
                + " the username nor the password matched."); 
        }
    }
    
}
