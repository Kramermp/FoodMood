/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodprofile.controller;

import externaldata.controller.ExternalDataCntl;
import foodmood.controller.NavigationCntl;
import foodprofile.view.FoodUI;
import java.awt.Dimension;
import java.sql.Connection;
import moodprofile.model.Mood;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
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
    
    
    /**
     * Default constructor, takes NavigationCntl for goHome and User to link entered moods to user
     * @param navigationCntl 
     * @param currentUser 
     */
    public MoodCntl(NavigationCntl navigationCntl, User currentUser){
        this.navigationCntl = navigationCntl;
        this.moodList = navigationCntl.getActiveUser().getMoodList();
        this.newMood();
    }
    
    /**
     * Adds a Mood to the current user's FoodList
     * @param mood the mood to add
     */
    public void addMood(Mood mood){
        moodList.addMood(mood);
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
    
    public void addMood(String name, GregorianCalendar time){
        System.out.println("adding mood");
        if(moodList == null){
            System.out.println("was null");
        }
        moodList.add(name, time);
        System.out.println("Mood list "+moodList.size());
    }
    
    public MoodList getMoodList(){
        
        return moodList;
    }
    
//_________________Views___________________
    
    /**
     * Goes to NavigationCntl for goHome
     */
    public void goHome(){
        navigationCntl.goHomeScreen();
    }
    
    /**
     * Creates a blank MoodUI
     */
    public void newMood(){
        MoodUI moodUI = new MoodUI(this);
        navigationCntl.getUserInterface().getContentPane().removeAll();
        navigationCntl.getUserInterface().setContentPane(moodUI);
        navigationCntl.getUserInterface().setSize(new Dimension(500, 700));
        navigationCntl.getUserInterface().repaint();
        navigationCntl.getUserInterface().revalidate();
        navigationCntl.getUserInterface().setVisible(true);
    }
    
    /**
     * Goes to a list view of the moodList
     */
    public void goListView(){
        MoodListUI moodListUI = new MoodListUI(this);
        navigationCntl.getUserInterface().getContentPane().removeAll();
        navigationCntl.getUserInterface().setContentPane(moodListUI);
        navigationCntl.getUserInterface().setSize(new Dimension(500, 700));
        navigationCntl.getUserInterface().repaint();
        navigationCntl.getUserInterface().revalidate();
        navigationCntl.getUserInterface().setVisible(true);
    }
    
    /**
     * Takes a mood and creates a MoodUI
     * @param mood the mood to view
     */
    public void viewMood(Mood mood){
        MoodUI moodUI = new MoodUI(this, mood);
        navigationCntl.getUserInterface().getContentPane().removeAll();
        navigationCntl.getUserInterface().setContentPane(moodUI);
        navigationCntl.getUserInterface().repaint();
        navigationCntl.getUserInterface().revalidate();
        navigationCntl.getUserInterface().setVisible(true);
    }
    
    public JFrame getUserInterface() {
        return navigationCntl.getUserInterface();
    }
}
