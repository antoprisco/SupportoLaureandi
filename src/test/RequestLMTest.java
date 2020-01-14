package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.RequestLM;

class RequestLMTest {

/*	@Test
	void testGetCount() {
		fail("Not yet implemented");
	}

	@Test
	void testSetCount() {
		fail("Not yet implemented");
	}
*/
	
	@Test
	void testRequestLMEmptyConstructor() {
		RequestLM lm = new RequestLM();
			assertNotNull(lm);
	}

	@Test
	void testGetId() {
		RequestLM lm = new RequestLM(120, "", 2020, "");
			assertEquals(120, lm.getId());
	}

	@Test
	void testSetId() {
		RequestLM lm = new RequestLM(120, "", 2020, "");
			lm.setId(130);
			assertEquals(130, lm.getId());
	}

	@Test
	void testGetYear() {
		RequestLM lm = new RequestLM(120, "", 2020, "");
			assertEquals(2020, lm.getYear());
	}

	@Test
	void testSetYear() {
		RequestLM lm = new RequestLM(120, "", 2020, "");
			lm.setYear(2021);
			assertEquals(2021, lm.getYear());
	}

	@Test
	void testGetEmail() {
		RequestLM lm = new RequestLM(120, "", 2020, "m.rossi@studenti.unisa.it");
			assertEquals("m.rossi@studenti.unisa.it", lm.getEmail());
	}

	@Test
	void testSetEmail() {
		RequestLM lm = new RequestLM(120, "", 2020, "m.rossi@studenti.unisa.it");
			lm.setEmail("p.cirillo@studenti.unisa.it");
			assertEquals("p.cirillo@studenti.unisa.it", lm.getEmail());
	}

	@Test
	void testGetCurr() {
		RequestLM lm = new RequestLM(120, "sicurezza informatica", 2020, "");
			assertEquals("sicurezza informatica", lm.getCurr());
	}

	@Test
	void testSetCurr() {
		RequestLM lm = new RequestLM(120, "sicurezza informatica", 2020, "");
			lm.setCurr("cloud computing");
			assertEquals("cloud computing", lm.getCurr());
	}

}
