package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Residenza;

class ResidenzaTest {

	
	@Test
	void testResidenaEmptyConstructor() {
		Residenza rz = new Residenza();
			assertNotNull(rz);
	}

	@Test
	void testGetResidenza() {
		Residenza rz = new Residenza("Salerno", "", "", 80400);
			assertEquals("Salerno", rz.getResidenza());
	}

	@Test
	void testSetResidenza() {
		Residenza rz = new Residenza("Salerno", "", "", 80400);
			rz.setResidenza("Napoli");
			assertEquals("Napoli", rz.getResidenza());
	}

	@Test
	void testGetProvincia() {
		Residenza rz = new Residenza("", "Salerno", "", 80400);
			assertEquals("Salerno", rz.getProvincia());
	}

	@Test
	void testSetProvincia() {
		Residenza rz = new Residenza("", "Salerno", "", 80400);
			rz.setProvincia("Napoli");
			assertEquals("Napoli", rz.getProvincia());
	}

	@Test
	void testGetIndirizzo() {
		Residenza rz = new Residenza("", "", "Via Roma", 80400);
			assertEquals("Via Roma", rz.getIndirizzo());
	}

	@Test
	void testSetIndirizzo() {
		Residenza rz = new Residenza("", "", "Via Roma", 80400);
			rz.setIndirizzo("Via Garibaldi");
			assertEquals("Via Garibaldi", rz.getIndirizzo());
	}

	@Test
	void testGetCap() {
		Residenza rz = new Residenza("", "", "", 80400);
			assertEquals(80400, rz.getCap());
	}

	@Test
	void testSetCap() {
		Residenza rz = new Residenza ("", "", "", 80400);
			rz.setCap(50020);
			assertEquals(50020, rz.getCap());
	}

}
