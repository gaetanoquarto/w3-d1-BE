package Esercizio1;

import java.time.LocalDate;

public class Main {
	


	public static void main(String[] args) {
		
		DB db = new DB();
		Cliente c1 = new Cliente ("Marco", "Cirillo", "Abruzzo", LocalDate.of(1982, 07, 25));
		
		db.connect();
		boolean insertNewStudent = false;
		if( insertNewStudent ) {
			c1.inserisciCliente();
		}
		boolean extract = true;
		if( extract ) {
			c1.estraiCliente();
		}
		
		db.disconnect();
		

	}

}
