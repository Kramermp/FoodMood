/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chart.view;

import chart.controller.ChartCntl;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
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
    
    private ChartCntl parentCntl;
    
    
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
        ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setBackground(this.getBackground());
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        
        add(chartPanel, c);
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
}
