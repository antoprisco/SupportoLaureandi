package controller;

import interfacce.UserInterface;
import java.io.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Allegati;
import model.AllegatiDAO;
import model.RequestCS;
import model.RequestCSDAO;
import model.SystemAttribute;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONObject;




/**
 * Servlet implementation class Uploader.
 */
@WebServlet("/UploaderCS")
public class UploaderCS extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private boolean isMultipart;
  private String filePath;
  private int maxFileSize = 50 * 102400;
  private int maxMemSize = 4 * 1024;
  @SuppressWarnings("unused")
  private File file;

  /**
   * constructor.
   * @see HttpServlet#HttpServlet()
   */
  public UploaderCS() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * method doGet.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  /**
   * method doPost.
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @SuppressWarnings({"unchecked", "unused", "rawtypes"})
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Integer result = 0;
    String error = "";
    String content = "";

    UserInterface user = (UserInterface) request.getSession().getAttribute("user");

    //getServletContext().getRealPath(path).
    RequestCS r = new RequestCS();
    RequestCSDAO rd = new RequestCSDAO();
    Allegati a = new Allegati();
    AllegatiDAO ad = new AllegatiDAO();
    ArrayList<Allegati> listaAllegati = new ArrayList<Allegati>();
    try {
      ArrayList<RequestCS> list = rd.doRetrieveByR(user.getEmail());
      if (!list.isEmpty()) {
        for (int j = 0; j < list.size(); j++) {
          r = list.get(j);
          if (r.getStato() == 1) {
            listaAllegati = ad.doRetrievebyReq(user.getEmail(),r.getId());
            
            //Modificare il path di filePath
            if (listaAllegati.isEmpty() || listaAllegati.size() < 2) {
              filePath = "C:\\Users\\Simone\\SupportoLaureandi\\UploadsCS\\" 
                + user.getEmail() + "\\";
              File file = new File(filePath);
              if (!file.exists()) {
                if (!file.mkdir()) {
                  result = 0;
                  error = "error Creazione Cartella per l'upload dei file";
                }
              }
              isMultipart = ServletFileUpload.isMultipartContent(request);
              response.setContentType("text/html");
              if (!isMultipart) {
                result = 0;
                error = "No file uploaded";
              }

              DiskFileItemFactory factory = new DiskFileItemFactory();
              factory.setSizeThreshold(maxMemSize);
              factory.setRepository(new File("c:\\temp"));
              ServletFileUpload upload = new ServletFileUpload(factory);
              upload.setSizeMax(maxFileSize);

              try {
                List fileItems = upload.parseRequest(request);
                Iterator i = fileItems.iterator();

                while (i.hasNext()) {
                  FileItem fi = (FileItem) i.next();
                  if (!fi.isFormField()) {
                    // Get the uploaded file parameters
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                    String fieldName = fi.getFieldName();
                    String fileName = timestamp.getTime() + "-" 
                        + fi.getName().replaceAll("\\s+", "");
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();
                    // Write the file
                    if (fileName.lastIndexOf("\\") >= 0) {
                      file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                      file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") 
                         + 1));
                    }
                    fi.write(file);
                    content += fileName;
                    // System.out.println(filePath + fileName);
                    result = 1;
                  }
                }
              } catch (Exception ex) {
                result = 0;
                error = ex.getMessage();
              }
            } else {
              error = "documenti già inseriti";
            }
          } else {
            error = "Spiacenti, non abbiamo trovato alcuna richiesta che attenda "
                + "l'upload dei file "; 
          }
        }
      } else {
        error = "Spiacenti, non vi e' alcuna richiesta";
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }


    JSONObject res = new JSONObject();
    res.put("result", result);
    res.put("error", error);
    res.put("content", content);
    PrintWriter out = response.getWriter();
    out.println(res);
  }

}
