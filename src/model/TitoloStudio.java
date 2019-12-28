package model;

import java.util.Date;

public class TitoloStudio {
	
	private String laurea, universita, lode;
	private int matricola, voto;
	private String dataL;

	public TitoloStudio(String laurea, String dataL, String universita, int matricola, int voto, String lode) {
		this.laurea=laurea;
		this.dataL=dataL;
		this.universita=universita;
		this.matricola=matricola;
		this.voto=voto;
		this.lode=lode;
	}

	public String getLaurea() {
		return laurea;
	}

	public void setLaurea(String laurea) {
		this.laurea = laurea;
	}

	public String getUniversita() {
		return universita;
	}

	public void setUniversita(String universita) {
		this.universita = universita;
	}

	public String getLode() {
		return lode;
	}

	public void setLode(String lode) {
		this.lode = lode;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public String getDataL() {
		return dataL;
	}

	public void setDataL(String dataL) {
		this.dataL = dataL;
	}

	@Override
	public String toString() {
		return "TitoloStudio [laurea=" + laurea + ", universita=" + universita + ", lode=" + lode + ", matricola="
				+ matricola + ", voto=" + voto + ", dataL=" + dataL + "]";
	}
	
}
