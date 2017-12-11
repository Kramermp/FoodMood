/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodprofile.controller;

import externaldata.controller.ExternalDataCntl;
import foodmood.analytic.NavigationCntl;
import foodprofile.model.FoodList;
import foodprofile.model.Food;
import foodprofile.view.FoodUI;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import userprofile.User;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.GregorianCalendar;
import moodprofile.controller.MoodCntl;

/**
 *
 * @author Michael Kramer
 */
public class FoodCntl {

    private FoodList foodList;
    private Connection theConnection = null;
    private Statement theStatement = null;
    private NavigationCntl navigationCntl;
    private Food selectedFood;
        
    public FoodCntl(NavigationCntl navigationCntl) {
        this.navigationCntl = navigationCntl;
        this.foodList = navigationCntl.getActiveUser().getFoodList();
    }
        
    /**
     * sort list chronologically, return date of the last
     * @return Date of last food
     */
    public Date getDateOfLastFood(){
        foodList.sortByDate();
        if(foodList.size() > 0){
            return foodList.getFood(foodList.size()-1).getTime().getTime();
        }else{
            return new Date();
        }
    }
    
     /**
     * This returns the FoodList for the current user
     * @return the foodList
     */
    public FoodList getFoodList() {
        return this.foodList;
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
        if(food.getID() == 0){
            food.setID(foodList.getNewID());
        }
        this.foodList.addFood(food);
    }
    
    
    public void updateFood(FoodUI foodUi) {
        this.foodList.updateFood(selectedFood, getFoodUIFood(foodUi));
    }
    
    
    public void addFood(FoodUI foodUi) {
        Food food = getFoodUIFood(foodUi);
        food.setID(foodList.getNewID());
        foodList.addFood(food);
    }
    
    private Food getFoodUIFood(FoodUI foodUi) {
        return new Food(foodUi.getFoodName(), foodUi.getFoodCategory(),
                foodUi.getTime());
    }
     
    /**
     * This deletes the food from the current user's FoodList
     * @param foodID the food to delete
     */
    public void deleteFood(Food food){
        foodList.removeFood(food);
    }
    
    public void setSelectedFood(Food foodToSelect) {
        this.selectedFood = foodToSelect;
    }
    
    public Food getSelectedFood() {
        return this.selectedFood;
    }
    
    public void deleteSelectedFood() {
        this.foodList.removeFood(selectedFood);
        selectedFood = null;
    }
    
    public void requestHomeView() {
        navigationCntl.goToScreen(NavigationCntl.ScreenOption.HOME);
    }
    
    public ArrayList<Integer> linkFoods(GregorianCalendar moodTime, int moodID, MoodCntl moodCntl){
        return foodList.linkFoods(moodTime, moodID);
    }
}
