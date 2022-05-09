package registration;

/**
 * Create an interface for Vehicle class.
 */
public interface IVehicle {

  /**
   * Get the name of the company that produce the vehicles.
   */
  String getMake();

  /**
   * Get the production year of the vehicles.
   */
  int getProductionYear();

  /**
   * Get the purchase price of the vehicles.
   */
  double getPurchasePrice();

  /**
   * Get the maxPassenger.
   */
  int getMaxPassenger();
}
