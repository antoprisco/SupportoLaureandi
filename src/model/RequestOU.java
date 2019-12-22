package model;

import java.util.Date;

public class RequestOU {
	
	private String idSkill;
	private String email;
	Date dateOfBirth;
	String cellNumber;

	public RequestOU(String idSkill, String email, Date day, String cell) {
		this.idSkill=idSkill;
		this.email=email;
		this.dateOfBirth = day;
		this.cellNumber = cell;	
	}
	
	public RequestOU() { } 
	

	public String getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(String idSkill) {
		this.idSkill = idSkill;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}
	
}
