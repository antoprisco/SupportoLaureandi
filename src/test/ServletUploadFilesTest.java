package test;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.ServletUploadFiles;
import interfacce.UserInterface;
import model.Student;



class ServletUploadFilesTest {
  private ServletUploadFiles servlet;
  private HttpSession session;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() throws Exception {
    servlet = new ServletUploadFiles();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
    session = request.getSession();
  }

  @Test
  public void test1() throws ServletException, IOException {
    UserInterface utente = 
        new Student("p.annarumma@studenti.unisa.it", "pasquale", "annarumma", 'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("flag", "3");
    servlet.doPost(request, response);
    assertEquals("json", request.getContentType());
  }
  
}