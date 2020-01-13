package test;

import static org.junit.jupiter.api.Assertions.*;

import controller.ServletViewReqCS;
import controller.ServletViewReqCSA;
import java.io.IOException;
import javax.servlet.ServletException;
import model.RequestCS;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

class ServletViewReqCSATest {

  private ServletViewReqCSA servlet; 
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() throws Exception {
    servlet = new ServletViewReqCSA();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  void test() throws ServletException, IOException {
    request.addParameter("flag", "1");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }

  @Test
  void test2() throws ServletException, IOException {
    request.addParameter("flag", "2");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
}
