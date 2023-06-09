/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.SensorWorkArea;

import Business.Organization.Organization;
import Business.Organization.Organization.SensorManagementType;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moins
 */
public class SensorOrganizationJPanel extends javax.swing.JPanel {

    private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    /**
     * Creates new form EnvironmentSensorOrganizationJPanel
     */
    public SensorOrganizationJPanel(JPanel userProcessContainer, OrganizationDirectory directory) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        
        populateTable();
        populateCombo();
    }
    
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_org.getModel();

        model.setRowCount(0);

        for (Organization organization : directory.getOrganizationList()) {
            Object[] row = new Object[1];

            row[0] = organization;

            model.addRow(row);
        }
    }
    
    private void populateCombo() {
        combo_Organization.removeAllItems();
        for (Organization.SensorManagementType type : Organization.SensorManagementType.values()) {
            if (!type.getValue().equals(Organization.SensorManagementType.SensorAdmin.getValue())) {
                combo_Organization.addItem(type);
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
        combo_Organization = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_org = new javax.swing.JTable();
        btn_back = new javax.swing.JButton();
        btnAddOrg = new javax.swing.JButton();
        btnDeleteOrg = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(222, 222, 248));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Organization Type ");
        add(jLabel1);
        jLabel1.setBounds(100, 350, 190, 30);

        combo_Organization.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combo_Organization.setForeground(new java.awt.Color(0, 0, 51));
        combo_Organization.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_Organization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_OrganizationActionPerformed(evt);
            }
        });
        add(combo_Organization);
        combo_Organization.setBounds(310, 360, 268, 23);

        jLabel2.setBackground(new java.awt.Color(91, 130, 170));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel2.setText("Sensor Management Organization");
        add(jLabel2);
        jLabel2.setBounds(40, 100, 770, 60);

        tbl_org.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }
        ));
        jScrollPane2.setViewportView(tbl_org);

        add(jScrollPane2);
        jScrollPane2.setBounds(50, 180, 490, 112);

        btn_back.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btn_back.setText("<<Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        add(btn_back);
        btn_back.setBounds(10, 10, 95, 40);

        btnAddOrg.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnAddOrg.setForeground(new java.awt.Color(51, 51, 51));
        btnAddOrg.setText("Add Organization");
        btnAddOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrgActionPerformed(evt);
            }
        });
        add(btnAddOrg);
        btnAddOrg.setBounds(110, 440, 180, 50);

        btnDeleteOrg.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnDeleteOrg.setForeground(new java.awt.Color(51, 51, 51));
        btnDeleteOrg.setText("Delete Organization");
        btnDeleteOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOrgActionPerformed(evt);
            }
        });
        add(btnDeleteOrg);
        btnDeleteOrg.setBounds(340, 440, 210, 50);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/emp2.jpeg"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(10, 60, 1010, 660);
    }// </editor-fold>//GEN-END:initComponents

    private void combo_OrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_OrganizationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_OrganizationActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btnAddOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrgActionPerformed
        // TODO add your handling code here:
        
        SensorManagementType type = (SensorManagementType) combo_Organization.getSelectedItem();

        directory.createSensorManagement(type);
        JOptionPane.showMessageDialog(this, "Organization Added Successfully!");
        populateTable();
    }//GEN-LAST:event_btnAddOrgActionPerformed

    private void btnDeleteOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOrgActionPerformed
        // TODO add your handling code here:
           // TODO add your handling code here:
        int selectedRow = tbl_org.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select the row");
            return;
        }
        Organization org = (Organization) tbl_org.getValueAt(selectedRow, 0);
        directory.DeleteOrganization(org);
        populateTable();
        JOptionPane.showMessageDialog(null, "Organization deleted Succesfully");
    }//GEN-LAST:event_btnDeleteOrgActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddOrg;
    private javax.swing.JButton btnDeleteOrg;
    private javax.swing.JButton btn_back;
    private javax.swing.JComboBox combo_Organization;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_org;
    // End of variables declaration//GEN-END:variables
}
