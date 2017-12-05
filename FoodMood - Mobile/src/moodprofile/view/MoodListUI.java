/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moodprofile.view;

import moodprofile.view.*;
import moodprofile.controller.MoodCntl;
import moodprofile.model.Mood;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author HannahGarthwaite
 */
public class MoodListUI extends JPanel {
    private MoodCntl moodCntl;
    
    /**
     * Creates new form MoodListUI
     * @param moodCntl
     */
    public MoodListUI(MoodCntl moodCntl){
        this.moodCntl = moodCntl;
        this.setLayout(new GridBagLayout());
        addComponents();
    }
    
    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        
        JPanel leftMargin = new JPanel();
        //leftMargin.setBackground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .25;
        gbc.weighty = .5;
        this.add(leftMargin, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = 10;
        this.add(displayPanel(), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;
        gbc.weighty = .5;
        this.add(buildButtonPanel(), gbc);
        
        JPanel rightMargin = new JPanel();
        //rightMargin.setBackground(Color.MAGENTA);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .25;
        gbc.weighty = .5;
        this.add(rightMargin, gbc);
    }
    
    private JPanel displayPanel() {
        JPanel displayPanel = new JPanel();
        //displayPanel.setBackground(Color.RED);
        displayPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        JButton homeBtn = new JButton("Home");
        homeBtn.addActionListener((ActionEvent ae) -> { 
            System.out.println("homeBtn Click Event Registered");
            moodCntl.requestHomeView();
        });
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = .25;
        c.weightx = 1;
        c.anchor = GridBagConstraints.WEST;
        displayPanel.add(homeBtn, c);
        
        scrollPane = new JScrollPane(buildListPanel());
        //scrollPane.setBackground(Color.PINK);
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.CENTER;
        displayPanel.add(scrollPane, c);
 
        return displayPanel;
    }
    
    private JPanel buildListPanel(){
        listPanel = new JPanel();
        listPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx =0;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        
        for (int i = 0; i < moodCntl.getMoodList().size(); i++) {
            System.out.println("Looping");
            JPanel singleMoodPanel = new JPanel();
            JLabel moodName = new JLabel(moodCntl.getMoodList().getMood(i).getName());
            singleMoodPanel.add(moodName);
            final Mood mood = moodCntl.getMoodList().getMood(i);
            listPanel.add(singleMoodPanel);
            
            //Allows user to click on a mood to view its detail
            singleMoodPanel.addMouseListener(new MouseListener() {
                
                @Override
                public void mouseClicked(MouseEvent e){
                    moodCntl.setSelectedMood(mood);
                    moodCntl.requestExtendedMoodScreen();
                }
                
                @Override
                public void mousePressed(MouseEvent e){
                    //Do Nothing
                }
                
                @Override
                public void mouseReleased(MouseEvent e){
                    //Do Nothing
                }
                
                @Override
                public void mouseEntered(MouseEvent e){
                    singleMoodPanel.setBackground(Color.lightGray);
                }
                
                @Override
                public void mouseExited(MouseEvent e){
                    singleMoodPanel.setBackground(new Color(238,238,238));
                }
            });
            c.gridy = i;
            listPanel.add(singleMoodPanel, c);
        }

        return listPanel;
    }
    
    private JPanel buildButtonPanel() {
        JPanel buttonPanel = new JPanel();
        // buttonPanel.setBackground(Color.RED); // For Debugging Purposes
        // This is just empty for now and just acts as a bottom butffer
        return buttonPanel;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        listPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Moods");

        javax.swing.GroupLayout listPanelLayout = new javax.swing.GroupLayout(listPanel);
        listPanel.setLayout(listPanelLayout);
        listPanelLayout.setHorizontalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );
        listPanelLayout.setVerticalGroup(
            listPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 397, Short.MAX_VALUE)
        );

        scrollPane.setViewportView(listPanel);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(133, 133, 133)
                            .addComponent(jLabel1))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );

    }                        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel listPanel;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
