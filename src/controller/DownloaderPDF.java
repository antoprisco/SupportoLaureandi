package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SystemAttribute;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONObject;

import interfacce.UserInterface;

/**
 * Servlet implementation class Downloader.
 */
@WebServlet("/DownloaderPDF")
public class DownloaderPDF extends HttpServlet {
  private static final long serialVersionUID = 1L;
  @SuppressWarnings("unused")
  private File file;

  /**
   * constructor.
   * 
   * @see HttpServlet#HttpServlet()
   */
  public DownloaderPDF() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * method doGet.
   * 
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    if (Integer.parseInt(request.getParameter("flag")) == 1) {
      UserInterface user = (UserInterface) request.getSession().getAttribute("user");
      OutputStream outputStream = null;
      InputStream in = null;

      Date d = new Date();
      
      //Modificare il path per il giusto download del pdf generato
      String basePath = "C:\\Users\\Simone\\Desktop\\eclipse"
      +"\\";
      String filename = "IscrizioneCS_" + user.getSurname() + d.getHours() + "" 
      + d.getMinutes() + ".pdf";

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
  }

  /**
   * method doPost.
   * 
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  @SuppressWarnings({ "unchecked", "unused", "rawtypes" })
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

}
