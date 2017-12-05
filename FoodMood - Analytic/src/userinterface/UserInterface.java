/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JFrame;

/**
 * This class is the UserInterface that the rest of the application utilizes to
 * ensure that there is a singular interface.
 * 
 * This class is a singleton class that follows the Lazy-Holder Idiom structure.
 * 
 * @author Michael Kramer
 */
public class UserInterface extends JFrame {
    
    private UserInterface() {
        buildWindow();
    }
    
    public static UserInterface getInstance() {
        return LazyHolder.INSTANCE;
    }
    
    private void clear() {
        this.getContentPane().removeAll();
    }
    
    public void setDisplay(Component component) {
        this.clear();
        this.add(component, BorderLayout.CENTER);
    }
    
    private static class LazyHolder {
        private static UserInterface INSTANCE = new UserInterface();
    }
    
    private void buildWindow() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
