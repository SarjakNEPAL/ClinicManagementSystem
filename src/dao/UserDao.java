package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.secure;
import Database.MySqlConnection;
import Model.Staff;

public class UserDao {
    MySqlConnection mysql = new MySqlConnection();

    public Staff login(Staff login) {
        Connection conn = mysql.openConnection();
        String sql = "SELECT * FROM Staff where Name = ? and Password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,(login.getName()));
            secure cc = new secure();
            cc.plainText= login.getPassword();
            try{
                cc.encrypt();
            }catch ( Exception f){
                System.out.println(f);
            }

            pstmt.setString(2, cc.cipherText);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                Staff user = new Staff();
                user.setId(result.getInt("Id"));
                user.setName(result.getString("Name"));
                user.setType(result.getString("Type"));
                
                try {
                    cc.decrypt();
                    user.setPassword(cc.plainText);
                } catch (Exception e) {
                    System.err.println("Decryption error: " + e.getMessage());
                    return null;
                }
                
                return user;
            }
        } catch (SQLException ex) {
            System.err.println("SQL error: " + ex.getMessage());
        } finally {
            mysql.closeConnection(conn);
        }
        return null;
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


