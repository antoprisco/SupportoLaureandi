package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.DbConnection;

public class CorsiDAO {
  static final String TABLE_NAME = "corsi";
  /**
   * Query per recuperare tutti i corsi nel db.
   */
  
  public synchronized ArrayList<Corsi> doRetrieveAll() throws SQLException {
    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    ArrayList<Corsi> listBean = new ArrayList<Corsi>();
    String selectSQL = "SELECT * FROM " + CorsiDAO.TABLE_NAME+ "";
    try {
      preparedStatement = conn.prepareStatement(selectSQL,preparedStatement.RETURN_GENERATED_KEYS);
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
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					if (conn != null)
						conn.commit();
				}
			}
			return listBean;
		}
	 public synchronized ArrayList<Corsi> doRetrieveBySemestre(int s) throws SQLException {
		  	Connection conn = new DbConnection().getInstance().getConn();
			PreparedStatement preparedStatement = null;

			
			ArrayList<Corsi> listbean = new ArrayList<Corsi>();

			String selectSQL = "select * from " + CorsiDAO.TABLE_NAME + " where SEMESTRE = ?";
			

			try {
				//connection = DbConnection.getInstance().getConn();
				preparedStatement = conn.prepareStatement(selectSQL,preparedStatement.RETURN_GENERATED_KEYS);
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
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					if (conn != null)
						conn.commit();
				}
			}
			return listbean;
		}
	 public synchronized Corsi doRetrieveByID(int id) throws SQLException {
		  	Connection conn = new DbConnection().getInstance().getConn();
			PreparedStatement preparedStatement = null;

			
			//ArrayList<Corsi> listbean = new ArrayList<Corsi>();
			Corsi bean = new Corsi();

			String selectSQL = "select * from " + CorsiDAO.TABLE_NAME + " where id = ?";
			

			try {
				//connection = DbConnection.getInstance().getConn();
				preparedStatement = conn.prepareStatement(selectSQL,preparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(1, id);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					//Corsi bean = new Corsi();
									
					bean.setId(rs.getInt("id"));
					bean.setNome(rs.getString("nome"));
					bean.setSemestre(rs.getInt("semestre"));
					bean.setCfu(rs.getInt("cfu"));
					
					
					
				}

			} finally {
				try {
					if (preparedStatement != null)
						preparedStatement.close();
				} finally {
					if (conn != null)
						conn.commit();
				}
			}
			return bean;
		}
	
}

