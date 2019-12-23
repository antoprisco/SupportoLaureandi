package model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import com.mysql.jdbc.Statement;

import controller.DbConnection;
public class RequestOUDAO {

	
	static final String TABLE_NAME = "request_ou";
	  
	  
	public synchronized boolean doSave(RequestOU r) throws SQLException {

		Connection con = (Connection) new DbConnection().getInstance().getConn();

		String sql = "INSERT INTO" + RequestOUDAO.TABLE_NAME + "(fk_id_skill, fk_email, date_of_birth, cell_number) VALUES (?,?,?,?)";
		boolean flag = true;

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, r.getIdSkill());
		ps.setString(2, r.getEmail());
		ps.setDate(3, (Date) r.getDateOfBirth());
		ps.setString(4, r.getCellNumber());


		try {	
			ps.executeUpdate();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}	
		
		return flag;
	}
	  
	  public synchronized ArrayList<RequestOU> doRetrieveByID(int id) throws SQLException {
		  	Connection conn = new DbConnection().getInstance().getConn();
			PreparedStatement preparedStatement = null;

			
			ArrayList<RequestOU> listbean = new ArrayList<RequestOU>();

			String selectSQL = "select * from " + RequestOUDAO.TABLE_NAME + " where fk_id_skill = ?";
			

			try {
				//connection = DbConnection.getInstance().getConn();
				preparedStatement = conn.prepareStatement(selectSQL,preparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(1, id);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					RequestOU bean = new RequestOU();
					bean.setIdSkill(rs.getInt("fk_id_skill"));
					bean.setEmail(rs.getString("fk_email"));
					bean.setDateOfBirth(rs.getDate("date_of_birth"));
					bean.setCellNumber(rs.getString("cell_number"));
								
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
	
	  public synchronized ArrayList<RequestOU> doRetrieveByEmail(String email) throws SQLException {
		  	Connection conn = new DbConnection().getInstance().getConn();
			PreparedStatement preparedStatement = null;

			
			ArrayList<RequestOU> listbean = new ArrayList<RequestOU>();

			String selectSQL = "select * from " + RequestOUDAO.TABLE_NAME + " where fk_email = ?";
			

			try {
				//connection = DbConnection.getInstance().getConn();
				preparedStatement = conn.prepareStatement(selectSQL,preparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, email);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					RequestOU bean = new RequestOU();
					bean.setIdSkill(rs.getInt("fk_id_skill"));
					bean.setEmail(rs.getString("fk_email"));
					bean.setDateOfBirth(rs.getDate("date_of_birth"));
					bean.setCellNumber(rs.getString("cell_number"));
					
					
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
	  public synchronized ArrayList<RequestOU> doRetrieveAll() throws SQLException {
		  Connection conn = new DbConnection().getInstance().getConn();
			PreparedStatement preparedStatement = null;

			ArrayList<RequestOU> listaReq = new ArrayList<RequestOU>();

			String selectSQL = "SELECT DISTINCT fk_email, date_of_birth, cell_number FROM " + TABLE_NAME+ "";
			
			try {
				//connection = DbConnection.getInstance().getConn();
				preparedStatement = conn.prepareStatement(selectSQL,preparedStatement.RETURN_GENERATED_KEYS);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					RequestOU bean = new RequestOU();
					
					//bean.setIdSkill(rs.getInt("fk_id_skill"));
					bean.setEmail(rs.getString("fk_email"));
					bean.setDateOfBirth(rs.getDate("date_of_birth"));
					bean.setCellNumber(rs.getString("cell_number"));
					
					listaReq.add(bean);							
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
			return listaReq;
		}	  
}