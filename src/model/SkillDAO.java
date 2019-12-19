package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import com.mysql.jdbc.Statement;

import controller.DbConnection;
public class SkillDAO {

	
	static final String TABLE_NAME = "skill";
	

	  

	  
	  
	  
	  
	  public synchronized ArrayList<Skill> doRetrieveByID(int id) throws SQLException {
		  	Connection conn = new DbConnection().getInstance().getConn();
			PreparedStatement preparedStatement = null;

			
			ArrayList<Skill> listbean = new ArrayList<Skill>();

			String selectSQL = "select * from " + SkillDAO.TABLE_NAME + " where id_skill = ?";
			

			try {
				//connection = DbConnection.getInstance().getConn();
				preparedStatement = conn.prepareStatement(selectSQL,preparedStatement.RETURN_GENERATED_KEYS);
				preparedStatement.setInt(1, id);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					Skill bean = new Skill();
					bean.setId(rs.getInt("id_skill"));
					bean.setNome(rs.getString("nome"));
					bean.setTipo(rs.getInt("tipo"));
					bean.setLvl(rs.getString("livello"));
					
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
	  public synchronized ArrayList<Skill> doRetrieveAll() throws SQLException {
		  Connection conn = new DbConnection().getInstance().getConn();
			PreparedStatement preparedStatement = null;

			ArrayList<Skill> listBean = new ArrayList<Skill>();

			String selectSQL = "SELECT * FROM " + TABLE_NAME+ "";
			
			

			try {
				//connection = DbConnection.getInstance().getConn();
				preparedStatement = conn.prepareStatement(selectSQL,preparedStatement.RETURN_GENERATED_KEYS);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					Skill bean = new Skill();								
					bean.setId(rs.getInt("id_skill"));
					bean.setNome(rs.getString("nome"));
					bean.setTipo(rs.getInt("tipo"));
					bean.setLvl(rs.getString("livello"));
					
					
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
	
}