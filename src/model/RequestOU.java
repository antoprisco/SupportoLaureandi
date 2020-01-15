package model;

public class RequestOU {
  private int idSkill;
  private String email;
  String dateOfBirth;
  String cellNumber;
  /**
   * Costruttore richieste Orientamento Uscita.
   */
  
  public RequestOU(int idSkill, String email, String day, String cell) {
    this.idSkill = idSkill;
    this.email = email;
    this.dateOfBirth = day;
    this.cellNumber = cell;
  }

  public RequestOU() {

  } 

  public int getIdSkill() {
    return idSkill;
  }

  public void setIdSkill(int idSkill) {
    this.idSkill = idSkill;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getCellNumber() {
    return cellNumber;
  }

  public void setCellNumber(String cellNumber) {
    this.cellNumber = cellNumber;
  }

}
