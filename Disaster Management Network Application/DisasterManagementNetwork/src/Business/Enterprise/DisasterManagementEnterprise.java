/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Enterprise;

import Business.Role.DisasterManagementAdminRole;
import Business.Role.Roles;
import java.util.ArrayList;

/**
 *
 * @author moins
 */
public class DisasterManagementEnterprise extends Enterprise{
    public DisasterManagementEnterprise(String name, Enterprise.EnterpriseType type) {
        super(name, type.DisasterManagement);
    }

    @Override
    public ArrayList<Roles> getSupportedRole() {
        ArrayList<Roles> roles = new ArrayList<>();
        roles.add(new DisasterManagementAdminRole());
        return roles; //To change body of generated methods, choose Tools | Templates.
    }
}
