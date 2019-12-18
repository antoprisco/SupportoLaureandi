package model;

public class RequestOU {
private int idSkill;
private String email;
	public RequestOU(int idSkill, String email) {
		this.idSkill=idSkill;
		this.email=email;
		
	}
	
	public RequestOU() {
		
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
	
	
	
}
