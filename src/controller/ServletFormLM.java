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

import interfacce.UserInterface;
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
		
		
		PrintWriter pw= response.getWriter();
		pw.append("ccc");
		UserInterface user = (UserInterface) request.getSession().getAttribute("user");
	    String idUser = user.getEmail();
	      
	    
	     	if(Integer.parseInt(request.getParameter("flag"))==6) {
	     		RequestLM r= new RequestLM(request.getParameter("curriculum"),Integer.parseInt(request.getParameter("anno")),idUser); 
	    	
	     		try {
	    		RequestlmDAO rd= new RequestlmDAO();
	    		rd.doSave(r);
	    		RequestDispatcher red=request.getRequestDispatcher("FormLM.jsp");
			    red.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
	    	
	 
	   
		
	
	      
	}
	


