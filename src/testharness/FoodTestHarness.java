/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testharness;

import foodprofile.model.Food;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael Kramer
 */
class FoodTestHarness {
    private static int errorCount = 0;
    
    public static void run() {
        testConstructors();
        testAccessors();
        testMutators();
        
        if(errorCount != 0) {
            System.err.println("FoodTestHarness completed with " + errorCount 
                + " errors.");
        } else {
            System.out.println("FoodTestHarness completed with " + errorCount 
                + " errors.");
        }
    }
    
    private static void testConstructors() {
        Food testFood = new Food();
        if(testFood !=  null) {
            System.out.println("The Food Default Constructor successfully"
                + " created the Food object.");
        } else {
            System.err.println("The Food Default Constructor failed to create"
                + " the Food object.");
            errorCount++;
        }
    }
    
    private static void testAccessors() {
        Food testFood = new Food();
        Class foodClass = testFood.getClass();
        try {
            //Test getID
            Field idField = foodClass.getDeclaredField("id");
            idField.setAccessible(true);
            int detectedID = (int) idField.get(testFood);
            if(detectedID == testFood.getID()) {
                System.out.println("The method Food.getID() successfully"
                        + " retrieved the ID.");
            } else {
                System.err.println("The method Food.getID() failed to retrieve"
                        + "the ID.");
                errorCount++;
            }
            
            //Test getName
            Field nameField = foodClass.getDeclaredField("name");
            nameField.setAccessible(true);
            String detectedName = (String) nameField.get(testFood);
            //This should be == this is not a mistake
            if(detectedName == testFood.getName()) {
                System.out.println("The method Food.getName() successfully"
                        + " retrieved the Name.");
            } else {
                System.err.println("The method Food.getName() failed to retrieve"
                        + "the Name.");
                errorCount++;
            }
            
            //Test getFoodCategories
            Field foodCategoriesField = foodClass.getDeclaredField("foodCategories");
            foodCategoriesField.setAccessible(true);
            ArrayList<String> detectedFoodCategories = (ArrayList<String>) foodCategoriesField.get(testFood);
            //This should be == this is not a mistake
            if(detectedFoodCategories == testFood.getFoodCategories()) {
                System.out.println("The method Food.getFoodCategories() successfully"
                        + " retrieved the foodCategories.");
            } else {
                System.err.println("The method Food.getFoodCategories() failed to retrieve"
                        + "the foodCategories.");
                errorCount++;
            }
            
            //Test getTime
            Field timeField = foodClass.getDeclaredField("time");
            timeField.setAccessible(true);
            GregorianCalendar detectedTime = (GregorianCalendar) timeField.get(testFood);
            //This should be == this is not a mistake
            if(detectedTime == testFood.getTime()) {
                System.out.println("The method Food.getTime() successfully"
                        + " retrieved the time.");
            } else {
                System.err.println("The method Food.getTime() failed to retrieve"
                        + "the time.");
                errorCount++;
            }
            
            //Test getMoods
            Field moodsField = foodClass.getDeclaredField("moods");
            moodsField.setAccessible(true);
            ArrayList<Integer> detectedMoods = (ArrayList<Integer>) moodsField.get(testFood);
            //This should be == this is not a mistake
            if(detectedMoods == testFood.getMoods()) {
                System.out.println("The method Food.getMoods() successfully"
                        + " retrieved the moods.");
            } else {
                System.err.println("The method Food.getMoods() failed to retrieve"
                        + "the moods.");
                errorCount++;
            }
        } catch (IllegalArgumentException | IllegalAccessException 
                | NoSuchFieldException | SecurityException ex) {
            System.err.println("An error occured while testing Food Accessors."
                    + "\n." + ex.getMessage());
            errorCount++;
        }
    }
    
