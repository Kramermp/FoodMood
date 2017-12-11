/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodmood.analytic;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author Michael Kramer <mpk5206 @ psu.edu>
 */
public class UserInterface extends JFrame {
	
	protected UserInterface() {
		super();
		configureWindow();
	}
	
	public static UserInterface getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	private static class LazyHolder {
		static final UserInterface INSTANCE = new UserInterface();
	}
	
	public void reset() {
		this.configureWindow();
		this.empty();
	}
	
	private void configureWindow() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension (500, 800));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Point windowLocation = new Point(screenSize.width / 2 - this.getWidth() /2,
				screenSize.height / 2 - this.getHeight() /2 );
		this.setLocation(windowLocation);
	}
	
	public void empty() {
		this.getContentPane().removeAll();
		this.repaint();
		this.revalidate();
	}
	
	
	@Override
	public Component add(Component component) {
		super.add(component);
		this.repaint();
		this.revalidate();
		return this;
	}
}
