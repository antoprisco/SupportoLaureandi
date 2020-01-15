
package model;

import com.mysql.jdbc.Statement;
import controller.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class SkillDAO {


  static final String TABLE_NAME = "skill";

  /**
   * Query per selezionare skill gestite cs.
   */
  public synchronized ArrayList<Skill> doRetrieveByID(int id) throws SQLException {

    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    ArrayList<Skill> listbean = new ArrayList<Skill>();
    String selectSql = "select * from " + SkillDAO.TABLE_NAME + " where id_skill = ?";
    try {
      //connection = DbConnection.getInstance().getConn();
      preparedStatement = conn.prepareStatement(selectSql,preparedStatement.RETURN_GENERATED_KEYS);
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
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } finally {
        if (conn != null) {
          conn.commit();
        }
      }
    }
    return listbean;
  }

  /**
   * Query per selezionare tutte skill gestite cs.
   */
  public synchronized ArrayList<Skill> doRetrieveAll() throws SQLException {

    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement preparedStatement = null;
    ArrayList<Skill> listBean = new ArrayList<Skill>();
    String selectSql = "SELECT * FROM " + TABLE_NAME + "";
    try {
      //connection = DbConnection.getInstance().getConn();
      preparedStatement = conn.prepareStatement(selectSql,preparedStatement.RETURN_GENERATED_KEYS);
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
        if (preparedStatement != null) {
          preparedStatement.close();
        }
      } finally {
        if (conn != null) {
          conn.commit();
        }
      }
    }
    return listBean;
  }

  /**
   * Query per inserire skill gestiste cs.
   */

  public synchronized int doSave(Skill s) throws SQLException {

    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement ps = null;
    String sql = null;
    Integer id = 0;

    if (s.getTipo() == 1) {
      sql = "INSERT INTO " + this.TABLE_NAME + "(NOME, TIPO, LIVELLO) VALUES (?,?,?)";
      ps = conn.prepareStatement(sql, ps.RETURN_GENERATED_KEYS);
      System.out.println(s.getNome());
      ps.setString(1, s.getNome());
      ps.setInt(2, s.getTipo());
      ps.setString(3, "");
    } else if (s.getTipo() == 0) {
      
      sql = "INSERT INTO " + this.TABLE_NAME + "(ID_SKILL, NOME, TIPO, LIVELLO) VALUES (?,?,?,?)";
      ps = conn.prepareStatement(sql, ps.RETURN_GENERATED_KEYS);
      ps.setInt(1, s.getId());
      ps.setString(2, s.getNome());
      ps.setInt(3, s.getTipo());
      ps.setString(4, String.valueOf(s.getLvl().charAt(0)));

    } else {
      sql = "INSERT INTO " + this.TABLE_NAME + "(ID_SKILL, NOME, TIPO, LIVELLO) VALUES (?,?,?,?)";
      ps = conn.prepareStatement(sql, ps.RETURN_GENERATED_KEYS);
      ps.setInt(1, s.getId());
      ps.setString(2, s.getNome());
      ps.setInt(3, s.getTipo());
      ps.setString(4, s.getLvl());
    }

    try {
      ps.executeUpdate();
      ResultSet rs = ps.getGeneratedKeys();
      if (rs.next()) {
        id = rs.getInt(1);
      }          
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (ps != null) {
          ps.close();
        }
      } finally {
        if (conn != null) {
          conn.commit();
        }
      }
    }
    return id;
  }

  /**
   * Query per selezionare skill gestiste cs.
   */

  public synchronized int doRetrieveByData(Skill s) throws SQLException {

    Connection conn = new DbConnection().getInstance().getConn();
    PreparedStatement ps = null;
    String sql = null;
    Integer id = 0;

    if (s.getTipo() == 1) {
      sql = "SELECT ID_SKILL FROM " + this.TABLE_NAME + " WHERE NOME = ? AND TIPO = ?";
      ps = conn.prepareStatement(sql);
      ps.setString(1, s.getNome());
      ps.setInt(2, s.getTipo());
    } else if (s.getTipo() == 0) {
      sql = "SELECT ID_SKILL FROM " + this.TABLE_NAME 
        + " WHERE NOME = ? AND TIPO = ? AND LIVELLO = ?";
      ps = conn.prepareStatement(sql);
      ps.setString(1, s.getNome());
      ps.setInt(2, s.getTipo());
      ps.setString(3, String.valueOf(s.getLvl().charAt(0)));
    } else {
      sql = "SELECT ID_SKILL FROM " + this.TABLE_NAME 
        + " WHERE NOME = ? AND TIPO = ? AND LIVELLO = ?";
      ps = conn.prepareStatement(sql);
      ps.setString(1, s.getNome());
      ps.setInt(2, s.getTipo());
      ps.setString(3, s.getLvl());
    }

    ResultSet rs;
    try {
      rs = ps.executeQuery();

      while (rs.next()) {
        id = rs.getInt("ID_SKILL");
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (ps != null) {
          ps.close();
        }
      } finally {
        if (conn != null) {
          conn.commit();
        }
      }
    }
    return id;
  }
}