package model;

import controller.DbConnection; 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

public class SystemAttribute {

  private HashMap<String, String> hashMap = new HashMap<String, String>();
  private static SystemAttribute instance;

  /**
   * Constructor.
   */
  public SystemAttribute() {
    Connection conn = new DbConnection().getInstance().getConn();
    if (conn != null) {

      try {
        Statement stmt = conn.createStatement();
        ResultSet r = stmt.executeQuery("SELECT slug, value FROM system_attribute");
        while (r.next()) {
          hashMap.put(r.getString("slug"), r.getString("value"));
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }      
      
    }    
  }

  public HashMap<String, String> getHashMap() {
    return hashMap;
  }

  public void setHashMap(HashMap<String, String> hashMap) {
    this.hashMap = hashMap;
  }

  /**
   * Returns the value to which the specified key is mapped, or null if this map contains no mapping
   * for the Key.
   * @param slug is the key of the hashmap
   * @return value associated to the slug.
   */
  public String getValueByKey(String slug) {
    return this.hashMap.get(slug);
  }
  
  /**
   * Method static and synchronized.
   * @return the instance of the singleton.
   */ 
  public static synchronized SystemAttribute getInstance() {
    if (instance == null) {
      instance = new SystemAttribute();
      System.out.println("SystemAtribue Class created ");
    }
    return instance;
  }

}
