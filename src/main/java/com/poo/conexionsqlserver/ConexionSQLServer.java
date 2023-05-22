package com.poo.conexionsqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexionSQLServer {
    private Connection con = null;
    
    // Your connection parameters
    private String username = "sa";
    private String password = "12345678";
    private String db = "escuelas";
    private String ip = "localhost";
    private String port = "1433";
    
    public Connection getConnection(){
        try {
            String conString = "jdbc:sqlserver://" + ip + ":" + port + ";"
                    + "databaseName=" + db;
//            String conString = "jdbc:sqlserver://localhost:1433;databaseName=escuelas;integratedSecurity=true;";
            con = DriverManager.getConnection(conString, username, password);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
        return con;
    }
    
    public void executeQuery() {
        // Example usage of prepared statement
        String query = "SELECT * FROM alumnos";
        
        try {
            PreparedStatement stmt = con.prepareStatement(query);
            // Set parameters or perform other operations
            // stmt.setXXX(parameterIndex, value);
            
            // Execute the query and process the result
            // stmt.executeQuery();
            
            stmt.close(); // Close the statement when done
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.toString());
        }
    }
    
    public void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexion cerrada");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexion: " + e.toString());
        }
    }
}