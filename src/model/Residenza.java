package model;

public class Residenza {
  private String residenza;
  private String provincia;
  private String indirizzo;
  int cap;
  /**
   * Costruttore Residenza.
   */
  
  public Residenza(String residenza, String provincia, String indirizzo, int cap) {
    this.residenza = residenza;
    this.provincia = provincia;
    this.indirizzo = indirizzo;
    this.cap = cap;
  }

  public String getResidenza() {
    return residenza;
  }

  public void setResidenza(String residenza) {
    this.residenza = residenza;
  }

  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  public String getIndirizzo() {
    return indirizzo;
  }

  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }

  public int getCap() {
    return cap;
  }

  public void setCap(int cap) {
    this.cap = cap;
  }

  @Override
  public String toString() {
    return "Residenza [residenza=" + residenza + ", provincia=" + provincia + ", indirizzo=" 
       + indirizzo + ", cap=" + cap + "]";
  }
}
