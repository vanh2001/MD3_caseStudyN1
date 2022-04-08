package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
<<<<<<< HEAD
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagement1", "root", "Huyen2002@123");
=======
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagement", "root", "1994");
>>>>>>> master
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}




