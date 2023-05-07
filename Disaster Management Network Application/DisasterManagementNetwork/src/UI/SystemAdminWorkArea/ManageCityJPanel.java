/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Map.MapViewer;
import Business.Network.Network;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author moins
 */
public class ManageCityJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    public static int selectedRowIndex = -1;

    
    /**
     * Creates new form ManageCityJPanel
     */
    public ManageCityJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.system = system;

        populateCityTable();
    }

    private void populateCityTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_city.getModel();

        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            Object[] row = new Object[1];
            row[0] = network;
            model.addRow(row);
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
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_city = new javax.swing.JTable();
        btnView = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btn_submit = new javax.swing.JButton();
        btnLocate = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(222, 222, 248));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Name");
        add(jLabel1);
        jLabel1.setBounds(250, 440, 60, 30);

        txtName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 0, 51));
        add(txtName);
        txtName.setBounds(310, 440, 190, 30);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel2.setText("Manage City");
        add(jLabel2);
        jLabel2.setBounds(290, 70, 150, 29);

        tbl_city.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_city);

        add(jScrollPane2);
        jScrollPane2.setBounds(120, 110, 490, 230);

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        add(btnView);
        btnView.setBounds(250, 350, 120, 40);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate);
        btnUpdate.setBounds(400, 350, 120, 40);

        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });
        add(btn_submit);
        btn_submit.setBounds(260, 490, 120, 40);

        btnLocate.setText("Locate");
        btnLocate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocateActionPerformed(evt);
            }
        });
        add(btnLocate);
        btnLocate.setBounds(540, 440, 80, 30);

        btn_back.setText("<<Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        add(btn_back);
        btn_back.setBounds(30, 30, 120, 40);

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        add(btn_delete);
        btn_delete.setBounds(390, 490, 120, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/City3.jpeg"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(1500, 800));
        add(jLabel3);
        jLabel3.setBounds(-510, -720, 2800, 2730);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
          int selectedRow = tbl_city.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please Select the row");
            return;
        }
        Network net = (Network) tbl_city.getValueAt(selectedRow, 0);
        system.DeleteCity(net);
        JOptionPane.showMessageDialog(this, "City Deleted!");
        populateCityTable();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        //SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        //sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        // TODO add your handling code here:
        
        String name = txtName.getText();

        if (!system.checkIfCityNameisUnique(name)) {
            if (!name.isEmpty()) {
                Network network = system.createAndAddNetwork();
                network.setName(name);
                populateCityTable();
                JOptionPane.showMessageDialog(this, "City Added Successfully!");
                txtName.setText("");
                
            } else {
                JOptionPane.showMessageDialog(null, "City Should have a name.");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "City Already Exists");
            return;
        }
    }//GEN-LAST:event_btn_submitActionPerformed

    private void btnLocateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocateActionPerformed
        // TODO add your handling code here:
        if (txtName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter City To Locate");
        } 
        else {
            SwingUtilities.invokeLater(new Runnable() 
            {
                @Override
                public void run() {
                    MapViewer browser = new MapViewer();
                    browser.setVisible(true);
                    browser.loadURL("https://www.google.com/maps/search/?api=1&query="+ txtName.getText().trim());
                }
            });
        }
    }//GEN-LAST:event_btnLocateActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        selectedRowIndex = tbl_city.getSelectedRow();
        if(selectedRowIndex==-1){
            JOptionPane.showMessageDialog(this, "Please Select A Row To View.");
            return;
        }
        DefaultTableModel model = (DefaultTableModel)tbl_city.getModel();
        Network selectedNetwork = (Network) model.getValueAt(selectedRowIndex, 0);
        txtName.setText(selectedNetwork.getName());
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if (selectedRowIndex == -1) {
        JOptionPane.showMessageDialog(this, "Please Select A Row To Update");
        return;    
        }
        DefaultTableModel model = (DefaultTableModel)tbl_city.getModel();
        Network selectedNetwork = (Network) model.getValueAt(selectedRowIndex, 0);
        String name = txtName.getText();

        
            if (!name.isEmpty()) {
                selectedNetwork.setName(name);
                populateCityTable();
                JOptionPane.showMessageDialog(this, "City Added Successfully!");
                txtName.setText("");
                
            } else {
                JOptionPane.showMessageDialog(null, "City Should have a name.");
                return;
            }
        {
            JOptionPane.showMessageDialog(null, "City Already Exists");
            return;
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLocate;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_submit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_city;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
