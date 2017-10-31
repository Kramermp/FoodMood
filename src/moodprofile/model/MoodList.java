/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodprofile.model;

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
public class MoodList {
    private ArrayList<Mood> listOfMoods;
    public MoodList(){
        System.out.println("New Mood List");
        listOfMoods = new ArrayList();
        
    }
    
    public MoodList(ArrayList<Mood> moods){
        this.listOfMoods = moods;
    }
    
    public void updateMood(Mood mood){
        for (int i = 0; i < listOfMoods.size(); i++) {
            if(listOfMoods.get(i).getID()==mood.getID()){
                listOfMoods.set(i, mood);
            }
        }
    }
    
    public void deleteMood(int id){
        for (int i = 0; i < listOfMoods.size(); i++) {
            if(listOfMoods.get(i).getID() == id){
                listOfMoods.remove(i)
;            }
        }
    }
    
    public void add(String name, GregorianCalendar time){
        int id;
        if(listOfMoods.size()==0){
            id = 1;
        }else{
            id = listOfMoods.get(listOfMoods.size()-1).getID() + 1;
        }
        Mood toAdd = new Mood(id, name, time);
        listOfMoods.add(toAdd);
        System.out.println("added");
        System.out.println(listOfMoods.size());
    }
    
    /**
     * Adds the provided MoodProfile to the MoodList
     * @param moodProfileToAdd the mood to add
     */
    public void addMoodProfile(Mood moodToAdd) {
        System.out.println("TODO addMood");
    }
    
    public Mood getMood(int i){
        return listOfMoods.get(i);
    }
    
    /**
     * Removes the provided MoodProfile from the MoodList
     * @param moodProfileToRemove the mood to remove
     */
    public void removeMoodProfile(Mood moodToRemove) {
        System.out.println("TODO removeMood");
    }
    
    /**
     * Checks if the MoodList contains the provided MoodProfile
     * @param moodProfile the profile to test food
     * @return boolean if it has the specified food
     */
    public boolean hasMoodProfile(Mood moodProfile) {
        System.err.println("This is a stub.");
        //TODO: Implment hasMoodProfile
        return false;
    }
    
    /**
     * Returns the size of the MoodList
     * @return the size of moodlist
     */
    public int size() {
        return listOfMoods.size();
    }
}
