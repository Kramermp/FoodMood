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
    private ArrayList<Mood> listOfMoods = 
            new ArrayList<Mood>();
    
    /**
     * Adds the provided MoodProfile to the MoodList
     * @param moodProfileToAdd the mood to add
     */
    public void addMoodProfile(Mood moodProfileToAdd) {
        System.err.println("This is a stub.");
        //TODO: Implment addMoodProfile
    }
    
    /**
     * Removes the provided MoodProfile from the MoodList
     * @param moodProfileToRemove the mood to remove
     */
    public void removeMoodProfile(Mood moodProfileToRemove) {
        System.err.println("This is a stub.");
        //TODO: Implment removeMoodProfile
    }
    
    /**
     * Checks if the MoodList contains the provided MoodProfile
     * @param moodProfile the profile to test food
     * @return boolean if it has the specified food
     */
    public boolean hasMoodProfile(Mood moodProfile) {
        System.err.println("This is a stub.");
        //TODO: Implment hasMoodProfile
        return false;
    }
    
    /**
     * Returns the size of the MoodList
     * @return the size of moodlist
     */
    public int size() {
        System.err.println("This is a stub.");
        //TODO: Implment size
        return 0;
    }
}
