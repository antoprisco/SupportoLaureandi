package controller;

import interfacce.UserInterface;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Secretary;
import model.Student;



public class CheckSession implements Serializable {

  /**
   * Variables.
   */
  private static final long serialVersionUID = -6469233075067075161L;
  private String pageFolder;
  private String pageName;
  private String urlRedirect;
  private HttpSession session;
  private boolean allowed;

  /**
   * Constructor.
   */
  public CheckSession(String pf, String pn, HttpSession s) {
    this.pageFolder = pf;
    this.pageName = pn;
    this.session = s;
    this.urlRedirect = "/index.jsp";
  }

  /**
   * Get the Session.
   */
  public HttpSession getSession() {
    return this.session;
  }

  /**
   * Set the Session between client and server.
   * 
   * @param session is a sequence of network request-response transactions.
   */
  public void setSession(HttpSession session) {
    this.session = session;
  }

  /**
   * Get the URL.
   */
  public String getUrlRedirect() {
    return this.urlRedirect;
  }

  /**
   * Set the URL.
   * 
   * @param urlRedirect is a reference to a web resource that specifies its location on Internet.
   */
  public void setUrlRedirect(String urlRedirect) {
    this.urlRedirect = urlRedirect;
  }

  /**
   * Get the name of the web page.
   */
  public String getPageName() {
    return pageName;
  }

  /**
   * Set the name of the web page.
   * 
   * @param pageName is the name of the web page.
   */
  public void setPageName(String pageName) {
    this.pageName = pageName;
  }

  /**
   * Get the location folder of the page.
   */
  public String getPageFolder() {
    return pageFolder;
  }

  /**
   * Set the name of the location folder of the page.
   * 
   * @param pageFolder is the name of the folder that contains the page.
   */
  public void setPageFolder(String pageFolder) {
    this.pageFolder = pageFolder;
  }

  /**
   * Specifies if the user is allowed to see the page.
   */
  public boolean isAllowed() {
    this.setAllowed(false);
    UserInterface u = (UserInterface) this.session.getAttribute("user");
    if (u != null) {
      int userType = u.getUserType();

      if (userType == 0 && this.pageFolder.equals("_areaStudent")) {
        this.setAllowed(true); // Profilo Student

      } else if (userType == 1 && this.pageFolder.equals("_areaSecretary")) {
        this.setAllowed(true); // Profilo Secretary

      } else if (userType == 2 && this.pageFolder.equals("_areaAdmin")) {
        this.setAllowed(true); // Profilo Admin
      }
    }
    return allowed;
  }

  /**
   * Set the variable allowed.
   * 
   * @param allowed contains a boolean that specifies if the user is allowed to see the page.
   */
  public void setAllowed(boolean allowed) {
    this.allowed = allowed;
  }

}
