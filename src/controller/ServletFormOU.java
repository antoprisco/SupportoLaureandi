package controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.lang.Object;

import com.itextpdf.text.log.SysoCounter;

import interfacce.UserInterface;
import model.RequestOU;
import model.RequestOUDAO;
import model.Skill;
import model.SkillDAO;

/**
 * Servlet implementation class SevletFormOU
 */
@WebServlet("/ServletFormOU")
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

		Integer result = 0;
		String error = "";
		String content = "";
		String redirect = "";

		String skillName = null;
		String skillValue = null;
		String softSkillName = null;
		String linguaName = null;
		String linguaValue = null;

		ArrayList<Skill> skillList = new ArrayList<Skill>();
		ArrayList<Skill> softSkillList = new ArrayList<Skill>();
		ArrayList<Skill> lingueList = new ArrayList<Skill>();

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

		// ----------- Conversione Stringa -> Data ---------------

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date data = null;
		try {
			data = formatter.parse(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		// -------------------------------------------------------

		// Creo oggetti JSON
		JSONParser parser = new JSONParser();
		JSONArray skills1 = new JSONArray();
		//JSONArray softskills1 = new JSONArray();
		//JSONArray lingue1 = new JSONArray();

		// Converto stringhe in input in oggetti JSON
		try {
			skills1 = (JSONArray) parser.parse(skills);
			//softskills1 = (JSONArray) parser.parse(softskills);
			//lingue1 = (JSONArray) parser.parse(lingue);
		} catch (org.json.simple.parser.ParseException e2) {
			e2.printStackTrace();
		}


		for (int i = 0; i < skills1.size(); i++) {
			JSONObject j = (JSONObject) skills1.get(i);
			skillName = (String) j.get("skill");
			skillValue = (String) j.get("value");

			Skill s = new Skill(skillName, 0, skillValue);

			try {
				if(sDAO.checkIfExists(s)) {
					s.setId(sDAO.doRetrieveByData(s));
					skillList.add(s);
				} else {
					sDAO.doSave(s);
					s.setId(sDAO.doRetrieveByData(s));
					skillList.add(s);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	

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
