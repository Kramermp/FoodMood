/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chart.view;

import chart.controller.ChartCntl;
import foodprofile.model.FoodList;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import moodprofile.model.Mood;
import org.jfree.chart.ChartFactory;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author hilarygodin
 */
public class ChartUI extends JPanel {
    private static final String[] FOOD_GROUPS = FoodList.FOOD_GROUPS;;
    private ChartCntl parentCntl;
    private ChartPanel chartPanel;
    
    public ChartUI(ChartCntl parentCntl) {
        this.parentCntl = parentCntl;
        addComponents();
    }
    
    private void addComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JButton homeBtn = new JButton("Home");
        homeBtn.addActionListener((ActionEvent ae) -> { 
            parentCntl.requestHomeScreen();
        });
        c.anchor = GridBagConstraints.WEST;     
        add(homeBtn, c);   
        
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor =  GridBagConstraints.CENTER;
        add(buildButtonArea(), c);
        
        chartPanel = new ChartPanel(createChart());
        chartPanel.setBackground(this.getBackground());
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 6;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        
        add(chartPanel, c);
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
                chartPanel.setChart(createChart());
                chartPanel.updateUI();
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
                chartPanel.setChart(createChart("Dairy"));
                chartPanel.updateUI();
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
                chartPanel.setChart(createChart("Fruits"));
                chartPanel.updateUI();
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
                chartPanel.setChart(createChart("Grains"));
                chartPanel.updateUI();
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
                chartPanel.setChart(createChart("Protein"));
                chartPanel.updateUI();
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
                chartPanel.setChart(createChart("Vegetables"));
                chartPanel.updateUI();
            }
        });
        buttonPanel.add(vegetablesBtn, c);
        
        return buttonPanel;
    }
    
    private JFreeChart createChart() {
        JFreeChart chart;

        final DefaultCategoryDataset dataset = parentCntl.getDataset();

        chart = ChartFactory.createBarChart(
           "Mood Relations", 
           "Mood", "Frequency", 
           dataset,PlotOrientation.VERTICAL, 
           true, true, false);
        
        return chart;
    }
    
    private JFreeChart createChart(String foodGroup) {
        JFreeChart chart;

        final DefaultCategoryDataset dataset = parentCntl.getDataset(foodGroup);

        chart = ChartFactory.createBarChart(
           foodGroup, 
           "Mood", "Frequency", 
           dataset,PlotOrientation.VERTICAL, 
           true, true, false);
        
        return chart;
    }
}
