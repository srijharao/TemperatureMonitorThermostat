import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for NaiveTemperatureMonitor implementation.
 */
public class NaiveTemperatureMonitorTest {

  private TemperatureMonitor naiveTemperatureMonitor;

  private Thermostat t1;

  @Before
  public void setUp() {
    naiveTemperatureMonitor = new NaiveTemperatureMonitor();
    t1 = new SimpleThermostat("2d", 49.054);
  }

  @Test
  public void add() {
    Thermostat t2 = new SimpleThermostat("2D", 49.054);
    naiveTemperatureMonitor.add(t1);
    naiveTemperatureMonitor.add(t2);
    assertEquals(2, naiveTemperatureMonitor.getNumberOfThermostats());
  }

  @Test
  public void remove() {
    Thermostat t0 = new SimpleThermostat("2D", 49.054);
    Thermostat t2 = new SimpleThermostat("2D", 49.054);
    naiveTemperatureMonitor.add(t0);
    naiveTemperatureMonitor.add(t2);
    assertEquals(2, naiveTemperatureMonitor.getNumberOfThermostats());
    naiveTemperatureMonitor.remove(t0);
    assertEquals(1, naiveTemperatureMonitor.getNumberOfThermostats());
    naiveTemperatureMonitor.remove(t2);
    assertEquals(0, naiveTemperatureMonitor.getNumberOfThermostats());
  }

  @Test
  public void getNumberOfThermostats() {
    naiveTemperatureMonitor.add(t1);
    assertEquals(1, naiveTemperatureMonitor.getNumberOfThermostats());
  }

  @Test
  public void tooMuchHeatingTrue() {
    naiveTemperatureMonitor.add(new SimpleThermostat("2d", 49.4));
    naiveTemperatureMonitor.add(new SimpleThermostat("2d", 30.4));
    naiveTemperatureMonitor.add(new SimpleThermostat("2D", 49.4));
    assertTrue(naiveTemperatureMonitor.tooMuchHeating());
  }

  @Test
  public void tooMuchHeatingFalse() {
    naiveTemperatureMonitor.add(new SimpleThermostat("2d", 49.4));
    naiveTemperatureMonitor.add(new SimpleThermostat("2d", 49.4));
    naiveTemperatureMonitor.add(new SimpleThermostat("2D", 20.4));
    assertFalse(naiveTemperatureMonitor.tooMuchHeating());
  }
}