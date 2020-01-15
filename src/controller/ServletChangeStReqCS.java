package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.GestisceCS;
import model.GestisceCSDAO;
import model.RequestCSDAO;
import org.json.simple.JSONObject;

/**
 * Contente di cambiare lo stato di una richiesta CS
 */
@WebServlet("/ServletChangeStReqCS")
public class ServletChangeStReqCS extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   * 
   * @see HttpServlet#HttpServlet()
   */
  public ServletChangeStReqCS() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * Method doGet().
   * 
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  /**
   * Method doPost().
   * 
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Integer result = 0;
    String error = "";
    String content = "";
    String redirect = "";

    int id = Integer.parseInt(request.getParameter("idreq"));
    int statePrev = Integer.parseInt(request.getParameter("stato"));
    int op = Integer.parseInt(request.getParameter("op"));
    RequestCSDAO rdao = new RequestCSDAO();
    GestisceCSDAO gcsdao = new GestisceCSDAO();
    GestisceCS gcs = new GestisceCS();
    String email = "";
    try {
      gcs = gcsdao.doRetrieveByReq(id);
      email = gcs.getEmail();
    } catch (Exception e) {
      error = "Errore";
      result = 0;
      e.printStackTrace();
    }

    int state = 3;
    if (statePrev == 3) {
      if (op == 1) {
        Mailer.send("sl.unisa2020@gmail.com", "supportolaureandi2020", email,
            "Aggiornamento stato richiesta",
            "Gentile studente,\nla informiamo che lo stato della sua richiesta è : "
            + "accettata e in valutazione da parte del Consiglio Didattico.\n\n\n  "
            + "Supporto Laureandi");
        state = 4;
      } else {
        Mailer.send("sl.unisa2020@gmail.com", "supportolaureandi2020", email,
            "Aggiornamento stato richiesta",
            "Gentile studente,\nla informiamo che lo stato della sua richiesta è : "
            + "rifiutata e in valutazione da parte del Consiglio Didattico.\n\n\n  "
            + "Supporto Laureandi");
        state = 5;
      }
    } else if (statePrev == 4 || statePrev == 5) {
      if (op == 1) {
        Mailer.send("sl.unisa2020@gmail.com", "supportolaureandi2020", email,
            "Aggiornamento stato richiesta",
            "Gentile studente,\nla informiamo che lo stato della sua richiesta è: "
            + "accettata e completata.\n\n\n  Supporto Laureandi");
        state = 6;
      } else {
        Mailer.send("sl.unisa2020@gmail.com", "supportolaureandi2020", email,
            "Aggiornamento stato richiesta",
            "Gentile studente,\nla informiamo che lo stato della sua richiesta è : "
            + "rifiutata e completata.\n\n\n  Supporto Laureandi");
        state = 7;
      }
    }

    try {
      rdao.doChangeState(state, id);
      content = "Stato richiesta modificato";
      result = 1;
    } catch (Exception e) {
      error = "Errore";
      result = 0;
      e.printStackTrace();
    }

    JSONObject res = new JSONObject();
    res.put("redirect", redirect);
    res.put("result", result);
    res.put("error", error);
    res.put("content", content);
    PrintWriter out = response.getWriter();
    out.println(res);
    response.setContentType("json");
  }
}
