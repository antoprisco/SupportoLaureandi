package controller;

import interfacce.UserInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RequestLM;
import model.RequestlmDAO;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class ServletFormLM.
 */
@WebServlet("/ServletFormLM")
public class ServletFormLM extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * Constructor.
   * 
   * @see HttpServlet#HttpServlet()
   */
  public ServletFormLM() {
    super();
  }

  /**
   * Method doGet().
   * 
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
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
    String idUser = user.getEmail();
    if (Integer.parseInt(request.getParameter("flag")) == 6) {
      if (!(request.getParameter("curriculum").length() > 0)) {
    //    throw new IllegalArgumentException("Curriculum non selezionato");
      }
      if (!(request.getParameter("anno").length() > 0)) {
   //     throw new IllegalArgumentException("Anno non selezionato");
      }
      RequestLM r = new RequestLM(request.getParameter("curriculum"),
          Integer.parseInt(request.getParameter("anno")),idUser); 
      
      try {
        RequestlmDAO rd = new RequestlmDAO();
        if (!rd.doRetrieveByUser(idUser)) {
          int idRequest = rd.doSave(r);
          if (idRequest > 0) {
            content = "Richiesta effettuata correttamente.";
            result = 1;
          } else {
            error = "Richiesta non effettuata errore salvataggio";
          }
        } else {
          int idRequest = rd.doUpdate(r);
          if (idRequest > 0) {
            content = "Richiesta modificata correttamente.";
            result = 1;
          } else {
            error = "Richiesta non modificata errore salvataggio";
          }
        }
      } catch (SQLException e) {
        e.printStackTrace();
        error = e.getMessage();
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