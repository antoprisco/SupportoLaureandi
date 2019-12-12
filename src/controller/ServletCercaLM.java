package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.err.println("ciaoooo");
		
		if(Integer.parseInt(request.getParameter("flag"))==7){
			System.err.println("ciaoooo2");
			request.setAttribute("denied", true);
			System.err.println("ciaoooo3");
			RequestlmDAO rd= new RequestlmDAO();
			System.err.println("ciaoooo4");
			ArrayList<RequestLM> list= new ArrayList<RequestLM>();
			System.err.println("ciaoooo5");
			try {
				
				list= rd.doRetrieveByYear(Integer.parseInt(request.getParameter("anno")));	
				System.err.println("ciaoooo6");
				request.setAttribute("list", list);
				System.err.println("ciaoooo7");
					
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
