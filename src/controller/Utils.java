package controller;

import interfacce.UserInterface;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.HttpSession;
import model.SystemAttribute;

public class Utils {
  public Utils() {}

  /**
   * Exposes the function to encrypt the password.
   * 
   * @param passwordToHash is the password to be encrypted.
   * @return the encrypted password.
   */
  public String generatePwd(String passwordToHash) {
    String generatedPassword = null;
    String salt = "englishvalidation";
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-1");
      md.update(salt.getBytes(StandardCharsets.UTF_8));
      byte[] bytes = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < bytes.length; i++) {
        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
      }
      generatedPassword = sb.toString();
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
    return generatedPassword;
  }

  /**
   * method getRequestState.
   * @param idRequest id request
   * @return idState
   */
  public Integer getRequestState(Integer idRequest) {
    Integer idState = 0;
    Connection conn = new DbConnection().getInstance().getConn();
    if (conn != null) {
      try {
        PreparedStatement stmt =
            conn.prepareStatement("SELECT fk_state FROM request WHERE id_request = ?");
        stmt.setInt(1, idRequest);
        ResultSet r = stmt.executeQuery();
        if (!r.wasNull()) {
          r.next();
          idState = r.getInt("fk_state");
        }
      } catch (Exception e) {
        idState = 0;
        System.out.println(e.getMessage());
      }
    }

    return idState;
  }

  /**
   * method getLastUserRequestPartiallyCompleted.
   * @param s session.
   * @return idRequest
   */
  public Integer getLastUserRequestPartiallyCompleted(HttpSession s) {
    Integer idRequest = 0;
    Connection conn = new DbConnection().getInstance().getConn();
    if (conn != null) {
      try {
        UserInterface user = (UserInterface) s.getAttribute("user");

        PreparedStatement stmt = conn
            .prepareStatement("SELECT id_request FROM request WHERE fk_user = ? AND fk_state = ?");
        stmt.setString(1, user.getEmail());
        stmt.setInt(2,
            Integer.parseInt(new SystemAttribute().getValueByKey("request-partially-completed")));
        ResultSet r = stmt.executeQuery();
        if (!r.wasNull()) {
          r.next();
          idRequest = r.getInt("id_request");
        }
      } catch (Exception e) {
        idRequest = 0;
      }
    }

    return idRequest;
  }

}
