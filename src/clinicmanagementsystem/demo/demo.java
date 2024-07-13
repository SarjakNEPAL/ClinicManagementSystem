package ClinicManagementSystem.demo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLOutput;

import ClinicManagementSystem.Controller.secure;
import ClinicManagementSystem.Database.MySqlConnection;
import ClinicManagementSystem.Model.Staff;
import ClinicManagementSystem.dao.UserDao;

public class demo {
    public static void main(String[] args) {
        UserDao a = new UserDao();
        Staff user = new Staff();
        user.setName("admin");
        user.setPassword("admin");
        Staff kk = a.login(user);
        if (kk == null) {
            System.out.println("Login failed");
        } else {
            if (kk.getType().equals("owner")) {
                System.out.println("Admin Logged in");
            } else {
                System.out.println("Staff Logged in");
            }
//    }
            user.setName("Okla");
            user.setPassword("Okla");
            user.setType("Staff");
            if (a.register(user)) {
                System.out.println("Okay");
            } else {
                System.out.println("No");
            }
        }
    }
}

