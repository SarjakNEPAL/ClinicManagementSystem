/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import Model.Patient;
import Model.Appointment;
import Database.MySqlConnection;
import Model.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import View.staffHomePage;

/**
 *
 * @author bhand
 */
public class StaffDAO {
    
    MySqlConnection mysql = new MySqlConnection();
    public int getStaffId(String Name){
    Connection conn = mysql.openConnection();
        String sql = "SELECT ID FROM Staff where Name = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,Name);
            
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                 return result.getInt("ID");
              
                }
        } catch (SQLException ex) {
            System.err.println("SQL error: " + ex.getMessage());
        } finally {
            mysql.closeConnection(conn);
        }
        return -1;

}
    public Patient seekPatient(long Number){
        Patient a=new Patient();
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM patient where PhoneNumber = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1,Number);
            
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
                    p.setLong(3,k.getPhoneNumber());
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
            stt.setString(3, (a.getDoctor()));
            re = stt.executeQuery();
            if(re.next()){
                eee=!true;
            }
            else{
            eee=!false;
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
                String sql = "INSERT INTO appointment(PatientPhone,Date,Time,Doctor,StaffID) Values(?,?,?,?,?);";
                try (PreparedStatement p = conn.prepareStatement(sql)) {
                    p.setLong(1, Appointment.PatientPhone);
                    p.setString(2, a.getDate());
                    p.setString(3,a.getTime());
                    p.setString(4,a.getDoctor());
                    p.setInt(5, staffHomePage.StaffID);
                    p.executeUpdate();
                    return true;
                } catch (Exception f) {
                    System.out.println(f);
  
                } finally {
                    mysql.closeConnection(conn);
                }
                    
        return false;
    }
    public boolean deleteAppointment(int id){
       Connection conn=mysql.openConnection();
       try{
           
           String sql="DELETE FROM appointment WHERE id="+id;
           PreparedStatement pst=conn.prepareStatement(sql);
           pst.execute();
           return true;
           
        }catch(Exception e){
            System.out.println(e);
        }
       finally{
           mysql.closeConnection(conn);
       }
       return false;
   }
   
    
    public List<Appointment> fetchAppointmentRecords() {
            List<Appointment> appointmentList = new ArrayList<>();
            Connection conn = mysql.openConnection();
            String sqlQuery = "SELECT id,Date,Time,Doctor,StaffID FROM appointment where PatientPhone=?";
            try(PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery)){
                preparedStatement.setLong(1, Appointment.PatientPhone);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {   
                    Appointment a = new Appointment();
                    a.setDate(resultSet.getString("Date"));
                    a.setTime(resultSet.getString("Time"));
                    a.setDoctor(resultSet.getString("Doctor"));
                    a.StaffID=resultSet.getInt("StaffID");
                    a.setId(resultSet.getInt("id"));
                    appointmentList.add(a);
                }              
                resultSet.close();
                preparedStatement.close();
            }
catch (Exception e) {
            System.out.println(e);
        } finally {
            mysql.closeConnection(conn);
        }
//        for (Object element : staffList) {
////            System.out.println(element);
//        }
        return appointmentList;
    }
    public List<Appointment> fetchAppointmentRecords(int id) {
            List<Appointment> appointmentList = new ArrayList<>();
            Connection conn = mysql.openConnection();
            String sqlQuery = "SELECT id,Date,Time,Doctor,StaffID FROM appointment where id=?";
            try(PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery)){
                preparedStatement.setLong(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {   
                    Appointment a = new Appointment();
                    a.setDate(resultSet.getString("Date"));
                    a.setTime(resultSet.getString("Time"));
                    a.setDoctor(resultSet.getString("Doctor"));
                    a.StaffID=resultSet.getInt("StaffID");
                    a.setId(resultSet.getInt("id"));
                    appointmentList.add(a);
                }              
                resultSet.close();
                preparedStatement.close();
            }
catch (Exception e) {
            System.out.println(e);
        } finally {
            mysql.closeConnection(conn);
        }
//        for (Object element : staffList) {
////            System.out.println(element);
//        }
        return appointmentList;
    }
}




