/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodprofile.controller;

import foodmood.ExternalDataCntl;
import foodmood.controller.NavigationCntl;
import foodprofile.view.FoodUI;
import java.sql.Connection;
import moodprofile.model.Mood;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import moodprofile.model.MoodList;
import moodprofile.view.MoodListUI;
import moodprofile.view.MoodUI;
import userprofile.model.User;

/**
 *
 * @author Michael Kramer
 */
public class MoodCntl {
    private MoodList moodList;
    private NavigationCntl navigationCntl;
    private ExternalDataCntl externalDataCntl;
    
    public MoodCntl(NavigationCntl navigationCntl, User currentUser){
        this.navigationCntl = navigationCntl;
        this.externalDataCntl = externalDataCntl;
        readMoods();
    }
     /**
     * This sets the MoodList for the current user
     * @param moodList the moodList to set
     */
    private void setMoodList(MoodList moodList) {
        this.moodList = moodList;
    }
    /**
     * Adds a Mood to the current user's FoodList
     * @param mood the mood to add
     */
    public void addMood(Mood mood){
        moodList.addMoodProfile(mood);
        System.out.println(moodList.size()+" in c");
    }
    
    /**
     * This updates a mood, using the id stored within the mood class. Also updates linkages
     * @param mood the mood to update
     */
    public void updateMood(Mood mood){
        moodList.updateMood(mood);
    }
    
    /**
     * This deletes the mood from the current user's MoodList
     * @param moodID the mood to delete
     */
    public void deleteMood(int moodID){
        moodList.deleteMood(moodID);
    }
    /**
     * Deletes a mood from the current user's MoodList and the linkages of all foods it was linked to
     * @param mood the mood to delete
     */
    public void deleteMood(Mood mood){
        moodList.deleteMood(mood.getID());
    }
    /**
     * Links foods and moods based on the time the food was consumed
     * @param moodID the ID of the mood
     * @param time time the mood was entered
     */
    public void addLinkedFoodsToMood(int moodID, GregorianCalendar time){
        
    }
    
    public void readMoods(){
        System.out.println("Reading moods");
        moodList = externalDataCntl.readMoods();
    }
    
    public void goListView(){
        MoodListUI moodListUI = new MoodListUI(this);
        moodListUI.setVisible(true);
    }
    
    public void addMood(String name, GregorianCalendar time){
        System.out.println("adding mood");
        moodList.add(name, time);
        System.out.println("Mood list "+moodList.size());
    }
    
    public MoodList getMoodList(){
        if(moodList == null){
            moodList = externalDataCntl.readMoods();
        }
        return moodList;
    }
    
    public void goHome(){
        navigationCntl.goHomeScreen();
    }
    
    public void newMood(){
        MoodUI moodUI = new MoodUI(this);
        moodUI.setVisible(true);
    }
    
    public void viewMood(Mood mood){
        MoodUI moodUI = new MoodUI(this, mood);
        moodUI.setVisible(true);
    }
}