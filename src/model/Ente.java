package model;

public class Ente {

  /**
   * Variables.
   */
  private int id;
  private String email;
  private String name;
  private String site;
  
  /**
   * Constructor.
   * @param idEnte is the identifier of the "Ente".
   * @param email is the address of the "Ente".
   * @param name is the name of the "Ente".
   * @param site is the URL of the site of the "Ente".
   */
  public Ente(int idEnte, String email, String name, String site) {
    this.id = idEnte;
    this.email = email;
    this.name = name;
    this.site = site;
  }
  
  /**
   * Empty Constructor.
   */
  public Ente() {}
  
  /**
   * Get the identifier number of the "Ente".
   */
  public int getIdEnte() {
    return id;
  }

  /**
   * Get the email of the "Ente".
   */
  public String getEmail() {
    return email;
  }

  /**
   * Get the name of the "Ente".
   */
  public String getName() {
    return name;
  }

  /**
   * Get the URL of the site.
   */
  public String getSite() {
    return site;
  }

  /**
   * Set the identifier of the "Ente".
   * @param idEnte is the iteger that identifies the "Ente".
   */
  public void setIdEnte(int idEnte) {
    this.id = idEnte;
  }
  
  /**
   * Set the email of the "Ente".
   * @param email is the address of the "Ente".
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Set the name of the "Ente".
   * @param name is the name of the "Ente".
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Set the URL of the site of the "Ente".
   * @param site is the URL link of the "Ente".
   */
  public void setSite(String site) {
    this.site = site;
  }

}
