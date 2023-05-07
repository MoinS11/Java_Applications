/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.HospitalAdmin;
import Business.Community.Community;
import UserInterface.SystemAdmin.*;
import Business.Ecosystem;
import Business.Hospital.Hospital;

import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author moins
 */
public class HospitalSideNavWorkAreaJpanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Ecosystem business;
    UserAccount account;
    Hospital hospital;
    /**
     * Creates new form MedicalCareWorkAreaJpanel
     */
    public HospitalSideNavWorkAreaJpanel(JPanel userProcessContainer, UserAccount account, 
             Ecosystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
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

        jPanel3 = new javax.swing.JPanel();
        manageDoctorsbtn = new javax.swing.JButton();
        editHospitalInfo = new javax.swing.JButton();
        managePatientsBtn1 = new javax.swing.JButton();
        lblPatientPortal = new javax.swing.JLabel();
        editHospitalInfo1 = new javax.swing.JButton();
        rightSystemAdminPanel = new javax.swing.JPanel();
        systemAdminPanel = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1800, 900));

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));
        jPanel3.setMinimumSize(new java.awt.Dimension(280, 840));
        jPanel3.setPreferredSize(new java.awt.Dimension(280, 840));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageDoctorsbtn.setBackground(new java.awt.Color(98, 203, 182));
        manageDoctorsbtn.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        manageDoctorsbtn.setText("Manage Doctors");
        manageDoctorsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageDoctorsbtnActionPerformed(evt);
            }
        });
        jPanel3.add(manageDoctorsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 200, 40));

        editHospitalInfo.setBackground(new java.awt.Color(98, 203, 182));
        editHospitalInfo.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        editHospitalInfo.setText("Edit Information");
        editHospitalInfo.setMaximumSize(new java.awt.Dimension(200, 40));
        editHospitalInfo.setMinimumSize(new java.awt.Dimension(200, 40));
        editHospitalInfo.setPreferredSize(new java.awt.Dimension(200, 40));
        editHospitalInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editHospitalInfoActionPerformed(evt);
            }
        });
        jPanel3.add(editHospitalInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        managePatientsBtn1.setBackground(new java.awt.Color(98, 203, 182));
        managePatientsBtn1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        managePatientsBtn1.setText("Manage Patients");
        managePatientsBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managePatientsBtn1ActionPerformed(evt);
            }
        });
        jPanel3.add(managePatientsBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 200, 40));

        lblPatientPortal.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblPatientPortal.setForeground(new java.awt.Color(255, 255, 255));
        lblPatientPortal.setText("Hospital Portal ");
        jPanel3.add(lblPatientPortal, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 180, 40));

        editHospitalInfo1.setBackground(new java.awt.Color(98, 203, 182));
        editHospitalInfo1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        editHospitalInfo1.setText("View Encounters");
        editHospitalInfo1.setMaximumSize(new java.awt.Dimension(200, 40));
        editHospitalInfo1.setMinimumSize(new java.awt.Dimension(200, 40));
        editHospitalInfo1.setPreferredSize(new java.awt.Dimension(200, 40));
        editHospitalInfo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editHospitalInfo1ActionPerformed(evt);
            }
        });
        jPanel3.add(editHospitalInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        rightSystemAdminPanel.setBackground(new java.awt.Color(255, 255, 255));
        rightSystemAdminPanel.setPreferredSize(new java.awt.Dimension(1058, 840));
        rightSystemAdminPanel.setLayout(new java.awt.CardLayout());

        systemAdminPanel.setBackground(new java.awt.Color(204, 255, 204));
        systemAdminPanel.setMinimumSize(new java.awt.Dimension(1338, 840));

        javax.swing.GroupLayout systemAdminPanelLayout = new javax.swing.GroupLayout(systemAdminPanel);
        systemAdminPanel.setLayout(systemAdminPanelLayout);
        systemAdminPanelLayout.setHorizontalGroup(
            systemAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1338, Short.MAX_VALUE)
        );
        systemAdminPanelLayout.setVerticalGroup(
            systemAdminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1031, Short.MAX_VALUE)
        );

        rightSystemAdminPanel.add(systemAdminPanel, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rightSystemAdminPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightSystemAdminPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editHospitalInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editHospitalInfoActionPerformed
        // TODO add your handling code here:
        HospitalInfoJPanel hospitalInfoJpanel  = new HospitalInfoJPanel(rightSystemAdminPanel, account, business);
        rightSystemAdminPanel.add("SystemAdminPatientPortalJPanel", hospitalInfoJpanel);
        CardLayout layout = (CardLayout) rightSystemAdminPanel.getLayout();
        layout.next(rightSystemAdminPanel);
    }//GEN-LAST:event_editHospitalInfoActionPerformed

    private void manageDoctorsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageDoctorsbtnActionPerformed
        // TODO add your handling code here:
        Community cmt = new Community();
        hospital = (Hospital) this.account.getDetails();
        ManagePhysicianJPanel systemAdminHospitalPortalJPanel = new ManagePhysicianJPanel(rightSystemAdminPanel, hospital, cmt, business,account);
        rightSystemAdminPanel.add("SystemAdminHospitalPortalJPanel", systemAdminHospitalPortalJPanel);
        CardLayout layout = (CardLayout) rightSystemAdminPanel.getLayout();
        layout.next(rightSystemAdminPanel);
    }//GEN-LAST:event_manageDoctorsbtnActionPerformed

    private void managePatientsBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managePatientsBtn1ActionPerformed
        HospitalAdminPatientPortalJPanel hospitalAdminPatientPortalJPanel  = new  HospitalAdminPatientPortalJPanel(rightSystemAdminPanel, business);
        rightSystemAdminPanel.add("HospitalAdminPatientJPanel", hospitalAdminPatientPortalJPanel);
        CardLayout layout = (CardLayout) rightSystemAdminPanel.getLayout();
        layout.next(rightSystemAdminPanel);
    }//GEN-LAST:event_managePatientsBtn1ActionPerformed

    private void editHospitalInfo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editHospitalInfo1ActionPerformed
        // TODO add your handling code here:
        HospitalAdminEncounterHistoryJPanel adminEncounterHistoryJPanel  = new  HospitalAdminEncounterHistoryJPanel(rightSystemAdminPanel, business,account);
        rightSystemAdminPanel.add("HospitalAdminPatientJPanel", adminEncounterHistoryJPanel );
        CardLayout layout = (CardLayout) rightSystemAdminPanel.getLayout();
        layout.next(rightSystemAdminPanel);
    }//GEN-LAST:event_editHospitalInfo1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editHospitalInfo;
    private javax.swing.JButton editHospitalInfo1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblPatientPortal;
    private javax.swing.JButton manageDoctorsbtn;
    private javax.swing.JButton managePatientsBtn1;
    private javax.swing.JPanel rightSystemAdminPanel;
    private javax.swing.JPanel systemAdminPanel;
    // End of variables declaration//GEN-END:variables
}
