/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodprofile.view;

import javax.swing.*;
import moodprofile.controller.MoodController;
import moodprofile.model.Mood;

/**
 *
 * @author Micahel Kramer
 */
public class MoodUI {
    private Mood theMoodModel;
    
    private MoodController parentCntl;
    private JFrame frame = new JFrame("Mood");
    private JLabel moodName;
    private JTextField moodInput;
    private JLabel date;
    private JTextField dateInput;
    private JLabel time;
    private JTextField timeInput;
    private JButton submit;
    /**
     * Default constructor for MoodView
     */
    public MoodUI(MoodController moodController) {
        this.parentCntl = moodController;
        initializeComponents();
    }

    private void initializeComponents() {
        frame.setSize(400,400); 
        frame.setLayout(null);
        
        date = new JLabel("Date:");
        date.setBounds(100, 75, 80, 25);
        frame.add(date);
        
        dateInput = new JTextField(50);
        dateInput.setBounds(200, 75, 80, 25);
        frame.add(dateInput);
        
        time = new JLabel("Time:");
        time.setBounds(100, 100, 80, 25);
        frame.add(time);
        
        timeInput = new JTextField(50);
        timeInput.setBounds(200, 100, 80, 25);
        frame.add(timeInput);
        
        moodName = new JLabel("Food:");
        moodName.setBounds(100, 150, 80, 25);
        frame.add(moodName);
        
        moodInput = new JTextField(50);
        moodInput.setBounds(200, 150, 100, 50);
        frame.add(moodInput);
        
        submit = new JButton("Submit");
        submit.setBounds(150, 250, 80, 25);
        frame.add(submit);
        
        frame.setVisible(true);
    }
}
