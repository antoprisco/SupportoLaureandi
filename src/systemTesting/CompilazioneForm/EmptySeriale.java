package systemTesting.CompilazioneForm;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EmptySeriale {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  /**
   * Before.
   */
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testEmptySeriale() throws Exception {
    driver.get("http://localhost:8000/EnglishValidation/index.jsp");
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("x.x@studenti.unisa.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.xpath(
        "(.//*[normalize-space(text()) and normalize-space(.)='Login'])[3]/following::button[1]"))
        .click();
    driver.get("http://localhost:8000/EnglishValidation/_areaStudent/firstForm.jsp");
    driver.findElement(By.id("immatricolazione")).click();
    new Select(driver.findElement(By.id("immatricolazione"))).selectByVisibleText("2015/2016");
    driver.findElement(By.xpath(
        "(.//*[normalize-space(text()) and normalize-space(.)='Richiesta'])[1]/following::option[2]"))
        .click();
    driver.findElement(By.xpath(
        "(.//*[normalize-space(text()) and normalize-space(.)='Disconnetti'])[2]/following::div[11]"))
        .click();
    driver.findElement(By.id("ente")).click();
    new Select(driver.findElement(By.id("ente")))
        .selectByVisibleText("Educational Testing Service (ETS)");
    driver.findElement(By.xpath(
        "(.//*[normalize-space(text()) and normalize-space(.)='Ente di rilascio:'])[1]/following::option[4]"))
        .click();
    driver.findElement(By.xpath(
        "(.//*[normalize-space(text()) and normalize-space(.)='Disconnetti'])[2]/following::div[11]"))
        .click();
    driver.findElement(By.xpath(
        "(.//*[normalize-space(text()) and normalize-space(.)='CFU da Conseguire:'])[1]/following::button[1]"))
        .click();
  }
  
  /**
   * After.
   */
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
