package demo;
import java.sql.Connection;
import java.sql.ResultSet;
import Controller.secure;
import Database.MySqlConnection;
public class demo {
public static void main(String[] args) {
    MySqlConnection mysql=new MySqlConnection();
    Connection conn=mysql.openConnection();
    int i
    String query="SELECT * from Staff";
    ResultSet result=mysql.runQuery(conn,query);
    try{
    if(result.next()){
        System.out.println(result.getInt("ID"));
    }
    }catch (Exception e){
        System.out.println(e);
    }
    finally {
        mysql.closeConnection(conn);
    }
    }
}

