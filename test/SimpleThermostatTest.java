import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;


/**
 * SimpleThermostat test class for implementation.
 */
public class SimpleThermostatTest {
  private Thermostat simpleThermostat;

  @Before
  public void setUp() {
    simpleThermostat = new SimpleThermostat("2d", 49.054);
  }

  @Test
  public void getID() {
    assertEquals("2d", simpleThermostat.getID());
  }

  @Test
  public void testNullID() {
    assertThrows(IllegalArgumentException.class, () -> new SimpleThermostat("", 49.054));
  }

  @Test
  public void getSetTemperature() {
    assertEquals(322.204, simpleThermostat.getSetTemperature(), 0.5);
  }

  @Test
  public void increaseSetTemperature() {
    simpleThermostat.increaseSetTemperature();
    assertEquals(322.304, simpleThermostat.getSetTemperature(), 0);
  }

  @Test
  public void decreaseSetTemperature() {
    simpleThermostat.decreaseSetTemperature();
    assertEquals(322.104, simpleThermostat.getSetTemperature(), 0);
  }

  @Test
  public void testEquals() {
    Thermostat simpleThermostat = new SimpleThermostat("2d", 49.054);
    Thermostat simpleThermostat2 = new SimpleThermostat("2d", 49.049);
    assertEquals(simpleThermostat, simpleThermostat2);
    assertTrue(simpleThermostat.equals(simpleThermostat2));
  }

  @Test
  public void testNotEqualsInequalTemperature() {
    Thermostat simpleThermostat = new SimpleThermostat("2d", 49.058);
    Thermostat simpleThermostat2 = new SimpleThermostat("2d", 49.049);
    assertNotEquals(simpleThermostat, simpleThermostat2);
  }

  @Test
  public void testNotEqualsInequalId() {
    Thermostat simpleThermostat = new SimpleThermostat("2d", 49.054);
    Thermostat simpleThermostat2 = new SimpleThermostat("2d0", 49.049);
    assertNotEquals(simpleThermostat, simpleThermostat2);
  }

  @Test
  public void testNotEqualsCaseSensitiveId() {
    Thermostat simpleThermostat = new SimpleThermostat("2d", 49.054);
    Thermostat simpleThermostat2 = new SimpleThermostat("2D", 49.049);
    assertNotEquals(simpleThermostat, simpleThermostat2);
  }

  @Test
  public void testEqualHashCode() {
    Thermostat simpleThermostat2 = new SimpleThermostat("2d", 49.054);
    assertEquals(simpleThermostat.hashCode(), simpleThermostat2.hashCode());
  }

  @Test
  public void testRoundedHashCode() {
    Thermostat simpleThermostat2 = new SimpleThermostat("2d", 49.049);
    assertEquals(simpleThermostat.hashCode(), simpleThermostat2.hashCode());
  }

  @Test
  public void testException() {
    assertThrows(IllegalArgumentException.class, () -> new SimpleThermostat("3df", 51));
  }

}