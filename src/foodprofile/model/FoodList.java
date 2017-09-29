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
    private ArrayList<Food> listOfFoods = 
            new ArrayList<Food>();  
    
    /**
     * Adds the provide FoodProfile to the FoodList
     * @param foodToAdd the foodToAdd 
     */
    public void addFoodProfile(Food foodToAdd) {
        System.err.println("This is a stub.");
        //TODO: Implment addFoodProfile
    }
    
    /**
     * Removes the provided from the FoodList
     * @param foodToRemove Food to be removed from the FoodList
     */
    public void removeFoodProfile(Food foodToRemove) {
        System.err.println("This is a stub.");
        //TODO: Implment removeFoodProfile
    }
    
    /**
     * Checks if the FoodList contains the provided FoodProfile
     * @param foodProfile the Food to check for
     * @return the food to check for
     */
    public boolean hasFoodProfile(Food foodProfile) {
        System.err.println("This is a stub.");
        //TODO: Implment hasFoodProfile
        return false;
    }
    
    /**
     * Returns the size of the FoodList
     * @return the size of the FoodList
     */
    public int size() {
        System.err.println("This is a stub.");
        //TODO: Implment size;
        return 0;
    }
}
