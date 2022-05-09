import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import employee.Employee;
import employee.HourlyPaycheck;
import employee.IPaycheck;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test for Employee class.
 */
public class testEmployee {
  private Employee leaksmy;
  private Employee daniel;
  private Employee peter;
  private Employee mark;
  private Employee rana;
  private Employee darny;

  /**
   * Setting up the Employee class.
   */
  @Before
  public void setUp() {
    leaksmy = new Employee("Smy", "E0001", 89000.00, 2, false);
    daniel = new Employee("Dan", "E0002", 79255.25, 4, false);
    peter = new Employee("Peter", "E0003", 96250.25, 1, false);
    mark = new Employee("Mark", "M0001", 125250.25, 2, true);
    rana = new Employee("Rana", "E0004", 34.2, 42.00);
    darny = new Employee("Darny", "E0005", 35.4, 39.00);
  }

  /**
   * Test isManager for Salaried Employee.
   */
  @Test
  public void testManager() {
    assertTrue(mark.isManager());
    assertFalse(leaksmy.isManager());
    assertFalse(peter.isManager());
    assertFalse(daniel.isManager());
    assertFalse(darny.isManager());
    assertFalse(rana.isManager());
  }

  /**
   * Test get paycheck for Salaried Employee.
   */
  @Test
  public void testGetPaycheckGetPayAfterTax() {
    // Get pay before tax
    assertEquals(3423.07f, leaksmy.getPaycheck().getTotalPay(), 0.01);
    assertEquals(6096.55f, daniel.getPaycheck().getTotalPay(), 0.01);
    assertEquals(1850.966f, peter.getPaycheck().getTotalPay(), 0.01);
    assertEquals(4817.31f, mark.getPaycheck().getTotalPay(), 0.01);
    assertEquals(1470.6f, rana.getPaycheck().getTotalPay(), 0.01);
    assertEquals(1380.6f, darny.getPaycheck().getTotalPay(), 0.01);
    // Get Pay after tax
    assertEquals(2909.61f, leaksmy.getPaycheck().getPayAfterTaxes(), 0.01);
    assertEquals(5182.07f, daniel.getPaycheck().getPayAfterTaxes(), 0.01);
    assertEquals(1573.32f, peter.getPaycheck().getPayAfterTaxes(), 0.01);
    assertEquals(4094.72f, mark.getPaycheck().getPayAfterTaxes(), 0.01);
    assertEquals(1250.0f, rana.getPaycheck().getPayAfterTaxes(), 0.01);
    assertEquals(1173.51f, darny.getPaycheck().getPayAfterTaxes(), 0.01);
  }

  /**
   * Test toString method.
   */
  @Test
  public void testToString() {
    String expectedSmy = "Name: Smy\nID: E0001\nPayment after taxes: $ 2909.62";
    String expectedMark = "Name: Mark\nID: M0001\nPayment after taxes: $ 4094.72";
    String expectedRana = "Name: Rana\nID: E0004\nPayment after taxes: $ 1250.01";
    String expectedDarny = "Name: Darny\nID: E0005\nPayment after taxes: $ 1173.51";
    assertEquals(expectedSmy + expectedMark, leaksmy.toString() + mark.toString());
    assertEquals(expectedRana + expectedDarny, rana.toString() + darny.toString());
  }

  /**
   * Integrating test between Employee and Paycheck.
   */
  @Test
  public void testIntegration() {
    IPaycheck paycheckDarny = darny.getPaycheck();
    ((HourlyPaycheck) paycheckDarny).resetHoursWorked();
    ((HourlyPaycheck) paycheckDarny).addHoursWorked(-10.00);
    ((HourlyPaycheck) paycheckDarny).addHoursWorked(10.00);
    assertEquals(35.4f, paycheckDarny.getPayRate(), 0.01);
    assertEquals(354.00f, paycheckDarny.getTotalPay(), 0.01);
    assertEquals(318.6f, paycheckDarny.getPayAfterTaxes(), 0.01);
    assertFalse(darny.isManager());
    ((HourlyPaycheck) paycheckDarny).addHoursWorked(2.25);
    ((HourlyPaycheck) paycheckDarny).addHoursWorked(5.50);
    ((HourlyPaycheck) paycheckDarny).addHoursWorked(3.75);
    ((HourlyPaycheck) paycheckDarny).addHoursWorked(-1.25);
    assertEquals(20.25f, ((HourlyPaycheck) paycheckDarny).getHoursWorked(), 0.01);
    assertEquals(30.50f, ((HourlyPaycheck) paycheckDarny).addHoursWorked(10.25), 0.01);
    assertEquals(917.74f, paycheckDarny.getPayAfterTaxes(), 0.01);
    String expectedPaycheck = "Payment after taxes: $ 917.75";
    String expectedPaycheckDarny = "Name: Darny\nID: E0005\nPayment after taxes: $ 917.75";
    assertEquals(expectedPaycheck, paycheckDarny.toString());
    assertEquals(expectedPaycheckDarny, darny.toString());
  }

  /**
   * Test Illegal name and id.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalNameID() {
    Employee smy1 = new Employee("", "E0001", 8.0, 2, false);
    Employee smy2 = new Employee("hello", "", 8.0, 1, false);
    Employee smy3 = new Employee(null, "", 18.0, 15.25);
    Employee smy4 = new Employee("hi", null, 25.0, 19.75);
  }

  /**
   * Test Illegal name and id.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testIllegalPayRatePayIntervalHoursWorked() {
    Employee smy1 = new Employee("he", "E0001", -8.0, 2, false);
    Employee smy2 = new Employee("she", "E0001", 25.0, 3, false);
    Employee smy3 = new Employee("hi", "E0001", 18.0, -25.00);
    Employee smy4 = new Employee("hi", null, -100, 29.25);
  }
}
