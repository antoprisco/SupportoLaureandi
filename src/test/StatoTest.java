package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Stato;

class StatoTest {

	@Test
	void testStatoEmptyConstructor() {
		Stato st = new Stato();
			assertNotNull(st);
	}

	@Test
	void testGetId() {
		Stato st = new Stato(1, "");
			assertEquals(1, st.getId());
	}

	@Test
	void testSetId() {
		Stato st = new Stato(1, "");
			st.setId(2);
			assertEquals(2, st.getId());
	}

	@Test
	void testGetDescr() {
		Stato st = new Stato(1, "aaa");
			assertEquals("aaa", st.getDescr());
	}

	@Test
	void testSetDescr() {
		Stato st = new Stato(1, "aaa");
			st.setDescr("bbb");
			assertEquals("bbb", st.getDescr());
	}

}
