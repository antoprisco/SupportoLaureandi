package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import controller.ServletSecretary;
import interfacce.UserInterface;

import java.io.IOException;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import model.Request;
import model.Student;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class ServletSecretaryTest extends Mockito {
  private ServletSecretary servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  /**
   * Before.
   */
  @Before
  public void setUp() {
    servlet = new ServletSecretary();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }
  
  @Test
  public void testViewRequest() throws ServletException, IOException {
    request.addParameter("flag", "1");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testViewRequestFailFlag() throws ServletException, IOException {
    request.addParameter("flag", "10");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testSetCfu() throws ServletException, IOException {
    request.addParameter("idRequest", "1");
    request.addParameter("cfu", "6");
    request.addParameter("flag", "2");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testSetCfuFailFlag() throws ServletException, IOException {
    request.addParameter("idRequest", "1");
    request.addParameter("cfu", "6");
    request.addParameter("flag", "20");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testSetCfuEmpty() throws ServletException, IOException {
    request.addParameter("idRequest", "123456");
    request.addParameter("cfu", "6");
    request.addParameter("flag", "2");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testSendAdmin() throws ServletException, IOException {
    request.addParameter("idRequest", "1");
    request.addParameter("flag", "3");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testSendAdminFailFlag() throws ServletException, IOException {
    request.addParameter("idRequest", "1");
    request.addParameter("flag", "30");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testSendAdminEmpty() throws ServletException, IOException {
    request.addParameter("idRequest", "123456");
    request.addParameter("flag", "3");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testDoGet() throws ServletException, IOException {
    request.addParameter("idRequest", "1");
    request.addParameter("flag", "3");
    servlet.doGet(request, response);
    assertEquals("json", response.getContentType());
  }
}
