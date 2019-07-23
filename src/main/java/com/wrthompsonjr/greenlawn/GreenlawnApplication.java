//Created By: William Ray Thompson Jr

package com.wrthompsonjr.greenlawn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class GreenlawnApplication {
	
	private final String url = "jdbc:postgresql://localhost/greenlawn";
    private final String user = "postgres";
    private final String password = "<add your password>";
 
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        return conn;
    }
 
    /**
     * @param args the command line arguments
     */
	
	public static void main(String[] args) {
		SpringApplication.run(GreenlawnApplication.class, args);
		GreenlawnApplication greenlawnApplication = new GreenlawnApplication();
		greenlawnApplication.connect();
	}
}