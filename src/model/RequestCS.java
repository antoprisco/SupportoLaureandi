package model;

public class RequestCS {
  private int id;
  private int stato;
  private String nome;
  private String cognome;
  
  /**
   * Costruttore richieste corsi singoli.
   */
  
  public RequestCS(String nome, String cognome, int stato) {
    this.nome = nome;
    this.cognome = cognome;
    this.stato = stato;
  }
  
  public RequestCS() {
    this.id = -1;
    this.nome = "";
    this.cognome = "";
    this.stato = 0;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }

  public int getStato() {
    return stato;
  }

  public void setStato(int stato) {
    this.stato = stato;
  }

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
}
