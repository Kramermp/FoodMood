/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testharness;

import java.lang.reflect.Field;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import moodprofile.model.Mood;

/**
 *
 * @author Michael Kramer
 */
public class MoodTestHarness {
    private static int errorCount = 0;
    
    public static void run() {
        testConstructors();
        testAccessors();
        testMutators();
        
        if(errorCount == 0) {
            System.out.println("The MoodTestHarness finished with no errors.");
        } else {
            System.err.println("The MoodTestHarness finsihed with " + errorCount
                + " errors.");
        } 
    }

    private static void testConstructors() {
        Mood testMood = new Mood();
        if(testMood != null) {
            System.out.println("The Mood() constructor successfully created the"
                + " Mood object.");
        } else {
            System.err.println("The Mood() constructor failed to create the"
                + " Mood object.");
        }
    }

    private static void testAccessors() {
        Mood testMood = new Mood();
        Class moodClass = testMood.getClass();
        try {
            //Test getID
            Field idField = moodClass.getDeclaredField("id");
            idField.setAccessible(true);
            int detectedID = (int) idField.get(testMood);
            if(detectedID == testMood.getId()) {
                System.out.println("The method Mood.getID() successfully"
                        + " retrieved the id.");
            } else {
                System.err.println("The method Mood.getID() failed to retrieve"
                        + " the id.");
                errorCount++;
            }
            
            //Test getName
            Field nameField = moodClass.getDeclaredField("name");
            nameField.setAccessible(true);
            String detectedName = (String) nameField.get(testMood);
            //This is supposed to be == it is not a mistake
            if(detectedName == testMood.getName()) {
                System.out.println("The method Mood.getName() successfully"
                        + " retrieved the name.");
            } else {
                System.err.println("The method Mood.getName() failed to retrieve"
                        + " the name.");
                errorCount++;
            }
            
            //Test getFoodIDs
            errorCount++;
 
            //Test getFood
            errorCount++;
            
            //Test getMoodScore
            Field moodScoreField = moodClass.getDeclaredField("moodScore");
            moodScoreField.setAccessible(true);
            int detectedMoodScore = (int) moodScoreField.get(testMood);
            //This is supposed to be == it is not a mistake
            if(detectedMoodScore == testMood.getMoodScore()) {
                System.out.println("The method Mood.getMoodScore() successfully"
                        + " retrieved the moodScore.");
            } else {
                System.err.println("The method Mood.getMoodScore() failed to retrieve"
                        + " the moodScore.");
                errorCount++;
            }
            
            //Test getTime
            Field timeField = moodClass.getDeclaredField("time");
            timeField.setAccessible(true);
            GregorianCalendar detectedTime = (GregorianCalendar) timeField.get(testMood);
            //This is supposed to be == it is not a mistake
            if(detectedTime == testMood.getTime()) {
                System.out.println("The method Mood.getTime() successfully"
                        + " retrieved the time.");
            } else {
                System.err.println("The method Mood.getTime() failed to retrieve"
                        + " the time.");
                errorCount++;
            }
            
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(MoodTestHarness.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(MoodTestHarness.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(MoodTestHarness.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MoodTestHarness.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private static void testMutators() {
        //TODO: Implement testMutators();
        //Test setID
        errorCount++;
        //Test setName 
        errorCount++;
        //Test setMoodScore
        errorCount++;
        //Test setTime
        errorCount++;
        //Test setFoodIDs
        errorCount++;
        //Test deleteFood
        errorCount++;
        //Test addFood
        errorCount++;
    }
}
