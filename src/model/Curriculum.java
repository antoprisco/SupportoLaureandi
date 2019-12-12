package model;

public class Curriculum {
	private int id;
	private String name;
	
	public Curriculum(int id, String name) {
		this.id=id;
		this.name=name;
	}
	public Curriculum() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
