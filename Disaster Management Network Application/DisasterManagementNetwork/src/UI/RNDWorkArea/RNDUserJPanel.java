/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.RNDWorkArea;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Role.Roles;
import java.awt.CardLayout;
import javax.management.relation.Role;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moins
 */
public class RNDUserJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoSystem business;
    /**
     * Creates new form EnvironmentSensorUserJPanel
     */
    public RNDUserJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.enterprise = enterprise;
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        
        populateTable();
        populateOrganizationComboBox();
    }

    public void populateTable() {

        DefaultTableModel model = (DefaultTableModel) tblUser.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[2];
                row[0] = ua.getUsername();
                row[1] = ua.getRole();
                ((DefaultTableModel) tblUser.getModel()).addRow(row);
            }
        }
    }
    
    public void populateOrganizationComboBox() {
        combo_Org.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            combo_Org.addItem(organization);
        }
    }
    
    public void populateEmployeeComboBox(Organization organization) {
        combo_emp.removeAllItems();

        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
            combo_emp.addItem(employee);
        }
    }
    
    private void populateRoleComboBox(Organization organization) {
        combo_role.removeAllItems();
        for (Roles role : organization.getSupportedRole()) {
            combo_role.addItem(role);
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

        jLabel5 = new javax.swing.JLabel();
        combo_Org = new javax.swing.JComboBox();
        combo_emp = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo_role = new javax.swing.JComboBox();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(222, 222, 248));
        setLayout(null);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Organization");
        add(jLabel5);
        jLabel5.setBounds(150, 350, 160, 21);

        combo_Org.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combo_Org.setForeground(new java.awt.Color(0, 0, 51));
        combo_Org.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_Org.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_OrgActionPerformed(evt);
            }
        });
        add(combo_Org);
        combo_Org.setBounds(390, 350, 250, 23);

        combo_emp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combo_emp.setForeground(new java.awt.Color(0, 0, 51));
        combo_emp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(combo_emp);
        combo_emp.setBounds(390, 400, 250, 23);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Employee");
        add(jLabel3);
        jLabel3.setBounds(150, 400, 100, 21);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Role");
        add(jLabel4);
        jLabel4.setBounds(150, 450, 70, 21);

        combo_role.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combo_role.setForeground(new java.awt.Color(0, 0, 51));
        combo_role.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_roleActionPerformed(evt);
            }
        });
        add(combo_role);
        combo_role.setBounds(390, 450, 250, 23);

        txtName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 0, 51));
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        add(txtName);
        txtName.setBounds(390, 500, 250, 23);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        add(jLabel2);
        jLabel2.setBounds(150, 550, 100, 21);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("User Name");
        add(jLabel1);
        jLabel1.setBounds(150, 500, 120, 21);

        txtPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 0, 51));
        add(txtPassword);
        txtPassword.setBounds(390, 550, 250, 23);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("RND Analyst");
        add(jLabel6);
        jLabel6.setBounds(250, 80, 290, 70);

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "User Name", "Role"
            }
        ));
        jScrollPane2.setViewportView(tblUser);

        add(jScrollPane2);
        jScrollPane2.setBounds(60, 160, 590, 94);

        btnBack.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(10, 20, 110, 50);

        btnCreate.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        add(btnCreate);
        btnCreate.setBounds(260, 600, 140, 40);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/R_D1.jpeg"))); // NOI18N
        add(jLabel7);
        jLabel7.setBounds(10, 20, 1070, 660);
    }// </editor-fold>//GEN-END:initComponents

    private void combo_OrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_OrgActionPerformed
        Organization organization = (Organization) combo_Org.getSelectedItem();
        if (organization != null) {
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_combo_OrgActionPerformed

    private void combo_roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_roleActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();
        String pss = txtPassword.getText();
        if (name.isEmpty() || pss.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No field should be empty");
            } else {String userName = txtName.getText();
        char[] passwordCharArray = txtPassword.getPassword();
        String password = String.valueOf(passwordCharArray);
        Organization organization = (Organization) combo_Org.getSelectedItem();
        Employee employee = (Employee) combo_emp.getSelectedItem();
        Roles role = (Roles) combo_role.getSelectedItem();
        if (employee == null) {
            JOptionPane.showMessageDialog(null, "You cannot add user account as employee combo box is empty");
            return;
        } else if (business.UniqueUserName(userName)) {
            organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
        } else {
            JOptionPane.showMessageDialog(null, "Username should be unique");
            return;
        }
        //enterprise.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
        //Add the organization to the enterprise
        populateTable();
        JOptionPane.showMessageDialog(null, "User created Succesfully");
        txtName.setText("");
        txtPassword.setText("");
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox combo_Org;
    private javax.swing.JComboBox combo_emp;
    private javax.swing.JComboBox combo_role;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}