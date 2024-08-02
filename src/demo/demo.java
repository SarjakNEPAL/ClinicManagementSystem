package demo;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLOutput;
//
//import Controller.secure;
//import Database.MySqlConnection;
import Model.Staff;
import dao.OwnerDao;
import dao.UserDao;

public class demo {
    public static void main(String[] args) {
        OwnerDao a = new OwnerDao();
        for (Object element : a.fetchStaffRecords()) {
            System.out.println();
        }

//            }
        }
    }


