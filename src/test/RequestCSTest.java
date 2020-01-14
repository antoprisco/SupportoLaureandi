package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.RequestCS;


class RequestCSTest {

	@Test
	void testRequestCSEmptyConstructor() {
		RequestCS cs = new RequestCS();
			assertNotNull(cs);	}

/*	@Test
	void testGetId() {
		RequestCS cs = new RequestCS("", "", 9);
		assertEquals("", cs.getId());
	}

	@Test
	void testSetId() {
		RequestCS cs = new RequestCS("", "", 9);
		cs.setId();
		assertEquals("", cs.getId());
	} 
*/

	@Test
	void testGetStato() {
		RequestCS cs = new RequestCS("", "", 1);
		assertEquals(1, cs.getStato());
	}

	@Test
	void testSetStato() {
		RequestCS cs = new RequestCS("", "", 1);
		cs.setStato(2);
		assertEquals(2, cs.getStato());
	}

	@Test
	void testGetNome() {
		RequestCS cs = new RequestCS("mario", "", 1);
		assertEquals("mario", cs.getNome());
	}

	@Test
	void testSetNome() {
		RequestCS cs = new RequestCS("mario", "", 1);
		cs.setNome("pippo");
		assertEquals("pippo", cs.getNome());
	}

	@Test
	void testGetCognome() {
		RequestCS cs = new RequestCS("", "rossi", 1);
		assertEquals("rossi", cs.getCognome());
	}

	@Test
	void testSetCognome() {
		RequestCS cs = new RequestCS("", "rossi", 1);
		cs.setCognome("cirillo");
		assertEquals("cirillo", cs.getCognome());
	}

}
