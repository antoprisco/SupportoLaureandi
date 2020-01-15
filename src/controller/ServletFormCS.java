package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import interfacce.UserInterface;
import java.io.File;
import java.io.FileOutputStream;
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
import model.Corsi;
import model.CorsiDAO;
import model.GestisceCS;
import model.GestisceCSDAO;
import model.RequestCS;
import model.RequestCSDAO;
import model.Residenza;
import model.TitoloStudio;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class ServletFormCS.
 */
@WebServlet("/ServletFormCS")
public class ServletFormCS extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * Constructor.
   * 
   * @see HttpServlet#HttpServlet()
   */
  public ServletFormCS() {
    super();
  }
  
  /**
   * Method doGet().
   * 
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doPost(request, response);
  }

  /**
   * Method doPost().
   * 
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException { 
    Integer result = 0;
    String error = "";
    String content = "";
    String redirect = "";
    File nome_file = null;
   
    UserInterface user = (UserInterface) request.getSession().getAttribute("user");
    String idUser = user.getEmail();
    if (Integer.parseInt(request.getParameter("flag")) == 8) {
      if (request.getParameter("cognome").length() == 0 
          || request.getParameter("cognome").length() > 20 
          || request.getParameter("cognome").matches(".*\\d+.*")) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (request.getParameter("nome").length() == 0 
          || request.getParameter("nome").length() > 20 
          || request.getParameter("nome").matches(".*\\d+.*")) { 
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (request.getParameter("luogoNascita").length() == 0 
          || request.getParameter("luogoNascita").length() > 30 
          || request.getParameter("luogoNascita").matches(".*\\d+.*")) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (request.getParameter("provincia").length() == 0 
          || request.getParameter("provincia").length() > 20 
          || request.getParameter("provincia").matches(".*\\d+.*")) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (request.getParameter("dataNascita").length() == 0) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      
      //Residenza
      if (request.getParameter("residenza").length() == 0 
          || request.getParameter("residenza").length() > 30 
          || request.getParameter("residenza").matches(".*\\d+.*")) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (request.getParameter("provinciaR").length() == 0 
          || request.getParameter("provinciaR").length() > 20 
          || request.getParameter("provinciaR").matches(".*\\d+.*")) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (request.getParameter("indirizzo").length() == 0 
          || request.getParameter("indirizzo").length() > 50) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (Integer.parseInt(request.getParameter("cap")) <= 1 
          || Integer.parseInt(request.getParameter("cap")) >= 99999) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      //Fine Residenza
      if (request.getParameter("telefonoF").length() == 0 
          || request.getParameter("telefonoF").length() > 15) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (request.getParameter("cellulare").length() == 0 
          || request.getParameter("cellulare").length() > 15) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (request.getParameter("cf").length() == 0 
          || request.getParameter("cf").length() >= 17) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      String email = request.getParameter("email");
      /*l'email ï¿½ valida se la sua lunghezza ï¿½ diversa da 0, 
      * se non ï¿½ presente nel DB e se rispetta il formato
      * se finisce con @studenti.unisa.it
               */
      String prefix = "";
      if (email.length() > 0) {
        prefix = email.substring(0, email.indexOf("@"));
      }
      if (email.length() == 0  
           || !email.endsWith("@studenti.unisa.it") 
           || prefix.length() < 3 
           || prefix.indexOf(".") == -1) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (request.getParameter("diploma").length() == 0 
           || request.getParameter("diploma").length() > 30 
           || request.getParameter("residenza").matches(".*\\d+.*")) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (Integer.parseInt(request.getParameter("annoD")) <= 1970 
           || Integer.parseInt(request.getParameter("annoD")) >= 2017) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (request.getParameter("istituto").length() == 0 
           || request.getParameter("istituto").length() > 30 
           || request.getParameter("istituto").matches(".*\\d+.*")) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (request.getParameter("comune").length() == 0 
           || request.getParameter("comune").length() > 30 
           || request.getParameter("comune").matches(".*\\d+.*")) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      //TitoloStudio
      if (request.getParameter("laurea").length() == 0 
           || request.getParameter("laurea").length() > 30 
           || request.getParameter("laurea").matches(".*\\d+.*")) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (request.getParameter("dataL").length() == 0) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (request.getParameter("universita").length() == 0 
           || request.getParameter("universita").length() > 30 
           || request.getParameter("universita").matches(".*\\d+.*")) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (Integer.parseInt(request.getParameter("matricola")) <= 0) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      if (Integer.parseInt(request.getParameter("voto")) <= 65 
           || Integer.parseInt(request.getParameter("voto")) >= 110) {
        throw new IllegalArgumentException("Formato non corretto");
      }
      Residenza r = new Residenza(
          request.getParameter("residenza"), request.getParameter("provinciaR"), 
          request.getParameter("indirizzo"), Integer.parseInt(request.getParameter("cap")));
      TitoloStudio ts = new TitoloStudio(
          request.getParameter("laurea"), request.getParameter("dataL"), 
          request.getParameter("universita"), Integer.parseInt(request.getParameter("matricola")), 
          Integer.parseInt(request.getParameter("voto")), request.getParameter("lode"));

      //controlla se ci sono altre richieste in sospeso
      RequestCS rcs = new RequestCS();
      RequestCS rcs1 = new RequestCS(request.getParameter("nome"), 
           request.getParameter("cognome"),1);
      RequestCSDAO rcD = new RequestCSDAO();
      GestisceCS g = new GestisceCS();
      GestisceCSDAO gd = new GestisceCSDAO();

      try {
        ArrayList<RequestCS> list = rcD.doRetrieveByR(user.getEmail());
        ArrayList<RequestCS> list1 = rcD.doRetrieveByES(user.getEmail(), 1);
        ArrayList<RequestCS> list2 = rcD.doRetrieveByES(user.getEmail(), 2);
        ArrayList<RequestCS> list3 = rcD.doRetrieveByES(user.getEmail(), 3);
        ArrayList<RequestCS> list4 = rcD.doRetrieveByES(user.getEmail(), 4);
        ArrayList<RequestCS> list5 = rcD.doRetrieveByES(user.getEmail(), 5);
        //ArrayList<RequestCS> list6 = rcD.doRetrieveByNCS(user.getName(), user.getSurname(), 6);

        /*Nel caso in cui non vi siano richieste con il nome dell'utente 
         * oppure ci sono ma sono completate si può effettuare la richiesta
         */
        if (list1.isEmpty()  && list2.isEmpty() && list3.isEmpty() 
            && list4.isEmpty() && list5.isEmpty() || list.isEmpty()) {
          
          //vengono presi tutti i parametri per creare il PDF
          String sceltaNome = null;
          String sceltaId = null;
          Corsi c = new Corsi();
          CorsiDAO cd = new CorsiDAO();
          ArrayList<Corsi> listaCorsi = new ArrayList<Corsi>();
          
          String scelta = request.getParameter("scelta");

          //CREO OGGETTI JSON
          JSONParser parser = new JSONParser();
          JSONArray scelta1 = new JSONArray();
          //CONVERTO STRINGHE in input in oggetti json
          try {
            scelta1 = (JSONArray) parser.parse(scelta);
          } catch (org.json.simple.parser.ParseException e2) {
            e2.printStackTrace();
          }

          //CREAZIONE PDF CON DATI DEL FORM
          try {
            Date d = new Date();
            nome_file = new File("IscrizioneCS_" + user.getSurname() 
                + d.getHours() + "" + d.getMinutes() + ".pdf");
            OutputStream file = new FileOutputStream(nome_file);
            Document document = new Document();
            PdfWriter.getInstance(document, file);
            document.open();
            String uni = "Università degli Studi di Salerno";
            String dip = "Dipartimento di Informatica";
            Image foto = Image.getInstance(
                "C://Users//Simone//SupportoLaureandi//WebContent//imagesEV//logo.png");
            
            String text1 = "Io sottoscritto/a ai sensi dell’art. 46 del D.P.R. 28 Dicembre 2000, "
                + "n. 445 e consapevole che, ai sensi dell’art. 76 dello stesso " 
                + "D.P.R. 445/2000 “chiunque rilascia dichiarazioni mendaci, forma atti falsi "
                + "o ne fa uso nei casi previsti dal presente testo unico è " 
                + "punito dal codice penale e dalle leggi speciali in materia” ";
            String text2 = "DICHIARO SOTTO LA MIA RESPONSABILITÀ I SEGUENTI DATI";
            String text3 = "Il mio NOME è " + user.getName() 
                + "\t il mio COGNOME è " + user.getSurname()
                + "\r\n" 
                + "sono NATO/A a " + request.getParameter("luogoNascita") + "\t prov. " 
                + request.getParameter("provincia") + "\t il " 
                +  request.getParameter("dataNascita")
                + "\r\n" 
                + "sono RESIDENTE a " + request.getParameter("residenza") + "\t prov. " 
                + request.getParameter("provinciaR")
                + "\r\n" 
                + "indirizzo: " + request.getParameter("indirizzo") + "\t C.A.P. " 
                + request.getParameter("cap") 
                + "\r\n" 
                + "telefono fisso: " + request.getParameter("telefonoF") 
                + "\t telefono cellulare: " + request.getParameter("cellulare")
                + "\r\n" 
                + "Il mio CODICE FISCALE è " + request.getParameter("cf") 
                + "\r\n"
                + "E-mail: " + request.getParameter("email")
                + "\r\n" 
                + "Sono in possesso del seguente diploma di maturità: " 
                + request.getParameter("diploma")
                + "\r\n" 
                + "conseguito nell’anno " + request.getParameter("annoD") 
                + "\t presso l’Istituto " + request.getParameter("istituto") 
                + "\r\n" 
                + "nel comune di " + request.getParameter("comune")
                + "\r\n" + "Sono in possesso del seguente titolo di Laurea: " 
                + request.getParameter("laurea")
                + "\r\n" 
                + "conseguito in data " + request.getParameter("dataL")
                + "\t presso l’Università: " + request.getParameter("universita") 
                + "\r\n" 
                + "matricola (se si è stati iscritti presso l’Università degli Studi di Salerno):" 
                + request.getParameter("matricola")
                + "\r\n con il voto di " + request.getParameter("voto") + "su 110" 
                + "\t lode: " + request.getParameter("lode") + "";

            String text4 = "CHIEDO L'ISCRIZIONE AI SEGUENTI CORSI SINGOLI:";
            String text5 = "Anno di iscrizione: " + request.getParameter("year") + "";
            
            Paragraph puni = new Paragraph(uni);
            Paragraph pdip = new Paragraph(dip);
            Paragraph p1 = new Paragraph(text1);
            Paragraph p2 = new Paragraph(text2);
            Paragraph p3 = new Paragraph(text3);
            Paragraph p4 = new Paragraph(text4);
            Paragraph p5 = new Paragraph(text5);

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
            for (int i = 0; i < scelta1.size(); i++) {
              JSONObject j = (JSONObject) scelta1.get(i);
              sceltaNome = (String)j.get("esame");
              sceltaId = (String) j.get("value");
              if (sceltaId != null) {
                try {
                  c = cd.doRetrieveByID(Integer.parseInt(sceltaId));

                  String text6 = c.getSemestre() + "° Semestre: " + c.getNome() 
                      + " (" + c.getCfu() + "cfu)\r\n";
                  Paragraph p6 = new Paragraph(text6);
                  document.add(p6);

                } catch (NumberFormatException e) {
                  e.printStackTrace();
                } catch (SQLException e) {
                  e.printStackTrace();
                }
              } else {
                error = "Non è stata inserito nessun corso";
              }
            }
            String acapo = "\r\n";
            String dataFirma = "Data____________________";
            String firma = "Firma_______________________";
            Paragraph spazio = new Paragraph(acapo);
            Paragraph pdf = new Paragraph(dataFirma);
            Paragraph pf = new Paragraph(firma);
            pdf.setAlignment(Element.ALIGN_BOTTOM);
            pf.setAlignment(Element.ALIGN_LEFT);
            pf.setAlignment(Element.ALIGN_RIGHT);
            //stampa data
            document.add(spazio);
            document.add(spazio);
            document.add(pdf);
            document.add(pf);

            document.close();
            file.close();

            
            
            
          } catch (Exception e) { 
            e.printStackTrace();
          }

          //Salvataggio nel database della richiesta con lo stato 1
          rcD.doSave(rcs1);
          rcs1 = rcD.doRetrieveByNCStato(request.getParameter("nome"), request.getParameter("cognome"),1);
          g = new GestisceCS(user.getEmail(),rcs1.getId());
          gd.doSave(g);
          result = 1;
        } else /*if (!list.isEmpty()) */ {
              /*Nel caso in cui ci sono richieste con il nome dell'utente 
            *e lo stato della richiesta è in corso
             */
              /* for (int i = 0; i<list.size(); i++) {
            rcs = list.get(i);
            if (rcs.getStato() == 1 
                || rcs.getStato() == 2 
                || rcs.getStato() == 3 
                || rcs.getStato() == 4 
                || rcs.getStato() == 5) {*/
          error = "Spiacenti, vi sono altre domande in corso";
          //}
          //}
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    JSONObject res = new JSONObject();
    res.put("result", result);
    res.put("error", error);
    res.put("content", content);
    res.put("redirect", redirect);
    //res.put("nome_file",nome_file);
    PrintWriter out = response.getWriter();
    // OutputStream outs= response.getOutputStream();
    out.println(res);
    response.setContentType("json");
    System.err.println(res.toString());
    
    
    //  DownloaderPDF dp= new DownloaderPDF();
    //dp.doPost(request, response);
    
    
  }

}
