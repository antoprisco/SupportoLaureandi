package testIntegrazione;



import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Test;

import controller.DbConnection;
import controller.ServletFormOU;
import interfacce.UserInterface;
import model.RequestOU;
import model.RequestOUDAO;
import model.Student;

class RequestOUTest{

	private RequestOU requestOU;
	private RequestOUDAO requestDAO;
	
	@Test
	void testRequestOUdoSave() throws SQLException{
		
		requestOU.setEmail("email");
		requestOU.setCellNumber("");
		requestOU.setDateOfBirth("");
		requestOU.setIdSkill(0);
		
		requestDAO = new RequestOUDAO();
		assertEquals(true, (requestDAO.doSave(requestOU)));
	}
	
	@Test
	void testRequestOUdoRetreiveById() throws SQLException{
		
//		requestOU.setEmail("email");
//		requestOU.setCellNumber("");
//		requestOU.setDateOfBirth("");
//		requestOU.setIdSkill(0);
//
//		
//		Connection con = (Connection) new DbConnection().getInstance().getConn();
//		PreparedStatement ps = null;
//
//		String sql = "INSERT INTO request_ou (fk_id_skill, fk_email, date_of_birth, cell_number) VALUES (?,?,?,?)";
//		ps = con.prepareStatement(sql);
//		ps.setInt(1, requestOU.getIdSkill());
//		ps.setString(2, requestOU.getEmail());
//		ps.setString(3, requestOU.getDateOfBirth());
//		ps.setString(4, requestOU.getCellNumber());
//		ps.executeUpdate();
		
		
		requestDAO = new RequestOUDAO();
		assertEquals(true, (!(requestDAO.doRetrieveByID(1).isEmpty())));
	}
	
	
	@Test
	void testRequestOUdoRetreiveByEmail() throws SQLException{
		
//		requestOU.setEmail("email");
//		requestOU.setCellNumber("");
//		requestOU.setDateOfBirth("");
//		requestOU.setIdSkill(0);
//
//		
//		Connection con = (Connection) new DbConnection().getInstance().getConn();
//		PreparedStatement ps = null;

//		String sql = "INSERT INTO request_ou (fk_id_skill, fk_email, date_of_birth, cell_number) VALUES (?,?,?,?)";
//		ps = con.prepareStatement(sql);
//		ps.setInt(1, requestOU.getIdSkill());
//		ps.setString(2, requestOU.getEmail());
//		ps.setString(3, requestOU.getDateOfBirth());
//		ps.setString(4, requestOU.getCellNumber());
//		ps.executeUpdate();
		
		
		requestDAO = new RequestOUDAO();
		assertEquals(true, (!(requestDAO.doRetrieveByEmail("email").isEmpty())));
	}
	
	@Test
	void testRequestOUdoRetreiveAll() throws SQLException{
		
//		requestOU.setEmail("email");
//		requestOU.setCellNumber("");
//		requestOU.setDateOfBirth("");
//		requestOU.setIdSkill(0);

		
//		Connection con = (Connection) new DbConnection().getInstance().getConn();
//		PreparedStatement ps = null;
//
//		String sql = "INSERT INTO request_ou (fk_id_skill, fk_email, date_of_birth, cell_number) VALUES (?,?,?,?)";
//		ps = con.prepareStatement(sql);
//		ps.setInt(1, requestOU.getIdSkill());
//		ps.setString(2, requestOU.getEmail());
//		ps.setString(3, requestOU.getDateOfBirth());
//		ps.setString(4, requestOU.getCellNumber());
//		ps.executeUpdate();
		
		
		requestDAO = new RequestOUDAO();
		assertEquals(true, (!(requestDAO.doRetrieveAll().isEmpty())));
	}
	
	@AfterClass
    public static void doYourOneTimeTeardown() throws SQLException {
		Connection con = (Connection) new DbConnection().getInstance().getConn();
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM request_ou WHERE id=0";
		ps = con.prepareStatement(sql);
		ps.executeUpdate();
    }    
}
