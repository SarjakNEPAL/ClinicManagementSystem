/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import javax.swing.*;
import javax.swing.JOptionPane;
import Model.Patient;
import dao.StaffDAO;
/**
 *
 * @author bhand
 */
public class patientTasks {
    private StaffDAO k=new StaffDAO();
    private Patient pp;
    public boolean isPatientExist(long Number){
        this.pp=k.seekPatient(Number);
        if(pp!=null){return true;}
        return false;
    }
    
    public boolean commitPatient(Patient p){
        if(k.register(p)){return true;}
        else{return false;}
    }
    
    public Patient getPatient(){
        return this.pp;
    }
    
   
}