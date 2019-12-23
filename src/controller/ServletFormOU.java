package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.StringJoiner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import interfacce.UserInterface;
import model.RequestOU;
import model.RequestOUDAO;
import model.Skill;
import model.SkillDAO;

/**
 * Servlet implementation class SevletFormOU
 */
@WebServlet("/SevletFormOU")
public class ServletFormOU extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletFormOU() {
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
		System.out.println("CIAO");
		
		Integer result = 0;
		String error = "";
		String content = "";
		String redirect = "";

		String primaParte = "";
		String secParte = "";

		UserInterface user = (UserInterface) request.getSession().getAttribute("user"); 
		RequestOUDAO rDAO = new RequestOUDAO();
		SkillDAO sDAO = new SkillDAO();
		Integer id = 0;

		String email = request.getParameter("email");
		String cell = request.getParameter("telefono");
		String date = request.getParameter("datanascita");

		String skills = request.getParameter("skills");
		String softskills = request.getParameter("softskills");
		String lingue = request.getParameter("lingua");

		// Creo oggetti JSON
		JSONParser parser = new JSONParser();
		JSONObject skills1 = new JSONObject();
		JSONObject softskills1 = new JSONObject();
		JSONObject lingue1 = new JSONObject();

		// Converto stringhe in input in oggetti JSON
		try {
			skills1 = (JSONObject) parser.parse(skills);
			softskills1 = (JSONObject) parser.parse(softskills);
			lingue1 = (JSONObject) parser.parse(lingue);
		} catch (org.json.simple.parser.ParseException e2) {
			e2.printStackTrace();
		}

		// Prendo i valori
		String[] skillName = (String[]) skills1.get("skill");
		String[] skillValue = (String[]) skills1.get("value");
		String[] softSkillName = (String[]) softskills1.get("softskill");
		String[] linguaName = (String[]) lingue1.get("lang");
		String[] linguaValue = (String[]) lingue1.get("value");

		ArrayList<Skill> skillList = new ArrayList<Skill>();
		ArrayList<Skill> softSkillList = new ArrayList<Skill>();
		ArrayList<Skill> lingueList = new ArrayList<Skill>();


		// ----------- Conversione Stringa -> Data ---------------

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date data = null;
		try {
			data = formatter.parse(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		// -------------------------------------------------------



		for (int i = 0; i < skillName.length; i++) {
			Skill s = new Skill(skillName[i], 0, skillValue[i]);

			try {
				if(sDAO.doRetrieveByData(s) == 0) {
					int idSkill = sDAO.doSave(s);
					skillList.add(s);
				} else {
					skillList.add(s);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		for (int i = 0; i < softSkillName.length; i++) {
			Skill s = new Skill(softSkillName[i], 1, null);

			try {
				if(sDAO.doRetrieveByData(s) == 0) {
					int idSkill = sDAO.doSave(s);
					softSkillList.add(s);
				} else {
					softSkillList.add(s);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


		for (int i = 0; i < linguaName.length; i++) {
			Skill s = new Skill(linguaName[i], 0, linguaValue[i]);

			try {
				if(sDAO.doRetrieveByData(s) == 0) {
					int idSkill = sDAO.doSave(s);
					lingueList.add(s);
				} else {
					lingueList.add(s);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//-------------- Caricamento richieste nel DB ---------------
		
		if(skillList.size() > 0) {
			for(Skill s: skillList) {
				RequestOU r = new RequestOU();
				r.setEmail(email);
				r.setIdSkill(s.getId());
				r.setCellNumber(cell);
				r.setDateOfBirth(data);
				
				try {
					rDAO.doSave(r);
				} catch (SQLException e) {
					error = "Errore nell'esecuzione della query";
					redirect = request.getContextPath() + "/_areaStudent/viewFormOU.jsp";
					e.printStackTrace();
				}
			}
		}

		if(softSkillList.size() > 0) {
			for(Skill s1: softSkillList) {
				RequestOU r1 = new RequestOU();
				r1.setEmail(email);
				r1.setIdSkill(s1.getId());
				r1.setCellNumber(cell);
				r1.setDateOfBirth(data);
				
				try {
					rDAO.doSave(r1);
				} catch (SQLException e) {
					error = "Errore nell'esecuzione della query";
					redirect = request.getContextPath() + "/_areaStudent/viewFormOU.jsp";
					e.printStackTrace();
				}
			}
		}

		if(lingueList.size() > 0) {
			for(Skill s2: lingueList) {
				RequestOU r2 = new RequestOU();
				r2.setEmail(email);
				r2.setIdSkill(s2.getId());
				r2.setCellNumber(cell);
				r2.setDateOfBirth(data);
				
				try {
					rDAO.doSave(r2);
				} catch (SQLException e) {
					error = "Errore nell'esecuzione della query";
					redirect = request.getContextPath() + "/_areaStudent/viewFormOU.jsp";
					e.printStackTrace();
				}
			}
		}
		//----------------------------------------------------------------
	
		
		content = "Richiesta avvenuta con successo";
		redirect = request.getContextPath() + "/_areaStudent/viewRequest.jsp";
		result = 1;

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
