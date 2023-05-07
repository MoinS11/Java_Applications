/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Person;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author moins
 */
public class AllEmployeeDetails {
    
    private ArrayList<PersonDetails> employeeDetails;
    
    public AllEmployeeDetails(){
        
        this.employeeDetails = new ArrayList<PersonDetails>();
//        PersonDetails p = new PersonDetails();
//        
//        p.setName("Moin");
//        p.setEmployee_Id(20);
//        p.setAge(35);
//        p.setPositionTitle("Sales");
//        p.setTeamInfo("Junior");
//        p.setGender("Male");
//        p.setLevel("Senior");
//        p.setStartDate("01/01/2020");
//        p.setCellPhoneNo("9833644486");
//        p.setEmailAddress("moin@gmail.com");
//        p.setPhotoLocation("C:\\Users\\moins\\Downloads\\Testimg3.jpg");
//        
//        employeeDetails.add(p);
//        
//        p = new PersonDetails();
//        
//        p.setName("Maaz");
//        p.setEmployee_Id(30);
//        p.setAge(80);
//        p.setPositionTitle("Java");
//        p.setTeamInfo("Senior");
//        p.setGender("Male");
//        p.setLevel("Senior");
//        p.setStartDate("01/01/2019");
//        p.setCellPhoneNo("1234567890");
//        p.setEmailAddress("maaz@gmail.com");
//        p.setPhotoLocation("C:\\Users\\moins\\Downloads\\Testimg2.jpg"); 
//        
//                employeeDetails.add(p);

                
    }

    public ArrayList<PersonDetails> getEmployeeDetails() {
        return employeeDetails;
    }

    public void setEmployeeDetails(ArrayList<PersonDetails> employeeDetails) {
        this.employeeDetails = employeeDetails;
    }

        
    public PersonDetails addNewEmployee(PersonDetails p){
  
this.employeeDetails.add(p);
return p;
    
    
    }
    
    public void deleteEmployee(PersonDetails p){
    
    employeeDetails.remove(p);
    
    }

  public PersonDetails search_EmployeeByName(String emp){
      
      for(PersonDetails p : employeeDetails){
          if(p.getName().equalsIgnoreCase(emp)){
              return p;
      }
 
      }
      return null;
  }

  public PersonDetails search_EmployeeById(int id){
      for(PersonDetails p : employeeDetails){
          if(p.getEmployee_Id()==id){
              return p;
          }
     
      }
  return null;
  }

   public PersonDetails search_EmployeeByCellPhoneNo(String number){
      for(PersonDetails p : employeeDetails){
          if(p.getCellPhoneNo().equalsIgnoreCase(number) ){
              return p;
          }
     
      }
  return null;
  }
}

