package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import controller.Downloader;
import controller.ServletCommon;

import java.io.IOException;
import javax.servlet.ServletException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class DownloaderTest {
  private Downloader servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;
  
  /**
   * Before.
   */
  @Before
  public void setUp() {
    servlet = new Downloader();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  public void testDoGet() throws ServletException, IOException {
    request.addParameter("idRequest", "1");
    request.addParameter("filename", "certificato.pdf");
    servlet.doGet(request, response);
  }
  
  @Test
  public void testDoPost() throws ServletException, IOException {
    request.addParameter("idRequest", "1");
    request.addParameter("filename", "certificato.pdf");
    servlet.doPost(request, response);
  }
}
