package model;

import controller.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class RequestCSDAO {

  static final String TABLE_NAME = "requestCS";
  
  /**
   * Query per inserire richieste.
   */
  public synchronized void doSave(RequestCS r) throws SQLException {
    Connection connection = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    String insertSql = "insert into " + RequestCSDAO.TABLE_NAME
        + " (nome, cognome, fk_state) values (?, ?, ?)";
    try {
      preparedStatement = connection.prepareStatement(insertSql,
          preparedStatement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, r.getNome());
      preparedStatement.setString(2, r.getCognome());
      preparedStatement.setInt(3, r.getStato());
      preparedStatement.executeUpdate();
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
  }

  /**
   * Query per recuperare le richieste in base al nome e al cognome.
   */

  public synchronized ArrayList<RequestCS> doRetrieveByNC(String nome, String cognome) 
       throws SQLException {
    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    ArrayList<RequestCS> listbean = new ArrayList<RequestCS>();
    String selectSql = "select * from " + RequestCSDAO.TABLE_NAME + " where nome = ? and cognome=?";
    try {
      preparedStatement = conn.prepareStatement(selectSql,preparedStatement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, nome);
      preparedStatement.setString(2, cognome);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        RequestCS bean = new RequestCS();
        bean.setId(rs.getInt("id"));
        bean.setNome(rs.getString("nome"));
        bean.setCognome(rs.getString("cognome"));
        bean.setStato(rs.getInt("fk_state"));
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
   * Query per recuperare le richieste in base al nome, cognome e stato.
   */

  public synchronized RequestCS doRetrieveByNCS(String nome, String cognome, int stato) 
      throws SQLException {
    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    RequestCS bean = new RequestCS();
    String selectSql = "select * from " + RequestCSDAO.TABLE_NAME 
        + " where nome = ? and cognome=? and fk_state=?";
    try {
      preparedStatement = conn.prepareStatement(selectSql,preparedStatement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, nome);
      preparedStatement.setString(2, cognome);
      preparedStatement.setInt(3, stato);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        bean.setId(rs.getInt("id"));
        bean.setNome(rs.getString("nome"));
        bean.setCognome(rs.getString("cognome"));
        bean.setStato(rs.getInt("fk_state"));
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
  
  /**
   * Query per recuperare tutte le richieste.
   */

  public synchronized ArrayList<RequestCS> doRetrieveAll() throws SQLException {
    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    ArrayList<RequestCS> listaRichieste = new ArrayList<RequestCS>();
    String selectSql = "SELECT DISTINCT id, nome, cognome FROM " + TABLE_NAME + "";
    try {
      preparedStatement = conn.prepareStatement(selectSql,preparedStatement.RETURN_GENERATED_KEYS);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        RequestCS r = new RequestCS();
        r.setId(rs.getInt(1));
        r.setNome(rs.getString("nome"));
        r.setCognome(rs.getString("cognome"));
        listaRichieste.add(r);
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
    return listaRichieste;
  }
  
  /**
   * Query per recuperare tutte le richieste lato Admin.
   */

  public synchronized ArrayList<RequestCS> doRetrieveAdmin() throws SQLException {
    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    ArrayList<RequestCS> listaRichieste = new ArrayList<RequestCS>();
    String selectSql = "SELECT DISTINCT id, nome, cognome, fk_state FROM " 
         + TABLE_NAME + " WHERE fk_state BETWEEN 3 AND 5 ORDER BY fk_State DESC";
    try {
      preparedStatement = conn.prepareStatement(selectSql,preparedStatement.RETURN_GENERATED_KEYS);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        RequestCS r = new RequestCS();
        r.setId(rs.getInt(1));
        r.setNome(rs.getString("nome"));
        r.setCognome(rs.getString("cognome"));
        r.setStato(rs.getInt("fk_state"));
        listaRichieste.add(r);
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
    return listaRichieste;
  }
  /**
   * Query per recuperare tutte le richieste lato segreteria.
   */


  public synchronized ArrayList<RequestCS> doRetrieveAllSecretary() throws SQLException {
    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    ArrayList<RequestCS> listaRichieste = new ArrayList<RequestCS>();
    String selectSql = "SELECT DISTINCT id, nome, cognome FROM " 
        + RequestCSDAO.TABLE_NAME + "WHERE FK_STATE=2";
    try {
      preparedStatement = conn.prepareStatement(selectSql,preparedStatement.RETURN_GENERATED_KEYS);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        RequestCS r = new RequestCS();
        r.setId(rs.getInt(1));
        r.setNome(rs.getString("nome"));
        r.setCognome(rs.getString("cognome"));
        listaRichieste.add(r);
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
    return listaRichieste;
  }
  
  /**
   * Query per aggiornare lo stato della richiesta.
   */
  
  public synchronized void doUpdate(int stato, int id) throws SQLException {
    Connection connection = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    String UpdateSql = "UPDATE " + RequestCSDAO.TABLE_NAME
        + " set fk_state = ?  WHERE id = ? ";
    try {
      preparedStatement = connection.prepareStatement(UpdateSql,
          preparedStatement.RETURN_GENERATED_KEYS);
      preparedStatement.setInt(1, stato);
      preparedStatement.setInt(2, id);
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
  }
  
  /**
   * Query per cambiare il nome.
   */
  
  public synchronized void doChangeName(String newName, int id) throws SQLException {
    Connection connection = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    String sql = "UPDATE " + RequestCSDAO.TABLE_NAME + " SET NOME = ? WHERE ID = ?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, newName);
      preparedStatement.setInt(2, id);
      preparedStatement.executeUpdate();
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
  }
  
  /**
   * Query per cambiare il congnome.
   */

  public synchronized void doChangeSurname(String newSurname, int id) throws SQLException {
    Connection connection = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    String sql = "UPDATE " + RequestCSDAO.TABLE_NAME + " SET COGNOME = ? WHERE ID = ?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, newSurname);
      preparedStatement.setInt(2, id);
      preparedStatement.executeUpdate();
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
  }

  /**
   * Query per cambiare lo stato.
   */
  
  public synchronized void doChangeState(int state, int id) throws SQLException {
    Connection connection = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    String sql = "UPDATE " + RequestCSDAO.TABLE_NAME + " SET FK_STATE = ? WHERE ID = ?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, state);
      preparedStatement.setInt(2, id);
      preparedStatement.executeUpdate();
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
  }
  /**
   * Query per inoltrare la richiesta all'Admin.
   */
  
  public synchronized void doInoltraToAdmin(int id) throws SQLException {
    Connection connection = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    String sql = "UPDATE " + RequestCSDAO.TABLE_NAME + " SET FK_STATE = 3 WHERE ID = ?";
    try {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, id);
      preparedStatement.executeUpdate();
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
  }
  /**
   * Query per recuperare tutte le richieste accettate.
   */

  public synchronized ArrayList<RequestCS> doRetrieveAccettate() throws SQLException {
    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    ArrayList<RequestCS> listaRichieste = new ArrayList<RequestCS>();
    String selectSql = "SELECT DISTINCT id, nome, cognome, fk_state FROM " 
        + TABLE_NAME + " WHERE fk_state = 4 ";
    try {
      preparedStatement = conn.prepareStatement(selectSql,preparedStatement.RETURN_GENERATED_KEYS);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        RequestCS r = new RequestCS();
        r.setId(rs.getInt(1));
        r.setNome(rs.getString("nome"));
        r.setCognome(rs.getString("cognome"));
        r.setStato(rs.getInt("fk_state"));
        listaRichieste.add(r);
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
    return listaRichieste;
  }
  
  /**
   * Query per recuperare tutte le richieste rifiutate.
   */

  public synchronized ArrayList<RequestCS> doRetrieveRifiutate() throws SQLException {
    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    ArrayList<RequestCS> listaRichieste = new ArrayList<RequestCS>();
    String selectSql = "SELECT DISTINCT id, nome, cognome, fk_state FROM " 
        + TABLE_NAME + " WHERE fk_state = 5 ";
    try {
      preparedStatement = conn.prepareStatement(selectSql,preparedStatement.RETURN_GENERATED_KEYS);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        RequestCS r = new RequestCS();
        r.setId(rs.getInt(1));
        r.setNome(rs.getString("nome"));
        r.setCognome(rs.getString("cognome"));
        r.setStato(rs.getInt("fk_state"));
        listaRichieste.add(r);
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
    return listaRichieste;
  }
}

