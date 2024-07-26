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
    StaffDAO k=new StaffDAO();
    public boolean Clicked(int Number){
        Patient pp=k.seekPatient(Number);
        if(pp!=null){return true;}
        return false;
    }

}