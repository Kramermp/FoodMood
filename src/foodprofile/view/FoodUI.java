/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodprofile.view;

import foodprofile.controller.FoodController;
import foodprofile.model.FoodProfileModel;

/**
 *
 * @author mpk5206
 */
public class FoodUI {
    private FoodProfileModel theFoodProfileModel;
    
    /**
     * Default Constructor for empty FoodView
     */
    public FoodUI(FoodController parentController) {
       System.err.println("This is a stub.");
        //TODO: Implment FoodView 
    }
    
    /**
     * Creates a FoodView of the provided FoodProfile
     * @param foodProfile 
     */
    public FoodUI(FoodController parentController, 
            FoodProfileModel foodProfile) {
        System.err.println("This is a stub.");
        //TODO: Implment FoodView
    }
    
    
    private void submitFoodProfile() {
        
    }   
    
    private void exit() {
        
    }
}
