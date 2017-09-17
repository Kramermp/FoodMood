/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodprofile.model;

import java.util.ArrayList;

/**
 *
 * @author Micahel Kramer
 */
public class MoodList {
    private ArrayList<MoodProfileModel> listOfMoods = 
            new ArrayList<MoodProfileModel>();
    
    /**
     * Adds the provided MoodProfile to the MoodList
     * @param moodProfileToAdd 
     */
    public void addMoodProfile(MoodProfileModel moodProfileToAdd) {
        System.err.println("This is a stub.");
        //TODO: Implment addMoodProfile
    }
    
    /**
     * Removes the provided MoodProfile from the MoodList
     * @param moodProfileToRemove 
     */
    public void removeMoodProfile(MoodProfileModel moodProfileToRemove) {
        System.err.println("This is a stub.");
        //TODO: Implment removeMoodProfile
    }
    
    /**
     * Checks if the MoodList contains the provided MoodProfile
     * @param moodProfile
     * @return 
     */
    public boolean hasMoodProfile(MoodProfileModel moodProfile) {
        System.err.println("This is a stub.");
        //TODO: Implment hasMoodProfile
        return false;
    }
    
    /**
     * Returns the size of the MoodList
     * @return 
     */
    public int size() {
        System.err.println("This is a stub.");
        //TODO: Implment size
        return 0;
    }
}
