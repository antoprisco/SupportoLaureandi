package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class Prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		RequestOU r= new RequestOU();
		RequestOUDAO rd= new RequestOUDAO();
		ArrayList<RequestOU> list= new ArrayList<RequestOU>();
		
		try {
			list=rd.doRetrieveByEmail("s.avolicino@studenti.unisa.it");
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i).getIdSkill());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	    
	   
	  
		
	   // ArrayList<RequestLM> ar= new ArrayList<RequestLM>();
	    
	
			
	    	
	

}
}
