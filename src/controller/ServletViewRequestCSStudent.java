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
import model.RequestCS;
import model.RequestCSDAO;
import model.Stato;
import model.StatoDAO;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class ServletViewRequestCSStudent.
 */
@WebServlet("/ServletViewRequestCSStudent")
public class ServletViewRequestCSStudent extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * Constructor.
   * 
   * @see HttpServlet#HttpServlet()
   */
  public ServletViewRequestCSStudent() {
    super();
  }

  /**
   * Method doGet().
   * 
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doPost(request,response);
  }

  /**
   * Method doPost().
   *
   *  @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    Integer result = 0;
    String error = "";
    String content = "";
    String redirect = "";
    ArrayList<Integer> id = new ArrayList<Integer>();
    ArrayList<String> nome = new ArrayList<String>();
    ArrayList<String> cognome = new ArrayList<String>();
    ArrayList<Integer> stato = new ArrayList<Integer>();
    UserInterface user = (UserInterface) request.getSession().getAttribute("user");
    if (Integer.parseInt(request.getParameter("flag")) == 1) {
      RequestCS r = new RequestCS();
      RequestCSDAO rd = new RequestCSDAO();
      ArrayList<RequestCS> list = new ArrayList<RequestCS>();
      try {
        list = rd.doRetrieveByR(user.getEmail());
        if (!list.isEmpty()) {
          result = 1;
          for (RequestCS rq:list) {
            id.add(rq.getId());
            nome.add(rq.getNome());
            cognome.add(rq.getCognome());
            stato.add(rq.getStato());
            
            Stato s = new Stato();
            StatoDAO sd = new StatoDAO();
            s = sd.doRetrieveById(rq.getStato());
            content += "<tr>";
            content += "<td>" + rq.getId() + "</td>";
            content += "<td>" + rq.getNome() + "</td>";
            content += "<td>" + rq.getCognome() + "</td>";
            content += "<td>" + s.getDescr() + "</td>";
            content += "</tr>";
          }
        }else {
          result=1;
          content += "<tr><td>Non ci sono richieste</td><td></td><td>"
              + "</td><td></td>";
        }
      } catch (SQLException e) {
        error = "errore database";
        e.printStackTrace();
      }
    }
    JSONObject res = new JSONObject();
    res.put("result", result);
    res.put("error", error);
    res.put("content", content);
    res.put("redirect", redirect);
    res.put("id",id);
    res.put("nome", nome);
    res.put("cognome",cognome);
    res.put("stato",stato);
    PrintWriter out = response.getWriter();
    out.println(res);
    response.setContentType("json");
    System.err.println(res.toString());
  }
}