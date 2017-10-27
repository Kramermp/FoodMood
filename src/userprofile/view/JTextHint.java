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
            this.setForeground(hintColor);
            this.setText(hint);
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
         * Used to empty the field when focus is gained.
         */
        private void clear () {
            setText("");
            setForeground(JTextHint.this.textColor);
        }
        public void prepareInput() {
            if(value.isEmpty()) {
                System.out.println("There is no value to the JTextHint");
                clear();
            } else {
                //If there is a value
                //Do Nothing
                System.out.println("The value is " + value);  
            }  
        }
        public void validateInput() {
            if(getText() == hint) {
                System.out.println("bvomm");
            }
            if(getText().isEmpty()) {
                System.out.println("Input is empty");
                setText(hint);
                setForeground(hintColor);
                value = "";
            } else {
                System.out.println("WARNIGNGNGNNGGNNG");
                value = getText();
            }
        }
	
        /**
         * This class is used to detect when the value of the field has changed
         */
	private class HintListener implements FocusListener {

            @Override
            public void focusGained(FocusEvent fe) {
                System.out.println("JTextHint gained Focus");
                prepareInput();
            }

            @Override
            public void focusLost(FocusEvent fe) {
                System.out.println("JTextHint Focus Lost");
                validateInput();
            }
	}
}
