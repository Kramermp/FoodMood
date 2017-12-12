/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmood.analytic;

import foodmood.analytic.NavigationCntl.ScreenOption;
import foodprofile.model.Food;
import foodprofile.model.FoodList;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import static java.awt.Event.HOME;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import moodprofile.model.MoodList;


/**
 *
 * @author hilarygodin
 */
public class CorrelationUI extends JPanel{
    private NavigationCntl parentCntl;
	
    private JButton goHomeButton;
    private JPanel listPanel = new JPanel();
    private JPanel test = new JPanel();
    
    
    public CorrelationUI(NavigationCntl parentCntl){
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
        
        c.gridx = 0;
        c.weighty = 0;
        c.anchor = GridBagConstraints.CENTER;
        c.gridy = 1;
        displayPanel.add(buildButtonArea(), c);
        
        buildListPanel();
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 1;
        c.weighty = .9;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(0, 0, 50, 0);
        displayPanel.add(listPanel, c);
        
        return displayPanel;
    }
    
    private JPanel buildButtonArea() {
        JPanel buttonPanel = new JPanel();
        // buttonPanel.setBackground(Color.yellow);
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints  c = new GridBagConstraints();
        
        c.gridwidth = 6;
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        JButton overviewBtn = new JButton("Overview");
        overviewBtn.setSize(50, 50);
        overviewBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               CardLayout layout = (CardLayout) (listPanel.getLayout());
               layout.show(listPanel, "Overview");
            }
        });
        buttonPanel.add(overviewBtn, c);
        
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        c.gridy = 1;
        JButton dairyBtn = new JButton("Dairy");
        dairyBtn.setSize(50, 50);
        dairyBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout layout = (CardLayout) (listPanel.getLayout());
                layout.show(listPanel, "Dairy");
            }
        });
        buttonPanel.add(dairyBtn, c);
        
        
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 1;
        JButton fruitsBtn = new JButton("Fruits");
        fruitsBtn.setSize(50, 50);
        fruitsBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout layout = (CardLayout) (listPanel.getLayout());
                layout.show(listPanel, "Fruits");
            }
        });
        buttonPanel.add(fruitsBtn, c);
        
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 1;
        JButton grainsBtn = new JButton("Grains");
        grainsBtn.setSize(50, 50);
        grainsBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout layout = (CardLayout) (listPanel.getLayout());
                layout.show(listPanel, "Grains");
            }
        });
        buttonPanel.add(grainsBtn, c);
        
        c.gridwidth = 1;
        c.gridx = 4;
        c.gridy = 1;
        JButton proteinBtn = new JButton("Protein");
        proteinBtn.setSize(50, 50);
        proteinBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               CardLayout layout = (CardLayout) (listPanel.getLayout());
               layout.show(listPanel, "Protein");
            }
        });
        buttonPanel.add(proteinBtn, c);
        
        c.gridwidth = 1;
        c.gridx = 5;
        c.gridy = 1;
        JButton vegetablesBtn = new JButton("Vegetables");
        vegetablesBtn.setSize(50, 50);
        vegetablesBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                CardLayout layout = (CardLayout) (listPanel.getLayout());
               layout.show(listPanel, "Vegetables");
            }
        });
        buttonPanel.add(vegetablesBtn, c);
        
        return buttonPanel;
    }
    
    private void buildListPanel() {
        listPanel = new JPanel(new CardLayout());
        listPanel.setBackground(Color.RED);
        
        JScrollPane overviewPanel = buildOverviewPanel();
        //overviewPanel.setBackground(Color.blue);
        listPanel.add(overviewPanel, "Overview");
        
        JScrollPane dairyPanel = buildSpecificPanel("Dairy");
        //dairyPanel.setBackground(Color.MAGENTA);
        listPanel.add(dairyPanel, "Dairy");
        
       JScrollPane fruitsPanel =  buildSpecificPanel("Fruits");
        //fruitsPanel.setBackground(Color.GREEN);
        listPanel.add(fruitsPanel, "Fruits");
        
        JScrollPane grainsPanel = buildSpecificPanel("Grains");
        //grainsPanel.setBackground(Color.PINK);
        listPanel.add(grainsPanel, "Grains");
        
        JScrollPane proteinPanel =  buildSpecificPanel("Protein");
        //proteinPanel.setBackground(Color.DARK_GRAY);
        listPanel.add(proteinPanel, "Protein");
        
        JScrollPane vegetablesPanel =  buildSpecificPanel("Vegetables");
        //vegetablesPanel.setBackground(Color.CYAN);
        listPanel.add(vegetablesPanel, "Vegetables");
    }
    
    private JScrollPane buildSpecificPanel(String foodGroup) {
        JPanel foodGroupPanel = new JPanel();
        foodGroupPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx =0;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        
        FoodList foodList = parentCntl.getActiveUser().getFoodList();
        MoodList moodList = parentCntl.getActiveUser().getMoodList();
        for(int i = 0; i <  foodList.size(); i++) {
            if(foodList.getFood(i).getFoodCategories().contains(foodGroup)) {
                ArrayList<Integer> moodIds = foodList.getFood(i).getMoods();
                for(int j = 0; j < moodIds.size(); j++) {
                    JPanel singleMoodPanel = new JPanel();
                    JLabel moodName = new JLabel (moodList.getMoodById(moodIds.get(j)).getName());
                    singleMoodPanel.add(moodName);
                    c.gridy++;
                    System.out.println("");
                    foodGroupPanel.add(singleMoodPanel, c);
                }
            } else {
                // Do Nothing
            }
        }
        
        return new JScrollPane(foodGroupPanel);
    }
    
    private JScrollPane buildOverviewPanel() {
        JPanel foodGroupPanel = new JPanel();
        foodGroupPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx =0;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        
        FoodList foodList = parentCntl.getActiveUser().getFoodList();
        MoodList moodList = parentCntl.getActiveUser().getMoodList();
        for(int i = 0; i <  foodList.size(); i++) {
            ArrayList<Integer> moodIds = foodList.getFood(i).getMoods();
            for(int j = 0; j < moodIds.size(); j++) {
                JPanel singlePanel = new JPanel();
                JLabel foodGroup = new JLabel (foodList.getFood(i).getFoodCategories().get(0));
                JLabel moodName = new JLabel (moodList.getMoodById(moodIds.get(j)).getName());
                singlePanel.add(foodGroup);
                singlePanel.add(moodName);
                c.gridy++;
                System.out.println("");
                foodGroupPanel.add(singlePanel, c);
            }
        }
        
        return new JScrollPane(foodGroupPanel);
    }
}


