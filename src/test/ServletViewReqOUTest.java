package test;


import java.io.IOException;
import javax.servlet.ServletException;
import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.ServletViewReqOU;



class ServletViewReqOUTest {
  private ServletViewReqOU servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() throws Exception {
    servlet = new ServletViewReqOU();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }
  
  @Test
  public void test1() throws ServletException, IOException {
    request.addParameter("flag", "1");
    servlet.doPost(request, response);
    assertEquals(null, request.getContentType());
  }
  
  @Test
  public void test2() throws ServletException, IOException {
    request.addParameter("flag", "2");
    servlet.doPost(request, response);
    assertEquals(null, request.getContentType());
  }

}
