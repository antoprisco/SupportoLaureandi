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

import model.*;
import java.sql.SQLException;

/**
 * Servlet implementation class ServletViewReqOU
 */
@WebServlet("/ServletViewReqOU")
public class ServletViewReqOU extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletViewReqOU() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
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
	    ArrayList<String> nome=new ArrayList<String>();
	    ArrayList<String> cognome= new ArrayList<String>();
	   	if(Integer.parseInt(request.getParameter("flag"))==1) {
	   		
	   		RequestOU r= new RequestOU();
			RequestOUDAO rd= new RequestOUDAO();
			ArrayList<RequestOU> list= new ArrayList<RequestOU>();
		try{
			list=rd.doRetrieveAll();
			if(!list.isEmpty()) {
				result=1;
				for(RequestOU rq:list) {
					UserBean u= new UserBean();
					UserBeanDAO ud= new UserBeanDAO();
					u=ud.doRetrieveByEmail(rq.getEmail());
					nome.add(u.getNome());
					cognome.add(u.getCognome());
					Skill s= new Skill();
					SkillDAO sd= new SkillDAO();
					ArrayList<Skill> listaskill= new ArrayList<Skill>();
					listaskill=sd.doRetrieveAll();
					list=rd.doRetrieveByEmail(rq.getEmail());
					
					content+= "<tr>";
					content+="<td>"+u.getCognome()+" "+ u.getNome()+"&emsp;&emsp;<button>Visualizza</button>";
					content+="<div class='b'> data di nascita: <b>"+ rq.getDateOfBirth()+" </b><br>E-Mail: <b>"+ u.getEmail()+ "</b>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;Telefono: <b>"+ rq.getCellNumber()+"</b><br>";
					content+="<br>Competenze<br>";
					for(RequestOU rou:list) {
						for(Skill skil: listaskill) {
							if(rou.getIdSkill()==skil.getId()) {
								
								content+="<li> "+ skil.getNome()+"<b>";
								if(skil.getTipo()==0) {
									if(skil.getLvl().equals("1")) content+=": Livello basso <br>";
									if(skil.getLvl().equals("2")) content+=": Livello medio <br>";
									if(skil.getLvl().equals("3")) content+=": Livello alto <br>";
									
								}
								if(skil.getTipo()==1) content+="<br>";
								if(skil.getTipo()==2) content+=": Livello "+skil.getLvl()+"<br>";
							content+=" </b>";
								
								
							}
					}
					}
					content+="</div>";
					
					
					
					
					content+="</td>";
					content+="</tr>";
				}
				
			}
			
			
		
			
	}catch(SQLException e) {
		// TODO Auto-generated catch block
		error="errore database";
		e.printStackTrace();
	}

}
	   	JSONObject res= new JSONObject();
	   	res.put("result", result);
	    res.put("error", error);
	    res.put("content", content);
	    res.put("redirect", redirect);
	    res.put("nome", nome);
	    res.put("cognome",cognome);
	    PrintWriter out = response.getWriter();
	    out.println(res);
	    response.setContentType("json");
	    System.err.println(res.toString());
	}
}
