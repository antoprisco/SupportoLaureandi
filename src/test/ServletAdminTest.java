package test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import controller.DbConnection;
import controller.ServletAdmin;
import interfacce.UserInterface;
import model.Admin;
import model.Student;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


public class ServletAdminTest extends Mockito {
  private ServletAdmin servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  /**
   * Before.
   */
  @Before
  public void setUp() {
    servlet = new ServletAdmin();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }
  
  @Test
  public void testGenerateExcel() throws ServletException, IOException {
    UserInterface user = new Admin("fferrucci@unisa.it", "Luigi", "Melchionno", 'M', "password", 2);
    request.getSession().setAttribute("user", user);
    request.addParameter("flag", "5");
    servlet.doGet(request, response);
    assertEquals("application/vnd.ms-excel", response.getContentType());
  }
  
  @Test
  public void testGenerateExcel2() throws ServletException, IOException {
    UserInterface user = new Admin("fferrucci@unisa.it", "Luigi", "Melchionno", 'M', "password", 2);
    request.getSession().setAttribute("user", user);
    request.addParameter("flag", "6");
    servlet.doGet(request, response);
    assertEquals("application/vnd.ms-excel", response.getContentType());
  }
  
  @Test
  public void testGenerateExcelFail() throws ServletException, IOException {
    UserInterface user = new Admin("fferrucci@unisa.it", "Luigi", "Melchionno", 'M', "password", 2);
    request.getSession().setAttribute("user", user);
    request.addParameter("flag", "60");
    servlet.doGet(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testGenerateExcelFail2() throws ServletException, IOException {
    UserInterface user = new Admin("fferrucci@unisa.it", "Luigi", "Melchionno", 'M', "password", 0);
    request.getSession().setAttribute("user", user);
    request.addParameter("flag", "5");
    servlet.doGet(request, response);
    assertNull(null, response.getContentType());
  }

  @Test
  public void testViewRequest() throws ServletException, IOException {
    request.addParameter("flag", "1");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testUpdateRequest() throws ServletException, IOException {
    request.addParameter("type", "1");
    request.addParameter("idRequest", "2");
    request.addParameter("flag", "2");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testUpdateRequest1() throws ServletException, IOException {
    request.addParameter("type", "2");
    request.addParameter("idRequest", "3");
    request.addParameter("flag", "2");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testUpdateRequest2() throws ServletException, IOException {
    request.addParameter("type", "3");
    request.addParameter("idRequest", "3");
    request.addParameter("flag", "2");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testUpdateRequestEmpty() throws ServletException, IOException {
    request.addParameter("type", "2");
    request.addParameter("idRequest", "321456");
    request.addParameter("flag", "2");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testUpdateRequestAccepted() throws ServletException, IOException {
    request.addParameter("idRequest", "1");
    request.addParameter("flag", "3");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testUpdateRequestAcceptedEmpty() throws ServletException, IOException {
    request.addParameter("idRequest", "123456");
    request.addParameter("flag", "3");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testUpdateRequestRefused() throws ServletException, IOException {
    request.addParameter("idRequest", "4");
    request.addParameter("flag", "4");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void testUpdateRequestRefusedEmpty() throws ServletException, IOException {
    request.addParameter("idRequest", "456789");
    request.addParameter("flag", "4");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
}
