/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Ecosystem;
import Business.UserAccount.UserAccount;
import UserInterface.Physician.DoctorSideNavWorkAreaJpanel;
import javax.swing.JPanel;

/**
 *
 * @author moins
 */
public class PhysicianRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer,
            UserAccount account, Ecosystem business) {
        return new DoctorSideNavWorkAreaJpanel(userProcessContainer,account, business);
    }
    
}
