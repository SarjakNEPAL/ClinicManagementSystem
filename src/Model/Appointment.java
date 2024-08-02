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
    private int PatientPhone;
    private String Date;
    private String Doctor;
    private int StaffId;

    // Getter methods
    public int getPatientPhone() {
        return PatientPhone;
    }

    public String getDate() {
        return Date;
    }

    public String getDoctor() {
        return Doctor;
    }

    public int getStaffId() {
        return StaffId;
    }

    // Setter methods
    public void setPatientPhone(int patientPhone) {
        PatientPhone = patientPhone;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setDoctor(String doctor) {
        Doctor = doctor;
    }

    public void setStaffId(int staffId) {
        StaffId = staffId;
    }
}

