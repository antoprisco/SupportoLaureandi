package test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import controller.Uploader;
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


public class UploaderTest extends Mockito {
  private Uploader servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  /**
   * Before.
   */
  @Before
  public void setUp() {
    servlet = new Uploader();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }
  
  @Test
  public void testDoPost() throws ServletException, IOException {
    request.addParameter("idRequest", "2");
    request.getSession().setAttribute("idRequest", 2);
    servlet.doPost(request, response);
    assertEquals("text/html", response.getContentType());
  }
  
  @Test
  public void testDoPostFail() throws ServletException, IOException {
    request.addParameter("idRequest", "389");
    request.getSession().setAttribute("idRequest", 389);
    servlet.doPost(request, response);
    assertEquals("text/html", response.getContentType());
  }
}