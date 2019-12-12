package controller;

import java.awt.Label;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Request;
import model.SystemAttribute;
import org.json.simple.JSONObject;
import interfacce.UserInterface;
import sun.util.calendar.LocalGregorianCalendar.Date;

/**
 * Servlet implementation class ServletAdmin.
 * 
 * @param <WritableWorkbook> parameter.
 */
@WebServlet("/ServletAdmin")
public class ServletAdmin<WritableWorkbook> extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Servlet implementation class ServletCommon.
   */
  public ServletAdmin() {
    super();

  }

  /**
   * Method doGet().
   * 
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int flag = Integer.parseInt(request.getParameter("flag"));

    UserInterface user = (UserInterface) request.getSession().getAttribute("user");

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
              stmtSelect = conn.createStatement();
              sql =
                  "SELECT r.id_request, r.serial, u.name, u.surname, r.year, r.certificate_serial, "
                      + "r.level, r.release_date, r.expiry_date, r.requested_cfu, "
                      + "r.validated_cfu, e.name AS ente " + "FROM request r "
                      + "     INNER JOIN ente e ON r.fk_certifier = e.id_ente "
                      + "     INNER JOIN state s ON r.fk_state = s.id_state "
                      + "     INNER JOIN user u ON r.fk_user = u.email " + "WHERE s.id_state = "
                      + requestWorkingEducationAdvice1 + ";";
              ResultSet r = stmtSelect.executeQuery(sql);
              if (r.wasNull()) {
                content = "Errore nell'esecuzione della Query";
              } else {
                int count = r.last() ? r.getRow() : 0;
                if (count > 0) {
                  r.beforeFirst();
                  content += "ID\tMatricola\tNome\tCognome\tA. A.\tCod. "
                      + "Cert.\tLiv. Cert\tData Ril.\tData Scad.\tCFU Ric.\tCFU Conv.\tEnte\n";
                  while (r.next()) {
                    content += r.getString("id_request") + "\t";
                    content += r.getString("serial") + "\t";
                    content += r.getString("name") + "\t";
                    content += r.getString("surname") + "\t";
                    content += r.getString("year") + "\t";
                    content += r.getString("certificate_serial") + "\t";
                    content += r.getString("level") + "\t";
                    content += r.getString("release_date") + "\t";
                    content += r.getString("expiry_date") + "\t";
                    content += r.getString("requested_cfu") + "\t";
                    content += r.getString("validated_cfu") + "\t";
                    content += r.getString("ente") + "\t";
                    content += "\n";
                  }
                }
              }
            } catch (Exception e) {
              content = e.getMessage();
            }
            response.setHeader("Content-Disposition",
                "attachment;filename=Richieste_Accettate.xls");
          } else if (flag == 6) { // Richieste Rifiutate
            Integer requestWorkingEducationAdvice2 = Integer.parseInt(
                new SystemAttribute().getValueByKey("request-working-educational-advice-2"));

            try {
              stmtSelect = conn.createStatement();
              sql =
                  "SELECT r.id_request, r.serial, u.name, u.surname, r.year, r.certificate_serial, "
                      + "r.level, r.release_date, r.expiry_date, r.requested_cfu, "
                      + "r.validated_cfu, e.name AS ente " + "FROM request r "
                      + "     INNER JOIN ente e ON r.fk_certifier = e.id_ente "
                      + "     INNER JOIN state s ON r.fk_state = s.id_state "
                      + "     INNER JOIN user u ON r.fk_user = u.email " + "WHERE s.id_state = "
                      + requestWorkingEducationAdvice2 + ";";
              ResultSet r = stmtSelect.executeQuery(sql);
              if (r.wasNull()) {
                content = "Errore nell'esecuzione della Query";
              } else {
                int count = r.last() ? r.getRow() : 0;
                if (count > 0) {
                  r.beforeFirst();
                  content += "ID\tMatricola\tNome\tCognome\tA. A.\tCod. "
                      + "Cert.\tLiv. Cert\tData Ril.\tData Scad.\tCFU Ric.\tCFU Conv.\tEnte\n";
                  while (r.next()) {
                    content += r.getString("id_request") + "\t";
                    content += r.getString("serial") + "\t";
                    content += r.getString("name") + "\t";
                    content += r.getString("surname") + "\t";
                    content += r.getString("year") + "\t";
                    content += r.getString("certificate_serial") + "\t";
                    content += r.getString("level") + "\t";
                    content += r.getString("release_date") + "\t";
                    content += r.getString("expiry_date") + "\t";
                    content += r.getString("requested_cfu") + "\t";
                    content += r.getString("validated_cfu") + "\t";
                    content += r.getString("ente") + "\t";
                    content += "\n";
                  }
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

  /**
   * Method doPost().
   * 
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Integer result = 0; // indica se la query è riuscita
    String error = ""; // indica il mex di errore
    String content = ""; // indica il contenuto trovato dopo la query
    String redirect = ""; // reindirizza di nuovo alla pagina in caso di errore

    PreparedStatement stmt = null;
    Statement stmtSelect = null;
    Statement stmtSelectTwo = null;

    int flag = Integer.parseInt(request.getParameter("flag"));
    Connection conn = new DbConnection().getInstance().getConn();
    String sql = "";

    if (conn != null) {
      Integer requestWorkingEducationAdvice1 = Integer
          .parseInt(new SystemAttribute().getValueByKey("request-working-educational-advice-1"));
      Integer requestWorkingEducationAdvice2 = Integer
          .parseInt(new SystemAttribute().getValueByKey("request-working-educational-advice-2"));
      Integer requestAccepted =
          Integer.parseInt(new SystemAttribute().getValueByKey("request-accepted"));
      Integer requestRefused =
          Integer.parseInt(new SystemAttribute().getValueByKey("request-refused"));

      if (flag == 1) { // Preleva tutte le richieste
        try {
          Integer requestWorkingAdmin =
              Integer.parseInt(new SystemAttribute().getValueByKey("request-working-admin"));

          stmtSelect = conn.createStatement();
          sql = "SELECT r.id_request, r.certificate_serial, r.level, r.release_date, "
              + "r.expiry_date, r.year, r.requested_cfu, r.serial, r.validated_cfu,"
              + " u.email AS user_email, u.name, u.surname, e.name AS state, e.email AS ente_mail, "
              + "e.site AS ente_site, s.description AS ente, s.id_state " + "FROM request r"
              + "     INNER JOIN ente e ON r.fk_certifier = e.id_ente "
              + "     INNER JOIN state s ON r.fk_state = s.id_state "
              + "     INNER JOIN user u ON r.fk_user = u.email " + "WHERE s.id_state IN("
              + requestWorkingAdmin + ", " + requestWorkingEducationAdvice1 + ", "
              + requestWorkingEducationAdvice2 + ", " + requestAccepted + ", " + requestRefused
              + ")";
          ResultSet r = stmtSelect.executeQuery(sql);
          if (r.wasNull()) {
            error = "Errore nell'esecuzione della Query";
          } else {
            int count = r.last() ? r.getRow() : 0;
            if (count > 0) {
              r.beforeFirst();
              SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
              String classe = "even";
              while (r.next()) {
                if (classe.equals("odd")) {
                  classe = "even";
                } else if (classe.equals("even")) {
                  classe = "odd";
                }

                content += "<tr class='" + classe + "' role='row'>";
                content += "    <td class='text-center'>" + r.getString("id_request") + "</td>";

                // for attached
                content += "    <td class='text-center'>";
                int idRequest = r.getInt("id_request");
                stmtSelectTwo = conn.createStatement();
                sql = "SELECT a.filename AS filename " + "FROM attached a "
                    + "WHERE a.fk_request = " + idRequest + ";";
                ResultSet r2 = stmtSelectTwo.executeQuery(sql);
                if (r2.wasNull()) {
                  result *= 0;
                  error = "Errore nell'esecuzione della Query degli Allegati";
                } else {
                  int countAttached = r2.last() ? r2.getRow() : 0;
                  int i = 1;
                  if (countAttached > 0) {
                    r2.beforeFirst();
                    while (r2.next()) {
                      if (i == countAttached) {
                        content += "<a href='" + request.getContextPath() + "/Downloader?filename="
                            + r2.getString("filename") + "&idRequest=" + idRequest + "'>"
                            + r2.getString("filename") + "</a>";
                      } else {
                        content += "<a href='" + request.getContextPath() + "/Downloader?filename="
                            + r2.getString("filename") + "&idRequest=" + idRequest + "'>"
                            + r2.getString("filename") + "</a>" + " - ";
                      }
                      i++;
                    }
                  }
                }
                content += "    </td>";

                content += "    <td class='text-center'>" + r.getString("serial") + "</td>";
                if (r.getInt("id_state") == requestWorkingAdmin) { // Se è in lavorazione dall'admin
                  content += "<td class='text-center'>" + r.getString("name");
                  content +=
                      "  <button class=\"btn btn-primary btn-action changeName\" data-iduser=\""
                          + r.getString("user_email") + "\" data-name=\"" + r.getString("name")
                          + "\" title=\"Modifica Nome\"><i class=\"fa fa-edit\"></i></button>";
                  content += "</td>";
                  content += "<td class='text-center'>" + r.getString("surname");
                  content +=
                      "  <button class=\"btn btn-primary btn-action changeSurname\" data-iduser=\""
                          + r.getString("user_email") + "\" data-surname=\""
                          + r.getString("surname")
                          + "\" title=\"Modifica Cognome\"><i class=\"fa fa-edit\"></i></button>";
                  content += "</td>";
                } else {
                  content += "    <td class='text-center'>" + r.getString("name") + "</td>";
                  content += "    <td class='text-center'>" + r.getString("surname") + "</td>";
                }

                content += "    <td class='text-center'>" + r.getInt("year") + "/"
                    + (r.getInt("year") + 1) + "</td>";
                content +=
                    "    <td class='text-center'>" + r.getString("certificate_serial") + "</td>";
                content += "    <td class='text-center'>" + r.getString("level") + "</td>";
                content += "    <td class='text-center'>" + sdf.format(r.getDate("release_date"))
                    + "</td>";
                content +=
                    "    <td class='text-center'>" + sdf.format(r.getDate("expiry_date")) + "</td>";
                content += "    <td class='text-center'>" + r.getString("requested_cfu") + "</td>";
                if (r.getInt("validated_cfu") == 0) {
                  content += "    <td class='text-center'>NC</td>";
                } else {
                  content += "    <td class='text-center'>" + r.getInt("validated_cfu") + "</td>";
                }

                content += "    <td class='text-center'>" + r.getString("state") + "</td>";
                content += "    <td class='text-center'>" + r.getString("ente") + "</td>";
                content += "    <td class='text-center'>";

                if (r.getInt("id_state") == requestWorkingAdmin) { // Se è in lavorazione dall'admin
                  if (!r.getString("ente_mail").equals("")) { // Se è settata la mail dell'ente
                    content += "<button class=\"btn btn-primary btn-action verifyCertificate"
                        + "\" title=\"Verifica Validit&agrave; "
                        + "Certificato Tramite Mail\" data-mail=\"" + r.getString("ente_mail")
                        + "\" data-certserial=\"" + r.getString("certificate_serial")
                        + "\"><i class=\"fa fa-question\"></i></button>";
                  } else if (!r.getString("ente_site").equals("")) {
                    // Se è settato il sito dell'ente
                    content += "<a target=\"_blank\" href=\"" + r.getString("ente_site")
                        + "\" class=\"btn btn-primary verifyCertificate"
                        + "\" title=\"Verifica Validit&agrave; Certificato Tramite Sito Web"
                        + "\"><i class=\"fa fa-question\"></i></a>";
                  }

                  // Mettere in requestWorkingEducationAdvice1
                  content +=
                      "<button class=\"btn btn-primary btn-action toWorkingEducationAdvice accept"
                          + "\" data-type=\"1\" data-idrequest=\"" + r.getInt("id_request")
                          + "\" title=\"Accetta e Inoltra al Consiglio Didattico"
                          + "\"><i class=\"fa fa-check\"></i></button>";

                  // oppure Mettere in requestWorkingEducationAdvice2
                  content +=
                      "<button class=\"btn btn-primary btn-action toWorkingEducationAdvice refuse"
                          + "\" data-type=\"2\" data-idrequest=\"" + r.getInt("id_request")
                          + "\" title=\"Rifiuta e Inoltra al Consiglio Didattico"
                          + "\"><i class=\"fa fa-times\"></i></button>";
                } else if (r.getInt("id_state") == requestWorkingEducationAdvice1
                    || r.getInt("id_state") == requestWorkingEducationAdvice2) {
                  // Se è in lavorazione da consiglio didattico

                  // Mettere in requestAccepted
                  content += "<button class=\"btn btn-primary btn-action toAccepted accept"
                      + "\" data-idrequest=\"" + r.getInt("id_request")
                      + "\" title=\"Accettata dal Consiglio Didattico"
                      + "\"><i class=\"fa fa-check\"></i></button>";

                  // oppure Mettere in requestRefused
                  content += "<button class=\"btn btn-primary btn-action toRefused refuse"
                      + "\" data-idrequest=\"" + r.getInt("id_request")
                      + "\" title=\"Rifiutata dal Consiglio Didattico"
                      + "\"><i class=\"fa fa-times\"></i></button>";
                } else if (r.getInt("id_state") == requestAccepted
                    || r.getInt("id_state") == requestRefused) { // Se è conclusa
                  content += "/";
                }
                content += "</td>";

                content += "</tr>";
              }
              result = 1;
            } else {
              result = 1;
              content = "<tr>" + "<td class=\"text-center\"" + "></td>"
                  + "<td class=\"text-center\"" + "></td>" + "<td class=\"text-center\"" + "></td>"
                  + "<td class=\"text-center\"" + "></td>" + "<td class=\"text-center\"" + "></td>"
                  + "<td class=\"text-center\"" + "></td>" + "<td class=\"text-center\"" + "></td>"
                  + "<td class=\"text-center\"" + "> Nessuna Richiesta Presente</td>"
                  + "<td class=\"text-center\"" + "></td>" + "<td class=\"text-center\"" + "></td>"
                  + "<td class=\"text-center\"" + "></td>" + "<td class=\"text-center\"" + "></td>"
                  + "<td class=\"text-center\"" + "></td>" + "<td class=\"text-center\"" + "></td>"
                  + "<td class=\"text-center\"" + "></td>" + "</tr>";
            }
          }
        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
      } else if (flag == 2) {
        Integer type = Integer.parseInt(request.getParameter("type"));
        Integer idRequest = Integer.parseInt(request.getParameter("idRequest"));
        if (type == 1) { // requestWorkingEducationAdvice1
          type = requestWorkingEducationAdvice1;
        } else if (type == 2) { // requestWorkingEducationAdvice2
          type = requestWorkingEducationAdvice2;
        }

        try {
          sql = " UPDATE request SET fk_state = ? WHERE id_request = ?; ";
          stmt = conn.prepareStatement(sql);
          stmt.setInt(1, type);
          stmt.setInt(2, idRequest);
          if (stmt.executeUpdate() > 0) {
            result = 1;
            content = "Richiesta aggiornata con successo.";
          } else {
            error += " Impossibile cambiare stato alla richiesta.";
            result = 0;
          }

          if (result == 0) {
            conn.rollback();
            result *= 0;
          } else {
            conn.commit();
          }

        } catch (Exception e) {
          error += e.getMessage();
          result *= 0;
        }

      } else if (flag == 3) { // Passaggio di stato a requestAccepted
        Integer idRequest = Integer.parseInt(request.getParameter("idRequest"));

        try {
          sql = " UPDATE request SET fk_state = ? WHERE id_request = ?; ";
          stmt = conn.prepareStatement(sql);
          stmt.setInt(1, requestAccepted);
          stmt.setInt(2, idRequest);
          if (stmt.executeUpdate() > 0) {
            result = 1;
            content = "Richiesta aggiornata con successo.";
          } else {
            error += " Impossibile cambiare stato alla richiesta.";
            result = 0;
          }

          if (result == 0) {
            conn.rollback();
            result *= 0;
          } else {
            conn.commit();
          }

        } catch (Exception e) {
          error += e.getMessage();
          result *= 0;
        }
      } else if (flag == 4) { // Passaggio di stato a requestRefused
        Integer idRequest = Integer.parseInt(request.getParameter("idRequest"));

        try {
          sql = " UPDATE request SET fk_state = ? WHERE id_request = ?; ";
          stmt = conn.prepareStatement(sql);
          stmt.setInt(1, requestRefused);
          stmt.setInt(2, idRequest);
          if (stmt.executeUpdate() > 0) {
            result = 1;
            content = "Richiesta aggiornata con successo.";
          } else {
            error += " Impossibile cambiare stato alla richiesta.";
            result = 0;
          }

          if (result == 0) {
            conn.rollback();
            result *= 0;
          } else {
            conn.commit();
          }

        } catch (Exception e) {
          error += e.getMessage();
          result *= 0;
        }
      }

    } else {
      error += "Nessuna connessione al database.";
    }

    JSONObject res = new JSONObject();
    res.put("result", result);
    res.put("error", error);
    res.put("content", content);
    res.put("redirect", redirect);
    PrintWriter out = response.getWriter();
    out.println(res);
    response.setContentType("json");

  }
}