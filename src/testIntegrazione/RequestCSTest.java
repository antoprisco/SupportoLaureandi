package testIntegrazione;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.RequestCS;
import model.RequestCSDAO;

public class RequestCSTest {
	
	@Test
	void testRequestCSdoRetrieveAllSegretary() throws SQLException {
		RequestCS request = new RequestCS();
		RequestCSDAO requestDAO = new RequestCSDAO();
		
		assertEquals(true, (requestDAO.doRetrieveAllSecretary(1)));
		
	
		
	}
	
	@Test
	void testRequestCSdoRetrieveRifiutate() throws SQLException {
		RequestCS request = new RequestCS();
		RequestCSDAO requestDAO = new RequestCSDAO();
		
		request.setNome("Pippo");
		request.setCognome("Rossi");
		request.setStato(5);
	
		assertEquals(true, (!(requestDAO.doRetrieveRifiutate().isEmpty())));
	}
	
	@Test
	void testRequestCSdoRetrieveAccettate() throws SQLException {
		RequestCS request = new RequestCS();
		RequestCSDAO requestDAO = new RequestCSDAO();
		
		request.setNome("Pippo");
		request.setCognome("Rossi");
		request.setStato(4);
	
		assertEquals(true, (!(requestDAO.doRetrieveAccettate().isEmpty())));
	}
	
	@Test
	void testRequestCSdoRetrieveByNCS() throws SQLException {
		RequestCS request = new RequestCS();
		RequestCSDAO requestDAO = new RequestCSDAO();
		
		request.setNome("Pippo");
		request.setCognome("Rossi");
		request.setStato(0);
	
		RequestCS flag = requestDAO.doRetrieveByNCStato(request.getNome(), request.getCognome(), request.getStato());
		assertEquals(true, flag);
	}


}