//test.removeAll();
//        foodGroupPanel = new JPanel();
//        foodGroupPanel.setBackground(Color.RED);
//        
//        foodGroupPanel.setLayout(new GridBagLayout());
//        GridBagConstraints c = new GridBagConstraints();
//        c.gridx =0;
//        c.weightx = 1;
//        c.weighty = 1;
//        c.fill = GridBagConstraints.BOTH;
////        for (int i = 0; i < parentCntl.getActiveUser().getFoodList().size(); i++) {
////            JPanel singleFoodPanel = new JPanel();
////            JLabel foodName = new JLabel(parentCntl.getActiveUser().getFoodList().getFood(i).getName());
////            singleFoodPanel.add(foodName);
////            final Food food = parentCntl.getActiveUser().getFoodList().getFood(i);
////            foodGroupPanel.add(singleFoodPanel);
////            
////            //Allows user to click on a food to view it
//////            singleFoodPanel.addMouseListener(new MouseListener() {
//////                
//////                @Override
//////                public void mouseClicked(MouseEvent e){
//////                    
//////                }
//////                
//////                @Override
//////                public void mousePressed(MouseEvent e){
//////                    // Do Nothing
//////                }
//////                
//////                @Override
//////                public void mouseReleased(MouseEvent e){
//////                    // Do Nothing
//////                }
//////                
//////                @Override
//////                public void mouseEntered(MouseEvent e){
//////                    singleFoodPanel.setBackground(Color.lightGray);
//////                }
//////                
//////                @Override
//////                public void mouseExited(MouseEvent e){
//////                    singleFoodPanel.setBackground(new Color(238,238,238));
//////                }
//////            });
////            c.gridy = i;
////            foodGroupPanel.add(singleFoodPanel, c);
////        }
//        
//        int j = c.gridy + 1;
//        for (int i = 0; i < parentCntl.getActiveUser().getMoodList().size(); i++) {
//            JPanel singleFoodPanel = new JPanel();
//            JLabel foodName = new JLabel(parentCntl.getActiveUser().getMoodList().getMood(i).getName());
//            singleFoodPanel.add(foodName);
//            foodGroupPanel.add(singleFoodPanel);
//            
//            //Allows user to click on a food to view it
////            singleFoodPanel.addMouseListener(new MouseListener() {
////                
////                @Override
////                public void mouseClicked(MouseEvent e){
////                    
////                }
////                
////                @Override
////                public void mousePressed(MouseEvent e){
////                    // Do Nothing
////                }
////                
////                @Override
////                public void mouseReleased(MouseEvent e){
////                    // Do Nothing
////                }
////                
////                @Override
////                public void mouseEntered(MouseEvent e){
////                    singleFoodPanel.setBackground(Color.lightGray);
////                }
////                
////                @Override
////                public void mouseExited(MouseEvent e){
////                    singleFoodPanel.setBackground(new Color(238,238,238));
////                }
////            });
//            c.gridy = i + j;
//            foodGroupPanel.add(singleFoodPanel, c);
//        }
//        
//        test.add(foodGroupPanel);
