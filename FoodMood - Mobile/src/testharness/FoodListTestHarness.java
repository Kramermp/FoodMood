/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testharness;

import foodprofile.model.Food;
import foodprofile.model.FoodList;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michael Kramer
 */
public class FoodListTestHarness {
    private static int errorCount;
    
    public static void run() {
        testConstructors();
        testAccessors();
        testMutators();
        
        if(errorCount == 0 ) {
            System.out.println("The FoodList Test Harness finished with no errors.");
        } else {
            System.err.println("The FoodListTestHarness finished with" 
                + " " + errorCount + " errors.");
        }
    }
    
    private static void testConstructors() {
        FoodList testFoodList = new FoodList();
        if(testFoodList != null) {
            System.out.println("The FoodList() Constructor successfully created"
                    + "the FoodList object.");
        } else {
            System.out.println("The FoodList() constructor failed to create"
                    + " the FoodList object.");
            errorCount++;
        }
    }
    
    private static void testAccessors() {
       //TODO: I'm not sure what the accessors should be for this
       // I'm not sure if they would be based on index or what
    }
    
    private static void testMutators() {
         FoodList testFoodList = new FoodList();
        Class foodListClass = testFoodList.getClass();
        try {
            //Test addFood
            Field foodListField = foodListClass.getDeclaredField("listOfFoods");
            foodListField.setAccessible(true);
            ArrayList<Food> detectedFoodList = (ArrayList<Food>) foodListField.get(testFoodList);
            Food testFood = new Food();
            testFoodList.addFood(testFood);
            if(detectedFoodList.size() == 0) {
                System.err.println("The method FoodList.addFood(Food)"
                        + " failed to modify the food list.");
                errorCount++; 
            }
            for(int i = 0; i < detectedFoodList.size(); i++) {
                if(detectedFoodList.get(i) == testFood) {
                    System.out.println("The method FoodList.addFood(Food)"
                        + " successfully modified the food list.");
                }
                if(i == detectedFoodList.size() - 1) {
                    System.err.println("The method FoodList.addFood(Food)"
                        + " failed to modify the food list.");
                    errorCount++;
                }
            }
            detectedFoodList.clear();
            
            //Test removeFood
            testFood = new Food();
            detectedFoodList.add(testFood);
            if(detectedFoodList.size() == 0) {
                System.err.println("The method FoodList.removeFood(Food)"
                        + " successfully modified the food list.");
                errorCount++;
            }
            for(int i = 0; i < detectedFoodList.size(); i++) {
                if(detectedFoodList.get(i) == testFood) {
                    System.err.println("The method FoodList.removeFood(Food)"
                        + " failed to modify the food list.");
                    errorCount++;
                }
                if(i == detectedFoodList.size() - 1) {
                    System.out.println("The method FoodList.removeFood(Food)"
                        + " successfully modified the food list.");
                }
            }
            
            //Test hasFood
            testFood = new Food();
            detectedFoodList.clear();
            detectedFoodList.add(testFood);
            if(testFoodList.hasFood(testFood)) {
                System.out.println("The method FoodList.hasFood(Food) detected"
                    + " that the Food List had the food correctly.");
            } else {
                System.err.println("The method FoodList.hasFood(Food) failed to"
                    + " detect that the FoodList did contain the food.");
                errorCount++;
            }
            
            detectedFoodList.clear();
            if(testFoodList.hasFood(testFood)) {
                System.err.println("The method FoodList.hasFood(Food) failed to"
                    + " detect that the FoodList did not contain the food.");
                errorCount++;
            } else {
                System.out.println("The method FoodList.hasFood(Food) detected"
                    + " that the Food List did not have the food correctly.");
            }
            
            //Test size
            if(testFoodList.size() == detectedFoodList.size()) {
                System.out.println("The method foodList.size() correctly"
                    + " detected the size of the Food List.");
            } else {
                System.err.println("The method FoodList.size() failed to detect"
                    + " the size of the FoodList.");
                errorCount++;
            }
            
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(FoodListTestHarness.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(FoodListTestHarness.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(FoodListTestHarness.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FoodListTestHarness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
