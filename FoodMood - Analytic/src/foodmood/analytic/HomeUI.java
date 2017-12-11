/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmood.analytic;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author HannahGarthwaite
 */
public class HomeUI extends JPanel{
    
    private NavigationCntl parentCntl;
	
    private JButton goChartScreenButton;
    private JButton goHistoryScreenButton;
    private JButton goNotificationScreenButton;
    private JButton logoutButton;
    private JButton goCorrelationScreenButton;
    private JButton goUserProfile;
    
    public HomeUI(NavigationCntl theNavigationCntl){
	System.out.println("Creating HomeUI");
        this.parentCntl = theNavigationCntl;
        initializeComponents(); 
    }
    
    private void initializeComponents(){
	System.out.println("Creating components");
        setLayout(new GridLayout(6,1));
        goChartScreenButton = new JButton("Chart Correlation");
        add(goChartScreenButton);
        goCorrelationScreenButton = new JButton("View Correlation");
        add(goCorrelationScreenButton);
        goHistoryScreenButton = new JButton ("View History");
        add(goHistoryScreenButton);
        goUserProfile = new JButton("User Profile");
        add(goUserProfile);
        
        logoutButton = new JButton("Logout");
        add(logoutButton);
       
        goChartScreenButton.addActionListener((ActionEvent ae) -> { 
            System.out.println("goFoodScreenBtn click event triggered.");
            parentCntl.goToScreen(NavigationCntl.ScreenOption.CHART);
        });
        
        goCorrelationScreenButton.addActionListener((ActionEvent ae) -> { 
            System.out.println("goMoodScreenBtn click event triggered.");
            parentCntl.goToScreen(NavigationCntl.ScreenOption.CORRELATION);
	});	
       
	goHistoryScreenButton.addActionListener((ActionEvent ae) -> { 
            System.out.println("goNotificationBtn click event triggered.");
            parentCntl.goToScreen(NavigationCntl.ScreenOption.HISTORY);
	});
                
        goUserProfile.addActionListener((ActionEvent ae) -> {
            System.out.println("goUserProfile click event triggered.");
            parentCntl.goToScreen(NavigationCntl.ScreenOption.USERPROFILE);
        });
        
        logoutButton.addActionListener((ActionEvent ae) -> { 
            System.out.println("logoutBtn click event triggered.");
            setVisible(false);
            parentCntl.logout();
	});
    }
}
