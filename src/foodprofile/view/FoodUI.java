/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodprofile.view;

import foodmood.controller.NavigationCntl;
import foodmood.view.UserInterface;
import foodprofile.controller.FoodCntl;
import foodprofile.model.Food;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javafx.scene.control.DatePicker;
import javax.swing.*;
import ui.utils.DateInputPanel;

/**
 *
 * @author mpk5206
 */
public class FoodUI extends JPanel {
    private Food sourceFood;

	
    private FoodCntl parentCntl;
    private JLabel foodName;
    private JTextField foodInput;
    private JLabel foodGroup;
    private JComboBox foodGroupInput;
    private DateInputPanel dateInputPanel;
    private JLabel time;
    private JTextField timeInput;
    private JButton submitBtn;
    private JComboBox monthsBox;
    private JComboBox daysBox;
    private JButton foodListBtn;
    private JButton homeButton;
    private JButton deleteButton;
    
    private JPanel buttonPanel;

    
    /**
     * Default Constructor for empty FoodView
	 * @param parentController the parentController
     */
   
    public FoodUI(FoodCntl foodController) {
		System.out.println("Creating FoodUI");
        this.parentCntl = foodController;
        //initializeComponents();
        setLayout(new GridBagLayout());
        addComponents(); 
    }
    
    public FoodUI(FoodCntl foodCntl, Food sourceFood) {
        System.out.println("Creating FoodUI with source food");
        this.parentCntl = foodCntl;
        this.sourceFood = sourceFood;
        setLayout(new GridBagLayout());
        addComponents();
        if(this.sourceFood != null) {
            populateFields();
        }
    }
    
    public String getFoodName() {
        return this.foodInput.getText();
    }
    
    public String getFoodCategory() {
        return (String) this.foodGroupInput.getSelectedItem();
    }
    
