package registration;

/**
 * Create a BlueJurisdiction class.
 */
public class BlueJurisdiction implements IJurisdiction {
  private static final double PERCENTAGE = 0.03;

  @Override
  public double exciseTax(IVehicle vehicle) {
    double result = vehicle.getPurchasePrice() * PERCENTAGE;
    if (vehicle.getProductionYear() < 2000) {
      int additionPrice = 99;
      result = result + additionPrice;
    }
    return result;
  }

  @Override
  public String toString() {
    return "Blue Jurisdiction";
  }
}
