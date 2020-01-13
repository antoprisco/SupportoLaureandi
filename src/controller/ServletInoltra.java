package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RequestCSDAO;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class ServletInoltra.
 */
@WebServlet("/ServletInoltra")
public class ServletInoltra extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * Constructor.
   * 
   * @see HttpServlet#HttpServlet()
   */
  public ServletInoltra() {
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
   * Method doGet().
   * 
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    Integer result = 0;
    String error = "";
    String content = "";
    String redirect = "";

    Integer id = Integer.parseInt(request.getParameter("id"));
    RequestCSDAO dao = new RequestCSDAO();

    try {
      dao.doInoltraToAdmin(id);
      content = "Richiesta inoltrata all'admin!";
      redirect = request.getContextPath() + "/_areaSecretary/viewRequestCS.jsp";
      result = 1;
    } catch (Exception e) {
      error = "E' stato impossibile inoltrare la richiesta";
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
