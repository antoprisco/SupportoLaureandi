package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controller.DbConnection;

public class GestisceCSDAO {
	static final String TABLE_NAME = "gestiscecs";
	public synchronized void doSave(GestisceCS g) throws SQLException {

		Connection connection = new DbConnection().getInstance().getConn();
		PreparedStatement preparedStatement = null;
		//Integer idRequest = 0;
		String insertSQL = "insert into " + GestisceCSDAO.TABLE_NAME
				+ " (fk_user, fk_reqcs) values (?, ?)";

		try {
			preparedStatement = connection.prepareStatement(insertSQL,preparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, g.getEmail());
			preparedStatement.setInt(2, g.getId());
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

}
