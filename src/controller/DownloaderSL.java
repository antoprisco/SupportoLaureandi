package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Downloader.
 */
@WebServlet("/DownloaderSL")
public class DownloaderSL extends HttpServlet {
  private static final long serialVersionUID = 1L;
  @SuppressWarnings("unused")
  private File file;

  /**
   * constructor.
   * 
   * @see HttpServlet#HttpServlet()
   */
  public DownloaderSL() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * method doGet.
   * 
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    OutputStream outputStream = null;
    InputStream in = null;

    int idRequest = Integer.parseInt(request.getParameter("idRequest"));
    String filename = request.getParameter("filename");
    String email = request.getParameter("email");
    String basePath = "\\GitHub\\SupportoLaureandi\\UploadsCS\\"+email+"\\";
    //String basePath = request.getServletContext().getRealPath("\\UploadCS\\"+email);
    // questo metodo stampa C:\Users\DDA79LJ\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\EnglishValidation\UploadCS\ + l'email 

    try {
      in = new FileInputStream(basePath + filename);
      byte[] buffer = new byte[1024];
      int bytesRead = 0;
      response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");
      outputStream = response.getOutputStream();
      while (0 < (bytesRead = in.read(buffer))) {
        outputStream.write(buffer, 0, bytesRead);
      }
    } finally {
      if (null != in) {
        in.close();
      }
    }
  }

  /**
   * method doPost.
   * 
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @SuppressWarnings({"unchecked", "unused", "rawtypes"})
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
