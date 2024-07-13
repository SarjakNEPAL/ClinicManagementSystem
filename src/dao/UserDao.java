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
}



