package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.ServletChangePsw;
import interfacce.UserInterface;
import model.Student;

class ServletChangePswTest {

  private ServletChangePsw servlet;
  private MockHttpServletResponse response;
  private MockHttpServletRequest request;
  private HttpSession session;

  @BeforeEach
  void setUp() throws Exception {
    servlet = new ServletChangePsw();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
    session = request.getSession();
  }
  
  @Test
  void test1() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("s.avolicino@studenti.unisa.it", "Simone", "Avolicino",
        'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("password", "password123");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  void test2() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student(null, "Simone", "Avolicino",
        'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("password", "password123");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

}
