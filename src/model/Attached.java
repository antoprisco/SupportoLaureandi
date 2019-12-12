package model;

public class Attached {

  /**
   * Variables.
   */
  private int idAttached;
  private String filename;
  
  /**
   * Empty Constructor.
   */
  public Attached() {}

  /**
   * Constructor.
   * @param idAttached represents a numeric identifier of the attached.
   * @param filename is the name of the attached.
   */
  public Attached(int idAttached, String filename) {
    this.idAttached = idAttached;
    this.filename = filename;
  }

  /**
   * Get the identifier of the Attached.
   */
  public int getIdAttached() {
    return idAttached;
  }

  /**
   * Set the identifier of the Attached.
   * @param idAttached is numeric identifier.
   */
  public void setIdAttached(int idAttached) {
    this.idAttached = idAttached;
  }

  /**
   * Get the name of the Attached.
   */
  public String getFilename() {
    return filename;
  }

  /**
   * Set the name of the Attached.
   * @param filename is the name of the Attached.
   */
  public void setFilename(String filename) {
    this.filename = filename;
  }

}
