package model;

public class UserBean {

  private String email;
  private String nome;
  private String cognome;
  private String sex;
  private String pass;
  private int tipo;
  
  /**
   * Costruttore bean Utente.
   */
  
  public UserBean(String email, String nome, String cognome, String sex, String pass, int tipo) {
    this.email = email;
    this.cognome = cognome;
    this.nome = nome;
    this.sex = sex;
    this.pass = pass;
    this.tipo = tipo;
  }
  
  public UserBean() {

  }

  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
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

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  public int getTipo() {
    return tipo;
  }

  public void setTipo(int tipo) {
    this.tipo = tipo;
  }

}
