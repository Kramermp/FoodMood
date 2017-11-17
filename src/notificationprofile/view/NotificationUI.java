/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notificationprofile.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import notificationprofile.controller.NotificationCntl;
import notificationprofile.model.Notification;

/**
 *
 * @author HannahGarthwaite
 */
public class NotificationUI extends JPanel {
    
    private NotificationCntl parentCntl;
    private Notification sourceNotification;
    
    /**
     * Creates new form NotificationUI
     */
    public NotificationUI() {
        initComponents();
    }
    
    public NotificationUI(NotificationCntl theNotificationCntl){
        this.parentCntl = theNotificationCntl;
        this.sourceNotification = theNotificationCntl.getSelectedNotification();
        this.sourceNotification.setRead(true);
        initComponents();
    }
           
    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        jPanel1 = new javax.swing.JPanel();
        notificationLbl = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        titleLbl = new javax.swing.JLabel();
        descriptionLbl = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        nextBtn = new javax.swing.JButton();
        previousBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();

        notificationLbl.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        notificationLbl.setText("Notification");

        titleLbl.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        titleLbl.setText("Title: " + sourceNotification.getName());

        descriptionLbl.setText("Description: " + sourceNotification.getDescription());

        timeLbl.setText("Time: " + sourceNotification.getTimeString());
        
        mainPanel.setLayout(new GridBagLayout());
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = .25;
        mainPanel.add(titleLbl, c);
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = .25;
        mainPanel.add(timeLbl, c);
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = .25;
        mainPanel.add(descriptionLbl, c);
        

        nextBtn.setText("Next >>");
        nextBtn.addActionListener((ActionEvent ae) -> {
            parentCntl.next();
        });

        previousBtn.setText("<< Previous");
        previousBtn.addActionListener((ActionEvent ae) -> {
            parentCntl.previous();
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener((ActionEvent ae) -> {
            parentCntl.deleteNotification();
        });
        if(parentCntl.hasPrevious()) {
            buttonPanel.add(previousBtn);
        }
        buttonPanel.add(deleteBtn);
        if(parentCntl.hasNext()) {
            buttonPanel.add(nextBtn);
        }
        //buttonPanel.setBackground(Color.RED);

        homeBtn.setText("Home");
        homeBtn.addActionListener((ActionEvent ae) -> {
            parentCntl.requestHomeView();
        });
        
        
        c.gridx = 0;
        c.gridy = 0;
        c.weighty = .5;
        c.anchor = GridBagConstraints.WEST;
        add(homeBtn, c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.weighty = 1;
        c.anchor = GridBagConstraints.CENTER;
        add(mainPanel, c);
        
        c.gridx = 0;
        c.gridy = 2;
        c.weighty = .5;
        c.anchor = GridBagConstraints.NORTH;
        add(buttonPanel, c);
        //setBackground(Color.RED);
    }                     

    private void jButton1ActionPerformed(java.awt.event.ActionEvent ae) {                                         
        parentCntl.next();
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent ae) {                                         
        parentCntl.previous();
       
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent ae) {                                         
        this.setVisible(false);
        parentCntl.deleteNotification(sourceNotification.getId());
//        parentCntl.viewNotificationList();
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent ae) {                                         
        this.setVisible(false);
        parentCntl.goHome();
    }                                        

    // Variables declaration - do not modify                     
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton previousBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel notificationLbl;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JLabel descriptionLbl;
    private javax.swing.JLabel timeLbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration                   
}
