/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externaldata.controller;

import foodprofile.model.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import moodprofile.model.*;
import userprofile.model.*;

/**
 * This is the ExternalDataCtnl and it manages the interaction between
 * the application and the SQL DataBase.
 * <p>
 * This class is structured following the Initialize-On-Demand Holder Idiom,
 * to ensure that there is only ever one ExternalDataCntl object created in the
 * application. By enforcing a single instance it helps ensure that the data
 * That is loaded into memory is the same as the data that is in the database.
 * <p>
 * The object is lazily initialized; meaning, the object is not instantiated 
 * until the first call to getExternalDataCntl().
 * <p>
 * @author HannahGarthwaite, Michael Kramer
 */
public class ExternalDataCntl {
    
    private Connection theConnection = null;
    private Statement theStatement = null;
    private UserList userList;
    private FoodList foodList;
    private MoodList moodList;
    
    private ExternalDataCntl(){
//        this.userList = readLogins();
//        this.foodList = readFoods();
//        this.moodList = readMoods();

		readSerializedData();
		if(userList == null) {
			userList = new UserList();
			writeSerializedData();
			readSerializedData();
		}
    }
    
    private static class LazyHolder {
        static final ExternalDataCntl INSTANCE = new ExternalDataCntl();
    }
    
    // This how the to get an ExternalDataCntl, not via a Constructure 
    public static ExternalDataCntl getExternalDataCntl() {
        return LazyHolder.INSTANCE;
    }
	
