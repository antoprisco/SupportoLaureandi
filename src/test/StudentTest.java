package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue; 
import static org.junit.jupiter.api.Assertions.assertEquals;

import model.Student;

import org.junit.jupiter.api.Test;

class StudentTest {
  
  @Test
  void testStudentCostructorEmpty() {
    Student stu = new Student();
    assertNotNull(stu);
  }

  @Test
  void testGetEmail() {
    Student st = new Student("aaa@sss.it", "", "", 'k', "", 0);
    assertEquals("aaa@sss.it", st.getEmail());
  }

  @Test
  void testGetName() {
    Student st = new Student("aaa@sss.it", "Giorgio", "", 'k', "", 0);
    assertEquals("Giorgio", st.getName());
  }

  @Test
  void testGetSurname() {
    Student st = new Student("aaa@sss.it", "Giorgio", "Rossi", 'k', "", 0);
    assertEquals("Rossi", st.getSurname());
  }

  @Test
  void testGetSex() {
    Student st = new Student("aaa@sss.it", "Giorgio", "", 'm', "", 0);
    assertEquals('m', st.getSex());
  }

  @Test
  void testGetPassword() {
    Student st = new Student("aaa@sss.it", "Giorgio", "", 'k', "xxx", 0);
    assertEquals("xxx", st.getPassword());
  }

  @Test
  void testGetUserType() {
    Student st = new Student("aaa@sss.it", "Giorgio", "", 'k', "", 0);
    assertEquals(0, st.getUserType());
  }

  @Test
  void testSetEmail() {
    Student st = new Student("aaa@sss.it", "", "", 'r', "", 0);
    st.setEmail("aaa");
    assertEquals("aaa", st.getEmail());
  }

  @Test
  void testSetName() {
    Student st = new Student("aaa@sss.it", "bho", "", 'r', "", 0);
    st.setName("aaa");
    assertEquals("aaa", st.getName());
  }

  @Test
  void testSetSurname() {
    Student st = new Student("aaa@sss.it", "", "", 'r', "", 0);
    st.setSurname("aaa");
    assertEquals("aaa", st.getSurname());
  }

  @Test
  void testSetSex() {
    Student st = new Student("aaa@sss.it", "", "", 'r', "", 0);
    st.setSex('m');
    assertEquals('m', st.getSex());
  }

 @Test
  void testSetPassword() {
    Student st = new Student("aaa@sss.it", "", "", 'r', "", 0);
    st.setPassword("xxx");
    assertEquals("xxx", st.getPassword());
  }

  @Test
  void testUserType() {
    Student st = new Student("aaa@sss.it", "", "", 'r', "", 0);
    st.setUserType(2);
    assertEquals(2, st.getUserType());
  }

  @Test
  void testValidate() {
    Student st = new Student("aaa@sss.it", "", "", 'r', "hhh", 0);
    assertTrue(st.validate());
  }
}
