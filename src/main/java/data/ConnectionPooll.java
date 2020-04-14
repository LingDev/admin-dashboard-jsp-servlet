/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.UserBean;

/**
 *
 * @author vando
 */
public class ConnectionPooll {
    static Connection con = null;
     public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql:// localhost:3307/";
        // Database name to access 
        String dbName = "studentmng";
        String dbUsername = "root";
        String dbPassword = "Linh@12345";

        Class.forName(dbDriver);
        con = DriverManager.getConnection(dbURL + dbName,
                dbUsername,
                dbPassword);
        return con;
    }
     public static void closeConnection () throws SQLException{
         con.close();
     }
}
