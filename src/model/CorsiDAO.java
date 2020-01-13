package model;

import controller.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CorsiDAO {
  static final String TABLE_NAME = "corsi";
  /**
   * Query per recuperare tutti i corsi nel db.
   */
  
  public synchronized ArrayList<Corsi> doRetrieveAll() throws SQLException {
    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    ArrayList<Corsi> listBean = new ArrayList<Corsi>();
    String selectSql = "SELECT * FROM " + CorsiDAO.TABLE_NAME + "";
    try {
      preparedStatement = conn.prepareStatement(selectSql,preparedStatement.RETURN_GENERATED_KEYS);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        Corsi bean = new Corsi();
        bean.setId(rs.getInt("id"));
        bean.setNome(rs.getString("nome"));
        bean.setSemestre(rs.getInt("semestre"));
        bean.setCfu(rs.getInt("cfu"));
        listBean.add(bean);
      }
    } finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } finally {
        if (conn != null) {
          conn.commit();
        }
      }
    }
    return listBean;
  }
  /**
   * Query per recuperare tutti i corsi nel db in base al semestre.
   */
  
  public synchronized ArrayList<Corsi> doRetrieveBySemestre(int s) throws SQLException {
    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    ArrayList<Corsi> listbean = new ArrayList<Corsi>();
    String selectSql = "select * from " + CorsiDAO.TABLE_NAME + " where SEMESTRE = ?";
    try {
      preparedStatement = conn.prepareStatement(selectSql,preparedStatement.RETURN_GENERATED_KEYS);
      preparedStatement.setInt(1, s);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        Corsi bean = new Corsi();
        bean.setId(rs.getInt("id"));
        bean.setNome(rs.getString("nome"));
        bean.setSemestre(rs.getInt("semestre"));
        bean.setCfu(rs.getInt("cfu"));
        listbean.add(bean);
      }
    } finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } finally {
        if (conn != null) {
          conn.commit();
        }
      }
    }
    return listbean;
  }
  /**
   * Query per recuperare tutti i corsi nel db in base all'id.
   */

  public synchronized Corsi doRetrieveByID(int id) throws SQLException {
    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    Corsi bean = new Corsi();
    String selectSql = "select * from " + CorsiDAO.TABLE_NAME + " where id = ?";
    try {
      preparedStatement = conn.prepareStatement(selectSql,preparedStatement.RETURN_GENERATED_KEYS);
      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        bean.setId(rs.getInt("id"));
        bean.setNome(rs.getString("nome"));
        bean.setSemestre(rs.getInt("semestre"));
        bean.setCfu(rs.getInt("cfu"));
      }
    } finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } finally {
        if (conn != null) {
          conn.commit();
        }
      }
    }
    return bean;
  }
}

