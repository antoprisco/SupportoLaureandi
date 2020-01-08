package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.RequestCSDAO;

/**
 * Servlet implementation class ServletChangeData
 */
@WebServlet("/ServletChangeData")
public class ServletChangeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletChangeData() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Integer result = 0;
		String error = "";
		String content = "";
		String redirect = "";
		
		int id = Integer.parseInt(request.getParameter("id"));
		RequestCSDAO rDAO = new RequestCSDAO();
		
		if(Integer.parseInt(request.getParameter("flag")) == 1) {
			String nome = request.getParameter("nome");
			
			try {
				rDAO.doChangeName(nome, id);
				content = "Modifica avvenuta con successo!";
				result = 1;
			} catch (SQLException e) {
				error = "Errore nel salvataggio della modifica";
				e.printStackTrace();
			}
		} else if(Integer.parseInt(request.getParameter("flag")) == 2) {
			String cognome = request.getParameter("cognome");
			
			try {
				rDAO.doChangeSurname(cognome, id);
				content = "Modifica avvenuta con successo!";
				result = 1;
			} catch (Exception e) {
				error = "Errore nel salvataggio della modifica";
				e.printStackTrace();
			}
		} else {
			result = 0;
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
