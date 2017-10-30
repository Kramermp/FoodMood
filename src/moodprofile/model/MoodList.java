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
        Statement theStatement = null;
        Connection theConnection = null;
        System.out.println("creating mood table \n");
        try{
            Class.forName("org.sqlite.JDBC");
            theConnection = DriverManager.getConnection("jdbc:sqlite:foodmood.db");
            theStatement = theConnection.createStatement();
            
            String create = "CREATE TABLE IF NOT EXISTS mood (name varchar, score integer, time integer)";
            theStatement.executeUpdate(create);
            
            
            
            theStatement.close();
            theConnection.close(); 
        } catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
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
        Connection conn = null;
        PreparedStatement stmt;
        try {
            // db parameters
            String url = "jdbc:sqlite:foodmood.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connected to foodmood.db");
            
            stmt = conn.prepareStatement("INSERT INTO mood (name, score, time) values (?, ?, ?)");
            stmt.setString(1, moodToAdd.getName());
            stmt.setInt(2, moodToAdd.getMoodScore());
            //stmt.setString(3, foodToAdd.getMoods().toString());
            stmt.setString(3, moodToAdd.getTime().toString());
            stmt.executeUpdate();
            
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Closed connection to foodmood.db");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public Mood getMood(int i){
        return listOfMoods.get(i);
    }
    
    /**
     * Removes the provided MoodProfile from the MoodList
     * @param moodProfileToRemove the mood to remove
     */
    public void removeMoodProfile(Mood moodToRemove) {
        Connection conn = null;
        PreparedStatement stmt;
        try {
            // db parameters
            String url = "jdbc:sqlite:foodmood.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connected to foodmood.db");
            stmt = conn.prepareStatement("DELETE FROM mood WHERE id = (?)");
            stmt.setInt(1, moodToRemove.getID());
            stmt.execute();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Closed connection to foodmood.db");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
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
        System.err.println("This is a stub.");
        //TODO: Implment size
        return 0;
    }
}
