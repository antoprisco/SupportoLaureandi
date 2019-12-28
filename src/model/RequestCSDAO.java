package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.DbConnection;

public class RequestCSDAO {
	
static final String TABLE_NAME = "requestCS";
	
	public synchronized void doSave(RequestCS r) throws SQLException {

		Connection connection = new DbConnection().getInstance().getConn();
		PreparedStatement preparedStatement = null;
		//Integer idRequest = 0;
		String insertSQL = "insert into " + RequestCSDAO.TABLE_NAME
				+ " (nome, cognome, fk_state) values (?, ?, ?)";

		try {
			preparedStatement = connection.prepareStatement(insertSQL,preparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, r.getNome());
			preparedStatement.setString(2, r.getCognome());
			preparedStatement.setInt(3, r.getStato());
			preparedStatement.executeUpdate();
            
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.commit();;
			}
		}
	}
	
	public synchronized ArrayList<RequestCS> doRetrieveByNC(String nome, String cognome) throws SQLException {
	  	Connection conn = new DbConnection().getInstance().getConn();
		PreparedStatement preparedStatement = null;

		
		ArrayList<RequestCS> listbean = new ArrayList<RequestCS>();

		String selectSQL = "select * from " + RequestCSDAO.TABLE_NAME + " where nome = ? and cognome=?";
		

		try {
			//connection = DbConnection.getInstance().getConn();
			preparedStatement = conn.prepareStatement(selectSQL,preparedStatement.RETURN_GENERATED_KEYS);
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
			if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (conn != null)
					conn.commit();
			}
		}
		return listbean;
	}
	
	public synchronized RequestCS doRetrieveByNCS(String nome, String cognome, int stato) throws SQLException {
	  	Connection conn = new DbConnection().getInstance().getConn();
		PreparedStatement preparedStatement = null;

		
		RequestCS bean = new RequestCS();

		String selectSQL = "select * from " + RequestCSDAO.TABLE_NAME + " where nome = ? and cognome=? and fk_state=?";
		

		try {
			//connection = DbConnection.getInstance().getConn();
			preparedStatement = conn.prepareStatement(selectSQL,preparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, cognome);
			preparedStatement.setInt(3, stato);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				//RequestCS bean = new RequestCS();
				bean.setId(rs.getInt("id"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setStato(rs.getInt("fk_state"));
				
				
				//listbean.add(bean);
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