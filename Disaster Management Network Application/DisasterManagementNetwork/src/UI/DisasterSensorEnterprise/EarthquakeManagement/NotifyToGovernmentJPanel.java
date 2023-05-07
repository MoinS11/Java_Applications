/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.DisasterSensorEnterprise.EarthquakeManagement;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.EarthquakeManagementOrganization;
import Business.Organization.SensorMonitorOrganization;
import Business.Organization.GovernmentOfficialOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Sensor.EarthquakeSensor;
import Business.Sensor.Sensor;
import Business.Sensor.SensorDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.EarthquakeWorkRequest;
import Business.WorkQueue.GovernmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import UI.DisasterSensorEnterprise.SensorManagement.SensorMonitorWorkArea;

/**
 *
 * @author moins
 */
public class NotifyToGovernmentJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private OrganizationDirectory organizationDirectory;
    

    /**
     * Creates new form NotifyToGovernmentJPanel
     */
    public NotifyToGovernmentJPanel(JPanel userProcessContainer, UserAccount userAccount, EcoSystem business, OrganizationDirectory organizationDirectory) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.userAccount = userAccount;
        this.organizationDirectory = organizationDirectory;
        
        populateTable();
    }
    
    public void populateTable(){
         ArrayList<EarthquakeSensor> tempEarthquakeSensorList = new ArrayList<EarthquakeSensor>();

        for(Network ntwk: business.getNetworkList())
        {
            for(Enterprise entprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization org : entprise.getOrganizationDirectory().getOrganizationList())
            {
            if(org instanceof SensorMonitorOrganization)
            {
                SensorDirectory sensedirect;
                sensedirect = ((SensorMonitorOrganization) org).getSensorDirectory();
                
                for(Sensor sense : sensedirect.getSensorList())
                {
                    if(sense instanceof EarthquakeSensor)
                    {
                        EarthquakeSensor Earthq = (EarthquakeSensor)sense;
                        tempEarthquakeSensorList.add(Earthq);
                    }
                }
            }

            }
        }   }
            
            DefaultTableModel model = (DefaultTableModel) tblEarthquake.getModel();
        model.setRowCount(0);
        
        for(EarthquakeSensor eq : tempEarthquakeSensorList)
                {
                    if(eq.getSeismicReading()>5)
                    {
                        Object[] row = new Object[4];
                        row[0] = eq;
                        row[1] = eq.getZipcode();
                        row[2] = eq.getSeismicReading();
                        model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblEarthquake = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnRequestToGovernment = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(222, 222, 248));
        setLayout(null);

        tblEarthquake.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sensor ID", "Zipcode", "Seismic Readings"
            }
        ));
        jScrollPane1.setViewportView(tblEarthquake);

        add(jScrollPane1);
        jScrollPane1.setBounds(110, 290, 660, 200);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(91, 130, 170));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Earthquake Sensor Readings");
        add(jLabel1);
        jLabel1.setBounds(90, 130, 670, 60);

        btnBack.setText("<< Back");
        btnBack.setSize(new java.awt.Dimension(120, 40));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack);
        btnBack.setBounds(20, 20, 80, 50);

        btnRequestToGovernment.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        btnRequestToGovernment.setText("Send Request To Government");
        btnRequestToGovernment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestToGovernmentActionPerformed(evt);
            }
        });
        add(btnRequestToGovernment);
        btnRequestToGovernment.setBounds(280, 520, 330, 33);

        jLabel2.setBackground(new java.awt.Color(222, 222, 248));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/seismic-r.jpeg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(0, 90, 1240, 780);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRequestToGovernmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestToGovernmentActionPerformed
        // TODO add your handling code here:
        int row = tblEarthquake.getSelectedRow();
        if(row <0){
            JOptionPane.showMessageDialog(null, "No row selected");
        }else{
        
     
        Sensor sensor = (Sensor)tblEarthquake.getValueAt(row, 0);
        
        EarthquakeSensor earthquakeSensor = (EarthquakeSensor) sensor;
        GovernmentWorkRequest reques = new GovernmentWorkRequest();
        reques.setEarthquakeSensor(earthquakeSensor);
        reques.setEarthquakeMessage("Area-code "+earthquakeSensor.getZipcode()+" is affected by Earthquake, please inform citizens to avoid this area until further notice");
        reques.setSender(userAccount);
        reques.setStatus("Successfully Notified to Government");
        
        Organization orgn = null;
        for(Network ntwk: business.getNetworkList())
        {
            for(Enterprise enterprise : ntwk.getEnterpriseDirectory().getEnterpriseList())
            {
                for(Organization orgzn : enterprise.getOrganizationDirectory().getOrganizationList())
                {
            
            if (orgzn instanceof GovernmentOfficialOrganization){
                orgn = orgzn;
                break;
                    }           
                }
            } 
        }
        if (orgn!=null){
            
            ArrayList<Integer> sensorIDsArray = new ArrayList<Integer>();
            boolean workRequestAlreadyPresent = false;
                    
            if(orgn.getWorkQueue().getWorkRequestList().isEmpty())
            {
                try {
                orgn.getWorkQueue().getWorkRequestList().add(reques);
                userAccount.getWorkQ().getWorkRequestList().add(reques);
                JOptionPane.showMessageDialog(null, "Request sent to Government successfully");
                return;
                } catch (Exception e) {
                }
                JOptionPane.showMessageDialog(null, "Request sent to Government successfully");
            }
            else
            {
            for(WorkRequest request1 : orgn.getWorkQueue().getWorkRequestList())
            {
                if(request1 instanceof GovernmentWorkRequest)
                {
                    GovernmentWorkRequest reque = (GovernmentWorkRequest) request1;
                    
                    if(reque.getEarthquakeSensor() != null)
                    {
                    sensorIDsArray.add(reque.getEarthquakeSensor().getSensorId());
                    for(int i=0; i<sensorIDsArray.size(); i++)
                    {
                        if(reques.getEarthquakeSensor().getSensorId() == sensorIDsArray.get(i))
                        {
                            workRequestAlreadyPresent = true;
                        }
                    }
                  }
                }
              }
                    if(workRequestAlreadyPresent)   
                    {
                        JOptionPane.showMessageDialog(null, "Request has already been sent to Government");
                    }
                    else
                    {
                        try {
                        orgn.getWorkQueue().getWorkRequestList().add(reques);
                        userAccount.getWorkQ().getWorkRequestList().add(reques);
                        JOptionPane.showMessageDialog(null, "Request sent to Government successfully");
                        return;
                        } catch (Exception e) {
                        }
                        JOptionPane.showMessageDialog(null, "Request sent to Government successfully");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnRequestToGovernmentActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        //JPanel panel = new NotifytoAirPolltuionSolutionDepartment(userProcessContainer,userAccount,business,organizationDirectory);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRequestToGovernment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEarthquake;
    // End of variables declaration//GEN-END:variables
}