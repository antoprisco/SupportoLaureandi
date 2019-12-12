package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import controller.ServletCommon;

import java.io.IOException;
import javax.servlet.ServletException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class ServletCommonTest extends Mockito {
  private ServletCommon servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  /**
   * Before.
   */
  @Before
  public void setUp() {
    servlet = new ServletCommon();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  public void testLoginAdmin() throws ServletException, IOException {
    request.addParameter("email", "fferrucci@unisa.it");
    request.addParameter("password", "password");
    request.addParameter("flag", "1");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testUpdateName() throws ServletException, IOException {
    request.addParameter("idUser", "fferrucci@unisa.it");
    request.addParameter("newName", "Luigia");
    request.addParameter("flag", "2");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testUpdateNameFail() throws ServletException, IOException {
    request.addParameter("idUser", "aferrucci@unisa.it");
    request.addParameter("newName", "Luigia");
    request.addParameter("flag", "2");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testUpdateSurname() throws ServletException, IOException {
    request.addParameter("idUser", "fferrucci@unisa.it");
    request.addParameter("newSurname", "Melchionno");
    request.addParameter("flag", "3");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testUpdateSurnameFail() throws ServletException, IOException {
    request.addParameter("idUser", "aferrucci@unisa.it");
    request.addParameter("newSurname", "Melchionno");
    request.addParameter("flag", "3");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testDoGet() throws ServletException, IOException {
    request.addParameter("idUser", "fferrucci@unisa.it");
    request.addParameter("newSurname", "Melchionno");
    request.addParameter("flag", "3");
    servlet.doGet(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testLoginStudent() throws ServletException, IOException {
    request.addParameter("email", "a.prova@studenti.unisa.it");
    request.addParameter("password", "password");
    request.addParameter("flag", "1");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testLoginFail() throws ServletException, IOException {
    request.addParameter("email", "a.prova@studenti.unisa.it");
    request.addParameter("password", "passwordsbagliata");
    request.addParameter("flag", "1");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testLoginSecretary() throws ServletException, IOException {
    request.addParameter("email", "segreteria@unisa.it");
    request.addParameter("password", "password");
    request.addParameter("flag", "1");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testLoginErrorType() throws ServletException, IOException {
    request.addParameter("email", "loginerror@studenti.unisa.it");
    request.addParameter("password", "password");
    request.addParameter("flag", "1");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  public void testLoginErrorFlag() throws ServletException, IOException {
    request.addParameter("email", "loginerror@studenti.unisa.it");
    request.addParameter("password", "password");
    request.addParameter("flag", "133");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
}

