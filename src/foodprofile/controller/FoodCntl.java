/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodprofile.controller;

import foodprofile.model.FoodList;
import foodprofile.model.Food;
import foodprofile.view.FoodUI;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import userprofile.model.User;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Michael Kramer
 */
public class FoodCntl {

    private FoodList foodList;
    private Connection theConnection = null;
    private Statement theStatement = null;
        
    public FoodCntl(User currentUser){
        
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
    public void addFood(Food food){
        this.foodList.addFood(food);
    }
    
    /**
     * This updates a food, using the id stored within the food class
     * @param food  the food to update
     */
    public void updateFood(Food food){
        //this.foodList.updateFood(food);
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
    
    
    public void readFoods(){
        System.out.println("Reading foods");
        try{
            Class.forName("org.sqlite.JDBC");
            theConnection = DriverManager.getConnection("jdbc:sqlite:foodmood.db");
            theStatement = theConnection.createStatement();
            
            ResultSet set = theStatement.executeQuery("SELECT * FROM food");
            ArrayList<Food> foods = new ArrayList();
            while(set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                Food food = new Food();
                food.setID(id);
                food.setName(name);
                foods.add(food);
            }
            foodList = new FoodList(foods);
             
            theStatement.close();
            theConnection.close(); 
            
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        
        
    }
    
}
