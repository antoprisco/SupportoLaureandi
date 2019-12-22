package model;

public class Skill {
	private int id;
	private String nome;
	private int tipo;
	private String lvl;
	
	public Skill(int id, String nome, int tipo, String livello) {
		this.id=id;
		this.nome=nome;
		this.tipo=tipo;
		this.lvl=livello;
		
	}

	public Skill() {
		this.nome="";
		this.tipo=-1;
		this.lvl="";
	}
	
	public Skill(String nome, int tipo, String livello) {
		this.nome = nome;
		this.tipo = tipo;
		this.lvl = livello;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getLvl() {
		return lvl;
	}

	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	
	
	
}
