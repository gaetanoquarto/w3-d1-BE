package Esercizio1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Cliente extends DB {
	
	String nome;
	String cognome;
	String regione_residenza;
	LocalDate data_nascita;


	
	
public Cliente(String nome, String cognome, String regione_residenza, LocalDate data_nascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.regione_residenza = regione_residenza;
		this.data_nascita = data_nascita;
	}


public void inserisciCliente() {
		
		try {
			System.out.println("Inserisco i dati...");
			String sql = "INSERT INTO clienti (nome, cognome, regione_residenza, data_nascita) VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, cognome);
			stmt.setString(3, regione_residenza);
			stmt.setDate(4, java.sql.Date.valueOf(data_nascita));
			stmt.execute();
			
			System.out.println("Dati inseriti correttamente!");
		}
		catch(SQLException e) {
			System.out.println("C'è stato un errore mentre inserivo i dati.");
			e.printStackTrace();
		}
		
	}

public void estraiCliente() {
	
	try {
		System.out.println("Estraggo i dati...");
		Statement stmt = conn.createStatement();
		ResultSet rs = 

		stmt.executeQuery("SELECT nome, cognome FROM clienti WHERE data_nascita BETWEEN '1982-01-01' AND '1982-12-31'");
		while( rs.next() ) {
			System.out.printf(
				"Nome: %s Cognome: %s%n", 
				rs.getString("nome"),
				rs.getString("cognome")
			);
			System.out.println("-----------------------------------------------");
		}

	}
	catch(SQLException e) {
		System.out.println("C'è stato un errore mentre estraevo i dati.");
		e.printStackTrace();
	}
	
}

}
