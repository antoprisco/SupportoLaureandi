package model;

import java.sql.SQLException;

public class Prova2Funzionalita {

	public static void main(String[] args) {
		
		RequestOU r = new RequestOU(12, "g.musacchio@studenti.unisa.it");
		RequestOUDAO rDAO = new RequestOUDAO();
		
		try {
			rDAO.doSave(r);
			System.out.println("Inserimento effettuato con successo");
		} catch (SQLException e) {
			System.out.println("Errore nella query");
			e.printStackTrace();
		}
	}
}
