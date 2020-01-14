package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Corsi;

class CorsiTest {


	@Test
	void testCorsiEmptyConstructor() {
		Corsi cs = new Corsi();
			assertNotNull(cs);
	}

	@Test
	void testGetId() {
		Corsi cs = new Corsi(1, "", 1, 9);
			assertEquals(1, cs.getId());
	}

	@Test
	void testSetId() {
		Corsi cs = new Corsi(1, "", 1, 9);
			cs.setId(2);
			assertEquals(2, cs.getId());
	}

	@Test
	void testGetSemestre() {
		Corsi cs = new Corsi(1, "", 1, 9);
			assertEquals(1, cs.getSemestre());
	}

	@Test
	void testSetSemestre() {
		Corsi cs = new Corsi(1, "", 1, 9);
			cs.setSemestre(2);
			assertEquals(2, cs.getSemestre());
	}

	@Test
	void testGetCfu() {
		Corsi cs = new Corsi(1, "", 1, 9);
			assertEquals(9, cs.getCfu());
	}

	@Test
	void testSetCfu() {
		Corsi cs = new Corsi(1, "", 1, 9);
			cs.setCfu(6);
			assertEquals(6, cs.getCfu());
	}

	@Test
	void testGetNome() {
		Corsi cs = new Corsi(1, "compilatori", 1, 9);
			assertEquals("compilatori", cs.getNome());
	}

	@Test
	void testSetNome() {
		Corsi cs = new Corsi(1, "compilatori", 1, 9);
			cs.setNome("algoritmi avanzati");
			assertEquals("algoritmi avanzati", cs.getNome());
	}

}
