package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.TitoloStudio;

class TitoloStudioTest {

	@Test
	void testTitoloStudioEmptyConstructor() {
		TitoloStudio ts = new TitoloStudio();
			assertNotNull(ts);
	}

	@Test
	void testGetLaurea() {
		TitoloStudio ts = new TitoloStudio("aaa", "", "", 000, 18, "");
			assertEquals("aaa", ts.getLaurea());
	}

	@Test
	void testSetLaurea() {
		TitoloStudio ts = new TitoloStudio("aaa", "", "", 000, 18, "");
			ts.setLaurea("bbb");
			assertEquals("bbb", ts.getLaurea());
	}

	@Test
	void testGetUniversita() {
		TitoloStudio ts = new TitoloStudio("", "", "aaa", 000, 18, "");
			assertEquals("aaa", ts.getUniversita());
	}

	@Test
	void testSetUniversita() {
		TitoloStudio ts = new TitoloStudio("", "", "aaa", 000, 18, "");
			ts.setUniversita("bbb");
			assertEquals("bbb", ts.getUniversita());
	}

	@Test
	void testGetLode() {
		TitoloStudio ts = new TitoloStudio("", "", "", 000, 18, "s");
			assertEquals("s", ts.getLode());	}

	@Test
	void testSetLode() {
		TitoloStudio ts = new TitoloStudio("", "", "", 000, 18, "s");
			ts.setLode("n");
			assertEquals("n", ts.getLode());
	}

	@Test
	void testGetMatricola() {
		TitoloStudio ts = new TitoloStudio("", "", "", 000, 18, "");
			assertEquals(000, ts.getMatricola());
	}

	@Test
	void testSetMatricola() {
		TitoloStudio ts = new TitoloStudio("", "", "", 000, 18, "");
			ts.setMatricola(001);
			assertEquals(001, ts.getMatricola());
	}

	@Test
	void testGetVoto() {
		TitoloStudio ts = new TitoloStudio("", "", "", 000, 18, "");
			assertEquals(18, ts.getVoto());
	}

	@Test
	void testSetVoto() {
		TitoloStudio ts = new TitoloStudio("", "", "", 000, 18, "");
			ts.setVoto(30);
			assertEquals(30, ts.getVoto());
	}

	@Test
	void testGetDataL() {
		TitoloStudio ts = new TitoloStudio("", "2010-11-12", "", 000, 18, "");
			assertEquals("2010-11-12", ts.getDataL());
	}

	@Test
	void testSetDataL() {
		TitoloStudio ts = new TitoloStudio("", "", "2010-11-12", 000, 18, "");
			ts.setDataL("2012-01-15");
			assertEquals("2012-01-15", ts.getDataL());
	}

}
