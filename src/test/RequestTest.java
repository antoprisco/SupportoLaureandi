package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import interfacce.UserInterface;

import java.time.Year;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import model.Attached;
import model.Ente;
import model.Request;
import model.Secretary;
import model.State;
import model.Student;

import org.junit.jupiter.api.Test;

class RequestTest {
  
  @Test
  void testRequestCostructorEmpty() {
    Request re = new Request();
    assertNotNull(re);
  }

  @Test
  void testGetIdRequest() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2001, 8, 01);

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), new ArrayList<Attached>(),
        new State(0, ""), new Ente(0, "", "", ""), ui);
    assertEquals(1, req.getIdRequest());
  }

  @Test
  void testSetIdRequest() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2001, 8, 01);

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), new ArrayList<Attached>(),
        new State(0, ""), new Ente(0, "", "", ""), ui);
    req.setIdRequest(225);
    assertEquals(225, req.getIdRequest());
  }

  @Test
  void testGetRequestCfu() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2001, 8, 01);

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), new ArrayList<Attached>(),
        new State(0, ""), new Ente(0, "", "", ""), ui);
    assertEquals(0, req.getRequestCfu());
  }

  @Test
  void testSetRequestCfu() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2001, 8, 01);

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), new ArrayList<Attached>(),
        new State(0, ""), new Ente(0, "", "", ""), ui);
    req.setRequestCfu(6);
    assertEquals(6, req.getRequestCfu());
  }

  @Test
  void testGetLevel() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2001, 8, 01);

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), new ArrayList<Attached>(),
        new State(0, ""), new Ente(0, "", "", ""), ui);
    assertEquals("", req.getLevel());
  }

  @Test
  void testSetLevel() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2001, 8, 01);

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), new ArrayList<Attached>(),
        new State(0, ""), new Ente(0, "", "", ""), ui);
    req.setLevel("level");
    assertEquals("level", req.getLevel());
  }

  @Test
  void testGetReleaseDate() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2001, 8, 01);

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), new ArrayList<Attached>(),
        new State(0, ""), new Ente(0, "", "", ""), ui);
    assertEquals("2001 - 01 - 01", Request.getSdf().format(req.getReleaseDate().getTime()));
  }

  @Test
  void testSetReleaseDate() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2001, 8, 01);

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), new ArrayList<Attached>(),
        new State(0, ""), new Ente(0, "", "", ""), ui);
    req.setReleaseDate(new GregorianCalendar(2008, 03, 17));
    assertEquals("2008 - 04 - 17", Request.getSdf().format(req.getReleaseDate().getTime()));
  }

  @Test
  void testGetExpireDate() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2001, 8, 9);

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), new ArrayList<Attached>(),
        new State(0, ""), new Ente(0, "", "", ""), ui);
    assertEquals("2001 - 09 - 09", Request.getSdf().format(req.getExpireDate().getTime()));
  }

  @Test
  void testSetExpireDate() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2004, 8, 14);

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), new ArrayList<Attached>(),
        new State(0, ""), new Ente(0, "", "", ""), ui);
    req.setExpireDate(new GregorianCalendar(2014, 7, 21));
    assertEquals("2014 - 08 - 21", Request.getSdf().format(req.getExpireDate().getTime()));
  }

  @Test
  void testGetValidateCfu() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2004, 8, 14);

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), new ArrayList<Attached>(),
        new State(0, ""), new Ente(0, "", "", ""), ui);
    assertEquals(0, req.getValidatedCfu());
  }

  @Test
  void testSetValidateCfu() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2004, 8, 14);

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), new ArrayList<Attached>(),
        new State(0, ""), new Ente(0, "", "", ""), ui);
    req.setValidatedCfu(3);
    assertEquals(3, req.getValidatedCfu());
  }

  @Test
  void testGetSerial() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2004, 8, 14);

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), new ArrayList<Attached>(),
        new State(0, ""), new Ente(0, "", "", ""), ui);
    assertEquals(111, req.getSerial());
  }

  @Test
  void testSetSerial() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2004, 8, 14);

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), new ArrayList<Attached>(),
        new State(0, ""), new Ente(0, "", "", ""), ui);
    req.setSerial(12548);
    assertEquals(12548, req.getSerial());
  }

  @Test
  void testGetYear() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2004, 8, 14);

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(2010), new ArrayList<Attached>(),
        new State(0, ""), new Ente(0, "", "", ""), ui);
    assertEquals(Year.of(2010), req.getYear());
  }

  @Test
  void testSetYear() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2004, 8, 14);

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(2010), new ArrayList<Attached>(),
        new State(0, ""), new Ente(0, "", "", ""), ui);
    req.setYear(Year.of(2009));
    assertEquals(Year.of(2009), req.getYear());
  }

  @Test
  void testGetAttached() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2004, 8, 14);
    Attached a = new Attached(01, "xxxxx");
    Attached a2 = new Attached(2, "vcds");
    List<Attached> attached = new ArrayList<>();
    attached.add(a);
    attached.add(a2);
    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), attached, new State(0, ""),
        new Ente(0, "", "", ""), ui);
    assertEquals(attached, req.getAttached());
  }

  @Test
  void testSetAttached() {
    Attached a = new Attached(01, "xxxxx");
    Attached a2 = new Attached(2, "vcds");
    List<Attached> attached = new ArrayList<>();
    attached.add(a);
    attached.add(a2);
    List<Attached> attached2 = new ArrayList<>();
    attached2.add(a2);
    Attached a3 = new Attached(3, "aasd");
    attached2.add(a3);
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2004, 8, 14);
    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), attached, new State(0, ""),
        new Ente(0, "", "", ""), ui);
    req.setAttached(attached2);
    assertEquals(attached2, req.getAttached());
  }

  @Test
  void testGetState() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2004, 8, 14);
    List<Attached> attached = new ArrayList<>();
    State state = new State(1, "xxx");

    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), attached, state,
        new Ente(0, "", "", ""), ui);
    assertEquals(state, req.getState());
  }

  @Test
  void testSetState() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2004, 8, 14);
    List<Attached> attached = new ArrayList<>();
    State state = new State(1, "xxx");
    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), attached, state,
        new Ente(0, "", "", ""), ui);
    State state2 = new State(2, "ok");
    req.setState(state2);
    assertEquals(state2, req.getState());
  }

  @Test
  void testGetEnte() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2004, 8, 14);
    List<Attached> attached = new ArrayList<>();
    State state = new State(1, "xxx");
    Ente ente = new Ente(1, "abc", "def", "ghi");
    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), attached, state, ente, ui);
    assertEquals(ente, req.getEnte());
  }

  @Test
  void testSetEnte() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2004, 8, 14);
    List<Attached> attached = new ArrayList<>();
    State state = new State(1, "xxx");
    Ente ente = new Ente(1, "abc", "def", "ghi");
    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), attached, state, ente, ui);
    Ente ente2 = new Ente(2, "lmn", "opq", "rst");
    req.setEnte(ente2);
    assertEquals(ente2, req.getEnte());
  }

  @Test
  void testGetUser() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2004, 8, 14);
    List<Attached> attached = new ArrayList<>();
    State state = new State(1, "xxx");
    Ente ente = new Ente(1, "abc", "def", "ghi");
    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), attached, state, ente, ui);
    assertEquals(ui, req.getUser());
  }

  @Test
  void testSetUser() {
    UserInterface ui = new Student();
    GregorianCalendar rd = new GregorianCalendar(2001, 00, 01);
    GregorianCalendar ed = new GregorianCalendar(2004, 8, 14);
    List<Attached> attached = new ArrayList<>();
    State state = new State(1, "xxx");
    Ente ente = new Ente(1, "abc", "def", "ghi");
    Request req = new Request(1, 0, "", rd, ed, 0, 111, Year.of(0), attached, state, ente, ui);
    UserInterface ui2 = new Secretary();
    req.setUser(ui2);
    assertEquals(ui2, req.getUser());
  }
}
