/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.GovernmentAgencyWorkArea;


import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Business.Organization.Organization.GovernmentAgencyType;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;

/**
 *
 * @author rahul
 */
public class GovernmentOrganizationJPanel extends javax.swing.JPanel {

    private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    /**
     * Creates new form GovernmentEnterpriseJPanel
     */
    public GovernmentOrganizationJPanel(JPanel userProcessContainer, OrganizationDirectory directory) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        
        populateTable();
        populateCombo();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_govorg.getModel();

        model.setRowCount(0);

        for (Organization organization : directory.getOrganizationList()) {
            Object[] row = new Object[1];

            row[0] = organization;

            model.addRow(row);
        }
    }
    
    private void populateCombo() {
        combo_org.removeAllItems();
        for (Organization.GovernmentAgencyType type : Organization.GovernmentAgencyType.values()) {
            if (!type.getValue().equals(Organization.GovernmentAgencyType.GovernmentAdmin.getValue())) {
                combo_org.addItem(type);
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
        combo_org = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_govorg = new javax.swing.JTable();
        btnAddOrg = new javax.swing.JButton();
        btnDeleteOrg = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(222, 222, 248));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Organization Type ");
        add(jLabel1);
        jLabel1.setBounds(150, 430, 180, 21);

        combo_org.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        combo_org.setForeground(new java.awt.Color(0, 0, 51));
        combo_org.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_org.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_orgActionPerformed(evt);
            }
        });
        add(combo_org);
        combo_org.setBounds(330, 430, 268, 21);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(91, 130, 170));
        jLabel2.setText("Government Organization");
        add(jLabel2);
        jLabel2.setBounds(80, 90, 660, 60);

        tbl_govorg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbl_govorg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_govorg);

        add(jScrollPane2);
        jScrollPane2.setBounds(40, 250, 660, 120);

        btnAddOrg.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnAddOrg.setText("Add ");
        btnAddOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrgActionPerformed(evt);
            }
        });
        add(btnAddOrg);
        btnAddOrg.setBounds(190, 490, 170, 40);

        btnDeleteOrg.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        btnDeleteOrg.setText("Delete");
        btnDeleteOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteOrgActionPerformed(evt);
            }
        });
        add(btnDeleteOrg);
        btnDeleteOrg.setBounds(370, 490, 170, 40);

        btnBack.setText("<<BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(30, 20, 95, 30);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/gov3.jpeg"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(0, 50, 1030, 710);
    }// </editor-fold>//GEN-END:initComponents

    private void combo_orgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_orgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_orgActionPerformed

    private void btnAddOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrgActionPerformed
        // TODO add your handling code here:
         GovernmentAgencyType type = (GovernmentAgencyType) combo_org.getSelectedItem();

        directory.createGovernmentAgency(type);
        //directory.createEnvironmentManagement(type);
        JOptionPane.showMessageDialog(this, "Organization Added Successfully!");
        populateTable();
    }//GEN-LAST:event_btnAddOrgActionPerformed

    private void btnDeleteOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteOrgActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int selectedRow = tbl_govorg.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select the row");
            return;
        }
        Organization org = (Organization) tbl_govorg.getValueAt(selectedRow, 0);
        directory.DeleteOrganization(org);
        populateTable();
        JOptionPane.showMessageDialog(null, "Organization Deleted Succesfully");
    }//GEN-LAST:event_btnDeleteOrgActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddOrg;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteOrg;
    private javax.swing.JComboBox combo_org;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_govorg;
    // End of variables declaration//GEN-END:variables
}