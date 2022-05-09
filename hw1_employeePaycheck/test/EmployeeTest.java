import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * This is the test class for the employee class.
 */
public class EmployeeTest {
  private Employee leaksmy;
  private Employee daniel;
  private Employee peter;
  private Employee amish;
  private Employee mark;

  /**
   * Setting up the Employee test.
   */
  @Before
  public void setUp() {
    leaksmy = new Employee("Leaksmy Heng", "EM001", 32.6);
    daniel = new Employee("Daniel Kelley", "EM002", 30.3);
    peter = new Employee("Peter KitlinSki", "EM003", 52.9);
    amish = new Employee("Amish Scott" , "EM004", 31.7);
    mark = new Employee("Mark Kelley", "MA005", 62.9);
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
    leaksmyAddHoursWorked = leaksmy.addHoursWorked(-26.0);
    double danielAddHoursWorked = daniel.addHoursWorked(20.0);
    danielAddHoursWorked = daniel.addHoursWorked(-20.5);
    double peterAddHoursWorked = peter.addHoursWorked(35.5);
    assertEquals(10.0f, leaksmyAddHoursWorked, 0.01);
    assertEquals(0.0f, danielAddHoursWorked, 0.01);
    assertEquals(35.5f, peterAddHoursWorked, 0.01);
  }

  /**
   * Test resetting the hours.
   */
  @Test
  public void testResetHoursWorked() {
    double leaksmyAddHoursWorked = leaksmy.addHoursWorked(36.0);
    leaksmyAddHoursWorked = leaksmy.addHoursWorked(-26.0);
    double danielAddHoursWorked = daniel.addHoursWorked(20.0);
    danielAddHoursWorked = daniel.addHoursWorked(-20.5);
    double peterAddHoursWorked = peter.addHoursWorked(35.5);
    double amishAddHoursWorked = amish.addHoursWorked(100000.4);
    assertEquals(0.0f, leaksmy.resetHoursWorked(), 0.01);
    assertEquals(0.0f, amish.resetHoursWorked(), 0.01);
    assertEquals(0.0f, daniel.resetHoursWorked(), 0.01);
    assertEquals(0.0f, mark.resetHoursWorked(), 0.01);
  }

  /**
   * Testing getHourWorks by creating 3 scenarios:
   * Adding and deducting the hours but still have it greater than 0
   * Adding and deducting the hours but have it less than 0
   * normal scenario where the hour is greater than 0.
   * */
  @Test
  public void testGetHourWorks() {
    double leaksmyAddHoursWorked = leaksmy.addHoursWorked(36.0);
    leaksmyAddHoursWorked = leaksmy.addHoursWorked(26.2);
    double danielAddHoursWorked = daniel.addHoursWorked(20.0);
    danielAddHoursWorked = daniel.addHoursWorked(-21.0);
    double peterAddHoursWorked = peter.addHoursWorked(35.5);
    double markAddHoursWorked = mark.addHoursWorked(-24.5);
    double amishAddHoursWorked = amish.addHoursWorked(100.5);
    assertEquals(62.2f, leaksmy.getHoursWorked(), 0.01);
    assertEquals(0.0f, daniel.getHoursWorked(), 0.01);
    assertEquals(35.5f, peter.getHoursWorked(), 0.01);
    assertEquals(0.0f, mark.getHoursWorked(), 0.01);
    assertEquals(100.5f, amish.getHoursWorked(), 0.01);
  }

  /**
   * Test getWeeklyCheck.
   */
  @Test
  public void testGetWeeklyCheck() {
    double leaksmyAddHoursWorked = leaksmy.addHoursWorked(36.0);
    double peterAddHoursWorked = peter.addHoursWorked(0.0);
    double markAddHoursWorked = mark.addHoursWorked(-24.5);
    String expectedLeaksmy = "Payment after taxes: $ 997.56";
    String expectedMark = "Payment after taxes: $ 0.00";
    String expectedPeter = "Payment after taxes: $ 0.00";
    assertEquals(expectedLeaksmy, leaksmy.getWeeklyCheck().toString());
    assertEquals(expectedPeter, peter.getWeeklyCheck().toString());
    assertEquals(expectedMark, mark.getWeeklyCheck().toString());
  }

  /**
   * Test toString method for Employee class.
   */
  @Test
  public void testToString() {
    double leaksmyAddHoursWorked = leaksmy.addHoursWorked(36.0);
    double markAddHoursWorked = mark.addHoursWorked(-24.5);
    double amishAddHoursWorked = amish.addHoursWorked(2.0);
    String expectedLeaksmy = "Name: Leaksmy Heng\nID: EM001\nPayment after taxes: $ 997.56";
    String expectedMark = "Name: Mark Kelley\nID: MA005\nPayment after taxes: $ 0.00";
    String expectedAmish = "Name: Amish Scott\nID: EM004\nPayment after taxes: $ 57.06";
    assertEquals(expectedLeaksmy, leaksmy.toString());
    assertEquals(expectedAmish, amish.toString());
    assertEquals(expectedMark, mark.toString());
  }
}
