package model;

public class Stato {
	private int id;
	private String descr;
	public Stato(int id, String descr) {
		this.id=id;
		this.descr=descr;
		
	}
	public Stato() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}

}
