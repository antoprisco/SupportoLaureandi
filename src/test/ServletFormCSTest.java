package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import controller.DbConnection;
import controller.ServletFormCS;
import interfacce.UserInterface;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import model.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

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

  @AfterEach
  void tearDown() throws SQLException, IOException {
    File folder = new File(".");
    File[] flist = folder.listFiles();
    for (int i = 0; i < flist.length; i++) {
      File pes = flist[i];
      if (pes.getName().endsWith(".pdf")) {
        (new File((flist[i].getName()))).delete();
      }
    }

    new DbConnection();
    Connection conn = DbConnection.getInstance().getConn();
    Statement stmtSelect = conn.createStatement();
    String sql = "DELETE FROM requestcs WHERE FK_STATE=1";
 //   stmtSelect.executeUpdate(sql);
  //  conn.commit();
  }

  @Test
  void testSuccess() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailCognomeLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("flag", "8");
    request.addParameter("cognome", "");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailLuogoNascitaLengt0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio1@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("flag", "8");
    request.addParameter("cognome", "annarumma");
    request.addParameter("nome", "pasquale");
    request.addParameter("luogoNascita", "");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailProvinciaLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio1@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("flag", "8");
    request.addParameter("cognome", "annarumma");
    request.addParameter("nome", "pasquale");
    request.addParameter("luogoNascita", "aaaaaaaa");
    request.addParameter("provincia", "");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailDataNascitaLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio1@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("flag", "8");
    request.addParameter("cognome", "annarumma");
    request.addParameter("nome", "pasquale");
    request.addParameter("luogoNascita", "aaaaaaaa");
    request.addParameter("provincia", "bbbbbbbbbb");
    request.addParameter("dataNascita", "");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailResidenzaLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio1@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("flag", "8");
    request.addParameter("cognome", "annarumma");
    request.addParameter("nome", "pasquale");
    request.addParameter("luogoNascita", "aaaaaaaa");
    request.addParameter("provincia", "bbbbbbbbbb");
    request.addParameter("dataNascita", "1990-02-03");
    request.addParameter("residenza", "");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailProvinciaRLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("flag", "8");
    request.addParameter("cognome", "annarumma");
    request.addParameter("nome", "pasquale");
    request.addParameter("luogoNascita", "scafati");
    request.addParameter("provincia", "salerno");
    request.addParameter("dataNascita", "1990-02-03");
    request.addParameter("residenza", "boh");
    request.addParameter("provinciaR", "");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailIndirizzoLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("flag", "8");
    request.addParameter("cognome", "annarumma");
    request.addParameter("nome", "pasquale");
    request.addParameter("luogoNascita", "scafati");
    request.addParameter("provincia", "salerno");
    request.addParameter("dataNascita", "1990-02-03");
    request.addParameter("residenza", "boh");
    request.addParameter("provinciaR", "salerno");
    request.addParameter("indirizzo", "");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    assertThrows(IllegalArgumentException.class, ()-> servlet.doPost(request, response));
    //  servlet.doPost(request, response);
  //  assertEquals("json", response.getContentType());
  }

  @Test
  void testFailCapValue0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("cap", "0");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailTelefonoFLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("telefonoF", "");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailCelulareLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("cellulare", "");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailCfLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("cellulare", "123456789");
    request.addParameter("cf", "");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailEmailLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("email", "");
    request.addParameter("diploma", "scuola superiore");
    request.addParameter("annoD", "2013");
    request.addParameter("istituto", "Publio Virgilio");
    request.addParameter("comune", "Scafati");
    request.addParameter("laurea", "Informatica");
    request.addParameter("dataL", "2014-05-03");
    request.addParameter("universita", "salerno");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailEmailPostfixWrong() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("email", "g.musacchio@gmail.it");
    request.addParameter("diploma", "scuola superiore");
    request.addParameter("annoD", "2013");
    request.addParameter("istituto", "Publio Virgilio");
    request.addParameter("comune", "Scafati");
    request.addParameter("laurea", "Informatica");
    request.addParameter("dataL", "2014-05-03");
    request.addParameter("universita", "salerno");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailEmailPrefixWrong() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("email", "g@studenti.unisa.it");
    request.addParameter("diploma", "scuola superiore");
    request.addParameter("annoD", "2013");
    request.addParameter("istituto", "Publio Virgilio");
    request.addParameter("comune", "Scafati");
    request.addParameter("laurea", "Informatica");
    request.addParameter("dataL", "2014-05-03");
    request.addParameter("universita", "salerno");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailEmailNoDot() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("email", "gmusacchio@studenti.unisa.it");
    request.addParameter("diploma", "scuola superiore");
    request.addParameter("annoD", "2013");
    request.addParameter("istituto", "Publio Virgilio");
    request.addParameter("comune", "Scafati");
    request.addParameter("laurea", "Informatica");
    request.addParameter("dataL", "2014-05-03");
    request.addParameter("universita", "salerno");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  // @Test
  // void test17() throws ServletException, IOException, SQLException {
  // UserInterface utente = new Student("g.musacchio@studenti.unisa.it",
  // "pasquale", "annarumma", 'M', "pippotto", 0);
  // session.setAttribute("user", utente);
  // request.addParameter("flag", "8");
  // request.addParameter("cognome", "annarumma");
  // request.addParameter("nome", "pasquale");
  // request.addParameter("luogoNascita", "scafati");
  // request.addParameter("provincia", "salerno");
  // request.addParameter("dataNascita", "1990-02-03");
  // request.addParameter("residenza", "boh");
  // request.addParameter("provinciaR", "salerno");
  // request.addParameter("indirizzo", "via pippo 3");
  // request.addParameter("cap", "84100");
  // request.addParameter("telefonoF", "089139481");
  // request.addParameter("cellulare", "3394218492");
  // request.addParameter("cf", "MSCPQL21J98D847H");
  // request.addParameter("email", "l.sushi@studenti.unisa.it");
  // request.addParameter("diploma", "scuola superiore");
  // request.addParameter("annoD", "2013");
  // request.addParameter("istituto", "Publio Virgilio");
  // request.addParameter("comune", "Scafati");
  // request.addParameter("laurea", "Informatica");
  // request.addParameter("dataL", "2014-05-03");
  // request.addParameter("universita", "salerno");
  // request.addParameter("matricola", "0512104133");
  // request.addParameter("voto", "100");
  //
  // request.addParameter("scelta", "[{\\\"esame\\\":\\\"ALGORITMI
  // AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");
  //
  // servlet.doPost(request, response);
  // assertEquals("json", response.getContentType());
  // }

  @Test
  void testFailDiplomaLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("diploma", "");
    request.addParameter("annoD", "2013");
    request.addParameter("istituto", "Publio Virgilio");
    request.addParameter("comune", "Scafati");
    request.addParameter("laurea", "Informatica");
    request.addParameter("dataL", "2014-05-03");
    request.addParameter("universita", "salerno");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailAnnoDBefore1970() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("annoD", "1900");
    request.addParameter("istituto", "Publio Virgilio");
    request.addParameter("comune", "Scafati");
    request.addParameter("laurea", "Informatica");
    request.addParameter("dataL", "2014-05-03");
    request.addParameter("universita", "salerno");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailAnnoDAfter2017() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("annoD", "2400");
    request.addParameter("istituto", "Publio Virgilio");
    request.addParameter("comune", "Scafati");
    request.addParameter("laurea", "Informatica");
    request.addParameter("dataL", "2014-05-03");
    request.addParameter("universita", "salerno");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailIstitutoLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("istituto", "");
    request.addParameter("comune", "Scafati");
    request.addParameter("laurea", "Informatica");
    request.addParameter("dataL", "2014-05-03");
    request.addParameter("universita", "salerno");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailComuneLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("comune", "");
    request.addParameter("laurea", "Informatica");
    request.addParameter("dataL", "2014-05-03");
    request.addParameter("universita", "salerno");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailLaureaLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("laurea", "");
    request.addParameter("dataL", "12345678");
    request.addParameter("universita", "salerno");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailUniversitaLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("universita", "");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailMatricolaNegativeValue() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("matricola", "-2");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailVotoLowerThan65() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("voto", "0");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailVotoGreaterThan111() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("voto", "400");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailUniversitaLenghtOverflow() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("dataL", "2345678");
    request.addParameter("universita", "12345678901234567890123456789012345678901");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
     assertEquals("json", response.getContentType());
  }

  @Test
  void testFailDataLLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("dataL", "");
    request.addParameter("universita", "università");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    assertThrows(IllegalArgumentException.class, ()-> servlet.doPost(request, response));
   // servlet.doPost(request, response);
   // assertEquals("json", response.getContentType());
  }

  // @Test
  // void test30() throws ServletException, IOException, SQLException {
  // UserInterface utente = new Student("g.musacchio@studenti.unisa.it",
  // "pasquale", "annarumma", 'M', "pippotto", 0);
  // session.setAttribute("user", utente);
  // request.addParameter("flag", "8");
  // request.addParameter("cognome", "annarumma");
  // request.addParameter("nome", "pasquale");
  // request.addParameter("luogoNascita", "scafati");
  // request.addParameter("provincia", "salerno");
  // request.addParameter("dataNascita", "1990-02-03");
  // request.addParameter("residenza", "boh");
  // request.addParameter("provinciaR", "salerno");
  // request.addParameter("indirizzo", "via pippo 3");
  // request.addParameter("cap", "84100");
  // request.addParameter("telefonoF", "089139481");
  // request.addParameter("cellulare", "3394218492");
  // request.addParameter("cf", "MSCPQL21J98D847H");
  // request.addParameter("email", "g.musacchio@studenti.unisa.it");
  // request.addParameter("diploma", "scuola superiore");
  // request.addParameter("annoD", "2013");
  // request.addParameter("istituto", "Publio Virgilio");
  // request.addParameter("comune", "Scafati");
  // request.addParameter("laurea", "Informatica");
  // request.addParameter("dataL", "2014-05-03");
  // request.addParameter("universita", "1234567890123456789012345678901");
  // request.addParameter("matricola", "0512104133");
  // request.addParameter("voto", "100");
  //
  // request.addParameter("scelta", "[{\\\"esame\\\":\\\"ALGORITMI
  // AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");
  //
  // servlet.doPost(request, response);
  // assertEquals("json", response.getContentType());
  // }

  @Test
  void testFailLaureaLenghtOverflow() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("laurea", "1234567890123456789012345678901");
    request.addParameter("dataL", "2014-05-03");
    request.addParameter("universita", "unauni");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailComuneLenghtOverflow() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("comune", "1234567890123456789012345678901");
    request.addParameter("laurea", "unauni");
    request.addParameter("dataL", "2014-05-03");
    request.addParameter("universita", "unauni");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailIstitutoLenghtOverflow() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("istituto", "1234567890123456789012345678901");
    request.addParameter("comune", "Roma");
    request.addParameter("laurea", "unauni");
    request.addParameter("dataL", "2014-05-03");
    request.addParameter("universita", "unauni");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailDiplomaLenghtOverflow() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("diploma", "1234567890123456789012345678901");
    request.addParameter("annoD", "2013");
    request.addParameter("istituto", "Roma");
    request.addParameter("comune", "Roma");
    request.addParameter("laurea", "unauni");
    request.addParameter("dataL", "2014-05-03");
    request.addParameter("universita", "unauni");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailCfLenghtOverflow() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("cf", "1234567890123456789012345678901");
    request.addParameter("email", "g.musacchio@studenti.unisa.it");
    request.addParameter("diploma", "roma");
    request.addParameter("annoD", "2013");
    request.addParameter("istituto", "Roma");
    request.addParameter("comune", "Roma");
    request.addParameter("laurea", "unauni");
    request.addParameter("dataL", "2014-05-03");
    request.addParameter("universita", "unauni");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

     servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailCellulareLenghtOverflow() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("cellulare", "1234567890123456789012345678901");
    request.addParameter("cf", "123");
    request.addParameter("email", "g.musacchio@studenti.unisa.it");
    request.addParameter("diploma", "roma");
    request.addParameter("annoD", "2013");
    request.addParameter("istituto", "Roma");
    request.addParameter("comune", "Roma");
    request.addParameter("laurea", "unauni");
    request.addParameter("dataL", "2014-05-03");
    request.addParameter("universita", "unauni");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testtestFailTelefonoFLenghtOverflow() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("telefonoF", "1234567890123456789012345678901");
    request.addParameter("cellulare", "1234567890");
    request.addParameter("cf", "123");
    request.addParameter("email", "g.musacchio@studenti.unisa.it");
    request.addParameter("diploma", "roma");
    request.addParameter("annoD", "2013");
    request.addParameter("istituto", "Roma");
    request.addParameter("comune", "Roma");
    request.addParameter("laurea", "unauni");
    request.addParameter("dataL", "2014-05-03");
    request.addParameter("universita", "unauni");
    request.addParameter("matricola", "0512104133");
    request.addParameter("voto", "100");

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

        servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailCapGreaterThan99999() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
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
    request.addParameter("cap", "100000");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"},{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailIndirizzoLenghtOverflow() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("flag", "8");
    request.addParameter("cognome", "annarumma");
    request.addParameter("nome", "pasquale");
    request.addParameter("luogoNascita", "scafati");
    request.addParameter("provincia", "salerno");
    request.addParameter("dataNascita", "1990-02-03");
    request.addParameter("residenza", "boh");
    request.addParameter("provinciaR", "salerno");
    request.addParameter("indirizzo",
        "123456789012345678901234567890123456789012345678901234567890");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"}," + "{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailProvinciaRLenghtOverflow() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("flag", "8");
    request.addParameter("cognome", "annarumma");
    request.addParameter("nome", "pasquale");
    request.addParameter("luogoNascita", "scafati");
    request.addParameter("provincia", "salerno");
    request.addParameter("dataNascita", "1990-02-03");
    request.addParameter("residenza", "boh");
    request.addParameter("provinciaR", "123456789012345678901234567890");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"}," + "{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailResidenzaLenghtOverflow() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("flag", "8");
    request.addParameter("cognome", "annarumma");
    request.addParameter("nome", "pasquale");
    request.addParameter("luogoNascita", "scafati");
    request.addParameter("provincia", "salerno");
    request.addParameter("dataNascita", "1990-02-03");
    request.addParameter("residenza", "1234567890123456789012345678901234567890");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"}," + "{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailProvinciaLenghtOverflow() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("flag", "8");
    request.addParameter("cognome", "annarumma");
    request.addParameter("nome", "pasquale");
    request.addParameter("luogoNascita", "scafati");
    request.addParameter("provincia", "123456789012345678901234567890");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"}," + "{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailLuogodinascitaLenghtOverflow() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("flag", "8");
    request.addParameter("cognome", "annarumma");
    request.addParameter("nome", "pasquale");
    request.addParameter("luogoNascita", "1234567890123456789012345678901234567890");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"}," + "{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void testFailNomeLenght0() throws ServletException, IOException, SQLException {
    UserInterface utente = new Student("g.musacchio@studenti.unisa.it", "pasquale", "annarumma",
        'M', "pippotto", 0);
    session.setAttribute("user", utente);
    request.addParameter("flag", "8");
    request.addParameter("cognome", "annarumma");
    request.addParameter("nome", "");
    request.addParameter("luogoNascita", "scafati");
    request.addParameter("provincia", "salerno");
    request.addParameter("dataNascita", "1990-02-03");
    request.addParameter("residenza", "boh");
    request.addParameter("provinciaR", "+-.,;:/&salerno");
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

    request.addParameter("scelta",
        "[{\\\"esame\\\":\\\"ALGORITMI AVANZATI\\\"}," + "{\\\"value\\\":\\\"1\\\"}]");

    servlet.doPost(request, response);
   assertEquals("json", response.getContentType());
  }
}

