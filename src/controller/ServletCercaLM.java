package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.RequestLM;
import model.RequestlmDAO;

/**
 * Servlet implementation class ServletCercaLM
 */
@WebServlet("/ServletCercaLM")
public class ServletCercaLM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCercaLM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer result = 0;
	    String error = "";
	    String content = "";
	    String redirect = "";
	    ArrayList<String> curriculum = new ArrayList<String>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		if(Integer.parseInt(request.getParameter("flag"))==7){
			

				
			RequestlmDAO rd= new RequestlmDAO();
			ArrayList<RequestLM> list= new ArrayList<RequestLM>();
			try {
				list= rd.doCountByYear(Integer.parseInt(request.getParameter("anno")));	
				if(!list.isEmpty()) {
					result=1;
					for (RequestLM req : list) {
						curriculum.add(req.getCurr());
						count.add(req.getCount());
					}
				}
				
			} catch (SQLException e) {
				error= "errore database";
				e.printStackTrace();
			}
		}
		JSONObject res = new JSONObject();
		res.put("result", result);
	    res.put("error", error);
	    res.put("content", content);
	    res.put("redirect", redirect);
	    res.put("curriculum", curriculum);
	    res.put("count",count);
	    PrintWriter out = response.getWriter();
	    out.println(res);
	    response.setContentType("json");
	    System.err.println(res.toString());

	}

}
