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

		String[] skills = request.getParameterValues("skills");
		String[] softskills = request.getParameterValues("softskills");
		String[] lingue = request.getParameterValues("lingua");

		ArrayList<Skill> sk = new ArrayList<Skill>();
		ArrayList<Skill> ss = new ArrayList<Skill>();
		ArrayList<Skill> l = new ArrayList<Skill>();
		ArrayList<Integer> idList = new ArrayList<Integer>();


		// ----------- Conversione Stringa -> Data ---------------

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date data = null;
		try {
			data = formatter.parse(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		// -------------------------------------------------------



		for (int i = 0; i < skills.length; i++) {
			for (int j = 0; j < skills[i].length(); j++) {
				String[] temp = skills[i].split(":");
				primaParte = temp[0];
				secParte = temp[1];
				Skill s = new Skill(primaParte, 0, secParte);

				try {
					if(!sDAO.checkIfExists(s.getId())) {	
						id = sDAO.doSave(s);
						idList.add(id);
						sk.add(s);
					} else {
						id = sDAO.doRetrieveByData(s);
						idList.add(id);
						sk.add(s);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


		for (int i = 0; i < softskills.length; i++) {
			Skill s = new Skill(softskills[i], 1, null);

			try {
				if(sDAO.doRetrieveByData(s) != 0) {
					idList.add(id);
					ss.add(s);
				} else {
					id = sDAO.doSave(s);
					idList.add(id);
					ss.add(s);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}


		for (int i = 0; i < lingue.length; i++) {
			for (int j = 0; j < lingue[i].length(); j++) {
				String[] temp = lingue[i].split(":");
				primaParte = temp[0];
				secParte = temp[1];
				Skill s = new Skill(primaParte, 2, secParte);

				try {
					if(!sDAO.checkIfExists(s.getId())) {	
						id = sDAO.doSave(s);
						idList.add(id);
						l.add(s);
					} else {
						id = sDAO.doRetrieveByData(s);
						idList.add(id);
						l.add(s);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		//----------- Conversione ArrayList(id) -> String --------------

		// Esempio risultato: {1, 2, 3, 4, 5}

		StringJoiner sj = new StringJoiner(", ");
		
		for (Integer seat : idList) {
			sj.add(seat.toString());
		}

		//--------------------------------------------------------------

		if((sk.size() > ss.size()) && sk.size() > l.size()) {
			for (int i = 0; i < sk.size(); i++) {
				RequestOU r = new RequestOU();
				r.setEmail(user.getEmail());
				r.setDateOfBirth(data);
				r.setCellNumber(cell);
				r.setIdSkill(sj.toString());

				try {
					if(rDAO.doSave(r)) {
						content = "Richiesta avvenuta con successo";
						redirect = request.getContextPath() + "/_areaStudent/viewRequest.jsp";
						result = 1;
					} else {
						error = "Errore nell'esecuzione della query";
						redirect = request.getContextPath() + "/_areaStudent/viewFormOU.jsp";
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else if((ss.size() > sk.size()) && ss.size() > l.size()){
			for (int i = 0; i < ss.size(); i++) {
				RequestOU r = new RequestOU();
				r.setEmail(user.getEmail());
				r.setDateOfBirth(data);
				r.setCellNumber(cell);
				r.setIdSkill(sj.toString());

				try {
					if(rDAO.doSave(r)) {
						content = "Richiesta avvenuta con successo";
						redirect = request.getContextPath() + "/_areaStudent/viewRequest.jsp";
						result = 1;
					} else {
						error = "Errore nell'esecuzione della query";
						redirect = request.getContextPath() + "/_areaStudent/viewFormOU.jsp";
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			for (int i = 0; i < l.size(); i++) {
				RequestOU r = new RequestOU();
				r.setEmail(user.getEmail());
				r.setDateOfBirth(data);
				r.setCellNumber(cell);
				r.setIdSkill(sj.toString());

				try {
					if(rDAO.doSave(r)) {
						content = "Richiesta avvenuta con successo";
						redirect = request.getContextPath() + "/_areaStudent/viewRequest.jsp";
						result = 1;
					} else {
						error = "Errore nell'esecuzione della query";
						redirect = request.getContextPath() + "/_areaStudent/viewFormOU.jsp";
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
