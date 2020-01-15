package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import controller.ServletCercaLM;
import controller.ServletGeneraExcel;
import interfacce.UserInterface;
import model.Student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class ServletGeneraExcelTest extends Mockito {
  private ServletGeneraExcel servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;
  private HttpSession session;
  /**
   * Before.
   */
  @Before
  public void setUp() {
    servlet = new ServletGeneraExcel();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
    session = request.getSession();
  }
  
  @Test
  public void test1() throws ServletException, IOException { //Anno presente nel DB
    UserInterface utente = 
        new Student("fferrucci@unisa.it", "f", "f", 'M', "plutone", 2);
    session.setAttribute("user", utente);
    request.addParameter("flag", "5");
    servlet.doGet(request, response);
    assertEquals("application/vnd.ms-excel", response.getContentType());
  }
  
  @Test
  public void test2() throws ServletException, IOException { //Anno non presente nel DB
    UserInterface utente = 
        new Student("fferrucci@unisa.it", "f", "f", 'M', "plutone", 2);
    session.setAttribute("user", utente);
    request.addParameter("flag", "6");
    request.addParameter("anno", "2019");
    servlet.doGet(request, response);
    assertEquals("application/vnd.ms-excel", response.getContentType());
  }
  
  @Test
  public void test3() throws ServletException, IOException { //Anno non presente nel DB
    UserInterface utente = 
        new Student("fferrucci@unisa.it", "f", "f", 'M', "plutone", 2);
    session.setAttribute("user", utente);
    request.addParameter("flag", "10");
    request.addParameter("anno", "2019");
    servlet.doGet(request, response);
    assertEquals(null, response.getContentType());
  }
  
  @Test
  public void test4() throws ServletException, IOException { //Anno non presente nel DB
    UserInterface utente = 
        new Student("fferrucci@unisa.it", "f", "f", 'M', "plutone", 1);
    session.setAttribute("user", utente);
    request.addParameter("flag", "10");
    request.addParameter("anno", "2019");
    servlet.doGet(request, response);
    assertEquals(null, response.getContentType());
  }
  
  
  
}