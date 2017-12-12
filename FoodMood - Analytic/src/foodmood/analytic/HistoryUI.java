/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmood.analytic;

import foodprofile.model.Food;
import java.awt.Color;
import java.awt.Component;
import static java.awt.Event.HOME;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author hilarygodin
 */
public class HistoryUI extends JPanel{
    
    private NavigationCntl parentCntl;
	
    private JButton goHomeButton;
    private JScrollPane scrollPane;
    
    public HistoryUI(NavigationCntl parentCntl){
        this.parentCntl = parentCntl;
        this.setLayout(new GridBagLayout());
        addComponents();
        
    }

    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        
        JPanel leftMargin = new JPanel();
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
        this.add(displayPanel(), gbc);
        
        JPanel bottomMargin = new JPanel();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .25;
        gbc.weighty = .5;
        this.add(bottomMargin, gbc);
        
        
        JPanel rightMargin = new JPanel();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .25;
        gbc.weighty = .5;
        this.add(rightMargin, gbc);
    }

    private Component displayPanel() {
        JPanel displayPanel = new JPanel();
        
        displayPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JButton homeBtn = new JButton("Home");
        homeBtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                System.out.println("homeBtn Click Event Registered");
                parentCntl.goToScreen(NavigationCntl.ScreenOption.HOME);
            }
        });
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = .25;
        c.weightx = 1;
        c.anchor = GridBagConstraints.WEST;
        displayPanel.add(homeBtn, c);
        
        scrollPane = new JScrollPane(buildListPanel());
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = .9;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(0, 0, 50, 0);
        displayPanel.add(scrollPane, c);
        
        return displayPanel;
    }

    private Component buildListPanel() {
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx =0;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        for (int i = 0; i < parentCntl.getActiveUser().getFoodList().size(); i++) {
            JPanel singleFoodPanel = new JPanel();
            JLabel foodName = new JLabel(parentCntl.getActiveUser().getFoodList().getFood(i).getName());
            singleFoodPanel.add(foodName);
            final Food food = parentCntl.getActiveUser().getFoodList().getFood(i);
            listPanel.add(singleFoodPanel);
            
            //Allows user to click on a food to view it
//            singleFoodPanel.addMouseListener(new MouseListener() {
//                
//                @Override
//                public void mouseClicked(MouseEvent e){
//                    
//                }
//                
//                @Override
//                public void mousePressed(MouseEvent e){
//                    // Do Nothing
//                }
//                
//                @Override
//                public void mouseReleased(MouseEvent e){
//                    // Do Nothing
//                }
//                
//                @Override
//                public void mouseEntered(MouseEvent e){
//                    singleFoodPanel.setBackground(Color.lightGray);
//                }
//                
//                @Override
//                public void mouseExited(MouseEvent e){
//                    singleFoodPanel.setBackground(new Color(238,238,238));
//                }
//            });
            c.gridy = i;
            listPanel.add(singleFoodPanel, c);
        }
        
        int j = c.gridy + 1;
        for (int i = 0; i < parentCntl.getActiveUser().getMoodList().size(); i++) {
            JPanel singleFoodPanel = new JPanel();
            JLabel foodName = new JLabel(parentCntl.getActiveUser().getMoodList().getMood(i).getName());
            singleFoodPanel.add(foodName);
            listPanel.add(singleFoodPanel);
            
            //Allows user to click on a food to view it
//            singleFoodPanel.addMouseListener(new MouseListener() {
//                
//                @Override
//                public void mouseClicked(MouseEvent e){
//                    
//                }
//                
//                @Override
//                public void mousePressed(MouseEvent e){
//                    // Do Nothing
//                }
//                
//                @Override
//                public void mouseReleased(MouseEvent e){
//                    // Do Nothing
//                }
//                
//                @Override
//                public void mouseEntered(MouseEvent e){
//                    singleFoodPanel.setBackground(Color.lightGray);
//                }
//                
//                @Override
//                public void mouseExited(MouseEvent e){
//                    singleFoodPanel.setBackground(new Color(238,238,238));
//                }
//            });
            c.gridy = i + j;
            listPanel.add(singleFoodPanel, c);
        }
        return listPanel;
    }
    
}
