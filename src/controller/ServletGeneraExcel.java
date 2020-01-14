package controller;

import interfacce.UserInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RequestCS;
import model.RequestCSDAO;
import model.SystemAttribute;

/**
 * La servlet si occupa di generale un file excel da parte dell'admin. 
 * Servlet implementation class ServletGeneraExcel.
 */
@WebServlet("/ServletGeneraExcel")
public class ServletGeneraExcel extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Costruttore. 
   * 
   * @see HttpServlet#HttpServlet()
   */
  public ServletGeneraExcel() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * Metodo doPost.
   * 
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  /**
   * Metodo doGet.
   * 
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int flag = Integer.parseInt(request.getParameter("flag"));

    UserInterface user = (UserInterface) request.getSession().getAttribute("user");
    RequestCSDAO rdao = new RequestCSDAO();
    ArrayList<RequestCS> listaRichieste = new ArrayList<RequestCS>();

    if (flag == 5 || flag == 6) { // Genera Excel
      PrintWriter out = response.getWriter();
      String content = "";
      Statement stmtSelect = null;
      String sql = "";
      Connection conn = new DbConnection().getInstance().getConn();

      if (user.getUserType() == 2) {
        if (conn != null) {

          if (flag == 5) { // Richieste Accettate
            Integer requestWorkingEducationAdvice1 = Integer.parseInt(
                new SystemAttribute().getValueByKey("request-working-educational-advice-1"));

            try {
              listaRichieste = rdao.doRetrieveAccettate();

              if (!listaRichieste.isEmpty()) {
                content += "ID\tNome\tCognome\n";
                for (RequestCS r : listaRichieste) {

                  content += r.getId() + "\t";
                  content += r.getNome() + "\t";
                  content += r.getCognome() + "\t";
                  content += "\n";
                }

              }
            } catch (Exception e) {
              content = e.getMessage();
            }
            response.setHeader("Content-Disposition",
                "attachment;filename=Richieste_Accettate.xls");
          } else if (flag == 6) { // Richieste Rifiutate
            Integer requestWorkingEducationAdvice1 = Integer.parseInt(
                new SystemAttribute().getValueByKey("request-working-educational-advice-1"));

            try {
              listaRichieste = rdao.doRetrieveRifiutate();

              if (!listaRichieste.isEmpty()) {
                content += "ID\tNome\tCognome\n";
                for (RequestCS r : listaRichieste) {

                  content += r.getId() + "\t";
                  content += r.getNome() + "\t";
                  content += r.getCognome() + "\t";
                  content += "\n";
                }

              }
            } catch (Exception e) {
              content = e.getMessage();
            }
            response.setHeader("Content-Disposition",
                "attachment;filename=Richieste_Rifiutate.xls");
          }

          out.println(content);
          response.setContentType("application/vnd.ms-excel");
        } else {
          out.println("Errore connessione al DB");
        }
      } else {
        out.println("Non si dispone dell'autorizzazione per l'utilizzo di questa funzionalita'.");
      }
    } else {
      doPost(request, response);
    }
  }

}
