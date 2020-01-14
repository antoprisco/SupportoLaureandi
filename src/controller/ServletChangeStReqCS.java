package controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.GestisceCS;
import model.GestisceCSDAO;
import model.RequestCSDAO;

/**
 * Servlet implementation class ServletInoltra
 */
@WebServlet("/ServletChangeStReqCS")
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
		
		int id = Integer.parseInt(request.getParameter("idreq"));
		int state_prev = Integer.parseInt(request.getParameter("stato"));
		int op = Integer.parseInt(request.getParameter("op"));
		RequestCSDAO rDAO = new RequestCSDAO();
	    GestisceCSDAO gcsdao= new GestisceCSDAO();
	    GestisceCS GCS = new GestisceCS();
	    String email= "";
	    try {
	    	GCS = gcsdao.doRetrieveByReq(id);
	    	email= GCS.getEmail();
	    } catch (Exception e) {
			error = "Errore";
			result = 0;
			e.printStackTrace();
		}

		int state = 3;
		if(state_prev==3) {
			if(op==1) {
				Mailer.send("sl.unisa2020@gmail.com","supportolaureandi2020",email,"Aggiornamento stato richiesta","Gentile studente,\nla informiamo che lo stato della sua richiesta è : accettata e in valutazione da parte del Consiglio Didattico.\n\n\n  Supporto Laureandi"); 
				state=4;
			}else { 
				Mailer.send("sl.unisa2020@gmail.com","supportolaureandi2020",email,"Aggiornamento stato richiesta","Gentile studente,\nla informiamo che lo stato della sua richiesta è : rifiutata e in valutazione da parte del Consiglio Didattico.\n\n\n  Supporto Laureandi");  
				state = 5;
			}
		} else if (state_prev==4 || state_prev==5) {
			if(op==1) {
				Mailer.send("sl.unisa2020@gmail.com","supportolaureandi2020",email,"Aggiornamento stato richiesta","Gentile studente,\nla informiamo che lo stato della sua richiesta è : accettata e completata.\n\n\n  Supporto Laureandi"); 
				state= 6;
			}else { 
				Mailer.send("sl.unisa2020@gmail.com","supportolaureandi2020",email,"Aggiornamento stato richiesta","Gentile studente,\nla informiamo che lo stato della sua richiesta è : rifiutata e completata.\n\n\n  Supporto Laureandi"); 
				state = 7;
			}
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
