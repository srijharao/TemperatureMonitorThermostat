import java.util.Objects;

/**
 * Class SimpleThermostat is the implementation of Thermostat interface.
 */
public class SimpleThermostat implements Thermostat {

  private final String iD;

  private double currentTemperature;

  /**
   * Constructor for class that accepts temperature in Celsius.
   *
   * @param iD                    is the unique id of thermostat
   * @param initialSetTemperature is the initial temperature
   * @throws IllegalArgumentException when iD is null or temperature > 50 Celsius
   */
  public SimpleThermostat(String iD, double initialSetTemperature) throws IllegalArgumentException {

    if (iD.isEmpty() || initialSetTemperature > 50) {
      throw new IllegalArgumentException("Initial temperature cannot be > 50");
    }
    this.iD = iD;
    this.currentTemperature = initialSetTemperature;
  }

  /**
   * Retrieves unique ID of thermostat.
   *
   * @return unique ID
   */
  @Override
  public String getID() {
    return this.iD;
  }

  /**
   * get the temperature in degrees Kelvin that the thermostat is set to.
   *
   * @return temperature in degrees Kelvin that the thermostat is set to
   */
  @Override
  public double getSetTemperature() {
    return this.currentTemperature + 273.15;
  }

  /**
   * increases the set temperature for the thermostat by 0.1.
   */
  @Override
  public void increaseSetTemperature() {
    if (this.currentTemperature + 0.1 < 50) {
      this.currentTemperature = this.currentTemperature + 0.1;
    }

  }

  /**
   * decreases the set temperature for the thermostat by 0.1.
   */
  @Override
  public void decreaseSetTemperature() {
    this.currentTemperature = currentTemperature - 0.1;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o) { //backward compatibility with default equals
      return true;
    }

    if (!(o instanceof Thermostat)) { // If o isn't the right class then it can't be equal:
      return false;
    }

    Thermostat that = (Thermostat) o; // The successful instanceof check means our cast will succeed

    //Boolean isEq = Math.abs(this.getSetTemperature() - that.getSetTemperature()) <= 0.005;
    //return this.getID().equals(that.getID()) && isEq;
    double firstTemperature = roundToDecimals(this.getSetTemperature());
    double secondTemperature = roundToDecimals(that.getSetTemperature());
    Boolean isTemp = firstTemperature == secondTemperature;
    return this.getID().equals(that.getID()) && isTemp;

  }

  private double roundToDecimals(double val) {
    return Math.round(val * 100.0) / 100.0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.iD, roundToDecimals(this.getSetTemperature()));
  }
}
