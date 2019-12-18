package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import controller.ServletCercaLM;
import java.io.IOException;
import javax.servlet.ServletException;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class ServletCercaLMTest extends Mockito {
  private ServletCercaLM servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  /**
   * Before.
   */
  @Before
  public void setUp() {
    servlet = new ServletCercaLM();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }
  
  @Test
  public void test1() throws ServletException, IOException { //Anno presente nel DB
    request.addParameter("flag", "7");
    request.addParameter("anno", "2021");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
  @Test
  public void test2() throws ServletException, IOException { //Anno non presente nel DB
    request.addParameter("flag", "7");
    request.addParameter("anno", "2020");
    servlet.doPost(request, response);
    assertEquals("json", response.getContentType());
  }
  
}