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
    private char[] value;
    
    public JPasswordHint (String hint, int width) {
        super(width);
        this.hint = hint.toCharArray();
        this.echoChar = getEchoChar();
        displayHint();
        this.addFocusListener(new PasswordFieldListener());
    }
    
    public void setText(char[] text) {
        setText(String.valueOf(hint));
    }
    
    private void displayHint() {
        setText(hint);
        setEchoChar((char) 0);
        setForeground(hintColor);
    }
    
    private void clear() {
        setText("");
        setForeground(textColor);
        setEchoChar(echoChar);
    }
    
    private class PasswordFieldListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent fe) {
            System.out.println("Password Field gained Focus");
            if(value == null) {
                clear();
            } else {
                
            }
        }

        @Override
        public void focusLost(FocusEvent fe) {
            System.out.println("Password Field Lost Focus");
            if (getPassword().length == 0) {
                displayHint();
                value = null;
            } else {
                value = getPassword();
                setForeground(textColor);
            }
        }
        
        
        
    }
}
