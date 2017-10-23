/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmood.view;
import foodmood.controller.NavigationCntl;
import javax.swing.JButton;
import javax.swing.JFrame;
/**
 *
 * @author hilarygodin
 */
public class HomeUI extends JFrame {
    
    private NavigationCntl theNavigationCntl;
    private JButton goFoodScreenButton;
    private JButton goMoodScreenButton;
    private JButton goNotificationScreenButton;
    private JButton logoutButton;
    
    public HomeUI(NavigationCntl theNavigationCntl){
        this.theNavigationCntl = theNavigationCntl;
    }
    
    private void initializeComponents(){
        goFoodScreenButton = new JButton("Food");
        goMoodScreenButton = new JButton("Mood");
        goNotificationScreenButton = new JButton("Notifications");
        logoutButton = new JButton("Logout");
    }
    
    private void goFoodScreen(){
        theNavigationCntl.goFoodScreen();
    }
    private void goMoodScreen(){
        theNavigationCntl.goMoodScreen();
    }
    private void goFoodMoodScreen(){
        theNavigationCntl.goFoodMoodScreen();
    }
    private void goNotificationScreen(){
        theNavigationCntl.goNotifcationScreen();
    }
    private void logout(){
        theNavigationCntl.logout();
    }
}
