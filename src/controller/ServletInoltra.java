package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.RequestCSDAO;

/**
 * Servlet implementation class ServletInoltra
 */
@WebServlet("/ServletInoltra")
public class ServletInoltra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInoltra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer result = 0;
		String error = "";
		String content = "";
		String redirect = "";
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		RequestCSDAO rDAO = new RequestCSDAO();
		
		try {
			rDAO.doInoltraToAdmin(id);
			content = "Richiesta inoltrata all'admin!";
			result = 1;
		} catch (Exception e) {
			error = "Errore";
			result = 0;
			e.printStackTrace();
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
