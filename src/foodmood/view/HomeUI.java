/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmood.view;
import foodmood.controller.NavigationCntl;
import java.awt.GridLayout;
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
    private JButton goHistoryScreen;
    private JButton goUserProfile;
    private JFrame frame = new JFrame("Home Menu");
    
    public HomeUI(NavigationCntl theNavigationCntl){
        this.parentCntl = theNavigationCntl;
		initializeComponents();
                
    }
    
    private void initializeComponents(){
        frame.setSize(400,400); 
        frame.setLayout(new GridLayout(2,3));
        goFoodScreenButton = new JButton("Food");
        frame.add(goFoodScreenButton);
        goMoodScreenButton = new JButton("Mood");
        frame.add(goMoodScreenButton);
	goNotificationScreenButton = new JButton("Notifications");
        frame.add(goNotificationScreenButton);
        goUserProfile = new JButton("User Profile");
        frame.add(goUserProfile);
        goHistoryScreen = new JButton("History");
        frame.add(goHistoryScreen);
        logoutButton = new JButton("Logout");
        frame.add(logoutButton);
        frame.setVisible(true);
       
        goFoodScreenButton.addActionListener((ActionEvent ae) -> { 
            System.out.println("goFoodScreenBtn click event triggered.");
            parentCntl.goFoodScreen();
            this.setVisible(false);
	});
		
        
	goMoodScreenButton.addActionListener((ActionEvent ae) -> { 
            System.out.println("goMoodScreenBtn click event triggered.");
            parentCntl.goMoodScreen();
            this.setVisible(false);
	});
		
       
	goNotificationScreenButton.addActionListener((ActionEvent ae) -> { 
            System.out.println("goNotificationBtn click event triggered.");
            parentCntl.goNotifcationScreen();
            this.setVisible(false);
	});
		
        
        goUserProfile.addActionListener((ActionEvent ae) -> {
            System.out.println("goUserProfile click event triggered.");
            parentCntl.goUserProfile();
            this.setVisible(false);
        });
                
        goHistoryScreen.addActionListener((ActionEvent ae) -> {
            System.out.println("goHistoryScreen click event triggered.");
            //parentCntl.goHistoryScreen();
        });
        
        logoutButton.addActionListener((ActionEvent ae) -> { 
            System.out.println("logoutBtn click event triggered.");
            this.setVisible(false);
            parentCntl.logout();
	});
		
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
    private void goUserProfile(){
        parentCntl.goUserProfile();
    }
    private void goHistoryScreen(){
        //parentCntl.goHistoryScreen();
    }
    private void logout(){
        parentCntl.logout();
    }
}
