/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodprofile.model;

import externaldata.controller.ExternalDataCntl;
import foodprofile.model.Food;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author Micahel Kramer
 */
public class MoodList implements Serializable {
    
    private ArrayList<Mood> listOfMoods;
    
    /**
     * Constructor for externalDataCntl
     */
    public MoodList(){
        System.out.println("New Mood List");
        listOfMoods = new ArrayList();
        
    }
    
    /**
     * Default constructor for taking a list of foods and creating the MoodList
     * @param moods list of moods
     */
    public MoodList(ArrayList<Mood> moods){
        this.listOfMoods = moods;
    }
    
    /**
     * Sorts Moodlist by date of mood
     */
    public void sortByDate(){
        Mood temp; 
        
        for (int i = 0; i < listOfMoods.size()-1; i++) {
            for (int j = 0; j < listOfMoods.size()-i-1; j++) {
                if(listOfMoods.get(j+1) != null && listOfMoods.get(j) != null){
                    long difference = listOfMoods.get(j).getTime().getTimeInMillis() - listOfMoods.get(j+1).getTime().getTimeInMillis();
                    if(difference >= 0){
                        temp = listOfMoods.get(j+1);
                        listOfMoods.set(j+1, listOfMoods.get(j));
                        listOfMoods.set(j, temp);
                    }
                }
            }
        }
    }
    
    
    /**
     * Takes a mood, finds it in the list, and updates it
     * @param mood mood to update
     */
    public void updateMood(Mood mood){
        for (int i = 0; i < listOfMoods.size(); i++) {
            if(listOfMoods.get(i).getID()==mood.getID()){
                listOfMoods.set(i, mood);
            }
        }
    }
    
    /**
     * Deletes all moods from the list with a given id (should be singular)
     * @param id id of the mood
     */
    public void deleteMood(int id){
        for (int i = 0; i < listOfMoods.size(); i++) {
            if(listOfMoods.get(i).getID() == id){
                listOfMoods.remove(i)
;            }
        }
    }
    
    /**
     * Takes a name and a time, creates a mood, and adds it to the list
     * @param name eg Happy
     * @param time time mood was entered
     */
    public void add(String name, GregorianCalendar time){
        int id;
        if(listOfMoods.size()==0){
            id = 1;
        }else{
            id = listOfMoods.get(listOfMoods.size()-1).getID() + 1;
        }
        Mood toAdd = new Mood(id, name, 1);
        listOfMoods.add(toAdd);
        System.out.println("added");
        System.out.println(listOfMoods.size());
        ExternalDataCntl.getExternalDataCntl().writeSerializedData();
    }
    
    /**
     * Adds the provided MoodProfile to the MoodList
     * @param moodProfileToAdd the mood to add
     */
    public void addMood(Mood moodToAdd) {
        this.listOfMoods.add(moodToAdd);
        ExternalDataCntl.getExternalDataCntl().writeSerializedData();
    }
    
    /**
     * Return a mood for a given index
     * @param i index of the mood
     * @return 
     */
    public Mood getMood(int i){
        return listOfMoods.get(i);
    }
    
    /**
     * Removes the provided MoodProfile from the MoodList
     * @param moodProfileToRemove the mood to remove
     */
    public void removeMoodProfile(Mood moodToRemove) {
        this.listOfMoods.remove(moodToRemove);
        ExternalDataCntl.getExternalDataCntl().writeSerializedData();
    }
    
    /**
     * Checks if the MoodList contains the provided MoodProfile
     * @param moodProfile the profile to test food
     * @return boolean if it has the specified food
     */
    public boolean hasMoodProfile(Mood moodProfile) {
        System.err.println("I'm not sure that this works.");
        return listOfMoods.contains(moodProfile);
    }
    
    /**
     * Returns the size of the MoodList
     * @return the size of moodlist
     */
    public int size() {
        return listOfMoods.size();
    }
}
