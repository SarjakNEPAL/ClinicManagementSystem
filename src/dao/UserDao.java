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
        String sql = "SELECT * FROM Staff where id = ? and Password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Integer.toString(login.getId()));
            pstmt.setString(2, login.getPassword());
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                Staff user = new Staff();
                user.setId(result.getInt("Id"));
                user.setName(result.getString("Name"));
                user.setType(result.getString("Type"));
                
                secure cc = new secure();
                cc.cipherText = result.getString("Password");
                
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
