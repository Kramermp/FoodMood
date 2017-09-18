/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import userprofile.model.*;
import moodprofile.model.*;
import foodprofile.model.*;

/**
 *
 * @author HannahGarthwaite
 */
public class ExternalDataCntl {
    UserList userList;
    FoodList foodList;
    MoodList moodList;
    
    
    /**
     * Default constructor for ExternalDataCntl
     */
    public ExternalDataCntl(){
        
    }
    
    /**
     * Reads the food list from the database
     * @return foodlist
     */
    public FoodList readFoodList(){
        return null;
    }
    
    /**
     * Reads the mood list form the database
     * @return moodlist
     */
    public MoodList readMoodList(){
        return null;
    }
    
    /**
     * Reads the user list from the database
     * @return userlist
     */
    public UserList readUserList(){
        return null;
    }
    
    /**
     * Writes the list of all foods consumed
     * @param foodList 
     */
    public void writeFoodList(FoodList foodList){
        
    }
    
    /**
     * Adds a single food to the database
     * @param food 
     */
    public void writeSingleFood(FoodProfileModel food){
        
    }
    
    /**
     * Writes the list of moods to the database
     * @param moodList 
     */
    public void writeMoodList(MoodList moodList){
        
    }
    
    /**
     * Writes a single mood to the database
     * @param mood
     */
    public void writeSingleMood(MoodProfileModel mood){
        
    }
    
    /**
     * Writes the userList to the database
     * @para userList
     */
    public void writeUserList(UserList userList){
        
    }
    
    /**
     * Writes a single user to the database
     * @param user 
     */
    public void writeSingleUser(User user){
        
    }
    
    
}
