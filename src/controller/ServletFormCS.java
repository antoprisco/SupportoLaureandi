package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.common.collect.Table;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import interfacce.UserInterface;
import model.Corsi;
import model.CorsiDAO;
import model.GestisceCS;
import model.GestisceCSDAO;
import model.RequestCS;
import model.RequestCSDAO;
import model.Residenza;
import model.TitoloStudio;

/**
 * Servlet implementation class ServletFormCS
 */
@WebServlet("/ServletFormCS")
public class ServletFormCS extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFormCS() {
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
		 	Integer result = 0;
		    String error = "";
		    String content = "";
		    String redirect = "";
			
			UserInterface user = (UserInterface) request.getSession().getAttribute("user");
		    String idUser = user.getEmail();
		      
		    System.out.println("njknjknjk1");
		     	if(Integer.parseInt(request.getParameter("flag"))==8) {
		     		
		     		System.out.println("nkkjnjk2");
		     		// -22/12   22:48 ENTRA QUI
		     		
		     		if ( request.getParameter("cognome").length() == 0 || request.getParameter("cognome").length() > 20 || request.getParameter("cognome").matches(".*\\d+.*"))
		     			throw new IllegalArgumentException("Formato non corretto");
		     		if ( !(request.getParameter("cognome").equals(user.getSurname())) ) {
		     			error="Controlla bene, non è il tuo cognome";
		     			throw new IllegalArgumentException("il Cognome non corrisponde a quello dell'utente");
		     		}
		     	System.out.println("cognome");
		     	
		     		if (request.getParameter("nome").length() == 0 || request.getParameter("nome").length() > 20 || request.getParameter("nome").matches(".*\\d+.*")) 
		     	          throw new IllegalArgumentException("Formato non corretto");
		     		if (!( request.getParameter("nome").equals(user.getName())) ) {
		     			error="Controlla bene, non è il tuo nome";
		     			throw new IllegalArgumentException("il Nome non corrisponde a quello dell'utente");
		     		}
		    	System.out.println("nome");
		    	
		    	
		     		if (request.getParameter("luogoNascita").length() == 0 || request.getParameter("luogoNascita").length() > 30 || request.getParameter("luogoNascita").matches(".*\\d+.*")) 
		     	          throw new IllegalArgumentException("Formato non corretto");
		    	System.out.println("luogonascita");
		     		if (request.getParameter("provincia").length() == 0 || request.getParameter("provincia").length() > 20 || request.getParameter("provincia").matches(".*\\d+.*")) 
		     	          throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("provincia");
		     		
		     		if(request.getParameter("dataNascita").length()==0)
		     			throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("dataNascita");	
		     		
		     	//Residenza
		     		
		     		if (request.getParameter("residenza").length() == 0 || request.getParameter("residenza").length() > 30 || request.getParameter("residenza").matches(".*\\d+.*")) 
		     	          throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("residenza");
		     		if (request.getParameter("provinciaR").length() == 0 || request.getParameter("provinciaR").length() > 20 || request.getParameter("provinciaR").matches(".*\\d+.*")) 
		     	          throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("provinciaR");
		     		if (request.getParameter("indirizzo").length() == 0 || request.getParameter("indirizzo").length() > 50) 
		     	          throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("indirizzo");
		     		if (Integer.parseInt(request.getParameter("cap"))<= 1 || Integer.parseInt(request.getParameter("cap"))>=99999 ) 
		     	          throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("cap");
		     		
		     		//end
		     		
		     		if (request.getParameter("telefonoF").length() == 0 || request.getParameter("telefonoF").length() > 15 ) 
		     	          throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("telefonoF");
		     		if (request.getParameter("cellulare").length() == 0 || request.getParameter("cellulare").length() > 15 ) 
		     	          throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("cellulare");
		     		
		     		if (request.getParameter("cf").length() == 0 || request.getParameter("cf").length() >=17 ) 
		     	         throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("cf");
		     		
		     		String email = request.getParameter("email");
		             /*l'email ï¿½ valida se la sua lunghezza ï¿½ diversa da 0, 
		              * se non ï¿½ presente nel DB e se rispetta il formato
		              * se finisce con @studenti.unisa.it
		             */
		             String prefix = "";
		             if (email.length() > 0) {
		               prefix = email.substring(0, email.indexOf("@"));
		             }
		             if (email.length() == 0  || !email.endsWith("@studenti.unisa.it") || prefix.length() < 3 || prefix.indexOf(".") == -1) {
		               throw new IllegalArgumentException("Formato non corretto");
		             }
		             if ( !(request.getParameter("email").equals(user.getEmail())) ) {
			     			error="Controlla bene, non è la tua email";
		             		throw new IllegalArgumentException("L'email non corrisponde a quella dell'utente");
		             }
		        System.out.println("email");
		             
		             if (request.getParameter("diploma").length() == 0 || request.getParameter("diploma").length() > 30 || request.getParameter("residenza").matches(".*\\d+.*")) 
		     	          throw new IllegalArgumentException("Formato non corretto");
		        System.out.println("diploma");
		     		
		     		
		     		if(Integer.parseInt(request.getParameter("annoD"))<=1970 || Integer.parseInt(request.getParameter("annoD"))>=2017)
		     			  throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("annoD");
		     		
		     		if (request.getParameter("istituto").length() == 0 || request.getParameter("istituto").length() > 30 || request.getParameter("istituto").matches(".*\\d+.*")) 
		     			throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("istituto");
		     		
		     		if (request.getParameter("comune").length() == 0 || request.getParameter("comune").length() > 30 || request.getParameter("comune").matches(".*\\d+.*")) 
		     	          throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("comune");
		     		
		     	
		     		
		     		//TitoloStudio
		     		if (request.getParameter("laurea").length() == 0 || request.getParameter("laurea").length() > 30 || request.getParameter("laurea").matches(".*\\d+.*")) 
		     	          throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("laurea");
		     		
		     		if(request.getParameter("dataL").length()==0)
		     			throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("dataL");
		     		
		     		if (request.getParameter("universita").length() == 0 || request.getParameter("universita").length() > 30 || request.getParameter("universita").matches(".*\\d+.*")) 
		     	          throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("università");
		     		
		     		if(Integer.parseInt(request.getParameter("matricola"))<=0)
		     			throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("matricola");
		     		
		     		if(Integer.parseInt(request.getParameter("voto"))<=65 || Integer.parseInt(request.getParameter("voto"))>=111 )
		     			throw new IllegalArgumentException("Formato non corretto");
		     	System.out.println("voto");
		     		
		     	
		     		
		     		Residenza r= new Residenza(request.getParameter("residenza"), request.getParameter("provinciaR"), request.getParameter("indirizzo"), Integer.parseInt(request.getParameter("cap")));
		     		TitoloStudio ts= new TitoloStudio(request.getParameter("laurea"), request.getParameter("dataL"), request.getParameter("universita"), Integer.parseInt(request.getParameter("matricola")), Integer.parseInt(request.getParameter("voto")), request.getParameter("lode"));
		     		
		     				     		
		     		
		     		
		     		
		     		//controlla se ci sono altre richieste in sospeso
		     		RequestCS rcs= new RequestCS();
		     		RequestCS rcs1= new RequestCS(request.getParameter("nome"), request.getParameter("cognome"),1);
		     		RequestCSDAO rcD= new RequestCSDAO();
		     		GestisceCS g= new GestisceCS();
		     		GestisceCSDAO gd= new GestisceCSDAO();
		     		
		     		try {
		     			ArrayList<RequestCS> list= rcD.doRetrieveByNC(user.getName(), user.getSurname());
		     			RequestCS list6=rcD.doRetrieveByNCS(user.getName(), user.getSurname(), 6);
		     			RequestCS list7=rcD.doRetrieveByNCS(user.getName(), user.getSurname(), 7);
		     			
		     			//Nel caso in cui non vi siano richieste con il nome dell'utente oppure ci sono ma sono completate si può effettuare la richiesta
		     			if(list6==null || list7==null || list.isEmpty()) {
		     				
		     				//vengono presi tutti i parametri per creare il PDF

				     		
				     		String SceltaNome= null;
				    		String SceltaId=null;
				    		Corsi c= new Corsi();
				    		CorsiDAO cd= new CorsiDAO();
				    		ArrayList<Corsi> listaCorsi= new ArrayList<Corsi>();
				    		
				    		String scelta= request.getParameter("scelta");
				    		
				    		//CREO OGGETTI JSON
				    		JSONParser parser = new JSONParser();
				    		JSONArray scelta1= new JSONArray();
				    		
				    		//CONVERTO STRINGHE in input in oggetti json
				    		try {
				    			scelta1=(JSONArray) parser.parse(scelta);
				    		}catch(org.json.simple.parser.ParseException e2) {
				    			e2.printStackTrace();
				    		}
				     		
				     		//CREAZIONE PDF CON DATI DEL FORM
				     		try {
				     			Date d= new Date();
				    			File nome_file= new File("IscrizioneCS_"+request.getParameter("cognome")+d.getHours()+""+d.getMinutes()+""+d.getSeconds()+".pdf");
				    			OutputStream file = new FileOutputStream(nome_file);
				                
				    			
				                Document document = new Document();
				                
				                PdfWriter.getInstance(document, file);
				                document.open();
				                String uni="Università degli Studi di Salerno";
				                String dip="Dipartimento di Informatica";
				                Image foto= Image.getInstance("C://Users//Simone//SupportoLaureandi//WebContent//imagesEV//logo.png");
				                
				                String Text1= "Io sottoscritto/a ai sensi dell’art. 46 del D.P.R. 28 Dicembre 2000, n. 445 e consapevole che, ai sensi dell’art. 76 dello stesso " + 
				                		"D.P.R. 445/2000 “chiunque rilascia dichiarazioni mendaci, forma atti falsi o ne fa uso nei casi previsti dal presente testo unico è " + 
				                		"punito dal codice penale e dalle leggi speciali in materia” ";
				                String Text2= "DICHIARO SOTTO LA MIA RESPONSABILITÀ I SEGUENTI DATI";
				                
				                String Text3="Il mio NOME è " + request.getParameter("nome") + "\t il mio COGNOME è " + request.getParameter("cognome")+
				                			"\r\n" + 
				                			"sono NATO/A a " + request.getParameter("luogoNascita")+ "\t prov. " + request.getParameter("provincia")+ "\t il " +  request.getParameter("dataNascita")+
				                			"\r\n" + 
				                			"sono RESIDENTE a "+ request.getParameter("residenza") +"\t prov. " + request.getParameter("provinciaR")+
				                			"\r\n" + 
				                			"indirizzo: "+ request.getParameter("indirizzo") +"\t C.A.P. " + request.getParameter("cap")+
				                			"\r\n" + 
				                			"telefono fisso: " + request.getParameter("telefonoF")+ "\t telefono cellulare: " + request.getParameter("cellulare")+
				                			"\r\n" + 
				                			"Il mio CODICE FISCALE è " + request.getParameter("cf")+
				                			"\r\n"+
				                			"E-mail: " + request.getParameter("email")+
				                			"\r\n" + 
				                			"Sono in possesso del seguente diploma di maturità: " + request.getParameter("diploma")+
				                			"\r\n" + 
				                			"conseguito nell’anno " + request.getParameter("annoD")+ "\t presso l’Istituto " + request.getParameter("istituto") +
				                			"\r\n" + 
				                			"nel comune di " + request.getParameter("comune")+
				                			"\r\n" + 
				                			"Sono in possesso del seguente titolo di Laurea: " + request.getParameter("laurea")+
				                			"\r\n" + 
				                			"conseguito in data " + request.getParameter("dataL")+ "\t presso l’Università: " + request.getParameter("universita") +
				                			"\r\n" + 
				                			"matricola (se si è stati iscritti presso l’Università degli Studi di Salerno):" + request.getParameter("matricola")+
				                			"\r\n con il voto di "+ request.getParameter("voto")+ "su 110" + "\t lode: "+ request.getParameter("lode")+"";
				              
				                String Text4= "CHIEDO L'ISCRIZIONE AI SEGUENTI CORSI SINGOLI:";
				                String Text5= "Anno di iscrizione: "+ request.getParameter("year") +"";
				                
				                Paragraph puni=new Paragraph(uni);
				                Paragraph pdip=new Paragraph(dip);
				                Paragraph p1=new Paragraph(Text1);
				                Paragraph p2=new Paragraph(Text2);
				                Paragraph p3=new Paragraph(Text3);
				                Paragraph p4=new Paragraph(Text4);
				                Paragraph p5=new Paragraph(Text5);
				                
				                p1.setAlignment(Element.ALIGN_JUSTIFIED);
				                p2.setAlignment(Element.ALIGN_CENTER);
				                p3.setAlignment(Element.ALIGN_JUSTIFIED);
				                p4.setAlignment(Element.ALIGN_CENTER);
				                
				                foto.scaleToFit(40, 40);
				                puni.setAlignment(Element.ALIGN_CENTER);
				                pdip.setAlignment(Element.ALIGN_CENTER);
				                foto.setAlignment(Element.ALIGN_CENTER);
				                
				                document.add(puni);
				                document.add(pdip);
				                document.add(foto);
				                
				                document.add(p1);
				                document.add(p2);
				                document.add(p3);
				                document.add(p4);
				                document.add(p5);
				                
				                
				              //INSERIMENTO CORSI SCELTI NEL PDF
				        		for(int i=0; i<scelta1.size();i++) {
				        			JSONObject j= (JSONObject) scelta1.get(i);
				        			SceltaNome=(String)j.get("esame");
				        			SceltaId= (String)j.get("value");
				        			
				        			if(SceltaId!=null) {
				        				
				        			try {
				        				c=cd.doRetrieveByID(Integer.parseInt(SceltaId));
				        				//listaCorsi.add(c);
				        				String Text6=c.getSemestre()+"° Semestre: "+c.getNome()+" ("+ c.getCfu()+"cfu)\r\n";
				        				Paragraph p6=new Paragraph(Text6);
						                document.add(p6);
						                
				        				System.out.println(c.getId()+":"+ c.getNome()+": "+c.getCfu()+"(semestre"+c.getSemestre()+")");
				        				
				        			} catch (NumberFormatException e) {
				        				// TODO Auto-generated catch block
				        				e.printStackTrace();
				        			} catch (SQLException e) {
				        				// TODO Auto-generated catch block
				        				e.printStackTrace();
				        			}
				        			}
				        			else error="Non è stata inserito nessun corso";
				        			
				        		}
				        		
				                String acapo="\r\n";
				        		String dataFirma="Data____________________";
				                String Firma="Firma_______________________";
				                
				                Paragraph spazio=new Paragraph(acapo);
				                Paragraph pdf=new Paragraph(dataFirma);
				                Paragraph pf= new Paragraph(Firma);
				                
				                pdf.setAlignment(Element.ALIGN_BOTTOM);
				                pf.setAlignment(Element.ALIGN_LEFT);
				                pf.setAlignment(Element.ALIGN_RIGHT);
				                
				                //stampa data
				                document.add(spazio);
				                document.add(spazio);
				                document.add(pdf);
				                document.add(pf);
				                document.add(new Paragraph(new Date().toString()));
				                
				                
				                document.close();
				                file.close();
				               		               
				            } catch (Exception e) { 
				                e.printStackTrace();
				            }
		     				
		     				
		     				
		     				
		     				//Salvataggio nel database
		     				rcD.doSave(rcs1);
	    					rcs1=rcD.doRetrieveByNCS(request.getParameter("nome"), request.getParameter("cognome"),1);
	    					g= new GestisceCS(request.getParameter("email"),rcs1.getId());
	    					gd.doSave(g);
	    					
	    					result=1;
	    					System.out.println("SALVATO");
		     				
		     			}
		     			//Nel caso in cui ci sono richieste con il nome dell'utente e lo stato della richiesta è in corso
		     			else if(!list.isEmpty()) {
		     				for(int i=0; i<list.size();i++) {
		    				
		     					rcs=list.get(i);
		     					if(rcs.getStato()==1 || rcs.getStato()==2 || rcs.getStato()==3 || rcs.getStato()==4 || rcs.getStato()==5) {
		     						error="Spiacenti, vi sono altre domande in corso";
		    					}
		    				
		    			}
		     			}
					
		     		
		     		}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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
