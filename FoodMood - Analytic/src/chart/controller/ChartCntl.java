/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chart.controller;

import chart.view.ChartUI;
import foodmood.analytic.NavigationCntl;
import foodprofile.model.Food;
import foodprofile.model.FoodList;
import java.awt.Color;
import java.util.ArrayList;
import moodprofile.model.Mood;
import moodprofile.model.MoodList;
import org.jfree.data.category.DefaultCategoryDataset;
import userinterface.UserInterface;

/**
 *
 * @author Michael Kramer
 */
public class ChartCntl {

    private NavigationCntl parentCntl;
    private ChartUI chartUi;
    
    
    
    public ChartCntl(NavigationCntl parentCntl) {
        this.parentCntl = parentCntl;
        chartUi = new ChartUI(this);
    }
    
    
    public ChartUI getUI() {
        return this.chartUi;
    }

    public DefaultCategoryDataset getDataset() {
        DefaultCategoryDataset theDataset = new DefaultCategoryDataset();
        String[] moods = Mood.possiblMoods;
        String[] foodGroups = FoodList.FOOD_GROUPS;
        
        for(int i =0; i < moods.length; i++) {
            for(int j =0; j < foodGroups.length; j++) {
                int count = getMoodCount(moods[i], foodGroups[j]);
                System.out.println("Testing for " + moods[i]);
                theDataset.addValue(count, moods[i], foodGroups[j]);
            }
        }   
        
        return theDataset;
    }
    
    
    public int getMoodCount(String moodToTestFor, String foodGroup) {
        FoodList foodList = parentCntl.getActiveUser().getFoodList();
        MoodList moodList = parentCntl.getActiveUser().getMoodList();
        
        int count = 0;
        for(int i = 0; i < foodList.size(); i++) {
            Food selectedFood = foodList.getFood(i);
            ArrayList<String> foodCategories = selectedFood.getFoodCategories();
            boolean isCorrectFoodCategory = foodCategories.contains(foodGroup);     
            
            if(isCorrectFoodCategory) {
                ArrayList<Integer> moods = selectedFood.getMoods();
                for(int j = 0; j < moods.size(); j++) {
                    Mood selectedMood = moodList.getMoodById(j);
                    if(selectedMood != null && selectedMood.getName().equals(moodToTestFor)) {
                        count++;
                    } else {
                        // Do Nothing
                        if(selectedMood == null) {
                            System.out.println("Mood was null");
                        }
                    }
                }
            } else {
                // Do Nothing
            }
        }
        return count;
    }

    public void requestHomeScreen() {
        parentCntl.goToScreen(NavigationCntl.ScreenOption.HOME);
    }
}
