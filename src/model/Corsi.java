package model;

public class Corsi {
	private int id, semestre, cfu;
	private String nome;
	
	public Corsi(int id, String nome, int semestre, int cfu) {
	this.id=id;
	this.nome=nome;
	this.semestre=semestre;
	this.cfu=cfu;
	}
	public Corsi() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
