package controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import interfacce.UserInterface;
import model.CompetenzeBean;
import model.RequestOU;
import model.RequestOUDAO;
import model.Skill;
import model.SkillDAO;

/**
 * Servlet implementation class SevletFormOU
 */
@WebServlet("/SevletFormOU")
public class SevletFormOU extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SevletFormOU() {
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
		
		UserInterface user = (UserInterface) request.getSession().getAttribute("user");
		int idSkill = Integer.parseInt(request.getParameter("skill"));
		
		SkillDAO skillDAO = new SkillDAO();
		ArrayList<Skill> list = new ArrayList<Skill>();
		
		try {	
			
			list = skillDAO.doRetrieveByID(idSkill);
			RequestOUDAO rDAO = new RequestOUDAO();
			
			for(Skill s: list) {
				RequestOU r = new RequestOU();
				r.setIdSkill(s.getId());
				r.setEmail(user.getEmail());
				//rDAO.doSave(r);
			}
			
		} catch (Exception e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
