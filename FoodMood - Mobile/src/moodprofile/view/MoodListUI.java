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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author HannahGarthwaite
 */
public class MoodListUI extends JPanel {

    MoodCntl moodCntl;
    /**
     * Creates new form MoodListUI
     */
    public MoodListUI() {
        initComponents();
    }
    public MoodListUI(MoodCntl moodCntl){
        this.moodCntl = moodCntl;
        initComponents();
        initCustomComponents();
    }
    
    public void initCustomComponents(){
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        
        for (int i = 0; i < moodCntl.getMoodList().size(); i++) {
            
            JPanel singleMoodPanel = new JPanel();
            JLabel moodName = new JLabel(moodCntl.getMoodList().getMood(i).getName());
            singleMoodPanel.add(moodName);
            final Mood mood = moodCntl.getMoodList().getMood(i);
            listPanel.add(singleMoodPanel);
            
            //Allows user to click on a mood to view its detail
            singleMoodPanel.addMouseListener(new MouseListener() {
                
                public void mouseClicked(MouseEvent e){
                    viewMood(mood);
                }
                
                public void mousePressed(MouseEvent e){
                    
                }
                
                public void mouseReleased(MouseEvent e){
                    
                }
                
                public void mouseEntered(MouseEvent e){
                    singleMoodPanel.setBackground(Color.lightGray);
                }
                
                public void mouseExited(MouseEvent e){
                    singleMoodPanel.setBackground(new Color(238,238,238));
                }
            });
            listPanel.add(singleMoodPanel);
            scrollPane.getViewport().add(listPanel, BorderLayout.NORTH);
        }
        scrollPane.getViewport().add(listPanel, BorderLayout.NORTH);
            
    }
    
    public void viewMood(Mood mood){
        this.setVisible(false);
        moodCntl.viewMood(mood);
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

        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Create New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

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

    }// </editor-fold>                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        moodCntl.newMood();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        moodCntl.goHome();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MoodListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MoodListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MoodListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MoodListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MoodListUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel listPanel;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
