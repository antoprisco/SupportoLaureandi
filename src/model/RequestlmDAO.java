package model;

import com.mysql.jdbc.Statement;
import controller.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;


public class RequestlmDAO {

  static final String TABLE_NAME = "requestlm";
  /**
   * Query per inserire richieste in gestiste lm.
   */
  
  public synchronized int doSave(RequestLM r) throws SQLException {

    Connection connection = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    Integer idRequest = 0;
    String insertSQL = "insert into " + RequestlmDAO.TABLE_NAME
        + " (curriculum, anno, fk_user) values (?, ?, ?)";

    try {
      /*
   *                 Integer idRequest = 0;

                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                  idRequest = rs.getInt(1);
                }
                result = 1;
                rs.close();
              } else {
                error = "Impossibile presentare la richiesta.";
              }*/
      preparedStatement = connection.prepareStatement(insertSQL,
        + preparedStatement.RETURN_GENERATED_KEYS);
      
      preparedStatement.setString(1, r.getCurr());
      preparedStatement.setInt(2, r.getYear());
      preparedStatement.setString(3, r.getEmail());

      preparedStatement.executeUpdate();
      ResultSet rs = preparedStatement.getGeneratedKeys();
      if (rs.next()) {
        idRequest = rs.getInt(1);
      }
      
    } finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } finally {
        if (connection != null) {
          connection.commit();;
        }
      }
    }
    return idRequest;
  }

  public void doSaveSelection(RequestLM r) {
  }
  /**
   * Query per selezionare richieste in gestiste lm.
   */
  
  public synchronized ArrayList<RequestLM> doCountByYear(int anno) throws SQLException {
    ArrayList<RequestLM> listbean = new ArrayList<RequestLM>();
    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;

    String selectSQL = "select curriculum, COUNT(*) as count FROM ";
    selectSQL += RequestlmDAO.TABLE_NAME + " where anno = ? group by curriculum";

    try {
      //connection = DbConnection.getInstance().getConn();
      preparedStatement = conn.prepareStatement(selectSQL);
      preparedStatement.setInt(1, anno);

      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        RequestLM bean = new RequestLM();
        bean.setCurr(rs.getString("curriculum"));
        bean.setCount(rs.getInt("count"));
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
   * Query per cercare richieste gestite in lm.
   */
  
  public synchronized boolean doRetrieveByUser(String email) throws SQLException {
    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    boolean x = true;
    ArrayList<RequestLM> listbean = new ArrayList<RequestLM>();

    String selectSQL = "select * from " + RequestlmDAO.TABLE_NAME 
        + " where fk_user = ?";

    try {
      //connection = DbConnection.getInstance().getConn();
      preparedStatement = conn.prepareStatement(selectSQL,preparedStatement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, email);

      ResultSet rs = preparedStatement.executeQuery();
      x = rs.next();

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
    return x;
  }

  /**
   * Query per aggiornare richieste in gestiste lm.
   */
  
  public synchronized int doUpdate(RequestLM r) throws SQLException {

    Connection connection = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    Integer idRequest = 0;
    String insertSQL = "UPDATE " + RequestlmDAO.TABLE_NAME
        + " set curriculum = ? ,  anno = ? WHERE fk_user = ? ";
    System.err.println("STRINGA SQLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
    System.err.println(insertSQL);
    System.err.println(insertSQL);
    System.err.println(insertSQL);
    System.err.println(insertSQL);

    int x;

    try {

      preparedStatement = connection.prepareStatement(insertSQL,
        + preparedStatement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, r.getCurr());
      preparedStatement.setInt(2, r.getYear());
      preparedStatement.setString(3, r.getEmail());

      System.err.println(preparedStatement.toString());
      System.err.println(preparedStatement.toString());
      System.err.println(preparedStatement.toString());
      System.err.println(preparedStatement.toString());
      x = preparedStatement.executeUpdate();

    } finally {
      try {
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } finally {
        if (connection != null) {
          connection.commit();
        }
      }
    }
    return x;
  }
}