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
    private int id;
    public static long PatientPhone;
    private String Date;
    private String Time;
    private String Doctor;
    public int StaffID;
        

    // Getter method for id
    public int getId() {
        return id;
    }

    // Setter method for id
    public void setId(int id) {
        this.id = id;
    }
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

