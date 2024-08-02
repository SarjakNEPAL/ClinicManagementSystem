/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import Model.Patient;
import Model.Appointment;
import Database.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bhand
 */
public class StaffDAO {
    
    MySqlConnection mysql = new MySqlConnection();

    public Patient seekPatient(int Number){
        Patient a=new Patient();
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM patient where PhoneNumber = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,Number);
            
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                a.setName(result.getString("Name"));
                a.setAddress(result.getString("Address"));
                a.setPhoneNumber(Number);
                a.setGender(result.getString("Gender"));
                return a;
            }
        } catch (SQLException ex) {
            System.err.println("SQL error: " + ex.getMessage());
        } finally {
            mysql.closeConnection(conn);
        }
        return null;
       }
    public boolean register(Patient k){
                Connection conn = mysql.openConnection();
                String sql = "INSERT INTO patient(Name,Address,PhoneNumber,Gender) Values(?,?,?,?);";
                try (PreparedStatement p = conn.prepareStatement(sql)) {
                    p.setString(1, k.getName());
                    p.setString(2, (k.getAddress()));
                    p.setInt(3,k.getPhoneNumber());
                    p.setString(4,k.getGender());
                    p.executeUpdate();
                    return true;
                } catch (Exception f) {
                    System.out.println(f);
  
                } finally {
                    mysql.closeConnection(conn);
                }
                    
        return false;
        }
    public boolean isAppointmentFree(Appointment a){
        boolean eee=false;
        ResultSet re;
        Connection conn = mysql.openConnection();
        String query = "SELECT Date FROM appointment WHERE time=? and date=? and Doctor=?";
        try (PreparedStatement stt = conn.prepareStatement(query)) {
            stt.setString(2, (a.getDate()));
            stt.setString(1, (a.getTime()));
            stt.setString(1, (a.getDoctor()));
            re = stt.executeQuery();
            if(re.next()){
                if(re.getString("Date").equals(a.getDate())){
                    eee= !true;
                }
                else {
                eee=  !false;
                }
            }
        } catch (SQLException ex) {
            System.err.println("SQL error: " + ex.getMessage());
        } finally {

            mysql.closeConnection(conn);
        }
        return eee;
    }
    public boolean registerAppointment(Appointment a){
                Connection conn = mysql.openConnection();
                String sql = "INSERT INTO appointment(PatientPhone,Date,Time,Doctor,StaffID) Values(?,?,?,?);";
                try (PreparedStatement p = conn.prepareStatement(sql)) {
                    p.setInt(1, Appointment.PatientPhone);
                    p.setString(2, a.getDate());
                    p.setString(3,a.getTime());
                    p.setString(4,a.getDoctor());
                    p.setInt(5, Appointment.StaffId);
                    p.executeUpdate();
                    return true;
                } catch (Exception f) {
                    System.out.println(f);
  
                } finally {
                    mysql.closeConnection(conn);
                }
                    
        return false;
    }
}




