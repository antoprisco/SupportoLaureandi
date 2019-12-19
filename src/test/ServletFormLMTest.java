package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import controller.ServletCercaLM;
import controller.ServletFormLM;
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

public class ServletFormLMTest extends Mockito {
  private ServletFormLM servlet;
  private HttpSession session;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  /**
   * Before.
   */
  @Before
  public void setUp() {
    servlet = new ServletFormLM();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
    session = request.getSession();
  }
  
  @Test
  public void test1() throws ServletException, IOException {
	UserInterface utente = new Student("p.annarumma@studenti.unisa.it", "pasquale", "annarumma", 'M', "pippotto", 0);
	session.setAttribute("user", utente);
	 request.addParameter("flag", "6");
    request.addParameter("curriculum", "cloud");
    request.addParameter("anno", "2020");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void test2() throws ServletException, IOException {
	UserInterface utente = new Student("p.annarumma@studenti.unisa.it", "pasquale", "annarumma", 'M', "pippotto", 0);
	session.setAttribute("user", utente);
	 request.addParameter("flag", "6");
    request.addParameter("curriculum", "");
    request.addParameter("anno", "2020");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void test3() throws ServletException, IOException {
	UserInterface utente = new Student("p.annarumma@studenti.unisa.it", "pasquale", "annarumma", 'M', "pippotto", 0);
	session.setAttribute("user", utente);
	 request.addParameter("flag", "6");
    request.addParameter("curriculum", "cloud");
    request.addParameter("anno", "");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  
  @Test
  public void test4() throws ServletException, IOException {
	UserInterface utente = new Student("s.sergiotto@studenti.unisa.it", "sergio", "nicola", 'M', "pippotto", 0);
	session.setAttribute("user", utente);
	 request.addParameter("flag", "6");
    request.addParameter("curriculum", "cloud");
    request.addParameter("anno", "2020");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  
  @Test
  public void test5() throws ServletException, IOException {
	UserInterface utente = new Student("p.annarumma@studenti.unisa.it", "pasquale", "annarumma", 'M', "pippotto", 0);
	session.setAttribute("user", utente);
	 request.addParameter("flag", "7");
    request.addParameter("curriculum", "cloud");
    request.addParameter("anno", "2020");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
}