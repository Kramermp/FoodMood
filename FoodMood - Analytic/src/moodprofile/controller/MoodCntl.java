/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodprofile.controller;

import externaldata.controller.ExternalDataCntl;
import foodmood.analytic.NavigationCntl;
import foodmood.analytic.UserInterface;
import foodprofile.controller.FoodCntl;
import foodprofile.view.FoodUI;
import java.awt.Dimension;
import java.sql.Connection;
import moodprofile.model.Mood;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import moodprofile.model.MoodList;
import moodprofile.view.MoodUI;
import userprofile.User;

/**
 *
 * @author Michael Kramer
 */
public class MoodCntl {
    private Mood selectedMood;
    private MoodList moodList;
    private NavigationCntl navigationCntl;
    
    
    /**
     * Default constructor, takes NavigationCntl for goHome and User to link entered moods to user
     * @param navigationCntl 
     * @param currentUser 
     */
    public MoodCntl(NavigationCntl navigationCntl){
        this.navigationCntl = navigationCntl;
        this.moodList = navigationCntl.getActiveUser().getMoodList();
    }
    
    /**
     * sort list chronologically, return date of the last
     * @return Date of last mood
     */
    public Date getDateOfLastMood(){
        moodList.sortByDate();
        if(moodList.size() > 0){
            return moodList.getMood(moodList.size()-1).getTime().getTime();
        }else{
            return new Date();
        }
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
    
    
    public MoodList getMoodList(){
        return moodList;
    }

    public void requestHomeView() {
     this.navigationCntl.goToScreen(NavigationCntl.ScreenOption.HOME);  
    }
    
    public void deleteMood(MoodUI moodUi) {
        System.out.println("Deleting mood");
        moodList.deleteMood(selectedMood);
        selectedMood = null;
    }
    
    public void updateMood(MoodUI moodUi) {
        System.out.println("Updating Mood");
        moodList.updateMood(selectedMood, getMoodUIMood(moodUi));
        selectedMood = null;
        
    }
    
    private Mood getMoodUIMood(MoodUI moodUi) {
        return new Mood(moodUi.getMoodName(), moodUi.getTime());
    }

    public void setSelectedMood(Mood mood) {
        this.selectedMood = mood;
    }

    public Mood getSelectedMood() {
        return this.selectedMood;
    }
    
}
