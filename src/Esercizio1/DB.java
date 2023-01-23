package Esercizio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	private final String url = "jdbc:postgresql://localhost:5432/Esercizio1?useSSL=false";
	private final String username = "postgres";
	private final String password = "postgres";
	static Connection conn = null;

	public void connect() {
		try {
		  System.out.println("Mi connetto al Database... " + url);
		  conn = DriverManager.getConnection(url, username, password);
		  System.out.println("Connessione avvenuta con successo!");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		if( conn != null ) {    	  
		    try {
				  conn.close();
				  System.out.println("Disconnessione avvenuta con successo!");
			} catch (SQLException e) {
				  e.printStackTrace();
			}
		}
	}
	


}
