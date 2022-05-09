package registration;

/**
 * Create a GreenJurisdiction class.
 */
public class GreenJurisdiction implements IJurisdiction {
  private static final double PERCENTAGE = 0.04;

  @Override
  public double exciseTax(IVehicle vehicle) {
    double carbonPrice = 100.00;
    return vehicle.getPurchasePrice() * PERCENTAGE + carbonPrice * vehicle.getMaxPassenger();
  }

  @Override
  public String toString() {
    return "Green Jurisdiction";
  }
}
