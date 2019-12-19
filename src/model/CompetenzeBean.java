package model;

import java.util.Date;

import interfacce.UserInterface;

public class CompetenzeBean {

	private UserInterface user;
	private Skill skill;
	private Date dataNascita;
	private String telefono;
	
	public CompetenzeBean(UserInterface user, Skill skill, Date dataNascita, String telefono) {
		this.user = user;
		this.skill = skill;
		this.dataNascita = dataNascita;
		this.telefono = telefono;
	}
	
	public CompetenzeBean() { }	

	public UserInterface getUser() {
		return user;
	}

	public void setUser(UserInterface user) {
		this.user = user;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	} 
}
