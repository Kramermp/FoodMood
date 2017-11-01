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
    private enum State {EMPTY, DISPLAYHINT, HASVALUE};
    
    private State fieldState = State.DISPLAYHINT;
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
     * Returns the actual value of the field ignoring the hint
     * @return the actual value
     */
    public char[] getValue() {
        return value;
    }
    
        /**
     * 
     */
    public void setValue(String value) {
        this.value = value.toCharArray();
        fieldState = State.HASVALUE;
        setText(value);
        setForeground(textColor); 
    }
    
    public boolean hasValue() {
        return value.length > 0;
    }

    /**
     * Used to empty the field when focus is gained.
     */
    private void clear () {
        fieldState = State.EMPTY;
        setText("");
        setForeground(textColor);
        setEchoChar(echoChar);
    }
    
    private void displayHint() {
        fieldState = State.DISPLAYHINT;
        value = new char[0];
        setText(hint);
        setEchoChar((char) 0);
        setForeground(hintColor);
    }
    
    private void prepareForInput() {
        switch (fieldState)  {
            case DISPLAYHINT:
                // Fall Through
            case EMPTY:
                clear();
                break;
            case HASVALUE:
                // Do Nothing
                break;                   
        }
    }

    public void processInput() {
        switch(fieldState) {
            case DISPLAYHINT:
                value = new char[0];
                break;
            case EMPTY:
                // Fall Through
            case HASVALUE:
                if(getText().isEmpty())
                    displayHint();
                else { 
                    value =  getPassword();
                    fieldState = State.HASVALUE;
                }
                break;     
        }
    }
    
    /***
     * This class is used to track when the PasswordField is actually updated
     * and to ensure valid info.
     */
    private class PasswordFieldListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent fe) {
            System.out.println("Password Field gained Focus");
            prepareForInput();
        }

        @Override
        public void focusLost(FocusEvent fe) {
            System.out.println("Password Field Lost Focus");
            processInput();
        }
    }
    
}