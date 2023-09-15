package connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String url = "jdbc:postgresql://localhost:5432/salesmanagerdb";
    private static final String user = "postgres";
    private static final String password = "8235";
    public static Connection connect(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url,user,password);
            return conn;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
