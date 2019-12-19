package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import controller.DbConnection;
import interfacce.UserInterface;

public class CompetenzeBeanDAO {

	// Salvataggio richiesta nel database
	
	public synchronized int doSave(CompetenzeBean cb) throws SQLException {

		Connection con = (Connection) new DbConnection().getInstance().getConn();
		String sql = "INSERT INTO REQUEST_OU (FK_ID_SKILL, FK_EMAIL) VALUES (?,?)";

		PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		ps.setInt(1, cb.getSkill().getId());
		ps.setString(2, cb.getUser().getEmail());

		try {	
			ps.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
	}
}
