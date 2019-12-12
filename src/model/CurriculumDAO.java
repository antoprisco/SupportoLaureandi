package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import controller.DbConnection;


public class CurriculumDAO {

	
	static final String TABLE_NAME = "curriculum";
	

	
	public synchronized Curriculum doRetrieveByName(String name) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Curriculum bean = new Curriculum();

		String selectSQL = "select * from " + CurriculumDAO.TABLE_NAME + " where name = ?";

		try {
			connection = DbConnection.getInstance().getConn();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, name);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setId(rs.getInt("id_curr"));
				bean.setName(rs.getString("name"));
				
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return bean;
	}
	
	public synchronized Curriculum doRetrieveByID(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Curriculum bean = new Curriculum();

		String selectSQL = "select * from " + CurriculumDAO.TABLE_NAME + " where id_curr = ?";

		try {
			connection = DbConnection.getInstance().getConn();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setId(rs.getInt("id_curr"));
				bean.setName(rs.getString("name"));
				
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return bean;
	}
	
	
	public synchronized ArrayList<Curriculum> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<Curriculum> curr = new ArrayList<Curriculum>();

		String selectSQL = "SELECT * FROM curriculum";
		
		

		try {
			connection = DbConnection.getInstance().getConn();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Curriculum bean = new Curriculum();
				
				bean.setId(rs.getInt("id_curr"));
				bean.setName(rs.getString("name"));
				
				curr.add(bean);
				
				
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return curr;
	}
	
	}