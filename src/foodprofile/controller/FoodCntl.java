/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodprofile.controller;

import externaldata.controller.ExternalDataCntl;
import foodmood.controller.NavigationCntl;
import foodprofile.model.FoodList;
import foodprofile.model.Food;
import foodprofile.view.FoodListUI;
import foodprofile.view.FoodUI;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import userprofile.model.User;
import java.sql.Connection;
import java.sql.Statement;
import java.util.GregorianCalendar;

/**
 *
 * @author Michael Kramer
 */
public class FoodCntl {

    private FoodList foodList;
    private Connection theConnection = null;
    private Statement theStatement = null;
    private FoodListUI foodListUI;
    private NavigationCntl navigationCntl;
        
    public FoodCntl(NavigationCntl navigationCntl, User currentUser){
        this.navigationCntl = navigationCntl;
        foodList = ExternalDataCntl.getExternalDataCntl().getFoodList();
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
    
    
    
    public void viewFood(Food food){
        FoodUI foodUI = new FoodUI(this, food);
        foodUI.setVisible(true);
    }
    
    public void newFood(){
        FoodUI foodUI = new FoodUI(this);
        foodUI.setVisible(true);
    }

    /**
     * Adds a Food to the current user's FoodList when food exists
     * @param food the food to add
     */
    public void addFood(Food food){
        this.foodList.addFood(food);
    }
    
    /**
     * creates a food and adds it to the list
     * @param name name of the food
     * @param foodCategory name or csv list of names of food categories
     * @param time the time the food was entered
     */
    public void addFood(String name, String foodCategory, GregorianCalendar time){
        if(foodList == null){
            foodList = ExternalDataCntl.getExternalDataCntl().getFoodList();
        }
        int id;
        if(foodList.size() == 0){
            id = 1;
        }else{
            id = foodList.getFood(foodList.size()-1).getID()+1;
        }
        Food theFood = new Food(id, name, foodCategory, time);
        foodList.addFood(theFood);
        System.out.println("Food created: "+theFood.getName()+" "+theFood.getTime().getTime().getMonth()+"/"+theFood.getTime().getTime().getDate());
        System.out.println(foodList.size());
    }
    
    /**
     * This updates a food, using the id stored within the food class
     * @param food  the food to update
     */
    public void updateFood(Food food){
        this.foodList.updateFood(food);
    }
    
    public void goListView(){
        foodListUI = new FoodListUI(this);
        foodListUI.setVisible(true); 
    }
    
     
    /**
     * This deletes the food from the current user's FoodList
     * @param foodID the food to delete
     */
    public void deleteFood(Food food){
        foodList.removeFood(food);
    }
    /**
     * Updates all food mood links based on times
     */
    public void updateFoodMoodLinks(){
        
    }
    
    public void goHome(){
        navigationCntl.goHomeScreen();
    }    
}
