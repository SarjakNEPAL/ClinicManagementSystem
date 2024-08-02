/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author bhand
 */
public class Appointment {
    public static int PatientPhone;
    private String Date;
    private String Time;
    private String Doctor;
    public static int StaffId;
    
    // Getter methods

    public String getDate() {
        return Date;
    }
       public String getTime() {
        return Time;
    }

    public String getDoctor() {
        return Doctor;
    }


    // Setter methods


    public void setDate(String date) {
        Date = date;
    }
    public void setTime(String time) {
        Time = time;
    }

    public void setDoctor(String doctor) {
        Doctor = doctor;
    }


}

