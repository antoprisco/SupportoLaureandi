package test;

import controller.ServletResetEmail;
import interfacce.UserInterface;
import model.Student;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;



class ServletResetEmailTest {
  private ServletResetEmail servlet;
  private MockHttpServletResponse response;
  private MockHttpServletRequest request;
  private HttpSession session;

  @BeforeEach
  void setUp() throws Exception {
    servlet = new ServletResetEmail();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
    session = request.getSession();
  }
  
  @Test
  void test1() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("s.avolicino@studenti.unisa.it", "Simone", "Avolicino",
        'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("email", "e.email@studenti.unisa.it");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
}
