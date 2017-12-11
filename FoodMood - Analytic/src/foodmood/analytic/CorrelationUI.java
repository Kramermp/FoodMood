/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmood.analytic;

import foodmood.analytic.NavigationCntl.ScreenOption;
import java.awt.Component;
import static java.awt.Event.HOME;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


/**
 *
 * @author hilarygodin
 */
public class CorrelationUI extends JPanel{
    private NavigationCntl parentCntl;
	
    private JButton goHomeButton;
    private JScrollPane scrollPane;
    
    public CorrelationUI(){
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
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
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
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        displayPanel.add(scrollPane, c);
        
        return displayPanel;
    }

    private Component buildListPanel() {
        JPanel buildListPanel = new JPanel();
        //retrieve data from DB
        return buildListPanel;
    }
}
