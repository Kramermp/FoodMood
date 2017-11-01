/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userprofile.view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author Michael Kramer <mpk5206 @ psu.edu>
 */
public class JTextHint extends JTextField {
    private enum State {DISPLAYHINT, EMPTY, HASVALUE};
    private State fieldState = State.DISPLAYHINT;
    
    private HintListener listener;
    private Color textColor = Color.BLACK;
    private Color hintColor = Color.GRAY;
    private String hint = "";
    private String value = "";
    
    /**
     * Creates a JTextField that displays a text hint there is no value
     * @param hint The String to display as a hint
     * @param width The width of the field
     */
    public JTextHint(String hint, int width) {
        super(width);
        this.hint = hint;
        this.listener = new HintListener();
        this.addFocusListener(listener);
        this.setForeground(hintColor);
        this.setText(hint);
    }
        
    /**
     * Creates a JTextField that displays a text hint if there is no value
     * @param hint The String to display as the hint
     */
    public JTextHint(String hint) {
        this.hint = hint;
        this.addFocusListener(new HintListener());
        this.displayHint();
    }

    /**
     * Sets the color of the text after values have been input
     * @param textColor The color to be displayed
     */
    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
    
        /**
         * Sets the color of the hint
         * @param hintColor 
         */
    public void setHintColor(Color hintColor) {
        this.hintColor = hintColor;
    }
    
    /** 
     * Gets the actual value of the field ignoring the hint
     * @return the value of the hint
     */
    public String getValue() {
        return value;
    }
    

    /**
     * 
     */
    public void setValue(String value) {
        this.value = value;
        this.fieldState = State.HASVALUE;
        setForeground(textColor); 
        setText(value);
    }
    
    public boolean hasValue() {
        return !value.isEmpty();
    }

    /**
     * Used to empty the field when focus is gained.
     */
    private void clear () {
        fieldState = State.EMPTY;
        setText("");
        setForeground(textColor);
    }
    
    private void displayHint() {
        fieldState = State.DISPLAYHINT;
        value = "";
        setText(hint);
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
                value = "";
                break;
            case EMPTY:
                // Fall Through
            case HASVALUE:
                if(getText().isEmpty())
                    displayHint();
                else { 
                    value =  getText();
                    fieldState = State.HASVALUE;
                }
                break;     
        }
    }

    /**
     * This class is used to detect when the value of the field has changed
     */
    private class HintListener implements FocusListener {
        
        @Override
        public void focusGained(FocusEvent fe) {
            System.out.println("JTextHint gained Focus");
            prepareForInput();
        }

        @Override
        public void focusLost(FocusEvent fe) {
            System.out.println("JTextHint Focus Lost");
            processInput();
        }
    }
}
