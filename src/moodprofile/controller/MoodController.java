/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodprofile.controller;

import java.util.GregorianCalendar;
import moodprofile.model.MoodList;
import moodprofile.model.MoodProfileModel;
import userprofile.model.User;

/**
 *
 * @author Michael Kramer
 */
public class MoodController {
    private MoodList moodList;
    
    public MoodController(User currentUser){
        
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
     * @param mood the mood to add
     */
    public void addMood(MoodProfileModel mood){
        
    }
    
    /**
     * This updates a mood, using the id stored within the mood class. Also updates linkages
     * @param mood the mood to update
     */
    public void updateMood(MoodProfileModel mood){
        
    }
    
    /**
     * This deletes the mood from the current user's MoodList
     * @param moodID the mood to delete
     */
    public void deleteMood(int moodID){
        
    }
    /**
     * Deletes a mood from the current user's MoodList and the linkages of all foods it was linked to
     * @param mood the mood to delete
     */
    public void deleteMood(MoodProfileModel mood){
        
    }
    /**
     * Links foods and moods based on the time the food was consumed
     * @param moodID the ID of the mood
     * @param time time the mood was entered
     */
    public void addLinkedFoodsToMood(int moodID, GregorianCalendar time){
        
    }
}
