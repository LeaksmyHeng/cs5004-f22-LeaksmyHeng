package registration;

/**
 * Create a RedJurisdiction class.
 */
public class RedJurisdiction implements IJurisdiction {
  private static final double PERCENTAGE = 0.05;

  @Override
  public double exciseTax(IVehicle vehicle) {
    return vehicle.getPurchasePrice() * PERCENTAGE;
  }

  @Override
  public String toString() {
    return "Red Jurisdiction";
  }
}
