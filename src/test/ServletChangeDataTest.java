package test;

import controller.ServletChangeData;
import controller.ServletFormOU;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;



class ServletChangeDataTest {
  private ServletChangeData servlet;
  private HttpSession session;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  @BeforeEach
  void setUp() throws Exception {
    servlet = new ServletChangeData();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
    session = request.getSession();
  }

  @Test
  public void test1() throws ServletException, IOException {
    request.addParameter("flag", "1");
    request.addParameter("newName", "Giovanni");
    request.addParameter("id", "5");
    servlet.doPost(request, response);
   // assertEquals("json", request.getContentType());
  }
	
  @Test
  public void test2() throws ServletException, IOException {
    request.addParameter("flag", "1");
    request.addParameter("newName", "Giovanni");
    request.addParameter("id", "512");
    servlet.doPost(request, response);
  //  assertEquals("json", request.getContentType());
  }

  @Test
  public void test3() throws ServletException, IOException {
    request.addParameter("flag", "2");
    request.addParameter("newSurname", "Musacchio");
    request.addParameter("id", "5");
    servlet.doPost(request, response);
   // assertEquals("json", request.getContentType());
  }

  @Test
  public void test4() throws ServletException, IOException {
    request.addParameter("flag", "3");
    request.addParameter("newName", "Giovanni");
    request.addParameter("id", "512");
    servlet.doPost(request, response);
   // assertEquals("json", request.getContentType());
  }


@Test
public void test5() throws ServletException, IOException {
  request.addParameter("flag", "2");
  request.addParameter("newSurname", "Musacchioooooooooooooo");
  request.addParameter("id", "5");
  assertThrows(IllegalArgumentException.class, ()-> servlet.doPost(request, response));
//  servlet.doPost(request, response);
//  assertEquals("json", request.getContentType());
}

@Test
public void test6() throws ServletException, IOException {
  request.addParameter("flag", "1");
  request.addParameter("newName", "Giovanniiiiiiiiiiiiiiiiiiiiiiii");
  request.addParameter("id", "512");
  assertThrows(IllegalArgumentException.class, ()-> servlet.doPost(request, response));
  //  servlet.doPost(request, response);
//  assertEquals("json", request.getContentType());
}
}