/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.HospitalAdmin;

import Business.Community.Community;
import UserInterface.Physician.PhysicianInfoJPanel;

import Business.Doctor.Doctor;
import Business.Ecosystem;
import Business.Hospital.Hospital;
import Business.UserAccount.UserAccount;
import UserInterface.HospitalAdmin.CreatePhysicianJPanel;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moins
 */
public class ManagePhysicianJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagePhysicianJPanel
     */
    private JPanel CardLayoutJPanel;
    private Hospital hospital;
    private Community community;
    private Ecosystem business;
    UserAccount account;
    public ManagePhysicianJPanel() {
        initComponents();
    }

    public ManagePhysicianJPanel(JPanel CardLayoutJPanel, Hospital hospital, Community community, Ecosystem business,UserAccount account) {

        initComponents();
        this.CardLayoutJPanel = CardLayoutJPanel;
        this.hospital = hospital;
        this.community = community;
        this.business = business;
        this.account=account;
        
         populateTable();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblManageDoctors = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        physicianTable = new javax.swing.JTable();
        btnAddDoctor = new javax.swing.JButton();
        btnViewDoctor = new javax.swing.JButton();
        btnRefresfh = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));

        lblManageDoctors.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        lblManageDoctors.setForeground(new java.awt.Color(255, 255, 255));
        lblManageDoctors.setText("MANAGE DOCTORS");

        physicianTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Physician ID", "Physician Name", "Contact Number", "Gender", "Email ID", "License Number"
            }
        ));
        jScrollPane1.setViewportView(physicianTable);

        btnAddDoctor.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnAddDoctor.setText("Add ");
        btnAddDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDoctorActionPerformed(evt);
            }
        });

        btnViewDoctor.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnViewDoctor.setText("View ");
        btnViewDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDoctorActionPerformed(evt);
            }
        });

        btnRefresfh.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnRefresfh.setText("Refresh");
        btnRefresfh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefresfhActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        backBtn.setText("<");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblManageDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresfh, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(backBtn)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblManageDoctors)
                        .addGap(29, 29, 29)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnRefresfh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnAddDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnViewDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDoctorActionPerformed
        // TODO add your handling code here:
        CreatePhysicianJPanel createPhysicianJPanel = new CreatePhysicianJPanel(CardLayoutJPanel, business, account);
        CardLayoutJPanel.add("createPhysicianJPanel", createPhysicianJPanel);
        CardLayout layout = (CardLayout) CardLayoutJPanel.getLayout();
        layout.next(CardLayoutJPanel);
    }//GEN-LAST:event_btnAddDoctorActionPerformed

     public void populateTable() {
        // populate all patients in patient directory
        ArrayList<Doctor> doctorList = new ArrayList();
        if(hospital == null) {
           for(Hospital h: this.community.getHospitalDirectory()) {
                doctorList.addAll(h.getDoctorDirectory());
            } 
        } else {
            doctorList.addAll(this.hospital.getDoctorDirectory());
        }
        int rowCount = physicianTable.getRowCount();
        
        DefaultTableModel model = (DefaultTableModel)physicianTable.getModel();
        for(int i=rowCount-1;i>=0;i--) {
            model.removeRow(i);
        }
        
        for(Hospital h: this.community.getHospitalDirectory()){
            for(Doctor doc: h.getDoctorDirectory()) {
                Object row[] = new Object[6];
                    row[0] = doc.getDoctorId();
                    row[1] = doc.getName();
                    row[2] = doc.getPhoneNo();
                    row[3] = doc.getGender();
                    row[4] = doc.getEmailId();
                    row[5] = doc.getLicenseNo();
                model.addRow(row);
            }
        }
        
        for(Doctor d : doctorList) {
            Object row[] = new Object[6];
            row[0] = d.getDoctorId();
            row[1] = d;
            row[2] = d.getPhoneNo();
            row[3] = d.getGender();
            row[4] = d.getEmailId();
            row[5] = d.getLicenseNo();
           
            model.addRow(row);
        }
    }
    
    private void btnViewDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDoctorActionPerformed
        // TODO add your handling code here:
        int row = physicianTable.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null,
                    "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Doctor viewDoctor = (Doctor) physicianTable.getValueAt(row, 1);
        PhysicianInfoJPanel physicianInfoJPanel = new PhysicianInfoJPanel(CardLayoutJPanel, viewDoctor);
        CardLayoutJPanel.add("physicianInfoJPanel", physicianInfoJPanel);
        CardLayout layout = (CardLayout) CardLayoutJPanel.getLayout();
        layout.next(CardLayoutJPanel);
    }//GEN-LAST:event_btnViewDoctorActionPerformed

    private void btnRefresfhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefresfhActionPerformed
        // TODO add your handling code here:
        
     //   populateTable();
    }//GEN-LAST:event_btnRefresfhActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        CardLayoutJPanel.remove(this);
        CardLayout layout = (CardLayout) CardLayoutJPanel.getLayout();
        layout.previous(CardLayoutJPanel);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton btnAddDoctor;
    private javax.swing.JButton btnRefresfh;
    private javax.swing.JButton btnViewDoctor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblManageDoctors;
    private javax.swing.JTable physicianTable;
    // End of variables declaration//GEN-END:variables
}
