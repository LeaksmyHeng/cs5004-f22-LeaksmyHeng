package registration;

import java.util.Objects;

/**
 * Create a public vehicle class that implement everything in the IVehicle.
 */
public class Vehicle implements IVehicle {
  private final VehicleType type;
  private final String make;
  private final int productionYear;
  private final double purchasePrice;

  /**
   * Create a constructor for all vehicle types.
   */
  public Vehicle(VehicleType type, String make, int productionYear, double purchasePrice)
          throws IllegalArgumentException {
    this.type = type;
    this.make = make;
    this.productionYear = productionYear;
    this.purchasePrice = purchasePrice;

    if (make == null || make.equals("")) {
      throw new IllegalArgumentException("Make of vehicles cannot be null.");
    }
    if (productionYear < 1900 || productionYear > 2023) {
      throw new IllegalArgumentException("Production year are in between 1900 and 2023");
    }
    if (purchasePrice < 0.0) {
      throw new IllegalArgumentException("Purchased price cannot be negative");
    }
  }

  /**
   * Create a getMake method for the vehicles.
   */
  public String getMake() {
    return make;
  }

  /**
   * Create a getProductionYear method.
   */
  public int getProductionYear() {
    return productionYear;
  }

  /**
   * Create a getPurchasePrice method.
   */
  public double getPurchasePrice() {
    return purchasePrice;
  }

  /**
   * Get maxPassenger.
   */
  public int getMaxPassenger() {
    return type.getMaxPassenger();
  }

  /**
   * Create the override for equals method for Vehicle class.
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    else if (this.getClass() == other.getClass()) {
      Vehicle o = (Vehicle) other;
      return Objects.equals(this.type, o.type)
              && Objects.equals(this.make, o.make)
              && this.productionYear == o.productionYear
              && this.purchasePrice == o.purchasePrice;
    }
    return false;
  }
}
