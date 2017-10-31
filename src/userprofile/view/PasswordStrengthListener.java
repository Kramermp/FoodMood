package userprofile.view;

import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class PasswordStrengthListener implements DocumentListener {
	private JPasswordField passwordField;
    private JProgressBar passwordStrengthBar;

    public PasswordStrengthListener(JPasswordField passwordField, 
            JProgressBar passwordStrengthBar) {
        this.passwordField = passwordField;
        this.passwordStrengthBar = passwordStrengthBar;
    }
    
	@Override
    public void changedUpdate(DocumentEvent e) {
        updateLabel(e);
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateLabel(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateLabel(e);
    }

    private void updateLabel(DocumentEvent e) {
        char[] text = passwordField.getPassword(); //get the pass as a char array
        if (text.length > -1 && text.length < 8) {
            passwordStrengthBar.setValue(text.length);
            System.out.println("Value is "+text.length);
        } else if (text.length >= 8) {
            boolean[] strengths = {false, false, false};
            for(char c: text){
                if(Character.isDigit(c))
                    strengths[0] = true;
                if(Character.isLowerCase(c))
                    strengths[1] = true;
                if(Character.isUpperCase(c))
                    strengths[2] = true;
            }
            if(strengths[0] && strengths[1] && strengths[2]){
                passwordStrengthBar.setValue(16);
            } else if((strengths[1] && strengths[2]) || (strengths[0] && (strengths[1] || strengths[2]))){
                passwordStrengthBar.setValue(12);
            } else if(strengths[0] || strengths[1] || strengths[2]){
                passwordStrengthBar.setValue(10);
            } else {
                passwordStrengthBar.setValue(8);
            }
        }
    }
}