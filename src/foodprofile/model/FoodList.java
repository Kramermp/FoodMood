/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodprofile.model;

import java.util.ArrayList;

/**
 *
 * @author Michael Kramer
 */
public class FoodList {
    private ArrayList<FoodProfileModel> listOfFoods = 
            new ArrayList<FoodProfileModel>();  
    
    /**
     * Adds the provide FoodProfile to the FoodList
     * @param foodToAdd the foodToAdd 
     */
    public void addFoodProfile(FoodProfileModel foodToAdd) {
        System.err.println("This is a stub.");
        //TODO: Implment addFoodProfile
    }
    
    /**
     * Removes the provided from the FoodList
     * @param foodToRemove 
     */
    public void removeFoodProfile(FoodProfileModel foodToRemove) {
        System.err.println("This is a stub.");
        //TODO: Implment removeFoodProfile
    }
    
    /**
     * Checks if the FoodList contains the provided FoodProfile
     * @param foodProfile
     * @return 
     */
    public boolean hasFoodProfile(FoodProfileModel foodProfile) {
        System.err.println("This is a stub.");
        //TODO: Implment hasFoodProfile
        return false;
    }
    
    /**
     * Returns the size of the FoodList
     * @return 
     */
    public int size() {
        System.err.println("This is a stub.");
        //TODO: Implment size;
        return 0;
    }
}
