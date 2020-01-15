package test;

import controller.ServletChangeStReqCS;
import java.io.IOException;
import javax.servlet.ServletException;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;



class ServletChangeStReqCSTest {
  private ServletChangeStReqCS servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() throws Exception {
    servlet = new ServletChangeStReqCS();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  public void test1() throws ServletException, IOException {
    request.addParameter("idreq", "1");
    request.addParameter("stato", "3");
    request.addParameter("op", "1");
    servlet.doPost(request, response);
    assertEquals(null, request.getContentType());
  }
  
  @Test
  public void test2() throws ServletException, IOException {
    request.addParameter("idreq", "1");
    request.addParameter("stato", "3");
    request.addParameter("op", "2");
    servlet.doPost(request, response);
    assertEquals(null, request.getContentType());
  }
  
  @Test
  public void test3() throws ServletException, IOException {
    request.addParameter("idreq", "1");
    request.addParameter("stato", "4");
    request.addParameter("op", "1");
    servlet.doPost(request, response);
    assertEquals(null, request.getContentType());
  }
  
  @Test
  public void test4() throws ServletException, IOException {
    request.addParameter("idreq", "1");
    request.addParameter("stato", "4");
    request.addParameter("op", "2");
    servlet.doPost(request, response);
    assertEquals(null, request.getContentType());
  }
  
  @Test
  public void test5() throws ServletException, IOException {
    request.addParameter("idreq", "1");
    request.addParameter("stato", "5");
    request.addParameter("op", "1");
    servlet.doPost(request, response);
    assertEquals(null, request.getContentType());
  }
  
  @Test
  public void test6() throws ServletException, IOException {
    request.addParameter("idreq", "1");
    request.addParameter("stato", "5");
    request.addParameter("op", "2");
    servlet.doPost(request, response);
    assertEquals(null, request.getContentType());
  }
  
  @Test
  public void test7() throws ServletException, IOException {
    request.addParameter("idreq", "1");
    request.addParameter("stato", "6");
    request.addParameter("op", "1");
    servlet.doPost(request, response);
    assertEquals(null, request.getContentType());
  }
}