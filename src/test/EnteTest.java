package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals; 

import model.Ente;

import org.junit.jupiter.api.Test;

class EnteTest {

  // INIZIO TEST GET

  @Test
  void testGetIdEnte() {
    Ente en = new Ente(01, "", "", "");
    assertEquals(01, en.getIdEnte());
  }
  
  @Test
  void testEnteCostructorEmpty() {
    Ente en = new Ente();
    assertNotNull(en);
  }


  @Test
  void testGetEmail() {
    Ente en = new Ente(01, "aaa@sss.it", "", "");
    assertEquals("aaa@sss.it", en.getEmail());
  }

  @Test
  void testGetName() {
    Ente en = new Ente(01, "", "English", "");
    assertEquals("English", en.getName());
  }

  @Test
  void testGetSite() {
    Ente en = new Ente(01, "", "", "Validation");
    assertEquals("Validation", en.getSite());
  }
  // FINE TEST GET

  // INIZIO TEST SET

  @Test
  void testSetIdEnte() {
    Ente en = new Ente(01, "", "", "");
    en.setIdEnte(001);
    assertEquals(001, en.getIdEnte());
  }

  @Test
  void testSetEmail() {
    Ente en = new Ente(01, "aaa@sss.it", "", "");
    en.setEmail("aaa");
    assertEquals("aaa", en.getEmail());
  }

  @Test
  void testSetName() {
    Ente en = new Ente(01, "", "English", "");
    en.setName("Italy");
    assertEquals("Italy", en.getName());
  }

  @Test
  void testSetSite() {
    Ente en = new Ente(01, "", "", "Validation");
    en.setSite("Validazione");
    assertEquals("Validazione", en.getSite());
  }

  // FINE TEST SET

}
