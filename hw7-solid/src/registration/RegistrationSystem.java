package registration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Create a public class for Registration System.
 */
public class RegistrationSystem {
  private List<IRegistration> registrationList = new ArrayList<>();
  private static final RegistrationSystem instance = new RegistrationSystem();

  public static RegistrationSystem getInstance() {
    return instance;
  }

  /**
   * Create a vehicle class.
   */
  public IVehicle createVehicle(String kind, String make, int productionYear, double purchasePrice)
          throws  IllegalArgumentException {
    if (kind == null || kind.equals("")) {
      throw new IllegalArgumentException("Kind cannot be null");
    }
    if (VehicleType.findVehicleType(kind) == null) {
      return null;
    }
    else {
      if (make == null || make.equals("")) {
        throw new IllegalArgumentException("Make of vehicles cannot be null.");
      }
      if (productionYear < 1900 || productionYear > 2023) {
        throw new IllegalArgumentException("Production year are in between 1900 and 2023");
      }
      if (purchasePrice < 0.0) {
        throw new IllegalArgumentException("Purchased price in createVehicle cannot be negative");
      }
      return new Vehicle(VehicleType.findVehicleType(kind), make, productionYear, purchasePrice);
    }
  }

  /**
   * Register a vehicle class.
   */
  public void register(IVehicle vehicle, IJurisdiction jurisdiction,
                       int registrationYear, List<Person> owners) {
    IRegistration newAdd = new Registration(owners, jurisdiction, registrationYear, vehicle);
    if (registrationList.size() >= 1) {
      for (IRegistration r : registrationList) {
        if (r.equals(newAdd)) {
          return;
        }
      }
    }
    registrationList.add(new Registration(owners, jurisdiction, registrationYear, vehicle));
  }

  /**
   * reset the system to initial "start state".
   */
  public void reboot() {
    registrationList = new ArrayList<>();
  }

  /**
   * Get all registration class. answer an unmodifiable list.
   */
  public List<IRegistration> getAllRegistrations() {
    registrationList = Collections.unmodifiableList(registrationList);
    return registrationList;
  }

  /**
   * getFilteredList() takes a Predicate IRegistration and returns a sublist
   * that is filtered based on that query.
   */
  public List<IRegistration> getFilteredList(Predicate<IRegistration> query) {
    if (query == null) {
      throw new IllegalArgumentException("Predicate query cannot be null");
    }
    List<IRegistration> registrationQuery =
            registrationList.stream().filter(query).collect(Collectors.toList());
    registrationQuery = Collections.unmodifiableList(registrationQuery);
    return registrationQuery;
  }
}
