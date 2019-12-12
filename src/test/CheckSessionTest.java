package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import controller.CheckSession;
import interfacce.UserInterface;

import javax.servlet.http.HttpSession;

import model.Attached;
import model.Ente;
import model.Secretary;
import model.Student;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class CheckSessionTest {

  @Test
  void testCheckSessionCostructor() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("","",session);
    assertNotNull(check);
  }
  
  @Test
  void testGetSession() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("","",session);
    assertEquals(session, check.getSession());
  }
  
  @Test
  void testSetSession() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("","",session);
    HttpSession session1 = request.getSession();
    check.setSession(session1);
    assertEquals(session1, check.getSession());
  }
  
  @Test
  void testGetUrlRedirect() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("","",session);
    assertEquals("/index.jsp", check.getUrlRedirect());
  }
  
  @Test
  void testSetUrlRedirect() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("","",session);
    check.setUrlRedirect("/logout.jsp");
    assertEquals("/logout.jsp", check.getUrlRedirect());
  }
  
  @Test
  void testGetPageName() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("","page1",session);
    assertEquals("page1", check.getPageName());
  }
  
  @Test
  void testSetPageName() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("","page1",session);
    check.setPageName("page2");
    assertEquals("page2", check.getPageName());
  }
  
  @Test
  void testGetPageFolder() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("folder1","",session);
    assertEquals("folder1", check.getPageFolder());
  }
  
  @Test
  void testSetPageFolder() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("folder1","",session);
    check.setPageFolder("folder2");
    assertEquals("folder2", check.getPageFolder());
  }
  
  @Test
  void testIsAllowedStudent() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    UserInterface u = new Student("stu.session@unisa.it", "name", "surname", 'M', "password", 0);
    request.getSession().setAttribute("user", u);
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("_areaStudent","",session);
    assertEquals(true, check.isAllowed());
  }
  
  @Test
  void testIsAllowedSecretary() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    UserInterface u = new Secretary("sec.session@unisa.it", "name", "surname", 'M', "password", 1);
    request.getSession().setAttribute("user", u);
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("_areaSecretary","",session);
    assertEquals(true, check.isAllowed());
  }
  
  @Test
  void testIsAllowedAdmin() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    UserInterface u = new Secretary("adm.session@unisa.it", "name", "surname", 'M', "password", 2);
    request.getSession().setAttribute("user", u);
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("_areaAdmin","",session);
    assertEquals(true, check.isAllowed());
  }
  
  @Test
  void testIsAllowedStudentFail() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    UserInterface u = new Student("stu.session@unisa.it", "name", "surname", 'M', "password", 0);
    request.getSession().setAttribute("user", u);
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("_areaStudenti","",session);
    assertEquals(false, check.isAllowed());
  }
  
  @Test
  void testIsAllowedSecretaryFail() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    UserInterface u = new Secretary("sec.session@unisa.it", "name", "surname", 'M', "password", 1);
    request.getSession().setAttribute("user", u);
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("_areaSecretari","",session);
    assertEquals(false, check.isAllowed());
  }
  
  @Test
  void testIsAllowedAdminFail() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    UserInterface u = new Secretary("adm.session@unisa.it", "name", "surname", 'M', "password", 2);
    request.getSession().setAttribute("user", u);
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("_areaAdmino","",session);
    assertEquals(false, check.isAllowed());
  }
  
  @Test
  void testIsAllowedNull() {
    MockHttpServletRequest request = new MockHttpServletRequest();
    UserInterface u = new Student("stu.session@unisa.it", "name", "surname", 'M', "password", 0);
    HttpSession session = request.getSession();
    CheckSession check = new CheckSession("_areaStudent","",session);
    assertEquals(false, check.isAllowed());
  }
}
