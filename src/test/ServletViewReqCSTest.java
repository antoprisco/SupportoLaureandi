package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import controller.ServletInoltra;
import controller.ServletViewReqCS;

class ServletViewReqCSTest {
	
	  private ServletViewReqCS servlet; 
	  private MockHttpServletRequest request;
	  private MockHttpServletResponse response;

	@BeforeEach
	void setUp() throws Exception {
		servlet = new ServletViewReqCS();
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
