package model;

import interfacce.UserInterface;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Request {
  private int idRequest;
  private int requestCfu;
  private String level;
  private GregorianCalendar releaseDate;
  private GregorianCalendar expireDate;
  private int validatedCfu;
  private int serial;
  private Year year = Year.of(1111);
  private List<Attached> attached = new ArrayList<>();
  State state;
  Ente ente;
  UserInterface user;
  static SimpleDateFormat sdf = new SimpleDateFormat("yyyy - MM - dd");

  public Request() {
  }

  /**
   * idRequest requestCfu level releaseDate expireDate validatedCfu serial year attached state ente
   * user Return Request.
   */

  public Request(int idRequest, int requestCfu, String level, GregorianCalendar releaseDate,
      GregorianCalendar expireDate, int validatedCfu, int serial, Year year,
      List<Attached> attached, State state, Ente ente, UserInterface user) {
    this.idRequest = idRequest;
    this.requestCfu = requestCfu;
    this.level = level;
    this.releaseDate = releaseDate;
    this.expireDate = expireDate;
    this.validatedCfu = validatedCfu;
    this.serial = serial;
    this.year = year;
    this.attached = attached;
    this.state = state;
    this.ente = ente;
    this.user = user;
  }

  public static SimpleDateFormat getSdf() {
    return sdf;
  }
  
  public void setSdf(SimpleDateFormat newSdf) {
    sdf = newSdf;
  }
  
  public int getIdRequest() {
    return idRequest;
  }

  public void setIdRequest(int idRequest) {
    this.idRequest = idRequest;
  }

  public int getRequestCfu() {
    return requestCfu;
  }

  public void setRequestCfu(int requestCfu) {
    this.requestCfu = requestCfu;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public GregorianCalendar getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(GregorianCalendar releaseDate) {
    this.releaseDate = releaseDate;
  }

  public GregorianCalendar getExpireDate() {
    return expireDate;
  }

  public void setExpireDate(GregorianCalendar expireDate) {
    this.expireDate = expireDate;
  }

  public int getValidatedCfu() {
    return validatedCfu;
  }

  public void setValidatedCfu(int validatedCfu) {
    this.validatedCfu = validatedCfu;
  }

  public int getSerial() {
    return serial;
  }

  public void setSerial(int serial) {
    this.serial = serial;
  }

  public Year getYear() {
    return year;
  }

  public void setYear(Year year) {
    this.year = year;
  }

  public List<Attached> getAttached() {
    return attached;
  }

  public void setAttached(List<Attached> attached) {
    this.attached = attached;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  public Ente getEnte() {
    return ente;
  }

  public void setEnte(Ente ente) {
    this.ente = ente;
  }

  public UserInterface getUser() {
    return user;
  }

  public void setUser(UserInterface user) {
    this.user = user;
  }

}
