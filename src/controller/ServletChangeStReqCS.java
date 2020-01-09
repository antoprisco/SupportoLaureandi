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
public class ServletChangeStReqCS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletChangeStReqCS() {
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
		int state_prev = Integer.parseInt(request.getParameter("state"));
		int op = Integer.parseInt(request.getParameter("op"));
		RequestCSDAO rDAO = new RequestCSDAO();
		int state = 3;
		if(state_prev==3) {
			if(op==1)
				state=4;
			else 
				state = 5;
		} else if (state_prev==4 || state_prev==5) {
			if(op==1)
				state= 6;
			else 
				state = 7;
		} 
		
		try {
			rDAO.doChangeState(state, id);
			content = "Stato richiesta modificato";
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
