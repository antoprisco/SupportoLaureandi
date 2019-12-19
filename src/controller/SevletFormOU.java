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
import model.CompetenzeBeanDAO;
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
		
		UserInterface user = (UserInterface) request.getSession().getAttribute("user");
		int idSkill = Integer.parseInt(request.getParameter("skill"));
		
		SkillDAO skillDAO = new SkillDAO();
		ArrayList<Skill> list = new ArrayList<Skill>();
		
		CompetenzeBeanDAO cbDAO = new CompetenzeBeanDAO();
		
		/*
		 * 		UNDER CONSTRUCTION
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
