/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigation.controller;

import navigation.ui.NavigationUI;
import userinterface.UserInterface;

/**
 *
 * @author Michael Kramer
 */
public class NavigationCntl {
    private UserInterface userInterface;
    private NavigationUI childUI;
    
    public NavigationCntl() {
        this.userInterface = UserInterface.getInstance();
        this.childUI = new NavigationUI(this);
        
        this.userInterface.setDisplay(childUI);
        this.userInterface.setVisible(true);
    }
}
