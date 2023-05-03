/**
 * Thermostat interface contains public methods of thermostat.
 */
public interface Thermostat {
  /**
   * Retrieves unique ID of thermostat.
   * @return unique ID
   */
  String getID();

  /**
   * get the temperature in degrees Kelvin that the thermostat is set to.
   * @return temperature in degrees Kelvin that the thermostat is set to
   */
  double getSetTemperature();

  /**
   * increases the set temperature for the thermostat (by an implementation-dependent amount).
   */
  void increaseSetTemperature();

  /**
   *  decreases the set temperature for the thermostat (by an implementation-dependent amount).
   */
  void decreaseSetTemperature();


}
