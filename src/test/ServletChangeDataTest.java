package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.ServletChangeData;

class ServletChangeDataTest {

	  private ServletChangeData servlet;
	  private HttpSession session;
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;
	
	@Before
	  public void setUp() {
	    servlet = new ServletChangeData();
	    request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	    session = request.getSession();
	  }
	
	@Test
	public void test1() throws ServletException, IOException {
		request.addParameter("newName", "Giovanni");
		request.addParameter("id", "5");
		request.addParameter("flag", "1");
		servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
	}
}
