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

/**
 * Servlet implementation class ServletViewReqCS
 */
@WebServlet("/ServletViewReqCS")
public class ServletViewReqCS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletViewReqCS() {
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
	    
	    ArrayList<RequestCS> listaRichieste = new ArrayList<RequestCS>();
	    RequestCSDAO rDAO = new RequestCSDAO();

	    if (Integer.parseInt(request.getParameter("flag")) == 1) {
			try {
				listaRichieste = rDAO.doRetrieveAll();
				result = 1;

				if (!listaRichieste.isEmpty()) {
					for (RequestCS r : listaRichieste) {
						listaNomi.add(r.getNome());
						listaCognomi.add(r.getCognome());

						content += "<tr>";
						content += "<td align='center' class = 'id'><button  id='idR'>" + r.getId() + "</button>";
						content += "<td align='center'><button class='changeName' id='nome'>" + r.getNome() + "</button>";
						content += "<td align='center'><button  class ='changeSurname' id='cognome'>" + r.getCognome() + "</button>";
						content += "<td align='center'><input type='checkbox'>";
						content +="</td>";
						content +="</td>";
						content +="</td>";
						content +="</td>";
						content +="</tr>";
					}
				}
			} catch (Exception e) {
				error = "Errore nel database";
				e.printStackTrace();
			} 
		/*}else if (Integer.parseInt(request.getParameter("flag")) == 2) {
			try {
				RequestCS rn = new RequestCS();
				rn.setId(Integer.parseInt(request.getParameter("id")));
				rn.setNome(request.getParameter("nome"));
				rn.setCognome(request.getParameter("cognome"));
				
				rDAO.doUpdateNC(rn);
			}catch(Exception e) {
				error = "errore nel db";
				e.printStackTrace();
			}*/
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
