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
	private Color textColor = Color.BLACK;
	private Color hintColor = Color.GRAY;
	private String hint = "";
	private String value = "";
	
	public void setTextColor(Color textColor) {
		this.textColor = textColor;
	}
	
	public void setHintColor(Color hintColor) {
		this.hintColor = hintColor;
	}
	
	public JTextHint(String hint) {
		this.hint = hint;
		this.addFocusListener(new HintListener());
		this.setForeground(hintColor);
		this.setText(hint);
	}
	
	private class HintListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent fe) {
			System.out.println("Focus was gained");
			setText(value);
			setForeground(JTextHint.this.textColor);
		}

		@Override
		public void focusLost(FocusEvent fe) {
			System.out.println("Focus Lost");
			if(getText() == hint) {
				//Do Nothing
				System.out.println("The Value was not the hint");
			} else {
				if(getText().isEmpty()) {
					setText(hint);
					setForeground(hintColor);
					value = "";
				} else {
					value = getText();
				}
			}
		}
	}
}
