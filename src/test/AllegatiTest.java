package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Allegati;

class AllegatiTest {

	@Test
	void testAllegatiEmptyConstructor() {
		  Allegati al = new Allegati();
		    assertNotNull(al);
	}

	@Test
	void testGetIdReq() {
		Allegati al = new Allegati("", "", 1);
		  assertEquals(01, al.getIdReq());
	}

	@Test
	void testSetIdReq() {
		Allegati al = new Allegati("", "", 1);
	    al.setId(2);
	    assertEquals(2, al.getId());
	}

	@Test
	void testGetFilename() {
		Allegati al = new Allegati("sds.pdf","",1);
		  assertEquals("sds.pdf", al.getFilename());
	}

	@Test
	void testSetFilename() {
		Allegati al = new Allegati("sds.pdf","",1);
		al.setFilename("ppp.pdf");
		assertEquals("ppp.pdf", al.getFilename());
	}

	@Test
	void testGetEmail() {
		Allegati al = new Allegati("","m.rossi@studenti.unisa.it",1);
		  assertEquals("m.rossi@studenti.unisa.it", al.getEmail());
	}

	@Test
	void testSetEmail() {
		Allegati al = new Allegati("","m.rossi@studenti.unisa.it",1);
		al.setEmail("p.cirillo@studenti.unisa.it");
		  assertEquals("p.cirillo@studenti.unisa.it", al.getEmail());
	}

}
