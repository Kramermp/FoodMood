/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;
import javax.swing.JPasswordField;

/**
 *
 * @author Michael Kramer <mpk5206 @ psu.edu>
 */
public class JPasswordHint extends JPasswordField {
    private Color hintColor = Color.GRAY;
    private Color textColor = Color.BLACK;
    private char echoChar;
    private char[] hint;
    private char[] value = {};
    
    public JPasswordHint (String hint, int width) {
        super(width);
        this.hint = hint.toCharArray();
        this.echoChar = getEchoChar();
        displayHint();
        this.addFocusListener(new PasswordFieldListener());
    }
    
    /**
     * Creates a JPassword field to display text before user inputs values
     * @param hint The String to be displayed
     */
    public JPasswordHint (String hint) {
        this.hint = hint.toCharArray();
        this.echoChar = getEchoChar(); //Stores the default Echo char
        displayHint();
        this.addFocusListener(new PasswordFieldListener());
    }
    
    /**
     * Sets the text to be displayed
     * @param text the text to be displayed
     */
    public void setText(char[] text) {
        setText(String.valueOf(hint));
    }
    
    /**
     * This is used internally to display the hint to ensure that the class
     * consistently makes the same changes
     */
    private void displayHint() {
        setText(hint);
        setEchoChar((char) 0);
        setForeground(hintColor);
    }
    
    /**
     * This is used for when the User gets focus on the field to ensure it
     * is empty in preparation for them entering their own data.
     */
    private void clear() {
        setText("");
        setForeground(textColor);
        setEchoChar(echoChar);
    }
    
    /**
     * Returns the actual value of the field ignoring the hint
     * @return the actual value
     */
    public char[] getValue() {
        return value;
    }
    
    /***
     * This class is used to track when the PasswordField is actually updated
     * and to ensure valid info.
     */
    private class PasswordFieldListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent fe) {
            System.out.println("Password Field gained Focus");
            if(value == null || value.length == 0) {
                //If it gains focus and there is no value
                clear();
            } else {
                //If it gains focus and there is actual data in the field
                //Do Nothing
            }
        }

        @Override
        public void focusLost(FocusEvent fe) {
            System.out.println("Password Field Lost Focus");
            if (getPassword().length == 0) {
                //If it loses focus and there is no data
                displayHint();
                value = new char[0]; //Clear old value
            } else {
                //If it loses focus and there is values is there
                value = getPassword();
                setForeground(textColor);
            }
        }
    }
    
}