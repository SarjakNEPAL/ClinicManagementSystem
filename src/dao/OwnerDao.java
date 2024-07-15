/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Controller.secure;
import Database.MySqlConnection;
import Model.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sarjak
 */
public class OwnerDao{
    MySqlConnection mysql = new MySqlConnection();
    secure cc = new secure();
    public String getOwnerPass(){
        Connection conn = mysql.openConnection();
        String sql = "SELECT Password FROM Staff where ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,1234);
            
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                 cc.cipherText=result.getString("Password");
              try {
                 cc.decrypt();
                 return cc.plainText;
                } catch (Exception e) {
                    System.err.println("Decryption error: " + e.getMessage());
                    return null;
                }

            }
        } catch (SQLException ex) {
            System.err.println("SQL error: " + ex.getMessage());
        } finally {
            mysql.closeConnection(conn);
        }
        return null;
        
    
}
public boolean chgPasAdmn(String Npass){
    boolean isOK = false;
    Connection conn= mysql.openConnection();
     cc.plainText=Npass;
   try {cc.encrypt();}catch(Exception e){System.out.println("Encryption error: " + e.getMessage());}
   String query="Update Staff SET Password=? WHERE id=1234";
   try (
           PreparedStatement pstmt = conn.prepareStatement(query)){pstmt.setString(1,cc.cipherText);pstmt.executeUpdate();
           isOK=true;
   }catch(SQLException ex){
       System.err.println("SQL error: " + ex.getMessage());return false;
   } finally { 
       mysql.closeConnection(conn);
       return isOK;
   }
}
public boolean register(Staff reg) {

        if (doesE(reg.getName())) {
            System.out.println("Exists");
            return false;
        } else {
            System.out.println("Doesnt Exist");
            Connection conn= mysql.openConnection();
            String sql = "INSERT INTO Staff(Name,Type,Password) Values(?,'Staff',?);";
            try (PreparedStatement p = conn.prepareStatement(sql)) {
                p.setString(1,reg.getName());
                p.setString(2,(reg.getPassword()));
                secure kk = new secure();
                kk.plainText= reg.getPassword();
                    kk.encrypt();
                p.setString(2, kk.cipherText);
                p.executeUpdate();
                }catch ( Exception f){
                    System.out.println(f);
                    return false;
                }
finally {
                mysql.closeConnection(conn);
            }
            return true;
        }
    }

    public boolean doesE(String Name) {
        boolean eee=false;
        ResultSet re;
        Connection conn = mysql.openConnection();
        String query = "SELECT Name FROM STAFF WHERE Name=?";
        try (PreparedStatement stt = conn.prepareStatement(query)) {
            stt.setString(1, (Name));
            re = stt.executeQuery();
            if(re.next()){
                if(re.getString("Name").equals(Name)){
                    eee= true;
                }
                else {
                eee=  false;
                }
            }
        } catch (SQLException ex) {
            System.err.println("SQL error: " + ex.getMessage());
        } finally {

            mysql.closeConnection(conn);
        }
        return eee;
    }
}