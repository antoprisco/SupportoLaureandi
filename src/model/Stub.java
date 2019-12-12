package model;

import java.util.HashMap;

public class Stub {
  HashMap<String, String> database;
  Student st = new Student("aaa@sss.it", "","",'x',"hhh",0);
  Student st2 = new Student("xxx", "","",'t',"",1);
  Secretary sc = new Secretary("zzz@lif.it", "","",'f', "qqq", 1);
  Secretary sc2 = new Secretary("qweqr@lif.it", "","",'f', "rrr", 1);
  
  /** 
   * list
   * Return virtual database.
   */
  
  public Stub() {
    database = new HashMap<>();
    database.put(st.getEmail(), st.getPassword());
    database.put(st2.getEmail(), st2.getPassword());
    database.put(sc.getEmail(), sc.getPassword());
    database.put(sc2.getEmail(), sc2.getPassword());
  }
}
