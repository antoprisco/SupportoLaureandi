package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.ServletInoltra;

class ServletInoltraTest {
	
	  private ServletInoltra servlet; 
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;

	@BeforeEach
	void setUp() throws Exception {
		servlet = new ServletInoltra();
		request = new MockHttpServletRequest();
	    response = new MockHttpServletResponse();
	}

	@Test
	void test1() throws ServletException, IOException {
		request.addParameter("id", "9");
		servlet.doPost(request, response);
	    assertEquals("json", response.getContentType());
	}

}
