/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmood.view;
import foodmood.controller.NavigationCntl;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author hilarygodin
 */
public class HomeUI extends JPanel {
    
    private NavigationCntl parentCntl;
	
    private JButton goFoodScreenButton;
    private JButton goMoodScreenButton;
    private JButton goNotificationScreenButton;
    private JButton logoutButton;
    private JButton goReccomendationsScreen;
    private JButton goUserProfile;
    
    public HomeUI(NavigationCntl theNavigationCntl){
		System.out.println("Creating HomeUI");
        this.parentCntl = theNavigationCntl;
        initializeComponents(); 
    }
    
    private void initializeComponents(){
		System.out.println("Creating components");
        setLayout(new GridLayout(6,1));
        goFoodScreenButton = new JButton("Food");
        add(goFoodScreenButton);
        goMoodScreenButton = new JButton("Mood");
        add(goMoodScreenButton);
		goNotificationScreenButton = new JButton("Notifications");
        if(parentCntl.unreadNotificaiton()){
            goNotificationScreenButton.setForeground(Color.red);
        }
        goReccomendationsScreen = new JButton ("Reccomendations");
        add(goReccomendationsScreen);
        add(goNotificationScreenButton);
        goUserProfile = new JButton("User Profile");
        add(goUserProfile);
        
        logoutButton = new JButton("Logout");
        add(logoutButton);
       
        goFoodScreenButton.addActionListener((ActionEvent ae) -> { 
            System.out.println("goFoodScreenBtn click event triggered.");
            parentCntl.goToScreen(NavigationCntl.ScreenOption.FOOD);
            this.setVisible(false);
		});
        
		goMoodScreenButton.addActionListener((ActionEvent ae) -> { 
            System.out.println("goMoodScreenBtn click event triggered.");
            parentCntl.goToScreen(NavigationCntl.ScreenOption.MOOD);
            this.setVisible(false);
		});	
       
		goNotificationScreenButton.addActionListener((ActionEvent ae) -> { 
            System.out.println("goNotificationBtn click event triggered.");
            parentCntl.goToScreen(NavigationCntl.ScreenOption.NOTIFICATIONLIST);
            this.setVisible(false);
		});
        
        goUserProfile.addActionListener((ActionEvent ae) -> {
            System.out.println("goUserProfile click event triggered.");
            parentCntl.goToScreen(NavigationCntl.ScreenOption.USERPROFILE);
            this.setVisible(false);
        });
        
        logoutButton.addActionListener((ActionEvent ae) -> { 
            System.out.println("logoutBtn click event triggered.");
            setVisible(false);
            parentCntl.logout();
		});
    }
}
