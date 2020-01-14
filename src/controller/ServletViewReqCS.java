package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import model.Allegati;
import model.AllegatiDAO;
import model.GestisceCS;
import model.GestisceCSDAO;
import model.RequestCS;
import model.RequestCSDAO;
import model.RequestOUDAO;
import model.Stato;
import model.StatoDAO;

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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer result = 0;
	    String error = "";
	    String content = "";
	    String redirect = "";
	    
	    int flag = Integer.parseInt(request.getParameter("flag"));

	    ArrayList<String> listaNomi = new ArrayList<String>();
	    ArrayList<String> listaCognomi = new ArrayList<String>();
	    
	    ArrayList<RequestCS> listaRichieste = new ArrayList<RequestCS>();
	    RequestCSDAO rDAO = new RequestCSDAO();
	    StatoDAO sDAO = new StatoDAO();
	    ArrayList<Allegati> allegati = new ArrayList<Allegati>();
	    GestisceCS gCS = new GestisceCS();
	    GestisceCSDAO gcsDAO= new GestisceCSDAO();
	    AllegatiDAO allegatoDAO= new AllegatiDAO();

	    if (flag == 1) {
			try {
				listaRichieste = rDAO.doRetrieveAllSecretary(flag);
				result = 1;

				if (!listaRichieste.isEmpty()) {
					for (RequestCS r : listaRichieste) {
						
							listaNomi.add(r.getNome());
							listaCognomi.add(r.getCognome());
							gCS = gcsDAO.doRetrieveByReq(r.getId());
							allegati = allegatoDAO.doRetrievebyReq(gCS.getEmail(), gCS.getId());
	
							content += "<tr>";
							content += "<td align='center'><button  id='idr'>" + r.getId() + "</button>";
							content +="</td>";
							content += " <td align='center'> <button class='changeName' data-idr='"+ r.getId() + "' data-name='"+ r.getNome()
			                        + "' title='Modifica Nome'>"+r.getNome();
							content +="</td>";
							content += " <td align='center'> <button class='changeSurname' data-idr='"+ r.getId() + "'  data-surname='" + r.getCognome()
			                        + "' title='Modifica Cognome'>"+r.getCognome();
							content +="</td>";
							content += "<td align='center'>";
							content	+= "\"<a href='" + request.getContextPath() + "/DownloaderSL?filename="  
									+ allegati.get(0).getFilename() + "&idRequest=" + allegati.get(0).getIdReq() + "&email="+gCS.getEmail()+"'>" 
									+ allegati.get(0).getFilename() + "</a> - ";
							content	+= "\"<a href='" + request.getContextPath() + "/DownloaderSL?filename="  
									+ allegati.get(1).getFilename() + "&idRequest=" + allegati.get(1).getIdReq() + "&email="+gCS.getEmail()+"'>" 
									+ allegati.get(1).getFilename() + "</a>";
							content += "</td>";
				            content += "<td class='text-center'> <button class=\"btn btn-primary btn-action toAdmin"
				                    + "\" title=\"Inoltra all'admin\" data-idr='"+ r.getId()
				                    + "' style='background-color: #149414; border-color: #149414;' "
				                    + "><i class=\"fa fa-check\"></i></button>";
							content +="</td>";
							content +="</tr>";
						
					}
				}
				else {
					content += "Nessuna richiesta da elaborare";
				}
			} catch (Exception e) {
				error = "Errore nel database";
				e.printStackTrace();
			} 
		
		} else if(flag == 2) {	// Altrimenti inserisci storico richieste
			try {
				listaRichieste = rDAO.doRetrieveAllSecretary(flag);
				result = 1;
				if (!listaRichieste.isEmpty()) {
					for (RequestCS r : listaRichieste) {

							listaNomi.add(r.getNome());
							listaCognomi.add(r.getCognome());
							Stato s = new Stato();
							s = sDAO.doRetrieveById(r.getStato());
							gCS = gcsDAO.doRetrieveByReq(r.getId());
							allegati = allegatoDAO.doRetrievebyReq(gCS.getEmail(), gCS.getId());
	
							content += "<tr>";
							content += "<td align='center'>" + r.getId();
							content +="</td>";
							content += " <td align='center'>" +r.getNome();
							content +="</td>";
							content += " <td align='center'>" +r.getCognome();
							content +="</td>";
							content += "<td align='center'>";
							content	+= "\"<a href='" + request.getContextPath() + "/DownloaderSL?filename="  
									+ allegati.get(0).getFilename() + "&idRequest=" + allegati.get(0).getIdReq() + "&email="+gCS.getEmail()+"'>" 
									+ allegati.get(0).getFilename() + "</a> - ";
							content	+= "\"<a href='" + request.getContextPath() + "/DownloaderSL?filename="  
									+ allegati.get(1).getFilename() + "&idRequest=" + allegati.get(1).getIdReq() + "&email="+gCS.getEmail()+"'>" 
									+ allegati.get(1).getFilename() + "</a>";
							content += "</td>";
				            content += "<td>" + s.getDescr();
							content +="</td>";
							content +="</tr>";
					}
				}
				else {
					error += "Nessuna richiesta passata";
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
