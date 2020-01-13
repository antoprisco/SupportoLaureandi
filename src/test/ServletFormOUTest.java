package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import controller.ServletCercaLM;
import controller.ServletFormLM;
import controller.ServletFormOU;
import interfacce.UserInterface;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Student;

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
  public void testOk() throws ServletException, IOException {
    UserInterface utente = 
        new Student("a.napolii@studenti.unisa.it", "antonio", "napoli", 'M', "plutone", 0);
    session.setAttribute("user", utente);
    request.addParameter("nome", "pasquale");
    request.addParameter("cognome", "annarumma");
    request.addParameter("email", "a.napolii@studenti.unisa.it");
    request.addParameter("telefono", "3420966986");
    request.addParameter("datanascita", "1994-10-10");
    request.addParameter("skills", "[{\"skill\":\"java\",\"value\":\"basso\"},"
        + "{\"skill\":\"c\",\"value\":\"medio\"},"
        + "{\"skill\":\"mysql\",\"value\":\"alto\"}]");
    request.addParameter("softSkills", "[{\"softskill\":\"\"},{\"softskill\":\"problem solving\"},"
        + "{\"softskill\":\"ciaoooooooooooooo\"}]");
    request.addParameter("lingue", "[{\"lang\":\"inglese\",\"value\":\"A1\"},"
        + "{\"lang\":\"francese\",\"value\":\"A2\"},"
        + "{\"lang\":\"tedesco\",\"value\":\"B1\"},{\"lang\":\"spagnolo\",\"value\":\"B2\"}]");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testReqExist() throws ServletException, IOException {
    UserInterface utente = 
        new Student("p.annarumma@studenti.unisa.it", "pasquale", "annarumma", 'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("nome", "pasquale");
    request.addParameter("cognome", "annarumma");
    request.addParameter("email", "p.annarumma@studenti.unisa.it");
    request.addParameter("telefono", "3420966986");
    request.addParameter("datanascita", "1994-10-10");
    request.addParameter("skills", "[{\"skill\":\"java\",\"value\":\"basso\"},"
        + "{\"skill\":\"c\",\"value\":\"medio\"},"
        + "{\"skill\":\"mysql\",\"value\":\"alto\"}]");
    request.addParameter("softSkills", "[{\"softskill\":\"\"},{\"softskill\":\"problem solving\"},"
        + "{\"softskill\":\"ciaoooooooooooooo\"}]");
    request.addParameter("lingue", "[{\"lang\":\"inglese\",\"value\":\"A1\"},"
        + "{\"lang\":\"francese\",\"value\":\"A2\"},"
        + "{\"lang\":\"tedesco\",\"value\":\"B1\"},{\"lang\":\"spagnolo\",\"value\":\"B2\"}]");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testNameLenght0() throws ServletException, IOException {
    UserInterface utente = 
        new Student("a.napoli@studenti.unisa.it", "antonio", "napoli", 'M', "plutone", 0);
    session.setAttribute("user", utente);
    request.addParameter("nome", "");
    request.addParameter("cognome", "annarumma");
    request.addParameter("email", "a.napoli@studenti.unisa.it");
    request.addParameter("telefono", "3420966986");
    request.addParameter("datanascita", "1994-10-10");
    request.addParameter("skills", "[{\"skill\":\"java\",\"value\":\"basso\"},"
        + "{\"skill\":\"c\",\"value\":\"medio\"},"
        + "{\"skill\":\"mysql\",\"value\":\"alto\"}]");
    request.addParameter("softSkills", "[{\"softskill\":\"\"},{\"softskill\":\"problem solving\"},"
        + "{\"softskill\":\"ciaoooooooooooooo\"}]");
    request.addParameter("lingue", "[{\"lang\":\"inglese\",\"value\":\"A1\"},"
        + "{\"lang\":\"francese\",\"value\":\"A2\"},"
        + "{\"lang\":\"tedesco\",\"value\":\"B1\"},{\"lang\":\"spagnolo\",\"value\":\"B2\"}]");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testNameLenghtOverflow() throws ServletException, IOException {
    UserInterface utente = 
        new Student("a.napoli@studenti.unisa.it", "antonio", "napoli", 'M', "plutone", 0);
    session.setAttribute("user", utente);
    request.addParameter("nome", "pasqualepasqualepasquale");
    request.addParameter("cognome", "annarumma");
    request.addParameter("email", "a.napoli@studenti.unisa.it");
    request.addParameter("telefono", "3420966986");
    request.addParameter("datanascita", "1994-10-10");
    request.addParameter("skills", "[{\"skill\":\"java\",\"value\":\"basso\"},"
        + "{\"skill\":\"c\",\"value\":\"medio\"},"
        + "{\"skill\":\"mysql\",\"value\":\"alto\"}]");
    request.addParameter("softSkills", "[{\"softskill\":\"\"},{\"softskill\":\"problem solving\"},"
        + "{\"softskill\":\"ciaoooooooooooooo\"}]");
    request.addParameter("lingue", "[{\"lang\":\"inglese\",\"value\":\"A1\"},"
        + "{\"lang\":\"francese\",\"value\":\"A2\"},"
        + "{\"lang\":\"tedesco\",\"value\":\"B1\"},{\"lang\":\"spagnolo\",\"value\":\"B2\"}]");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testNameFailFormat() throws ServletException, IOException {
    UserInterface utente = 
        new Student("a.napoli@studenti.unisa.it", "antonio", "napoli", 'M', "plutone", 0);
    session.setAttribute("user", utente);
    request.addParameter("nome", "p4squale");
    request.addParameter("cognome", "annarumma");
    request.addParameter("email", "a.napoli@studenti.unisa.it");
    request.addParameter("telefono", "3420966986");
    request.addParameter("datanascita", "1994-10-10");
    request.addParameter("skills", "[{\"skill\":\"java\",\"value\":\"basso\"},"
        + "{\"skill\":\"c\",\"value\":\"medio\"},"
        + "{\"skill\":\"mysql\",\"value\":\"alto\"}]");
    request.addParameter("softSkills", "[{\"softskill\":\"\"},{\"softskill\":\"problem solving\"},"
        + "{\"softskill\":\"ciaoooooooooooooo\"}]");
    request.addParameter("lingue", "[{\"lang\":\"inglese\",\"value\":\"A1\"},"
        + "{\"lang\":\"francese\",\"value\":\"A2\"},"
        + "{\"lang\":\"tedesco\",\"value\":\"B1\"},{\"lang\":\"spagnolo\",\"value\":\"B2\"}]");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testSurnameLenght0() throws ServletException, IOException {
    UserInterface utente = 
        new Student("a.napoli@studenti.unisa.it", "antonio", "napoli", 'M', "plutone", 0);
    session.setAttribute("user", utente);
    request.addParameter("nome", "pasquale");
    request.addParameter("cognome", "");
    request.addParameter("email", "a.napoli@studenti.unisa.it");
    request.addParameter("telefono", "3420966986");
    request.addParameter("datanascita", "1994-10-10");
    request.addParameter("skills", "[{\"skill\":\"java\",\"value\":\"basso\"},"
        + "{\"skill\":\"c\",\"value\":\"medio\"},"
        + "{\"skill\":\"mysql\",\"value\":\"alto\"}]");
    request.addParameter("softSkills", "[{\"softskill\":\"\"},{\"softskill\":\"problem solving\"},"
        + "{\"softskill\":\"ciaoooooooooooooo\"}]");
    request.addParameter("lingue", "[{\"lang\":\"inglese\",\"value\":\"A1\"},"
        + "{\"lang\":\"francese\",\"value\":\"A2\"},"
        + "{\"lang\":\"tedesco\",\"value\":\"B1\"},{\"lang\":\"spagnolo\",\"value\":\"B2\"}]");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testSurnameLeghtOverflow() throws ServletException, IOException {
    UserInterface utente = 
        new Student("a.napoli@studenti.unisa.it", "antonio", "napoli", 'M', "plutone", 0);
    session.setAttribute("user", utente);
    request.addParameter("nome", "pasquale");
    request.addParameter("cognome", "annarummaannarummaannarumma");
    request.addParameter("email", "a.napoli@studenti.unisa.it");
    request.addParameter("telefono", "3420966986");
    request.addParameter("datanascita", "1994-10-10");
    request.addParameter("skills", "[{\"skill\":\"java\",\"value\":\"basso\"},"
        + "{\"skill\":\"c\",\"value\":\"medio\"},"
        + "{\"skill\":\"mysql\",\"value\":\"alto\"}]");
    request.addParameter("softSkills", "[{\"softskill\":\"\"},{\"softskill\":\"problem solving\"},"
        + "{\"softskill\":\"ciaoooooooooooooo\"}]");
    request.addParameter("lingue", "[{\"lang\":\"inglese\",\"value\":\"A1\"},"
        + "{\"lang\":\"francese\",\"value\":\"A2\"},"
        + "{\"lang\":\"tedesco\",\"value\":\"B1\"},{\"lang\":\"spagnolo\",\"value\":\"B2\"}]");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testEmailLenght0() throws ServletException, IOException {
    UserInterface utente = 
        new Student("a.napolii@studenti.unisa.it", "antonio", "napoli", 'M', "plutone", 0);
    session.setAttribute("user", utente);
    request.addParameter("nome", "pasquale");
    request.addParameter("cognome", "annarumma");
    request.addParameter("email", "");
    request.addParameter("telefono", "3420966986");
    request.addParameter("datanascita", "1994-10-10");
    request.addParameter("skills", "[{\"skill\":\"java\",\"value\":\"basso\"},"
        + "{\"skill\":\"c\",\"value\":\"medio\"},"
        + "{\"skill\":\"mysql\",\"value\":\"alto\"}]");
    request.addParameter("softSkills", "[{\"softskill\":\"\"},{\"softskill\":\"problem solving\"},"
        + "{\"softskill\":\"ciaoooooooooooooo\"}]");
    request.addParameter("lingue", "[{\"lang\":\"inglese\",\"value\":\"A1\"},"
        + "{\"lang\":\"francese\",\"value\":\"A2\"},"
        + "{\"lang\":\"tedesco\",\"value\":\"B1\"},{\"lang\":\"spagnolo\",\"value\":\"B2\"}]");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testEmailFailFormat() throws ServletException, IOException {
    UserInterface utente = 
        new Student("a.napolii@studenti.unisa.it", "antonio", "napoli", 'M', "plutone", 0);
    session.setAttribute("user", utente);
    request.addParameter("nome", "pasquale");
    request.addParameter("cognome", "annarumma");
    request.addParameter("email", "a.napoli@studentii.unisa.it");
    request.addParameter("telefono", "3420966986");
    request.addParameter("datanascita", "1994-10-10");
    request.addParameter("skills", "[{\"skill\":\"java\",\"value\":\"basso\"},"
        + "{\"skill\":\"c\",\"value\":\"medio\"},"
        + "{\"skill\":\"mysql\",\"value\":\"alto\"}]");
    request.addParameter("softSkills", "[{\"softskill\":\"\"},{\"softskill\":\"problem solving\"},"
        + "{\"softskill\":\"ciaoooooooooooooo\"}]");
    request.addParameter("lingue", "[{\"lang\":\"inglese\",\"value\":\"A1\"},"
        + "{\"lang\":\"francese\",\"value\":\"A2\"},"
        + "{\"lang\":\"tedesco\",\"value\":\"B1\"},{\"lang\":\"spagnolo\",\"value\":\"B2\"}]");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  
  @Test
  public void testEmailLenght2() throws ServletException, IOException {
    UserInterface utente = 
        new Student("a.napolii@studenti.unisa.it", "antonio", "napoli", 'M', "plutone", 0);
    session.setAttribute("user", utente);
    request.addParameter("nome", "pasquale");
    request.addParameter("cognome", "annarumma");
    request.addParameter("email", "an@studenti.unisa.it");
    request.addParameter("telefono", "3420966986");
    request.addParameter("datanascita", "1994-10-10");
    request.addParameter("skills", "[{\"skill\":\"java\",\"value\":\"basso\"},"
        + "{\"skill\":\"c\",\"value\":\"medio\"},"
        + "{\"skill\":\"mysql\",\"value\":\"alto\"}]");
    request.addParameter("softSkills", "[{\"softskill\":\"\"},{\"softskill\":\"problem solving\"},"
        + "{\"softskill\":\"ciaoooooooooooooo\"}]");
    request.addParameter("lingue", "[{\"lang\":\"inglese\",\"value\":\"A1\"},"
        + "{\"lang\":\"francese\",\"value\":\"A2\"},"
        + "{\"lang\":\"tedesco\",\"value\":\"B1\"},{\"lang\":\"spagnolo\",\"value\":\"B2\"}]");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testTelefonoLenght0() throws ServletException, IOException {
    UserInterface utente = 
        new Student("a.napolii@studenti.unisa.it", "antonio", "napoli", 'M', "plutone", 0);
    session.setAttribute("user", utente);
    request.addParameter("nome", "pasquale");
    request.addParameter("cognome", "annarumma");
    request.addParameter("email", "a.napolii@studenti.unisa.it");
    request.addParameter("telefono", "");
    request.addParameter("datanascita", "1994-10-10");
    request.addParameter("skills", "[{\"skill\":\"java\",\"value\":\"basso\"},"
        + "{\"skill\":\"c\",\"value\":\"medio\"},"
        + "{\"skill\":\"mysql\",\"value\":\"alto\"}]");
    request.addParameter("softSkills", "[{\"softskill\":\"\"},{\"softskill\":\"problem solving\"},"
        + "{\"softskill\":\"ciaoooooooooooooo\"}]");
    request.addParameter("lingue", "[{\"lang\":\"inglese\",\"value\":\"A1\"},"
        + "{\"lang\":\"francese\",\"value\":\"A2\"},"
        + "{\"lang\":\"tedesco\",\"value\":\"B1\"},{\"lang\":\"spagnolo\",\"value\":\"B2\"}]");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testTelefonoLenghtOverflow() throws ServletException, IOException {
    UserInterface utente = 
        new Student("a.napolii@studenti.unisa.it", "antonio", "napoli", 'M', "plutone", 0);
    session.setAttribute("user", utente);
    request.addParameter("nome", "pasquale");
    request.addParameter("cognome", "annarumma");
    request.addParameter("email", "a.napolii@studenti.unisa.it");
    request.addParameter("telefono", "3420966986123123");
    request.addParameter("datanascita", "1994-10-10");
    request.addParameter("skills", "[{\"skill\":\"java\",\"value\":\"basso\"},"
        + "{\"skill\":\"c\",\"value\":\"medio\"},"
        + "{\"skill\":\"mysql\",\"value\":\"alto\"}]");
    request.addParameter("softSkills", "[{\"softskill\":\"\"},{\"softskill\":\"problem solving\"},"
        + "{\"softskill\":\"ciaoooooooooooooo\"}]");
    request.addParameter("lingue", "[{\"lang\":\"inglese\",\"value\":\"A1\"},"
        + "{\"lang\":\"francese\",\"value\":\"A2\"},"
        + "{\"lang\":\"tedesco\",\"value\":\"B1\"},{\"lang\":\"spagnolo\",\"value\":\"B2\"}]");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
}