package testIntegrazione;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.RequestLM;
import model.RequestlmDAO;

class RequestLMTest {
	
	@Test
	void testRequestLM() throws SQLException {
		RequestLM request = new RequestLM();
		RequestlmDAO requestDAO = new RequestlmDAO();
		
		request.setEmail("g.musacchio@studenti.unisa.it");
		request.setCurr("Cloud Computing");
		
		boolean flag = requestDAO.doRetrieveByUser(request.getEmail());
		
		assertEquals(true, flag);
	}

}
