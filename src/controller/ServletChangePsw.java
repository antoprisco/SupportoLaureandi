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

import org.json.simple.JSONObject;

import interfacce.UserInterface;
import model.UserBean;
import model.UserBeanDAO;

/**
 * Consente di modificare la password
 */
@WebServlet("/ServletChangePsw")
public class ServletChangePsw extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   * 
   * @see HttpServlet#HttpServlet()
   */
  public ServletChangePsw() {
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
    // TODO Auto-generated method stub
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
    // TODO Auto-generated method stub

    Integer result = 0;
    String error = "";
    String content = "";
    String redirect = "";

    UserInterface userSession = (UserInterface) request.getSession().getAttribute("user");
    UserBeanDAO ud = new UserBeanDAO();
    try {
      UserBean user = ud.doRetrieveByEmail(userSession.getEmail());
      String newpass = request.getParameter("password");
      
      String password = new Utils().generatePwd(newpass);
      int x = ud.doSetPassword(userSession.getEmail(), password);
      if (x == 1) {
        content = "Password modificata correttamente";

      } else {
        content = "Impossibile modificare passowrd";
      }

    } catch (SQLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
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
