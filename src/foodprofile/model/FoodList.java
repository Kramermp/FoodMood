/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodprofile.model;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Michael Kramer
 */
public class FoodList {
    private ArrayList<Food> listOfFoods = new ArrayList<Food>();  

    
    /**
     * Default Constructor
     */
    public FoodList() {
        System.out.println("TODO foodList");
        
    }
    
    public void updateFood(Food toUpdate){
        for (int i = 0; i < listOfFoods.size(); i++) {
            if(listOfFoods.get(i).getID() == toUpdate.getID()){
                listOfFoods.set(i, toUpdate);
            }
        }
    }
    
    public FoodList(ArrayList<Food> foods){
        this.listOfFoods = foods;
    }
    
    /**
     * Adds the provide FoodProfile to the FoodList
     * @param foodToAdd the foodToAdd 
     */
    public void addFood(Food foodToAdd) {
        System.out.println("TODO add food");
    }
    
    /**
     * Removes the provided from the FoodList
     * @param foodToRemove Food to be removed from the FoodList
     */
    public void removeFood(Food foodToRemove) {
        for (int i = 0; i < listOfFoods.size(); i++) {
            if(listOfFoods.get(i).getID() == foodToRemove.getID()){
                listOfFoods.remove(i);
            }
        }
        System.out.println("TODO remove food");
    }
    
    /**
     * Checks if the FoodList contains the provided FoodProfile
     * @param foodProfile the Food to check for
     * @return the food to check for
     */
    public boolean hasFood(Food foodProfile) {
        System.err.println("This is a stub.");
        //TODO: Implment hasFoodProfile
        return false;
    }
    
    /**
     * Returns the size of the FoodList
     * @return the size of the FoodList
     */
    public int size() {
        return listOfFoods.size();
    }
    
    public Food getFood(int i){
        if(i>=listOfFoods.size()){
            i = listOfFoods.size();
        }
        return listOfFoods.get(i);
    }
}
