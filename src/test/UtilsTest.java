package test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import controller.Utils;

import interfacce.UserInterface;

import java.time.Year;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpSession;

import model.Attached;
import model.Ente;
import model.Request;
import model.State;
import model.Student;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

class UtilsTest {

  @Test
  void testGetRequestState() {
    Utils ut = new Utils();
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2017, 05, 25);
    GregorianCalendar ed = new GregorianCalendar(2018, 05, 25);
    Request req = new Request(1, 3, "A1", rd, ed, 6, 
        512103579, Year.of(0), new ArrayList<Attached>(),
        new State(3, ""), new Ente(1, "", "", ""), ui);
    assertEquals(Integer.valueOf(3), ut.getRequestState(1));
  }

  @Test
  void testGetLastUserRequestPartiallyCompleted() {
    Utils ut = new Utils();
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    UserInterface user = new Student("x.x@studenti.unisa.it", "fdg", "surname", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    assertEquals(Integer.valueOf(11), ut.getLastUserRequestPartiallyCompleted(session));
  }
  
  @Test
  void testGetLastUserRequestPartiallyCompletedFail() {
    Utils ut = new Utils();
    MockHttpServletRequest request = new MockHttpServletRequest();
    HttpSession session = request.getSession();
    assertEquals(Integer.valueOf(0), ut.getLastUserRequestPartiallyCompleted(session));
  }
}
