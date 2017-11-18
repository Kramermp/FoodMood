/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodprofile.view;

import foodmood.controller.NavigationCntl;
import foodprofile.controller.FoodCntl;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Michael Kramer
 */
public class FoodRecommendationUI extends JPanel{
    private JPanel recommendations;
    private JButton homeButton;
    private NavigationCntl parentCntl;
            
    /**
     * The Default Constructor for the FoodRecommendationUI
     */
    public FoodRecommendationUI (NavigationCntl parentCntl) {
       this.parentCntl = parentCntl;
       addComponents();
    }
    
    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        
        JPanel leftMargin = new JPanel();
        //leftMargin.setBackground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .25;
        gbc.weighty = .5;
        this.add(leftMargin, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = 10;
        this.add(buildDisplayPanel(), gbc);
        
        JPanel bottomMargin =  new JPanel();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = .5;
        this.add(bottomMargin, gbc);
        
        JPanel rightMargin = new JPanel();
        //rightMargin.setBackground(Color.MAGENTA);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .25;
        gbc.weighty = .5;
        this.add(rightMargin, gbc);
    }
    
    private JPanel buildDisplayPanel() {
        GridBagConstraints c = new GridBagConstraints();
        recommendations = new JPanel();
        
        homeButton = new JButton("Home");
        homeButton.addActionListener((ActionEvent ae) -> {
           parentCntl.goToScreen(NavigationCntl.ScreenOption.HOME);
        });
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weighty = .25;
        c.anchor = GridBagConstraints.WEST;
        recommendations.add(homeButton, c);
 
        return recommendations;
    }
}
