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

import interfacce.UserInterface;
import model.*;
import java.sql.SQLException;

/**
 * Servlet implementation class ServletViewReqOU
 */
@WebServlet("/ServletViewRequestCSStudent")
public class ServletViewRequestCSStudent extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletViewRequestCSStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer result = 0;
	    String error = "";
	    String content = "";
	    String redirect = "";
	    ArrayList<Integer> id=new ArrayList<Integer>();
	    ArrayList<String> nome=new ArrayList<String>();
	    ArrayList<String> cognome= new ArrayList<String>();
	    ArrayList<Integer> stato=new ArrayList<Integer>();
	    
	    UserInterface user = (UserInterface) request.getSession().getAttribute("user");
	    String idUser = user.getEmail();
	    
	   	if(Integer.parseInt(request.getParameter("flag"))==1) {
	   		
	   		RequestCS r= new RequestCS();
			RequestCSDAO rd= new RequestCSDAO();
			ArrayList<RequestCS> list= new ArrayList<RequestCS>();
		try{
			list=rd.doRetrieveByNC(user.getName(), user.getSurname());
			if(!list.isEmpty()) {
				result=1;
				for(RequestCS rq:list) {
					id.add(rq.getId());
					nome.add(rq.getNome());
					cognome.add(rq.getCognome());
					stato.add(rq.getStato());
					
					Stato s= new Stato();
					StatoDAO sd= new StatoDAO();
					s=sd.doRetrieveById(rq.getStato());
					
					
					
					content+= "<tr>";
						content+="<td>"+rq.getId()+"</td>";
						content+="<td>"+rq.getNome()+"</td>";
						content+="<td>"+rq.getCognome()+"</td>";
						content+="<td>"+s.getDescr()+"</td>";
					content+="</tr>";
				}
				
			}
			
			
		
			
	}catch(SQLException e) {
		// TODO Auto-generated catch block
		error="errore database";
		e.printStackTrace();
	}

}
	   	JSONObject res= new JSONObject();
	   	res.put("result", result);
	    res.put("error", error);
	    res.put("content", content);
	    res.put("redirect", redirect);
	    res.put("id",id);
	    res.put("nome", nome);
	    res.put("cognome",cognome);
	    res.put("stato",stato);
	    PrintWriter out = response.getWriter();
	    out.println(res);
	    response.setContentType("json");
	    System.err.println(res.toString());
	}
}