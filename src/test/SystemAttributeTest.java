package test;

import static org.hamcrest.CoreMatchers.is; 
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import controller.DbConnection;

import java.util.HashMap;
import java.util.Map;

import model.SystemAttribute;

import org.hamcrest.collection.IsMapContaining;

import org.junit.jupiter.api.Test;

public class SystemAttributeTest {
  
  @Test
  void testSystemAttributeCostructorEmpty() {
    SystemAttribute sy = new SystemAttribute();
    assertNotNull(sy);
  }

  @Test
  void testGetHashMap() {
    HashMap<String, String> expected = new HashMap<>();
    expected.put("request-accepted", "6");
    expected.put("request-allowed-extension-upload", ".pdf");
    expected.put("request-matriculation-year-range", "5");
    expected.put("request-max-cfu", "12");
    expected.put("request-min-cfu", "1");
    expected.put("request-number-max-upload", "2");
    expected.put("request-partially-completed", "1");
    expected.put("request-refused", "7");
    expected.put("request-upload-path", "C:\\Users\\Kugga\\Documents\\EV_EnglishValidation\\uploads");
    expected.put("request-working-admin", "3");
    expected.put("request-working-educational-advice-1", "4");
    expected.put("request-working-educational-advice-2", "5");
    expected.put("request-working-secretary", "2");

    SystemAttribute sa = new SystemAttribute();
    assertThat(expected, is(sa.getHashMap()));
    assertThat(sa.getHashMap().size(), is(13));
    assertThat(sa.getHashMap(), IsMapContaining.hasEntry("request-accepted", "6"));
    assertThat(sa.getHashMap(), not(IsMapContaining.hasEntry("aaa", "a")));
    assertThat(sa.getHashMap(), IsMapContaining.hasKey("request-partially-completed"));
    assertThat(sa.getHashMap(), IsMapContaining.hasValue("1"));
  }
  
  @Test
  void testSetHshMap() {
    HashMap<String, String> expected = new HashMap<>();
    expected.put("request-accepted", "6");
    expected.put("request-allowed-extension-upload", ".docx");
    expected.put("request-matriculation-year-range", "5");
    expected.put("request-max-cfu", "12");
    expected.put("request-min-cfu", "1");
    expected.put("request-number-max-upload", "2");
    expected.put("request-partially-completed", "1");
    expected.put("request-refused", "7");
    expected.put("request-upload-path", "C:\\Users\\Kugga\\Documents\\EV_EnglishValidation\\uploads");
    expected.put("request-working-admin", "3");
    expected.put("request-working-educational-advice-1", "4");
    expected.put("request-working-educational-advice-2", "5");
    expected.put("request-working-secretary", "2");
    SystemAttribute sa = new SystemAttribute();
    sa.setHashMap(expected);
    assertThat(expected, is(sa.getHashMap()));
  }
  
  @Test
  void testGetValueByKey() {
    SystemAttribute sa = new SystemAttribute();
    assertEquals("6", sa.getValueByKey("request-accepted"));
    assertEquals(".pdf", sa.getValueByKey("request-allowed-extension-upload"));
    assertEquals("5", sa.getValueByKey("request-matriculation-year-range"));
    assertEquals("12", sa.getValueByKey("request-max-cfu"));
    assertEquals("1", sa.getValueByKey("request-min-cfu"));
    assertEquals("2", sa.getValueByKey("request-number-max-upload"));
    assertEquals("1", sa.getValueByKey("request-partially-completed"));
    assertEquals("7", sa.getValueByKey("request-refused"));
    assertEquals("C:\\Users\\Kugga\\Documents\\EV_EnglishValidation\\uploads", sa.getValueByKey("request-upload-path"));
    assertEquals("3", sa.getValueByKey("request-working-admin"));
    assertEquals("4", sa.getValueByKey("request-working-educational-advice-1"));
    assertEquals("5", sa.getValueByKey("request-working-educational-advice-2"));
    assertEquals("2", sa.getValueByKey("request-working-secretary"));
  }

  
  @Test
  void testGetInstance() {
    SystemAttribute sa = SystemAttribute.getInstance();
    SystemAttribute sa1 = SystemAttribute.getInstance();
    assertEquals(sa, sa1);
  }

}
