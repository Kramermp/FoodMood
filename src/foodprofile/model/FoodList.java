/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodprofile.model;

import externaldata.controller.ExternalDataCntl;
import java.io.Serializable;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.GregorianCalendar;

/**
 *
 * @author Michael Kramer
 */
public class FoodList implements Serializable {
    private ArrayList<Food> listOfFoods = new ArrayList<Food>();  

    
    /**
     * Creates FoodList without an existing list of foods
     * Default Constructor
     */
    public FoodList() {
        listOfFoods = new ArrayList();
    }
    
    
    /**
     * Creates FoodList with an existing arrayList of foods
     * @param foods ArrayList of food
     */
    public FoodList(ArrayList<Food> foods){
        this.listOfFoods = foods;
    }
    
    /**
     * Adds the provide FoodProfile to the FoodList
     * @param foodToAdd the foodToAdd 
     */
    public void addFood(Food foodToAdd) {
        this.listOfFoods.add(foodToAdd);
        ExternalDataCntl.getExternalDataCntl().writeSerializedData();
    }
    
    /**
     * Takes a food, finds it in the list based on the ID and updates it in the list
     * @param toUpdate the food that is to be updated
     */
    public void updateFood(Food originalFood, Food newFood){
        for (int i = 0; i < listOfFoods.size(); i++) {
            if(listOfFoods.get(i) == originalFood){
                listOfFoods.set(i, newFood);
            }
        }
        ExternalDataCntl.getExternalDataCntl().writeSerializedData();
    }
    /**
     * Removes the provided from the FoodList
     * @param foodToRemove Food to be removed from the FoodList
     */
    public void removeFood(Food foodToRemove) {
        for (int i = 0; i < listOfFoods.size(); i++) {
            if(listOfFoods.get(i) == foodToRemove){
               listOfFoods.remove(i);
            }
        }
        ExternalDataCntl.getExternalDataCntl().writeSerializedData();
    }
    
    /**
     * Checks if the FoodList contains the provided FoodProfile
     * @param foodProfile the Food to check for
     * @return the food to check for
     */
    public boolean hasFood(Food foodProfile) {
        //I'm not sure if this actually works
        System.err.println("I'm not sure if this would actually work.");
        return (this.listOfFoods.contains(foodProfile));
    }
    
    /**
     * Returns the size of the FoodList
     * @return the size of the FoodList
     */
    public int size() {
        return listOfFoods.size();
    }
    
    /**
     * Returns a Food given its index in the list
     * @param i the index
     * @return 
     */
    public Food getFood(int i){
        if(i>=listOfFoods.size()){
            i = listOfFoods.size();
        }
        return listOfFoods.get(i);
    }
    
    /**
     * sorts the FoodList by date
     */
    public void sortByDate(){
        Food temp; 
        
        for (int i = 0; i < listOfFoods.size()-1; i++) {
            for (int j = 0; j < listOfFoods.size()-i-1; j++) {
                if(listOfFoods.get(j+1) != null && listOfFoods.get(j) != null){
                    long difference = listOfFoods.get(j).getTime().getTimeInMillis() - listOfFoods.get(j+1).getTime().getTimeInMillis();
                    if(difference >= 0){
                        temp = listOfFoods.get(j+1);
                        listOfFoods.set(j+1, listOfFoods.get(j));
                        listOfFoods.set(j, temp);
                    }
                }
            }
        }
    }
    
    /**
     * walks through the foodList and if the food is within 3 hours of the mood,
     * adds the mood id to the food
     * @param dateOfMood the date to test for
     * @param mood the id to add
     */
    public ArrayList<Integer> linkFoods(GregorianCalendar dateOfMood, int mood){
        ArrayList<Integer> linkedFoods = new ArrayList();
        for (int i = 0; i < listOfFoods.size()-1; i++) {
            int monthDifferent = dateOfMood.getTime().getMonth() - 
                    listOfFoods.get(i).getTime().getTime().getMonth();
            int dayDifferent = dateOfMood.getTime().getDate() - 
                    listOfFoods.get(i).getTime().getTime().getDate();
//            long difference = dateOfMood.getTimeInMillis() - listOfFoods.get(i).getTime().getTimeInMillis();
//            if(difference < 0){
//                difference = difference * -1;
//            }
            System.out.println("******************************");
            System.out.println(dateOfMood.getTime().getMonth()+ " - "+ listOfFoods.get(i).getTime().getTime().getMonth());
            System.out.println(dateOfMood.getTime().getDate() +" - "+ listOfFoods.get(i).getTime().getTime().getDate());
            System.out.println("****************************");
            if(monthDifferent == 0 && dayDifferent == 0){
                listOfFoods.get(i).addMood(mood);
                linkedFoods.add(listOfFoods.get(i).getID());
            }else{
                System.out.println("no");
            }
        }
        ExternalDataCntl.getExternalDataCntl().writeSerializedData();
        return linkedFoods;
    }
    
    public int getNewID(){
        return listOfFoods.size()+1;
    }
}
