/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Physician;

import Business.Doctor.Doctor;
import Business.Ecosystem;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import UserInterface.Patient.PatientHistoryJPanel;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author moins
 */
public class SearchJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SearchJPanel
     */
    private JPanel CardLayoutJPanel;
    private UserAccount account;
    private Doctor doctor;
    private Ecosystem business;
    public SearchJPanel(JPanel CardLayoutJPanel, Doctor doctor, UserAccount account, Ecosystem business) {
        initComponents();
        this.CardLayoutJPanel = CardLayoutJPanel;
        this.doctor = doctor;
        this.account = account;
        this.business = business;
        
        populatePatientComboBox();
    }
    public ArrayList<Patient> getAssociatedPatients() {
        Set<String> patientIdSet = new HashSet<>();
        ArrayList<Patient> list = new ArrayList();
        
        ArrayList<WorkRequest> workRequestOfDoctor = this.account.getWorkQueue().getWorkRequestList();
        
        for(WorkRequest w: workRequestOfDoctor) {
            
            if(w.getStatus().equals("Physician appointment completed")) {
                String patientId = w.getSender().getId();
                if(!patientId.equals(this.account.getId()) &&!patientIdSet.contains(patientId)) {
                    list.add((Patient) w.getSender().getDetails());
                    patientIdSet.add(patientId);
                }
            }
        }
        
        return list;
        
    }
    public void populatePatientComboBox() {
        
        ArrayList<Patient> list = this.getAssociatedPatients();
        Patient[] comboBoxModel4 = list.toArray(new Patient[0]);
        
        
        patientComboBox.setModel(new DefaultComboBoxModel<Patient>(comboBoxModel4));
        
    
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SearchJPanelSplitPane = new javax.swing.JSplitPane();
        leftJPanel = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        patientComboBox = new javax.swing.JComboBox<>();
        btnPatientDetails = new javax.swing.JButton();
        lblSelectPatient = new javax.swing.JLabel();
        rightJPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 153, 153));

        leftJPanel.setBackground(new java.awt.Color(172, 255, 172));
        leftJPanel.setPreferredSize(new java.awt.Dimension(194, 525));

        backBtn.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        backBtn.setText("< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        patientComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientComboBoxActionPerformed(evt);
            }
        });

        btnPatientDetails.setBackground(new java.awt.Color(98, 203, 182));
        btnPatientDetails.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnPatientDetails.setText("Patient Details");
        btnPatientDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPatientDetailsActionPerformed(evt);
            }
        });

        lblSelectPatient.setText("Select Patient:");

        javax.swing.GroupLayout leftJPanelLayout = new javax.swing.GroupLayout(leftJPanel);
        leftJPanel.setLayout(leftJPanelLayout);
        leftJPanelLayout.setHorizontalGroup(
            leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftJPanelLayout.createSequentialGroup()
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(leftJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftJPanelLayout.createSequentialGroup()
                        .addGroup(leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(patientComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSelectPatient, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnPatientDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        leftJPanelLayout.setVerticalGroup(
            leftJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftJPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(backBtn)
                .addGap(18, 18, 18)
                .addComponent(lblSelectPatient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPatientDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(328, Short.MAX_VALUE))
        );

        SearchJPanelSplitPane.setLeftComponent(leftJPanel);

        rightJPanel.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout rightJPanelLayout = new javax.swing.GroupLayout(rightJPanel);
        rightJPanel.setLayout(rightJPanelLayout);
        rightJPanelLayout.setHorizontalGroup(
            rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );
        rightJPanelLayout.setVerticalGroup(
            rightJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        SearchJPanelSplitPane.setRightComponent(rightJPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SearchJPanelSplitPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(SearchJPanelSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        CardLayoutJPanel.remove(this);
        CardLayout layout = (CardLayout) CardLayoutJPanel.getLayout();
        layout.previous(CardLayoutJPanel);
    }//GEN-LAST:event_backBtnActionPerformed

    private void btnPatientDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPatientDetailsActionPerformed
        // TODO add your handling code here:

        Patient p = (Patient) patientComboBox.getSelectedItem();
        if(p == null) {
            JOptionPane.showMessageDialog(null, "Please select a patient");
            return;
        }

        SearchJPanelSplitPane.setRightComponent(new PatientHistoryJPanel(CardLayoutJPanel, p, this.account,false));
    }//GEN-LAST:event_btnPatientDetailsActionPerformed

    private void patientComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane SearchJPanelSplitPane;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton btnPatientDetails;
    private javax.swing.JLabel lblSelectPatient;
    private javax.swing.JPanel leftJPanel;
    private javax.swing.JComboBox<Patient> patientComboBox;
    private javax.swing.JPanel rightJPanel;
    // End of variables declaration//GEN-END:variables
}
