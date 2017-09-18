/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmoodv1;

import foodprofile.model.FoodList;
import foodprofile.model.FoodProfileModel;
import java.util.GregorianCalendar;
import moodprofile.model.MoodList;
import moodprofile.model.MoodProfileModel;
import userprofile.model.User;
/**
 *
 * @author HannahGarthwaite
 */
public class FoodMoodCntl {
    private FoodList foodList;
    private MoodList moodList;

    /**
     * This is the default constructor for FoodMoodCntl
     */  
    public FoodMoodCntl(User currentUser){
        
    }
    
    /**
     * This returns the FoodList for the current user
     * @return the foodList
     */
    public FoodList getFoodList() {
        return foodList;
    }

    /**
     * This sets the FoodList for the current user
     * @param foodList the foodList to set
     */
    public void setFoodList(FoodList foodList) {
        this.foodList = foodList;
    }
    
    /**
     * Adds a Food to the current user's FoodList
     * @param food 
     */
    public void addFood(FoodProfileModel food){
        
    }
    
    /**
     * This updates a food, using the id stored within the food class
     * @param food 
     */
    public void updateFood(FoodProfileModel food){
        
    }
    
    /**
     * This deletes the food from the current user's FoodList
     * @param foodID 
     */
    public void deleteFood(int foodID){
        
    }

    /**
     * This gets the MoodList for the current user
     * @return the moodList
     */
    public MoodList getMoodList() {
        return moodList;
    }

    /**
     * This sets the MoodList for the current user
     * @param moodList the moodList to set
     */
    public void setMoodList(MoodList moodList) {
        this.moodList = moodList;
    }
    
    /**
     * Adds a Mood to the current user's FoodList
     * @param mood 
     */
    public void addMood(MoodProfileModel mood){
        
    }
    
    /**
     * This updates a mood, using the id stored within the mood class. Also updates linkages
     * @param food 
     */
    public void updateMood(MoodProfileModel mood){
        
    }
    
    /**
     * This deletes the mood from the current user's MoodList
     * @param foodID 
     */
    public void deleteMood(int moodID){
        
    }
    
    /**
     * Links foods and moods based on the time the food was consumed
     * @param moodID the ID of the mood
     * @param time time the mood was entered
     */
    public void addLinkedFoodsToMood(int moodID, GregorianCalendar time){
        
    }
    
    /**
     * Deletes a mood from the current user's MoodList and the linkages of all foods it was linked to
     * @param mood 
     */
    public void deleteMood(MoodProfileModel mood){
        
    }

    /**
     * Updates all food mood links based on times
     */
    public void updateFoodMoodLinks(){
        
    }
    
    
}
