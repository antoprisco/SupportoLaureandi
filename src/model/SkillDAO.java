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
	  
	  public synchronized boolean checkIfExists(int id) throws SQLException {
		  
		  Connection conn = new DbConnection().getInstance().getConn();
		  boolean flag = false;
		  
		  String sql = "SELECT * FROM " + this.TABLE_NAME + "WHERE ID_SKILL = ?";
		  PreparedStatement ps = conn.prepareStatement(sql);
		  ps.setInt(1, id);
		  
		  ResultSet rs = ps.executeQuery();
		  
		  while(rs.next()) {
			  flag = true;
		  }
		  
		  return flag;	  
	  }
	  
	  public synchronized int doSave(Skill s) throws SQLException {
		  
		  Connection conn = new DbConnection().getInstance().getConn();
		  PreparedStatement ps = null;
		  Integer id = 0;
		  
		  String sql = "INSERT INTO TABLE " + this.TABLE_NAME + "(ID_SKILL, NOME, TIPO, LIVELLO) VALUES (?,?,?,?)";
		  ps = conn.prepareStatement(sql, ps.RETURN_GENERATED_KEYS);
		  
		  ps.setInt(1, s.getId());
		  ps.setString(2, s.getNome());
		  ps.setInt(3, s.getTipo());
		  ps.setString(4, s.getLvl());
		  
		  ps.executeUpdate(sql);
		  
		  ResultSet rs = ps.getGeneratedKeys();
          if (rs.next()) {
            id = rs.getInt(1);
          }          
          return id;
	  }
	  
	  public synchronized int doRetrieveByData(Skill s) throws SQLException {
		  
		  Connection conn = new DbConnection().getInstance().getConn();
		  PreparedStatement ps = null;
		  Integer id = 0;
		  
		  String sql = "SELECT ID_SKILL FROM " + this.TABLE_NAME + "WHERE NOME = ?, TIPO = ?, LIVELLO = ?";
		  ps = conn.prepareStatement(sql);
		  ResultSet rs = ps.executeQuery(sql);
		  
		  while(rs.next()) {
			  id = rs.getInt(1);
		  }
		  
		  return id;
	  }
}