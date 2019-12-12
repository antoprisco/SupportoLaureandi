package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Admin;
import model.Student;

import org.junit.jupiter.api.Test;

class AdminTest {

  @Test
  void testAdminCostructorEmpty() {
    Admin ad = new Admin();
    assertNotNull(ad);
  }
  
  // INIZIO TEST GET

  @Test
  void testGetEmail() {
    Admin ad = new Admin("aaa@sss.it", "", "", 'm', "", 2);
    assertEquals("aaa@sss.it", ad.getEmail());
  }

  @Test
  void testGetName() {
    Admin ad = new Admin("aaa@sss.it", "Angelo", "", 'm', "", 2);
    assertEquals("Angelo", ad.getName());
  }

  @Test
  void testGetSurname() {
    Admin ad = new Admin("aaa@sss.it", "", "Macellaro", 'm', "", 2);
    assertEquals("Macellaro", ad.getSurname());
  }

  @Test
  void testGetSex() {
    Admin ad = new Admin("aaa@sss.it", "", "", 'm', "", 2);
    assertEquals('m', ad.getSex());
  }

  @Test
  void testGetPassword() {
    Admin ad = new Admin("aaa@sss.it", "", "", 'm', "Ciao1234", 2);
    assertEquals("Ciao1234", ad.getPassword());
  }

  @Test
  void testGetUserType() {
    Admin ad = new Admin("aaa@sss.it", "", "", 'm', "", 2);
    assertEquals(2, ad.getUserType());
  }

  // FINE TEST GET

  // INIZIO TEST SET

  @Test
  void testSetEmail() {
    Admin ad = new Admin("aaa@sss.it", "", "", 'm', "", 2);
    ad.setEmail("aaa");
    assertEquals("aaa", ad.getEmail());
  }

  @Test
  void testSetName() {
    Admin ad = new Admin("aaa@sss.it", "Angelo", "", 'm', "", 2);
    ad.setName("Valeria");
    assertEquals("Valeria", ad.getName());
  }

  @Test
  void testSetSurname() {
    Admin ad = new Admin("aaa@sss.it", "", "Macellaro", 'm', "", 2);
    ad.setSurname("Pontillo");
    assertEquals("Pontillo", ad.getSurname());
  }

  @Test
  void testSetSex() {
    Admin ad = new Admin("aaa@sss.it", "", "", 'm', "", 2);
    ad.setSex('f');
    assertEquals('f', ad.getSex());
  }

  @Test
  void testSetPassword() {
    Admin ad = new Admin("aaa@sss.it", "", "", 'f', "Ciao1234", 2);
    ad.setPassword("QWERTY");
    assertEquals("QWERTY", ad.getPassword());
  }

  @Test
  void testSetUserType() {
    Admin ad = new Admin("aaa@sss.it", "", "", 'f', "", 2);
    ad.setUserType(02);
    assertEquals(02, ad.getUserType());
  }

  // FINE TEST SET

  @Test
  void testValidate() {
    Student st = new Student("aaa@sss.it", "", "", 'r', "hhh", 0);
    assertTrue(st.validate());
  }


}
