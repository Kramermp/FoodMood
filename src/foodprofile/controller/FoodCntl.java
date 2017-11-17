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
import foodprofile.view.FoodListUIOLD;
import foodprofile.view.FoodUI;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import userprofile.model.User;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Michael Kramer
 */
public class FoodCntl {

    private FoodList foodList;
    private Connection theConnection = null;
    private Statement theStatement = null;
    private FoodListUIOLD foodListUI;
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
            System.out.println("list null");
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
    
    public void updateFood(FoodUI foodUi) {
        this.foodList.updateFood(selectedFood, getFoodUIFood(foodUi));
    }
    
    public void goListView(){
        foodListUI = new FoodListUIOLD(this);
        foodListUI.setVisible(true);
    }
    
    public void addFood(FoodUI foodUi) {
        foodList.addFood(getFoodUIFood(foodUi));
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
    /**
     * Updates all food mood links based on times
     */
    public void updateFoodMoodLinks(){
        
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
    
    public void requestListView() {
        navigationCntl.goToScreen(NavigationCntl.ScreenOption.FOODLIST);
    }

    public void requestHomeView() {
        navigationCntl.goToScreen(NavigationCntl.ScreenOption.HOME);
    }
    
    public void requestFoodView() {
        navigationCntl.goToScreen(NavigationCntl.ScreenOption.FOOD);
    }
    
    public void requestExtendedFoodView() {
        navigationCntl.goToScreen(NavigationCntl.ScreenOption.EXTENDEDFOOD);
    }
}
