/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodprofile.view;

import foodprofile.controller.FoodCntl;
import foodprofile.model.Food;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author HannahGarthwaite, Michael Kramer
 */
public class FoodListUI extends JPanel {

    private FoodCntl parentCntl;
    private JScrollPane scrollPane;
    
    /**
     * Creates new form FoodListUI
     * @param foodCntl
     */
    public FoodListUI(FoodCntl foodCntl){
        this.parentCntl = foodCntl;
        addComponents();
    }
    
    private void addComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        JPanel leftMargin = new JPanel();
        //leftMargin.setBackground(Color.BLUE); // For Debugging Purposes
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
        //rightMargin.setBackground(Color.MAGENTA); // For Debugging Purposes
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .25;
        gbc.weighty = .5;
        this.add(rightMargin, gbc);
    }
    
    private JPanel buildInputPanel() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        // inputPanel.setBackground(Color.PINK); // For Debuggin Purposes
        JButton homeBtn = new JButton("HOME");
        homeBtn.addActionListener((ActionEvent ae) -> { 
            System.out.println("homeBtn Click Event Registered");
            parentCntl.requestHomeView();
        });
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = .25;
        c.weightx = 1;
        c.anchor = GridBagConstraints.WEST;
        inputPanel.add(homeBtn, c);
        
        scrollPane = new JScrollPane(buildListPanel());
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        inputPanel.add(scrollPane, c);
        
        return inputPanel;
    }
    
    private JPanel buildListPanel() {
        JPanel listPanel = new JPanel();
        // listPanel.setBackground(Color.yellow); // For Debugging Purposes
        listPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx =0;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        for (int i = 0; i < parentCntl.getFoodList().size(); i++) {
            JPanel singleFoodPanel = new JPanel();
            JLabel foodName = new JLabel(parentCntl.getFoodList().getFood(i).getName());
            singleFoodPanel.add(foodName);
            final Food food = parentCntl.getFoodList().getFood(i);
            listPanel.add(singleFoodPanel);
            
            //Allows user to click on a food to view it
            singleFoodPanel.addMouseListener(new MouseListener() {
                
                @Override
                public void mouseClicked(MouseEvent e){
                    parentCntl.setSelectedFood(food);
                    parentCntl.requestExtendedFoodView();
                }
                
                @Override
                public void mousePressed(MouseEvent e){
                    // Do Nothing
                }
                
                @Override
                public void mouseReleased(MouseEvent e){
                    // Do Nothing
                }
                
                @Override
                public void mouseEntered(MouseEvent e){
                    singleFoodPanel.setBackground(Color.lightGray);
                }
                
                @Override
                public void mouseExited(MouseEvent e){
                    singleFoodPanel.setBackground(new Color(238,238,238));
                }
            });
            c.gridy = i;
            listPanel.add(singleFoodPanel, c);
            //scrollPane.getViewport().add(listPanel, BorderLayout.NORTH);
        }
 
        return listPanel;
    }
    
    private JPanel buildButtonPanel() {
        JPanel buttonPanel = new JPanel();
        //buttonPanel.setBackground(Color.RED); // For Debuggin Purposes
        
        return buttonPanel;
    }                                                                                    
}
