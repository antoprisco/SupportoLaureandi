package test;

	import static org.junit.jupiter.api.Assertions.assertEquals;

import controller.DownloaderPDF;
import controller.ServletCercaLM;
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

	public class DownloaderPDFTest extends Mockito {
	  private DownloaderPDF servlet;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	  private HttpSession session;

	  /**
	   * Before.
	   */
	  @Before
	  public void setUp() {
	    servlet = new DownloaderPDF();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	    session = request.getSession();
	  }
	  
	  @Test
	  public void test1() throws ServletException, IOException { 
	    UserInterface utente = 
	        new Student("p.annarumma@studenti.unisa.it", "pasquale", "annarumma", 'M', "pippotto", 0);
		session.setAttribute("user", utente);
	    request.addParameter("flag", "1");
	    servlet.doPost(request, response);
	    assertEquals(null , response.getContentType());
	  }
	  
	  @Test
	  public void test2() throws ServletException, IOException { 
	    UserInterface utente = 
	        new Student("p.annarumma@studenti.unisa.it", "pasquale", "annarumma", 'M', "pippotto", 0);
		session.setAttribute("user", utente);
	    request.addParameter("flag", "2");
	    servlet.doPost(request, response);
	    assertEquals(null, response.getContentType());
	  }

}
