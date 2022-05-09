package registration;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Create a registration class.
 */
public class Registration implements IRegistration {
  private IVehicle vehicle;
  private List<Person> owners;
  private IJurisdiction jurisdiction;
  private int registrationYear;
  private double exciseTax;

  /**
   * Create a constructor for Registration class.
   */
  public Registration(List<Person> owners, IJurisdiction jurisdiction,
                      int registrationYear, IVehicle vehicle) {
    this.owners = owners;
    this.jurisdiction = jurisdiction;
    this.registrationYear = registrationYear;
    this.vehicle = vehicle;
    this.exciseTax = jurisdiction.exciseTax(vehicle);

    // check if jurisdiction & vehicle info is in the requirement or else throw exception
  }

  @Override
  public int getRegistrationYear() {
    return registrationYear;
  }

  @Override
  public int getProductionYear() {
    return vehicle.getProductionYear();
  }

  @Override
  public IJurisdiction getJurisdiction() {
    return this.jurisdiction;
  }

  @Override
  public List<Person> getOwners() {
    return Collections.unmodifiableList(this.owners);
  }

  @Override
  public int getMaxPassengers() {
    return vehicle.getMaxPassenger();
  }

  @Override
  public double calculateExciseTax() {
    return this.exciseTax;
  }

  /**
   * Create an override equals method for Registration.
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (this.getClass() == other.getClass()) {
      Registration o = (Registration) other;
      if (this.vehicle.equals(o.vehicle)) {
        return this.registrationYear == o.registrationYear
                && Objects.equals(this.owners, o.owners);
      }
    }
    return false;
  }
}
