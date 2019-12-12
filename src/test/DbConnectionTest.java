package test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import controller.DbConnection;

import org.junit.jupiter.api.Test;

public class DbConnectionTest {

  //Test Metodi GET
  
  @Test
  void testgetDatabaseName() {
    DbConnection db = new DbConnection();
    assertEquals("englishvalidation", db.getDatabaseName());
  }

  @Test
  void testgetUserName() {
    DbConnection db = new DbConnection();
    assertEquals("root", db.getUserName());
  }

  @Test
  void testgetPassword() {
    DbConnection db = new DbConnection();
    assertEquals("", db.getPassword());
  }

  @Test
  void testgetHostPort() {
    DbConnection db = new DbConnection();
    assertEquals(3306, db.getHostPort());
  }

  @Test
  void testgetHostName() {
    DbConnection db = new DbConnection();
    assertEquals("localhost", db.getHostName());
  }

  @Test
  void testgetConn() {
    DbConnection db = new DbConnection();
    assertNotEquals(null, db.getConn());
  }

  @Test
  void testgetInstance() {
    DbConnection db = DbConnection.getInstance();
    DbConnection db1 = DbConnection.getInstance();
    assertEquals(db, db1);
  }

  //Test Metodi SET
  
  @Test
  void testsetDatabaseName() {
    DbConnection db = new DbConnection();
    db.setDatabaseName("English Validation");
    assertEquals("English Validation", db.getDatabaseName());
  }

  @Test
  void testsetUserName() {
    DbConnection db = new DbConnection();
    db.setUserName("Luigi");
    assertEquals("Luigi", db.getUserName());
  }

  @Test
  void testsetPassword() {
    DbConnection db = new DbConnection();
    db.setPassword("password123");
    assertEquals("password123", db.getPassword());
  }

  @Test
  void testsetHostPort() {
    DbConnection db = new DbConnection();
    db.setHostPort(3306);
    assertEquals(3306, db.getHostPort());
  }

  @Test
  void testsetHostName() {
    DbConnection db = new DbConnection();
    db.setHostName("localhost");
    assertEquals("localhost", db.getHostName());
  }

  @Test
  void testsetConn() throws Exception {
    new DbConnection().setConn(null);
  }
}
