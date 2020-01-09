package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.RequestCS;
import model.RequestCSDAO;
import model.RequestOUDAO;
import model.Stato;
import model.StatoDAO;

/**
 * Servlet implementation class ServletViewReqCS
 */
@WebServlet("/ServletViewReqCS")
public class ServletViewReqCSA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletViewReqCSA() {
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

	    ArrayList<String> listaNomi = new ArrayList<String>();
	    ArrayList<String> listaCognomi = new ArrayList<String>();
	    ArrayList<Stato> listaStati = new ArrayList<Stato>();
	    ArrayList<RequestCS> listaRichieste = new ArrayList<RequestCS>();
	    RequestCSDAO rDAO = new RequestCSDAO();
	    StatoDAO sDAO = new StatoDAO();
	    if (Integer.parseInt(request.getParameter("flag")) == 1) {
			try {
				listaRichieste = rDAO.doRetrieveAdmin();
				result = 1;

				if (!listaRichieste.isEmpty() ) {
					for (RequestCS r : listaRichieste) {
						listaNomi.add(r.getNome());
						listaCognomi.add(r.getCognome());
						listaStati.add(sDAO.doRetrieveById(r.getStato()));
						content = "";
					}
				}
			} catch (Exception e) {
				error = "Errore nel database";
				e.printStackTrace();
			} 

		}
		JSONObject res= new JSONObject();
	   	res.put("result", result);
	    res.put("error", error);
	    res.put("content", content);
	    res.put("redirect", redirect);
	    res.put("nome", listaNomi);
	    res.put("cognome",listaCognomi);
	    PrintWriter out = response.getWriter();
	    out.println(res);
	    response.setContentType("json");
	    System.err.println(res.toString());
	}

}
