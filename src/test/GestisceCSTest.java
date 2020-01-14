package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.GestisceCS;

class GestisceCSTest {

	@Test
	void testGestisceCSEmptyConstructor() {
		GestisceCS cs = new GestisceCS();
			assertNotNull(cs);
	}

	@Test
	void testGetEmail() {
		GestisceCS cs = new GestisceCS("m.rossi@studenti.unisa.it", 9);
			assertEquals("m.rossi@studenti.unisa.it", cs.getEmail());
	}

	@Test
	void testSetEmail() {
		GestisceCS cs = new GestisceCS("m.rossi@studenti.unisa.it", 9);
			cs.setEmail("p.cirillo@studenti.unisa.it");
			assertEquals("p.cirillo@studenti.unisa.it", cs.getEmail());
	}

	@Test
	void testGetId() {
		GestisceCS cs = new GestisceCS("", 9);
			assertEquals(9, cs.getId());
	}

	@Test
	void testSetId() {
		GestisceCS cs = new GestisceCS("", 8);
			cs.setId(9);
			assertEquals(9, cs.getId());
	}

}
