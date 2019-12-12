package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue; 
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Secretary;

import org.junit.jupiter.api.Test;

class SecretaryTest {
  
  @Test
  void testSecretaryCostructorEmpty() {
    Secretary se = new Secretary();
    assertNotNull(se);
  }

  @Test
  void testGetEmail() {
    Secretary sc = new Secretary("aaa@sss.it", "","",'k',"", 0);
    assertEquals("aaa@sss.it",sc.getEmail());
  }

  @Test
  void testGetName() {
    Secretary sc = new Secretary("aaa@sss.it", "Giorgio","",'k',"", 0);
    assertEquals("Giorgio", sc.getName());
  }

  @Test
  void testGetSurame() {
    Secretary sc = new Secretary("aaa@sss.it", "Giorgio","Rossi",'k',"", 0);
    assertEquals("Rossi", sc.getSurname());
  }

  @Test
  void testGetSex() {
    Secretary sc = new Secretary("aaa@sss.it", "Giorgio","",'m',"", 0);
    assertEquals('m', sc.getSex());
  }

  @Test
  void testGetPassword() {
    Secretary sc = new Secretary("aaa@sss.it", "Giorgio","",'k',"xxx", 0);
    assertEquals("xxx", sc.getPassword());
  }

  @Test
  void testGetUserType() {
    Secretary sc = new Secretary("aaa@sss.it", "Giorgio","",'k',"", 0);
    assertEquals(0, sc.getUserType());
  }
  
  @Test
  void testSetEmail() { 
    Secretary sc = new Secretary("aaa@sss.it", "", "", 'r', "", 0);
    sc.setEmail("aaa");
    assertEquals("aaa", sc.getEmail());
  }
  
  @Test
  void testSetName() { 
    Secretary sc = new Secretary("aaa@sss.it", "bho", "", 'r', "", 0);
    sc.setName("aaa");
    assertEquals("aaa", sc.getName());
  }
  
  @Test
  void testSetSurname() { 
    Secretary sc = new Secretary("aaa@sss.it", "", "", 'r', "", 0);
    sc.setSurname("aaa");
    assertEquals("aaa", sc.getSurname());
  }
  
  @Test
  void testSetSex() { 
    Secretary sc = new Secretary("aaa@sss.it", "", "", 'r', "", 0);
    sc.setSex('m');
    assertEquals('m', sc.getSex());
  }

  @Test
  void testSetPassword() { 
    Secretary sc = new Secretary("aaa@sss.it", "", "", 'r', "", 0);
    sc.setPassword("xxx");
    assertEquals("xxx", sc.getPassword());
  }
  
  @Test
  void testUserType() { 
    Secretary sc = new Secretary("aaa@sss.it", "", "", 'r', "", 0);
    sc.setUserType(2);
    assertEquals(2, sc.getUserType());
  }
  
  @Test
  void testValidate() {
    Secretary sc = new Secretary("zzz@lif.it", "","",'f', "qqq", 1);
    assertTrue(sc.validate());
  }
}
