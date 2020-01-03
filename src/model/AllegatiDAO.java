package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.DbConnection;

public class AllegatiDAO {
	
	static final String TABLE_NAME = "allegati";
	public synchronized void doSave(Allegati a) throws SQLException {

		Connection connection = new DbConnection().getInstance().getConn();
		PreparedStatement preparedStatement = null;
		//Integer idRequest = 0;
		String insertSQL = "insert into " + AllegatiDAO.TABLE_NAME
				+ " (filename,fk_user, fk_reqcs) values (?, ?, ?)";

		try {
			preparedStatement = connection.prepareStatement(insertSQL,preparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, a.getFilename());
			preparedStatement.setString(2, a.getEmail());
			preparedStatement.setInt(3, a.getIdReq());
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
	
	public synchronized ArrayList<Allegati> doRetrievebyReq(String email, int id) throws SQLException {
	  	Connection conn = new DbConnection().getInstance().getConn();
		PreparedStatement preparedStatement = null;

		int i=0;
		ArrayList<Allegati> listbean = new ArrayList<Allegati>();

		String selectSQL = "select * from " + AllegatiDAO.TABLE_NAME + " where fk_user=? and fk_reqcs=?";
		
		
		
		try {
			//connection = DbConnection.getInstance().getConn();
			
			preparedStatement = conn.prepareStatement(selectSQL,preparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Allegati bean = new Allegati();
				bean.setId(rs.getInt("id"));
				bean.setFilename(rs.getString("filename"));
				bean.setEmail(rs.getString("fk_user"));
				bean.setId(rs.getInt("fk_reqcs"));
				
				
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
		return  listbean;
	}

}
