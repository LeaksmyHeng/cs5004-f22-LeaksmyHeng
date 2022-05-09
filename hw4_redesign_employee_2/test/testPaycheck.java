import static org.junit.Assert.assertEquals;

import employee.HourlyPaycheck;
import employee.SalariedPaycheck;
import org.junit.Before;
import org.junit.Test;

/**
 * This is a test for both Hourly and Salary Paycheck class.
 */
public class testPaycheck {
  private SalariedPaycheck leaksmy;
  private SalariedPaycheck daniel;
  private SalariedPaycheck peter;
  private HourlyPaycheck mark1;
  private HourlyPaycheck leaksmy1;
  private HourlyPaycheck daniel1;
  private HourlyPaycheck peter1;

  /**
   * Setting up the Salaried and Hourly paycheck class.
   */
  @Before
  public void setUp() {
    leaksmy = new SalariedPaycheck(89000.00, 2);
    daniel = new SalariedPaycheck(79255.25, 1);
    peter = new SalariedPaycheck(96250.25, 4);
    leaksmy1 = new HourlyPaycheck(34.2, 50);
    daniel1 = new HourlyPaycheck(35.4, 42);
    peter1 = new HourlyPaycheck(42.9, 39);
    mark1 = new HourlyPaycheck(50, 2);
  }

  /**
   * Create the Illegal argument test.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalpayRatePayIntervalHoursWorked() {
    SalariedPaycheck illegal1 = new SalariedPaycheck(-0.01, 1);
    SalariedPaycheck illegal2 = new SalariedPaycheck(-1.0, 1);
    HourlyPaycheck illegal3 = new HourlyPaycheck(-3, 40.00);
    HourlyPaycheck illegal4 = new HourlyPaycheck(10.25, -4.25);
    SalariedPaycheck illegal5 = new SalariedPaycheck(125000.00, 5);
  }

  /**
   * Creating test for getting total pay.
   */
  @Test
  public void testGetTotalPay() {
    assertEquals(1881.0f, leaksmy1.getTotalPay(), 0.01);
    assertEquals(1673.1f, peter1.getTotalPay(), 0.01);
    assertEquals(1522.2f, daniel1.getTotalPay(), 0.01);
  }

  /**
   * Creating test for getPayAfterTaxes.
   */
  @Test
  public void testGetPayAfterTaxes() {
    assertEquals(1598.85f, leaksmy1.getPayAfterTaxes(), 0.01);
    assertEquals(1422.135f, peter1.getPayAfterTaxes(), 0.01);
    assertEquals(1293.87f,daniel1.getPayAfterTaxes(), 0.01);
    assertEquals(90.0f, mark1.getPayAfterTaxes(), 0.01);
  }

  /**
   * Creat toString test for Paycheck class.
   */
  @Test
  public void testToString() {
    String expectedLeaksmy = "Payment after taxes: $ 1598.85";
    String expectedDaniel = "Payment after taxes: $ 1293.87";
    assertEquals(expectedLeaksmy, leaksmy1.toString());
    assertEquals(expectedDaniel, daniel1.toString());
  }

  /**
   * Create the addHoursWorked test.
   */
  @Test
  public void testAddResetGetHoursWorked() {
    double leaksmyAddHoursWorked = leaksmy1.addHoursWorked(36.0);
    leaksmyAddHoursWorked = leaksmy1.addHoursWorked(-26.0);
    double danielAddHoursWorked = daniel1.addHoursWorked(20.0);
    danielAddHoursWorked = daniel1.addHoursWorked(-30.0);
    double peterAddHoursWorked = peter1.addHoursWorked(35.5);
    assertEquals(60.0f, leaksmy1.getHoursWorked(), 0.01);
    assertEquals(32.0f, daniel1.getHoursWorked(), 0.01);
    assertEquals(75.0f, leaksmy1.addHoursWorked(15.00), 0.01);
    assertEquals(47.0f, daniel1.addHoursWorked(15.00), 0.01);
    assertEquals(0.0f, leaksmy1.resetHoursWorked(), 0.01);
    assertEquals(0.0f, daniel1.resetHoursWorked(), 0.01);
    assertEquals(0.0f, mark1.addHoursWorked(-100.00), 0.01);
    assertEquals(0.0f, mark1.resetHoursWorked(), 0.01);
  }

  /**
   * Integrating test for the entire paycheck.
   */
  @Test
  public void testIntegrationHourlyPaycheck() {
    leaksmy1.resetHoursWorked();
    daniel1.resetHoursWorked();
    mark1.resetHoursWorked();
    leaksmy1.addHoursWorked(5.00);
    leaksmy1.addHoursWorked(-10.00);
    leaksmy1.addHoursWorked(-35.00);
    daniel1.addHoursWorked(2.25);
    daniel1.addHoursWorked(10.00);
    daniel1.addHoursWorked(35.25);
    mark1.addHoursWorked(200);
    mark1.addHoursWorked(-100);
    mark1.addHoursWorked(-70.00);
    assertEquals(1500.0f, mark1.getTotalPay(), 0.01);
    assertEquals(1814.25f, daniel1.getTotalPay(), 0.01);
    assertEquals(0.0f, leaksmy1.getTotalPay(), 0.01);
    assertEquals(1275.0f, mark1.getPayAfterTaxes(), 0.01);
    assertEquals(1542.11f, daniel1.getPayAfterTaxes(), 0.01);
    leaksmy1.addHoursWorked(10.00);
    assertEquals(342.0f, leaksmy1.getTotalPay(), 0.01);
    assertEquals(307.8f, leaksmy1.getPayAfterTaxes(), 0.01);
    assertEquals(34.2f, leaksmy1.getPayRate(), 0.01);
  }

  /**
   * Test get pay rate from the Salaried Employee.
   */
  @Test
  public void testGetPayRate() {
    assertEquals(89000.0f, leaksmy.getPayRate(), 0.01);
    assertEquals(79255.25f, daniel.getPayRate(), 0.01);
    assertEquals(96250.25f, peter.getPayRate(), 0.01);
  }

  /**
   * Test get total pay for salaried employee.
   */
  @Test
  public void testGetTotalPaySalaried() {
    assertEquals(3423.07f, leaksmy.getTotalPay(), 0.01);
    assertEquals(1524.13f, daniel.getTotalPay(), 0.01);
    assertEquals(7403.86f, peter.getTotalPay(), 0.01);
    assertEquals(2909.61f, leaksmy.getPayAfterTaxes(), 0.01);
    assertEquals(1295.51f, daniel.getPayAfterTaxes(), 0.01);
    assertEquals(6293.28f, peter.getPayAfterTaxes(), 0.01);
  }
}
