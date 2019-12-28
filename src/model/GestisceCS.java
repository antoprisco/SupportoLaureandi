package model;

public class GestisceCS {
	private String email;
	private int id;
	public GestisceCS(String email,int id) {
		this.email=email;
		this.id=id;
		
	}
	public GestisceCS() {}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
