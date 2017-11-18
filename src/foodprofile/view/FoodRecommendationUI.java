/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodprofile.view;

import foodmood.controller.NavigationCntl;
import foodprofile.controller.FoodCntl;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Michael Kramer
 */
public class FoodRecommendationUI extends JPanel{
    private JPanel recommendations;
    private JPanel imagePanel;
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
        this.setLayout(new GridBagLayout());
        
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
        recommendations.setLayout(new GridBagLayout());
        
        homeButton = new JButton("Home");
        homeButton.addActionListener((ActionEvent ae) -> {
           parentCntl.goToScreen(NavigationCntl.ScreenOption.HOME);
        });
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weightx = 1;
        c.weighty = 0;
        c.anchor = GridBagConstraints.WEST;
        recommendations.add(homeButton, c);
        
        imagePanel = new JPanel();
        imagePanel.setLayout(new GridBagLayout());
        ImageIcon test = new ImageIcon("myPlate.jpg"); 
        JLabel image = new JLabel("", test, JLabel.CENTER);
        c.fill = GridBagConstraints.BOTH;
        imagePanel.add(image, c);
        imagePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                
            }

            @Override
            public void mousePressed(MouseEvent me) {
                try {
                    openWebpage(new URI("https://www.fns.usda.gov/tn/myplate"));
                } catch (URISyntaxException ex) {
                    Logger.getLogger(FoodRecommendationUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                
            }

            @Override
            public void mouseExited(MouseEvent me) {
                
            }
        });
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.weighty = .1;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.BOTH;
        recommendations.add(imagePanel, c);

        return recommendations;
    }
    
    public static void openWebpage(URI uri) {
    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
        try {
            desktop.browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
}
