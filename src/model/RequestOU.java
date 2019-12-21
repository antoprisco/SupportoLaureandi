package model;

import java.sql.Date;

public class RequestOU {
	private int idSkill;
	private String email;
	Date dateOfBirth;
	String  cellNumber;

	public RequestOU(int idSkill, String email, Date day, String cell) {
		this.idSkill=idSkill;
		this.email=email;
		this.dateOfBirth = day;
		this.cellNumber = cell;	
	}
	
	public RequestOU() { }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(int idSkill) {
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
