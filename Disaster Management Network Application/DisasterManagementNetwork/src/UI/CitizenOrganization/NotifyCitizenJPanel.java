/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.CitizenOrganization;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.GovernmentOfficialOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Organization.CitizenOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CitizenWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author moins
 */
public class NotifyCitizenJPanel extends javax.swing.JPanel {
    private OrganizationDirectory directory;
    private UserAccount userAccount;
    private JPanel userProcessContainer;

    public NotifyCitizenJPanel(JPanel userProcessContainer, UserAccount userAccount, OrganizationDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.directory = directory;
        
        populateTable();
    }
    /**
     * Creates new form NotifyResidentJPanel
     */
    public NotifyCitizenJPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkRequest = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnViewFullMessage = new javax.swing.JButton();
        lblMessage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 102));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("CITIZEN WORK QUEUE");
        add(lblTitle);
        lblTitle.setBounds(300, 27, 838, 40);

        tblWorkRequest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblWorkRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Work_Request_ID", "Sender", "Message"
            }
        ));
        jScrollPane1.setViewportView(tblWorkRequest);

        add(jScrollPane1);
        jScrollPane1.setBounds(143, 85, 710, 166);

        btnBack.setText("<<BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(730, 275, 123, 30);

        btnViewFullMessage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnViewFullMessage.setText("View Full Message");
        btnViewFullMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewFullMessageActionPerformed(evt);
            }
        });
        add(btnViewFullMessage);
        btnViewFullMessage.setBounds(380, 280, 199, 40);

        lblMessage.setForeground(new java.awt.Color(255, 0, 0));
        add(lblMessage);
        lblMessage.setBounds(106, 401, 811, 91);

        jLabel2.setBackground(new java.awt.Color(222, 222, 248));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/alert.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(-250, -520, 1580, 1350);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewFullMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewFullMessageActionPerformed
        // TODO add your handling code here:
        int getSelectedRow = tblWorkRequest.getSelectedRow();
        if(getSelectedRow <0){
            JOptionPane.showMessageDialog(null, "No row selected");
            return;
        }
        else
        {
        CitizenWorkRequest request = (CitizenWorkRequest)tblWorkRequest.getValueAt(getSelectedRow, 0);
        if(request.getCycloneStormSensor() != null){
        lblMessage.setText(request.getCycloneStormMessage());
        }
        else if(request.getFloodSensor() != null)
        {
        lblMessage.setText(request.getFloodMessage());
        }
        else if(request.getEarthquakeSensor() != null)
        {
        lblMessage.setText(request.getEarthquakeMessage());
        }    
        }
    }//GEN-LAST:event_btnViewFullMessageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnViewFullMessage;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblWorkRequest;
    // End of variables declaration//GEN-END:variables

    public void populateTable() {
        CitizenWorkRequest cwr = null;
        DefaultTableModel model = (DefaultTableModel) tblWorkRequest.getModel();
        model.setRowCount(0);
        
        for(Organization organization : directory.getOrganizationList())
        {
            if(organization instanceof CitizenOrganization) {
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof CitizenWorkRequest) 
            {
                cwr = (CitizenWorkRequest)wr;
            
                if(cwr.getCycloneStormSensor()!=null)
                {
                Object[] row1 = new Object[3];
                row1[0] = cwr;
                row1[1] = cwr.getSender().getUsername();
                row1[2] = cwr.getCycloneStormMessage();
                model.addRow(row1);
                }
                            
                else if(cwr.getEarthquakeSensor() != null)
                {
                Object[] row = new Object[3];
                row[0] = cwr;
                row[1] = cwr.getSender().getUsername();
                row[2] = cwr.getEarthquakeMessage();
                model.addRow(row);
                }
                
                else if(cwr.getFloodSensor() != null)
                {
                Object[] row = new Object[3];
                row[0] = cwr;
                row[1] = cwr.getSender().getUsername();
                row[2] = cwr.getFloodMessage();
                model.addRow(row);
                }
                
            }
        }
      }
        }    }
}