    public GregorianCalendar getTime() {
//        System.err.println("This is technically a stub (FoodUI.getTime()).");
        return dateInputPanel.getCalendar();
    }
    
    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        
        JPanel leftMargin = new JPanel();
        //leftMargin.setBackground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = .5;
        this.add(leftMargin, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = 1;
        this.add(buildInputPanel(), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = .5;
        this.add(buildButtonPanel(), gbc);
        
        JPanel rightMargin = new JPanel();
        //rightMargin.setBackground(Color.MAGENTA);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = .5;
        this.add(rightMargin, gbc);
    }
    
    private JPanel buildInputPanel() {
        JPanel inputPanel =  new JPanel();
        // inputPanel.setBackground(Color.CYAN); // For Testing Purposes
        
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();      
       
        
        homeButton = new JButton("Home");
        homeButton.addActionListener((ActionEvent ae) -> {
           parentCntl.requestHomeView();
        });
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weighty = .25;
        c.anchor = GridBagConstraints.WEST;
        inputPanel.add(homeButton, c);
        
        JLabel dateLbl = new JLabel("Date:");
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 0;
        c.insets = new Insets(10,10,10,10);
        c.gridwidth = 1;
        c.weighty = .0;
        c.gridy = 1;
        inputPanel.add(dateLbl, c);
        
        dateInputPanel = new DateInputPanel();
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 1;
        inputPanel.add(dateInputPanel, c);
        
        time = new JLabel("Time:");
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = .25;
        c.anchor = GridBagConstraints.EAST;
        inputPanel.add(time, c);
        
        timeInput = new JTextField(25);
        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 1;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.NONE;
        inputPanel.add(timeInput, c);
        
        foodGroup = new JLabel("Food Group:");
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.EAST;
        c.weightx = .25;
        c.fill = GridBagConstraints.NONE;
        inputPanel.add(foodGroup, c);
        
        String[] foodGroupOptions = {"Dairy", "Fruits", "Grains", "Protein", "Vegetables"};
        foodGroupInput = new JComboBox(foodGroupOptions);
        foodGroupInput.setBounds(200, 125, 100, 25);
        c.gridx = 1;
        c.gridy = 3;
        c.anchor = GridBagConstraints.WEST;
        inputPanel.add(foodGroupInput, c);
        
        foodName = new JLabel("Food:");
        //foodName.setBounds(100, 150, 80, 25);
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = .25;
        c.weighty = .5;
        c.anchor = GridBagConstraints.NORTHEAST;
        inputPanel.add(foodName, c);
        
        foodInput = new JTextField(25);
        c.gridx = 1;
        c.gridy = 4;
        c.fill = GridBagConstraints.NONE;
        c.weighty = .5;
        c.anchor = GridBagConstraints.NORTHWEST;
        inputPanel.add(foodInput, c);
        
        return inputPanel;
    }
    
    private JPanel buildButtonPanel() {
        buttonPanel = new JPanel();
        // buttonPanel.setBackground(Color.PINK); // For Testing Purposes
        GridBagConstraints c = new GridBagConstraints();
        submitBtn = new JButton("Submit");
        submitBtn.addActionListener((ActionEvent ae) -> { 
            System.out.println("submitBtn ClickEvent Registered");
            if(sourceFood == null) {
                parentCntl.addFood(this);
            } else {
                parentCntl.updateFood(this);
            }
        });
        submitBtn.setSize(10, 25);
        c.gridx = 0;
        c.gridy = 5;
        c.anchor = GridBagConstraints.EAST;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        buttonPanel.add(submitBtn, c);
        
        foodListBtn = new JButton("Food List");
        foodListBtn.addActionListener((ActionEvent ae) -> { 
            System.out.println("foodListBtn Click Event Registered.");
            parentCntl.requestListView();
        });
        foodListBtn.setSize(10, 25);
        c.gridx = 1;
        c.gridy = 5;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        buttonPanel.add(foodListBtn, c);
        
        if(sourceFood != null) {
            
            JButton deleteBtn = new JButton("Delete");
            deleteBtn.addActionListener((ActionEvent ae) -> { 
                System.out.println("deleteBtn Click Event Registered");
                parentCntl.deleteSelectedFood();
                parentCntl.requestListView();
            });
            c.gridx = 0;
            c.gridy = 1;
            buttonPanel.add(deleteBtn, c);
        }
        return buttonPanel;
    }
    
    private void populateFields() {
        this.foodInput.setText(sourceFood.getName());
        this.dateInputPanel.setDate(sourceFood.getTime());
        this.foodGroupInput.setSelectedItem(sourceFood.getFoodCategories().get(0));
        this.timeInput.setText(String.valueOf(sourceFood.getTime().get(GregorianCalendar.HOUR)) + ":" +
        String.valueOf(sourceFood.getTime().get(GregorianCalendar.MINUTE)));
        
    }
  
    private void initializeComponents() {

        setVisible(true);
        
        
        foodListBtn.addActionListener((ActionEvent ae) -> { 
            parentCntl.goListView();
        });
        
        
        
    }
    
    public void initView(){
//        
//        //The text field option for date
////        dateInput = new JTextField(50);
////        dateInput.setBounds(200, 75, 80, 25);
////        add(dateInput);
//        
//        //Makes the date drop downs to elliminate user entering error
//        String[] months = new String[13];
//        for (int i = 1; i < 12; i++) {
//            months[i] = (i)+"";
//        }
//        months[0] = sourceFood.getTime().getTime().getMonth()+"";
//        String[] days = new String[32];
//        for (int i = 1; i < 31; i++) {
//            days[i] = (i)+"";
//        }
//        days[0] = sourceFood.getTime().getTime().getDate()+"";
//        JPanel dateInputPanel = new JPanel();
//        dateInputPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//        monthsBox = new JComboBox(months);
//        dateInputPanel.add(monthsBox);
//        JLabel slash = new JLabel("/");
//        dateInputPanel.add(slash);
//        daysBox = new JComboBox(days);
//        dateInputPanel.add(daysBox);
//        dateInputPanel.setBounds(200, 75, 180, 25);
//        add(dateInputPanel);
//        
//        
//        time = new JLabel("Time:");
//        time.setBounds(100, 100, 80, 25);
//        add(time);
//        
//        timeInput = new JTextField(50);
//        timeInput.setBounds(200, 100, 80, 25);
//        add(timeInput);
//        
//        foodGroup = new JLabel("Food Group:");
//        foodGroup.setBounds(100, 125, 80, 25);
//        add(foodGroup);
//        
//        String[] foodGroupOptions = {sourceFood.getFoodCategories().get(0), "Dairy", "Fruits", "Grains", "Protein", "Vegetables"};
//        foodGroupInput = new JComboBox(foodGroupOptions);
//        foodGroupInput.setBounds(200, 125, 100, 25);
//        add(foodGroupInput);
//        
//        foodName = new JLabel("Food:");
//        
//        foodName.setBounds(100, 150, 80, 25);
//        add(foodName);
//        
//        foodInput = new JTextField(50);
//        foodInput.setText(sourceFood.getName());
//        foodInput.setBounds(200, 150, 100, 50);
//        add(foodInput);
//        
//        
//        submitBtn = new JButton("Update");
//        submitBtn.setBounds(150, 250, 80, 25);
//        add(submitBtn);
//        
//        foodListBtn = new JButton("Food List");
//        foodListBtn.setBounds(300, 250, 180, 25);
//        add(foodListBtn);
//        
//        deleteButton = new JButton("Delete");
//        deleteButton.setBounds(50, 250, 80, 25);
//        add(deleteButton);
//        
//        setVisible(true);
//        
////        dateInput.addActionListener((ActionEvent ae) -> { 
////            System.out.println("DateInput event triggered.");
////	});
//        timeInput.addActionListener((ActionEvent ae) -> { 
//            System.out.println("TimeInput event triggered.");
//	});
//        foodGroupInput.addActionListener((ActionEvent ae) -> { 
//            System.out.println("foodGroupInput event triggered.");
//	});
//        foodInput.addActionListener((ActionEvent ae) -> { 
//            System.out.println("foodInput event triggered.");
//	});
//        submitBtn.addActionListener((ActionEvent ae) -> { 
//            String name = foodInput.getText();
//            String category = foodGroupInput.getSelectedItem().toString();
//            int month = Integer.parseInt(monthsBox.getSelectedItem().toString());
//            int day = Integer.parseInt(daysBox.getSelectedItem().toString());
//            GregorianCalendar time = new GregorianCalendar(2017, month, day);
//            sourceFood.setFoodCategory(category);
//            sourceFood.setName(name);
//            sourceFood.setTime(time);
//            parentCntl.updateFood(sourceFood);
//	});
//        
//        deleteButton.addActionListener((ActionEvent ae) -> { 
//            this.setVisible(false);
//            parentCntl.deleteFood(sourceFood);
//            parentCntl.goListView();
//	});
    }
    
}
