/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodprofile.view;

import foodmood.controller.NavigationCntl;
import foodprofile.controller.FoodCntl;
import foodprofile.model.Food;
import foodprofile.model.FoodProfileModel;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author mpk5206
 */
public class FoodUI extends JFrame{
    private Food theFoodModel;
    
    private JFrame frame = new JFrame("Food");
    private FoodCntl parentCntl;
    private JLabel foodName;
    private JTextField foodInput;
    private JLabel foodGroup;
    private JComboBox foodGroupInput;
    private JLabel date;
    private JTextField dateInput;
    private JLabel time;
    private JTextField timeInput;
    private JButton submit;

    
    /**
     * Default Constructor for empty FoodView
	 * @param parentController the parentController
     */
   
    public FoodUI(FoodCntl foodController) {
        this.parentCntl = foodController;
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
        
        foodGroup = new JLabel("Food Group:");
        foodGroup.setBounds(100, 125, 80, 25);
        frame.add(foodGroup);
        
        String[] foodGroupOptions = {"Dairy", "Fruits", "Grains", "Protein", "Vegetables"};
        foodGroupInput = new JComboBox(foodGroupOptions);
        foodGroupInput.setBounds(200, 125, 100, 25);
        frame.add(foodGroupInput);
        
        foodName = new JLabel("Food:");
        foodName.setBounds(100, 150, 80, 25);
        frame.add(foodName);
        
        foodInput = new JTextField(50);
        foodInput.setBounds(200, 150, 100, 50);
        frame.add(foodInput);
        
        submit = new JButton("Submit");
        submit.setBounds(150, 250, 80, 25);
        frame.add(submit);
        
        frame.setVisible(true);
        
        dateInput.addActionListener((ActionEvent ae) -> { 
            System.out.println("DateInput event triggered.");
	});
        timeInput.addActionListener((ActionEvent ae) -> { 
            System.out.println("TimeInput event triggered.");
	});
        foodGroupInput.addActionListener((ActionEvent ae) -> { 
            System.out.println("foodGroupInput event triggered.");
	});
        foodInput.addActionListener((ActionEvent ae) -> { 
            System.out.println("foodInput event triggered.");
	});
        submit.addActionListener((ActionEvent ae) -> { 
            System.out.println("submit click event triggered.");
	});
        
    }
      
    
    private void exit() {
        
    }
    /**
     * Creates a FoodView of the provided FoodProfile
     * @param foodProfile the source foodprofile
	 * @param parentController the parent controller
     */
    public FoodUI(FoodCntl parentController, 
            FoodProfileModel foodProfile) {
        
        
    }
    
}
