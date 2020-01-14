package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.RequestOU;

class RequestOUTest {

	@Test
	void testRequestOUEmptyConstructor() {
		RequestOU ou = new RequestOU();
			assertNotNull(ou);
	}

	@Test
	void testGetIdSkill() {
		RequestOU ou = new RequestOU(1, "", "", "");
			assertEquals(1, ou.getIdSkill());
	}

	@Test
	void testSetIdSkill() {
		RequestOU ou = new RequestOU(1, "", "", "");
			ou.setIdSkill(2);
			assertEquals(2, ou.getIdSkill());
	}

	@Test
	void testGetEmail() {
		RequestOU ou = new RequestOU(1, "m.rossi@studenti.unisa.it", "", "");
		assertEquals("m.rossi@studenti.unisa.it", ou.getEmail());
	}

	@Test
	void testSetEmail() {
		RequestOU ou = new RequestOU(1, "m.rossi@studenti.unisa.it", "", "");
			ou.setEmail("p.cirillo@studenti.unisa.it");
			assertEquals("p.cirillo@studenti.unisa.it", ou.getEmail());
	}

	@Test
	void testGetDateOfBirth() {
		RequestOU ou = new RequestOU(1, "", "1998-12-04", "");
			assertEquals("1998-12-04", ou.getDateOfBirth());
	}

	@Test
	void testSetDateOfBirth() {
		RequestOU ou = new RequestOU(1, "", "1998-12-04", "");
			ou.setDateOfBirth("1999-10-24");
			assertEquals("1999-10-24", ou.getDateOfBirth());
	}

	@Test
	void testGetCellNumber() {
		RequestOU ou = new RequestOU(1, "", "", "3412567965");
			assertEquals("3412567965", ou.getCellNumber());
	}

	@Test
	void testSetCellNumber() {
		RequestOU ou = new RequestOU(1, "", "", "3412567965");
			ou.setCellNumber("3312976432");
			assertEquals("3312976432", ou.getCellNumber());
	}

}
