package registration;

/**
 * Create an enum class that list all type of vehicles.
 */
public enum VehicleType { Motorcycle(2), Auto(5), Boat(10);

  private final int maxPassenger;
  VehicleType(int maxPassenger) {
    this.maxPassenger = maxPassenger;
  }

  /**
   * Method that will return the maximum number of Passenger.
   */
  public int getMaxPassenger() {
    return maxPassenger;
  }

  /**
   * Method that use String kind to return whether there are that type of vehicles in enum or not.
   */
  public static VehicleType findVehicleType(String kind) {
    VehicleType vehicleKind = null;
    for (VehicleType type : VehicleType.values()) {
      if (type.name().equalsIgnoreCase(kind)) {
        vehicleKind = type;
        break;
      }
    }
    return vehicleKind;
  }
}
