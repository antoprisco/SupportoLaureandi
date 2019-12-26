package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import controller.ServletCercaLM;
import controller.ServletFormLM;
import controller.ServletFormOU;
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

public class ServletFormOUTest extends Mockito {
  private ServletFormOU servlet;
  private HttpSession session;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  /**
   * Before.
   */
  @Before
  public void setUp() {
    servlet = new ServletFormOU();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
    session = request.getSession();
  }
  
  @Test
  public void test1() throws ServletException, IOException {
	UserInterface utente = new Student("p.annarumma@studenti.unisa.it", "pasquale", "annarumma", 'M', "pippotto", 0);
	session.setAttribute("user", utente);
	request.addParameter("email", "p.annarumma@studenti.unisa.it");
	request.addParameter("telefono", "3420966986");
    request.addParameter("datanascita", "1994-10-10");
    request.addParameter("skills", "[{\"skill\":\"java\",\"value\":\"basso\"},{\"skill\":\"c\",\"value\":\"medio\"},{\"skill\":\"mysql\",\"value\":\"alto\"}]");
    request.addParameter("softSkills", "[{\"softskill\":\"\"},{\"softskill\":\"problem solving\"},{\"softskill\":\"ciaoooooooooooooo\"}]");
    request.addParameter("lingue", "[{\"lang\":\"inglese\",\"value\":\"A1\"},{\"lang\":\"francese\",\"value\":\"A2\"},{\"lang\":\"tedesco\",\"value\":\"B1\"},{\"lang\":\"spagnolo\",\"value\":\"B2\"}]");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void test2() throws ServletException, IOException {
	UserInterface utente = new Student("p.annarumma@studenti.unisa.it", "pasquale", "annarumma", 'M', "pippotto", 0);
	//session.setAttribute("user", utente);
	request.addParameter("email", "p.annarumma@studenti.unisa.it");
	request.addParameter("telefono", "3420966986");
    request.addParameter("datanascita", "1994-10-10");
    request.addParameter("skills", "[{\"skill\":\"java\",\"value\":\"basso\"},{\"skill\":\"c\",\"value\":\"medio\"},{\"skill\":\"mysql\",\"value\":\"alto\"}]");
    request.addParameter("softSkills", "[{\"softskill\":\"\"},{\"softskill\":\"problem solving\"},{\"softskill\":\"ciaoooooooooooooo\"}]");
    request.addParameter("lingue", "[{\"lang\":\"inglese\",\"value\":\"A1\"},{\"lang\":\"francese\",\"value\":\"A2\"},{\"lang\":\"tedesco\",\"value\":\"B1\"},{\"lang\":\"spagnolo\",\"value\":\"B2\"}]");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  
  @Test
  public void test3() throws ServletException, IOException {
	UserInterface utente = new Student("p.annarumma@studenti.unisa.it", "pasquale", "annarumma", 'M', "pippotto", 0);
	session.setAttribute("user", utente);
	request.addParameter("email", "p.annarumma@studenti.unisa.it");
	request.addParameter("telefono", "3420966986");
    request.addParameter("datanascita", "1994-10-10");
    request.addParameter("skills", "");
    request.addParameter("softSkills", "");
    request.addParameter("lingue", "[{\"lang\":\"inglese\",\"value\":\"A1\"},{\"lang\":\"francese\",\"value\":\"A2\"},{\"lang\":\"tedesco\",\"value\":\"B1\"},{\"lang\":\"spagnolo\",\"value\":\"B2\"}]");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  
  @Test
  public void test4() throws ServletException, IOException {
	UserInterface utente = new Student("p.annarumma@studenti.unisa.it", "pasquale", "annarumma", 'M', "pippotto", 0);
	session.setAttribute("user", utente);
	request.addParameter("email", "p.annarumma@studenti.unisa.it");
	request.addParameter("telefono", "3420966986");
    request.addParameter("datanascita", "1994-10-10");
    request.addParameter("skills", "");
    request.addParameter("softSkills", "");
    request.addParameter("lingue", "");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void test5() throws ServletException, IOException {
	UserInterface utente = new Student("p.annarumma@studenti.unisa.it", "pasquale", "annarumma", 'M', "pippotto", 0);
	session.setAttribute("user", utente);
	request.addParameter("email", "p.annarumma@studenti.unisa.it");
	//request.addParameter("telefono", "3420966986");
    request.addParameter("datanascita", "");
    request.addParameter("skills", "");
    request.addParameter("softSkills", "");
    request.addParameter("lingue", "[{\"lang\":\"inglese\",\"value\":\"A1\"},{\"lang\":\"francese\",\"value\":\"A2\"},{\"lang\":\"tedesco\",\"value\":\"B1\"},{\"lang\":\"spagnolo\",\"value\":\"B2\"}]");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
}