package registration;

import java.util.List;

/**
 * Interface class for the Registration.
 */
public interface IRegistration {
  /**
   * Get the year that the vehicle is registered.
   */
  public int getRegistrationYear();

  /**
   * Get the year of that the vehicle is produced.
   */
  public int getProductionYear();

  /**
   * Get the Jurisdiction.
   */
  public IJurisdiction getJurisdiction();

  /**
   * Get the list of the owners' name.
   */
  public List<Person> getOwners();

  /**
   * Calculate the maximum number of passengers.
   */
  public int getMaxPassengers();

  /**
   * Calculate the Excise Tax for all type of vehicle.
   */
  public double calculateExciseTax();
}
