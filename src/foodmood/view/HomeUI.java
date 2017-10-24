/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmood.view;
import foodmood.controller.NavigationCntl;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 *
 * @author hilarygodin
 */
public class HomeUI extends JFrame {
    
    private NavigationCntl parentCntl;
    private JButton goFoodScreenButton;
    private JButton goMoodScreenButton;
    private JButton goNotificationScreenButton;
    private JButton logoutButton;
    
    public HomeUI(NavigationCntl theNavigationCntl){
        this.parentCntl = theNavigationCntl;
		initializeComponents();
    }
    
    private void initializeComponents(){
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		
        goFoodScreenButton = new JButton("Food");
		goFoodScreenButton.addActionListener((ActionEvent ae) -> { 
			System.out.println("goFoodScreenBtn click event triggered.");
			parentCntl.goFoodScreen();
		});
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(goFoodScreenButton, gbc);
        goMoodScreenButton = new JButton("Mood");
		goMoodScreenButton.addActionListener((ActionEvent ae) -> { 
			System.out.println("goMoodScreenBtn click event triggered.");
			parentCntl.goMoodScreen();
		});
		gbc.gridx = 2;
		gbc.gridy = 0;
		add(goMoodScreenButton, gbc);
        goNotificationScreenButton = new JButton("Notifications");
		goNotificationScreenButton.addActionListener((ActionEvent ae) -> { 
			System.out.println("goNotificationBtn click event triggered.");
			parentCntl.goNotifcationScreen();
		});
		gbc.gridx = 3;
		gbc.gridy = 0;
		add(goNotificationScreenButton, gbc);
        logoutButton = new JButton("Logout");
		logoutButton.addActionListener((ActionEvent ae) -> { 
			System.out.println("logoutBtn click event triggered.");
			parentCntl.logout();
		});
		gbc.gridx = 4;
		gbc.gridy = 0;
		add(logoutButton, gbc);
    }
    
    private void goFoodScreen(){
        parentCntl.goFoodScreen();
    }
    private void goMoodScreen(){
        parentCntl.goMoodScreen();
    }
    private void goFoodMoodScreen(){
        parentCntl.goFoodMoodScreen();
    }
    private void goNotificationScreen(){
        parentCntl.goNotifcationScreen();
    }
    private void logout(){
        parentCntl.logout();
    }
}
