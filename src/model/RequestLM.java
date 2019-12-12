package model;

import java.time.Year;
import java.util.ArrayList;

public class RequestLM {
	private int id, idcurr;
	private int year;
	private String email;
	private String curr;
	
	
	public RequestLM(int id,String curr, int year, String email) {
		this.id=id;
		this.year=year;
		this.email=email;
		this.curr=curr;
	
	}


	public RequestLM() {
		this.id=0;
		this.year=0;
		this.email="";
		this.curr="";
	}
	public RequestLM(String curr, int year, String email) {
		this.id=+1;
		this.year=year;
		this.email=email;
		this.curr=curr;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCurr() {
		return curr;
	}


	public void setCurr(String curr) {
		this.curr = curr;
	}
	
	
}
