package controller;

import interfacce.UserInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Allegati;
import model.AllegatiDAO;
import model.RequestCS;
import model.RequestCSDAO;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class ServletUploadFiles.
 */
@WebServlet("/ServletUploadFiles")
public class ServletUploadFiles extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * Constructor.
   * 
   * @see HttpServlet#HttpServlet()
   */
  public ServletUploadFiles() {
    super();
  }

  /**
   * Method doGet().
   * 
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doPost(request, response);
  }

  /**
  * Method doPost().
  *
  *  @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    Integer result = 0;
    String error = "";
    String content = "";
    String redirect = "";
    UserInterface user = (UserInterface) request.getSession().getAttribute("user");
    if (Integer.parseInt(request.getParameter("flag")) == 3) {
      /*Verifica che esista la richiesta associata al nome e al congnome dell'utente 
       * e che lo stato sia 1
       */
      RequestCS r = new RequestCS();
      RequestCSDAO rd = new RequestCSDAO();
      Allegati a = new Allegati();
      AllegatiDAO ad = new AllegatiDAO();
      ArrayList<Allegati> listaAllegati = new ArrayList<Allegati>();
      
      try {
        ArrayList<RequestCS> list = rd.doRetrieveByR(user.getEmail());
        if (!list.isEmpty()) {
          for (int i = 0; i < list.size(); i++) {
            r = list.get(i);
            if (r.getStato() == 1) {
              //Se rispetta la condizione possiamo allegare i file
              String[] filenames = request.getParameterValues("filenames[]");
              if (filenames.length != 2 
                  || !filenames[0].endsWith(".pdf") 
                  || !filenames[1].endsWith(".pdf")) {
                throw new IllegalArgumentException("Valore non corretto");
              }
              for (int j = 0; j < filenames.length; j++) {
                a = new Allegati(filenames[j],user.getEmail(),r.getId());
                listaAllegati = ad.doRetrievebyReq(user.getEmail(),r.getId());
                if (listaAllegati.isEmpty() || listaAllegati.size() < 2) {
                  ad.doSave(a);
                  System.out.println(r.getId());
                  rd.doUpdate(2, r.getId());
                  System.out.println("dopo= " + r.getId());
                  result = 1;
                } else {
                  error = "documenti già inseriti";
                }
              }
              
              
            } else {
              error = "Spiacenti, non abbiamo trovato alcuna richiesta "
                 + "che attenda l'upload dei file "; 
            }
          }
        } else {
          error = "Spiacenti, non vi e' alcuna richiesta";
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    JSONObject res = new JSONObject();
    res.put("result", result);
    res.put("error", error);
    res.put("content", content);
    res.put("redirect", redirect);
    PrintWriter out = response.getWriter();
    out.println(res);
    response.setContentType("json");
    System.err.println(res.toString());
  }

}
