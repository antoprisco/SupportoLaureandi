package model;

import interfacce.UserInterface;

public class Secretary implements UserInterface {

  public String email;
  private String name;
  private String surname;
  private char sex;
  private String password;
  private int userType;

  public Secretary() {}

  /**
   * email name surname sex password userType Return object Secretary.
   */

  public Secretary(String email, String name, String surname, char sex, String password,
      int userType) {
    this.email = email;
    this.name = name;
    this.surname = surname;
    this.sex = sex;
    this.password = password;
    this.userType = userType;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getSurname() {
    return surname;
  }

  @Override
  public char getSex() {
    return sex;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public int getUserType() {
    return userType;
  }

  @Override
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setSurname(String surname) {
    this.surname = surname;
  }

  @Override
  public void setSex(char sex) {
    this.sex = sex;
  }

  @Override
  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public void setUserType(int userType) {
    this.userType = userType;
  }

  @Override
  public boolean validate() {
    return new Stub().database.containsKey(getEmail())
        && new Stub().database.containsValue(getPassword());
  }
}
