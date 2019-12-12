package model;

public class State {

  /**
   * Variables.
   */
  private int idState;
  private String description;
  
  /**
   * Empty Constructor.
   */
  public State() {}
  
  /**
   * Constructor.
   * @param idState is the number that identifies the state.
   * @param description is a description of the state.
   */
  public State(int idState,String description) {
    this.idState = idState;
    this.description = description;
  }

  /**
   * Get the id code of the state.
   */
  public int getIdState() {
    return idState;
  }

  /**
   * Set the id code of the state.
   * @param idState is the number that identifies the state.
   */
  public void setIdState(int idState) {
    this.idState = idState;
  }

  /**
   * Get the description of the state.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Set the description of the state.
   * @param description is a description of the state.
   */
  public void setDescription(String description) {
    this.description = description;
  }
  
}
