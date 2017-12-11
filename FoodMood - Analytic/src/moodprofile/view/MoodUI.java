/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodprofile.view;

import foodmood.analytic.NavigationCntl;
import java.awt.Color;
import moodprofile.controller.MoodCntl;
import moodprofile.model.Mood;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.*;
import ui.utils.DateInputPanel;

/**
 *
 * @author mpk5206
 */
public class MoodUI extends JPanel {

    private Mood sourceMood;

    private MoodCntl parentCntl;
    private JComboBox moodInput;
    private DateInputPanel dateInputPanel;
    private JTextField timeInput;
    private JButton submit;
    private JButton listButton;
    private JButton homeButton;
    private JButton deleteButton;

    /**
     * Default Constructor for empty MoodView
     *
     * @param parentController the parentController
     */
    public MoodUI(MoodCntl moodController) {
        //System.out.println("Creating MoodUI");
        //this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.parentCntl = moodController;
        addComponents();
    }

    /**
     * Creates a MoodView of the provided MoodProfile
     *
     * @param moodProfile the source moodprofile
     * @param parentController the parent controller
     */
    public MoodUI(MoodCntl parentController, Mood mood) {
        //this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.parentCntl = parentController;
        this.sourceMood = mood;

        addComponents();
        if (sourceMood != null) {
            populateFields();
        }
    }

    private void addComponents() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel leftMargin = new JPanel();
        //leftMargin.setBackground(Color.BLUE); // For Debugging Purposes
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = .5;
        this.add(leftMargin, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = .5;
        this.add(buildInputPanel(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = .25;
        this.add(buildButtonPanel(), gbc);

        JPanel rightMargin = new JPanel();
        //rightMargin.setBackground(Color.MAGENTA); // For Debugging Purposes
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = .5;
        this.add(rightMargin, gbc);
    }

    private JPanel buildInputPanel() {
        JPanel inputPanel = new JPanel();
        // inputPanel.setBackground(Color.RED); // For Debugging Purposes
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        homeButton = new JButton("Home");
        homeButton.addActionListener((ActionEvent ae) -> {
            parentCntl.requestHomeView();
        });
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weighty = .25;
        //c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.WEST;
        inputPanel.add(homeButton, c);

        JLabel dateLbl = new JLabel("Date:");
        c.anchor = GridBagConstraints.EAST;
        c.gridx = 0;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridwidth = 1;
        c.weighty = 0;
        c.gridy = 1;
        inputPanel.add(dateLbl, c);

        dateInputPanel = new DateInputPanel();
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 1;
        inputPanel.add(dateInputPanel, c);

        JLabel timeLbl = new JLabel("Time:");
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = .25;
        c.anchor = GridBagConstraints.EAST;
        inputPanel.add(timeLbl, c);

        timeInput = new JTextField(25);
        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 1;
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.NONE;
        inputPanel.add(timeInput, c);

        JLabel moodLbl = new JLabel("Mood:");
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.NORTHEAST;
        c.weightx = .25;
        c.fill = GridBagConstraints.NONE;
        inputPanel.add(moodLbl, c);

        moodInput = new JComboBox(Mood.possiblMoods);

        c.gridx = 1;
        c.gridy = 3;
        c.weightx = .25;
        c.weighty = .5;
        c.anchor = GridBagConstraints.NORTHWEST;
        inputPanel.add(moodInput, c);

        return inputPanel;

    }

    private JPanel buildButtonPanel() {
        JPanel buttonPanel = new JPanel();
        // buttonPanel.setBackground(Color.PINK); // For Debugging Purposes
        buttonPanel.setLayout(new GridBagLayout());

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener((ActionEvent ae) -> {
            System.out.println("DeleteBtn Click Event Registered");
            if (sourceMood != null) {
                parentCntl.deleteMood(this);
                parentCntl.requestHomeView();
            }
        });
        if (sourceMood != null) {
            buttonPanel.add(deleteButton);
        }

        return buttonPanel;

    }

    public final void populateFields() {
        System.out.println("Populating Fields");
        this.moodInput.setSelectedItem(sourceMood.getName());
        this.dateInputPanel.setDate(sourceMood.getTime());
        this.timeInput.setText(String.valueOf(sourceMood.getTime().get(GregorianCalendar.HOUR)) + ":"
                + String.valueOf(sourceMood.getTime().get(GregorianCalendar.MINUTE)));
    }

    public String getMoodName() {
        return this.moodInput.getSelectedItem().toString();   
    }

    public GregorianCalendar getTime() {
        return dateInputPanel.getCalendar();
    }
}
