/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DisasterManagementWorkQueue;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.FloodManagementOrganization;
import Business.Organization.Organization;
import Business.WorkQueue.FloodWorkRequest;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moins
 */
public class FloodManagementWorkQueueJPanel extends javax.swing.JPanel {
private OrganizationDirectory directory;
    private UserAccount userAccount;
    private FloodManagementOrganization organization;
    private Enterprise enterprise; 
    private EcoSystem business;
    private JPanel userProcessContainer;
    /**
     * Creates new form FloodManagementWorkQueueJPanel
     * @param userProcessContainer
     */
    public FloodManagementWorkQueueJPanel(JPanel userProcessContainer, UserAccount userAccount, OrganizationDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.directory = directory;
        this.organization = organization;
        this.enterprise = enterprise;
        this.business = business;
        
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

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkQueue = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnResolve = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(222, 222, 248));
        setLayout(null);

        lblTitle.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(91, 130, 170));
        lblTitle.setText("Flood Management Work Queue");
        add(lblTitle);
        lblTitle.setBounds(10, 170, 820, 70);

        tblWorkQueue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Work_Request", "Sender", "Sensor_Id", "Zip"
            }
        ));
        jScrollPane1.setViewportView(tblWorkQueue);

        add(jScrollPane1);
        jScrollPane1.setBounds(180, 370, 670, 220);

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(20, 30, 91, 50);

        btnResolve.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnResolve.setText("Resolve");
        btnResolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolveActionPerformed(evt);
            }
        });
        add(btnResolve);
        btnResolve.setBounds(470, 630, 122, 50);

        jLabel2.setBackground(new java.awt.Color(222, 222, 248));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Flood.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(-390, 250, 1450, 660);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
                                                   
        userProcessContainer.remove(this);
        JPanel panel = new FloodManagementWorkJPanel(userProcessContainer,userAccount,organization, enterprise,business);

        //Component[] componentArray = userProcessContainer.getComponents();
        //Component component = componentArray[componentArray.length - 1];
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
       
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnResolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolveActionPerformed
        // TODO add your handling code here:
        int getSelectedRow = tblWorkQueue.getSelectedRow();
        if(getSelectedRow <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        Random rn = new Random();
        
        WorkRequest workRequest = (WorkRequest) tblWorkQueue.getValueAt(getSelectedRow, 0);
        
        FloodWorkRequest floodSolutionWorkRequest = (FloodWorkRequest)workRequest;
        floodSolutionWorkRequest.setStatus("Resolved");
        floodSolutionWorkRequest.setResolveDate(new Date());
        
        floodSolutionWorkRequest.getFloodSensor().setCurrentlevel(rn.nextInt(100));
        
        populateTable();
        
        JOptionPane.showMessageDialog(null, "Problem Resolved");
        }
    }//GEN-LAST:event_btnResolveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnResolve;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblWorkQueue;
    // End of variables declaration//GEN-END:variables

    private void populateTable() {
        FloodWorkRequest air_wrs = null;
        DefaultTableModel model = (DefaultTableModel) tblWorkQueue.getModel();
        model.setRowCount(0);
        
        for(Organization organization : directory.getOrganizationList())
        {
        for (WorkRequest wr : organization.getWorkQueue().getWorkRequestList()) {
            if (wr instanceof FloodWorkRequest) {
                air_wrs = (FloodWorkRequest)wr;
            
                Object[] row = new Object[8];
                row[0] = air_wrs;
                row[1] = air_wrs.getSender().getUsername();
                row[2] = air_wrs.getFloodSensor().getSensorId();
                row[3] = air_wrs.getFloodSensor().getZipcode();
                row[4] = air_wrs.getStatus();
                row[5] = air_wrs.getMessage();
                row[6] = air_wrs.getRequestDate();
                row[7] = air_wrs.getResolveDate();
                model.addRow(row);
            }
        }
        }

    }
    
}
