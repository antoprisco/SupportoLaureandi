package controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import interfacce.UserInterface;
import model.Student;
import model.RequestLM;
import model.RequestlmDAO;

/**
 * Servlet implementation class ServletFormLM
 */
@WebServlet("/ServletFormLM")
public class ServletFormLM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFormLM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    Integer result = 0;
	    String error = "";
	    String content = "";
	    String redirect = "";
		
		UserInterface user = (UserInterface) request.getSession().getAttribute("user");
	    String idUser = user.getEmail();
	      
	    
	     	if(Integer.parseInt(request.getParameter("flag"))==6) {
	     		
	     		if(!(request.getParameter("curriculum").length()>0))
	     			throw new IllegalArgumentException("Curriculum non selezionato");

	     		if(!(request.getParameter("anno").length()>0))
	     			throw new IllegalArgumentException("Anno non selezionato");
	     		
	     		RequestLM r= new RequestLM(request.getParameter("curriculum"),Integer.parseInt(request.getParameter("anno")),idUser); 
	     		
	     		
	     		
	     		
	     		try {
	    		RequestlmDAO rd= new RequestlmDAO();
	    		
	    		if(!rd.doRetrieveByUser(idUser)) {
		    		int idRequest=rd.doSave(r);
				    if(idRequest>0) {
				    	content = "Richiesta effettuata correttamente.";
				    	result=1;
				    }else
				    	error = "Richiesta non effettuata errore salvataggio";
				    redirect = request.getContextPath() + "/_areaStudent/viewRequest.jsp";
	    		}else {
		    		int idRequest=rd.doUpdate(r);
				    if(idRequest>0) {
				    	content = "Richiesta modificata correttamente.";
				    	result=1;
				    }else
				    	error = "Richiesta non modificata errore salvataggio";
				    redirect = request.getContextPath() + "/_areaStudent/viewRequest.jsp";
	    		}

			    
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				error = e.getMessage();
			}
	    }
	    
	    JSONObject res = new JSONObject();
	    res.put("result", result);
	    res.put("error", error);
	    res.put("content", content);
	    res.put("redirect", redirect);
	    PrintWriter out = response.getWriter();
	    out.println(res);
	    response.setContentType("json");
	    System.err.println(res.toString());
	}      
}
	


