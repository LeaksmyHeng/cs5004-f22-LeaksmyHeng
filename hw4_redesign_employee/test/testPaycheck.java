import org.junit.Before;
import org.junit.Test;

import employee.HourlyPaycheck;

import static org.junit.Assert.assertEquals;

/**
 * This is a test for Paycheck class.
 */

public class testPaycheck {
  private HourlyPaycheck leaksmy;
  private HourlyPaycheck daniel;
  private HourlyPaycheck peter;
  private HourlyPaycheck mark;

  /**
   * Setting up the Paycheck test.
   */
  @Before
  public void setUp() {
    leaksmy = new HourlyPaycheck(34.2, 50);
    daniel = new HourlyPaycheck(35.4, 42);
    peter = new HourlyPaycheck(42.9, 39);
    mark = new HourlyPaycheck(50, 2);
  }

  /**
   * Testing addHoursWorked by creating 3 scenarios:
   * Adding and deducting the hours but still have it greater than 0
   * Adding and deducting the hours but have it less than 0
   * normal scenario where the hour is greater than 0.
   */
  @Test
  public void testAddHoursWorked() {
    double leaksmyAddHoursWorked = leaksmy.addHoursWorked(36.0);
    double danielAddHoursWorked = daniel.addHoursWorked(20.0);
    double peterAddHoursWorked = peter.addHoursWorked(35.5);
    double markAddHoursWorked = mark.addHoursWorked(-7);
    assertEquals(86.0f, leaksmyAddHoursWorked, 0.01);
    assertEquals(62.0f, danielAddHoursWorked, 0.01);
    assertEquals(74.5f, peterAddHoursWorked, 0.01);
    assertEquals(0.0f, markAddHoursWorked, 0.01);

    leaksmy.resetHoursWorked();
    peter.resetHoursWorked();
    daniel.resetHoursWorked();
    assertEquals(0.0f, leaksmy.getHoursWorked(), 0.01);
    assertEquals(0.0f, peter.getHoursWorked(), 0.01);
    assertEquals(0.0f, daniel.getHoursWorked(), 0.01);

    leaksmy.addHoursWorked(1.0);
    leaksmy.addHoursWorked(2.0);
    leaksmy.addHoursWorked(3.0);
    assertEquals(6.0f, leaksmy.getHoursWorked(), 0.01);
  }

}
