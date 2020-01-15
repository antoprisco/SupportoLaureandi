package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserBeanDAO;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class ServletChangeData.
 */
@WebServlet("/ServletResetEmail")
public class ServletResetEmail extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   * 
   * @see HttpServlet#HttpServlet()
   */
  public ServletResetEmail() {
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

    UserBeanDAO user = new UserBeanDAO();
    String newpass = new String("");
    Random r = new Random();
    for (int i = 0; i < 8; i++) {
      newpass += r.nextInt(10);
    }
    String password = new Utils().generatePwd(newpass);

    String email = request.getParameter("email");
    System.out.println("questa ï¿½ l'email passata alla servlet");
    System.out.println(email);
    System.out.println("questa ï¿½ la password generata non criptata");
    System.out.println(newpass);
    System.out.println("questa ï¿½ la password generata criptata");
    System.out.println(password);
    try {
      int x = user.doSetPassword(email, password);
      if (x == 1) {
        Mailer.send("sl.unisa2020@gmail.com", "supportolaureandi2020",
            email, "Reset Password Supporto Laureandi",
            "Ciao la tua nuova password è : " + newpass + "\n\n\n Il Team di Supporto Laureandi");
        content = "Inviata nuova password con successo all'email : " + email;

      } else {
        content = "Non esiste nessun account con questa email";
      }
    } catch (SQLException e) {
      error = "Errore nel salvataggio della modifica";
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