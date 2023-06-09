/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DisasterSensorEnterprise.FloodManagement;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.SensorMonitorOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import UI.DisasterSensorEnterprise.SensorManagement.SensorMonitorWorkArea;
/**
 *
 * @author moins
 */
public class FloodSensorJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer; 
    private UserAccount account; 
    private SensorMonitorOrganization organization; 
    private Enterprise enterprise; 
    private EcoSystem business;

    /**
     * Creates new form AirPollutionSensorJPanel
     */
    public FloodSensorJPanel(JPanel userProcessContainer, UserAccount account, SensorMonitorOrganization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnSendRequest = new javax.swing.JButton();
        btnViewRequests = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(222, 222, 248));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(91, 130, 170));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Flood Sensor");
        add(jLabel1);
        jLabel1.setBounds(0, 180, 310, 50);

        btnSendRequest.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnSendRequest.setForeground(new java.awt.Color(91, 130, 170));
        btnSendRequest.setText("Send Request");
        btnSendRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendRequestActionPerformed(evt);
            }
        });
        add(btnSendRequest);
        btnSendRequest.setBounds(640, 440, 250, 40);

        btnViewRequests.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnViewRequests.setForeground(new java.awt.Color(91, 130, 170));
        btnViewRequests.setText("View Sent Requests");
        btnViewRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRequestsActionPerformed(evt);
            }
        });
        add(btnViewRequests);
        btnViewRequests.setBounds(640, 520, 250, 40);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(20, 30, 130, 40);

        jLabel2.setBackground(new java.awt.Color(222, 222, 248));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/flood-reading.jpeg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 230, 1000, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendRequestActionPerformed
        // TODO add your handling code here:
       NotifytoFloodSolutionDepartment notifytoFloodSolutionDepartment;
       try{
            notifytoFloodSolutionDepartment = new NotifytoFloodSolutionDepartment(userProcessContainer, account, business, enterprise.getOrganizationDirectory());
            userProcessContainer.add("NotifytoFloodSolutionDepartment", notifytoFloodSolutionDepartment);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } catch (IOException ex) {
            Logger.getLogger(FloodSensorJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSendRequestActionPerformed

    private void btnViewRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRequestsActionPerformed
        // TODO add your handling code here:
        ViewFloodWorkQueue viewWorkQueueJPanel = new ViewFloodWorkQueue(userProcessContainer, account, enterprise.getOrganizationDirectory(), business);
        userProcessContainer.add("viewWorkQueueJPanel", viewWorkQueueJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewRequestsActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        JPanel panel = new SensorMonitorWorkArea(userProcessContainer,account,organization, enterprise,business);
        //Component[] componentArray = userProcessContainer.getComponents();
        //Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSendRequest;
    private javax.swing.JButton btnViewRequests;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
