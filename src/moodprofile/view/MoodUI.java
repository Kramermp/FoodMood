/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodprofile.view;

import foodmood.controller.NavigationCntl;
import moodprofile.controller.MoodCntl;
import moodprofile.model.Mood;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;

/**
 *
 * @author mpk5206
 */
public class MoodUI extends JPanel {
    private Mood theMoodModel;
    
    private MoodCntl parentCntl;
    private JLabel moodName;
    private JTextField moodInput;
    private JLabel moodGroup;
    private JComboBox moodGroupInput;
    private JLabel date;
    private JTextField dateInput;
    private JLabel time;
    private JTextField timeInput;
    private JButton submit;
    private JComboBox monthsBox;
    private JComboBox daysBox;
    private JButton listButton;
    private JButton homeButton;
    private JButton deleteButton;

    
    /**
     * Default Constructor for empty MoodView
     * @param parentController the parentController
     */
   
    public MoodUI(MoodCntl moodController) {
        //this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.parentCntl = moodController;
        initializeComponents();
        
    }
    
    private void initializeComponents() {
        //this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500,500); 
        this.setLayout(null);
        
        homeButton = new JButton("Home");
        homeButton.setBounds(50, 50, 80, 25);
        this.add(homeButton);
        
        date = new JLabel("Date:");
        date.setBounds(100, 75, 80, 25);
        this.add(date);
        
        //The text field option for date
//        dateInput = new JTextField(50);
//        dateInput.setBounds(200, 75, 80, 25);
//        this.add(dateInput);
        
        //Makes the date drop downs to elliminate user entering error
        String[] months = new String[12];
        for (int i = 0; i < 12; i++) {
            months[i] = (i+1)+"";
        }
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = (i+1)+"";
        }
        
        JPanel dateInputPanel = new JPanel();
        dateInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        monthsBox = new JComboBox(months);
        dateInputPanel.add(monthsBox);
        JLabel slash = new JLabel("/");
        dateInputPanel.add(slash);
        daysBox = new JComboBox(days);
        dateInputPanel.add(daysBox);
        dateInputPanel.setBounds(200, 75, 180, 25);
        this.add(dateInputPanel);
        
        
        time = new JLabel("Time:");
        time.setBounds(100, 100, 80, 25);
        this.add(time);
        
        timeInput = new JTextField(50);
        timeInput.setBounds(200, 100, 80, 25);
        this.add(timeInput);

        
        moodName = new JLabel("Mood:");
        moodName.setBounds(100, 150, 80, 25);
        this.add(moodName);
        
        moodInput = new JTextField(50);
        moodInput.setBounds(200, 150, 100, 50);
        this.add(moodInput);
        
        submit = new JButton("Submit");
        submit.setBounds(150, 250, 80, 25);
        this.add(submit);
        
        listButton = new JButton("Mood List");
        listButton.setBounds(300, 250, 180, 25);
        this.add(listButton);
        
        this.setVisible(true);
        
//        dateInput.addActionListener((ActionEvent ae) -> { 
//            System.out.println("DateInput event triggered.");
//  });
        timeInput.addActionListener((ActionEvent ae) -> { 
            System.out.println("TimeInput event triggered.");
    });
        moodInput.addActionListener((ActionEvent ae) -> { 
            System.out.println("moodInput event triggered.");
    });
        submit.addActionListener((ActionEvent ae) -> { 
            String name = moodInput.getText();
            int month = Integer.parseInt(monthsBox.getSelectedItem().toString());
            int day = Integer.parseInt(daysBox.getSelectedItem().toString());
            GregorianCalendar time = new GregorianCalendar(2017, month, day);
            parentCntl.addMood(name, time);
    });
        listButton.addActionListener((ActionEvent ae) -> { 
            this.setVisible(false);
            parentCntl.goListView();
    });
        homeButton.addActionListener((ActionEvent ae) -> {
           this.setVisible(false);
           parentCntl.goHome();
        });
        
        
    }
      
    
    private void exit() {
        
    }
    /**
     * Creates a MoodView of the provided MoodProfile
     * @param moodProfile the source moodprofile
     * @param parentController the parent controller
     */
    public MoodUI(MoodCntl parentController, Mood mood) {
        //this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.parentCntl = parentController;
        this.theMoodModel = mood;
        initView();
        
        
    }
    
    public void initView(){
        //this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400,400); 
        this.setLayout(null);
        
        date = new JLabel("Date:");
        date.setBounds(100, 75, 80, 25);
        this.add(date);
        
        //The text field option for date
//        dateInput = new JTextField(50);
//        dateInput.setBounds(200, 75, 80, 25);
//        this.add(dateInput);
        
        //Makes the date drop downs to elliminate user entering error
        String[] months = new String[13];
        for (int i = 1; i < 12; i++) {
            months[i] = (i)+"";
        }
        months[0] = theMoodModel.getTime().getTime().getMonth()+"";
        String[] days = new String[32];
        for (int i = 1; i < 31; i++) {
            days[i] = (i)+"";
        }
        days[0] = theMoodModel.getTime().getTime().getDate()+"";
        JPanel dateInputPanel = new JPanel();
        dateInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        monthsBox = new JComboBox(months);
        dateInputPanel.add(monthsBox);
        JLabel slash = new JLabel("/");
        dateInputPanel.add(slash);
        daysBox = new JComboBox(days);
        dateInputPanel.add(daysBox);
        dateInputPanel.setBounds(200, 75, 180, 25);
        this.add(dateInputPanel);
        
        
        time = new JLabel("Time:");
        time.setBounds(100, 100, 80, 25);
        this.add(time);
        
        timeInput = new JTextField(50);
        timeInput.setBounds(200, 100, 80, 25);
        this.add(timeInput);
        
        moodName = new JLabel("Mood:");
        
        moodName.setBounds(100, 150, 80, 25);
        this.add(moodName);
        
        moodInput = new JTextField(50);
        moodInput.setText(theMoodModel.getName());
        moodInput.setBounds(200, 150, 100, 50);
        this.add(moodInput);
        
        
        submit = new JButton("Update");
        submit.setBounds(150, 250, 80, 25);
        this.add(submit);
        
        listButton = new JButton("Mood List");
        listButton.setBounds(300, 250, 180, 25);
        this.add(listButton);
        
        deleteButton = new JButton("Delete");
        deleteButton.setBounds(50, 250, 80, 25);
        this.add(deleteButton);
        
        this.setVisible(true);
        
//        dateInput.addActionListener((ActionEvent ae) -> { 
//            System.out.println("DateInput event triggered.");
//  });
        timeInput.addActionListener((ActionEvent ae) -> { 
            System.out.println("TimeInput event triggered.");
    });
        moodInput.addActionListener((ActionEvent ae) -> { 
            System.out.println("moodInput event triggered.");
    });
        submit.addActionListener((ActionEvent ae) -> { 
            String name = moodInput.getText();
            int month = Integer.parseInt(monthsBox.getSelectedItem().toString());
            int day = Integer.parseInt(daysBox.getSelectedItem().toString());
            GregorianCalendar time = new GregorianCalendar(2017, month, day);
            theMoodModel.setName(name);
            theMoodModel.setTime(time);
            parentCntl.updateMood(theMoodModel);
    });
        listButton.addActionListener((ActionEvent ae) -> { 
            this.setVisible(false);
            parentCntl.goListView();
    });
        deleteButton.addActionListener((ActionEvent ae) -> { 
            this.setVisible(false);
            parentCntl.deleteMood(theMoodModel);
            parentCntl.goListView();
    });
    }
    
}
