import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import registration.BlueJurisdiction;
import registration.GreenJurisdiction;
import registration.IRegistration;
import registration.IVehicle;
import registration.Person;
import registration.RedJurisdiction;
import registration.Registration;
import registration.RegistrationSystem;

/**
 * Test the registration system.
 */
public class testRegistrationSystem {
  private Person leaksmy;
  private Person daniel;
  private Person joyce;
  Person[] owner1 = {leaksmy, daniel};
  Person[] owner2 = {daniel, joyce};

  /**
   * Create a test for Illegal input on make.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalVehicleMade() {
    RegistrationSystem.getInstance().createVehicle("boat", "",
            2000, 12500);
  }

  /**
   * Create a test for Illegal input on make.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalVehicleMade2() {
    RegistrationSystem.getInstance().createVehicle("boat", null,
            2000, 12500);
  }

  /**
   * Create a test for Illegal input on production year.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalVehicleProductionYear() {
    RegistrationSystem.getInstance().createVehicle("boat", "Yamaha",
            1899, 12500);
  }

  /**
   * Create a test for Illegal input on production year.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalVehicleProductionYear2() {
    RegistrationSystem.getInstance().createVehicle("boat", "Yamaha",
            2025, 12500);
  }

  /**
   * Create a test for Illegal input on purchase price.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalVehiclePurchasePrice() {
    RegistrationSystem.getInstance().createVehicle("boat", "Yamaha",
            2023, -1);
  }

  /**
   * Test Registration class.
   */
  @Test
  public void testRegisterVehicle2() {
    // Test Registering function and getAllRegistrations
    IVehicle vehicle1 = RegistrationSystem.getInstance().createVehicle("boat",
            "Yamaha", 2001, 5999.99);
    IVehicle vehicle2 = RegistrationSystem.getInstance().createVehicle("auto",
            "Toyota", 2011, 12500.00);
    IVehicle vehicle3 = RegistrationSystem.getInstance().createVehicle("motorcycle",
            "BMW", 2021, 2555.55);
    IVehicle vehicle4 = RegistrationSystem.getInstance().createVehicle("motorcycle",
            "BMW", 1999, 2555.55);
    Registration registerVehicle1 = new Registration(Arrays.asList(owner1), new RedJurisdiction(),
            2023, vehicle1);
    Registration registerVehicle2 = new Registration(Arrays.asList(owner2), new BlueJurisdiction(),
            2023, vehicle2);
    Registration registerVehicle4 = new Registration(Arrays.asList(owner1), new GreenJurisdiction(),
            2023, vehicle1);
    assertTrue(registerVehicle1.equals(registerVehicle4));
    assertEquals(registerVehicle2.calculateExciseTax(), 375.00, 0.0f);
    assertEquals(registerVehicle4.calculateExciseTax(), 1239.9996, 0.0f);
    Registration registerVehicle5 = new Registration(Arrays.asList(owner2), new GreenJurisdiction(),
            2024, vehicle1);
    Registration registerVehicle6 = new Registration(Arrays.asList(owner2), new BlueJurisdiction(),
            2024, vehicle1);
    assertEquals(registerVehicle5.getMaxPassengers(), 10);
    assertEquals(registerVehicle6.getRegistrationYear(), 2024);
    assertEquals(registerVehicle6.getProductionYear(), 2001);
    assertEquals(registerVehicle6.getOwners().size(), 2);
  }

  /**
   * Test registering the vehicles and filter function.
   */
  @Test
  public void testRegisterVehicle1() {
    // Test createVehicle
    IVehicle vehicle1 = RegistrationSystem.getInstance().createVehicle("boat",
            "Yamaha", 2000, 5999.99);
    IVehicle vehicle2 = RegistrationSystem.getInstance().createVehicle("auto",
            "Toyota", 2010, 12500.00);
    IVehicle vehicle3 = RegistrationSystem.getInstance().createVehicle("motorcycle",
            "BMW", 2020, 2555.55);
    // Test register vehicle
    RegistrationSystem.getInstance().register(vehicle1, new RedJurisdiction(),
            2023, Arrays.asList(owner1));
    RegistrationSystem.getInstance().register(vehicle2, new BlueJurisdiction(),
            2023, Arrays.asList(owner2));
    RegistrationSystem.getInstance().register(vehicle3, new BlueJurisdiction(),
            2023, Arrays.asList(owner1));
    RegistrationSystem.getInstance().register(vehicle1, new GreenJurisdiction(),
            2023, Arrays.asList(owner1));
    List<IRegistration> filterMaxPassenger = RegistrationSystem.getInstance()
            .getFilteredList(a -> a.getMaxPassengers() >= 5 && a.getProductionYear() > 2005);
    List<IRegistration> filterRegistrationYear = RegistrationSystem.getInstance()
            .getFilteredList(a -> a.getRegistrationYear() > 2022);
    List<IRegistration> filterExciseTax = RegistrationSystem.getInstance()
            .getFilteredList(a -> a.calculateExciseTax() > 200.00);
    assertEquals(filterMaxPassenger.size(), 1);
    assertEquals(filterRegistrationYear.size(), 3);
    assertEquals(filterExciseTax.size(), 2);
    assertEquals(RegistrationSystem.getInstance().getAllRegistrations().size(), 3);
    // Test reboot function
    RegistrationSystem.getInstance().reboot();
    assertEquals(RegistrationSystem.getInstance().getAllRegistrations().size(), 0);
  }
}
