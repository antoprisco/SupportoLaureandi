package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.DbConnection;

public class UserBeanDAO {

	
	static final String TABLE_NAME = "user";
	  
	
	  public synchronized UserBean doRetrieveByEmail(String email) throws SQLException {
		  	Connection conn = new DbConnection().getInstance().getConn();
			PreparedStatement preparedStatement = null;

			
			UserBean bean = new UserBean();

			String selectSQL = "select * from " + UserBeanDAO.TABLE_NAME + " where email = ?";
			

			try {
				//connection = DbConnection.getInstance().getConn();
				preparedStatement = conn.prepareStatement(selectSQL,preparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setString(1, email);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					
					bean.setEmail(rs.getString("email"));
					bean.setNome(rs.getString("name"));
					bean.setCognome(rs.getString("surname"));
					bean.setSex(rs.getString("sex"));
					bean.setPass(rs.getString("password"));
					bean.setTipo(rs.getInt("user_type"));
				
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