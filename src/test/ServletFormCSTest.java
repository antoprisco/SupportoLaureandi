package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.ServletFormCS;
import controller.ServletFormLM;
import interfacce.UserInterface;
import model.Student;

class ServletFormCSTest {
	
	private ServletFormCS servlet;
	private MockHttpServletResponse response;
	private MockHttpServletRequest request;
	private HttpSession session; 
	

	@BeforeEach
	void setUp() throws Exception {
		servlet = new ServletFormCS();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	    session = request.getSession();
	}

	@Test
	void test1() throws ServletException, IOException {
		UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma", 'M', "pippotto", 0);
		session.setAttribute("user", utente);
		request.addParameter("flag", "8");
		request.addParameter("cognome", "annarumma");
		request.addParameter("nome", "pasquale");
		request.addParameter("luogoNascita", "scafati");
		request.addParameter("provincia", "salerno");
		request.addParameter("dataNascita", "1990-02-03");
		request.addParameter("residenza", "boh");
		request.addParameter("provinciaR", "salerno");
		request.addParameter("indirizzo", "via pippo 3");
		request.addParameter("cap", "84100");
		request.addParameter("telefonoF", "089139481");
		request.addParameter("cellulare", "3394218492");
		request.addParameter("cf", "MSCPQL21J98D847H");
		request.addParameter("email", "g.musacchio@studenti.unisa.it");
		request.addParameter("diploma", "scuola superiore");
		request.addParameter("annoD", "2013");
		request.addParameter("istituto", "Publio Virgilio");
		request.addParameter("comune", "Scafati");
		request.addParameter("laurea", "Informatica");
		request.addParameter("dataL", "2014-05-03");
		request.addParameter("universita", "salerno");
		request.addParameter("matricola", "0512104133");
		request.addParameter("voto", "100");
		
		request.addParameter("scelta", "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");
		
		servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
	}
}
