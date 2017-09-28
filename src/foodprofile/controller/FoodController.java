/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodprofile.controller;

import foodprofile.model.FoodList;
import foodprofile.model.FoodProfileModel;
import userprofile.model.User;

/**
 *
 * @author Michael Kramer
 */
public class FoodController {

    private FoodList foodList;
        
    public FoodController(User currentUser){
        
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
     * @param food the food to add
     */
    public void addFood(FoodProfileModel food){
        
    }
    
    /**
     * This updates a food, using the id stored within the food class
     * @param food  the food to update
     */
    public void updateFood(FoodProfileModel food){
        
    }
    
    /**
     * This deletes the food from the current user's FoodList
     * @param foodID the food to delete
     */
    public void deleteFood(int foodID){
        
    }
    /**
     * Updates all food mood links based on times
     */
    public void updateFoodMoodLinks(){
        
    }
    
}
