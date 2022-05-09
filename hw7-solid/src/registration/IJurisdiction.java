package registration;

/**
 * The interface for Jurisdiction with its default exciseTax.
 */
public interface  IJurisdiction {

  /**
   * Default exciseTax of 0%.
   */
  default double exciseTax(IVehicle vehicle) {
    return 0.0;
  }
}