    private static void testMutators() {
        Food testFood = new Food();
        Class foodClass = testFood.getClass();
        try {
            //Test setID
            Field idField = foodClass.getDeclaredField("id");
            idField.setAccessible(true);
            int newID = 77;
            testFood.setID(newID);
            int detectedID = (int) idField.get(testFood);
            if(detectedID == newID) {
                System.out.println("The method Food.setID() successfully"
                        + " modified the ID.");
            } else {
                System.err.println("The method Food.setID() failed to modify"
                        + " the ID.");
                errorCount++;
            }
            
            //Test setName
            Field nameField = foodClass.getDeclaredField("name");
            nameField.setAccessible(true);
            String newName = "New Name";
            testFood.setName(newName);
            String detectedName = (String) nameField.get(testFood);
            //This should be == this is not a mistake
            if(detectedName == newName) {
                System.out.println("The method Food.setName() successfully"
                        + " modified the Name.");
            } else {
                System.err.println("The method Food.setName() failed to modify"
                        + " the Name.");
                errorCount++;
            }
            
            //Test setFoodCategories
            Field foodCategoriesField = foodClass.getDeclaredField("foodCategories");
            foodCategoriesField.setAccessible(true);
            ArrayList<String> newList = new ArrayList<String>();
            testFood.setFoodCategories(newList);
            ArrayList<String> detectedFoodCategories = (ArrayList<String>) foodCategoriesField.get(testFood);
            //This should be == this is not a mistake
            if(detectedFoodCategories == newList) {
                System.out.println("The method Food.setFoodCategories() successfully"
                        + " modified the foodCategories.");
            } else {
                System.err.println("The method Food.setFoodCategories() failed to modify"
                        + " the foodCategories.");
                errorCount++;
            }
            
            //Test addFoodCategory
            String testFoodCategory = "Test Food Category";
            testFood.addFoodCategory(testFoodCategory);
            if(detectedFoodCategories.get(0) == testFoodCategory) {
                System.out.println("The method Food.addFoodCategory(String)"
                    + " successfully modified the food categories.");
            } else {
                System.err.println("The method Food.addFoodCategory(String)"
                    + "failed to modify the food categories.");
                    errorCount++;
            }
           
            //Test deleteFoodCategory
            String sampleFoodCategory = "Sample Food Category";
            detectedFoodCategories.clear();
            detectedFoodCategories.add(sampleFoodCategory);
            testFood.deleteFoodCategory("Sample Food Category");
            if(!detectedFoodCategories.contains(sampleFoodCategory)) {
                System.out.println("The method Food.removeFoodCategory(String)"
                    + " successfully modified the food categories.");
            } else {
                System.err.println("The method Food.removeFoodCategory(String)"
                    + " failed to modify the food categories.");
                errorCount++;
            }
            
            
            
            //Test setTime
            Field timeField = foodClass.getDeclaredField("time");
            timeField.setAccessible(true);
            GregorianCalendar newTime = new GregorianCalendar();
            testFood.setTime(newTime);
            GregorianCalendar detectedTime = (GregorianCalendar) timeField.get(testFood);
            //This should be == this is not a mistake
            if(detectedTime == newTime) {
                System.out.println("The method Food.setTime() successfully"
                        + " modified the time.");
            } else {
                System.err.println("The method Food.setTime() failed to modify"
                        + " the time.");
                errorCount++;
            }
            
            //Test setMoods
            Field moodsField = foodClass.getDeclaredField("moods");
            moodsField.setAccessible(true);
            ArrayList<Integer> newMoods = new ArrayList<Integer>();
            testFood.setMoods(newMoods);
            ArrayList<Integer> detectedMoods = (ArrayList<Integer>) moodsField.get(testFood);
            //This should be == this is not a mistake
            if(detectedMoods == newMoods) {
                System.out.println("The method Food.setMoods() successfully"
                        + " modified the moods.");
            } else {
                System.err.println("The method Food.setMoods() failed to modify"
                        + " the moods.");
                errorCount++;
            }
            
            //Test addMood
            Integer testInt = 3;
            testFood.addMood(testInt);
            for (int i = 0; i < detectedMoods.size(); i++) {
                if(detectedMoods.get(i) == testInt) {
                    System.out.println("The method Food.addMood(Integer)"
                        + " successfully modified the moods.");
                    break;
                }
                if(i == detectedMoods.size() - 1) {
                    System.err.println("The method Food.addMood(Intger)"
                        + " failed to modify the moods.");
                    errorCount++;
                }
            }
            detectedMoods.clear();
            
            //Test deleteMood
            detectedMoods.add(testInt);
            for (int i = 0; i < detectedMoods.size(); i++) {
                if(detectedMoods.get(i) == testInt) {
                    System.err.println("The method Food.deleteMood(Intger)"
                        + " failed to modify the moods.");
                    errorCount++;
                    break;
                }
                if(i == detectedMoods.size() - 1) {
                    System.out.println("The method Food.deleteMood(Integer)"
                        + " successfully modified the moods.");
                }
            }
            
        } catch (IllegalArgumentException | IllegalAccessException 
                | NoSuchFieldException | SecurityException ex) {
            System.err.println("An error occured while testing Food Accessors."
                    + "\n." + ex.getMessage());
            errorCount++;
        }
    }
    
    
}
