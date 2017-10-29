/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodprofile.model;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Michael Kramer
 */
public class FoodList {
    private ArrayList<Food> listOfFoods = 
            new ArrayList<Food>();  

    
    /**
     * Default Constructor
     */
    public FoodList() {
        Statement theStatement = null;
        Connection theConnection = null;
        System.out.println("creating food table \n");
        try{
            Class.forName("org.sqlite.JDBC");
            theConnection = DriverManager.getConnection("jdbc:sqlite:foodmood.db");
            theStatement = theConnection.createStatement();
            
            String create = "CREATE TABLE IF NOT EXISTS food (name varchar, categories blob, time integer)";
            theStatement.executeUpdate(create);
            
            
            
            theStatement.close();
            theConnection.close(); 
        } catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    public FoodList(ArrayList<Food> foods){
        this.listOfFoods = foods;
    }
    
    /**
     * Adds the provide FoodProfile to the FoodList
     * @param foodToAdd the foodToAdd 
     */
    public void addFood(Food foodToAdd) {
        Connection conn = null;
        PreparedStatement stmt;
        try {
            // db parameters
            String url = "jdbc:sqlite:foodmood.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connected to foodmood.db");
            
            stmt = conn.prepareStatement("INSERT INTO food (name, categories, time) values (?, ?, ?)");
            stmt.setString(1, foodToAdd.getName());
            stmt.setString(2, foodToAdd.getFoodCategories().toString());
            //stmt.setString(3, foodToAdd.getMoods().toString());
            stmt.setString(3, foodToAdd.getTime().toString());
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
    
    /**
     * Removes the provided from the FoodList
     * @param foodToRemove Food to be removed from the FoodList
     */
    public void removeFood(Food foodToRemove) {
        Connection conn = null;
        PreparedStatement stmt;
        try {
            // db parameters
            String url = "jdbc:sqlite:foodmood.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connected to foodmood.db");
            stmt = conn.prepareStatement("DELETE FROM food WHERE id = (?)");
            stmt.setInt(1, foodToRemove.getID());
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
     * Checks if the FoodList contains the provided FoodProfile
     * @param foodProfile the Food to check for
     * @return the food to check for
     */
    public boolean hasFood(Food foodProfile) {
        System.err.println("This is a stub.");
        //TODO: Implment hasFoodProfile
        return false;
    }
    
    /**
     * Returns the size of the FoodList
     * @return the size of the FoodList
     */
    public int size() {
        return listOfFoods.size();
    }
}
