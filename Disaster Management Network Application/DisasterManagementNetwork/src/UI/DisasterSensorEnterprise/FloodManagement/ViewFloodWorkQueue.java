/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DisasterSensorEnterprise.FloodManagement;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.SensorMonitorOrganization;
import Business.Organization.GovernmentOfficialOrganization;
import Business.Organization.OrganizationDirectory;
import Business.Sensor.FloodSensor;
import Business.Sensor.Sensor;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FloodWorkRequest;
import Business.WorkQueue.GovernmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel; 

/**
 *
 * @author moins
 */
public class ViewFloodWorkQueue extends javax.swing.JPanel {
    
    private OrganizationDirectory directory;
    private UserAccount userAccount;
    private JPanel userProcessContainer;
    private EcoSystem business;

    /**
     * Creates new form ViewAirPollutionWorkQueue
     */
    public ViewFloodWorkQueue(JPanel userProcessContainer, UserAccount userAccount, OrganizationDirectory directory, EcoSystem business) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.directory = directory;
        this.business = business;
        
        populateTable();
    }
    
    public void populateTable(){
        FloodWorkRequest floodWorks = null;
        DefaultTableModel model = (DefaultTableModel) WorkQueueJTable.getModel();
        model.setRowCount(0);
        
        for(Organization organization : directory.getOrganizationList())
        {
            if(organization instanceof SensorMonitorOrganization)
            {
                for (WorkRequest workr : organization.getWorkQueue().getWorkRequestList()) {
                    if (workr instanceof FloodWorkRequest){
                        floodWorks = (FloodWorkRequest)workr;
            
                        Object[] row = new Object[7];
                        row[0] = floodWorks;
                        row[1] = floodWorks.getSender().getUsername();
                        row[2] = floodWorks.getFloodSensor().getSensorId();
                        row[3] = floodWorks.getFloodSensor().getZipcode();
                        row[4] = floodWorks.getStatus();
                        row[5] = floodWorks.getMessage();
                        row[6] = floodWorks.getRequestDate();
                        model.addRow(row);
                    }
                }
                }
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        PendingReqJTable = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnPendingReq = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        WorkQueueJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnResolvedMessageGov = new javax.swing.JButton();
        btnResolved = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ResolvedJTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(222, 222, 248));
        setForeground(new java.awt.Color(0, 153, 102));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Flood Work Queue");

        PendingReqJTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PendingReqJTable.setForeground(new java.awt.Color(255, 0, 51));
        PendingReqJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Work Request ID", "Sender", "Sensor ID", "Zipcode", "Status", "Message", "Sent Date"
            }
        ));
        jScrollPane1.setViewportView(PendingReqJTable);

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnPendingReq.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnPendingReq.setText("Get Pending Requests");
        btnPendingReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPendingReqActionPerformed(evt);
            }
        });

        WorkQueueJTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        WorkQueueJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Work Request ID", "Sender", "Sensor ID", "Zipcode", "Status", "Message", "Sent Date"
            }
        ));
        jScrollPane2.setViewportView(WorkQueueJTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Pending Requests");

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Resolved Requests");

        btnResolvedMessageGov.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnResolvedMessageGov.setText("Send Resolution Message to Government");
        btnResolvedMessageGov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolvedMessageGovActionPerformed(evt);
            }
        });

        btnResolved.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnResolved.setText("Get Resolved Work Requests");
        btnResolved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolvedActionPerformed(evt);
            }
        });

        ResolvedJTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ResolvedJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Work Request ID", "Sender", "Sensor ID", "Zipcode", "Status", "Message", "Sent Date"
            }
        ));
        jScrollPane3.setViewportView(ResolvedJTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnResolved, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnResolvedMessageGov, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnPendingReq, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPendingReq, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResolved, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnResolvedMessageGov, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnPendingReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPendingReqActionPerformed
        // TODO add your handling code here:
        FloodWorkRequest floodWorks = null;
        DefaultTableModel model = (DefaultTableModel) PendingReqJTable.getModel();
        model.setRowCount(0);
        
        for(Organization organization : directory.getOrganizationList())
        {
            if(organization instanceof SensorMonitorOrganization)
            {
                for (WorkRequest workr : organization.getWorkQueue().getWorkRequestList()) {
                    if (workr instanceof FloodWorkRequest)  {
                        floodWorks = (FloodWorkRequest)workr;
            
                    if(!floodWorks.getStatus().equalsIgnoreCase("Resolved"))
                    {
                        Object[] row = new Object[7];
                        row[0] = floodWorks;
                        row[1] = floodWorks.getSender().getUsername();
                        row[2] = floodWorks.getFloodSensor().getSensorId();
                        row[3] = floodWorks.getFloodSensor().getZipcode();
                        row[4] = floodWorks.getStatus();
                        row[5] = floodWorks.getMessage();
                        row[6] = floodWorks.getRequestDate();
                        model.addRow(row);
                    }
                    }
                }
                }
            }
    }//GEN-LAST:event_btnPendingReqActionPerformed

    private void btnResolvedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolvedActionPerformed
        // TODO add your handling code here:
        FloodWorkRequest floodWorks = null;
        DefaultTableModel model = (DefaultTableModel) ResolvedJTable.getModel();
        model.setRowCount(0);
        
        for(Organization organization : directory.getOrganizationList())
        {
            if(organization instanceof SensorMonitorOrganization)
            {
                for (WorkRequest workr : organization.getWorkQueue().getWorkRequestList()) {
                    if (workr instanceof FloodWorkRequest)
                    {
                        floodWorks = (FloodWorkRequest)workr;
            
                    if(floodWorks.getStatus().equalsIgnoreCase("Resolved"))
                    {
                        Object[] row = new Object[8];
                        row[0] = floodWorks;
                        row[1] = floodWorks.getSender().getUsername();
                        row[2] = floodWorks.getFloodSensor().getSensorId();
                        row[3] = floodWorks.getFloodSensor().getZipcode();
                        row[4] = floodWorks.getStatus();
                        row[5] = floodWorks.getMessage();
                        row[6] = floodWorks.getRequestDate();
                        row[7] = floodWorks.getResolveDate();
                        model.addRow(row);
                    }
                    }
                }
                }
            }

    }//GEN-LAST:event_btnResolvedActionPerformed

    private void btnResolvedMessageGovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolvedMessageGovActionPerformed
        // TODO add your handling code here:
        int row = ResolvedJTable.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }
        else
        {
            
            FloodWorkRequest CycloneStormWorkRequest = (FloodWorkRequest)ResolvedJTable.getValueAt(row, 0);

            FloodSensor floodSensor = CycloneStormWorkRequest.getFloodSensor();
            GovernmentWorkRequest reques = new GovernmentWorkRequest();
            reques.setFloodSensor(floodSensor);
            reques.setFloodMessage("Area-code "+floodSensor.getZipcode()+"is not flooded anymore");
            reques.setSender(userAccount);
            reques.setStatus("Resolution Message Sent to Government");

            Organization orgzn = null;
            for(Network ntwk: business.getNetworkList())
            {
                for(Enterprise enterprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
                {
                    for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
                    {
                        //System.out.println(org.getName());
                        if (org instanceof GovernmentOfficialOrganization){
                            orgzn = org;
                            break;
                        }
                    }
                }
            }
            if (orgzn!=null){

                ArrayList<Integer> sensorIDsArray = new ArrayList<Integer>();
                boolean workRequestAlreadyPresent = false;

                try {
                orgzn.getWorkQueue().getWorkRequestList().add(reques);
                userAccount.getWorkQ().getWorkRequestList().add(reques);
                
                return;
                } catch (Exception e) {
                }
                JOptionPane.showMessageDialog(null, "Request Successfully sent to Government");
            }
        }
    }//GEN-LAST:event_btnResolvedMessageGovActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PendingReqJTable;
    private javax.swing.JTable ResolvedJTable;
    private javax.swing.JTable WorkQueueJTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPendingReq;
    private javax.swing.JButton btnResolved;
    private javax.swing.JButton btnResolvedMessageGov;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
