package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class Prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		RequestLM r= new RequestLM("SICUREZZA",2023,"s.avolicino@studenti.unisa.it");
		RequestlmDAO rdd= new RequestlmDAO();
		try {
			rdd.doSave(r);
			System.out.println("Inserimento effettuato");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	    RequestlmDAO rd= new RequestlmDAO();
	    ArrayList<RequestLM> ar= new ArrayList<RequestLM>();
	    
	    try {
			ar=rd.doRetrieveByYear(2020);
			for (int i=0; i<ar.size();i++) {
			System.out.println(ar.get(i).getId() + "    "+ ar.get(i).getCurr() );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	   
	    
	   
	  
		
	   // ArrayList<RequestLM> ar= new ArrayList<RequestLM>();
	    
	
			
	    	
	

}
}
