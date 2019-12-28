package model;

public class Allegati {
	private int id, idReq;
	private String filename, email;
	
public Allegati(String filename, String email, int idReq) {
	this.filename=filename;
	this.email=email;
	this.idReq=idReq;
		
	}
public Allegati() {};

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getIdReq() {
	return idReq;
}
public void setIdReq(int idReq) {
	this.idReq = idReq;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


}