    public void writeSerializedData() {
		System.out.println("Executing writeTheSerializedData().");
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream("Data.ser");
			out = new ObjectOutputStream(fos);
			out.writeObject(userList);
			out.flush();
			out.close();
		} catch(IOException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}	
	}
	
	public void readSerializedData() {
		System.out.println("Executing readTheSerializedData().");
		String errorType = null;
		String errorMessage = null;
		try {
			FileInputStream fis = null;
			ObjectInputStream in = null;
			fis = new FileInputStream("Data.ser");
			in = new ObjectInputStream(fis);
			userList = (UserList) in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			errorType = "FileNotFoundException";
			errorMessage = e.getMessage();
		} catch (IOException e) {
			errorType = "IOException";
			errorMessage = e.getMessage();
		} catch (ClassNotFoundException e) {
			errorType = "ClassNameNotFoundException";
			errorMessage = e.getMessage();
		} catch (Exception e) {
			errorType = e.getClass().getName();
			errorMessage = e.getMessage();
		} finally {
			if(errorType != null) {
				System.out.println(errorType + " occurred while executing"
					+ " readTheSerializedData().");
				System.out.println(errorMessage);
			}
		}
	}
	
    public void createUserTable(){
        System.out.println("creating user table");
        try{
            Class.forName("org.sqlite.JDBC");
            theConnection = DriverManager.getConnection("jdbc:sqlite:foodmood.db");
            theStatement = theConnection.createStatement();
            
            String create = "CREATE TABLE IF NOT EXISTS login (username varchar, password varchar)";
            theStatement.executeUpdate(create);
            
            String delete = "DELETE FROM login WHERE username = 'User1';";
            theStatement.executeUpdate(delete);
            delete = "DELETE FROM login WHERE username = 'user1';";
            theStatement.executeUpdate(delete);
            
            String insert = "INSERT INTO login VALUES ('User1', 'password');";
            theStatement.executeUpdate(insert);
            
            theStatement.close();
            theConnection.close(); 
        } catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    public UserList getUserList() {
        
        return this.userList;
    }
        
    private UserList readLogins(){
        createUserTable();
        System.out.println("Reading logins");
        UserList theUserList = null;
        try{
            Class.forName("org.sqlite.JDBC");
            theConnection = DriverManager.getConnection("jdbc:sqlite:foodmood.db");
            theStatement = theConnection.createStatement();
            
            ResultSet set = theStatement.executeQuery("SELECT * FROM login");
            ArrayList<User> users = new ArrayList();
            while(set.next()){
                String username = set.getString("username");
                char[] password = set.getString("password").toCharArray();
                System.out.println(username);
                for (int i = 0; i < password.length; i++) {
                    System.out.println(password[i]);
                }
                
                User user = new User(username, password);
                users.add(user);
            }
            theUserList = new UserList(users);
             
            theStatement.close();
            theConnection.close(); 
            
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        return theUserList;
        
    }
    
    public void updateUser(String oldUsername, User newUser){
        System.out.println("updating user to db");
        try{
            Class.forName("org.sqlite.JDBC");
            theConnection = DriverManager.getConnection("jdbc:sqlite:foodmood.db");
            theStatement = theConnection.createStatement();
            System.out.println("successfully opened db");

            String newPasswordString = "";
            for (int i = 0; i < newUser.getPassword().length; i++) {
                newPasswordString += newUser.getPassword()[i];
            }

            String update = "UPDATE login SET username = '"+newUser.getUsername()+"', password = '"+newPasswordString+"' WHERE username = '"+oldUsername+"';";
            theStatement.executeUpdate(update);

            theStatement.close();
            theConnection.close(); 
            System.out.println("User added to db");

        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
		writeSerializedData();
    }
    
    public void addUser(String username, char[] password){
        createUserTable();
		System.out.println("adding user to db");
		try{
			Class.forName("org.sqlite.JDBC");
			theConnection = DriverManager.getConnection("jdbc:sqlite:foodmood.db");
			theStatement = theConnection.createStatement();
			System.out.println("successfully opened db");

			String passwordString = "";
			for (int i = 0; i < password.length; i++) {
				passwordString += password[i];
			}

			String insert = "INSERT INTO login VALUES ('"+username+"', '"+passwordString+"');";
			theStatement.executeUpdate(insert);

			theStatement.close();
			theConnection.close(); 
			System.out.println("User added to db");

		}catch(Exception e){
			e.printStackTrace();
			System.exit(0);
		}
		writeSerializedData();
    }
    
    public void deleteUser(String username){
        createUserTable();
            System.out.println("adding user to db");
            try{
                Class.forName("org.sqlite.JDBC");
                theConnection = DriverManager.getConnection("jdbc:sqlite:foodmood.db");
                theStatement = theConnection.createStatement();
                System.out.println("successfully opened db");
                

                String delete = "DELETE FROM login WHERE username = '"+username+"';";
                theStatement.executeUpdate(delete);
                
                theStatement.close();
                theConnection.close(); 
                System.out.println("User added to db");

            }catch(Exception e){
                e.printStackTrace();
                System.exit(0);
            }
    }
    
    public void createFoodTable(){
        System.out.println("creating food table \n");
        try{
            Class.forName("org.sqlite.JDBC");
            theConnection = DriverManager.getConnection("jdbc:sqlite:foodmood.db");
            theStatement = theConnection.createStatement();
            
            String create = "CREATE TABLE IF NOT EXISTS food (name varchar, categories blob, time integer)";
            theStatement.executeUpdate(create);
            
            theStatement.close();
            theConnection.close(); 
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    public FoodList getFoodList() {
        return this.foodList;
    }
            
    
    private FoodList readFoods(){
		createFoodTable();
        FoodList foodList = null;
        try{
            Class.forName("org.sqlite.JDBC");
            theConnection = DriverManager.getConnection("jdbc:sqlite:foodmood.db");
            theStatement = theConnection.createStatement();
            
            ResultSet set = theStatement.executeQuery("SELECT * FROM food");
            ArrayList<Food> foods = new ArrayList();
            while(set.next()){
                //Commented out as there's no such column
//                int id = set.getInt("id");
                String name = set.getString("name");
                Food food = new Food();
                //commented out as there's no such column
//                food.setID(id);
                food.setName(name);
                foods.add(food);
            }
            foodList = new FoodList(foods);
             
            theStatement.close();
            theConnection.close(); 
            
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        return foodList;
    }
    
    public void addFood(Food foodToAdd){
        ArrayList<Food> listOfFoods = new ArrayList();
        
        Connection conn = null;
        PreparedStatement stmt;
        listOfFoods.add(foodToAdd);
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
		writeSerializedData();
    }
    
    public void removeFood(Food foodToRemove){
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
		writeSerializedData();
    }
    
    public void createMoodTable(){
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
    
    public void addMood(Mood moodToAdd){
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
		writeSerializedData();
    }
    
    public void deleteMood(Mood moodToRemove){
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
		writeSerializedData();
    }
    
    public MoodList getMoodList() {
        return this.moodList;
    }
    
    private MoodList readMoods(){
		createMoodTable();
        MoodList moodList = null;
        try{
            Class.forName("org.sqlite.JDBC");
            theConnection = DriverManager.getConnection("jdbc:sqlite:foodmood.db");
            theStatement = theConnection.createStatement();
            
            ResultSet set = theStatement.executeQuery("SELECT * FROM mood");
            ArrayList<Mood> moods = new ArrayList();
            while(set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                int score = set.getInt("score");
                Mood mood = new Mood(id, name, score);

            }
//            moodList = new MoodList(moods);
             
            theStatement.close();
            theConnection.close(); 
            
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        return moodList;
    } 
    
}
