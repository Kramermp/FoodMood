/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodprofile.view;

import foodprofile.controller.FoodCntl;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Michael Kramer
 */
public class FoodRecommendationUI extends JPanel{
    private JPanel recommendations;
    
    private FoodCntl parentCntl;
    private JButton homeButton;
    
    /**
     * The Default Constructor for the FoodRecommendationUI
     */
    public FoodRecommendationUI (FoodCntl foodController) {
        System.out.println("Creating FoodReccomendationsUI");
        this.parentCntl = foodController;
        //initializeComponents();
        setLayout(new GridBagLayout());
        addComponents(); 
    }
    private void addComponents() {
    GridBagConstraints gbc = new GridBagConstraints();
    
    recommendations = new JPanel();
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
        recommendations.add(homeButton, c);
    
    }
}
