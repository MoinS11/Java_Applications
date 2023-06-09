/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemAdmin;

import UserInterface.HospitalAdmin.*;
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
public class ManageDoctorJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagePhysicianJPanel
     */
    private JPanel CardLayoutJPanel;
    private Hospital hospital;
    private Ecosystem business;
    UserAccount account;
    ArrayList<Community> communities;
    ArrayList<Hospital> hospitals;
    public ManageDoctorJPanel(JPanel CardLayoutJPanel, Ecosystem business) {

        initComponents();
        this.CardLayoutJPanel = CardLayoutJPanel;
        this.hospital = hospital;
        this.business = business;
        
        communities = new ArrayList<>();
        for (UserAccount account1 : business.getUserAccountDirectory().getUserAccountList()){
            System.out.println("UserInterface.SystemAdmin.SystemAdminHospitalPortalJPanel.<init>()"+ account1.getRole().toString());
            if(account1.getRole().toString().contains("CommunityAdminRole")){
              communities.add((Community)account1.getDetails());
            }
        }
        
        ArrayList<Hospital> hospitalList = new ArrayList<>();
        for(Community c  : communities){
            if(c.getHospitalDirectory().size()>0)
                for(Hospital h : c.getHospitalDirectory()){
                    hospitalList.add( h);
                }
            
       
        
        }
        hospitals=hospitalList;
        
        
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
        btnDeleteDoctor = new javax.swing.JButton();
        btnViewDoctor = new javax.swing.JButton();
        btnRefresfh = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));
        setPreferredSize(new java.awt.Dimension(1506, 629));

        lblManageDoctors.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        lblManageDoctors.setForeground(new java.awt.Color(255, 255, 255));
        lblManageDoctors.setText("MANAGE DOCTORS");

        physicianTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Physician ID", "Physician Name", "Contact Number", "Gender", "Email ID", "License Number", "Community", "Hospital"
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

        btnDeleteDoctor.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnDeleteDoctor.setText("Delete");
        btnDeleteDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDoctorActionPerformed(evt);
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
                    .addComponent(btnDeleteDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresfh, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblManageDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(lblManageDoctors)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backBtn)
                        .addGap(22, 22, 22)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnRefresfh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnAddDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnDeleteDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnViewDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDoctorActionPerformed
        // TODO add your handling code here:
        CreateDoctorJPanel createDoctorJPanel = new CreateDoctorJPanel(CardLayoutJPanel, business);
        CardLayoutJPanel.add("createPhysicianJPanel", createDoctorJPanel);
        CardLayout layout = (CardLayout) CardLayoutJPanel.getLayout();
        layout.next(CardLayoutJPanel);
    }//GEN-LAST:event_btnAddDoctorActionPerformed

    private void btnDeleteDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDoctorActionPerformed
        // TODO add your handling code here:
        int row = physicianTable.getSelectedRow();
        

        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String selectedHospital = physicianTable.getValueAt(row, 7).toString();
        String selectedCommunity =  physicianTable.getValueAt(row, 6).toString();
        
        ArrayList<Community> communities = business.getCommunityDirectory().getCommunityList();
        Community community = null;
        for(Community c : communities){
            if(c.getName().equalsIgnoreCase(selectedCommunity)){
            community = c;   
            }
        }
        
        ArrayList<Hospital> hospitals = community.getHospitalDirectory();
        Hospital hospital = null;
        for(Hospital h : hospitals){
            if(h.getName().equalsIgnoreCase(selectedHospital)){
            hospital = h;   
            }
        }
        
        String selectedDoctor =  physicianTable.getValueAt(row, 0).toString();
        
        hospital.deleteDoctor(selectedDoctor,business);
        populateTable();
    }//GEN-LAST:event_btnDeleteDoctorActionPerformed

     public void populateTable() {
        // populate all patients in patient directory
        ArrayList<Doctor> doctorList = new ArrayList();
        if(hospital == null) {
           for(Hospital h: hospitals) {
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
        
        for(Hospital h: hospitals){
            for(Doctor doc: h.getDoctorDirectory()) {
                Object row[] = new Object[8];
                    row[0] = doc.getDoctorId();
                    row[1] = doc.getName();
                    row[2] = doc.getPhoneNo();
                    row[3] = doc.getGender();
                    row[4] = doc.getEmailId();
                    row[5] = doc.getLicenseNo();
                    
                    row[6]=  h.getCommunity().getName();
                    
                    row[7] = doc.getHospital().getName();
                model.addRow(row);
            }
        }
        
//        for(Doctor d : doctorList) {
//            Object row[] = new Object[6];
//            row[0] = d.getDoctorId();
//            row[1] = d;
//            row[2] = d.getPhoneNo();
//            row[3] = d.getGender();
//            row[4] = d.getEmailId();
//            row[5] = d.getLicenseNo();
//           
//            model.addRow(row);
//        }
    }
    
    private void btnViewDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDoctorActionPerformed
        // TODO add your handling code here:
        int row = physicianTable.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null,
                    "Please select a row from the table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String selectedHospital = physicianTable.getValueAt(row, 7).toString();
        String selectedCommunity =  physicianTable.getValueAt(row, 6).toString();
        String selectedDoctor = physicianTable.getValueAt(row, 1).toString();
        
        ArrayList<Community> communities = business.getCommunityDirectory().getCommunityList();
        Community community = null;
        for(Community c : communities){
            if(c.getName().equalsIgnoreCase(selectedCommunity)){
            community = c;   
            }
        }
        
        ArrayList<Hospital> hospitals = community.getHospitalDirectory();
        Hospital hospital = null;
        for(Hospital h : hospitals){
            if(h.getName().equalsIgnoreCase(selectedHospital)){
            hospital = h;   
            }
        }
        
        ArrayList<Doctor> doctors = hospital.getDoctorDirectory();
        Doctor viewDoctor = null;
        for(Doctor d: doctors){
            if(d.getName().equalsIgnoreCase(selectedDoctor)){
                viewDoctor=d;
            }
        }
        DoctorInfoJPanel doctorInfoJPanel = new DoctorInfoJPanel(CardLayoutJPanel, viewDoctor);
        CardLayoutJPanel.add("doctorInfoJPanel", doctorInfoJPanel);
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
    private javax.swing.JButton btnDeleteDoctor;
    private javax.swing.JButton btnRefresfh;
    private javax.swing.JButton btnViewDoctor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblManageDoctors;
    private javax.swing.JTable physicianTable;
    // End of variables declaration//GEN-END:variables
}
