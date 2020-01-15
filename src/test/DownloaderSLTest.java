package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import controller.DownloaderSL;
import controller.ServletCercaLM;
import interfacce.UserInterface;
import model.Student;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class DownloaderSLTest extends Mockito {
  private DownloaderSL servlet;
  private MockHttpServletRequest request;
  private MockHttpServletResponse response;

  /**
   * Before.
   */
  @Before
  public void setUp() {
    servlet = new DownloaderSL();
    request = new MockHttpServletRequest();
    response = new MockHttpServletResponse();
  }

  @Test
  public void test1() throws ServletException, IOException {
    request.addParameter("idRequest", "1");
    request.addParameter("filename", "1578684597403-IscrizioneRossi_Firmata.pdf");
    request.addParameter("email", "p.lentisco1@studenti.unisa.it");
    servlet.doPost(request, response);
    assertEquals(null, response.getContentType());
  }

}
