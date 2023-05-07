/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Physician;

import UserInterface.Patient.*;
import Business.Ecosystem;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author moins
 */
public class PhysicianAppointmentsJPanel extends javax.swing.JPanel {

    JPanel CardLayoutJPanel;
    UserAccount account;
    Ecosystem business;
    
    /**
     * Creates new form AppointmentsJPanel
     */
    public PhysicianAppointmentsJPanel(JPanel CardLayoutJPanel, UserAccount account, Ecosystem business) {
        initComponents();
        
        this.CardLayoutJPanel = CardLayoutJPanel;
        this.business = business;
        this.account = account;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        rightJPanel = new javax.swing.JPanel();
        leftJPanel = new javax.swing.JPanel();
        UpcomingAppointmentBtn = new javax.swing.JButton();
        ScheduleAppointmentBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        rightJPanel.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout rightJPanelLayout = new javax.swing.GroupLayout(rightJPanel);
        rightJPanel.setLayout(rightJPanelLayout);
        rightJPanelLayout.setHorizontalGroup(
            rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );
        rightJPanelLayout.setVerticalGroup(
            rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(rightJPanel);

        leftJPanel.setBackground(new java.awt.Color(172, 255, 172));

        UpcomingAppointmentBtn.setBackground(new java.awt.Color(98, 203, 182));
        UpcomingAppointmentBtn.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        UpcomingAppointmentBtn.setText("Upcoming Appointments");
        UpcomingAppointmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpcomingAppointmentBtnActionPerformed(evt);
            }
        });

        ScheduleAppointmentBtn.setBackground(new java.awt.Color(98, 203, 182));
        ScheduleAppointmentBtn.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        ScheduleAppointmentBtn.setText("Pending Approvals");
        ScheduleAppointmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ScheduleAppointmentBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        backBtn.setText("< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftJPanelLayout = new javax.swing.GroupLayout(leftJPanel);
        leftJPanel.setLayout(leftJPanelLayout);
        leftJPanelLayout.setHorizontalGroup(
            leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ScheduleAppointmentBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpcomingAppointmentBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftJPanelLayout.setVerticalGroup(
            leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftJPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(backBtn)
                .addGap(72, 72, 72)
                .addComponent(UpcomingAppointmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ScheduleAppointmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(leftJPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void UpcomingAppointmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpcomingAppointmentBtnActionPerformed
        // TODO add your handling code here:
        jSplitPane1.setRightComponent(new PhysicianUpcomingAppointmentsJPanel(CardLayoutJPanel, account, business));
    }//GEN-LAST:event_UpcomingAppointmentBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        CardLayoutJPanel.remove(this);
        CardLayout layout = (CardLayout) CardLayoutJPanel.getLayout();
        layout.previous(CardLayoutJPanel);
    }//GEN-LAST:event_backBtnActionPerformed

    private void ScheduleAppointmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ScheduleAppointmentBtnActionPerformed
        // TODO add your handling code here:

        jSplitPane1.setRightComponent(new PhysicianPendingAppointmentsJPanel(CardLayoutJPanel ,account, business));
    }//GEN-LAST:event_ScheduleAppointmentBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ScheduleAppointmentBtn;
    private javax.swing.JButton UpcomingAppointmentBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel leftJPanel;
    private javax.swing.JPanel rightJPanel;
    // End of variables declaration//GEN-END:variables
}
