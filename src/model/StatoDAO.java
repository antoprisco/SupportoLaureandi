package model;

import controller.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class StatoDAO {
  static final String TABLE_NAME = "state";
  /**
   * Query per selezionare lo stato delle richieste.
   */

  public synchronized Stato doRetrieveById(int id) throws SQLException {
    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    Stato bean = new Stato();
    String selectSQL = "select * from " + StatoDAO.TABLE_NAME + " where id_state = ?";
    try {
      //connection = DbConnection.getInstance().getConn();
      preparedStatement = conn.prepareStatement(selectSQL,preparedStatement.RETURN_GENERATED_KEYS);
      preparedStatement.setInt(1, id);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        //Stato bean = new Stato();
        bean.setId(rs.getInt("id_state"));
        bean.setDescr(rs.getString("description"));
        //listbean.add(bean);
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
