package model;

import controller.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GestisceCSDAO {
  static final String TABLE_NAME = "gestiscecs";
  
  /**
   * Query per inserire richieste in gestiste cs.
   */
  
  public synchronized void doSave(GestisceCS g) throws SQLException {
    Connection connection = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    String insertSql = "insert into " + GestisceCSDAO.TABLE_NAME
        + " (fk_user, fk_reqcs) values (?, ?)";
    try {
      preparedStatement = connection.prepareStatement(insertSql,
         preparedStatement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, g.getEmail());
      preparedStatement.setInt(2, g.getId());
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
   * Query per recuperare le richieste mediante l'id.
   */

  public synchronized GestisceCS doRetrieveByReq(int id) throws SQLException {
    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    GestisceCS bean = new GestisceCS();
    String selectSql = "select * from " + GestisceCSDAO.TABLE_NAME + " where fk_reqcs = ? ";
    try {
      preparedStatement = conn.prepareStatement(selectSql,preparedStatement.RETURN_GENERATED_KEYS);
      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        bean = new GestisceCS(rs.getString("fk_user"), rs.getInt("fk_reqcs"));
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
