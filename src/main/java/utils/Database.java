package utils;
import java.sql.*;

public class Database {
    final String URL = "jdbc:mysql://localhost:3306/gestion_resto";
    final String USER="root";
    final String PASS="";
    private Connection connection;
    private static Database instance;

    public Database(){
        try {
            connection = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("Connected");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;

    }
    public Connection getConnection(){
        return connection;
    }


}
