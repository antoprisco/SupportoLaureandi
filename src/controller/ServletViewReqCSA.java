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
@WebServlet("/ServletViewReqCSA")
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer result = 0;
	    String error = "";
	    String content = "";
	    String redirect = "";

	    ArrayList<String> listaNomi = new ArrayList<String>();
	    ArrayList<String> listaCognomi = new ArrayList<String>();
	    ArrayList<Stato> listaStati = new ArrayList<Stato>();
	    ArrayList<RequestCS> listaRichieste = new ArrayList<RequestCS>();
	    ArrayList<Allegati> allegati = new ArrayList<Allegati>();
	    GestisceCS gCS = new GestisceCS();
	    
	    RequestCSDAO rDAO = new RequestCSDAO();
	    StatoDAO sDAO = new StatoDAO();
	    GestisceCSDAO gcsDAO= new GestisceCSDAO();
	    AllegatiDAO allegatoDAO= new AllegatiDAO();
	   // String cognome= request.getParameter("cognome");
	    if (Integer.parseInt(request.getParameter("flag")) == 1) {
			try {
				listaRichieste = rDAO.doRetrieveAdmin();
				result = 1;

				if (!listaRichieste.isEmpty() ) {
					for (RequestCS r : listaRichieste) {
						listaNomi.add(r.getNome());
						listaCognomi.add(r.getCognome());
						listaStati.add(sDAO.doRetrieveById(r.getStato()));
						gCS = gcsDAO.doRetrieveByReq(r.getId());
						allegati = allegatoDAO.doRetrievebyReq(gCS.getEmail(), gCS.getId());
						content += "<tr>";
						content += "<td align='center' class = 'id' data-idreq = '"+r.getId()+"' ><p  id='idR'>"+r.getId()+ "</p></td>";
						content += "<td align='center'><button class='changeName' id='nome'>" + r.getNome() + "</button>";
						content += "<td align='center'><button  class ='changeSurname' id='cognome'>" + r.getCognome() + "</button>";
						content += "<td align='center'>";
						content	+= "\"<a href='" + request.getContextPath() + "/DownloaderSL?filename="  
								+ allegati.get(0).getFilename() + "&idRequest=" + allegati.get(0).getIdReq() + "&email="+gCS.getEmail()+"'>" 
								+ allegati.get(0).getFilename() + "</a> - ";
						content	+= "\"<a href='" + request.getContextPath() + "/DownloaderSL?filename="  
								+ allegati.get(1).getFilename() + "&idRequest=" + allegati.get(1).getIdReq() + "&email="+gCS.getEmail()+"'>" 
								+ allegati.get(1).getFilename() + "</a>";
						content += "</td>";
						
						if(r.getStato()==3) {
							content += "<td align='center'><p class=\"list-group-item-warning\">In attesa</p></td>";
						}else if(r.getStato()==4) {
							content += "<td align='center'><p class=\"list-group-item-success\">Approvata, revisione in consiglio</p></td>";
						}else if(r.getStato()==5) {
							content += "<td align='center'><p class=\"list-group-item-danger\">Rifiutata, revisione in consiglio</p></td>";
						}
						
						content += "<td align='center'>"+ 
									"<button type=\"button\" class=\"btn btn-default\" aria-label=\"Conferma\" data-idreq = '"+r.getId()+"' data-stato = '"+r.getStato()+"' id=\"checkConferma\">" + 
										"<span class=\"glyphicon glyphicon-ok\" aria-hidden=\"true\"></span>" + 
									"</button>" + 
								"</td>";
						content += "<td align='center'>"+ 
									"<button type=\"button\" class=\"btn btn-default\" aria-label=\"Rifiuta\" data-idreq = '"+r.getId()+"' data-stato = '"+r.getStato()+"'  id=\"checkRifiuta\">" + 
										"<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>" + 
									"</button>" + 
								"</td>";
						content +="</tr>";
					}
				}else {
				  content+="<tr><td>Non ci sono richieste</td><td></td><td></td><td></td><td></td><td></td><td></td></tr>";
				}
			} catch (Exception e) {
				error = "Errore nel database";
				e.printStackTrace();
			} 

		}
	    if(Integer.parseInt(request.getParameter("flag"))==2 && request.getParameter("cognome")!=null) {
	      System.out.println(request.getParameter("cognome"));
	      try {
            listaRichieste = rDAO.doRetrievebyC(request.getParameter("cognome"));
            result = 1;

            if (!listaRichieste.isEmpty() ) {
                for (RequestCS r : listaRichieste) {
                    listaNomi.add(r.getNome());
                    listaCognomi.add(r.getCognome());
                    listaStati.add(sDAO.doRetrieveById(r.getStato()));
                    gCS = gcsDAO.doRetrieveByReq(r.getId());
                    allegati = allegatoDAO.doRetrievebyReq(gCS.getEmail(), gCS.getId());
                    content += "<tr>";
                    content += "<td align='center' class = 'id' data-idreq = '"+r.getId()+"' ><p  id='idR'>"+r.getId()+ "</p></td>";
                    content += "<td align='center'><button class='changeName' id='nome'>" + r.getNome() + "</button>";
                    content += "<td align='center'><button  class ='changeSurname' id='cognome'>" + r.getCognome() + "</button>";
                    content += "<td align='center'>";
                    content += "\"<a href='" + request.getContextPath() + "/DownloaderSL?filename="  
                            + allegati.get(0).getFilename() + "&idRequest=" + allegati.get(0).getIdReq() + "&email="+gCS.getEmail()+"'>" 
                            + allegati.get(0).getFilename() + "</a> - ";
                    content += "\"<a href='" + request.getContextPath() + "/DownloaderSL?filename="  
                            + allegati.get(1).getFilename() + "&idRequest=" + allegati.get(1).getIdReq() + "&email="+gCS.getEmail()+"'>" 
                            + allegati.get(1).getFilename() + "</a>";
                    content += "</td>";
                    
                    if(r.getStato()==3) {
                        content += "<td align='center'><p class=\"list-group-item-warning\">In attesa</p></td>";
                    }else if(r.getStato()==4) {
                        content += "<td align='center'><p class=\"list-group-item-success\">Approvata, revisione in consiglio</p></td>";
                    }else if(r.getStato()==5) {
                        content += "<td align='center'><p class=\"list-group-item-danger\">Rifiutata, revisione in consiglio</p></td>";
                    }
                    
                    content += "<td align='center'>"+ 
                                "<button type=\"button\" class=\"btn btn-default\" aria-label=\"Conferma\" data-idreq = '"+r.getId()+"' data-stato = '"+r.getStato()+"' id=\"checkConferma\">" + 
                                    "<span class=\"glyphicon glyphicon-ok\" aria-hidden=\"true\"></span>" + 
                                "</button>" + 
                            "</td>";
                    content += "<td align='center'>"+ 
                                "<button type=\"button\" class=\"btn btn-default\" aria-label=\"Rifiuta\" data-idreq = '"+r.getId()+"' data-stato = '"+r.getStato()+"'  id=\"checkRifiuta\">" + 
                                    "<span class=\"glyphicon glyphicon-remove\" aria-hidden=\"true\"></span>" + 
                                "</button>" + 
                            "</td>";
                    content +="</tr>";
                }
            }else {
              content+="<tr><td>Non ci sono richieste</td><td></td><td></td><td></td><td></td><td></td><td></td></tr>";
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
